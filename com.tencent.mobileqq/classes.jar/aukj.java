import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukj
  extends aula
{
  public aukj()
  {
    this.a = 19;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool = true;
    paramBoolean = true;
    paramauko = (DiscussionInfo)paramauko;
    if (paramaukz == null)
    {
      paramauko.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramauko.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
      paramauko.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramauko.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      paramauko.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      paramauko.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      paramauko.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramauko.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
      paramauko.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
      paramauko.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramauko.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramauko.mOrigin = paramCursor.getLong(paramCursor.getColumnIndex("mOrigin"));
      paramauko.mOriginExtra = paramCursor.getLong(paramCursor.getColumnIndex("mOriginExtra"));
      paramauko.mSelfRight = paramCursor.getInt(paramCursor.getColumnIndex("mSelfRight"));
      paramauko.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
      paramauko.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasCollect"))) {}
      for (;;)
      {
        paramauko.hasCollect = paramBoolean;
        paramauko.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
        paramauko.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
        return paramauko;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("infoSeq");
      if (i != -1) {
        break label1045;
      }
      paramaukz.a(new NoColumnError("infoSeq", Long.TYPE));
      label438:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label1060;
      }
      paramaukz.a(new NoColumnError("ownerUin", String.class));
      label472:
      i = paramCursor.getColumnIndex("inheritOwnerUin");
      if (i != -1) {
        break label1075;
      }
      paramaukz.a(new NoColumnError("inheritOwnerUin", String.class));
      label506:
      i = paramCursor.getColumnIndex("discussionName");
      if (i != -1) {
        break label1090;
      }
      paramaukz.a(new NoColumnError("discussionName", String.class));
      label540:
      i = paramCursor.getColumnIndex("createTime");
      if (i != -1) {
        break label1105;
      }
      paramaukz.a(new NoColumnError("createTime", Long.TYPE));
      label575:
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label1120;
      }
      paramaukz.a(new NoColumnError("timeSec", Long.TYPE));
      label610:
      i = paramCursor.getColumnIndex("faceUinSet");
      if (i != -1) {
        break label1135;
      }
      paramaukz.a(new NoColumnError("faceUinSet", String.class));
      label644:
      i = paramCursor.getColumnIndex("DiscussionFlag");
      if (i != -1) {
        break label1150;
      }
      paramaukz.a(new NoColumnError("DiscussionFlag", Long.TYPE));
      label679:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1165;
      }
      paramaukz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label714:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1180;
      }
      paramaukz.a(new NoColumnError("mCompareSpell", String.class));
      label748:
      i = paramCursor.getColumnIndex("mOrigin");
      if (i != -1) {
        break label1195;
      }
      paramaukz.a(new NoColumnError("mOrigin", Long.TYPE));
      label783:
      i = paramCursor.getColumnIndex("mOriginExtra");
      if (i != -1) {
        break label1210;
      }
      paramaukz.a(new NoColumnError("mOriginExtra", Long.TYPE));
      label818:
      i = paramCursor.getColumnIndex("mSelfRight");
      if (i != -1) {
        break label1225;
      }
      paramaukz.a(new NoColumnError("mSelfRight", Integer.TYPE));
      label853:
      i = paramCursor.getColumnIndex("groupCode");
      if (i != -1) {
        break label1240;
      }
      paramaukz.a(new NoColumnError("groupCode", Long.TYPE));
      label888:
      i = paramCursor.getColumnIndex("groupUin");
      if (i != -1) {
        break label1255;
      }
      paramaukz.a(new NoColumnError("groupUin", Long.TYPE));
      label923:
      i = paramCursor.getColumnIndex("hasCollect");
      if (i != -1) {
        break label1270;
      }
      paramaukz.a(new NoColumnError("hasCollect", Boolean.TYPE));
      i = paramCursor.getColumnIndex("createFrom");
      if (i != -1) {
        break label1298;
      }
      paramaukz.a(new NoColumnError("createFrom", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("uiControlFlag");
      if (i != -1) {
        break label1313;
      }
      paramaukz.a(new NoColumnError("uiControlFlag", Long.TYPE));
      return paramauko;
      paramauko.uin = paramCursor.getString(i);
      break;
      label1045:
      paramauko.infoSeq = paramCursor.getLong(i);
      break label438;
      label1060:
      paramauko.ownerUin = paramCursor.getString(i);
      break label472;
      label1075:
      paramauko.inheritOwnerUin = paramCursor.getString(i);
      break label506;
      label1090:
      paramauko.discussionName = paramCursor.getString(i);
      break label540;
      label1105:
      paramauko.createTime = paramCursor.getLong(i);
      break label575;
      label1120:
      paramauko.timeSec = paramCursor.getLong(i);
      break label610;
      label1135:
      paramauko.faceUinSet = paramCursor.getString(i);
      break label644;
      label1150:
      paramauko.DiscussionFlag = paramCursor.getLong(i);
      break label679;
      label1165:
      paramauko.mComparePartInt = paramCursor.getInt(i);
      break label714;
      label1180:
      paramauko.mCompareSpell = paramCursor.getString(i);
      break label748;
      label1195:
      paramauko.mOrigin = paramCursor.getLong(i);
      break label783;
      label1210:
      paramauko.mOriginExtra = paramCursor.getLong(i);
      break label818;
      label1225:
      paramauko.mSelfRight = paramCursor.getInt(i);
      break label853;
      label1240:
      paramauko.groupCode = paramCursor.getLong(i);
      break label888;
      label1255:
      paramauko.groupUin = paramCursor.getLong(i);
      break label923;
      label1270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramauko.hasCollect = paramBoolean;
        break;
      }
      label1298:
      paramauko.createFrom = paramCursor.getInt(i);
    }
    label1313:
    paramauko.uiControlFlag = paramCursor.getLong(i);
    return paramauko;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,infoSeq INTEGER ,ownerUin TEXT ,inheritOwnerUin TEXT ,discussionName TEXT ,createTime INTEGER ,timeSec INTEGER ,faceUinSet TEXT ,DiscussionFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mOrigin INTEGER ,mOriginExtra INTEGER ,mSelfRight INTEGER ,groupCode INTEGER ,groupUin INTEGER ,hasCollect INTEGER ,createFrom INTEGER ,uiControlFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (DiscussionInfo)paramauko;
    paramContentValues.put("uin", paramauko.uin);
    paramContentValues.put("infoSeq", Long.valueOf(paramauko.infoSeq));
    paramContentValues.put("ownerUin", paramauko.ownerUin);
    paramContentValues.put("inheritOwnerUin", paramauko.inheritOwnerUin);
    paramContentValues.put("discussionName", paramauko.discussionName);
    paramContentValues.put("createTime", Long.valueOf(paramauko.createTime));
    paramContentValues.put("timeSec", Long.valueOf(paramauko.timeSec));
    paramContentValues.put("faceUinSet", paramauko.faceUinSet);
    paramContentValues.put("DiscussionFlag", Long.valueOf(paramauko.DiscussionFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramauko.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramauko.mCompareSpell);
    paramContentValues.put("mOrigin", Long.valueOf(paramauko.mOrigin));
    paramContentValues.put("mOriginExtra", Long.valueOf(paramauko.mOriginExtra));
    paramContentValues.put("mSelfRight", Integer.valueOf(paramauko.mSelfRight));
    paramContentValues.put("groupCode", Long.valueOf(paramauko.groupCode));
    paramContentValues.put("groupUin", Long.valueOf(paramauko.groupUin));
    paramContentValues.put("hasCollect", Boolean.valueOf(paramauko.hasCollect));
    paramContentValues.put("createFrom", Integer.valueOf(paramauko.createFrom));
    paramContentValues.put("uiControlFlag", Long.valueOf(paramauko.uiControlFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukj
 * JD-Core Version:    0.7.0.1
 */