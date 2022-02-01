package com.tencent.comic.config;

import android.text.TextUtils;

public class QQComicConfBean$WebBundleConfig
{
  public String a;
  public boolean a;
  
  public QQComicConfBean$WebBundleConfig(QQComicConfBean paramQQComicConfBean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebBundleConfig{enable=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", preloadUrl='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean.WebBundleConfig
 * JD-Core Version:    0.7.0.1
 */