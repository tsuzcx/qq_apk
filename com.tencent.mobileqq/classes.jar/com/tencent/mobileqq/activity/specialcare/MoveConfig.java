package com.tencent.mobileqq.activity.specialcare;

import com.tencent.mobileqq.utils.FileUtils;

public class MoveConfig
  implements Runnable
{
  private String a;
  
  MoveConfig(String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("https://i.gtimg.cn/club/moblie/special_sound/new_config.json");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append("pddata/vas/special_remind/new_config.json");
    FileUtils.moveFile((String)localObject, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.MoveConfig
 * JD-Core Version:    0.7.0.1
 */