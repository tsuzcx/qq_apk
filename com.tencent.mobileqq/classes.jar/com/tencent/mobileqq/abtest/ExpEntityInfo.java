package com.tencent.mobileqq.abtest;

import com.tencent.mtt.abtestsdk.ABTestApi;
import com.tencent.mtt.abtestsdk.entity.RomaExpEntity;
import java.util.ArrayList;
import java.util.List;

public class ExpEntityInfo
  extends RomaExpEntity
{
  public String a;
  public List<String> a;
  public String b;
  
  public ExpEntityInfo(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    setExpName(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString3;
  }
  
  public ExpEntityInfo(String paramString, List<String> paramList)
  {
    super(paramString);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    setExpName(paramString);
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
  }
  
  public String a()
  {
    Object localObject = getParams();
    String str = super.toString();
    if (localObject != null) {}
    for (localObject = localObject.toString();; localObject = "") {
      return String.format("%s  params:%s", new Object[] { str, localObject });
    }
  }
  
  public void a()
  {
    if (isDefaultRomaExp()) {
      return;
    }
    ABTestApi.reportExpExpose(this);
  }
  
  public void a(RomaExpEntity paramRomaExpEntity)
  {
    if ((paramRomaExpEntity == null) || (!getExpName().equalsIgnoreCase(paramRomaExpEntity.getExpName()))) {
      return;
    }
    setAssignment(paramRomaExpEntity.getAssignment());
    setPercentage(paramRomaExpEntity.getPercentage());
    setBucket(paramRomaExpEntity.getBucket());
    setGrayId(paramRomaExpEntity.getGrayId());
    setParams(paramRomaExpEntity.getParams());
    setEndTime(paramRomaExpEntity.getEndTime());
    setExpName(paramRomaExpEntity.getExpName());
    setLayerCode(paramRomaExpEntity.getLayerCode());
  }
  
  public boolean a()
  {
    return (!isDefaultRomaExp()) && (this.b.equalsIgnoreCase(getAssignment()));
  }
  
  public boolean b()
  {
    return (!isDefaultRomaExp()) && (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(getAssignment()));
  }
  
  public boolean c()
  {
    return !isDefaultRomaExp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.abtest.ExpEntityInfo
 * JD-Core Version:    0.7.0.1
 */