import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.OGAbstractDao;

public class ayvc
  extends OGAbstractDao
{
  public ayvc()
  {
    this.columnLen = 55;
  }
  
  public Entity cursor2Entity(Entity paramEntity, Cursor paramCursor, boolean paramBoolean, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramEntity = (EmoticonPackage)paramEntity;
    if (paramNoColumnErrorHandler == null)
    {
      paramEntity.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramEntity.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramEntity.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramEntity.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramEntity.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramEntity.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramEntity.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramEntity.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramEntity.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramEntity.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramEntity.hasSound = paramBoolean;
        paramEntity.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramEntity.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label1079;
        }
        paramBoolean = true;
        label277:
        paramEntity.valid = paramBoolean;
        paramEntity.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramEntity.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label1084;
        }
        paramBoolean = true;
        label338:
        paramEntity.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label1089;
        }
        paramBoolean = true;
        label363:
        paramEntity.isMagicFaceDownloading = paramBoolean;
        paramEntity.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramEntity.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramEntity.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramEntity.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramEntity.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramEntity.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramEntity.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label1094;
        }
        paramBoolean = true;
        label514:
        paramEntity.hasReadUpdatePage = paramBoolean;
        paramEntity.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramEntity.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramEntity.extraFlags = paramCursor.getInt(paramCursor.getColumnIndex("extraFlags"));
        paramEntity.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramEntity.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramEntity.isAPNG = paramCursor.getInt(paramCursor.getColumnIndex("isAPNG"));
        paramEntity.copywritingType = paramCursor.getInt(paramCursor.getColumnIndex("copywritingType"));
        paramEntity.diversionName = paramCursor.getString(paramCursor.getColumnIndex("diversionName"));
        paramEntity.copywritingContent = paramCursor.getString(paramCursor.getColumnIndex("copywritingContent"));
        paramEntity.jumpUrl = paramCursor.getString(paramCursor.getColumnIndex("jumpUrl"));
        paramEntity.imageUrl = paramCursor.getString(paramCursor.getColumnIndex("imageUrl"));
        paramEntity.beginTime = paramCursor.getLong(paramCursor.getColumnIndex("beginTime"));
        paramEntity.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
        paramEntity.buttonWording = paramCursor.getString(paramCursor.getColumnIndex("buttonWording"));
        paramEntity.comeFom = paramCursor.getString(paramCursor.getColumnIndex("comeFom"));
        paramEntity.ipUrl = paramCursor.getString(paramCursor.getColumnIndex("ipUrl"));
        paramEntity.ipName = paramCursor.getString(paramCursor.getColumnIndex("ipName"));
        paramEntity.ipDetail = paramCursor.getString(paramCursor.getColumnIndex("ipDetail"));
        paramEntity.ipOpName = paramCursor.getString(paramCursor.getColumnIndex("ipOpName"));
        paramEntity.ipJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("ipJumpUrl"));
        paramEntity.ipReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipReqTime"));
        paramEntity.ipLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("aio"))) {
          break label1099;
        }
        paramBoolean = true;
        label935:
        paramEntity.aio = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandian"))) {
          break label1104;
        }
        paramBoolean = true;
        label960:
        paramEntity.kandian = paramBoolean;
        paramEntity.richIPReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPReqTime"));
        paramEntity.richIPLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasIpProduct"))) {
          break label1109;
        }
        paramBoolean = true;
        label1021:
        paramEntity.hasIpProduct = paramBoolean;
        paramEntity.ipSiteInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("ipSiteInfoBytes"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("newSoundEp"))) {
          break label1114;
        }
      }
      label1079:
      label1084:
      label1089:
      label1094:
      label1099:
      label1104:
      label1109:
      label1114:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramEntity.newSoundEp = paramBoolean;
        return paramEntity;
        paramBoolean = false;
        break;
        paramBoolean = false;
        break label277;
        paramBoolean = false;
        break label338;
        paramBoolean = false;
        break label363;
        paramBoolean = false;
        break label514;
        paramBoolean = false;
        break label935;
        paramBoolean = false;
        break label960;
        paramBoolean = false;
        break label1021;
      }
    }
    int i = paramCursor.getColumnIndex("epId");
    if (i == -1)
    {
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label3065;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("wordingId", Long.TYPE));
      label1189:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label3080;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("childEpId", String.class));
      label1224:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label3095;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("minQQVersion", String.class));
      label1259:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3110;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
      label1294:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label3125;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mark", String.class));
      label1329:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label3140;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("type", Integer.TYPE));
      label1364:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label3155;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("author", String.class));
      label1399:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label3170;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("expiretime", Long.TYPE));
      label1434:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3185;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("status", Integer.TYPE));
      label1469:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label3200;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label3227;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("jobType", Integer.TYPE));
      label1539:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label3242;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("kinId", String.class));
      label1574:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label3257;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label3284;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("downloadCount", Integer.TYPE));
      label1644:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label3299;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1679:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label3314;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label3341;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label3368;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("firstEmotionId", String.class));
      label1784:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label3383;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1819:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label3398;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("localVersion", Integer.TYPE));
      label1854:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label3413;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("latestVersion", Integer.TYPE));
      label1889:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label3428;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("jsonVersion", Integer.TYPE));
      label1924:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label3443;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("updateFlag", Integer.TYPE));
      label1959:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label3458;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("updateTip", String.class));
      label1994:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label3473;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label3500;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("rscType", Integer.TYPE));
      label2064:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label3515;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("supportSize", String.class));
      label2099:
      i = paramCursor.getColumnIndex("extraFlags");
      if (i != -1) {
        break label3530;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("extraFlags", Integer.TYPE));
      label2134:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label3545;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("businessExtra", String.class));
      label2169:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label3560;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("subType", Integer.TYPE));
      label2204:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label3575;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("isAPNG", Integer.TYPE));
      label2239:
      i = paramCursor.getColumnIndex("copywritingType");
      if (i != -1) {
        break label3590;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("copywritingType", Integer.TYPE));
      label2274:
      i = paramCursor.getColumnIndex("diversionName");
      if (i != -1) {
        break label3605;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("diversionName", String.class));
      label2309:
      i = paramCursor.getColumnIndex("copywritingContent");
      if (i != -1) {
        break label3620;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("copywritingContent", String.class));
      label2344:
      i = paramCursor.getColumnIndex("jumpUrl");
      if (i != -1) {
        break label3635;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("jumpUrl", String.class));
      label2379:
      i = paramCursor.getColumnIndex("imageUrl");
      if (i != -1) {
        break label3650;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("imageUrl", String.class));
      label2414:
      i = paramCursor.getColumnIndex("beginTime");
      if (i != -1) {
        break label3665;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("beginTime", Long.TYPE));
      label2449:
      i = paramCursor.getColumnIndex("endTime");
      if (i != -1) {
        break label3680;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("endTime", Long.TYPE));
      label2484:
      i = paramCursor.getColumnIndex("buttonWording");
      if (i != -1) {
        break label3695;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("buttonWording", String.class));
      label2519:
      i = paramCursor.getColumnIndex("comeFom");
      if (i != -1) {
        break label3710;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("comeFom", String.class));
      label2554:
      i = paramCursor.getColumnIndex("ipUrl");
      if (i != -1) {
        break label3725;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipUrl", String.class));
      label2589:
      i = paramCursor.getColumnIndex("ipName");
      if (i != -1) {
        break label3740;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipName", String.class));
      label2624:
      i = paramCursor.getColumnIndex("ipDetail");
      if (i != -1) {
        break label3755;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipDetail", String.class));
      label2659:
      i = paramCursor.getColumnIndex("ipOpName");
      if (i != -1) {
        break label3770;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipOpName", String.class));
      label2694:
      i = paramCursor.getColumnIndex("ipJumpUrl");
      if (i != -1) {
        break label3785;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipJumpUrl", String.class));
      label2729:
      i = paramCursor.getColumnIndex("ipReqTime");
      if (i != -1) {
        break label3800;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipReqTime", Long.TYPE));
      label2764:
      i = paramCursor.getColumnIndex("ipLastReqTime");
      if (i != -1) {
        break label3815;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipLastReqTime", Long.TYPE));
      label2799:
      i = paramCursor.getColumnIndex("aio");
      if (i != -1) {
        break label3830;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("aio", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandian");
      if (i != -1) {
        break label3857;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("kandian", Boolean.TYPE));
      i = paramCursor.getColumnIndex("richIPReqTime");
      if (i != -1) {
        break label3884;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richIPReqTime", Long.TYPE));
      label2904:
      i = paramCursor.getColumnIndex("richIPLastReqTime");
      if (i != -1) {
        break label3899;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("richIPLastReqTime", Long.TYPE));
      label2939:
      i = paramCursor.getColumnIndex("hasIpProduct");
      if (i != -1) {
        break label3914;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("hasIpProduct", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipSiteInfoBytes");
      if (i != -1) {
        break label3941;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("ipSiteInfoBytes", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("newSoundEp");
      if (i != -1) {
        break label3956;
      }
      paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError("newSoundEp", Boolean.TYPE));
      return paramEntity;
      paramEntity.epId = paramCursor.getString(i);
      break;
      label3065:
      paramEntity.wordingId = paramCursor.getLong(i);
      break label1189;
      label3080:
      paramEntity.childEpId = paramCursor.getString(i);
      break label1224;
      label3095:
      paramEntity.minQQVersion = paramCursor.getString(i);
      break label1259;
      label3110:
      paramEntity.name = paramCursor.getString(i);
      break label1294;
      label3125:
      paramEntity.mark = paramCursor.getString(i);
      break label1329;
      label3140:
      paramEntity.type = paramCursor.getInt(i);
      break label1364;
      label3155:
      paramEntity.author = paramCursor.getString(i);
      break label1399;
      label3170:
      paramEntity.expiretime = paramCursor.getLong(i);
      break label1434;
      label3185:
      paramEntity.status = paramCursor.getInt(i);
      break label1469;
      label3200:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasSound = paramBoolean;
        break;
      }
      label3227:
      paramEntity.jobType = paramCursor.getInt(i);
      break label1539;
      label3242:
      paramEntity.kinId = paramCursor.getString(i);
      break label1574;
      label3257:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.valid = paramBoolean;
        break;
      }
      label3284:
      paramEntity.downloadCount = paramCursor.getInt(i);
      break label1644;
      label3299:
      paramEntity.mobileFeetype = paramCursor.getInt(i);
      break label1679;
      label3314:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isRecommendation = paramBoolean;
        break;
      }
      label3341:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label3368:
      paramEntity.firstEmotionId = paramCursor.getString(i);
      break label1784;
      label3383:
      paramEntity.upperLeftLable = paramCursor.getInt(i);
      break label1819;
      label3398:
      paramEntity.localVersion = paramCursor.getInt(i);
      break label1854;
      label3413:
      paramEntity.latestVersion = paramCursor.getInt(i);
      break label1889;
      label3428:
      paramEntity.jsonVersion = paramCursor.getInt(i);
      break label1924;
      label3443:
      paramEntity.updateFlag = paramCursor.getInt(i);
      break label1959;
      label3458:
      paramEntity.updateTip = paramCursor.getString(i);
      break label1994;
      label3473:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasReadUpdatePage = paramBoolean;
        break;
      }
      label3500:
      paramEntity.rscType = paramCursor.getInt(i);
      break label2064;
      label3515:
      paramEntity.supportSize = paramCursor.getString(i);
      break label2099;
      label3530:
      paramEntity.extraFlags = paramCursor.getInt(i);
      break label2134;
      label3545:
      paramEntity.businessExtra = paramCursor.getString(i);
      break label2169;
      label3560:
      paramEntity.subType = paramCursor.getInt(i);
      break label2204;
      label3575:
      paramEntity.isAPNG = paramCursor.getInt(i);
      break label2239;
      label3590:
      paramEntity.copywritingType = paramCursor.getInt(i);
      break label2274;
      label3605:
      paramEntity.diversionName = paramCursor.getString(i);
      break label2309;
      label3620:
      paramEntity.copywritingContent = paramCursor.getString(i);
      break label2344;
      label3635:
      paramEntity.jumpUrl = paramCursor.getString(i);
      break label2379;
      label3650:
      paramEntity.imageUrl = paramCursor.getString(i);
      break label2414;
      label3665:
      paramEntity.beginTime = paramCursor.getLong(i);
      break label2449;
      label3680:
      paramEntity.endTime = paramCursor.getLong(i);
      break label2484;
      label3695:
      paramEntity.buttonWording = paramCursor.getString(i);
      break label2519;
      label3710:
      paramEntity.comeFom = paramCursor.getString(i);
      break label2554;
      label3725:
      paramEntity.ipUrl = paramCursor.getString(i);
      break label2589;
      label3740:
      paramEntity.ipName = paramCursor.getString(i);
      break label2624;
      label3755:
      paramEntity.ipDetail = paramCursor.getString(i);
      break label2659;
      label3770:
      paramEntity.ipOpName = paramCursor.getString(i);
      break label2694;
      label3785:
      paramEntity.ipJumpUrl = paramCursor.getString(i);
      break label2729;
      label3800:
      paramEntity.ipReqTime = paramCursor.getLong(i);
      break label2764;
      label3815:
      paramEntity.ipLastReqTime = paramCursor.getLong(i);
      break label2799;
      label3830:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.aio = paramBoolean;
        break;
      }
      label3857:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.kandian = paramBoolean;
        break;
      }
      label3884:
      paramEntity.richIPReqTime = paramCursor.getLong(i);
      break label2904;
      label3899:
      paramEntity.richIPLastReqTime = paramCursor.getLong(i);
      break label2939;
      label3914:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramEntity.hasIpProduct = paramBoolean;
        break;
      }
      label3941:
      paramEntity.ipSiteInfoBytes = paramCursor.getBlob(i);
    }
    label3956:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramEntity.newSoundEp = paramBoolean;
      return paramEntity;
    }
  }
  
  public void entity2ContentValues(Entity paramEntity, ContentValues paramContentValues)
  {
    paramEntity = (EmoticonPackage)paramEntity;
    paramContentValues.put("epId", paramEntity.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramEntity.wordingId));
    paramContentValues.put("childEpId", paramEntity.childEpId);
    paramContentValues.put("minQQVersion", paramEntity.minQQVersion);
    paramContentValues.put("name", paramEntity.name);
    paramContentValues.put("mark", paramEntity.mark);
    paramContentValues.put("type", Integer.valueOf(paramEntity.type));
    paramContentValues.put("author", paramEntity.author);
    paramContentValues.put("expiretime", Long.valueOf(paramEntity.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramEntity.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramEntity.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramEntity.jobType));
    paramContentValues.put("kinId", paramEntity.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramEntity.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramEntity.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramEntity.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramEntity.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramEntity.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramEntity.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramEntity.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramEntity.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramEntity.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramEntity.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramEntity.updateFlag));
    paramContentValues.put("updateTip", paramEntity.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramEntity.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramEntity.rscType));
    paramContentValues.put("supportSize", paramEntity.supportSize);
    paramContentValues.put("extraFlags", Integer.valueOf(paramEntity.extraFlags));
    paramContentValues.put("businessExtra", paramEntity.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramEntity.subType));
    paramContentValues.put("isAPNG", Integer.valueOf(paramEntity.isAPNG));
    paramContentValues.put("copywritingType", Integer.valueOf(paramEntity.copywritingType));
    paramContentValues.put("diversionName", paramEntity.diversionName);
    paramContentValues.put("copywritingContent", paramEntity.copywritingContent);
    paramContentValues.put("jumpUrl", paramEntity.jumpUrl);
    paramContentValues.put("imageUrl", paramEntity.imageUrl);
    paramContentValues.put("beginTime", Long.valueOf(paramEntity.beginTime));
    paramContentValues.put("endTime", Long.valueOf(paramEntity.endTime));
    paramContentValues.put("buttonWording", paramEntity.buttonWording);
    paramContentValues.put("comeFom", paramEntity.comeFom);
    paramContentValues.put("ipUrl", paramEntity.ipUrl);
    paramContentValues.put("ipName", paramEntity.ipName);
    paramContentValues.put("ipDetail", paramEntity.ipDetail);
    paramContentValues.put("ipOpName", paramEntity.ipOpName);
    paramContentValues.put("ipJumpUrl", paramEntity.ipJumpUrl);
    paramContentValues.put("ipReqTime", Long.valueOf(paramEntity.ipReqTime));
    paramContentValues.put("ipLastReqTime", Long.valueOf(paramEntity.ipLastReqTime));
    paramContentValues.put("aio", Boolean.valueOf(paramEntity.aio));
    paramContentValues.put("kandian", Boolean.valueOf(paramEntity.kandian));
    paramContentValues.put("richIPReqTime", Long.valueOf(paramEntity.richIPReqTime));
    paramContentValues.put("richIPLastReqTime", Long.valueOf(paramEntity.richIPLastReqTime));
    paramContentValues.put("hasIpProduct", Boolean.valueOf(paramEntity.hasIpProduct));
    paramContentValues.put("ipSiteInfoBytes", paramEntity.ipSiteInfoBytes);
    paramContentValues.put("newSoundEp", Boolean.valueOf(paramEntity.newSoundEp));
  }
  
  public String getCreateTableSql(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,extraFlags INTEGER ,businessExtra TEXT ,subType INTEGER ,isAPNG INTEGER ,copywritingType INTEGER ,diversionName TEXT ,copywritingContent TEXT ,jumpUrl TEXT ,imageUrl TEXT ,beginTime INTEGER ,endTime INTEGER ,buttonWording TEXT ,comeFom TEXT ,ipUrl TEXT ,ipName TEXT ,ipDetail TEXT ,ipOpName TEXT ,ipJumpUrl TEXT ,ipReqTime INTEGER ,ipLastReqTime INTEGER ,aio INTEGER ,kandian INTEGER ,richIPReqTime INTEGER ,richIPLastReqTime INTEGER ,hasIpProduct INTEGER ,ipSiteInfoBytes BLOB ,newSoundEp INTEGER)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvc
 * JD-Core Version:    0.7.0.1
 */