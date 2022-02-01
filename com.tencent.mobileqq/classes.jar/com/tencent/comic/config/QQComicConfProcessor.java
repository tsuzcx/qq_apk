package com.tencent.comic.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class QQComicConfProcessor
  extends IQConfigProcessor<QQComicConfBean>
{
  @NotNull
  public QQComicConfBean a(int paramInt)
  {
    return new QQComicConfBean();
  }
  
  @Nullable
  public QQComicConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicConfProcessor", 2, "onParsed");
    }
    return QQComicConfBean.a(paramArrayOfQConfItem);
  }
  
  public void a(QQComicConfBean paramQQComicConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramQQComicConfBean.toString());
      QLog.d("QQComicConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<QQComicConfBean> clazz()
  {
    return QQComicConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 534;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.config.QQComicConfProcessor
 * JD-Core Version:    0.7.0.1
 */