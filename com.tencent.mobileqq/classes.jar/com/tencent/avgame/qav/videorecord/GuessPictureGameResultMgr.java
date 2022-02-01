package com.tencent.avgame.qav.videorecord;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuessPictureGameResultMgr
{
  public GuessPictureGamePaintLogic a;
  public String a;
  private List<ArrayList<GameImageData>> a;
  public boolean a;
  public String b;
  private volatile boolean b;
  private boolean c;
  private boolean d;
  
  public GuessPictureGameResultMgr()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      QLog.d("GuessPictureGameResultMgr", 1, "generateVideoPhoto, gameImageDataCache is empty");
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList2 = (ArrayList)localIterator.next();
      if (!((GameImageData)localArrayList2.get(0)).jdField_a_of_type_Boolean) {
        localArrayList1.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilList.indexOf(localArrayList2)));
      }
    }
    double d1;
    double d2;
    int i;
    if (localArrayList1.isEmpty())
    {
      d1 = Math.random();
      d2 = this.jdField_a_of_type_JavaUtilList.size();
      Double.isNaN(d2);
      i = (int)(d1 * d2);
    }
    else
    {
      d1 = Math.random();
      d2 = localArrayList1.size();
      Double.isNaN(d2);
      i = ((Integer)localArrayList1.get((int)(d1 * d2))).intValue();
    }
    if (!a((ArrayList)this.jdField_a_of_type_JavaUtilList.get(i))) {
      this.jdField_b_of_type_JavaLangString = null;
    }
  }
  
  private boolean a(ArrayList<GameImageData> paramArrayList)
  {
    boolean bool2 = paramArrayList.isEmpty();
    boolean bool1 = false;
    if ((!bool2) && (((GameImageData)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsBitmap != null))
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a, this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.b, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a(localCanvas, (GameImageData)paramArrayList.get(0), false);
        if ((paramArrayList.size() > 1) && (((GameImageData)paramArrayList.get(1)).jdField_b_of_type_JavaLangString.equals("Tips"))) {
          this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.b(localCanvas, (GameImageData)paramArrayList.get(1), false);
        }
        bool2 = FileUtil.a(localBitmap, this.jdField_b_of_type_JavaLangString);
        try
        {
          localBitmap.recycle();
          QLog.d("GuessPictureGameResultMgr", 1, new Object[] { "generateVideoPhoto, ret:", Boolean.valueOf(bool2) });
          return bool2;
        }
        catch (Exception paramArrayList)
        {
          bool1 = bool2;
        }
        QLog.e("GuessPictureGameResultMgr", 1, "generateVideoPhoto fail", paramArrayList);
      }
      catch (Exception paramArrayList) {}
      return bool1;
    }
    QLog.d("GuessPictureGameResultMgr", 1, "generateVideoPhoto, selectImageData is empty");
    return false;
  }
  
  private void b(ArrayList<GameImageData> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameImageData localGameImageData = (GameImageData)paramArrayList.next();
        if ((!localGameImageData.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) && (!localGameImageData.jdField_b_of_type_JavaLangString.equals("Back Image"))) {
          localGameImageData.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, GuessPictureGamePaintLogic paramGuessPictureGamePaintLogic)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic = paramGuessPictureGamePaintLogic;
  }
  
  public void a(ArrayList<GameImageData> paramArrayList)
  {
    if (paramArrayList != null) {
      try
      {
        if (!paramArrayList.isEmpty())
        {
          int j = 0;
          int i = 0;
          if (((GameImageData)paramArrayList.get(0)).jdField_a_of_type_AndroidGraphicsBitmap != null)
          {
            String str = ((GameImageData)paramArrayList.get(0)).jdField_a_of_type_JavaLangString;
            if ((!str.equals("Mosaic Image")) && (!str.equals("Tips")))
            {
              i = j;
              if (this.jdField_b_of_type_Boolean)
              {
                i = j;
                if (this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.b())
                {
                  i = j;
                  if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
                  {
                    this.c = true;
                    ((GameImageData)((ArrayList)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).get(0)).jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAvgameQavVideorecordGuessPictureGamePaintLogic.a();
                    i = j;
                  }
                }
              }
            }
            else
            {
              if ((str.equals("Mosaic Image")) && (this.c))
              {
                this.jdField_b_of_type_Boolean = false;
                this.c = false;
              }
              j = i;
              if (!this.jdField_b_of_type_Boolean)
              {
                this.jdField_b_of_type_Boolean = true;
                this.jdField_a_of_type_JavaUtilList.add(paramArrayList);
                j = 1;
              }
              i = j;
              if (str.equals("Tips"))
              {
                i = j;
                if (this.jdField_b_of_type_Boolean)
                {
                  i = j;
                  if (!this.jdField_a_of_type_JavaUtilList.isEmpty())
                  {
                    b((ArrayList)this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1));
                    this.jdField_a_of_type_JavaUtilList.add(paramArrayList);
                    i = 1;
                  }
                }
              }
            }
            if (!this.d)
            {
              this.d = true;
              a(paramArrayList);
            }
            if (i == 0) {
              b(paramArrayList);
            }
            return;
          }
        }
      }
      finally {}
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if ((this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        this.c = true;
        ((GameImageData)((ArrayList)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1)).get(0)).jdField_a_of_type_Boolean = paramBoolean;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (!IGameEngine.k())
    {
      localObject = IGameEngine.a().a();
    }
    else
    {
      QLog.d("GuessPictureGameResultMgr", 2, "gameEngine or data is null");
      localObject = null;
    }
    if ((!paramBoolean) && (localObject != null))
    {
      ((EngineData)localObject).a(null, null, paramLong);
    }
    else if (localObject != null)
    {
      a();
      ((EngineData)localObject).a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, paramLong);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameResultMgr", 2, new Object[] { "saveResult, videoPath:", this.jdField_a_of_type_JavaLangString, " photoPath:", this.jdField_b_of_type_JavaLangString });
    }
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaLangString = null;
    Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject).hasNext()) {
      b((ArrayList)((Iterator)localObject).next());
    }
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GuessPictureGameResultMgr
 * JD-Core Version:    0.7.0.1
 */