package com.tencent.aelight.camera.aeeditor.module.autotemplate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import androidx.annotation.RequiresApi;
import dov.com.qq.im.aeeditor.module.autotemplate.ExtractUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FrameExtractor
{
  public Bitmap a(String paramString, long paramLong)
  {
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = Bitmap.createBitmap(localMediaMetadataRetriever.getFrameAtTime(paramLong, 3));
    localMediaMetadataRetriever.release();
    return paramString;
  }
  
  @RequiresApi(api=17)
  public Bitmap a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      Bitmap localBitmap = ExtractUtil.a.a(paramString, paramLong, paramInt);
      return localBitmap;
    }
    catch (Exception localException)
    {
      label15:
      break label15;
    }
    return a(paramString, paramLong);
  }
  
  public List<Bitmap> a(List<FrameExtractor.MediaWithType> paramList, List<Long> paramList1, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = paramList.iterator();
    long l = 0L;
    while (((Iterator)localObject).hasNext())
    {
      l += ((FrameExtractor.MediaWithType)((Iterator)localObject).next()).jdField_a_of_type_Long;
      localArrayList2.add(Long.valueOf(l));
    }
    if (paramList1 != null)
    {
      if (paramList1.isEmpty()) {
        return localArrayList1;
      }
      paramList1 = new ArrayList(paramList1);
      int k = 0;
      int i = 0;
      while (k < paramList1.size())
      {
        int j = i;
        do
        {
          i = j;
          if (((Long)localArrayList2.get(j)).longValue() > ((Long)paramList1.get(k)).longValue()) {
            break;
          }
          i = j + 1;
          j = i;
        } while (i < localArrayList2.size());
        if (i >= localArrayList2.size()) {
          return localArrayList1;
        }
        if (((Long)localArrayList2.get(i)).longValue() > ((Long)paramList1.get(k)).longValue()) {
          if (((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_Int == 2)
          {
            localObject = new BitmapFactory.Options();
            int m = 1;
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
            BitmapFactory.decodeFile(((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject);
            int n = ((BitmapFactory.Options)localObject).outWidth;
            int i1 = ((BitmapFactory.Options)localObject).outHeight;
            j = m;
            if (paramInt > 0) {
              if (i1 > n)
              {
                j = m;
                if (i1 > paramInt) {
                  j = i1 / paramInt;
                }
              }
              else
              {
                j = m;
                if (n > paramInt) {
                  j = n / paramInt;
                }
              }
            }
            localObject = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
            ((BitmapFactory.Options)localObject).inSampleSize = j;
            localArrayList1.add(BitmapFactory.decodeFile(((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject));
          }
          else if (Build.VERSION.SDK_INT >= 17)
          {
            localArrayList1.add(a(((FrameExtractor.MediaWithType)paramList.get(i)).jdField_a_of_type_JavaLangString, ((Long)paramList1.get(k)).longValue(), paramInt));
          }
        }
        k += 1;
      }
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.autotemplate.FrameExtractor
 * JD-Core Version:    0.7.0.1
 */