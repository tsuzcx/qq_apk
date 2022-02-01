package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import UserGrowth.stSimpleMetaFeed;
import java.util.ArrayList;

class WSGridDataManager$WSGridRspModel
{
  private ArrayList<stSimpleMetaFeed> a;
  private boolean b;
  
  public ArrayList<stSimpleMetaFeed> a()
  {
    ArrayList localArrayList2 = this.a;
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  public void a(ArrayList<stSimpleMetaFeed> paramArrayList)
  {
    this.a = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridDataManager.WSGridRspModel
 * JD-Core Version:    0.7.0.1
 */