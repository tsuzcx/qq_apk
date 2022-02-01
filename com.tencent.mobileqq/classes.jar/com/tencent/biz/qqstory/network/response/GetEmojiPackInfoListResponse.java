package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetEmoticonPackList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.EmoticonPack;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class GetEmojiPackInfoListResponse
  extends BaseResponse
{
  public final List<GetEmojiPackInfoListResponse.EmojiPack> a;
  public final boolean b;
  public final String e;
  public final long f;
  public final byte[] g;
  
  public GetEmojiPackInfoListResponse(qqstory_service.RspGetEmoticonPackList paramRspGetEmoticonPackList, byte[] paramArrayOfByte, long paramLong)
  {
    super(paramRspGetEmoticonPackList.result);
    boolean bool;
    if (paramRspGetEmoticonPackList.is_end.get() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    this.e = paramRspGetEmoticonPackList.next_cookie.get().toStringUtf8();
    ArrayList localArrayList = new ArrayList();
    paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.pack_list.get();
    if (paramRspGetEmoticonPackList != null)
    {
      paramRspGetEmoticonPackList = paramRspGetEmoticonPackList.iterator();
      while (paramRspGetEmoticonPackList.hasNext())
      {
        GetEmojiPackInfoListResponse.EmojiPack localEmojiPack = new GetEmojiPackInfoListResponse.EmojiPack((qqstory_struct.EmoticonPack)paramRspGetEmoticonPackList.next());
        if (localEmojiPack.a())
        {
          localArrayList.add(localEmojiPack);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("found invalid data we ignore it : ");
          localStringBuilder.append(localEmojiPack);
          SLog.d("GetEmojiPackInfoListResponse", localStringBuilder.toString());
        }
      }
    }
    this.a = Collections.unmodifiableList(localArrayList);
    this.f = paramLong;
    this.g = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, this.g, 0, paramArrayOfByte.length);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GetEmojiPackInfoListResponse{mEmojiPackList.size=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", mIsEnd=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mNextCookie='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetEmojiPackInfoListResponse
 * JD-Core Version:    0.7.0.1
 */