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
  public boolean a;
  public String b;
  public String c;
  public GuessPictureGamePaintLogic d;
  private List<ArrayList<GameImageData>> e = new ArrayList();
  private volatile boolean f;
  private boolean g;
  private boolean h;
  
  private void a()
  {
    if (this.e.isEmpty())
    {
      QLog.d("GuessPictureGameResultMgr", 1, "generateVideoPhoto, gameImageDataCache is empty");
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      ArrayList localArrayList2 = (ArrayList)localIterator.next();
      if (!((GameImageData)localArrayList2.get(0)).i) {
        localArrayList1.add(Integer.valueOf(this.e.indexOf(localArrayList2)));
      }
    }
    double d1;
    double d2;
    int i;
    if (localArrayList1.isEmpty())
    {
      d1 = Math.random();
      d2 = this.e.size();
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
    if (!c((ArrayList)this.e.get(i))) {
      this.c = null;
    }
  }
  
  private void b(ArrayList<GameImageData> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        GameImageData localGameImageData = (GameImageData)paramArrayList.next();
        if ((!localGameImageData.a.isRecycled()) && (!localGameImageData.h.equals("Back Image"))) {
          localGameImageData.a.recycle();
        }
      }
    }
  }
  
  private boolean c(ArrayList<GameImageData> paramArrayList)
  {
    boolean bool2 = paramArrayList.isEmpty();
    boolean bool1 = false;
    if ((!bool2) && (((GameImageData)paramArrayList.get(0)).a != null))
    {
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(this.d.a, this.d.b, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        this.d.a(localCanvas, (GameImageData)paramArrayList.get(0), false);
        if ((paramArrayList.size() > 1) && (((GameImageData)paramArrayList.get(1)).h.equals("Tips"))) {
          this.d.b(localCanvas, (GameImageData)paramArrayList.get(1), false);
        }
        bool2 = FileUtil.a(localBitmap, this.c);
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
  
  public void a(String paramString1, String paramString2, GuessPictureGamePaintLogic paramGuessPictureGamePaintLogic)
  {
    this.a = true;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramGuessPictureGamePaintLogic;
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
          if (((GameImageData)paramArrayList.get(0)).a != null)
          {
            String str = ((GameImageData)paramArrayList.get(0)).g;
            if ((!str.equals("Mosaic Image")) && (!str.equals("Tips")))
            {
              i = j;
              if (this.f)
              {
                i = j;
                if (this.d.b())
                {
                  i = j;
                  if (!this.e.isEmpty())
                  {
                    this.g = true;
                    ((GameImageData)((ArrayList)this.e.get(this.e.size() - 1)).get(0)).i = this.d.a();
                    i = j;
                  }
                }
              }
            }
            else
            {
              if ((str.equals("Mosaic Image")) && (this.g))
              {
                this.f = false;
                this.g = false;
              }
              j = i;
              if (!this.f)
              {
                this.f = true;
                this.e.add(paramArrayList);
                j = 1;
              }
              i = j;
              if (str.equals("Tips"))
              {
                i = j;
                if (this.f)
                {
                  i = j;
                  if (!this.e.isEmpty())
                  {
                    b((ArrayList)this.e.remove(this.e.size() - 1));
                    this.e.add(paramArrayList);
                    i = 1;
                  }
                }
              }
            }
            if (!this.h)
            {
              this.h = true;
              c(paramArrayList);
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
      if ((this.f) && (!this.e.isEmpty()))
      {
        this.g = true;
        ((GameImageData)((ArrayList)this.e.get(this.e.size() - 1)).get(0)).i = paramBoolean;
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
    if (!IGameEngine.J())
    {
      localObject = IGameEngine.I().s();
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
      ((EngineData)localObject).a(this.b, this.c, paramLong);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GuessPictureGameResultMgr", 2, new Object[] { "saveResult, videoPath:", this.b, " photoPath:", this.c });
    }
    this.c = null;
    this.b = null;
    Object localObject = this.e.iterator();
    while (((Iterator)localObject).hasNext()) {
      b((ArrayList)((Iterator)localObject).next());
    }
    this.h = false;
    this.f = false;
    this.g = false;
    this.e.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.videorecord.GuessPictureGameResultMgr
 * JD-Core Version:    0.7.0.1
 */