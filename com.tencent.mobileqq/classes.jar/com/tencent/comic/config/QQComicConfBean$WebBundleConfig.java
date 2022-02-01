package com.tencent.comic.config;

import android.text.TextUtils;

public class QQComicConfBean$WebBundleConfig
{
  public boolean a = false;
  public String b = "";
  
  public QQComicConfBean$WebBundleConfig(QQComicConfBean paramQQComicConfBean) {}
  
  public boolean a()
  {
    return (this.a) && (!TextUtils.isEmpty(this.b));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WebBundleConfig{enable=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", preloadUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfBean.WebBundleConfig
 * JD-Core Version:    0.7.0.1
 */