package com.tencent.featuretoggle.hltxkg.common.c.a;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.common.a.n;
import com.tencent.featuretoggle.hltxkg.common.c.d;
import com.tencent.featuretoggle.hltxkg.common.c.f;
import com.tencent.featuretoggle.hltxkg.common.c.j;
import com.tencent.featuretoggle.hltxkg.common.platform.ISettingsClient.ISettingUpdateListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends a
  implements d
{
  private n jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAN = new n();
  private List<ISettingsClient.ISettingUpdateListener> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public b()
  {
    com.tencent.featuretoggle.hltxkg.common.a.i().post(new c(this));
  }
  
  private void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public final String a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAN.a(paramString1, paramInt, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final void a(String paramString1, String arg2)
  {
    if ((!TextUtils.isEmpty(???)) && (!com.tencent.featuretoggle.hltxkg.common.c.b.a.b.a().b().equals(???))) {
      com.tencent.featuretoggle.hltxkg.common.c.b.a.b.a().a(???, true);
    }
    if (!TextUtils.isEmpty(paramString1)) {
      synchronized (this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAN)
      {
        this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAN.b();
        this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAN.a(paramString1);
        j.a("settings_in_client", this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonAN.a(), true);
        a();
        return;
      }
    }
  }
  
  public final String b()
  {
    return "settings";
  }
  
  public final void c()
  {
    f.d().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.a.b
 * JD-Core Version:    0.7.0.1
 */