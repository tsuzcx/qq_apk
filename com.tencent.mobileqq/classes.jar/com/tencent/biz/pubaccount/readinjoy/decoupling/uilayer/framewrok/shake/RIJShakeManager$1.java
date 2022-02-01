package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.shake;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.Builder;
import com.tencent.biz.pubaccount.readinjoy.notecard.ReadInJoyNoteCardUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ScripCmsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;

class RIJShakeManager$1
  extends ShakeListener
{
  RIJShakeManager$1(RIJShakeManager paramRIJShakeManager) {}
  
  public void a()
  {
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (ReadInJoyNoteCardUtil.a(RIJShakeManager.a(this.a).a().a(), str) < ScripCmsInfo.d)
    {
      ((ReadInJoyXListView)RIJShakeManager.a(this.a).a().a().a()).c(6);
      return;
    }
    QQToast.a(RIJShakeManager.a(this.a).a().a(), 0, RIJShakeManager.a(this.a).a().a().getString(2131718404), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.shake.RIJShakeManager.1
 * JD-Core Version:    0.7.0.1
 */