package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import nxv;
import sdf;
import sgj;

class ReadinjoySubscriptManagerActivity$2
  implements Runnable
{
  ReadinjoySubscriptManagerActivity$2(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public void run()
  {
    Object localObject = sdf.a().c(this.this$0.app);
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublicAccountInfo localPublicAccountInfo = (PublicAccountInfo)((Iterator)localObject).next();
        nxv localnxv = new nxv(this.this$0, null);
        nxv.a(localnxv, localPublicAccountInfo.getUin());
        nxv.b(localnxv, localPublicAccountInfo.name);
        nxv.c(localnxv, ChnToSpell.a(nxv.b(localnxv), 2));
        if (sgj.b(this.this$0.app, localPublicAccountInfo.getUin())) {
          localArrayList2.add(localnxv);
        } else {
          localArrayList1.add(localnxv);
        }
      }
    }
    Collections.sort(localArrayList1, ReadinjoySubscriptManagerActivity.a(this.this$0));
    Collections.sort(localArrayList2, ReadinjoySubscriptManagerActivity.a(this.this$0));
    localArrayList2.addAll(localArrayList1);
    ThreadManager.getUIHandler().post(new ReadinjoySubscriptManagerActivity.2.1(this, localArrayList2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.2
 * JD-Core Version:    0.7.0.1
 */