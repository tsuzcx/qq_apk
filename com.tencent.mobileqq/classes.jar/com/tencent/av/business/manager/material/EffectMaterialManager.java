package com.tencent.av.business.manager.material;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.av.business.processor.Avatar2dConfigFileProcessor;
import com.tencent.av.business.processor.BaseConfigFileProcessor;
import com.tencent.av.business.processor.FaceConfigFileProcessor;
import com.tencent.av.business.processor.PendantConfigFileProcessor;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.av.ui.effect.data.MaterialCategory;
import com.tencent.mobileqq.shortvideo.common.Observable;
import com.tencent.mobileqq.shortvideo.common.Observer;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class EffectMaterialManager
  extends BusinessManager
{
  private final Object d = new Object();
  private String e = "0";
  private Observable f;
  private int g = 1;
  private String h;
  private List<QavListItemBase.ItemInfo> i = new ArrayList(19);
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private boolean p = false;
  private HashMap<Integer, BaseConfigFileProcessor<? extends ItemBase>> q = new HashMap();
  
  public EffectMaterialManager(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private QavListItemBase.ItemInfo a(String paramString, List<MaterialCategory> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      QavListItemBase.ItemInfo localItemInfo;
      do
      {
        paramList = paramList.iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!paramList.hasNext()) {
              break;
            }
            localObject = (MaterialCategory)paramList.next();
          } while ((((MaterialCategory)localObject).d == null) || (((MaterialCategory)localObject).d.size() <= 0));
          localObject = ((MaterialCategory)localObject).d.iterator();
        }
        localItemInfo = (QavListItemBase.ItemInfo)((Iterator)localObject).next();
      } while (!paramString.equals(localItemInfo.a));
      return localItemInfo;
    }
    return null;
  }
  
  private void w()
  {
    if (this.p) {
      return;
    }
    this.q.put(Integer.valueOf(1), new PendantConfigFileProcessor(this.c));
    this.q.put(Integer.valueOf(2), new FaceConfigFileProcessor(this.c));
    this.q.put(Integer.valueOf(3), new Avatar2dConfigFileProcessor(this.c));
    this.p = true;
  }
  
  public BaseConfigFileProcessor<? extends ItemBase> a(int paramInt)
  {
    if (!this.p) {
      w();
    }
    BaseConfigFileProcessor localBaseConfigFileProcessor = (BaseConfigFileProcessor)this.q.get(Integer.valueOf(paramInt));
    if (localBaseConfigFileProcessor == null) {
      QLog.e("EffectMaterialManager", 1, "getConfigFileProcessor: invalid processor");
    }
    return localBaseConfigFileProcessor;
  }
  
  public ArrayList<QavListItemBase.ItemInfo> a(Context arg1, String paramString, List<MaterialCategory> paramList)
  {
    ??? = SharedPreUtils.K(???, this.c.getCurrentAccountUin()).getString(paramString, null);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("loadRecentMaterial list = ");
      paramString.append(???);
      QLog.i("EffectMaterialManager", 2, paramString.toString());
    }
    if (TextUtils.isEmpty(???)) {
      return null;
    }
    paramString = ???.split("\\$");
    ArrayList localArrayList;
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        return null;
      }
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      int i1;
      synchronized (this.d)
      {
        int i2 = paramString.length;
        i1 = 0;
        if (i1 < i2)
        {
          Object localObject = paramString[i1];
          if (paramString == null) {
            break label190;
          }
          localObject = a((String)localObject, paramList);
          if ((localObject == null) || (a(localArrayList, (QavListItemBase.ItemInfo)localObject)) || (((QavListItemBase.ItemInfo)localObject).a.equals("0"))) {
            break label190;
          }
          localArrayList.add(localObject);
          break label190;
        }
        return localArrayList;
      }
      return null;
      label190:
      i1 += 1;
    }
  }
  
  protected void a()
  {
    w();
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 3) {
      return;
    }
    c(1);
  }
  
  public void a(Observer paramObserver)
  {
    try
    {
      if (this.f != null) {
        this.f.a(paramObserver);
      }
      return;
    }
    finally
    {
      paramObserver = finally;
      throw paramObserver;
    }
  }
  
  public void a(Observer paramObserver, int paramInt)
  {
    try
    {
      if (this.f == null) {
        this.f = new Observable();
      }
      this.f.a(paramObserver, new int[] { paramInt });
      return;
    }
    finally {}
  }
  
  public void a(List<QavListItemBase.ItemInfo> paramList)
  {
    this.i = paramList;
  }
  
  protected boolean a(String paramString)
  {
    return false;
  }
  
  public boolean a(ArrayList<QavListItemBase.ItemInfo> paramArrayList, QavListItemBase.ItemInfo paramItemInfo)
  {
    if (paramItemInfo == null) {
      return true;
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return false;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (((QavListItemBase.ItemInfo)paramArrayList.next()).a.equals(paramItemInfo.a)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public String b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentSelectPendantMaterialId id : ");
      localStringBuilder.append(this.h);
      QLog.i("EffectMaterialManager", 2, localStringBuilder.toString());
    }
    return this.h;
  }
  
  public void b(Context paramContext, String paramString, List<QavListItemBase.ItemInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      synchronized (this.d)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QavListItemBase.ItemInfo localItemInfo = (QavListItemBase.ItemInfo)paramList.next();
          if ((!TextUtils.isEmpty(localItemInfo.a)) && (!localItemInfo.a.equals("0")))
          {
            localStringBuilder.append(localItemInfo.a);
            localStringBuilder.append("$");
          }
        }
        if (TextUtils.isEmpty(localStringBuilder.toString())) {
          return;
        }
        if (QLog.isColorLevel())
        {
          paramList = new StringBuilder();
          paramList.append("saveRecentMaterial list=");
          paramList.append(localStringBuilder.toString());
          QLog.d("EffectMaterialManager", 2, paramList.toString());
        }
        SharedPreUtils.K(paramContext, this.c.getCurrentAccountUin()).edit().putString(paramString, localStringBuilder.toString()).commit();
        return;
      }
    }
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentSelectPendantMaterialId id : ");
      localStringBuilder.append(paramString);
      QLog.i("EffectMaterialManager", 2, localStringBuilder.toString());
    }
    this.h = paramString;
  }
  
  public boolean b(int paramInt)
  {
    return paramInt == 1;
  }
  
  public List<QavListItemBase.ItemInfo> c()
  {
    return this.i;
  }
  
  public void c(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentSelectDoublePendantMaterialId id : ");
      localStringBuilder.append(paramString);
      QLog.i("EffectMaterialManager", 2, localStringBuilder.toString());
    }
    this.l = paramString;
  }
  
  public String d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurrentSelectDoublePendantMaterialId id : ");
      localStringBuilder.append(this.l);
      QLog.i("EffectMaterialManager", 2, localStringBuilder.toString());
    }
    return this.l;
  }
  
  public void d(String paramString)
  {
    this.j = paramString;
  }
  
  public String e()
  {
    return this.j;
  }
  
  public void e(String paramString)
  {
    this.k = paramString;
  }
  
  public String f()
  {
    return this.k;
  }
  
  public void f(String paramString)
  {
    this.m = paramString;
  }
  
  public String g()
  {
    return this.m;
  }
  
  public void g(String paramString)
  {
    this.n = paramString;
  }
  
  public String h()
  {
    return this.n;
  }
  
  public void h(String paramString)
  {
    this.o = paramString;
  }
  
  public String i()
  {
    return this.o;
  }
  
  public void i(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveAvatar2dBg id : ");
      localStringBuilder.append(paramString);
      QLog.i("EffectMaterialManager", 2, localStringBuilder.toString());
    }
    this.e = paramString;
  }
  
  public void j()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(2, new Object[] { null });
    }
  }
  
  public void k()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(4, new Object[] { null });
    }
  }
  
  public void l()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(5, new Object[] { null });
    }
  }
  
  public void m()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(6, new Object[] { null });
    }
  }
  
  public void n()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(7, new Object[] { null });
    }
  }
  
  public void o()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(8, new Object[] { null });
    }
  }
  
  public void p()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(1, new Object[] { null });
    }
  }
  
  public void q()
  {
    Observable localObservable = this.f;
    if (localObservable != null) {
      localObservable.a(3, new Object[] { null });
    }
  }
  
  public String r()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAvatar2dBg id : ");
      localStringBuilder.append(this.e);
      QLog.i("EffectMaterialManager", 2, localStringBuilder.toString());
    }
    return this.e;
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectMaterialManager", 2, "resetAvatar2dBg");
    }
    this.e = "0";
  }
  
  public boolean t()
  {
    return SharedPreUtils.K(this.c.getApplicationContext(), this.c.getCurrentAccountUin()).getBoolean("is_first_open_avatar2d_use_camera", true);
  }
  
  public void u()
  {
    SharedPreUtils.K(this.c.getApplicationContext(), this.c.getCurrentAccountUin()).edit().putBoolean("is_first_open_avatar2d_use_camera", false);
  }
  
  public int v()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.material.EffectMaterialManager
 * JD-Core Version:    0.7.0.1
 */