import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukh
  extends auky
{
  public aukh()
  {
    this.a = 19;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool = true;
    paramBoolean = true;
    paramaukm = (DiscussionInfo)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramaukm.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
      paramaukm.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramaukm.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      paramaukm.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      paramaukm.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      paramaukm.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramaukm.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
      paramaukm.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
      paramaukm.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramaukm.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramaukm.mOrigin = paramCursor.getLong(paramCursor.getColumnIndex("mOrigin"));
      paramaukm.mOriginExtra = paramCursor.getLong(paramCursor.getColumnIndex("mOriginExtra"));
      paramaukm.mSelfRight = paramCursor.getInt(paramCursor.getColumnIndex("mSelfRight"));
      paramaukm.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
      paramaukm.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasCollect"))) {}
      for (;;)
      {
        paramaukm.hasCollect = paramBoolean;
        paramaukm.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
        paramaukm.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
        return paramaukm;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramaukx.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("infoSeq");
      if (i != -1) {
        break label1045;
      }
      paramaukx.a(new NoColumnError("infoSeq", Long.TYPE));
      label438:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label1060;
      }
      paramaukx.a(new NoColumnError("ownerUin", String.class));
      label472:
      i = paramCursor.getColumnIndex("inheritOwnerUin");
      if (i != -1) {
        break label1075;
      }
      paramaukx.a(new NoColumnError("inheritOwnerUin", String.class));
      label506:
      i = paramCursor.getColumnIndex("discussionName");
      if (i != -1) {
        break label1090;
      }
      paramaukx.a(new NoColumnError("discussionName", String.class));
      label540:
      i = paramCursor.getColumnIndex("createTime");
      if (i != -1) {
        break label1105;
      }
      paramaukx.a(new NoColumnError("createTime", Long.TYPE));
      label575:
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label1120;
      }
      paramaukx.a(new NoColumnError("timeSec", Long.TYPE));
      label610:
      i = paramCursor.getColumnIndex("faceUinSet");
      if (i != -1) {
        break label1135;
      }
      paramaukx.a(new NoColumnError("faceUinSet", String.class));
      label644:
      i = paramCursor.getColumnIndex("DiscussionFlag");
      if (i != -1) {
        break label1150;
      }
      paramaukx.a(new NoColumnError("DiscussionFlag", Long.TYPE));
      label679:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1165;
      }
      paramaukx.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label714:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1180;
      }
      paramaukx.a(new NoColumnError("mCompareSpell", String.class));
      label748:
      i = paramCursor.getColumnIndex("mOrigin");
      if (i != -1) {
        break label1195;
      }
      paramaukx.a(new NoColumnError("mOrigin", Long.TYPE));
      label783:
      i = paramCursor.getColumnIndex("mOriginExtra");
      if (i != -1) {
        break label1210;
      }
      paramaukx.a(new NoColumnError("mOriginExtra", Long.TYPE));
      label818:
      i = paramCursor.getColumnIndex("mSelfRight");
      if (i != -1) {
        break label1225;
      }
      paramaukx.a(new NoColumnError("mSelfRight", Integer.TYPE));
      label853:
      i = paramCursor.getColumnIndex("groupCode");
      if (i != -1) {
        break label1240;
      }
      paramaukx.a(new NoColumnError("groupCode", Long.TYPE));
      label888:
      i = paramCursor.getColumnIndex("groupUin");
      if (i != -1) {
        break label1255;
      }
      paramaukx.a(new NoColumnError("groupUin", Long.TYPE));
      label923:
      i = paramCursor.getColumnIndex("hasCollect");
      if (i != -1) {
        break label1270;
      }
      paramaukx.a(new NoColumnError("hasCollect", Boolean.TYPE));
      i = paramCursor.getColumnIndex("createFrom");
      if (i != -1) {
        break label1298;
      }
      paramaukx.a(new NoColumnError("createFrom", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("uiControlFlag");
      if (i != -1) {
        break label1313;
      }
      paramaukx.a(new NoColumnError("uiControlFlag", Long.TYPE));
      return paramaukm;
      paramaukm.uin = paramCursor.getString(i);
      break;
      label1045:
      paramaukm.infoSeq = paramCursor.getLong(i);
      break label438;
      label1060:
      paramaukm.ownerUin = paramCursor.getString(i);
      break label472;
      label1075:
      paramaukm.inheritOwnerUin = paramCursor.getString(i);
      break label506;
      label1090:
      paramaukm.discussionName = paramCursor.getString(i);
      break label540;
      label1105:
      paramaukm.createTime = paramCursor.getLong(i);
      break label575;
      label1120:
      paramaukm.timeSec = paramCursor.getLong(i);
      break label610;
      label1135:
      paramaukm.faceUinSet = paramCursor.getString(i);
      break label644;
      label1150:
      paramaukm.DiscussionFlag = paramCursor.getLong(i);
      break label679;
      label1165:
      paramaukm.mComparePartInt = paramCursor.getInt(i);
      break label714;
      label1180:
      paramaukm.mCompareSpell = paramCursor.getString(i);
      break label748;
      label1195:
      paramaukm.mOrigin = paramCursor.getLong(i);
      break label783;
      label1210:
      paramaukm.mOriginExtra = paramCursor.getLong(i);
      break label818;
      label1225:
      paramaukm.mSelfRight = paramCursor.getInt(i);
      break label853;
      label1240:
      paramaukm.groupCode = paramCursor.getLong(i);
      break label888;
      label1255:
      paramaukm.groupUin = paramCursor.getLong(i);
      break label923;
      label1270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramaukm.hasCollect = paramBoolean;
        break;
      }
      label1298:
      paramaukm.createFrom = paramCursor.getInt(i);
    }
    label1313:
    paramaukm.uiControlFlag = paramCursor.getLong(i);
    return paramaukm;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,infoSeq INTEGER ,ownerUin TEXT ,inheritOwnerUin TEXT ,discussionName TEXT ,createTime INTEGER ,timeSec INTEGER ,faceUinSet TEXT ,DiscussionFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mOrigin INTEGER ,mOriginExtra INTEGER ,mSelfRight INTEGER ,groupCode INTEGER ,groupUin INTEGER ,hasCollect INTEGER ,createFrom INTEGER ,uiControlFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (DiscussionInfo)paramaukm;
    paramContentValues.put("uin", paramaukm.uin);
    paramContentValues.put("infoSeq", Long.valueOf(paramaukm.infoSeq));
    paramContentValues.put("ownerUin", paramaukm.ownerUin);
    paramContentValues.put("inheritOwnerUin", paramaukm.inheritOwnerUin);
    paramContentValues.put("discussionName", paramaukm.discussionName);
    paramContentValues.put("createTime", Long.valueOf(paramaukm.createTime));
    paramContentValues.put("timeSec", Long.valueOf(paramaukm.timeSec));
    paramContentValues.put("faceUinSet", paramaukm.faceUinSet);
    paramContentValues.put("DiscussionFlag", Long.valueOf(paramaukm.DiscussionFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramaukm.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramaukm.mCompareSpell);
    paramContentValues.put("mOrigin", Long.valueOf(paramaukm.mOrigin));
    paramContentValues.put("mOriginExtra", Long.valueOf(paramaukm.mOriginExtra));
    paramContentValues.put("mSelfRight", Integer.valueOf(paramaukm.mSelfRight));
    paramContentValues.put("groupCode", Long.valueOf(paramaukm.groupCode));
    paramContentValues.put("groupUin", Long.valueOf(paramaukm.groupUin));
    paramContentValues.put("hasCollect", Boolean.valueOf(paramaukm.hasCollect));
    paramContentValues.put("createFrom", Integer.valueOf(paramaukm.createFrom));
    paramContentValues.put("uiControlFlag", Long.valueOf(paramaukm.uiControlFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukh
 * JD-Core Version:    0.7.0.1
 */