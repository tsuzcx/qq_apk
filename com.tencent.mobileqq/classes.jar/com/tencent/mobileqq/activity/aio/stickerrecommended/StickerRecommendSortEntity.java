package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.util.ArrayList;
import java.util.List;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="usrMessage,recommendType")
public class StickerRecommendSortEntity
  extends Entity
{
  public String clicked;
  @notColumn
  public List<Integer> clickedList = new ArrayList();
  public String exposed;
  @notColumn
  public List<Integer> exposedList = new ArrayList();
  public String noExpose;
  @notColumn
  public List<Integer> noExposeList = new ArrayList();
  public int recommendType;
  public String usrMessage;
  
  public StickerRecommendSortEntity() {}
  
  public StickerRecommendSortEntity(String paramString)
  {
    this.usrMessage = paramString;
  }
  
  public void addClicked(Integer paramInteger)
  {
    this.clickedList.add(0, paramInteger);
  }
  
  public void addExposed(Integer paramInteger)
  {
    this.exposedList.add(paramInteger);
  }
  
  public void addNoExpose(Integer paramInteger)
  {
    this.noExposeList.add(paramInteger);
  }
  
  public void convertToList()
  {
    Object localObject = this.clicked;
    int j = 0;
    int k;
    int i;
    if (localObject != null)
    {
      localObject = ((String)localObject).split(",");
      k = localObject.length;
      i = 0;
    }
    for (;;)
    {
      String str;
      if (i < k) {
        str = localObject[i];
      }
      try
      {
        this.clickedList.add(Integer.valueOf(Integer.parseInt(str)));
        i += 1;
        continue;
        localObject = this.exposed;
        if (localObject != null)
        {
          localObject = ((String)localObject).split(",");
          k = localObject.length;
          i = 0;
          if (i < k) {
            str = localObject[i];
          }
        }
      }
      catch (Exception localException2)
      {
        try
        {
          for (;;)
          {
            this.exposedList.add(Integer.valueOf(Integer.parseInt(str)));
            i += 1;
          }
          localObject = this.noExpose;
          if (localObject != null)
          {
            localObject = ((String)localObject).split(",");
            k = localObject.length;
            i = j;
            if (i < k) {
              str = localObject[i];
            }
          }
        }
        catch (Exception localException2)
        {
          try
          {
            for (;;)
            {
              this.noExposeList.add(Integer.valueOf(Integer.parseInt(str)));
              label181:
              i += 1;
              continue;
              return;
              localException1 = localException1;
            }
            localException2 = localException2;
          }
          catch (Exception localException3)
          {
            break label181;
          }
        }
      }
    }
  }
  
  public void convertToString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    List localList = this.clickedList;
    int j = 0;
    int i;
    if (localList != null)
    {
      i = 0;
      while (i < this.clickedList.size())
      {
        localStringBuilder.append(this.clickedList.get(i));
        if (i < this.clickedList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    this.clicked = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    if (this.exposedList != null)
    {
      i = 0;
      while (i < this.exposedList.size())
      {
        localStringBuilder.append(this.exposedList.get(i));
        if (i < this.exposedList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    this.exposed = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    if (this.noExposeList != null)
    {
      i = j;
      while (i < this.noExposeList.size())
      {
        localStringBuilder.append(this.noExposeList.get(i));
        if (i < this.noExposeList.size() - 1) {
          localStringBuilder.append(",");
        }
        i += 1;
      }
    }
    this.noExpose = localStringBuilder.toString();
  }
  
  public void removeClicked(Integer paramInteger)
  {
    this.clickedList.remove(paramInteger);
  }
  
  public void removeExposed(Integer paramInteger)
  {
    this.exposedList.remove(paramInteger);
  }
  
  public void removeNoExpose(Integer paramInteger)
  {
    this.noExposeList.remove(paramInteger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendSortEntity
 * JD-Core Version:    0.7.0.1
 */