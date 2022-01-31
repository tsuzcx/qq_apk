import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukm
  extends aula
{
  public aukm()
  {
    this.a = 55;
  }
  
  public auko a(auko paramauko, Cursor paramCursor, boolean paramBoolean, aukz paramaukz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramauko = (EmoticonPackage)paramauko;
    if (paramaukz == null)
    {
      paramauko.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramauko.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramauko.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramauko.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramauko.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramauko.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramauko.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramauko.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramauko.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramauko.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramauko.hasSound = paramBoolean;
        paramauko.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramauko.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label1078;
        }
        paramBoolean = true;
        label277:
        paramauko.valid = paramBoolean;
        paramauko.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramauko.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label1083;
        }
        paramBoolean = true;
        label338:
        paramauko.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label1088;
        }
        paramBoolean = true;
        label363:
        paramauko.isMagicFaceDownloading = paramBoolean;
        paramauko.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramauko.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramauko.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramauko.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramauko.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramauko.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramauko.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label1093;
        }
        paramBoolean = true;
        label514:
        paramauko.hasReadUpdatePage = paramBoolean;
        paramauko.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramauko.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramauko.extraFlags = paramCursor.getInt(paramCursor.getColumnIndex("extraFlags"));
        paramauko.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramauko.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramauko.isAPNG = paramCursor.getInt(paramCursor.getColumnIndex("isAPNG"));
        paramauko.copywritingType = paramCursor.getInt(paramCursor.getColumnIndex("copywritingType"));
        paramauko.diversionName = paramCursor.getString(paramCursor.getColumnIndex("diversionName"));
        paramauko.copywritingContent = paramCursor.getString(paramCursor.getColumnIndex("copywritingContent"));
        paramauko.jumpUrl = paramCursor.getString(paramCursor.getColumnIndex("jumpUrl"));
        paramauko.imageUrl = paramCursor.getString(paramCursor.getColumnIndex("imageUrl"));
        paramauko.beginTime = paramCursor.getLong(paramCursor.getColumnIndex("beginTime"));
        paramauko.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
        paramauko.buttonWording = paramCursor.getString(paramCursor.getColumnIndex("buttonWording"));
        paramauko.comeFom = paramCursor.getString(paramCursor.getColumnIndex("comeFom"));
        paramauko.ipUrl = paramCursor.getString(paramCursor.getColumnIndex("ipUrl"));
        paramauko.ipName = paramCursor.getString(paramCursor.getColumnIndex("ipName"));
        paramauko.ipDetail = paramCursor.getString(paramCursor.getColumnIndex("ipDetail"));
        paramauko.ipOpName = paramCursor.getString(paramCursor.getColumnIndex("ipOpName"));
        paramauko.ipJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("ipJumpUrl"));
        paramauko.ipReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipReqTime"));
        paramauko.ipLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("aio"))) {
          break label1098;
        }
        paramBoolean = true;
        label935:
        paramauko.aio = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandian"))) {
          break label1103;
        }
        paramBoolean = true;
        label960:
        paramauko.kandian = paramBoolean;
        paramauko.richIPReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPReqTime"));
        paramauko.richIPLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasIpProduct"))) {
          break label1108;
        }
        paramBoolean = true;
        label1021:
        paramauko.hasIpProduct = paramBoolean;
        paramauko.ipSiteInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("ipSiteInfoBytes"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("newSoundEp"))) {
          break label1113;
        }
      }
      label1078:
      label1083:
      label1088:
      label1093:
      label1098:
      label1103:
      label1108:
      label1113:
      for (paramBoolean = bool1;; paramBoolean = false)
      {
        paramauko.newSoundEp = paramBoolean;
        return paramauko;
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
      paramaukz.a(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label3062;
      }
      paramaukz.a(new NoColumnError("wordingId", Long.TYPE));
      label1188:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label3077;
      }
      paramaukz.a(new NoColumnError("childEpId", String.class));
      label1223:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label3092;
      }
      paramaukz.a(new NoColumnError("minQQVersion", String.class));
      label1258:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3107;
      }
      paramaukz.a(new NoColumnError("name", String.class));
      label1293:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label3122;
      }
      paramaukz.a(new NoColumnError("mark", String.class));
      label1328:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label3137;
      }
      paramaukz.a(new NoColumnError("type", Integer.TYPE));
      label1363:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label3152;
      }
      paramaukz.a(new NoColumnError("author", String.class));
      label1398:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label3167;
      }
      paramaukz.a(new NoColumnError("expiretime", Long.TYPE));
      label1433:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3182;
      }
      paramaukz.a(new NoColumnError("status", Integer.TYPE));
      label1468:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label3197;
      }
      paramaukz.a(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label3224;
      }
      paramaukz.a(new NoColumnError("jobType", Integer.TYPE));
      label1538:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label3239;
      }
      paramaukz.a(new NoColumnError("kinId", String.class));
      label1573:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label3254;
      }
      paramaukz.a(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label3281;
      }
      paramaukz.a(new NoColumnError("downloadCount", Integer.TYPE));
      label1643:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label3296;
      }
      paramaukz.a(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1678:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label3311;
      }
      paramaukz.a(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label3338;
      }
      paramaukz.a(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label3365;
      }
      paramaukz.a(new NoColumnError("firstEmotionId", String.class));
      label1783:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label3380;
      }
      paramaukz.a(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1818:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label3395;
      }
      paramaukz.a(new NoColumnError("localVersion", Integer.TYPE));
      label1853:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label3410;
      }
      paramaukz.a(new NoColumnError("latestVersion", Integer.TYPE));
      label1888:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label3425;
      }
      paramaukz.a(new NoColumnError("jsonVersion", Integer.TYPE));
      label1923:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label3440;
      }
      paramaukz.a(new NoColumnError("updateFlag", Integer.TYPE));
      label1958:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label3455;
      }
      paramaukz.a(new NoColumnError("updateTip", String.class));
      label1993:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label3470;
      }
      paramaukz.a(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label3497;
      }
      paramaukz.a(new NoColumnError("rscType", Integer.TYPE));
      label2063:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label3512;
      }
      paramaukz.a(new NoColumnError("supportSize", String.class));
      label2098:
      i = paramCursor.getColumnIndex("extraFlags");
      if (i != -1) {
        break label3527;
      }
      paramaukz.a(new NoColumnError("extraFlags", Integer.TYPE));
      label2133:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label3542;
      }
      paramaukz.a(new NoColumnError("businessExtra", String.class));
      label2168:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label3557;
      }
      paramaukz.a(new NoColumnError("subType", Integer.TYPE));
      label2203:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label3572;
      }
      paramaukz.a(new NoColumnError("isAPNG", Integer.TYPE));
      label2238:
      i = paramCursor.getColumnIndex("copywritingType");
      if (i != -1) {
        break label3587;
      }
      paramaukz.a(new NoColumnError("copywritingType", Integer.TYPE));
      label2273:
      i = paramCursor.getColumnIndex("diversionName");
      if (i != -1) {
        break label3602;
      }
      paramaukz.a(new NoColumnError("diversionName", String.class));
      label2308:
      i = paramCursor.getColumnIndex("copywritingContent");
      if (i != -1) {
        break label3617;
      }
      paramaukz.a(new NoColumnError("copywritingContent", String.class));
      label2343:
      i = paramCursor.getColumnIndex("jumpUrl");
      if (i != -1) {
        break label3632;
      }
      paramaukz.a(new NoColumnError("jumpUrl", String.class));
      label2378:
      i = paramCursor.getColumnIndex("imageUrl");
      if (i != -1) {
        break label3647;
      }
      paramaukz.a(new NoColumnError("imageUrl", String.class));
      label2413:
      i = paramCursor.getColumnIndex("beginTime");
      if (i != -1) {
        break label3662;
      }
      paramaukz.a(new NoColumnError("beginTime", Long.TYPE));
      label2448:
      i = paramCursor.getColumnIndex("endTime");
      if (i != -1) {
        break label3677;
      }
      paramaukz.a(new NoColumnError("endTime", Long.TYPE));
      label2483:
      i = paramCursor.getColumnIndex("buttonWording");
      if (i != -1) {
        break label3692;
      }
      paramaukz.a(new NoColumnError("buttonWording", String.class));
      label2518:
      i = paramCursor.getColumnIndex("comeFom");
      if (i != -1) {
        break label3707;
      }
      paramaukz.a(new NoColumnError("comeFom", String.class));
      label2553:
      i = paramCursor.getColumnIndex("ipUrl");
      if (i != -1) {
        break label3722;
      }
      paramaukz.a(new NoColumnError("ipUrl", String.class));
      label2588:
      i = paramCursor.getColumnIndex("ipName");
      if (i != -1) {
        break label3737;
      }
      paramaukz.a(new NoColumnError("ipName", String.class));
      label2623:
      i = paramCursor.getColumnIndex("ipDetail");
      if (i != -1) {
        break label3752;
      }
      paramaukz.a(new NoColumnError("ipDetail", String.class));
      label2658:
      i = paramCursor.getColumnIndex("ipOpName");
      if (i != -1) {
        break label3767;
      }
      paramaukz.a(new NoColumnError("ipOpName", String.class));
      label2693:
      i = paramCursor.getColumnIndex("ipJumpUrl");
      if (i != -1) {
        break label3782;
      }
      paramaukz.a(new NoColumnError("ipJumpUrl", String.class));
      label2728:
      i = paramCursor.getColumnIndex("ipReqTime");
      if (i != -1) {
        break label3797;
      }
      paramaukz.a(new NoColumnError("ipReqTime", Long.TYPE));
      label2763:
      i = paramCursor.getColumnIndex("ipLastReqTime");
      if (i != -1) {
        break label3812;
      }
      paramaukz.a(new NoColumnError("ipLastReqTime", Long.TYPE));
      label2798:
      i = paramCursor.getColumnIndex("aio");
      if (i != -1) {
        break label3827;
      }
      paramaukz.a(new NoColumnError("aio", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandian");
      if (i != -1) {
        break label3854;
      }
      paramaukz.a(new NoColumnError("kandian", Boolean.TYPE));
      i = paramCursor.getColumnIndex("richIPReqTime");
      if (i != -1) {
        break label3881;
      }
      paramaukz.a(new NoColumnError("richIPReqTime", Long.TYPE));
      label2903:
      i = paramCursor.getColumnIndex("richIPLastReqTime");
      if (i != -1) {
        break label3896;
      }
      paramaukz.a(new NoColumnError("richIPLastReqTime", Long.TYPE));
      label2938:
      i = paramCursor.getColumnIndex("hasIpProduct");
      if (i != -1) {
        break label3911;
      }
      paramaukz.a(new NoColumnError("hasIpProduct", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipSiteInfoBytes");
      if (i != -1) {
        break label3938;
      }
      paramaukz.a(new NoColumnError("ipSiteInfoBytes", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("newSoundEp");
      if (i != -1) {
        break label3953;
      }
      paramaukz.a(new NoColumnError("newSoundEp", Boolean.TYPE));
      return paramauko;
      paramauko.epId = paramCursor.getString(i);
      break;
      label3062:
      paramauko.wordingId = paramCursor.getLong(i);
      break label1188;
      label3077:
      paramauko.childEpId = paramCursor.getString(i);
      break label1223;
      label3092:
      paramauko.minQQVersion = paramCursor.getString(i);
      break label1258;
      label3107:
      paramauko.name = paramCursor.getString(i);
      break label1293;
      label3122:
      paramauko.mark = paramCursor.getString(i);
      break label1328;
      label3137:
      paramauko.type = paramCursor.getInt(i);
      break label1363;
      label3152:
      paramauko.author = paramCursor.getString(i);
      break label1398;
      label3167:
      paramauko.expiretime = paramCursor.getLong(i);
      break label1433;
      label3182:
      paramauko.status = paramCursor.getInt(i);
      break label1468;
      label3197:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasSound = paramBoolean;
        break;
      }
      label3224:
      paramauko.jobType = paramCursor.getInt(i);
      break label1538;
      label3239:
      paramauko.kinId = paramCursor.getString(i);
      break label1573;
      label3254:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.valid = paramBoolean;
        break;
      }
      label3281:
      paramauko.downloadCount = paramCursor.getInt(i);
      break label1643;
      label3296:
      paramauko.mobileFeetype = paramCursor.getInt(i);
      break label1678;
      label3311:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isRecommendation = paramBoolean;
        break;
      }
      label3338:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label3365:
      paramauko.firstEmotionId = paramCursor.getString(i);
      break label1783;
      label3380:
      paramauko.upperLeftLable = paramCursor.getInt(i);
      break label1818;
      label3395:
      paramauko.localVersion = paramCursor.getInt(i);
      break label1853;
      label3410:
      paramauko.latestVersion = paramCursor.getInt(i);
      break label1888;
      label3425:
      paramauko.jsonVersion = paramCursor.getInt(i);
      break label1923;
      label3440:
      paramauko.updateFlag = paramCursor.getInt(i);
      break label1958;
      label3455:
      paramauko.updateTip = paramCursor.getString(i);
      break label1993;
      label3470:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasReadUpdatePage = paramBoolean;
        break;
      }
      label3497:
      paramauko.rscType = paramCursor.getInt(i);
      break label2063;
      label3512:
      paramauko.supportSize = paramCursor.getString(i);
      break label2098;
      label3527:
      paramauko.extraFlags = paramCursor.getInt(i);
      break label2133;
      label3542:
      paramauko.businessExtra = paramCursor.getString(i);
      break label2168;
      label3557:
      paramauko.subType = paramCursor.getInt(i);
      break label2203;
      label3572:
      paramauko.isAPNG = paramCursor.getInt(i);
      break label2238;
      label3587:
      paramauko.copywritingType = paramCursor.getInt(i);
      break label2273;
      label3602:
      paramauko.diversionName = paramCursor.getString(i);
      break label2308;
      label3617:
      paramauko.copywritingContent = paramCursor.getString(i);
      break label2343;
      label3632:
      paramauko.jumpUrl = paramCursor.getString(i);
      break label2378;
      label3647:
      paramauko.imageUrl = paramCursor.getString(i);
      break label2413;
      label3662:
      paramauko.beginTime = paramCursor.getLong(i);
      break label2448;
      label3677:
      paramauko.endTime = paramCursor.getLong(i);
      break label2483;
      label3692:
      paramauko.buttonWording = paramCursor.getString(i);
      break label2518;
      label3707:
      paramauko.comeFom = paramCursor.getString(i);
      break label2553;
      label3722:
      paramauko.ipUrl = paramCursor.getString(i);
      break label2588;
      label3737:
      paramauko.ipName = paramCursor.getString(i);
      break label2623;
      label3752:
      paramauko.ipDetail = paramCursor.getString(i);
      break label2658;
      label3767:
      paramauko.ipOpName = paramCursor.getString(i);
      break label2693;
      label3782:
      paramauko.ipJumpUrl = paramCursor.getString(i);
      break label2728;
      label3797:
      paramauko.ipReqTime = paramCursor.getLong(i);
      break label2763;
      label3812:
      paramauko.ipLastReqTime = paramCursor.getLong(i);
      break label2798;
      label3827:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.aio = paramBoolean;
        break;
      }
      label3854:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.kandian = paramBoolean;
        break;
      }
      label3881:
      paramauko.richIPReqTime = paramCursor.getLong(i);
      break label2903;
      label3896:
      paramauko.richIPLastReqTime = paramCursor.getLong(i);
      break label2938;
      label3911:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramauko.hasIpProduct = paramBoolean;
        break;
      }
      label3938:
      paramauko.ipSiteInfoBytes = paramCursor.getBlob(i);
    }
    label3953:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramauko.newSoundEp = paramBoolean;
      return paramauko;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,extraFlags INTEGER ,businessExtra TEXT ,subType INTEGER ,isAPNG INTEGER ,copywritingType INTEGER ,diversionName TEXT ,copywritingContent TEXT ,jumpUrl TEXT ,imageUrl TEXT ,beginTime INTEGER ,endTime INTEGER ,buttonWording TEXT ,comeFom TEXT ,ipUrl TEXT ,ipName TEXT ,ipDetail TEXT ,ipOpName TEXT ,ipJumpUrl TEXT ,ipReqTime INTEGER ,ipLastReqTime INTEGER ,aio INTEGER ,kandian INTEGER ,richIPReqTime INTEGER ,richIPLastReqTime INTEGER ,hasIpProduct INTEGER ,ipSiteInfoBytes BLOB ,newSoundEp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(auko paramauko, ContentValues paramContentValues)
  {
    paramauko = (EmoticonPackage)paramauko;
    paramContentValues.put("epId", paramauko.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramauko.wordingId));
    paramContentValues.put("childEpId", paramauko.childEpId);
    paramContentValues.put("minQQVersion", paramauko.minQQVersion);
    paramContentValues.put("name", paramauko.name);
    paramContentValues.put("mark", paramauko.mark);
    paramContentValues.put("type", Integer.valueOf(paramauko.type));
    paramContentValues.put("author", paramauko.author);
    paramContentValues.put("expiretime", Long.valueOf(paramauko.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramauko.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramauko.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramauko.jobType));
    paramContentValues.put("kinId", paramauko.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramauko.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramauko.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramauko.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramauko.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramauko.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramauko.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramauko.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramauko.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramauko.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramauko.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramauko.updateFlag));
    paramContentValues.put("updateTip", paramauko.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramauko.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramauko.rscType));
    paramContentValues.put("supportSize", paramauko.supportSize);
    paramContentValues.put("extraFlags", Integer.valueOf(paramauko.extraFlags));
    paramContentValues.put("businessExtra", paramauko.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramauko.subType));
    paramContentValues.put("isAPNG", Integer.valueOf(paramauko.isAPNG));
    paramContentValues.put("copywritingType", Integer.valueOf(paramauko.copywritingType));
    paramContentValues.put("diversionName", paramauko.diversionName);
    paramContentValues.put("copywritingContent", paramauko.copywritingContent);
    paramContentValues.put("jumpUrl", paramauko.jumpUrl);
    paramContentValues.put("imageUrl", paramauko.imageUrl);
    paramContentValues.put("beginTime", Long.valueOf(paramauko.beginTime));
    paramContentValues.put("endTime", Long.valueOf(paramauko.endTime));
    paramContentValues.put("buttonWording", paramauko.buttonWording);
    paramContentValues.put("comeFom", paramauko.comeFom);
    paramContentValues.put("ipUrl", paramauko.ipUrl);
    paramContentValues.put("ipName", paramauko.ipName);
    paramContentValues.put("ipDetail", paramauko.ipDetail);
    paramContentValues.put("ipOpName", paramauko.ipOpName);
    paramContentValues.put("ipJumpUrl", paramauko.ipJumpUrl);
    paramContentValues.put("ipReqTime", Long.valueOf(paramauko.ipReqTime));
    paramContentValues.put("ipLastReqTime", Long.valueOf(paramauko.ipLastReqTime));
    paramContentValues.put("aio", Boolean.valueOf(paramauko.aio));
    paramContentValues.put("kandian", Boolean.valueOf(paramauko.kandian));
    paramContentValues.put("richIPReqTime", Long.valueOf(paramauko.richIPReqTime));
    paramContentValues.put("richIPLastReqTime", Long.valueOf(paramauko.richIPLastReqTime));
    paramContentValues.put("hasIpProduct", Boolean.valueOf(paramauko.hasIpProduct));
    paramContentValues.put("ipSiteInfoBytes", paramauko.ipSiteInfoBytes);
    paramContentValues.put("newSoundEp", Boolean.valueOf(paramauko.newSoundEp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukm
 * JD-Core Version:    0.7.0.1
 */