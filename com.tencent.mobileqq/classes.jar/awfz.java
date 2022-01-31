import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awfz
  extends awgq
{
  public awfz()
  {
    this.a = 19;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool = true;
    paramBoolean = true;
    paramawge = (DiscussionInfo)paramawge;
    if (paramawgp == null)
    {
      paramawge.uin = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      paramawge.infoSeq = paramCursor.getLong(paramCursor.getColumnIndex("infoSeq"));
      paramawge.ownerUin = paramCursor.getString(paramCursor.getColumnIndex("ownerUin"));
      paramawge.inheritOwnerUin = paramCursor.getString(paramCursor.getColumnIndex("inheritOwnerUin"));
      paramawge.discussionName = paramCursor.getString(paramCursor.getColumnIndex("discussionName"));
      paramawge.createTime = paramCursor.getLong(paramCursor.getColumnIndex("createTime"));
      paramawge.timeSec = paramCursor.getLong(paramCursor.getColumnIndex("timeSec"));
      paramawge.faceUinSet = paramCursor.getString(paramCursor.getColumnIndex("faceUinSet"));
      paramawge.DiscussionFlag = paramCursor.getLong(paramCursor.getColumnIndex("DiscussionFlag"));
      paramawge.mComparePartInt = paramCursor.getInt(paramCursor.getColumnIndex("mComparePartInt"));
      paramawge.mCompareSpell = paramCursor.getString(paramCursor.getColumnIndex("mCompareSpell"));
      paramawge.mOrigin = paramCursor.getLong(paramCursor.getColumnIndex("mOrigin"));
      paramawge.mOriginExtra = paramCursor.getLong(paramCursor.getColumnIndex("mOriginExtra"));
      paramawge.mSelfRight = paramCursor.getInt(paramCursor.getColumnIndex("mSelfRight"));
      paramawge.groupCode = paramCursor.getLong(paramCursor.getColumnIndex("groupCode"));
      paramawge.groupUin = paramCursor.getLong(paramCursor.getColumnIndex("groupUin"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasCollect"))) {}
      for (;;)
      {
        paramawge.hasCollect = paramBoolean;
        paramawge.createFrom = paramCursor.getInt(paramCursor.getColumnIndex("createFrom"));
        paramawge.uiControlFlag = paramCursor.getLong(paramCursor.getColumnIndex("uiControlFlag"));
        return paramawge;
        paramBoolean = false;
      }
    }
    int i = paramCursor.getColumnIndex("uin");
    if (i == -1)
    {
      paramawgp.a(new NoColumnError("uin", String.class));
      i = paramCursor.getColumnIndex("infoSeq");
      if (i != -1) {
        break label1045;
      }
      paramawgp.a(new NoColumnError("infoSeq", Long.TYPE));
      label438:
      i = paramCursor.getColumnIndex("ownerUin");
      if (i != -1) {
        break label1060;
      }
      paramawgp.a(new NoColumnError("ownerUin", String.class));
      label472:
      i = paramCursor.getColumnIndex("inheritOwnerUin");
      if (i != -1) {
        break label1075;
      }
      paramawgp.a(new NoColumnError("inheritOwnerUin", String.class));
      label506:
      i = paramCursor.getColumnIndex("discussionName");
      if (i != -1) {
        break label1090;
      }
      paramawgp.a(new NoColumnError("discussionName", String.class));
      label540:
      i = paramCursor.getColumnIndex("createTime");
      if (i != -1) {
        break label1105;
      }
      paramawgp.a(new NoColumnError("createTime", Long.TYPE));
      label575:
      i = paramCursor.getColumnIndex("timeSec");
      if (i != -1) {
        break label1120;
      }
      paramawgp.a(new NoColumnError("timeSec", Long.TYPE));
      label610:
      i = paramCursor.getColumnIndex("faceUinSet");
      if (i != -1) {
        break label1135;
      }
      paramawgp.a(new NoColumnError("faceUinSet", String.class));
      label644:
      i = paramCursor.getColumnIndex("DiscussionFlag");
      if (i != -1) {
        break label1150;
      }
      paramawgp.a(new NoColumnError("DiscussionFlag", Long.TYPE));
      label679:
      i = paramCursor.getColumnIndex("mComparePartInt");
      if (i != -1) {
        break label1165;
      }
      paramawgp.a(new NoColumnError("mComparePartInt", Integer.TYPE));
      label714:
      i = paramCursor.getColumnIndex("mCompareSpell");
      if (i != -1) {
        break label1180;
      }
      paramawgp.a(new NoColumnError("mCompareSpell", String.class));
      label748:
      i = paramCursor.getColumnIndex("mOrigin");
      if (i != -1) {
        break label1195;
      }
      paramawgp.a(new NoColumnError("mOrigin", Long.TYPE));
      label783:
      i = paramCursor.getColumnIndex("mOriginExtra");
      if (i != -1) {
        break label1210;
      }
      paramawgp.a(new NoColumnError("mOriginExtra", Long.TYPE));
      label818:
      i = paramCursor.getColumnIndex("mSelfRight");
      if (i != -1) {
        break label1225;
      }
      paramawgp.a(new NoColumnError("mSelfRight", Integer.TYPE));
      label853:
      i = paramCursor.getColumnIndex("groupCode");
      if (i != -1) {
        break label1240;
      }
      paramawgp.a(new NoColumnError("groupCode", Long.TYPE));
      label888:
      i = paramCursor.getColumnIndex("groupUin");
      if (i != -1) {
        break label1255;
      }
      paramawgp.a(new NoColumnError("groupUin", Long.TYPE));
      label923:
      i = paramCursor.getColumnIndex("hasCollect");
      if (i != -1) {
        break label1270;
      }
      paramawgp.a(new NoColumnError("hasCollect", Boolean.TYPE));
      i = paramCursor.getColumnIndex("createFrom");
      if (i != -1) {
        break label1298;
      }
      paramawgp.a(new NoColumnError("createFrom", Integer.TYPE));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("uiControlFlag");
      if (i != -1) {
        break label1313;
      }
      paramawgp.a(new NoColumnError("uiControlFlag", Long.TYPE));
      return paramawge;
      paramawge.uin = paramCursor.getString(i);
      break;
      label1045:
      paramawge.infoSeq = paramCursor.getLong(i);
      break label438;
      label1060:
      paramawge.ownerUin = paramCursor.getString(i);
      break label472;
      label1075:
      paramawge.inheritOwnerUin = paramCursor.getString(i);
      break label506;
      label1090:
      paramawge.discussionName = paramCursor.getString(i);
      break label540;
      label1105:
      paramawge.createTime = paramCursor.getLong(i);
      break label575;
      label1120:
      paramawge.timeSec = paramCursor.getLong(i);
      break label610;
      label1135:
      paramawge.faceUinSet = paramCursor.getString(i);
      break label644;
      label1150:
      paramawge.DiscussionFlag = paramCursor.getLong(i);
      break label679;
      label1165:
      paramawge.mComparePartInt = paramCursor.getInt(i);
      break label714;
      label1180:
      paramawge.mCompareSpell = paramCursor.getString(i);
      break label748;
      label1195:
      paramawge.mOrigin = paramCursor.getLong(i);
      break label783;
      label1210:
      paramawge.mOriginExtra = paramCursor.getLong(i);
      break label818;
      label1225:
      paramawge.mSelfRight = paramCursor.getInt(i);
      break label853;
      label1240:
      paramawge.groupCode = paramCursor.getLong(i);
      break label888;
      label1255:
      paramawge.groupUin = paramCursor.getLong(i);
      break label923;
      label1270:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = bool;; paramBoolean = false)
      {
        paramawge.hasCollect = paramBoolean;
        break;
      }
      label1298:
      paramawge.createFrom = paramCursor.getInt(i);
    }
    label1313:
    paramawge.uiControlFlag = paramCursor.getLong(i);
    return paramawge;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin TEXT UNIQUE ,infoSeq INTEGER ,ownerUin TEXT ,inheritOwnerUin TEXT ,discussionName TEXT ,createTime INTEGER ,timeSec INTEGER ,faceUinSet TEXT ,DiscussionFlag INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,mOrigin INTEGER ,mOriginExtra INTEGER ,mSelfRight INTEGER ,groupCode INTEGER ,groupUin INTEGER ,hasCollect INTEGER ,createFrom INTEGER ,uiControlFlag INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (DiscussionInfo)paramawge;
    paramContentValues.put("uin", paramawge.uin);
    paramContentValues.put("infoSeq", Long.valueOf(paramawge.infoSeq));
    paramContentValues.put("ownerUin", paramawge.ownerUin);
    paramContentValues.put("inheritOwnerUin", paramawge.inheritOwnerUin);
    paramContentValues.put("discussionName", paramawge.discussionName);
    paramContentValues.put("createTime", Long.valueOf(paramawge.createTime));
    paramContentValues.put("timeSec", Long.valueOf(paramawge.timeSec));
    paramContentValues.put("faceUinSet", paramawge.faceUinSet);
    paramContentValues.put("DiscussionFlag", Long.valueOf(paramawge.DiscussionFlag));
    paramContentValues.put("mComparePartInt", Integer.valueOf(paramawge.mComparePartInt));
    paramContentValues.put("mCompareSpell", paramawge.mCompareSpell);
    paramContentValues.put("mOrigin", Long.valueOf(paramawge.mOrigin));
    paramContentValues.put("mOriginExtra", Long.valueOf(paramawge.mOriginExtra));
    paramContentValues.put("mSelfRight", Integer.valueOf(paramawge.mSelfRight));
    paramContentValues.put("groupCode", Long.valueOf(paramawge.groupCode));
    paramContentValues.put("groupUin", Long.valueOf(paramawge.groupUin));
    paramContentValues.put("hasCollect", Boolean.valueOf(paramawge.hasCollect));
    paramContentValues.put("createFrom", Integer.valueOf(paramawge.createFrom));
    paramContentValues.put("uiControlFlag", Long.valueOf(paramawge.uiControlFlag));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awfz
 * JD-Core Version:    0.7.0.1
 */