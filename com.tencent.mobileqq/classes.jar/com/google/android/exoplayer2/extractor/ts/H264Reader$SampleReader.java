package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.NalUnitUtil.PpsData;
import com.google.android.exoplayer2.util.NalUnitUtil.SpsData;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import java.util.Arrays;

final class H264Reader$SampleReader
{
  private static final int DEFAULT_BUFFER_SIZE = 128;
  private static final int NAL_UNIT_TYPE_AUD = 9;
  private static final int NAL_UNIT_TYPE_IDR = 5;
  private static final int NAL_UNIT_TYPE_NON_IDR = 1;
  private static final int NAL_UNIT_TYPE_PARTITION_A = 2;
  private final boolean allowNonIdrKeyframes;
  private final ParsableNalUnitBitArray bitArray;
  private byte[] buffer;
  private int bufferLength;
  private final boolean detectAccessUnits;
  private boolean isFilling;
  private long nalUnitStartPosition;
  private long nalUnitTimeUs;
  private int nalUnitType;
  private final TrackOutput output;
  private final SparseArray<NalUnitUtil.PpsData> pps;
  private H264Reader.SampleReader.SliceHeaderData previousSliceHeader;
  private boolean readingSample;
  private boolean sampleIsKeyframe;
  private long samplePosition;
  private long sampleTimeUs;
  private H264Reader.SampleReader.SliceHeaderData sliceHeader;
  private final SparseArray<NalUnitUtil.SpsData> sps;
  
  public H264Reader$SampleReader(TrackOutput paramTrackOutput, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.output = paramTrackOutput;
    this.allowNonIdrKeyframes = paramBoolean1;
    this.detectAccessUnits = paramBoolean2;
    this.sps = new SparseArray();
    this.pps = new SparseArray();
    this.previousSliceHeader = new H264Reader.SampleReader.SliceHeaderData(null);
    this.sliceHeader = new H264Reader.SampleReader.SliceHeaderData(null);
    this.buffer = new byte[''];
    this.bitArray = new ParsableNalUnitBitArray(this.buffer, 0, 0);
    reset();
  }
  
  private void outputSample(int paramInt)
  {
    if (this.sampleIsKeyframe) {}
    for (int i = 1;; i = 0)
    {
      int j = (int)(this.nalUnitStartPosition - this.samplePosition);
      this.output.sampleMetadata(this.sampleTimeUs, i, j, paramInt, null);
      return;
    }
  }
  
  public void appendToNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.isFilling) {}
    int i3;
    int i4;
    int i5;
    NalUnitUtil.SpsData localSpsData;
    boolean bool2;
    int i6;
    boolean bool3;
    boolean bool1;
    boolean bool4;
    label403:
    int i1;
    int m;
    int i2;
    int n;
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool5;
            boolean bool6;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          paramInt2 -= paramInt1;
                          if (this.buffer.length < this.bufferLength + paramInt2) {
                            this.buffer = Arrays.copyOf(this.buffer, (this.bufferLength + paramInt2) * 2);
                          }
                          System.arraycopy(paramArrayOfByte, paramInt1, this.buffer, this.bufferLength, paramInt2);
                          this.bufferLength = (paramInt2 + this.bufferLength);
                          this.bitArray.reset(this.buffer, 0, this.bufferLength);
                        } while (!this.bitArray.canReadBits(8));
                        this.bitArray.skipBit();
                        i3 = this.bitArray.readBits(2);
                        this.bitArray.skipBits(5);
                      } while (!this.bitArray.canReadExpGolombCodedNum());
                      this.bitArray.readUnsignedExpGolombCodedInt();
                    } while (!this.bitArray.canReadExpGolombCodedNum());
                    i4 = this.bitArray.readUnsignedExpGolombCodedInt();
                    if (!this.detectAccessUnits)
                    {
                      this.isFilling = false;
                      this.sliceHeader.setSliceType(i4);
                      return;
                    }
                  } while (!this.bitArray.canReadExpGolombCodedNum());
                  i5 = this.bitArray.readUnsignedExpGolombCodedInt();
                  if (this.pps.indexOfKey(i5) < 0)
                  {
                    this.isFilling = false;
                    return;
                  }
                  paramArrayOfByte = (NalUnitUtil.PpsData)this.pps.get(i5);
                  localSpsData = (NalUnitUtil.SpsData)this.sps.get(paramArrayOfByte.seqParameterSetId);
                  if (!localSpsData.separateColorPlaneFlag) {
                    break;
                  }
                } while (!this.bitArray.canReadBits(2));
                this.bitArray.skipBits(2);
              } while (!this.bitArray.canReadBits(localSpsData.frameNumLength));
              bool2 = false;
              bool5 = false;
              bool6 = false;
              i6 = this.bitArray.readBits(localSpsData.frameNumLength);
              bool3 = bool5;
              bool1 = bool6;
              if (localSpsData.frameMbsOnlyFlag) {
                break;
              }
            } while (!this.bitArray.canReadBits(1));
            bool4 = this.bitArray.readBit();
            bool2 = bool4;
            bool3 = bool5;
            bool1 = bool6;
            if (!bool4) {
              break;
            }
          } while (!this.bitArray.canReadBits(1));
          bool1 = this.bitArray.readBit();
          bool3 = true;
          bool2 = bool4;
          if (this.nalUnitType != 5) {
            break label588;
          }
          bool4 = true;
          paramInt1 = 0;
          if (!bool4) {
            break;
          }
        } while (!this.bitArray.canReadExpGolombCodedNum());
        paramInt1 = this.bitArray.readUnsignedExpGolombCodedInt();
        i1 = 0;
        m = 0;
        i2 = 0;
        n = 0;
        if (localSpsData.picOrderCountType != 0) {
          break label594;
        }
      } while (!this.bitArray.canReadBits(localSpsData.picOrderCntLsbLength));
      i1 = this.bitArray.readBits(localSpsData.picOrderCntLsbLength);
      i = i1;
      j = m;
      paramInt2 = i2;
      k = n;
      if (!paramArrayOfByte.bottomFieldPicOrderInFramePresentFlag) {
        break;
      }
      i = i1;
      j = m;
      paramInt2 = i2;
      k = n;
      if (bool2) {
        break;
      }
    } while (!this.bitArray.canReadExpGolombCodedNum());
    int j = this.bitArray.readSignedExpGolombCodedInt();
    int k = n;
    paramInt2 = i2;
    int i = i1;
    for (;;)
    {
      this.sliceHeader.setAll(localSpsData, i3, i4, i6, i5, bool2, bool3, bool1, bool4, paramInt1, i, j, paramInt2, k);
      this.isFilling = false;
      return;
      label588:
      bool4 = false;
      break label403;
      label594:
      i = i1;
      j = m;
      paramInt2 = i2;
      k = n;
      if (localSpsData.picOrderCountType == 1)
      {
        i = i1;
        j = m;
        paramInt2 = i2;
        k = n;
        if (!localSpsData.deltaPicOrderAlwaysZeroFlag)
        {
          if (!this.bitArray.canReadExpGolombCodedNum()) {
            break;
          }
          i2 = this.bitArray.readSignedExpGolombCodedInt();
          i = i1;
          j = m;
          paramInt2 = i2;
          k = n;
          if (paramArrayOfByte.bottomFieldPicOrderInFramePresentFlag)
          {
            i = i1;
            j = m;
            paramInt2 = i2;
            k = n;
            if (!bool2)
            {
              if (!this.bitArray.canReadExpGolombCodedNum()) {
                break;
              }
              k = this.bitArray.readSignedExpGolombCodedInt();
              i = i1;
              j = m;
              paramInt2 = i2;
            }
          }
        }
      }
    }
  }
  
  public void endNalUnit(long paramLong, int paramInt)
  {
    int i = 0;
    if ((this.nalUnitType == 9) || ((this.detectAccessUnits) && (H264Reader.SampleReader.SliceHeaderData.access$100(this.sliceHeader, this.previousSliceHeader))))
    {
      if (this.readingSample) {
        outputSample((int)(paramLong - this.nalUnitStartPosition) + paramInt);
      }
      this.samplePosition = this.nalUnitStartPosition;
      this.sampleTimeUs = this.nalUnitTimeUs;
      this.sampleIsKeyframe = false;
      this.readingSample = true;
    }
    int j = this.sampleIsKeyframe;
    if (this.nalUnitType != 5)
    {
      paramInt = i;
      if (this.allowNonIdrKeyframes)
      {
        paramInt = i;
        if (this.nalUnitType == 1)
        {
          paramInt = i;
          if (!this.sliceHeader.isISlice()) {}
        }
      }
    }
    else
    {
      paramInt = 1;
    }
    this.sampleIsKeyframe = (paramInt | j);
  }
  
  public boolean needsSpsPps()
  {
    return this.detectAccessUnits;
  }
  
  public void putPps(NalUnitUtil.PpsData paramPpsData)
  {
    this.pps.append(paramPpsData.picParameterSetId, paramPpsData);
  }
  
  public void putSps(NalUnitUtil.SpsData paramSpsData)
  {
    this.sps.append(paramSpsData.seqParameterSetId, paramSpsData);
  }
  
  public void reset()
  {
    this.isFilling = false;
    this.readingSample = false;
    this.sliceHeader.clear();
  }
  
  public void startNalUnit(long paramLong1, int paramInt, long paramLong2)
  {
    this.nalUnitType = paramInt;
    this.nalUnitTimeUs = paramLong2;
    this.nalUnitStartPosition = paramLong1;
    if (((this.allowNonIdrKeyframes) && (this.nalUnitType == 1)) || ((this.detectAccessUnits) && ((this.nalUnitType == 5) || (this.nalUnitType == 1) || (this.nalUnitType == 2))))
    {
      H264Reader.SampleReader.SliceHeaderData localSliceHeaderData = this.previousSliceHeader;
      this.previousSliceHeader = this.sliceHeader;
      this.sliceHeader = localSliceHeaderData;
      this.sliceHeader.clear();
      this.bufferLength = 0;
      this.isFilling = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader
 * JD-Core Version:    0.7.0.1
 */