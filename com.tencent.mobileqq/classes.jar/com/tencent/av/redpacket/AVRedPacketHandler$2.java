package com.tencent.av.redpacket;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.AVC2CDataHandler.FrameDataHandler;
import com.tencent.av.opengl.Tlv;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.Emoji;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.FocusInfo;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.FrameSyncInfo;
import com.tencent.protofile.avredpacket.AVRedPacketGameSyncInfo.HitInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AVRedPacketHandler$2
  implements AVC2CDataHandler.FrameDataHandler
{
  AVRedPacketHandler$2(AVRedPacketHandler paramAVRedPacketHandler) {}
  
  public Tlv a()
  {
    for (;;)
    {
      AVRedPacketManager.LocalFrameSyncInfo localLocalFrameSyncInfo;
      AVRedPacketGameSyncInfo.FrameSyncInfo localFrameSyncInfo;
      int i;
      try
      {
        System.currentTimeMillis();
        Object localObject1 = (AVRedPacketManager)this.a.a.a(6);
        if (!((AVRedPacketManager)localObject1).a()) {
          return null;
        }
        localObject1 = ((AVRedPacketManager)localObject1).a();
        localLocalFrameSyncInfo = ((AVRedPacketManager.GameStateInfo)localObject1).currLocalFrameSyncInfo;
        if (QLog.isColorLevel()) {}
        localFrameSyncInfo = new AVRedPacketGameSyncInfo.FrameSyncInfo();
        localFrameSyncInfo.currScores.set(localLocalFrameSyncInfo.curScore);
        i = localLocalFrameSyncInfo.localEmojiInfos.size() - 1;
        if (i >= 0)
        {
          localObject3 = (AVRedPacketManager.LocalEmojiInfo)localLocalFrameSyncInfo.localEmojiInfos.get(i);
          if (localObject3 == null) {
            break label412;
          }
          AVRedPacketGameSyncInfo.Emoji localEmoji = new AVRedPacketGameSyncInfo.Emoji();
          localEmoji.emojiTypeId.set(((AVRedPacketManager.LocalEmojiInfo)localObject3).emojiType);
          localEmoji.startTime.set(((AVRedPacketManager.LocalEmojiInfo)localObject3).startTime);
          localEmoji.trackNum.set(((AVRedPacketManager.LocalEmojiInfo)localObject3).trackNum);
          localEmoji.id.set(((AVRedPacketManager.LocalEmojiInfo)localObject3).emojiId);
          localEmoji.isBigEmoji.set(((AVRedPacketManager.LocalEmojiInfo)localObject3).isBigEmoji);
          localEmoji.fallDownDuration.set(((AVRedPacketManager.LocalEmojiInfo)localObject3).fallDownDuration);
          localFrameSyncInfo.emojis.add(localEmoji);
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AVRedPacketHandler", 2, "OnFrameDataGet ", localException);
        }
        return null;
      }
      Object localObject3 = new AVRedPacketGameSyncInfo.FocusInfo();
      ((AVRedPacketGameSyncInfo.FocusInfo)localObject3).id.set(localLocalFrameSyncInfo.localFocusInfo.emojiId);
      localFrameSyncInfo.focusInfo.set((MessageMicro)localObject3);
      localObject3 = new AVRedPacketGameSyncInfo.HitInfo();
      ((AVRedPacketGameSyncInfo.HitInfo)localObject3).id.set(localLocalFrameSyncInfo.localHitInfo.emojiId);
      ((AVRedPacketGameSyncInfo.HitInfo)localObject3).startTime.set(localLocalFrameSyncInfo.localHitInfo.hitStartTime);
      ((AVRedPacketGameSyncInfo.HitInfo)localObject3).comboCnt.set(localLocalFrameSyncInfo.localHitInfo.comboCnt);
      ((AVRedPacketGameSyncInfo.HitInfo)localObject3).newAddScore.set(localLocalFrameSyncInfo.localHitInfo.newAddScore);
      ((AVRedPacketGameSyncInfo.HitInfo)localObject3).topWordTipType.set(localLocalFrameSyncInfo.localHitInfo.topWordTipType);
      localFrameSyncInfo.hitInfo.set((MessageMicro)localObject3);
      localFrameSyncInfo.frameSyncGameState.set(localLocalFrameSyncInfo.frameSyncGameState);
      localException.count_OnFrameDataSend += 1;
      localFrameSyncInfo.seq.set(localException.count_OnFrameDataSend);
      Object localObject2 = localFrameSyncInfo.toByteArray();
      if (QLog.isColorLevel()) {}
      localObject2 = new Tlv((short)5, (short)localObject2.length, (byte[])localObject2);
      return localObject2;
      label412:
      i -= 1;
    }
  }
  
  public void a(String paramString, Tlv paramTlv)
  {
    boolean bool;
    if ((!QLog.isColorLevel()) || (paramTlv != null))
    {
      try
      {
        if (paramTlv.a() == null) {
          return;
        }
        localAVRedPacketManager = (AVRedPacketManager)this.a.a.a(6);
        if (!localAVRedPacketManager.b()) {
          return;
        }
        localFrameSyncInfo = new AVRedPacketGameSyncInfo.FrameSyncInfo();
        paramString = null;
      }
      catch (Exception paramString)
      {
        AVRedPacketManager localAVRedPacketManager;
        AVRedPacketGameSyncInfo.FrameSyncInfo localFrameSyncInfo;
        label78:
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.e("AVRedPacketHandler", 2, "onFrameDataCome ", paramString);
        return;
      }
      try
      {
        localFrameSyncInfo.mergeFrom(paramTlv.a());
        paramTlv = AVRedPacketHandler.a(this.a, localFrameSyncInfo);
        paramString = paramTlv;
        bool = true;
      }
      catch (Exception paramTlv)
      {
        bool = false;
        break label78;
      }
      if (QLog.isColorLevel()) {}
      localAVRedPacketManager.a(bool, paramString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.redpacket.AVRedPacketHandler.2
 * JD-Core Version:    0.7.0.1
 */