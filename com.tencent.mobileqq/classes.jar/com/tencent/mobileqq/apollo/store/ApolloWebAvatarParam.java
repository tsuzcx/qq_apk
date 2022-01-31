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
    localStringBuilder.append("x=").append(this.x);
    localStringBuilder.append(", y=").append(this.y);
    localStringBuilder.append(", rate=").append(this.rate);
    localStringBuilder.append(", uin='").append(this.uin).append('\'');
    localStringBuilder.append(", nickName='").append(this.nickName).append('\'');
    localStringBuilder.append(", greeting='").append(this.greeting).append('\'');
    localStringBuilder.append(", roleId=").append(this.roleId);
    localStringBuilder.append(", dressIds=").append(Arrays.toString(this.dressIds));
    localStringBuilder.append(", type=").append(this.type);
    localStringBuilder.append(", isMain=").append(this.isMain);
    localStringBuilder.append(", tab='").append(this.tab).append('\'');
    localStringBuilder.append(", isResExist=").append(this.isResExist);
    localStringBuilder.append(", apolloId='").append(this.apolloId).append('\'');
    localStringBuilder.append(", width=").append(this.width);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloWebAvatarParam
 * JD-Core Version:    0.7.0.1
 */