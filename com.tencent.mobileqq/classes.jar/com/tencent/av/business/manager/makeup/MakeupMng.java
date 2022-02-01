package com.tencent.av.business.manager.makeup;

import android.text.TextUtils;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectMutexManager;
import com.tencent.av.business.manager.pendant.EffectPendantBase;
import com.tencent.av.business.manager.pendant.EffectPendantBase.Pendant;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MakeupMng
  extends EffectPendantBase
{
  public static final String[] b;
  public final ConcurrentHashMap<String, Integer> a;
  public int b;
  public String b;
  private int c;
  
  static
  {
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "params.dat" };
  }
  
  public MakeupMng(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_ArrayOfJavaLangString = jdField_b_of_type_ArrayOfJavaLangString;
  }
  
  public int a()
  {
    return 591;
  }
  
  public int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramString = (Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } else {
      paramString = null;
    }
    if (paramString == null) {
      return 50;
    }
    return paramString.intValue();
  }
  
  public EffectPendantBase.Pendant a(int paramInt1, int paramInt2)
  {
    if (this.jdField_c_of_type_Int == 3002) {
      a(0L, "getVideoPendant");
    }
    EffectPendantBase.Pendant localPendant = super.a(paramInt1, paramInt2);
    if ((localPendant != null) && (localPendant.a != null)) {
      localPendant.a.extraParam = Integer.valueOf(this.jdField_b_of_type_Int);
    }
    return localPendant;
  }
  
  protected List<PendantItem> a(int paramInt, String paramString)
  {
    Object localObject1 = super.a(paramInt, paramString);
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (PendantItem)((Iterator)localObject1).next();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parse, cid[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], config[");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("], size[");
      ((StringBuilder)localObject2).append(localArrayList.size());
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return localArrayList;
  }
  
  public void a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MuteByOthers, fromMuteKey[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], data[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 4, localStringBuilder.toString());
    }
    if (paramInt == 3004) {
      return;
    }
    if (paramInt == 3002)
    {
      if (this.jdField_c_of_type_Int == 3003) {
        a(l, this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_c_of_type_Int = 3002;
      return;
    }
    if (paramInt == 3003) {
      return;
    }
    if (paramInt == 3005)
    {
      this.jdField_c_of_type_Int = 3005;
      a(l, null);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearMuteFlag, muteFlag[");
      localStringBuilder.append(this.jdField_c_of_type_Int);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], cur[");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("], value[");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("]");
      QLog.i(str, 4, localStringBuilder.toString());
    }
    int i = this.jdField_c_of_type_Int;
    if ((i == 3003) || (i == 3005)) {
      a(paramLong, this.jdField_b_of_type_JavaLangString);
    }
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (b()) {
      return;
    }
    if ((!TextUtils.equals(paramString, this.jdField_b_of_type_JavaLangString)) || (paramInt != this.jdField_b_of_type_Int))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_Int = paramInt;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(this.jdField_b_of_type_JavaLangString, Integer.valueOf(paramInt));
      }
    }
  }
  
  protected void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    Object localObject = (PendantItem)a();
    if (localObject == null)
    {
      this.jdField_b_of_type_JavaLangString = null;
      this.jdField_b_of_type_Int = 50;
    }
    else
    {
      this.jdField_b_of_type_JavaLangString = ((PendantItem)localObject).getId();
    }
    if (QLog.isColorLevel())
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyUI, peerUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], quit[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], item[");
      localStringBuilder.append(a());
      localStringBuilder.append("]");
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
  }
  
  public boolean a(long paramLong, PendantItem paramPendantItem)
  {
    boolean bool = super.a(paramLong, paramPendantItem);
    if ((!b()) && (bool) && (paramPendantItem != null) && (!TextUtils.isEmpty(paramPendantItem.getId())) && (!TextUtils.equals("0", paramPendantItem.getId())))
    {
      EffectMutexManager localEffectMutexManager = (EffectMutexManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
      if (localEffectMutexManager != null) {
        localEffectMutexManager.a(3004, paramPendantItem.getId());
      }
    }
    return bool;
  }
  
  public int b()
  {
    return 3004;
  }
  
  public boolean b()
  {
    int i = this.jdField_c_of_type_Int;
    return (i == 3002) || (i == 3003);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.makeup.MakeupMng
 * JD-Core Version:    0.7.0.1
 */