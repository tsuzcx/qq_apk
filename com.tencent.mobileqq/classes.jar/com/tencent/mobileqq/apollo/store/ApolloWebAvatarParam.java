package com.tencent.mobileqq.apollo.store;

import java.io.Serializable;
import java.util.Arrays;

public class ApolloWebAvatarParam
  implements Serializable
{
  public String apolloId;
  public int[] dressIds;
  public String greeting;
  public boolean isMain;
  public boolean isResExist;
  public String nickName;
  public float rate;
  public int roleId;
  public String tab;
  public int tapRectHeight;
  public int tapRectWidth;
  public int tapRectX;
  public int tapRectY;
  public int type;
  public String uin;
  public int width;
  public int x;
  public int y;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ApolloWebAvatarParam{");
    localStringBuilder.append("x=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", y=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", rate=");
    localStringBuilder.append(this.rate);
    localStringBuilder.append(", uin='");
    localStringBuilder.append(this.uin);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", greeting='");
    localStringBuilder.append(this.greeting);
    localStringBuilder.append('\'');
    localStringBuilder.append(", roleId=");
    localStringBuilder.append(this.roleId);
    localStringBuilder.append(", dressIds=");
    localStringBuilder.append(Arrays.toString(this.dressIds));
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", isMain=");
    localStringBuilder.append(this.isMain);
    localStringBuilder.append(", tab='");
    localStringBuilder.append(this.tab);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isResExist=");
    localStringBuilder.append(this.isResExist);
    localStringBuilder.append(", apolloId='");
    localStringBuilder.append(this.apolloId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.width);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam
 * JD-Core Version:    0.7.0.1
 */