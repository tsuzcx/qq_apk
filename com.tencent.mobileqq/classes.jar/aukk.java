import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.NoColumnError;

public class aukk
  extends auky
{
  public aukk()
  {
    this.a = 55;
  }
  
  public aukm a(aukm paramaukm, Cursor paramCursor, boolean paramBoolean, aukx paramaukx)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramaukm = (EmoticonPackage)paramaukm;
    if (paramaukx == null)
    {
      paramaukm.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramaukm.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramaukm.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramaukm.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramaukm.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramaukm.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramaukm.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramaukm.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramaukm.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramaukm.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramaukm.hasSound = paramBoolean;
        paramaukm.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramaukm.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label1078;
        }
        paramBoolean = true;
        label277:
        paramaukm.valid = paramBoolean;
        paramaukm.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramaukm.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label1083;
        }
        paramBoolean = true;
        label338:
        paramaukm.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label1088;
        }
        paramBoolean = true;
        label363:
        paramaukm.isMagicFaceDownloading = paramBoolean;
        paramaukm.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramaukm.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramaukm.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramaukm.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramaukm.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramaukm.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramaukm.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label1093;
        }
        paramBoolean = true;
        label514:
        paramaukm.hasReadUpdatePage = paramBoolean;
        paramaukm.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramaukm.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramaukm.extraFlags = paramCursor.getInt(paramCursor.getColumnIndex("extraFlags"));
        paramaukm.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramaukm.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramaukm.isAPNG = paramCursor.getInt(paramCursor.getColumnIndex("isAPNG"));
        paramaukm.copywritingType = paramCursor.getInt(paramCursor.getColumnIndex("copywritingType"));
        paramaukm.diversionName = paramCursor.getString(paramCursor.getColumnIndex("diversionName"));
        paramaukm.copywritingContent = paramCursor.getString(paramCursor.getColumnIndex("copywritingContent"));
        paramaukm.jumpUrl = paramCursor.getString(paramCursor.getColumnIndex("jumpUrl"));
        paramaukm.imageUrl = paramCursor.getString(paramCursor.getColumnIndex("imageUrl"));
        paramaukm.beginTime = paramCursor.getLong(paramCursor.getColumnIndex("beginTime"));
        paramaukm.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
        paramaukm.buttonWording = paramCursor.getString(paramCursor.getColumnIndex("buttonWording"));
        paramaukm.comeFom = paramCursor.getString(paramCursor.getColumnIndex("comeFom"));
        paramaukm.ipUrl = paramCursor.getString(paramCursor.getColumnIndex("ipUrl"));
        paramaukm.ipName = paramCursor.getString(paramCursor.getColumnIndex("ipName"));
        paramaukm.ipDetail = paramCursor.getString(paramCursor.getColumnIndex("ipDetail"));
        paramaukm.ipOpName = paramCursor.getString(paramCursor.getColumnIndex("ipOpName"));
        paramaukm.ipJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("ipJumpUrl"));
        paramaukm.ipReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipReqTime"));
        paramaukm.ipLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("aio"))) {
          break label1098;
        }
        paramBoolean = true;
        label935:
        paramaukm.aio = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandian"))) {
          break label1103;
        }
        paramBoolean = true;
        label960:
        paramaukm.kandian = paramBoolean;
        paramaukm.richIPReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPReqTime"));
        paramaukm.richIPLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasIpProduct"))) {
          break label1108;
        }
        paramBoolean = true;
        label1021:
        paramaukm.hasIpProduct = paramBoolean;
        paramaukm.ipSiteInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("ipSiteInfoBytes"));
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
        paramaukm.newSoundEp = paramBoolean;
        return paramaukm;
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
      paramaukx.a(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label3062;
      }
      paramaukx.a(new NoColumnError("wordingId", Long.TYPE));
      label1188:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label3077;
      }
      paramaukx.a(new NoColumnError("childEpId", String.class));
      label1223:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label3092;
      }
      paramaukx.a(new NoColumnError("minQQVersion", String.class));
      label1258:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3107;
      }
      paramaukx.a(new NoColumnError("name", String.class));
      label1293:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label3122;
      }
      paramaukx.a(new NoColumnError("mark", String.class));
      label1328:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label3137;
      }
      paramaukx.a(new NoColumnError("type", Integer.TYPE));
      label1363:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label3152;
      }
      paramaukx.a(new NoColumnError("author", String.class));
      label1398:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label3167;
      }
      paramaukx.a(new NoColumnError("expiretime", Long.TYPE));
      label1433:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3182;
      }
      paramaukx.a(new NoColumnError("status", Integer.TYPE));
      label1468:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label3197;
      }
      paramaukx.a(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label3224;
      }
      paramaukx.a(new NoColumnError("jobType", Integer.TYPE));
      label1538:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label3239;
      }
      paramaukx.a(new NoColumnError("kinId", String.class));
      label1573:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label3254;
      }
      paramaukx.a(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label3281;
      }
      paramaukx.a(new NoColumnError("downloadCount", Integer.TYPE));
      label1643:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label3296;
      }
      paramaukx.a(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1678:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label3311;
      }
      paramaukx.a(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label3338;
      }
      paramaukx.a(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label3365;
      }
      paramaukx.a(new NoColumnError("firstEmotionId", String.class));
      label1783:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label3380;
      }
      paramaukx.a(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1818:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label3395;
      }
      paramaukx.a(new NoColumnError("localVersion", Integer.TYPE));
      label1853:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label3410;
      }
      paramaukx.a(new NoColumnError("latestVersion", Integer.TYPE));
      label1888:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label3425;
      }
      paramaukx.a(new NoColumnError("jsonVersion", Integer.TYPE));
      label1923:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label3440;
      }
      paramaukx.a(new NoColumnError("updateFlag", Integer.TYPE));
      label1958:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label3455;
      }
      paramaukx.a(new NoColumnError("updateTip", String.class));
      label1993:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label3470;
      }
      paramaukx.a(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label3497;
      }
      paramaukx.a(new NoColumnError("rscType", Integer.TYPE));
      label2063:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label3512;
      }
      paramaukx.a(new NoColumnError("supportSize", String.class));
      label2098:
      i = paramCursor.getColumnIndex("extraFlags");
      if (i != -1) {
        break label3527;
      }
      paramaukx.a(new NoColumnError("extraFlags", Integer.TYPE));
      label2133:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label3542;
      }
      paramaukx.a(new NoColumnError("businessExtra", String.class));
      label2168:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label3557;
      }
      paramaukx.a(new NoColumnError("subType", Integer.TYPE));
      label2203:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label3572;
      }
      paramaukx.a(new NoColumnError("isAPNG", Integer.TYPE));
      label2238:
      i = paramCursor.getColumnIndex("copywritingType");
      if (i != -1) {
        break label3587;
      }
      paramaukx.a(new NoColumnError("copywritingType", Integer.TYPE));
      label2273:
      i = paramCursor.getColumnIndex("diversionName");
      if (i != -1) {
        break label3602;
      }
      paramaukx.a(new NoColumnError("diversionName", String.class));
      label2308:
      i = paramCursor.getColumnIndex("copywritingContent");
      if (i != -1) {
        break label3617;
      }
      paramaukx.a(new NoColumnError("copywritingContent", String.class));
      label2343:
      i = paramCursor.getColumnIndex("jumpUrl");
      if (i != -1) {
        break label3632;
      }
      paramaukx.a(new NoColumnError("jumpUrl", String.class));
      label2378:
      i = paramCursor.getColumnIndex("imageUrl");
      if (i != -1) {
        break label3647;
      }
      paramaukx.a(new NoColumnError("imageUrl", String.class));
      label2413:
      i = paramCursor.getColumnIndex("beginTime");
      if (i != -1) {
        break label3662;
      }
      paramaukx.a(new NoColumnError("beginTime", Long.TYPE));
      label2448:
      i = paramCursor.getColumnIndex("endTime");
      if (i != -1) {
        break label3677;
      }
      paramaukx.a(new NoColumnError("endTime", Long.TYPE));
      label2483:
      i = paramCursor.getColumnIndex("buttonWording");
      if (i != -1) {
        break label3692;
      }
      paramaukx.a(new NoColumnError("buttonWording", String.class));
      label2518:
      i = paramCursor.getColumnIndex("comeFom");
      if (i != -1) {
        break label3707;
      }
      paramaukx.a(new NoColumnError("comeFom", String.class));
      label2553:
      i = paramCursor.getColumnIndex("ipUrl");
      if (i != -1) {
        break label3722;
      }
      paramaukx.a(new NoColumnError("ipUrl", String.class));
      label2588:
      i = paramCursor.getColumnIndex("ipName");
      if (i != -1) {
        break label3737;
      }
      paramaukx.a(new NoColumnError("ipName", String.class));
      label2623:
      i = paramCursor.getColumnIndex("ipDetail");
      if (i != -1) {
        break label3752;
      }
      paramaukx.a(new NoColumnError("ipDetail", String.class));
      label2658:
      i = paramCursor.getColumnIndex("ipOpName");
      if (i != -1) {
        break label3767;
      }
      paramaukx.a(new NoColumnError("ipOpName", String.class));
      label2693:
      i = paramCursor.getColumnIndex("ipJumpUrl");
      if (i != -1) {
        break label3782;
      }
      paramaukx.a(new NoColumnError("ipJumpUrl", String.class));
      label2728:
      i = paramCursor.getColumnIndex("ipReqTime");
      if (i != -1) {
        break label3797;
      }
      paramaukx.a(new NoColumnError("ipReqTime", Long.TYPE));
      label2763:
      i = paramCursor.getColumnIndex("ipLastReqTime");
      if (i != -1) {
        break label3812;
      }
      paramaukx.a(new NoColumnError("ipLastReqTime", Long.TYPE));
      label2798:
      i = paramCursor.getColumnIndex("aio");
      if (i != -1) {
        break label3827;
      }
      paramaukx.a(new NoColumnError("aio", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandian");
      if (i != -1) {
        break label3854;
      }
      paramaukx.a(new NoColumnError("kandian", Boolean.TYPE));
      i = paramCursor.getColumnIndex("richIPReqTime");
      if (i != -1) {
        break label3881;
      }
      paramaukx.a(new NoColumnError("richIPReqTime", Long.TYPE));
      label2903:
      i = paramCursor.getColumnIndex("richIPLastReqTime");
      if (i != -1) {
        break label3896;
      }
      paramaukx.a(new NoColumnError("richIPLastReqTime", Long.TYPE));
      label2938:
      i = paramCursor.getColumnIndex("hasIpProduct");
      if (i != -1) {
        break label3911;
      }
      paramaukx.a(new NoColumnError("hasIpProduct", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipSiteInfoBytes");
      if (i != -1) {
        break label3938;
      }
      paramaukx.a(new NoColumnError("ipSiteInfoBytes", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("newSoundEp");
      if (i != -1) {
        break label3953;
      }
      paramaukx.a(new NoColumnError("newSoundEp", Boolean.TYPE));
      return paramaukm;
      paramaukm.epId = paramCursor.getString(i);
      break;
      label3062:
      paramaukm.wordingId = paramCursor.getLong(i);
      break label1188;
      label3077:
      paramaukm.childEpId = paramCursor.getString(i);
      break label1223;
      label3092:
      paramaukm.minQQVersion = paramCursor.getString(i);
      break label1258;
      label3107:
      paramaukm.name = paramCursor.getString(i);
      break label1293;
      label3122:
      paramaukm.mark = paramCursor.getString(i);
      break label1328;
      label3137:
      paramaukm.type = paramCursor.getInt(i);
      break label1363;
      label3152:
      paramaukm.author = paramCursor.getString(i);
      break label1398;
      label3167:
      paramaukm.expiretime = paramCursor.getLong(i);
      break label1433;
      label3182:
      paramaukm.status = paramCursor.getInt(i);
      break label1468;
      label3197:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasSound = paramBoolean;
        break;
      }
      label3224:
      paramaukm.jobType = paramCursor.getInt(i);
      break label1538;
      label3239:
      paramaukm.kinId = paramCursor.getString(i);
      break label1573;
      label3254:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.valid = paramBoolean;
        break;
      }
      label3281:
      paramaukm.downloadCount = paramCursor.getInt(i);
      break label1643;
      label3296:
      paramaukm.mobileFeetype = paramCursor.getInt(i);
      break label1678;
      label3311:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isRecommendation = paramBoolean;
        break;
      }
      label3338:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label3365:
      paramaukm.firstEmotionId = paramCursor.getString(i);
      break label1783;
      label3380:
      paramaukm.upperLeftLable = paramCursor.getInt(i);
      break label1818;
      label3395:
      paramaukm.localVersion = paramCursor.getInt(i);
      break label1853;
      label3410:
      paramaukm.latestVersion = paramCursor.getInt(i);
      break label1888;
      label3425:
      paramaukm.jsonVersion = paramCursor.getInt(i);
      break label1923;
      label3440:
      paramaukm.updateFlag = paramCursor.getInt(i);
      break label1958;
      label3455:
      paramaukm.updateTip = paramCursor.getString(i);
      break label1993;
      label3470:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasReadUpdatePage = paramBoolean;
        break;
      }
      label3497:
      paramaukm.rscType = paramCursor.getInt(i);
      break label2063;
      label3512:
      paramaukm.supportSize = paramCursor.getString(i);
      break label2098;
      label3527:
      paramaukm.extraFlags = paramCursor.getInt(i);
      break label2133;
      label3542:
      paramaukm.businessExtra = paramCursor.getString(i);
      break label2168;
      label3557:
      paramaukm.subType = paramCursor.getInt(i);
      break label2203;
      label3572:
      paramaukm.isAPNG = paramCursor.getInt(i);
      break label2238;
      label3587:
      paramaukm.copywritingType = paramCursor.getInt(i);
      break label2273;
      label3602:
      paramaukm.diversionName = paramCursor.getString(i);
      break label2308;
      label3617:
      paramaukm.copywritingContent = paramCursor.getString(i);
      break label2343;
      label3632:
      paramaukm.jumpUrl = paramCursor.getString(i);
      break label2378;
      label3647:
      paramaukm.imageUrl = paramCursor.getString(i);
      break label2413;
      label3662:
      paramaukm.beginTime = paramCursor.getLong(i);
      break label2448;
      label3677:
      paramaukm.endTime = paramCursor.getLong(i);
      break label2483;
      label3692:
      paramaukm.buttonWording = paramCursor.getString(i);
      break label2518;
      label3707:
      paramaukm.comeFom = paramCursor.getString(i);
      break label2553;
      label3722:
      paramaukm.ipUrl = paramCursor.getString(i);
      break label2588;
      label3737:
      paramaukm.ipName = paramCursor.getString(i);
      break label2623;
      label3752:
      paramaukm.ipDetail = paramCursor.getString(i);
      break label2658;
      label3767:
      paramaukm.ipOpName = paramCursor.getString(i);
      break label2693;
      label3782:
      paramaukm.ipJumpUrl = paramCursor.getString(i);
      break label2728;
      label3797:
      paramaukm.ipReqTime = paramCursor.getLong(i);
      break label2763;
      label3812:
      paramaukm.ipLastReqTime = paramCursor.getLong(i);
      break label2798;
      label3827:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.aio = paramBoolean;
        break;
      }
      label3854:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.kandian = paramBoolean;
        break;
      }
      label3881:
      paramaukm.richIPReqTime = paramCursor.getLong(i);
      break label2903;
      label3896:
      paramaukm.richIPLastReqTime = paramCursor.getLong(i);
      break label2938;
      label3911:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramaukm.hasIpProduct = paramBoolean;
        break;
      }
      label3938:
      paramaukm.ipSiteInfoBytes = paramCursor.getBlob(i);
    }
    label3953:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramaukm.newSoundEp = paramBoolean;
      return paramaukm;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,extraFlags INTEGER ,businessExtra TEXT ,subType INTEGER ,isAPNG INTEGER ,copywritingType INTEGER ,diversionName TEXT ,copywritingContent TEXT ,jumpUrl TEXT ,imageUrl TEXT ,beginTime INTEGER ,endTime INTEGER ,buttonWording TEXT ,comeFom TEXT ,ipUrl TEXT ,ipName TEXT ,ipDetail TEXT ,ipOpName TEXT ,ipJumpUrl TEXT ,ipReqTime INTEGER ,ipLastReqTime INTEGER ,aio INTEGER ,kandian INTEGER ,richIPReqTime INTEGER ,richIPLastReqTime INTEGER ,hasIpProduct INTEGER ,ipSiteInfoBytes BLOB ,newSoundEp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(aukm paramaukm, ContentValues paramContentValues)
  {
    paramaukm = (EmoticonPackage)paramaukm;
    paramContentValues.put("epId", paramaukm.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramaukm.wordingId));
    paramContentValues.put("childEpId", paramaukm.childEpId);
    paramContentValues.put("minQQVersion", paramaukm.minQQVersion);
    paramContentValues.put("name", paramaukm.name);
    paramContentValues.put("mark", paramaukm.mark);
    paramContentValues.put("type", Integer.valueOf(paramaukm.type));
    paramContentValues.put("author", paramaukm.author);
    paramContentValues.put("expiretime", Long.valueOf(paramaukm.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramaukm.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramaukm.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramaukm.jobType));
    paramContentValues.put("kinId", paramaukm.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramaukm.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramaukm.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramaukm.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramaukm.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramaukm.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramaukm.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramaukm.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramaukm.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramaukm.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramaukm.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramaukm.updateFlag));
    paramContentValues.put("updateTip", paramaukm.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramaukm.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramaukm.rscType));
    paramContentValues.put("supportSize", paramaukm.supportSize);
    paramContentValues.put("extraFlags", Integer.valueOf(paramaukm.extraFlags));
    paramContentValues.put("businessExtra", paramaukm.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramaukm.subType));
    paramContentValues.put("isAPNG", Integer.valueOf(paramaukm.isAPNG));
    paramContentValues.put("copywritingType", Integer.valueOf(paramaukm.copywritingType));
    paramContentValues.put("diversionName", paramaukm.diversionName);
    paramContentValues.put("copywritingContent", paramaukm.copywritingContent);
    paramContentValues.put("jumpUrl", paramaukm.jumpUrl);
    paramContentValues.put("imageUrl", paramaukm.imageUrl);
    paramContentValues.put("beginTime", Long.valueOf(paramaukm.beginTime));
    paramContentValues.put("endTime", Long.valueOf(paramaukm.endTime));
    paramContentValues.put("buttonWording", paramaukm.buttonWording);
    paramContentValues.put("comeFom", paramaukm.comeFom);
    paramContentValues.put("ipUrl", paramaukm.ipUrl);
    paramContentValues.put("ipName", paramaukm.ipName);
    paramContentValues.put("ipDetail", paramaukm.ipDetail);
    paramContentValues.put("ipOpName", paramaukm.ipOpName);
    paramContentValues.put("ipJumpUrl", paramaukm.ipJumpUrl);
    paramContentValues.put("ipReqTime", Long.valueOf(paramaukm.ipReqTime));
    paramContentValues.put("ipLastReqTime", Long.valueOf(paramaukm.ipLastReqTime));
    paramContentValues.put("aio", Boolean.valueOf(paramaukm.aio));
    paramContentValues.put("kandian", Boolean.valueOf(paramaukm.kandian));
    paramContentValues.put("richIPReqTime", Long.valueOf(paramaukm.richIPReqTime));
    paramContentValues.put("richIPLastReqTime", Long.valueOf(paramaukm.richIPLastReqTime));
    paramContentValues.put("hasIpProduct", Boolean.valueOf(paramaukm.hasIpProduct));
    paramContentValues.put("ipSiteInfoBytes", paramaukm.ipSiteInfoBytes);
    paramContentValues.put("newSoundEp", Boolean.valueOf(paramaukm.newSoundEp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukk
 * JD-Core Version:    0.7.0.1
 */