import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awbq
  extends awch
{
  public awbq()
  {
    this.a = 19;
  }
  
  public awbv a(awbv paramawbv, Cursor paramCursor, boolean paramBoolean, awcg paramawcg)
  {
    boolean bool = true;
    paramBoolean = true;
    paramawbv = (DiscussionInfo)paramawbv;
    if (paramawcg == null)
    {
      paramawbv.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawbv.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
      paramawbv.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramawbv.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      paramawbv.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      paramawbv.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      paramawbv.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramawbv.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
      paramawbv.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
      paramawbv.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramawbv.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramawbv.mOrigin = paramCursor.getLong(paramCursor.getColumnIndex("mOrigin"));
      paramawbv.mOriginExtra = paramCursor.getLong(paramCursor.getColumnIndex("mOriginExtra"));
      paramawbv.mSelfRight = paramCursor.getInt(paramCursor.getColumnIndex("mSelfRight"));
      paramawbv.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
      paramawbv.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasCollect"))) {}
      for (;;)
      {
        paramawbv.hasCollect = paramBoolean;
        paramawbv.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
        paramawbv.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
        return paramawbv;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawcg.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("infoSeq");
      if (i != -1) {
        break label1045;
      }
      paramawcg.a(new NoColumnError("infoSeq", Long.TYPE));
      label438:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label1060;
      }
      paramawcg.a(new NoColumnError("ownerUin", String.class));
      label472:
      i = paramCursor.getColumnIndex("inheritOwnerUin");
      if (i != -1) {
        break label1075;
      }
      paramawcg.a(new NoColumnError("inheritOwnerUin", String.class));
      label506:
      i = paramCursor.getColumnIndex("discussionName");
      if (i != -1) {
        break label1090;
      }
      paramawcg.a(new NoColumnError("discussionName", String.class));
      label540:
      i = paramCursor.getColumnIndex("createTime");
      if (i != -1) {
        break label1105;
      }
      paramawcg.a(new NoColumnError("createTime", Long.TYPE));
      label575:
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label1120;
      }
      paramawcg.a(new NoColumnError("timeSec", Long.TYPE));
      label610:
      i = paramCursor.getColumnIndex("faceUinSet");
      if (i != -1) {
        break label1135;
      }
      paramawcg.a(new NoColumnError("faceUinSet", String.class));
      label644:
      i = paramCursor.getColumnIndex("DiscussionFlag");
      if (i != -1) {
        break label1150;
      }
      paramawcg.a(new NoColumnError("DiscussionFlag", Long.TYPE));
      label679:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1165;
      }
      paramawcg.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label714:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1180;
      }
      paramawcg.a(new NoColumnError("mCompareSpell", String.class));
      label748:
      i = paramCursor.getColumnIndex("mOrigin");
      if (i != -1) {
        break label1195;
      }
      paramawcg.a(new NoColumnError("mOrigin", Long.TYPE));
      label783:
      i = paramCursor.getColumnIndex("mOriginExtra");
      if (i != -1) {
        break label1210;
      }
      paramawcg.a(new NoColumnError("mOriginExtra", Long.TYPE));
      label818:
      i = paramCursor.getColumnIndex("mSelfRight");
      if (i != -1) {
        break label1225;
      }
      paramawcg.a(new NoColumnError("mSelfRight", Integer.TYPE));
      label853:
      i = paramCursor.getColumnIndex("groupCode");
      if (i != -1) {
        break label1240;
      }
      paramawcg.a(new NoColumnError("groupCode", Long.TYPE));
      label888:
      i = paramCursor.getColumnIndex("groupUin");
      if (i != -1) {
        break label1255;
      }
      paramawcg.a(new NoColumnError("groupUin", Long.TYPE));
      label923:
      i = paramCursor.getColumnIndex("hasCollect");
      if (i != -1) {
        break label1270;
      }
      paramawcg.a(new NoColumnError("hasCollect", Boolean.TYPE));
      i = paramCursor.getColumnIndex("createFrom");
      if (i != -1) {
        break label1298;
      }
      paramawcg.a(new NoColumnError("createFrom", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("uiControlFlag");
      if (i != -1) {
        break label1313;
      }
      paramawcg.a(new NoColumnError("uiControlFlag", Long.TYPE));
      return paramawbv;
      paramawbv.uin = paramCursor.getString(i);
      break;
      label1045:
      paramawbv.infoSeq = paramCursor.getLong(i);
      break label438;
      label1060:
      paramawbv.ownerUin = paramCursor.getString(i);
      break label472;
      label1075:
      paramawbv.inheritOwnerUin = paramCursor.getString(i);
      break label506;
      label1090:
      paramawbv.discussionName = paramCursor.getString(i);
      break label540;
      label1105:
      paramawbv.createTime = paramCursor.getLong(i);
      break label575;
      label1120:
      paramawbv.timeSec = paramCursor.getLong(i);
      break label610;
      label1135:
      paramawbv.faceUinSet = paramCursor.getString(i);
      break label644;
      label1150:
      paramawbv.DiscussionFlag = paramCursor.getLong(i);
      break label679;
      label1165:
      paramawbv.mComparePartInt = paramCursor.getInt(i);
      break label714;
      label1180:
      paramawbv.mCompareSpell = paramCursor.getString(i);
      break label748;
      label1195:
      paramawbv.mOrigin = paramCursor.getLong(i);
      break label783;
      label1210:
      paramawbv.mOriginExtra = paramCursor.getLong(i);
      break label818;
      label1225:
      paramawbv.mSelfRight = paramCursor.getInt(i);
      break label853;
      label1240:
      paramawbv.groupCode = paramCursor.getLong(i);
      break label888;
      label1255:
      paramawbv.groupUin = paramCursor.getLong(i);
      break label923;
      label1270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramawbv.hasCollect = paramBoolean;
        break;
      }
      label1298:
      paramawbv.createFrom = paramCursor.getInt(i);
    }
    label1313:
    paramawbv.uiControlFlag = paramCursor.getLong(i);
    return paramawbv;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,infoSeq INTEGER ,ownerUin TEXT ,inheritOwnerUin TEXT ,discussionName TEXT ,createTime INTEGER ,timeSec INTEGER ,faceUinSet TEXT ,DiscussionFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mOrigin INTEGER ,mOriginExtra INTEGER ,mSelfRight INTEGER ,groupCode INTEGER ,groupUin INTEGER ,hasCollect INTEGER ,createFrom INTEGER ,uiControlFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awbv paramawbv, ContentValues paramContentValues)
  {
    paramawbv = (DiscussionInfo)paramawbv;
    paramContentValues.put("uin", paramawbv.uin);
    paramContentValues.put("infoSeq", Long.valueOf(paramawbv.infoSeq));
    paramContentValues.put("ownerUin", paramawbv.ownerUin);
    paramContentValues.put("inheritOwnerUin", paramawbv.inheritOwnerUin);
    paramContentValues.put("discussionName", paramawbv.discussionName);
    paramContentValues.put("createTime", Long.valueOf(paramawbv.createTime));
    paramContentValues.put("timeSec", Long.valueOf(paramawbv.timeSec));
    paramContentValues.put("faceUinSet", paramawbv.faceUinSet);
    paramContentValues.put("DiscussionFlag", Long.valueOf(paramawbv.DiscussionFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawbv.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawbv.mCompareSpell);
    paramContentValues.put("mOrigin", Long.valueOf(paramawbv.mOrigin));
    paramContentValues.put("mOriginExtra", Long.valueOf(paramawbv.mOriginExtra));
    paramContentValues.put("mSelfRight", Integer.valueOf(paramawbv.mSelfRight));
    paramContentValues.put("groupCode", Long.valueOf(paramawbv.groupCode));
    paramContentValues.put("groupUin", Long.valueOf(paramawbv.groupUin));
    paramContentValues.put("hasCollect", Boolean.valueOf(paramawbv.hasCollect));
    paramContentValues.put("createFrom", Integer.valueOf(paramawbv.createFrom));
    paramContentValues.put("uiControlFlag", Long.valueOf(paramawbv.uiControlFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awbq
 * JD-Core Version:    0.7.0.1
 */