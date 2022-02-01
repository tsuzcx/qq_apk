package com.tencent.mobileqq.activity.contacts.topentry;

import android.content.res.Resources;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Locale;

class CTEntryMng$4
  implements CardViewController.MayKnowListener
{
  CTEntryMng$4(CTEntryMng paramCTEntryMng) {}
  
  public void a(List<MayKnowRecommend> paramList)
  {
    Object localObject2 = this.a.a(3);
    boolean bool3 = ((CTEntry)localObject2).c;
    Object localObject1 = ((CTEntry)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject3;
    boolean bool2;
    boolean bool1;
    if ((paramList != null) && (paramList.size() > 0))
    {
      ((CTEntry)localObject2).jdField_a_of_type_JavaLangString = CTEntryMng.a(this.a).getApp().getResources().getString(2131698928);
      ((CTEntry)localObject2).b = "";
      ((CTEntry)localObject2).jdField_a_of_type_JavaLangObject = paramList;
      localObject3 = (MayknowRecommendManager)CTEntryMng.a(this.a).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if (localObject3 == null) {
        break label262;
      }
      bool2 = ((MayknowRecommendManager)localObject3).b("sp_mayknow_entry_list_recommend");
      bool1 = ((MayknowRecommendManager)localObject3).b("sp_mayknow_entry_list_head");
    }
    for (;;)
    {
      label128:
      Object localObject4;
      if ((bool1) && (!bool2))
      {
        ((CTEntry)localObject2).c = true;
        CTEntryMng.a(this.a);
        if (QLog.isColorLevel())
        {
          localObject3 = Locale.getDefault();
          bool1 = ((CTEntry)localObject2).c;
          localObject4 = ((CTEntry)localObject2).jdField_a_of_type_JavaLangObject;
          localObject2 = ((CTEntry)localObject2).b;
          if (paramList == null) {
            break label257;
          }
        }
      }
      label257:
      for (int i = paramList.size();; i = 0)
      {
        QLog.i("CTEntryMng", 2, String.format((Locale)localObject3, "updateMayKnow pre: [%s,%s], cur: [%s,%s], subtitle: %s recommends:%s", new Object[] { Boolean.valueOf(bool3), localObject1, Boolean.valueOf(bool1), localObject4, localObject2, Integer.valueOf(i) }));
        return;
        ((CTEntry)localObject2).jdField_a_of_type_JavaLangObject = null;
        ((CTEntry)localObject2).b = null;
        break;
        ((CTEntry)localObject2).c = false;
        break label128;
      }
      label262:
      bool1 = true;
      bool2 = false;
    }
  }
  
  public boolean a()
  {
    CTEntry localCTEntry = this.a.a(3);
    CTEntryMng.EntryUserSetting localEntryUserSetting = this.a.a(3);
    if (QLog.isColorLevel()) {
      QLog.d("CTEntryMng", 2, "isMayKnowEntryShown, canBeShown = " + localCTEntry.c + ", flagValue = " + localEntryUserSetting.b);
    }
    return (localCTEntry.c) && (localEntryUserSetting.b == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.4
 * JD-Core Version:    0.7.0.1
 */