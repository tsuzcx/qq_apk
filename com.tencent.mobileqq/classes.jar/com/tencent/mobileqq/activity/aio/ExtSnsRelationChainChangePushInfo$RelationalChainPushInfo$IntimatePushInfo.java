package com.tencent.mobileqq.activity.aio;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.intimate_relation.intimate_relation.IntimateBuddy;
import tencent.intimate_relation.intimate_relation.IntimateInfo;
import tencent.intimate_relation.intimate_relation.IntimateLadybro;
import tencent.intimate_relation.intimate_relation.IntimateLover;
import tencent.intimate_relation.intimate_relation.SnsRelationInfo;

public class ExtSnsRelationChainChangePushInfo$RelationalChainPushInfo$IntimatePushInfo
{
  public int a;
  
  public static IntimatePushInfo a(byte[] paramArrayOfByte)
  {
    Object localObject2 = new intimate_relation.SnsRelationInfo();
    Object localObject1 = null;
    try
    {
      ((intimate_relation.SnsRelationInfo)localObject2).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject1;
      if (((intimate_relation.SnsRelationInfo)localObject2).intimate_list.has())
      {
        paramArrayOfByte = (byte[])localObject1;
        if (((intimate_relation.SnsRelationInfo)localObject2).intimate_list.size() > 0)
        {
          localObject1 = new IntimatePushInfo();
          localObject2 = (intimate_relation.IntimateInfo)((intimate_relation.SnsRelationInfo)localObject2).intimate_list.get(0);
          if ((((intimate_relation.IntimateInfo)localObject2).lover.has()) && (((intimate_relation.IntimateLover)((intimate_relation.IntimateInfo)localObject2).lover.get()).level.has()))
          {
            ((IntimatePushInfo)localObject1).a = ((intimate_relation.IntimateLover)((intimate_relation.IntimateInfo)localObject2).lover.get()).level.get();
            paramArrayOfByte = (byte[])localObject1;
          }
          else if ((((intimate_relation.IntimateInfo)localObject2).buddy.has()) && (((intimate_relation.IntimateBuddy)((intimate_relation.IntimateInfo)localObject2).buddy.get()).level.has()))
          {
            ((IntimatePushInfo)localObject1).a = ((intimate_relation.IntimateBuddy)((intimate_relation.IntimateInfo)localObject2).buddy.get()).level.get();
            paramArrayOfByte = (byte[])localObject1;
          }
          else
          {
            paramArrayOfByte = (byte[])localObject1;
            if (((intimate_relation.IntimateInfo)localObject2).ladybro.has())
            {
              paramArrayOfByte = (byte[])localObject1;
              if (((intimate_relation.IntimateLadybro)((intimate_relation.IntimateInfo)localObject2).ladybro.get()).level.has())
              {
                ((IntimatePushInfo)localObject1).a = ((intimate_relation.IntimateLadybro)((intimate_relation.IntimateInfo)localObject2).ladybro.get()).level.get();
                paramArrayOfByte = (byte[])localObject1;
              }
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parseFrom retInfo:");
        ((StringBuilder)localObject1).append(paramArrayOfByte);
        QLog.i("ExtSnsIntimateInfo", 1, ((StringBuilder)localObject1).toString());
      }
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseFrom error:");
      ((StringBuilder)localObject1).append(paramArrayOfByte.getMessage());
      QLog.i("ExtSnsIntimateInfo", 1, ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ExtSnsIntimatePushInfo{");
    localStringBuilder.append("intimate_level:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", ");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ExtSnsRelationChainChangePushInfo.RelationalChainPushInfo.IntimatePushInfo
 * JD-Core Version:    0.7.0.1
 */