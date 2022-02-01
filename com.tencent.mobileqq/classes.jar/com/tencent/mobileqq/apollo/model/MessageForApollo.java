package com.tencent.mobileqq.apollo.model;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloMessageUtilImpl;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessageForApollo
  extends ChatMessage
  implements IMessageForApollo
{
  public static final int FAKE_MSG_ACTION_ID = 99999;
  public static final String RESERVE_JSON_KEY_3D_MESSAGE = "mApollo3DMessage";
  public static final String RESERVE_JSON_KEY_ACTION_TYPE = "actionType";
  public static final String RESERVE_JSON_KEY_ARK = "arkInfo";
  public static final String RESERVE_JSON_KEY_AUDIOID = "audioID";
  public static final String RESERVE_JSON_KEY_AUDIO_START_TIME = "audioStartTime";
  public static final String RESERVE_JSON_KEY_COMMINFO = "commInfo";
  public static final String RESERVE_JSON_KEY_CUR_USED_ID_TYPE = "curUsedIdType";
  public static final String RESERVE_JSON_KEY_EXTEND_JSON = "extendJson";
  public static final String RESERVE_JSON_KEY_GAMEID = "gameId";
  public static final String RESERVE_JSON_KEY_GAMEMODE = "gameMode";
  public static final String RESERVE_JSON_KEY_GAMENAME = "gameName";
  public static final String RESERVE_JSON_KEY_GAMESTATUS = "gameStatus";
  public static final String RESERVE_JSON_KEY_GAMESTATUS_STAMP = "gmUpdateStamp";
  public static final String RESERVE_JSON_KEY_GAME_EXTEND_JSON = "gameExtendJson";
  public static final String RESERVE_JSON_KEY_INPUTTEXT = "inputText";
  public static final String RESERVE_JSON_KEY_MSGTYPE = "msgTyep";
  public static final String RESERVE_JSON_KEY_OVER_TYPE = "gameOverType";
  public static final String RESERVE_JSON_KEY_PLAYERLIST = "playerList";
  public static final String RESERVE_JSON_KEY_ROOMID = "roomid";
  public static final String RESERVE_JSON_KEY_ROOMVOL = "roomVol";
  public static final String RESERVE_JSON_KEY_STICKER_HEIGHT = "stickerHeight";
  public static final String RESERVE_JSON_KEY_STICKER_WIDTH = "stickerWidth";
  public static final String RESERVE_JSON_KEY_WELCOME_ID = "welcomeId";
  public static final String RESERVE_JSON_KEY_WELCOME_UIN_LIST = "welcomeUinList";
  public static final String RESERVE_JSON_KEY_WINNERLIST = "winnerList";
  public static final String RESERVE_JSON_KEY_WINRECORD = "winRecord";
  public static final String RESERVE_JSON_KEY_WINUIN = "winUin";
  private static final String TAG = "[cmshow]MessageForApollo";
  public int actionType;
  public int audioId;
  public float audioStartTime = 0.0F;
  public String commInfo;
  public int curUsedIdType;
  public String extendJson;
  @Deprecated
  public String gameArkInfo;
  public String gameExtendJson;
  public int gameId;
  public String gameName;
  @Deprecated
  public int gameStatus;
  public long gameStatusStamp;
  public boolean hasPlayed;
  public String inputText;
  public int isPlayDefaultAudio;
  @RecordForTest
  public Apollo3DMessage mApollo3DMessage;
  public MessageForArkApp mApolloGameArkMsg;
  public ApolloMessage mApolloMessage;
  public int mGameMode;
  public int mSendSrc;
  public int msgType;
  public int overType;
  @Deprecated
  public List<Long> playerList = new ArrayList();
  public long roomId;
  @Deprecated
  public int roomVol;
  public long signTs;
  public int stickerHeight;
  public int stickerWidth;
  public long welcomeId;
  public List<Long> welcomeUinList = new ArrayList();
  @Deprecated
  public String winRecord;
  @Deprecated
  public List<Long> winnerList = new ArrayList();
  @Deprecated
  public long winnerUin;
  
  protected void doParse()
  {
    try
    {
      this.mApolloMessage = ((ApolloMessage)MessagePkgUtils.a(this.msgData));
      this.hasPlayed = this.mApolloMessage.isPlayed;
      this.msg = ApolloMessageUtilImpl.getApolloDescMsg(this);
      if (!TextUtils.isEmpty(this.mApolloMessage.extStr))
      {
        JSONObject localJSONObject = new JSONObject(this.mApolloMessage.extStr);
        this.inputText = localJSONObject.optString("inputText");
        this.audioId = localJSONObject.optInt("audioID");
        if (localJSONObject.has("audioStartTime")) {
          this.audioStartTime = ((float)localJSONObject.getDouble("audioStartTime"));
        }
        this.msgType = localJSONObject.optInt("msgTyep");
        this.gameId = localJSONObject.optInt("gameId");
        this.mGameMode = localJSONObject.optInt("gameMode");
        this.roomId = localJSONObject.optLong("roomid");
        this.gameStatus = localJSONObject.optInt("gameStatus");
        this.roomVol = localJSONObject.optInt("roomVol");
        this.gameStatusStamp = localJSONObject.optLong("gmUpdateStamp");
        this.stickerHeight = localJSONObject.optInt("stickerHeight");
        this.stickerWidth = localJSONObject.optInt("stickerWidth");
        this.welcomeId = localJSONObject.optLong("welcomeId");
        int i;
        if (localJSONObject.has("welcomeUinList"))
        {
          this.welcomeUinList.clear();
          localObject = localJSONObject.getJSONArray("welcomeUinList");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              this.welcomeUinList.add(Long.valueOf(((JSONArray)localObject).getLong(i)));
              i += 1;
            }
          }
        }
        if (localJSONObject.has("playerList"))
        {
          this.playerList.clear();
          localObject = localJSONObject.getJSONArray("playerList");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              this.playerList.add(Long.valueOf(((JSONArray)localObject).getLong(i)));
              i += 1;
            }
          }
        }
        if (localJSONObject.has("winnerList"))
        {
          this.winnerList.clear();
          localObject = localJSONObject.getJSONArray("winnerList");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            i = 0;
            while (i < ((JSONArray)localObject).length())
            {
              this.winnerList.add(Long.valueOf(((JSONArray)localObject).getLong(i)));
              i += 1;
            }
          }
        }
        this.winnerUin = localJSONObject.optLong("winUin");
        this.winRecord = localJSONObject.optString("winRecord");
        this.gameName = localJSONObject.optString("gameName");
        this.extendJson = localJSONObject.optString("extendJson");
        if (this.gameStatus == 0) {
          this.gameStatus = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(this.extendJson, "gameStatus");
        }
        this.actionType = localJSONObject.optInt("actionType");
        this.gameArkInfo = localJSONObject.optString("arkInfo");
        this.commInfo = localJSONObject.optString("commInfo");
        this.gameExtendJson = localJSONObject.optString("gameExtendJson");
        this.overType = localJSONObject.optInt("gameOverType");
        localJSONObject = localJSONObject.optJSONObject("mApollo3DMessage");
        if (localJSONObject != null)
        {
          if (this.mApollo3DMessage == null) {
            this.mApollo3DMessage = new Apollo3DMessage();
          }
          this.mApollo3DMessage.setMessageWithJSONObject(localJSONObject);
        }
        if (this.msgType == 12) {
          this.actionType = 0;
        }
      }
      if ((TextUtils.isEmpty(this.inputText)) && (this.istroop == 0) && (this.mApolloMessage.text != null))
      {
        this.inputText = new String(this.mApolloMessage.text);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (this.mApolloMessage == null)
      {
        this.mApolloMessage = new ApolloMessage();
        localObject = this.mApolloMessage;
        ((ApolloMessage)localObject).isPlayed = true;
        ((ApolloMessage)localObject).extStr = "{}";
        ((ApolloMessage)localObject).id = 99999;
        ((ApolloMessage)localObject).name = ApolloUtilImpl.getFakeMsgText();
        QLog.e("[cmshow]MessageForApollo", 1, "mApolloMessage == null, make fake Message.");
      }
      if (this.msgData != null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" Apollo doParse error, msgData->");
        ((StringBuilder)localObject).append(Arrays.toString(this.msgData));
        QLog.e("[cmshow]MessageForApollo", 1, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" Apollo doParse error, e->");
      ((StringBuilder)localObject).append(localThrowable.getMessage());
      QLog.e("[cmshow]MessageForApollo", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public boolean is3dAction()
  {
    Apollo3DMessage localApollo3DMessage = this.mApollo3DMessage;
    return (localApollo3DMessage != null) && (ApolloActionData.isAction3DModel(localApollo3DMessage.actionID3D));
  }
  
  public boolean isBarrageMode()
  {
    ApolloMessage localApolloMessage = this.mApolloMessage;
    boolean bool = false;
    if (localApolloMessage == null) {
      return false;
    }
    if (128 == (localApolloMessage.flag & 0x80)) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isDoubleAction()
  {
    ApolloMessage localApolloMessage = this.mApolloMessage;
    boolean bool2 = false;
    if (localApolloMessage == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (1 == (localApolloMessage.flag >> 2 & 0x1))
    {
      bool1 = bool2;
      if (this.mApolloMessage.peerUin > 0L) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isMeme()
  {
    if (CmShowWnsUtils.c())
    {
      int i = this.msgType;
      if ((i == 10) || (i == 11) || ((i == 12) && (CMShowPlatform.a.b(Scene.MEME_PLAYER)))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean needVipBubble()
  {
    return (this.istroop == 1) && (isMeme());
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    ApolloMessage localApolloMessage = this.mApolloMessage;
    if (localApolloMessage != null) {
      try
      {
        localApolloMessage.isPlayed = this.hasPlayed;
        this.msgData = MessagePkgUtils.a(localApolloMessage);
        return;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSend:");
        localStringBuilder.append(isSend());
        localStringBuilder.append(" Apollo prewrite error：");
        localStringBuilder.append(localException.getMessage());
        QLog.e("[cmshow]MessageForApollo", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.MessageForApollo
 * JD-Core Version:    0.7.0.1
 */