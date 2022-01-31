import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmj
  extends atna
{
  public atmj()
  {
    this.a = 19;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool = true;
    paramBoolean = true;
    paramatmo = (DiscussionInfo)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramatmo.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
      paramatmo.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramatmo.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      paramatmo.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      paramatmo.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      paramatmo.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramatmo.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
      paramatmo.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
      paramatmo.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramatmo.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramatmo.mOrigin = paramCursor.getLong(paramCursor.getColumnIndex("mOrigin"));
      paramatmo.mOriginExtra = paramCursor.getLong(paramCursor.getColumnIndex("mOriginExtra"));
      paramatmo.mSelfRight = paramCursor.getInt(paramCursor.getColumnIndex("mSelfRight"));
      paramatmo.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
      paramatmo.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasCollect"))) {}
      for (;;)
      {
        paramatmo.hasCollect = paramBoolean;
        paramatmo.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
        paramatmo.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
        return paramatmo;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramatmz.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("infoSeq");
      if (i != -1) {
        break label1045;
      }
      paramatmz.a(new NoColumnError("infoSeq", Long.TYPE));
      label438:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label1060;
      }
      paramatmz.a(new NoColumnError("ownerUin", String.class));
      label472:
      i = paramCursor.getColumnIndex("inheritOwnerUin");
      if (i != -1) {
        break label1075;
      }
      paramatmz.a(new NoColumnError("inheritOwnerUin", String.class));
      label506:
      i = paramCursor.getColumnIndex("discussionName");
      if (i != -1) {
        break label1090;
      }
      paramatmz.a(new NoColumnError("discussionName", String.class));
      label540:
      i = paramCursor.getColumnIndex("createTime");
      if (i != -1) {
        break label1105;
      }
      paramatmz.a(new NoColumnError("createTime", Long.TYPE));
      label575:
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label1120;
      }
      paramatmz.a(new NoColumnError("timeSec", Long.TYPE));
      label610:
      i = paramCursor.getColumnIndex("faceUinSet");
      if (i != -1) {
        break label1135;
      }
      paramatmz.a(new NoColumnError("faceUinSet", String.class));
      label644:
      i = paramCursor.getColumnIndex("DiscussionFlag");
      if (i != -1) {
        break label1150;
      }
      paramatmz.a(new NoColumnError("DiscussionFlag", Long.TYPE));
      label679:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1165;
      }
      paramatmz.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label714:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1180;
      }
      paramatmz.a(new NoColumnError("mCompareSpell", String.class));
      label748:
      i = paramCursor.getColumnIndex("mOrigin");
      if (i != -1) {
        break label1195;
      }
      paramatmz.a(new NoColumnError("mOrigin", Long.TYPE));
      label783:
      i = paramCursor.getColumnIndex("mOriginExtra");
      if (i != -1) {
        break label1210;
      }
      paramatmz.a(new NoColumnError("mOriginExtra", Long.TYPE));
      label818:
      i = paramCursor.getColumnIndex("mSelfRight");
      if (i != -1) {
        break label1225;
      }
      paramatmz.a(new NoColumnError("mSelfRight", Integer.TYPE));
      label853:
      i = paramCursor.getColumnIndex("groupCode");
      if (i != -1) {
        break label1240;
      }
      paramatmz.a(new NoColumnError("groupCode", Long.TYPE));
      label888:
      i = paramCursor.getColumnIndex("groupUin");
      if (i != -1) {
        break label1255;
      }
      paramatmz.a(new NoColumnError("groupUin", Long.TYPE));
      label923:
      i = paramCursor.getColumnIndex("hasCollect");
      if (i != -1) {
        break label1270;
      }
      paramatmz.a(new NoColumnError("hasCollect", Boolean.TYPE));
      i = paramCursor.getColumnIndex("createFrom");
      if (i != -1) {
        break label1298;
      }
      paramatmz.a(new NoColumnError("createFrom", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("uiControlFlag");
      if (i != -1) {
        break label1313;
      }
      paramatmz.a(new NoColumnError("uiControlFlag", Long.TYPE));
      return paramatmo;
      paramatmo.uin = paramCursor.getString(i);
      break;
      label1045:
      paramatmo.infoSeq = paramCursor.getLong(i);
      break label438;
      label1060:
      paramatmo.ownerUin = paramCursor.getString(i);
      break label472;
      label1075:
      paramatmo.inheritOwnerUin = paramCursor.getString(i);
      break label506;
      label1090:
      paramatmo.discussionName = paramCursor.getString(i);
      break label540;
      label1105:
      paramatmo.createTime = paramCursor.getLong(i);
      break label575;
      label1120:
      paramatmo.timeSec = paramCursor.getLong(i);
      break label610;
      label1135:
      paramatmo.faceUinSet = paramCursor.getString(i);
      break label644;
      label1150:
      paramatmo.DiscussionFlag = paramCursor.getLong(i);
      break label679;
      label1165:
      paramatmo.mComparePartInt = paramCursor.getInt(i);
      break label714;
      label1180:
      paramatmo.mCompareSpell = paramCursor.getString(i);
      break label748;
      label1195:
      paramatmo.mOrigin = paramCursor.getLong(i);
      break label783;
      label1210:
      paramatmo.mOriginExtra = paramCursor.getLong(i);
      break label818;
      label1225:
      paramatmo.mSelfRight = paramCursor.getInt(i);
      break label853;
      label1240:
      paramatmo.groupCode = paramCursor.getLong(i);
      break label888;
      label1255:
      paramatmo.groupUin = paramCursor.getLong(i);
      break label923;
      label1270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramatmo.hasCollect = paramBoolean;
        break;
      }
      label1298:
      paramatmo.createFrom = paramCursor.getInt(i);
    }
    label1313:
    paramatmo.uiControlFlag = paramCursor.getLong(i);
    return paramatmo;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,infoSeq INTEGER ,ownerUin TEXT ,inheritOwnerUin TEXT ,discussionName TEXT ,createTime INTEGER ,timeSec INTEGER ,faceUinSet TEXT ,DiscussionFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mOrigin INTEGER ,mOriginExtra INTEGER ,mSelfRight INTEGER ,groupCode INTEGER ,groupUin INTEGER ,hasCollect INTEGER ,createFrom INTEGER ,uiControlFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (DiscussionInfo)paramatmo;
    paramContentValues.put("uin", paramatmo.uin);
    paramContentValues.put("infoSeq", Long.valueOf(paramatmo.infoSeq));
    paramContentValues.put("ownerUin", paramatmo.ownerUin);
    paramContentValues.put("inheritOwnerUin", paramatmo.inheritOwnerUin);
    paramContentValues.put("discussionName", paramatmo.discussionName);
    paramContentValues.put("createTime", Long.valueOf(paramatmo.createTime));
    paramContentValues.put("timeSec", Long.valueOf(paramatmo.timeSec));
    paramContentValues.put("faceUinSet", paramatmo.faceUinSet);
    paramContentValues.put("DiscussionFlag", Long.valueOf(paramatmo.DiscussionFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramatmo.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramatmo.mCompareSpell);
    paramContentValues.put("mOrigin", Long.valueOf(paramatmo.mOrigin));
    paramContentValues.put("mOriginExtra", Long.valueOf(paramatmo.mOriginExtra));
    paramContentValues.put("mSelfRight", Integer.valueOf(paramatmo.mSelfRight));
    paramContentValues.put("groupCode", Long.valueOf(paramatmo.groupCode));
    paramContentValues.put("groupUin", Long.valueOf(paramatmo.groupUin));
    paramContentValues.put("hasCollect", Boolean.valueOf(paramatmo.hasCollect));
    paramContentValues.put("createFrom", Integer.valueOf(paramatmo.createFrom));
    paramContentValues.put("uiControlFlag", Long.valueOf(paramatmo.uiControlFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmj
 * JD-Core Version:    0.7.0.1
 */