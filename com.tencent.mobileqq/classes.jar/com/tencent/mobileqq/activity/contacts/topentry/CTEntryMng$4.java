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
    if ((paramList != null) && (paramList.size() > 0))
    {
      ((CTEntry)localObject2).jdField_a_of_type_JavaLangString = CTEntryMng.a(this.a).getApp().getResources().getString(2131699007);
      ((CTEntry)localObject2).b = "";
      ((CTEntry)localObject2).jdField_a_of_type_JavaLangObject = paramList;
    }
    else
    {
      ((CTEntry)localObject2).jdField_a_of_type_JavaLangObject = null;
      ((CTEntry)localObject2).b = null;
    }
    Object localObject3 = (MayknowRecommendManager)CTEntryMng.a(this.a).getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    int i = 0;
    boolean bool2;
    boolean bool1;
    if (localObject3 != null)
    {
      bool2 = ((MayknowRecommendManager)localObject3).b("sp_mayknow_entry_list_recommend");
      bool1 = ((MayknowRecommendManager)localObject3).b("sp_mayknow_entry_list_head");
    }
    else
    {
      bool1 = true;
      bool2 = false;
    }
    if ((bool1) && (!bool2)) {
      ((CTEntry)localObject2).c = true;
    } else {
      ((CTEntry)localObject2).c = false;
    }
    CTEntryMng.a(this.a);
    if (QLog.isColorLevel())
    {
      localObject3 = Locale.getDefault();
      bool1 = ((CTEntry)localObject2).c;
      Object localObject4 = ((CTEntry)localObject2).jdField_a_of_type_JavaLangObject;
      localObject2 = ((CTEntry)localObject2).b;
      if (paramList != null) {
        i = paramList.size();
      }
      QLog.i("CTEntryMng", 2, String.format((Locale)localObject3, "updateMayKnow pre: [%s,%s], cur: [%s,%s], subtitle: %s recommends:%s", new Object[] { Boolean.valueOf(bool3), localObject1, Boolean.valueOf(bool1), localObject4, localObject2, Integer.valueOf(i) }));
    }
  }
  
  public boolean a()
  {
    CTEntry localCTEntry = this.a.a(3);
    CTEntryMng.EntryUserSetting localEntryUserSetting = this.a.a(3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isMayKnowEntryShown, canBeShown = ");
      localStringBuilder.append(localCTEntry.c);
      localStringBuilder.append(", flagValue = ");
      localStringBuilder.append(localEntryUserSetting.b);
      QLog.d("CTEntryMng", 2, localStringBuilder.toString());
    }
    return (localCTEntry.c) && (localEntryUserSetting.b == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng.4
 * JD-Core Version:    0.7.0.1
 */