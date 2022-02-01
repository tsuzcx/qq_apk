package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class AtomParsers
{
  private static final String TAG = "AtomParsers";
  private static final int TYPE_clcp = Util.getIntegerCodeForString("clcp");
  private static final int TYPE_meta = Util.getIntegerCodeForString("meta");
  private static final int TYPE_sbtl;
  private static final int TYPE_soun;
  private static final int TYPE_subt;
  private static final int TYPE_text;
  private static final int TYPE_vide = Util.getIntegerCodeForString("vide");
  
  static
  {
    TYPE_soun = Util.getIntegerCodeForString("soun");
    TYPE_text = Util.getIntegerCodeForString("text");
    TYPE_sbtl = Util.getIntegerCodeForString("sbtl");
    TYPE_subt = Util.getIntegerCodeForString("subt");
  }
  
  private static int findEsdsPosition(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramParsableByteArray.getPosition();
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      if (paramParsableByteArray.readInt() == Atom.TYPE_esds) {
        return i;
      }
      i += j;
    }
    return -1;
  }
  
  private static void parseAudioSampleEntry(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, boolean paramBoolean, DrmInitData paramDrmInitData, AtomParsers.StsdData paramStsdData, int paramInt5)
  {
    int m = paramInt2;
    paramParsableByteArray.setPosition(m + 8 + 8);
    if (paramBoolean)
    {
      k = paramParsableByteArray.readUnsignedShort();
      paramParsableByteArray.skipBytes(6);
    }
    else
    {
      paramParsableByteArray.skipBytes(8);
      k = 0;
    }
    int j;
    int i;
    if ((k != 0) && (k != 1))
    {
      if (k == 2)
      {
        paramParsableByteArray.skipBytes(16);
        j = (int)Math.round(paramParsableByteArray.readDouble());
        i = paramParsableByteArray.readUnsignedIntToInt();
        paramParsableByteArray.skipBytes(20);
      }
    }
    else
    {
      n = paramParsableByteArray.readUnsignedShort();
      paramParsableByteArray.skipBytes(6);
      i1 = paramParsableByteArray.readUnsignedFixedPoint1616();
      j = i1;
      i = n;
      if (k == 1)
      {
        paramParsableByteArray.skipBytes(16);
        i = n;
        j = i1;
      }
    }
    int n = paramParsableByteArray.getPosition();
    int i1 = Atom.TYPE_enca;
    Object localObject1 = paramDrmInitData;
    int k = paramInt1;
    if (paramInt1 == i1)
    {
      localObject2 = parseSampleEntryEncryptionData(paramParsableByteArray, m, paramInt3);
      localObject1 = paramDrmInitData;
      if (localObject2 != null)
      {
        paramInt1 = ((Integer)((Pair)localObject2).first).intValue();
        if (paramDrmInitData == null) {
          localObject1 = null;
        } else {
          localObject1 = paramDrmInitData.copyWithSchemeType(((TrackEncryptionBox)((Pair)localObject2).second).schemeType);
        }
        paramStsdData.trackEncryptionBoxes[paramInt5] = ((TrackEncryptionBox)((Pair)localObject2).second);
      }
      paramParsableByteArray.setPosition(n);
      k = paramInt1;
    }
    Object localObject2 = localObject1;
    paramInt1 = Atom.TYPE_ac_3;
    String str1 = "audio/raw";
    if (k == paramInt1) {
      paramDrmInitData = "audio/ac3";
    } else if (k == Atom.TYPE_ec_3) {
      paramDrmInitData = "audio/eac3";
    } else if (k == Atom.TYPE_dtsc) {
      paramDrmInitData = "audio/vnd.dts";
    } else if ((k != Atom.TYPE_dtsh) && (k != Atom.TYPE_dtsl))
    {
      if (k == Atom.TYPE_dtse) {
        paramDrmInitData = "audio/vnd.dts.hd;profile=lbr";
      } else if (k == Atom.TYPE_samr) {
        paramDrmInitData = "audio/3gpp";
      } else if (k == Atom.TYPE_sawb) {
        paramDrmInitData = "audio/amr-wb";
      } else if ((k != Atom.TYPE_lpcm) && (k != Atom.TYPE_sowt))
      {
        if (k == Atom.TYPE__mp3) {
          paramDrmInitData = "audio/mpeg";
        } else if (k == Atom.TYPE_alac) {
          paramDrmInitData = "audio/alac";
        } else {
          paramDrmInitData = null;
        }
      }
      else {
        paramDrmInitData = "audio/raw";
      }
    }
    else {
      paramDrmInitData = "audio/vnd.dts.hd";
    }
    paramInt1 = n;
    localObject1 = null;
    k = j;
    m = i;
    while (paramInt1 - paramInt2 < paramInt3)
    {
      paramParsableByteArray.setPosition(paramInt1);
      paramInt5 = paramParsableByteArray.readInt();
      boolean bool;
      if (paramInt5 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      n = paramParsableByteArray.readInt();
      if ((n != Atom.TYPE_esds) && ((!paramBoolean) || (n != Atom.TYPE_wave)))
      {
        if (n == Atom.TYPE_dac3) {
          paramParsableByteArray.setPosition(paramInt1 + 8);
        }
        for (paramStsdData.format = Ac3Util.parseAc3AnnexFFormat(paramParsableByteArray, Integer.toString(paramInt4), paramString, (DrmInitData)localObject2);; paramStsdData.format = Ac3Util.parseEAc3AnnexFFormat(paramParsableByteArray, Integer.toString(paramInt4), paramString, (DrmInitData)localObject2))
        {
          i = paramInt1;
          paramInt1 = paramInt5;
          paramInt5 = i;
          break label693;
          if (n != Atom.TYPE_dec3) {
            break;
          }
          paramParsableByteArray.setPosition(paramInt1 + 8);
        }
        if (n == Atom.TYPE_ddts)
        {
          paramStsdData.format = Format.createAudioSampleFormat(Integer.toString(paramInt4), paramDrmInitData, null, -1, -1, m, k, null, (DrmInitData)localObject2, 0, paramString);
        }
        else if (n == Atom.TYPE_alac)
        {
          localObject1 = new byte[paramInt5];
          i = paramInt1;
          paramParsableByteArray.setPosition(i);
          paramParsableByteArray.readBytes((byte[])localObject1, 0, paramInt5);
          paramInt1 = paramInt5;
          paramInt5 = i;
          break label693;
        }
        i = paramInt5;
        paramInt5 = paramInt1;
        paramInt1 = i;
      }
      for (;;)
      {
        label693:
        break;
        j = paramInt5;
        i = paramInt1;
        if (n == Atom.TYPE_esds) {
          n = i;
        } else {
          n = findEsdsPosition(paramParsableByteArray, i, j);
        }
        paramInt1 = j;
        paramInt5 = i;
        if (n != -1)
        {
          paramDrmInitData = parseEsdsFromParent(paramParsableByteArray, n);
          String str2 = (String)paramDrmInitData.first;
          byte[] arrayOfByte = (byte[])paramDrmInitData.second;
          paramInt1 = j;
          paramInt5 = i;
          paramDrmInitData = str2;
          localObject1 = arrayOfByte;
          if ("audio/mp4a-latm".equals(str2))
          {
            paramDrmInitData = CodecSpecificDataUtil.parseAacAudioSpecificConfig(arrayOfByte);
            k = ((Integer)paramDrmInitData.first).intValue();
            m = ((Integer)paramDrmInitData.second).intValue();
            localObject1 = arrayOfByte;
            paramDrmInitData = str2;
            paramInt5 = i;
            paramInt1 = j;
          }
        }
      }
      paramInt1 = paramInt5 + paramInt1;
    }
    paramInt1 = 2;
    if ((paramStsdData.format == null) && (paramDrmInitData != null))
    {
      if (!str1.equals(paramDrmInitData)) {
        paramInt1 = -1;
      }
      str1 = Integer.toString(paramInt4);
      if (localObject1 == null) {
        paramParsableByteArray = null;
      } else {
        paramParsableByteArray = Collections.singletonList(localObject1);
      }
      paramStsdData.format = Format.createAudioSampleFormat(str1, paramDrmInitData, null, -1, -1, m, k, paramInt1, paramParsableByteArray, (DrmInitData)localObject2, 0, paramString);
    }
  }
  
  static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int k = -1;
    int j = 0;
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int m = paramParsableByteArray.readInt();
      int n = paramParsableByteArray.readInt();
      Object localObject4;
      Object localObject3;
      if (n == Atom.TYPE_frma)
      {
        localObject4 = Integer.valueOf(paramParsableByteArray.readInt());
        localObject3 = localObject2;
      }
      else if (n == Atom.TYPE_schm)
      {
        paramParsableByteArray.skipBytes(4);
        localObject3 = paramParsableByteArray.readString(4);
        localObject4 = localObject1;
      }
      else
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (n == Atom.TYPE_schi)
        {
          k = i;
          j = m;
          localObject4 = localObject1;
          localObject3 = localObject2;
        }
      }
      i += m;
      localObject2 = localObject3;
      localObject1 = localObject4;
    }
    if ((!"cenc".equals(localObject2)) && (!"cbc1".equals(localObject2)) && (!"cens".equals(localObject2)) && (!"cbcs".equals(localObject2))) {
      return null;
    }
    boolean bool2 = true;
    boolean bool1;
    if (localObject1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1, "frma atom is mandatory");
    if (k != -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1, "schi atom is mandatory");
    paramParsableByteArray = parseSchiFromParent(paramParsableByteArray, k, j, localObject2);
    if (paramParsableByteArray != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Assertions.checkArgument(bool1, "tenc atom is mandatory");
    return Pair.create(localObject1, paramParsableByteArray);
  }
  
  private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom paramContainerAtom)
  {
    if (paramContainerAtom != null)
    {
      paramContainerAtom = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_elst);
      if (paramContainerAtom != null)
      {
        paramContainerAtom = paramContainerAtom.data;
        paramContainerAtom.setPosition(8);
        int j = Atom.parseFullAtomVersion(paramContainerAtom.readInt());
        int k = paramContainerAtom.readUnsignedIntToInt();
        long[] arrayOfLong1 = new long[k];
        long[] arrayOfLong2 = new long[k];
        int i = 0;
        while (i < k)
        {
          long l;
          if (j == 1) {
            l = paramContainerAtom.readUnsignedLongToLong();
          } else {
            l = paramContainerAtom.readUnsignedInt();
          }
          arrayOfLong1[i] = l;
          if (j == 1) {
            l = paramContainerAtom.readLong();
          } else {
            l = paramContainerAtom.readInt();
          }
          arrayOfLong2[i] = l;
          if (paramContainerAtom.readShort() == 1)
          {
            paramContainerAtom.skipBytes(2);
            i += 1;
          }
          else
          {
            throw new IllegalArgumentException("Unsupported media rate.");
          }
        }
        return Pair.create(arrayOfLong1, arrayOfLong2);
      }
    }
    return Pair.create(null, null);
  }
  
  private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.setPosition(paramInt + 8 + 4);
    paramParsableByteArray.skipBytes(1);
    parseExpandableClassSize(paramParsableByteArray);
    paramParsableByteArray.skipBytes(2);
    paramInt = paramParsableByteArray.readUnsignedByte();
    if ((paramInt & 0x80) != 0) {
      paramParsableByteArray.skipBytes(2);
    }
    if ((paramInt & 0x40) != 0) {
      paramParsableByteArray.skipBytes(paramParsableByteArray.readUnsignedShort());
    }
    if ((paramInt & 0x20) != 0) {
      paramParsableByteArray.skipBytes(2);
    }
    paramParsableByteArray.skipBytes(1);
    parseExpandableClassSize(paramParsableByteArray);
    paramInt = paramParsableByteArray.readUnsignedByte();
    String str = null;
    if (paramInt != 32)
    {
      if (paramInt != 33)
      {
        if (paramInt != 35)
        {
          if (paramInt != 64)
          {
            if (paramInt != 107) {
              if ((paramInt != 96) && (paramInt != 97)) {
                if (paramInt != 165) {
                  if (paramInt == 166) {}
                }
              }
            }
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                break;
              case 170: 
              case 171: 
                return Pair.create("audio/vnd.dts.hd", null);
              case 169: 
              case 172: 
                return Pair.create("audio/vnd.dts", null);
                str = "audio/eac3";
                break;
                str = "audio/ac3";
                break;
                str = "video/mpeg2";
                break;
                return Pair.create("audio/mpeg", null);
              }
              break;
            }
          }
          else
          {
            str = "audio/mp4a-latm";
          }
        }
        else {
          str = "video/hevc";
        }
      }
      else {
        str = "video/avc";
      }
    }
    else {
      str = "video/mp4v-es";
    }
    paramParsableByteArray.skipBytes(12);
    paramParsableByteArray.skipBytes(1);
    paramInt = parseExpandableClassSize(paramParsableByteArray);
    byte[] arrayOfByte = new byte[paramInt];
    paramParsableByteArray.readBytes(arrayOfByte, 0, paramInt);
    return Pair.create(str, arrayOfByte);
  }
  
  private static int parseExpandableClassSize(ParsableByteArray paramParsableByteArray)
  {
    int j = paramParsableByteArray.readUnsignedByte();
    for (int i = j & 0x7F; (j & 0x80) == 128; i = i << 7 | j & 0x7F) {
      j = paramParsableByteArray.readUnsignedByte();
    }
    return i;
  }
  
  private static int parseHdlr(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.setPosition(16);
    int i = paramParsableByteArray.readInt();
    if (i == TYPE_soun) {
      return 1;
    }
    if (i == TYPE_vide) {
      return 2;
    }
    if ((i != TYPE_text) && (i != TYPE_sbtl) && (i != TYPE_subt) && (i != TYPE_clcp))
    {
      if (i == TYPE_meta) {
        return 4;
      }
      return -1;
    }
    return 3;
  }
  
  private static Metadata parseIlst(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.skipBytes(8);
    ArrayList localArrayList = new ArrayList();
    while (paramParsableByteArray.getPosition() < paramInt)
    {
      Metadata.Entry localEntry = MetadataUtil.parseIlstElement(paramParsableByteArray);
      if (localEntry != null) {
        localArrayList.add(localEntry);
      }
    }
    if (localArrayList.isEmpty()) {
      return null;
    }
    return new Metadata(localArrayList);
  }
  
  private static Pair<Long, String> parseMdhd(ParsableByteArray paramParsableByteArray)
  {
    int j = 8;
    paramParsableByteArray.setPosition(8);
    int k = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
    if (k == 0) {
      i = 8;
    } else {
      i = 16;
    }
    paramParsableByteArray.skipBytes(i);
    long l = paramParsableByteArray.readUnsignedInt();
    int i = j;
    if (k == 0) {
      i = 4;
    }
    paramParsableByteArray.skipBytes(i);
    i = paramParsableByteArray.readUnsignedShort();
    paramParsableByteArray = new StringBuilder();
    paramParsableByteArray.append("");
    paramParsableByteArray.append((char)((i >> 10 & 0x1F) + 96));
    paramParsableByteArray.append((char)((i >> 5 & 0x1F) + 96));
    paramParsableByteArray.append((char)((i & 0x1F) + 96));
    return Pair.create(Long.valueOf(l), paramParsableByteArray.toString());
  }
  
  private static Metadata parseMetaAtom(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.skipBytes(12);
    while (paramParsableByteArray.getPosition() < paramInt)
    {
      int i = paramParsableByteArray.getPosition();
      int j = paramParsableByteArray.readInt();
      if (paramParsableByteArray.readInt() == Atom.TYPE_ilst)
      {
        paramParsableByteArray.setPosition(i);
        return parseIlst(paramParsableByteArray, i + j);
      }
      paramParsableByteArray.skipBytes(j - 8);
    }
    return null;
  }
  
  private static long parseMvhd(ParsableByteArray paramParsableByteArray)
  {
    int i = 8;
    paramParsableByteArray.setPosition(8);
    if (Atom.parseFullAtomVersion(paramParsableByteArray.readInt()) != 0) {
      i = 16;
    }
    paramParsableByteArray.skipBytes(i);
    return paramParsableByteArray.readUnsignedInt();
  }
  
  private static float parsePaspFromParent(ParsableByteArray paramParsableByteArray, int paramInt)
  {
    paramParsableByteArray.setPosition(paramInt + 8);
    paramInt = paramParsableByteArray.readUnsignedIntToInt();
    int i = paramParsableByteArray.readUnsignedIntToInt();
    return paramInt / i;
  }
  
  private static byte[] parseProjFromParent(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + 8;
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      if (paramParsableByteArray.readInt() == Atom.TYPE_proj) {
        return Arrays.copyOfRange(paramParsableByteArray.data, i, j + i);
      }
      i += j;
    }
    return null;
  }
  
  private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2)
  {
    int i = paramParsableByteArray.getPosition();
    while (i - paramInt1 < paramInt2)
    {
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      boolean bool;
      if (j > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      if (paramParsableByteArray.readInt() == Atom.TYPE_sinf)
      {
        Pair localPair = parseCommonEncryptionSinfFromParent(paramParsableByteArray, i, j);
        if (localPair != null) {
          return localPair;
        }
      }
      i += j;
    }
    return null;
  }
  
  private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, String paramString)
  {
    int i = paramInt1 + 8;
    for (;;)
    {
      Object localObject2 = null;
      if (i - paramInt1 >= paramInt2) {
        break;
      }
      paramParsableByteArray.setPosition(i);
      int j = paramParsableByteArray.readInt();
      if (paramParsableByteArray.readInt() == Atom.TYPE_tenc)
      {
        paramInt1 = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
        paramParsableByteArray.skipBytes(1);
        if (paramInt1 == 0)
        {
          paramParsableByteArray.skipBytes(1);
          paramInt1 = 0;
          paramInt2 = 0;
        }
        else
        {
          paramInt1 = paramParsableByteArray.readUnsignedByte();
          paramInt2 = paramInt1 & 0xF;
          paramInt1 = (paramInt1 & 0xF0) >> 4;
        }
        boolean bool;
        if (paramParsableByteArray.readUnsignedByte() == 1) {
          bool = true;
        } else {
          bool = false;
        }
        i = paramParsableByteArray.readUnsignedByte();
        byte[] arrayOfByte = new byte[16];
        paramParsableByteArray.readBytes(arrayOfByte, 0, arrayOfByte.length);
        Object localObject1 = localObject2;
        if (bool)
        {
          localObject1 = localObject2;
          if (i == 0)
          {
            j = paramParsableByteArray.readUnsignedByte();
            localObject1 = new byte[j];
            paramParsableByteArray.readBytes((byte[])localObject1, 0, j);
          }
        }
        return new TrackEncryptionBox(bool, paramString, i, arrayOfByte, paramInt1, paramInt2, (byte[])localObject1);
      }
      i += j;
    }
    return null;
  }
  
  public static TrackSampleTable parseStbl(Track paramTrack, Atom.ContainerAtom paramContainerAtom, GaplessInfoHolder paramGaplessInfoHolder)
  {
    Object localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stsz);
    if (localObject1 != null)
    {
      localObject1 = new AtomParsers.StszSampleSizeBox((Atom.LeafAtom)localObject1);
    }
    else
    {
      localObject1 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stz2);
      if (localObject1 == null) {
        break label2196;
      }
      localObject1 = new AtomParsers.Stz2SampleSizeBox((Atom.LeafAtom)localObject1);
    }
    int n = ((AtomParsers.SampleSizeBox)localObject1).getSampleCount();
    if (n == 0) {
      return new TrackSampleTable(new long[0], new int[0], 0, new long[0], new int[0], -9223372036854775807L);
    }
    Object localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stco);
    boolean bool;
    if (localObject2 == null)
    {
      localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_co64);
      bool = true;
    }
    else
    {
      bool = false;
    }
    Object localObject3 = ((Atom.LeafAtom)localObject2).data;
    Object localObject4 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stsc).data;
    Object localObject6 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stts).data;
    localObject2 = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_stss);
    if (localObject2 != null) {
      localObject2 = ((Atom.LeafAtom)localObject2).data;
    } else {
      localObject2 = null;
    }
    paramContainerAtom = paramContainerAtom.getLeafAtomOfType(Atom.TYPE_ctts);
    if (paramContainerAtom != null) {
      paramContainerAtom = paramContainerAtom.data;
    } else {
      paramContainerAtom = null;
    }
    Object localObject7 = new AtomParsers.ChunkIterator((ParsableByteArray)localObject4, (ParsableByteArray)localObject3, bool);
    ((ParsableByteArray)localObject6).setPosition(12);
    int i1 = ((ParsableByteArray)localObject6).readUnsignedIntToInt() - 1;
    int i5 = ((ParsableByteArray)localObject6).readUnsignedIntToInt();
    int i7 = ((ParsableByteArray)localObject6).readUnsignedIntToInt();
    int i;
    if (paramContainerAtom != null)
    {
      paramContainerAtom.setPosition(12);
      i = paramContainerAtom.readUnsignedIntToInt();
    }
    else
    {
      i = 0;
    }
    int j = -1;
    int k;
    if (localObject2 != null)
    {
      ((ParsableByteArray)localObject2).setPosition(12);
      k = ((ParsableByteArray)localObject2).readUnsignedIntToInt();
      if (k > 0) {
        j = ((ParsableByteArray)localObject2).readUnsignedIntToInt() - 1;
      } else {
        localObject2 = null;
      }
    }
    else
    {
      k = 0;
    }
    int m;
    if ((((AtomParsers.SampleSizeBox)localObject1).isFixedSampleSize()) && ("audio/raw".equals(paramTrack.format.sampleMimeType)) && (i1 == 0) && (i == 0) && (k == 0)) {
      m = 1;
    } else {
      m = 0;
    }
    long l3 = 0L;
    long[] arrayOfLong;
    Object localObject5;
    int i2;
    int i3;
    int i4;
    long l1;
    if (m == 0)
    {
      arrayOfLong = new long[n];
      localObject5 = new int[n];
      localObject3 = new long[n];
      localObject4 = new int[n];
      i2 = k;
      k = i;
      l2 = 0L;
      i = i1;
      int i8 = 0;
      int i6 = 0;
      i3 = 0;
      i4 = 0;
      m = 0;
      l1 = l2;
      i1 = j;
      j = i8;
      while (i6 < n)
      {
        i8 = i4;
        i4 = i2;
        while (i8 == 0)
        {
          Assertions.checkState(((AtomParsers.ChunkIterator)localObject7).moveNext());
          l1 = ((AtomParsers.ChunkIterator)localObject7).offset;
          i8 = ((AtomParsers.ChunkIterator)localObject7).numSamples;
        }
        int i10 = i3;
        int i9 = k;
        i2 = m;
        if (paramContainerAtom != null)
        {
          while ((i3 == 0) && (k > 0))
          {
            i3 = paramContainerAtom.readUnsignedIntToInt();
            m = paramContainerAtom.readInt();
            k -= 1;
          }
          i10 = i3 - 1;
          i2 = m;
          i9 = k;
        }
        arrayOfLong[i6] = l1;
        localObject5[i6] = ((AtomParsers.SampleSizeBox)localObject1).readNextSampleSize();
        k = j;
        if (localObject5[i6] > j) {
          k = localObject5[i6];
        }
        localObject3[i6] = (i2 + l2);
        if (localObject2 == null) {
          j = 1;
        } else {
          j = 0;
        }
        localObject4[i6] = j;
        if (i6 == i1)
        {
          localObject4[i6] = 1;
          j = i4 - 1;
          if (j > 0) {
            i1 = ((ParsableByteArray)localObject2).readUnsignedIntToInt() - 1;
          }
        }
        else
        {
          j = i4;
        }
        l2 += i7;
        i5 -= 1;
        if (i5 == 0)
        {
          m = i;
          if (m > 0)
          {
            i5 = ((ParsableByteArray)localObject6).readUnsignedIntToInt();
            i7 = ((ParsableByteArray)localObject6).readInt();
            i = m - 1;
          }
        }
        l1 += localObject5[i6];
        i4 = i8 - 1;
        i6 += 1;
        i3 = j;
        m = i2;
        j = k;
        i2 = i3;
        i3 = i10;
        k = i9;
      }
      l1 = l2 + m;
      if (i3 == 0) {
        bool = true;
      } else {
        bool = false;
      }
      Assertions.checkArgument(bool);
      while (k > 0)
      {
        if (paramContainerAtom.readUnsignedIntToInt() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkArgument(bool);
        paramContainerAtom.readInt();
        k -= 1;
      }
      if ((i2 == 0) && (i5 == 0) && (i4 == 0) && (i == 0))
      {
        i = j;
        localObject1 = arrayOfLong;
        localObject2 = localObject5;
        paramContainerAtom = (Atom.ContainerAtom)localObject4;
        j = n;
      }
      else
      {
        paramContainerAtom = new StringBuilder();
        paramContainerAtom.append("Inconsistent stbl box for track ");
        paramContainerAtom.append(paramTrack.id);
        paramContainerAtom.append(": remainingSynchronizationSamples ");
        paramContainerAtom.append(i2);
        paramContainerAtom.append(", remainingSamplesAtTimestampDelta ");
        paramContainerAtom.append(i5);
        paramContainerAtom.append(", remainingSamplesInChunk ");
        paramContainerAtom.append(i4);
        paramContainerAtom.append(", remainingTimestampDeltaChanges ");
        paramContainerAtom.append(i);
        Log.w("AtomParsers", paramContainerAtom.toString());
        i = j;
        localObject1 = arrayOfLong;
        localObject2 = localObject5;
        paramContainerAtom = (Atom.ContainerAtom)localObject4;
        j = n;
      }
    }
    else
    {
      j = n;
      paramContainerAtom = new long[((AtomParsers.ChunkIterator)localObject7).length];
      localObject2 = new int[((AtomParsers.ChunkIterator)localObject7).length];
      while (((AtomParsers.ChunkIterator)localObject7).moveNext())
      {
        paramContainerAtom[localObject7.index] = ((AtomParsers.ChunkIterator)localObject7).offset;
        localObject2[localObject7.index] = ((AtomParsers.ChunkIterator)localObject7).numSamples;
      }
      localObject4 = FixedSampleSizeRechunker.rechunk(((AtomParsers.SampleSizeBox)localObject1).readNextSampleSize(), paramContainerAtom, (int[])localObject2, i7);
      localObject1 = ((FixedSampleSizeRechunker.Results)localObject4).offsets;
      localObject2 = ((FixedSampleSizeRechunker.Results)localObject4).sizes;
      i = ((FixedSampleSizeRechunker.Results)localObject4).maximumSize;
      localObject3 = ((FixedSampleSizeRechunker.Results)localObject4).timestamps;
      paramContainerAtom = ((FixedSampleSizeRechunker.Results)localObject4).flags;
      l1 = ((FixedSampleSizeRechunker.Results)localObject4).duration;
    }
    localObject7 = paramTrack;
    paramTrack = (Track)localObject2;
    long l2 = Util.scaleLargeTimestamp(l1, 1000000L, ((Track)localObject7).timescale);
    if ((((Track)localObject7).editListDurations != null) && (!paramGaplessInfoHolder.hasGaplessInfo()))
    {
      long l5;
      long l4;
      if ((((Track)localObject7).editListDurations.length == 1) && (((Track)localObject7).type == 1) && (localObject3.length >= 2))
      {
        l5 = localObject7.editListMediaTimes[0];
        l4 = l5 + Util.scaleLargeTimestamp(localObject7.editListDurations[0], ((Track)localObject7).timescale, ((Track)localObject7).movieTimescale);
        if ((localObject3[0] <= l5) && (l5 < localObject3[1]) && (localObject3[(localObject3.length - 1)] < l4) && (l4 <= l1))
        {
          l5 = Util.scaleLargeTimestamp(l5 - localObject3[0], ((Track)localObject7).format.sampleRate, ((Track)localObject7).timescale);
          l4 = Util.scaleLargeTimestamp(l1 - l4, ((Track)localObject7).format.sampleRate, ((Track)localObject7).timescale);
          if (((l5 != 0L) || (l4 != 0L)) && (l5 <= 2147483647L) && (l4 <= 2147483647L))
          {
            paramGaplessInfoHolder.encoderDelay = ((int)l5);
            paramGaplessInfoHolder.encoderPadding = ((int)l4);
            Util.scaleLargeTimestampsInPlace((long[])localObject3, 1000000L, ((Track)localObject7).timescale);
            return new TrackSampleTable((long[])localObject1, paramTrack, i, (long[])localObject3, paramContainerAtom, l2);
          }
        }
        else {}
      }
      paramGaplessInfoHolder = (GaplessInfoHolder)localObject1;
      localObject4 = "AtomParsers";
      if ((((Track)localObject7).editListDurations.length == 1) && (localObject7.editListDurations[0] == 0L))
      {
        l2 = localObject7.editListMediaTimes[0];
        j = 0;
        while (j < localObject3.length)
        {
          localObject3[j] = Util.scaleLargeTimestamp(localObject3[j] - l2, 1000000L, ((Track)localObject7).timescale);
          j += 1;
        }
        return new TrackSampleTable(paramGaplessInfoHolder, paramTrack, i, (long[])localObject3, paramContainerAtom, Util.scaleLargeTimestamp(l1 - l2, 1000000L, ((Track)localObject7).timescale));
      }
      if (((Track)localObject7).type == 1) {
        bool = true;
      } else {
        bool = false;
      }
      n = 0;
      k = 0;
      m = 0;
      i1 = 0;
      l1 = l2;
      while (n < ((Track)localObject7).editListDurations.length)
      {
        l2 = localObject7.editListMediaTimes[n];
        if (l2 != -1L)
        {
          l4 = Util.scaleLargeTimestamp(localObject7.editListDurations[n], ((Track)localObject7).timescale, ((Track)localObject7).movieTimescale);
          i4 = Util.binarySearchCeil((long[])localObject3, l2, true, true);
          i3 = Util.binarySearchCeil((long[])localObject3, l2 + l4, bool, false);
          i2 = m + (i3 - i4);
          if (i1 != i4) {
            m = 1;
          } else {
            m = 0;
          }
          k |= m;
          i1 = i3;
          m = i2;
        }
        n += 1;
      }
      if (m != j) {
        j = 1;
      } else {
        j = 0;
      }
      i3 = j | k;
      if (i3 != 0) {
        localObject1 = new long[m];
      } else {
        localObject1 = paramGaplessInfoHolder;
      }
      if (i3 != 0) {
        localObject5 = new int[m];
      } else {
        localObject5 = paramTrack;
      }
      if (i3 != 0) {
        j = 0;
      } else {
        j = i;
      }
      if (i3 != 0) {
        localObject2 = new int[m];
      } else {
        localObject2 = paramContainerAtom;
      }
      arrayOfLong = new long[m];
      m = 0;
      k = 0;
      l2 = l3;
      localObject6 = paramTrack;
      paramTrack = (Track)localObject1;
      while (m < ((Track)localObject7).editListDurations.length)
      {
        l3 = localObject7.editListMediaTimes[m];
        l4 = localObject7.editListDurations[m];
        if (l3 != -1L)
        {
          l5 = Util.scaleLargeTimestamp(l4, ((Track)localObject7).timescale, ((Track)localObject7).movieTimescale);
          n = Util.binarySearchCeil((long[])localObject3, l3, true, true);
          i2 = Util.binarySearchCeil((long[])localObject3, l5 + l3, bool, false);
          if (i3 != 0)
          {
            i1 = i2 - n;
            System.arraycopy(paramGaplessInfoHolder, n, paramTrack, k, i1);
            System.arraycopy(localObject6, n, localObject5, k, i1);
            System.arraycopy(paramContainerAtom, n, localObject2, k, i1);
          }
          i1 = j;
          j = k;
          k = i1;
          i1 = i2;
          while (n < i1)
          {
            arrayOfLong[j] = (Util.scaleLargeTimestamp(l2, 1000000L, ((Track)localObject7).movieTimescale) + Util.scaleLargeTimestamp(localObject3[n] - l3, 1000000L, ((Track)localObject7).timescale));
            i2 = k;
            if (i3 != 0)
            {
              i2 = k;
              if (localObject5[j] > k) {
                i2 = localObject6[n];
              }
            }
            j += 1;
            n += 1;
            k = i2;
          }
          n = k;
        }
        else
        {
          n = j;
          j = k;
        }
        l2 += l4;
        m += 1;
        k = j;
        j = n;
      }
      l2 = Util.scaleLargeTimestamp(l2, 1000000L, ((Track)localObject7).timescale);
      k = 0;
      m = 0;
      while ((k < localObject2.length) && (m == 0))
      {
        if ((localObject2[k] & 0x1) != 0) {
          n = 1;
        } else {
          n = 0;
        }
        m |= n;
        k += 1;
      }
      if (m == 0)
      {
        Log.w((String)localObject4, "Ignoring edit list: Edited sample sequence does not contain a sync sample.");
        Util.scaleLargeTimestampsInPlace((long[])localObject3, 1000000L, ((Track)localObject7).timescale);
        return new TrackSampleTable(paramGaplessInfoHolder, (int[])localObject6, i, (long[])localObject3, paramContainerAtom, l1);
      }
      return new TrackSampleTable(paramTrack, (int[])localObject5, j, arrayOfLong, (int[])localObject2, l2);
    }
    Util.scaleLargeTimestampsInPlace((long[])localObject3, 1000000L, ((Track)localObject7).timescale);
    return new TrackSampleTable((long[])localObject1, paramTrack, i, (long[])localObject3, paramContainerAtom, l2);
    label2196:
    paramTrack = new ParserException("Track has no sample table size information");
    for (;;)
    {
      throw paramTrack;
    }
  }
  
  private static AtomParsers.StsdData parseStsd(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, String paramString, DrmInitData paramDrmInitData, boolean paramBoolean)
  {
    paramParsableByteArray.setPosition(12);
    int j = paramParsableByteArray.readInt();
    AtomParsers.StsdData localStsdData = new AtomParsers.StsdData(j);
    int i = 0;
    while (i < j)
    {
      int k = paramParsableByteArray.getPosition();
      int m = paramParsableByteArray.readInt();
      boolean bool;
      if (m > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      int n = paramParsableByteArray.readInt();
      if ((n != Atom.TYPE_avc1) && (n != Atom.TYPE_avc3) && (n != Atom.TYPE_encv) && (n != Atom.TYPE_mp4v) && (n != Atom.TYPE_hvc1) && (n != Atom.TYPE_hev1) && (n != Atom.TYPE_s263) && (n != Atom.TYPE_vp08) && (n != Atom.TYPE_vp09))
      {
        if ((n != Atom.TYPE_mp4a) && (n != Atom.TYPE_enca) && (n != Atom.TYPE_ac_3) && (n != Atom.TYPE_ec_3) && (n != Atom.TYPE_dtsc) && (n != Atom.TYPE_dtse) && (n != Atom.TYPE_dtsh) && (n != Atom.TYPE_dtsl) && (n != Atom.TYPE_samr) && (n != Atom.TYPE_sawb) && (n != Atom.TYPE_lpcm) && (n != Atom.TYPE_sowt) && (n != Atom.TYPE__mp3) && (n != Atom.TYPE_alac))
        {
          if ((n != Atom.TYPE_TTML) && (n != Atom.TYPE_tx3g) && (n != Atom.TYPE_wvtt) && (n != Atom.TYPE_stpp) && (n != Atom.TYPE_c608))
          {
            if (n == Atom.TYPE_camm) {
              localStsdData.format = Format.createSampleFormat(Integer.toString(paramInt1), "application/x-camera-motion", null, -1, null);
            }
          }
          else {
            parseTextSampleEntry(paramParsableByteArray, n, k, m, paramInt1, paramString, localStsdData);
          }
        }
        else {
          parseAudioSampleEntry(paramParsableByteArray, n, k, m, paramInt1, paramString, paramBoolean, paramDrmInitData, localStsdData, i);
        }
      }
      else {
        parseVideoSampleEntry(paramParsableByteArray, n, k, m, paramInt1, paramInt2, paramDrmInitData, localStsdData, i);
      }
      paramParsableByteArray.setPosition(k + m);
      i += 1;
    }
    return localStsdData;
  }
  
  private static void parseTextSampleEntry(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, AtomParsers.StsdData paramStsdData)
  {
    paramParsableByteArray.setPosition(paramInt2 + 8 + 8);
    paramInt2 = Atom.TYPE_TTML;
    String str = "application/ttml+xml";
    Object localObject = null;
    long l = 9223372036854775807L;
    if (paramInt1 == paramInt2) {
      paramParsableByteArray = str;
    }
    for (;;)
    {
      break;
      if (paramInt1 == Atom.TYPE_tx3g)
      {
        paramInt1 = paramInt3 - 8 - 8;
        localObject = new byte[paramInt1];
        paramParsableByteArray.readBytes((byte[])localObject, 0, paramInt1);
        localObject = Collections.singletonList(localObject);
        paramParsableByteArray = "application/x-quicktime-tx3g";
      }
      else if (paramInt1 == Atom.TYPE_wvtt)
      {
        paramParsableByteArray = "application/x-mp4-vtt";
      }
      else if (paramInt1 == Atom.TYPE_stpp)
      {
        l = 0L;
        paramParsableByteArray = str;
      }
      else
      {
        if (paramInt1 != Atom.TYPE_c608) {
          break label157;
        }
        paramStsdData.requiredSampleTransformation = 1;
        paramParsableByteArray = "application/x-mp4-cea-608";
      }
    }
    paramStsdData.format = Format.createTextSampleFormat(Integer.toString(paramInt4), paramParsableByteArray, null, -1, 0, paramString, -1, null, l, (List)localObject);
    return;
    label157:
    paramParsableByteArray = new IllegalStateException();
    for (;;)
    {
      throw paramParsableByteArray;
    }
  }
  
  private static AtomParsers.TkhdData parseTkhd(ParsableByteArray paramParsableByteArray)
  {
    int j = 8;
    paramParsableByteArray.setPosition(8);
    int n = Atom.parseFullAtomVersion(paramParsableByteArray.readInt());
    if (n == 0) {
      i = 8;
    } else {
      i = 16;
    }
    paramParsableByteArray.skipBytes(i);
    int m = paramParsableByteArray.readInt();
    paramParsableByteArray.skipBytes(4);
    int i1 = paramParsableByteArray.getPosition();
    int i = j;
    if (n == 0) {
      i = 4;
    }
    int k = 0;
    j = 0;
    while (j < i)
    {
      if (paramParsableByteArray.data[(i1 + j)] != -1)
      {
        j = 0;
        break label99;
      }
      j += 1;
    }
    j = 1;
    label99:
    long l2 = -9223372036854775807L;
    long l1;
    if (j != 0)
    {
      paramParsableByteArray.skipBytes(i);
      l1 = l2;
    }
    else
    {
      if (n == 0) {
        l1 = paramParsableByteArray.readUnsignedInt();
      } else {
        l1 = paramParsableByteArray.readUnsignedLongToLong();
      }
      if (l1 == 0L) {
        l1 = l2;
      }
    }
    paramParsableByteArray.skipBytes(16);
    j = paramParsableByteArray.readInt();
    n = paramParsableByteArray.readInt();
    paramParsableByteArray.skipBytes(4);
    i1 = paramParsableByteArray.readInt();
    int i2 = paramParsableByteArray.readInt();
    if ((j == 0) && (n == 65536) && (i1 == -65536) && (i2 == 0))
    {
      i = 90;
    }
    else if ((j == 0) && (n == -65536) && (i1 == 65536) && (i2 == 0))
    {
      i = 270;
    }
    else
    {
      i = k;
      if (j == -65536)
      {
        i = k;
        if (n == 0)
        {
          i = k;
          if (i1 == 0)
          {
            i = k;
            if (i2 == -65536) {
              i = 180;
            }
          }
        }
      }
    }
    return new AtomParsers.TkhdData(m, l1, i);
  }
  
  public static Track parseTrak(Atom.ContainerAtom paramContainerAtom, Atom.LeafAtom paramLeafAtom, long paramLong, DrmInitData paramDrmInitData, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramContainerAtom.getContainerAtomOfType(Atom.TYPE_mdia);
    int i = parseHdlr(((Atom.ContainerAtom)localObject).getLeafAtomOfType(Atom.TYPE_hdlr).data);
    if (i == -1) {
      return null;
    }
    AtomParsers.TkhdData localTkhdData = parseTkhd(paramContainerAtom.getLeafAtomOfType(Atom.TYPE_tkhd).data);
    long l1 = -9223372036854775807L;
    if (paramLong == -9223372036854775807L) {
      paramLong = AtomParsers.TkhdData.access$000(localTkhdData);
    }
    long l2 = parseMvhd(paramLeafAtom.data);
    if (paramLong == -9223372036854775807L) {
      paramLong = l1;
    } else {
      paramLong = Util.scaleLargeTimestamp(paramLong, 1000000L, l2);
    }
    paramLeafAtom = ((Atom.ContainerAtom)localObject).getContainerAtomOfType(Atom.TYPE_minf).getContainerAtomOfType(Atom.TYPE_stbl);
    localObject = parseMdhd(((Atom.ContainerAtom)localObject).getLeafAtomOfType(Atom.TYPE_mdhd).data);
    paramDrmInitData = parseStsd(paramLeafAtom.getLeafAtomOfType(Atom.TYPE_stsd).data, AtomParsers.TkhdData.access$100(localTkhdData), AtomParsers.TkhdData.access$200(localTkhdData), (String)((Pair)localObject).second, paramDrmInitData, paramBoolean2);
    if (!paramBoolean1)
    {
      paramLeafAtom = parseEdts(paramContainerAtom.getContainerAtomOfType(Atom.TYPE_edts));
      paramContainerAtom = (long[])paramLeafAtom.first;
      paramLeafAtom = (long[])paramLeafAtom.second;
    }
    else
    {
      paramContainerAtom = null;
      paramLeafAtom = paramContainerAtom;
    }
    if (paramDrmInitData.format == null) {
      return null;
    }
    return new Track(AtomParsers.TkhdData.access$100(localTkhdData), i, ((Long)((Pair)localObject).first).longValue(), l2, paramLong, paramDrmInitData.format, paramDrmInitData.requiredSampleTransformation, paramDrmInitData.trackEncryptionBoxes, paramDrmInitData.nalUnitLengthFieldLength, paramContainerAtom, paramLeafAtom);
  }
  
  public static Metadata parseUdta(Atom.LeafAtom paramLeafAtom, boolean paramBoolean)
  {
    if (paramBoolean) {
      return null;
    }
    paramLeafAtom = paramLeafAtom.data;
    paramLeafAtom.setPosition(8);
    while (paramLeafAtom.bytesLeft() >= 8)
    {
      int i = paramLeafAtom.getPosition();
      int j = paramLeafAtom.readInt();
      if (paramLeafAtom.readInt() == Atom.TYPE_meta)
      {
        paramLeafAtom.setPosition(i);
        return parseMetaAtom(paramLeafAtom, i + j);
      }
      paramLeafAtom.skipBytes(j - 8);
    }
    return null;
  }
  
  private static void parseVideoSampleEntry(ParsableByteArray paramParsableByteArray, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, DrmInitData paramDrmInitData, AtomParsers.StsdData paramStsdData, int paramInt6)
  {
    paramParsableByteArray.setPosition(paramInt2 + 8 + 8);
    paramParsableByteArray.skipBytes(16);
    int n = paramParsableByteArray.readUnsignedShort();
    int i1 = paramParsableByteArray.readUnsignedShort();
    paramParsableByteArray.skipBytes(50);
    int j = paramParsableByteArray.getPosition();
    int k = Atom.TYPE_encv;
    DrmInitData localDrmInitData = null;
    Object localObject2 = paramDrmInitData;
    int i = paramInt1;
    Object localObject1;
    if (paramInt1 == k)
    {
      localObject2 = parseSampleEntryEncryptionData(paramParsableByteArray, paramInt2, paramInt3);
      localObject1 = paramDrmInitData;
      if (localObject2 != null)
      {
        paramInt1 = ((Integer)((Pair)localObject2).first).intValue();
        if (paramDrmInitData == null) {
          localObject1 = null;
        } else {
          localObject1 = paramDrmInitData.copyWithSchemeType(((TrackEncryptionBox)((Pair)localObject2).second).schemeType);
        }
        paramStsdData.trackEncryptionBoxes[paramInt6] = ((TrackEncryptionBox)((Pair)localObject2).second);
      }
      paramParsableByteArray.setPosition(j);
      i = paramInt1;
      localObject2 = localObject1;
    }
    Object localObject4 = null;
    Object localObject3 = localObject4;
    paramInt1 = 0;
    float f1 = 1.0F;
    k = -1;
    paramInt6 = j;
    j = paramInt1;
    while (paramInt6 - paramInt2 < paramInt3)
    {
      paramParsableByteArray.setPosition(paramInt6);
      paramInt1 = paramParsableByteArray.getPosition();
      int i2 = paramParsableByteArray.readInt();
      if ((i2 == 0) && (paramParsableByteArray.getPosition() - paramInt2 == paramInt3)) {
        break;
      }
      boolean bool;
      if (i2 > 0) {
        bool = true;
      } else {
        bool = false;
      }
      Assertions.checkArgument(bool, "childAtomSize should be positive");
      int i3 = paramParsableByteArray.readInt();
      int m;
      float f2;
      Object localObject5;
      if (i3 == Atom.TYPE_avcC)
      {
        if (localDrmInitData == null) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkState(bool);
        paramParsableByteArray.setPosition(paramInt1 + 8);
        paramDrmInitData = AvcConfig.parse(paramParsableByteArray);
        localObject1 = paramDrmInitData.initializationData;
        paramStsdData.nalUnitLengthFieldLength = paramDrmInitData.nalUnitLengthFieldLength;
        if (j == 0) {
          f1 = paramDrmInitData.pixelWidthAspectRatio;
        }
        paramDrmInitData = "video/avc";
        m = j;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == Atom.TYPE_hvcC)
      {
        if (localDrmInitData == null) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkState(bool);
        paramParsableByteArray.setPosition(paramInt1 + 8);
        paramDrmInitData = HevcConfig.parse(paramParsableByteArray);
        localObject1 = paramDrmInitData.initializationData;
        paramStsdData.nalUnitLengthFieldLength = paramDrmInitData.nalUnitLengthFieldLength;
        paramDrmInitData = "video/hevc";
        m = j;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == Atom.TYPE_vpcC)
      {
        if (localDrmInitData == null) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkState(bool);
        if (i == Atom.TYPE_vp08) {
          paramDrmInitData = "video/x-vnd.on2.vp8";
        } else {
          paramDrmInitData = "video/x-vnd.on2.vp9";
        }
        m = j;
        localObject1 = localObject4;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == Atom.TYPE_d263)
      {
        if (localDrmInitData == null) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkState(bool);
        paramDrmInitData = "video/3gpp";
        m = j;
        localObject1 = localObject4;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == Atom.TYPE_esds)
      {
        if (localDrmInitData == null) {
          bool = true;
        } else {
          bool = false;
        }
        Assertions.checkState(bool);
        localObject1 = parseEsdsFromParent(paramParsableByteArray, paramInt1);
        paramDrmInitData = (String)((Pair)localObject1).first;
        localObject1 = Collections.singletonList(((Pair)localObject1).second);
        m = j;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == Atom.TYPE_pasp)
      {
        f2 = parsePaspFromParent(paramParsableByteArray, paramInt1);
        m = 1;
        paramDrmInitData = localDrmInitData;
        localObject1 = localObject4;
        localObject5 = localObject3;
        paramInt1 = k;
      }
      else if (i3 == Atom.TYPE_sv3d)
      {
        localObject5 = parseProjFromParent(paramParsableByteArray, paramInt1, i2);
        m = j;
        paramDrmInitData = localDrmInitData;
        localObject1 = localObject4;
        f2 = f1;
        paramInt1 = k;
      }
      else
      {
        m = j;
        paramDrmInitData = localDrmInitData;
        localObject1 = localObject4;
        f2 = f1;
        localObject5 = localObject3;
        paramInt1 = k;
        if (i3 == Atom.TYPE_st3d)
        {
          i3 = paramParsableByteArray.readUnsignedByte();
          paramParsableByteArray.skipBytes(3);
          m = j;
          paramDrmInitData = localDrmInitData;
          localObject1 = localObject4;
          f2 = f1;
          localObject5 = localObject3;
          paramInt1 = k;
          if (i3 == 0)
          {
            paramInt1 = paramParsableByteArray.readUnsignedByte();
            if (paramInt1 != 0)
            {
              if (paramInt1 != 1)
              {
                if (paramInt1 != 2)
                {
                  if (paramInt1 != 3)
                  {
                    m = j;
                    paramDrmInitData = localDrmInitData;
                    localObject1 = localObject4;
                    f2 = f1;
                    localObject5 = localObject3;
                    paramInt1 = k;
                  }
                  else
                  {
                    paramInt1 = 3;
                    m = j;
                    paramDrmInitData = localDrmInitData;
                    localObject1 = localObject4;
                    f2 = f1;
                    localObject5 = localObject3;
                  }
                }
                else
                {
                  paramInt1 = 2;
                  m = j;
                  paramDrmInitData = localDrmInitData;
                  localObject1 = localObject4;
                  f2 = f1;
                  localObject5 = localObject3;
                }
              }
              else
              {
                paramInt1 = 1;
                m = j;
                paramDrmInitData = localDrmInitData;
                localObject1 = localObject4;
                f2 = f1;
                localObject5 = localObject3;
              }
            }
            else
            {
              paramInt1 = 0;
              localObject5 = localObject3;
              f2 = f1;
              localObject1 = localObject4;
              paramDrmInitData = localDrmInitData;
              m = j;
            }
          }
        }
      }
      paramInt6 += i2;
      j = m;
      localDrmInitData = paramDrmInitData;
      localObject4 = localObject1;
      f1 = f2;
      localObject3 = localObject5;
      k = paramInt1;
    }
    if (localDrmInitData == null) {
      return;
    }
    paramStsdData.format = Format.createVideoSampleFormat(Integer.toString(paramInt4), localDrmInitData, null, -1, -1, n, i1, -1.0F, localObject4, paramInt5, f1, localObject3, k, null, (DrmInitData)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.mp4.AtomParsers
 * JD-Core Version:    0.7.0.1
 */