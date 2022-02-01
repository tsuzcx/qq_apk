package com.tencent.biz.qqstory.base;

import com.tencent.biz.qqstory.model.item.RecommendItem;
import com.tencent.biz.qqstory.notification.StoryPushMsg;
import com.tencent.biz.qqstory.pgc.model.UserInfo;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.base.ToastUtil;
import java.util.List;

public class QQStoryObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(byte paramByte) {}
  
  public void a(int paramInt) {}
  
  public void a(StoryPushMsg paramStoryPushMsg) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt, String paramString) {}
  
  public void a(boolean paramBoolean, int paramInt, List<RecommendItem> paramList) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<UserInfo> paramList, boolean paramBoolean2, String paramString, List<String> paramList1) {}
  
  public void a(boolean paramBoolean, QQStoryBanInfo paramQQStoryBanInfo) {}
  
  public void a(boolean paramBoolean, UserInfo paramUserInfo) {}
  
  public void a(boolean paramBoolean, QQStoryUserInfo paramQQStoryUserInfo) {}
  
  public void a(boolean paramBoolean, List<String> paramList) {}
  
  public void a(boolean paramBoolean1, List<QQStoryUserInfo> paramList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    if (!paramBoolean1)
    {
      if (paramBoolean2) {
        paramString = "";
      } else {
        paramString = HardCodeUtil.a(2131898212);
      }
      if (paramInt == 0) {
        paramInt = 2131908581;
      } else {
        paramInt = 2131899712;
      }
      String str = HardCodeUtil.a(paramInt);
      ToastUtil localToastUtil = ToastUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localStringBuilder.append(HardCodeUtil.a(2131908582));
      localToastUtil.a(localStringBuilder.toString());
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void b() {}
  
  public void b(int paramInt) {}
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean) {}
  
  public void d(boolean paramBoolean) {}
  
  public void e(boolean paramBoolean) {}
  
  public void f(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryObserver
 * JD-Core Version:    0.7.0.1
 */