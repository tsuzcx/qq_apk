package com.google.android.exoplayer2.text.cea;

import android.util.Log;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Cea708Decoder
  extends CeaDecoder
{
  private static final int CC_VALID_FLAG = 4;
  private static final int CHARACTER_BIG_CARONS = 42;
  private static final int CHARACTER_BIG_OE = 44;
  private static final int CHARACTER_BOLD_BULLET = 53;
  private static final int CHARACTER_CLOSE_DOUBLE_QUOTE = 52;
  private static final int CHARACTER_CLOSE_SINGLE_QUOTE = 50;
  private static final int CHARACTER_DIAERESIS_Y = 63;
  private static final int CHARACTER_ELLIPSIS = 37;
  private static final int CHARACTER_FIVE_EIGHTHS = 120;
  private static final int CHARACTER_HORIZONTAL_BORDER = 125;
  private static final int CHARACTER_LOWER_LEFT_BORDER = 124;
  private static final int CHARACTER_LOWER_RIGHT_BORDER = 126;
  private static final int CHARACTER_MN = 127;
  private static final int CHARACTER_NBTSP = 33;
  private static final int CHARACTER_ONE_EIGHTH = 118;
  private static final int CHARACTER_OPEN_DOUBLE_QUOTE = 51;
  private static final int CHARACTER_OPEN_SINGLE_QUOTE = 49;
  private static final int CHARACTER_SEVEN_EIGHTHS = 121;
  private static final int CHARACTER_SM = 61;
  private static final int CHARACTER_SMALL_CARONS = 58;
  private static final int CHARACTER_SMALL_OE = 60;
  private static final int CHARACTER_SOLID_BLOCK = 48;
  private static final int CHARACTER_THREE_EIGHTHS = 119;
  private static final int CHARACTER_TM = 57;
  private static final int CHARACTER_TSP = 32;
  private static final int CHARACTER_UPPER_LEFT_BORDER = 127;
  private static final int CHARACTER_UPPER_RIGHT_BORDER = 123;
  private static final int CHARACTER_VERTICAL_BORDER = 122;
  private static final int COMMAND_BS = 8;
  private static final int COMMAND_CLW = 136;
  private static final int COMMAND_CR = 13;
  private static final int COMMAND_CW0 = 128;
  private static final int COMMAND_CW1 = 129;
  private static final int COMMAND_CW2 = 130;
  private static final int COMMAND_CW3 = 131;
  private static final int COMMAND_CW4 = 132;
  private static final int COMMAND_CW5 = 133;
  private static final int COMMAND_CW6 = 134;
  private static final int COMMAND_CW7 = 135;
  private static final int COMMAND_DF0 = 152;
  private static final int COMMAND_DF1 = 153;
  private static final int COMMAND_DF2 = 154;
  private static final int COMMAND_DF3 = 155;
  private static final int COMMAND_DF4 = 156;
  private static final int COMMAND_DF5 = 157;
  private static final int COMMAND_DF6 = 158;
  private static final int COMMAND_DF7 = 159;
  private static final int COMMAND_DLC = 142;
  private static final int COMMAND_DLW = 140;
  private static final int COMMAND_DLY = 141;
  private static final int COMMAND_DSW = 137;
  private static final int COMMAND_ETX = 3;
  private static final int COMMAND_EXT1 = 16;
  private static final int COMMAND_EXT1_END = 23;
  private static final int COMMAND_EXT1_START = 17;
  private static final int COMMAND_FF = 12;
  private static final int COMMAND_HCR = 14;
  private static final int COMMAND_HDW = 138;
  private static final int COMMAND_NUL = 0;
  private static final int COMMAND_P16_END = 31;
  private static final int COMMAND_P16_START = 24;
  private static final int COMMAND_RST = 143;
  private static final int COMMAND_SPA = 144;
  private static final int COMMAND_SPC = 145;
  private static final int COMMAND_SPL = 146;
  private static final int COMMAND_SWA = 151;
  private static final int COMMAND_TGW = 139;
  private static final int DTVCC_PACKET_DATA = 2;
  private static final int DTVCC_PACKET_START = 3;
  private static final int GROUP_C0_END = 31;
  private static final int GROUP_C1_END = 159;
  private static final int GROUP_C2_END = 31;
  private static final int GROUP_C3_END = 159;
  private static final int GROUP_G0_END = 127;
  private static final int GROUP_G1_END = 255;
  private static final int GROUP_G2_END = 127;
  private static final int GROUP_G3_END = 255;
  private static final int NUM_WINDOWS = 8;
  private static final String TAG = "Cea708Decoder";
  private final ParsableByteArray ccData = new ParsableByteArray();
  private final Cea708Decoder.CueBuilder[] cueBuilders;
  private List<Cue> cues;
  private Cea708Decoder.CueBuilder currentCueBuilder;
  private Cea708Decoder.DtvCcPacket currentDtvCcPacket;
  private int currentWindow;
  private List<Cue> lastCues;
  private final int selectedServiceNumber;
  private final ParsableBitArray serviceBlockPacket = new ParsableBitArray();
  
  public Cea708Decoder(int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.selectedServiceNumber = i;
    this.cueBuilders = new Cea708Decoder.CueBuilder[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.cueBuilders[paramInt] = new Cea708Decoder.CueBuilder();
      paramInt += 1;
    }
    this.currentCueBuilder = this.cueBuilders[0];
    resetCueBuilders();
  }
  
  private void finalizeCurrentPacket()
  {
    if (this.currentDtvCcPacket == null) {
      return;
    }
    processCurrentPacket();
    this.currentDtvCcPacket = null;
  }
  
  private List<Cue> getDisplayCues()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.cueBuilders[i].isEmpty()) && (this.cueBuilders[i].isVisible())) {
        localArrayList.add(this.cueBuilders[i].build());
      }
      i += 1;
    }
    Collections.sort(localArrayList);
    return Collections.unmodifiableList(localArrayList);
  }
  
  private void handleC0Command(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 3) {
        if (paramInt == 8) {}
      }
      switch (paramInt)
      {
      default: 
        if ((paramInt >= 17) && (paramInt <= 23))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Currently unsupported COMMAND_EXT1 Command: ");
          localStringBuilder.append(paramInt);
          Log.w("Cea708Decoder", localStringBuilder.toString());
          this.serviceBlockPacket.skipBits(8);
          return;
        }
        if ((paramInt >= 24) && (paramInt <= 31))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Currently unsupported COMMAND_P16 Command: ");
          localStringBuilder.append(paramInt);
          Log.w("Cea708Decoder", localStringBuilder.toString());
          this.serviceBlockPacket.skipBits(16);
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Invalid C0 command: ");
        localStringBuilder.append(paramInt);
        Log.w("Cea708Decoder", localStringBuilder.toString());
        return;
      case 13: 
        this.currentCueBuilder.append('\n');
        return;
      case 12: 
        resetCueBuilders();
        return;
        this.currentCueBuilder.backspace();
        return;
        this.cues = getDisplayCues();
      }
    }
  }
  
  private void handleC1Command(int paramInt)
  {
    int j = 1;
    int k = 1;
    int i = 1;
    Object localObject;
    switch (paramInt)
    {
    case 147: 
    case 148: 
    case 149: 
    case 150: 
    default: 
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid C1 command: ");
      ((StringBuilder)localObject).append(paramInt);
      Log.w("Cea708Decoder", ((StringBuilder)localObject).toString());
      return;
    case 152: 
    case 153: 
    case 154: 
    case 155: 
    case 156: 
    case 157: 
    case 158: 
    case 159: 
      paramInt -= 152;
      handleDefineWindow(paramInt);
      if (this.currentWindow != paramInt)
      {
        this.currentWindow = paramInt;
        this.currentCueBuilder = this.cueBuilders[paramInt];
        return;
      }
      break;
    case 151: 
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(32);
        return;
      }
      handleSetWindowAttributes();
      return;
    case 146: 
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(16);
        return;
      }
      handleSetPenLocation();
      return;
    case 145: 
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(24);
        return;
      }
      handleSetPenColor();
      return;
    case 144: 
      if (!this.currentCueBuilder.isDefined())
      {
        this.serviceBlockPacket.skipBits(16);
        return;
      }
      handleSetPenAttributes();
      return;
    case 143: 
      resetCueBuilders();
      return;
    case 141: 
      this.serviceBlockPacket.skipBits(8);
      return;
    case 140: 
    case 139: 
    case 138: 
    case 137: 
    case 136: 
    case 128: 
    case 129: 
    case 130: 
    case 131: 
    case 132: 
    case 133: 
    case 134: 
    case 135: 
      while (i <= 8)
      {
        if (this.serviceBlockPacket.readBit()) {
          this.cueBuilders[(8 - i)].reset();
        }
        i += 1;
        continue;
        paramInt = 1;
        while (paramInt <= 8)
        {
          if (this.serviceBlockPacket.readBit())
          {
            localObject = this.cueBuilders[(8 - paramInt)];
            ((Cea708Decoder.CueBuilder)localObject).setVisibility(((Cea708Decoder.CueBuilder)localObject).isVisible() ^ true);
          }
          paramInt += 1;
          continue;
          while (j <= 8)
          {
            if (this.serviceBlockPacket.readBit()) {
              this.cueBuilders[(8 - j)].setVisibility(false);
            }
            j += 1;
            continue;
            paramInt = 1;
            while (paramInt <= 8)
            {
              if (this.serviceBlockPacket.readBit()) {
                this.cueBuilders[(8 - paramInt)].setVisibility(true);
              }
              paramInt += 1;
              continue;
              while (k <= 8)
              {
                if (this.serviceBlockPacket.readBit()) {
                  this.cueBuilders[(8 - k)].clear();
                }
                k += 1;
                continue;
                paramInt -= 128;
                if (this.currentWindow != paramInt)
                {
                  this.currentWindow = paramInt;
                  this.currentCueBuilder = this.cueBuilders[paramInt];
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void handleC2Command(int paramInt)
  {
    if (paramInt <= 7) {
      return;
    }
    if (paramInt <= 15)
    {
      this.serviceBlockPacket.skipBits(8);
      return;
    }
    if (paramInt <= 23)
    {
      this.serviceBlockPacket.skipBits(16);
      return;
    }
    if (paramInt <= 31) {
      this.serviceBlockPacket.skipBits(24);
    }
  }
  
  private void handleC3Command(int paramInt)
  {
    if (paramInt <= 135)
    {
      this.serviceBlockPacket.skipBits(32);
      return;
    }
    if (paramInt <= 143)
    {
      this.serviceBlockPacket.skipBits(40);
      return;
    }
    if (paramInt <= 159)
    {
      this.serviceBlockPacket.skipBits(2);
      paramInt = this.serviceBlockPacket.readBits(6);
      this.serviceBlockPacket.skipBits(paramInt * 8);
    }
  }
  
  private void handleDefineWindow(int paramInt)
  {
    Cea708Decoder.CueBuilder localCueBuilder = this.cueBuilders[paramInt];
    this.serviceBlockPacket.skipBits(2);
    boolean bool1 = this.serviceBlockPacket.readBit();
    boolean bool2 = this.serviceBlockPacket.readBit();
    boolean bool3 = this.serviceBlockPacket.readBit();
    paramInt = this.serviceBlockPacket.readBits(3);
    boolean bool4 = this.serviceBlockPacket.readBit();
    int i = this.serviceBlockPacket.readBits(7);
    int j = this.serviceBlockPacket.readBits(8);
    int k = this.serviceBlockPacket.readBits(4);
    int m = this.serviceBlockPacket.readBits(4);
    this.serviceBlockPacket.skipBits(2);
    int n = this.serviceBlockPacket.readBits(6);
    this.serviceBlockPacket.skipBits(2);
    localCueBuilder.defineWindow(bool1, bool2, bool3, paramInt, bool4, i, j, m, n, k, this.serviceBlockPacket.readBits(3), this.serviceBlockPacket.readBits(3));
  }
  
  private void handleG0Character(int paramInt)
  {
    if (paramInt == 127)
    {
      this.currentCueBuilder.append('♫');
      return;
    }
    this.currentCueBuilder.append((char)(paramInt & 0xFF));
  }
  
  private void handleG1Character(int paramInt)
  {
    this.currentCueBuilder.append((char)(paramInt & 0xFF));
  }
  
  private void handleG2Character(int paramInt)
  {
    if (paramInt != 32)
    {
      if (paramInt != 33)
      {
        if (paramInt != 37)
        {
          if (paramInt != 42)
          {
            if (paramInt != 44)
            {
              if (paramInt != 63)
              {
                if (paramInt != 57)
                {
                  if (paramInt != 58)
                  {
                    if (paramInt != 60)
                    {
                      if (paramInt != 61)
                      {
                        switch (paramInt)
                        {
                        default: 
                          switch (paramInt)
                          {
                          default: 
                            StringBuilder localStringBuilder = new StringBuilder();
                            localStringBuilder.append("Invalid G2 character: ");
                            localStringBuilder.append(paramInt);
                            Log.w("Cea708Decoder", localStringBuilder.toString());
                            return;
                          case 127: 
                            this.currentCueBuilder.append('┌');
                            return;
                          case 126: 
                            this.currentCueBuilder.append('┘');
                            return;
                          case 125: 
                            this.currentCueBuilder.append('─');
                            return;
                          case 124: 
                            this.currentCueBuilder.append('└');
                            return;
                          case 123: 
                            this.currentCueBuilder.append('┐');
                            return;
                          case 122: 
                            this.currentCueBuilder.append('│');
                            return;
                          case 121: 
                            this.currentCueBuilder.append('⅞');
                            return;
                          case 120: 
                            this.currentCueBuilder.append('⅝');
                            return;
                          case 119: 
                            this.currentCueBuilder.append('⅜');
                            return;
                          }
                          this.currentCueBuilder.append('⅛');
                          return;
                        case 53: 
                          this.currentCueBuilder.append('•');
                          return;
                        case 52: 
                          this.currentCueBuilder.append('”');
                          return;
                        case 51: 
                          this.currentCueBuilder.append('“');
                          return;
                        case 50: 
                          this.currentCueBuilder.append('’');
                          return;
                        case 49: 
                          this.currentCueBuilder.append('‘');
                          return;
                        }
                        this.currentCueBuilder.append('█');
                        return;
                      }
                      this.currentCueBuilder.append('℠');
                      return;
                    }
                    this.currentCueBuilder.append('œ');
                    return;
                  }
                  this.currentCueBuilder.append('š');
                  return;
                }
                this.currentCueBuilder.append('™');
                return;
              }
              this.currentCueBuilder.append('Ÿ');
              return;
            }
            this.currentCueBuilder.append('Œ');
            return;
          }
          this.currentCueBuilder.append('Š');
          return;
        }
        this.currentCueBuilder.append('…');
        return;
      }
      this.currentCueBuilder.append(' ');
      return;
    }
    this.currentCueBuilder.append(' ');
  }
  
  private void handleG3Character(int paramInt)
  {
    if (paramInt == 160)
    {
      this.currentCueBuilder.append('㏄');
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid G3 character: ");
    localStringBuilder.append(paramInt);
    Log.w("Cea708Decoder", localStringBuilder.toString());
    this.currentCueBuilder.append('_');
  }
  
  private void handleSetPenAttributes()
  {
    int i = this.serviceBlockPacket.readBits(4);
    int j = this.serviceBlockPacket.readBits(2);
    int k = this.serviceBlockPacket.readBits(2);
    boolean bool1 = this.serviceBlockPacket.readBit();
    boolean bool2 = this.serviceBlockPacket.readBit();
    int m = this.serviceBlockPacket.readBits(3);
    int n = this.serviceBlockPacket.readBits(3);
    this.currentCueBuilder.setPenAttributes(i, j, k, bool1, bool2, m, n);
  }
  
  private void handleSetPenColor()
  {
    int i = this.serviceBlockPacket.readBits(2);
    i = Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), i);
    int j = this.serviceBlockPacket.readBits(2);
    j = Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), j);
    this.serviceBlockPacket.skipBits(2);
    int k = Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
    this.currentCueBuilder.setPenColor(i, j, k);
  }
  
  private void handleSetPenLocation()
  {
    this.serviceBlockPacket.skipBits(4);
    int i = this.serviceBlockPacket.readBits(4);
    this.serviceBlockPacket.skipBits(2);
    int j = this.serviceBlockPacket.readBits(6);
    this.currentCueBuilder.setPenLocation(i, j);
  }
  
  private void handleSetWindowAttributes()
  {
    int i = this.serviceBlockPacket.readBits(2);
    int k = Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), i);
    int j = this.serviceBlockPacket.readBits(2);
    int m = Cea708Decoder.CueBuilder.getArgbColorFromCeaColor(this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2), this.serviceBlockPacket.readBits(2));
    i = j;
    if (this.serviceBlockPacket.readBit()) {
      i = j | 0x4;
    }
    boolean bool = this.serviceBlockPacket.readBit();
    j = this.serviceBlockPacket.readBits(2);
    int n = this.serviceBlockPacket.readBits(2);
    int i1 = this.serviceBlockPacket.readBits(2);
    this.serviceBlockPacket.skipBits(8);
    this.currentCueBuilder.setWindowAttributes(k, m, bool, i, j, n, i1);
  }
  
  private void processCurrentPacket()
  {
    StringBuilder localStringBuilder;
    if (this.currentDtvCcPacket.currentIndex != this.currentDtvCcPacket.packetSize * 2 - 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DtvCcPacket ended prematurely; size is ");
      localStringBuilder.append(this.currentDtvCcPacket.packetSize * 2 - 1);
      localStringBuilder.append(", but current index is ");
      localStringBuilder.append(this.currentDtvCcPacket.currentIndex);
      localStringBuilder.append(" (sequence number ");
      localStringBuilder.append(this.currentDtvCcPacket.sequenceNumber);
      localStringBuilder.append("); ignoring packet");
      Log.w("Cea708Decoder", localStringBuilder.toString());
      return;
    }
    this.serviceBlockPacket.reset(this.currentDtvCcPacket.packetData, this.currentDtvCcPacket.currentIndex);
    int j = this.serviceBlockPacket.readBits(3);
    int k = this.serviceBlockPacket.readBits(5);
    int i = j;
    if (j == 7)
    {
      this.serviceBlockPacket.skipBits(2);
      i = j + this.serviceBlockPacket.readBits(6);
    }
    if (k == 0)
    {
      if (i != 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("serviceNumber is non-zero (");
        localStringBuilder.append(i);
        localStringBuilder.append(") when blockSize is 0");
        Log.w("Cea708Decoder", localStringBuilder.toString());
      }
      return;
    }
    if (i != this.selectedServiceNumber) {
      return;
    }
    i = 0;
    while (this.serviceBlockPacket.bitsLeft() > 0)
    {
      j = this.serviceBlockPacket.readBits(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          handleC0Command(j);
          continue;
        }
        if (j <= 127)
        {
          handleG0Character(j);
        }
        else if (j <= 159)
        {
          handleC1Command(j);
        }
        else if (j <= 255)
        {
          handleG1Character(j);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Invalid base command: ");
          localStringBuilder.append(j);
          Log.w("Cea708Decoder", localStringBuilder.toString());
        }
      }
      else
      {
        j = this.serviceBlockPacket.readBits(8);
        if (j <= 31)
        {
          handleC2Command(j);
          continue;
        }
        if (j > 127) {
          break label416;
        }
        handleG2Character(j);
      }
      for (;;)
      {
        i = 1;
        break;
        label416:
        if (j <= 159)
        {
          handleC3Command(j);
          break;
        }
        if (j > 255) {
          break label446;
        }
        handleG3Character(j);
      }
      label446:
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Invalid extended command: ");
      localStringBuilder.append(j);
      Log.w("Cea708Decoder", localStringBuilder.toString());
    }
    if (i != 0) {
      this.cues = getDisplayCues();
    }
  }
  
  private void resetCueBuilders()
  {
    int i = 0;
    while (i < 8)
    {
      this.cueBuilders[i].reset();
      i += 1;
    }
  }
  
  protected Subtitle createSubtitle()
  {
    List localList = this.cues;
    this.lastCues = localList;
    return new CeaSubtitle(localList);
  }
  
  protected void decode(SubtitleInputBuffer paramSubtitleInputBuffer)
  {
    this.ccData.reset(paramSubtitleInputBuffer.data.array(), paramSubtitleInputBuffer.data.limit());
    while (this.ccData.bytesLeft() >= 3)
    {
      int k = this.ccData.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      boolean bool = false;
      if ((k & 0x4) == 4) {
        k = 1;
      } else {
        k = 0;
      }
      int i = (byte)this.ccData.readUnsignedByte();
      int j = (byte)this.ccData.readUnsignedByte();
      if (((m == 2) || (m == 3)) && (k != 0))
      {
        Cea708Decoder.DtvCcPacket localDtvCcPacket;
        if (m == 3)
        {
          finalizeCurrentPacket();
          m = i & 0x3F;
          k = m;
          if (m == 0) {
            k = 64;
          }
          this.currentDtvCcPacket = new Cea708Decoder.DtvCcPacket((i & 0xC0) >> 6, k);
          paramSubtitleInputBuffer = this.currentDtvCcPacket.packetData;
          localDtvCcPacket = this.currentDtvCcPacket;
          k = localDtvCcPacket.currentIndex;
          localDtvCcPacket.currentIndex = (k + 1);
          paramSubtitleInputBuffer[k] = j;
        }
        else
        {
          if (m == 2) {
            bool = true;
          }
          Assertions.checkArgument(bool);
          paramSubtitleInputBuffer = this.currentDtvCcPacket;
          if (paramSubtitleInputBuffer == null)
          {
            Log.e("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
            continue;
          }
          paramSubtitleInputBuffer = paramSubtitleInputBuffer.packetData;
          localDtvCcPacket = this.currentDtvCcPacket;
          k = localDtvCcPacket.currentIndex;
          localDtvCcPacket.currentIndex = (k + 1);
          paramSubtitleInputBuffer[k] = i;
          paramSubtitleInputBuffer = this.currentDtvCcPacket.packetData;
          localDtvCcPacket = this.currentDtvCcPacket;
          k = localDtvCcPacket.currentIndex;
          localDtvCcPacket.currentIndex = (k + 1);
          paramSubtitleInputBuffer[k] = j;
        }
        if (this.currentDtvCcPacket.currentIndex == this.currentDtvCcPacket.packetSize * 2 - 1) {
          finalizeCurrentPacket();
        }
      }
    }
  }
  
  public void flush()
  {
    super.flush();
    this.cues = null;
    this.lastCues = null;
    this.currentWindow = 0;
    this.currentCueBuilder = this.cueBuilders[this.currentWindow];
    resetCueBuilders();
    this.currentDtvCcPacket = null;
  }
  
  public String getName()
  {
    return "Cea708Decoder";
  }
  
  protected boolean isNewSubtitleDataAvailable()
  {
    return this.cues != this.lastCues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.text.cea.Cea708Decoder
 * JD-Core Version:    0.7.0.1
 */