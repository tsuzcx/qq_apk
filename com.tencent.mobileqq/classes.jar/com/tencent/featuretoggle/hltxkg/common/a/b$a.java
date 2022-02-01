package com.tencent.featuretoggle.hltxkg.common.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class b$a
{
  Integer jdField_a_of_type_JavaLangInteger;
  String jdField_a_of_type_JavaLangString;
  List<a> jdField_a_of_type_JavaUtilList = new ArrayList();
  String b;
  String c;
  private String d;
  
  public b$a(String paramString)
  {
    this.d = paramString;
  }
  
  public final void a(a parama)
  {
    if (parama == null) {
      return;
    }
    if (parama.b() > 0)
    {
      if (parama.b() > 5) {
        return;
      }
      this.jdField_a_of_type_JavaUtilList.add(parama);
    }
  }
  
  public final void b(a parama)
  {
    if (parama == null) {
      return;
    }
    try
    {
      if (((parama.b() == 1) || (parama.b() == 2)) && (this.jdField_a_of_type_JavaUtilList.contains(parama))) {
        this.jdField_a_of_type_JavaUtilList.remove(parama);
      }
      return;
    }
    finally {}
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder("Appid：");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangInteger);
    ((StringBuilder)localObject).append(" domain：");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("\r\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder("apn：");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" ckIP：");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("\r\n");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((List)localObject).addAll(this.jdField_a_of_type_JavaUtilList);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      a locala = (a)((Iterator)localObject).next();
      StringBuilder localStringBuilder2 = new StringBuilder("accessIP：");
      localStringBuilder2.append(locala.toString());
      localStringBuilder2.append("\r\n");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.a.b.a
 * JD-Core Version:    0.7.0.1
 */