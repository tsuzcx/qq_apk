package com.tencent.kingkong;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.ArrayList;
import java.util.Iterator;

public class MainConfig
{
  private static MainConfig jdField_a_of_type_ComTencentKingkongMainConfig;
  private SharedPreferences.Editor jdField_a_of_type_AndroidContentSharedPreferences$Editor = null;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences = null;
  public String a;
  private ArrayList<PatchInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private MainConfig()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  private MainConfig(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "";
    int i = 0;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    paramContext = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("PATCH_LIST", "").split(";");
    int j = paramContext.length;
    while (i < j)
    {
      Object localObject = paramContext[i];
      if (!((String)localObject).equals(""))
      {
        localObject = new PatchInfo(this.jdField_a_of_type_AndroidContentSharedPreferences, (String)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--> ");
        localStringBuilder.append(localObject);
        Common.Log.a("KingKongMainConfig", localStringBuilder.toString());
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
      }
      i += 1;
    }
  }
  
  public static MainConfig a(Context paramContext)
  {
    MainConfig localMainConfig = jdField_a_of_type_ComTencentKingkongMainConfig;
    if (localMainConfig != null) {
      return localMainConfig;
    }
    try
    {
      if (jdField_a_of_type_ComTencentKingkongMainConfig != null)
      {
        paramContext = jdField_a_of_type_ComTencentKingkongMainConfig;
        return paramContext;
      }
      jdField_a_of_type_ComTencentKingkongMainConfig = new MainConfig(paramContext);
      paramContext = jdField_a_of_type_ComTencentKingkongMainConfig;
      return paramContext;
    }
    finally {}
  }
  
  private void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    StringBuilder localStringBuilder;
    for (String str = ""; localIterator.hasNext(); str = localStringBuilder.toString())
    {
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(localPatchInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(";");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.putString("PATCH_LIST", str);
    this.jdField_a_of_type_AndroidContentSharedPreferences$Editor.commit();
  }
  
  public PatchInfo a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (localPatchInfo.jdField_a_of_type_JavaLangString.equals(paramString)) {
        return localPatchInfo;
      }
    }
    return null;
  }
  
  public ArrayList<PatchInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(PatchInfo paramPatchInfo)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((PatchInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString.equals(paramPatchInfo.jdField_a_of_type_JavaLangString)) {
        break label49;
      }
      i += 1;
    }
    i = -1;
    label49:
    if (i != -1)
    {
      this.jdField_a_of_type_JavaUtilArrayList.set(i, paramPatchInfo);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramPatchInfo);
      a();
    }
    paramPatchInfo.b(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      PatchInfo localPatchInfo = (PatchInfo)localIterator.next();
      if (localPatchInfo.jdField_a_of_type_JavaLangString.equals(paramString))
      {
        localPatchInfo.a(this.jdField_a_of_type_AndroidContentSharedPreferences$Editor);
        this.jdField_a_of_type_JavaUtilArrayList.remove(localPatchInfo);
      }
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.MainConfig
 * JD-Core Version:    0.7.0.1
 */