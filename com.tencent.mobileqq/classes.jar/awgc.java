import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.NoColumnError;

public class awgc
  extends awgq
{
  public awgc()
  {
    this.a = 55;
  }
  
  public awge a(awge paramawge, Cursor paramCursor, boolean paramBoolean, awgp paramawgp)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramawge = (EmoticonPackage)paramawge;
    if (paramawgp == null)
    {
      paramawge.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramawge.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramawge.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramawge.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramawge.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramawge.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramawge.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramawge.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramawge.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramawge.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramawge.hasSound = paramBoolean;
        paramawge.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramawge.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label1078;
        }
        paramBoolean = true;
        label277:
        paramawge.valid = paramBoolean;
        paramawge.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramawge.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label1083;
        }
        paramBoolean = true;
        label338:
        paramawge.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label1088;
        }
        paramBoolean = true;
        label363:
        paramawge.isMagicFaceDownloading = paramBoolean;
        paramawge.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramawge.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramawge.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramawge.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramawge.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramawge.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramawge.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label1093;
        }
        paramBoolean = true;
        label514:
        paramawge.hasReadUpdatePage = paramBoolean;
        paramawge.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramawge.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramawge.extraFlags = paramCursor.getInt(paramCursor.getColumnIndex("extraFlags"));
        paramawge.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramawge.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramawge.isAPNG = paramCursor.getInt(paramCursor.getColumnIndex("isAPNG"));
        paramawge.copywritingType = paramCursor.getInt(paramCursor.getColumnIndex("copywritingType"));
        paramawge.diversionName = paramCursor.getString(paramCursor.getColumnIndex("diversionName"));
        paramawge.copywritingContent = paramCursor.getString(paramCursor.getColumnIndex("copywritingContent"));
        paramawge.jumpUrl = paramCursor.getString(paramCursor.getColumnIndex("jumpUrl"));
        paramawge.imageUrl = paramCursor.getString(paramCursor.getColumnIndex("imageUrl"));
        paramawge.beginTime = paramCursor.getLong(paramCursor.getColumnIndex("beginTime"));
        paramawge.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
        paramawge.buttonWording = paramCursor.getString(paramCursor.getColumnIndex("buttonWording"));
        paramawge.comeFom = paramCursor.getString(paramCursor.getColumnIndex("comeFom"));
        paramawge.ipUrl = paramCursor.getString(paramCursor.getColumnIndex("ipUrl"));
        paramawge.ipName = paramCursor.getString(paramCursor.getColumnIndex("ipName"));
        paramawge.ipDetail = paramCursor.getString(paramCursor.getColumnIndex("ipDetail"));
        paramawge.ipOpName = paramCursor.getString(paramCursor.getColumnIndex("ipOpName"));
        paramawge.ipJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("ipJumpUrl"));
        paramawge.ipReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipReqTime"));
        paramawge.ipLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("aio"))) {
          break label1098;
        }
        paramBoolean = true;
        label935:
        paramawge.aio = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandian"))) {
          break label1103;
        }
        paramBoolean = true;
        label960:
        paramawge.kandian = paramBoolean;
        paramawge.richIPReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPReqTime"));
        paramawge.richIPLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasIpProduct"))) {
          break label1108;
        }
        paramBoolean = true;
        label1021:
        paramawge.hasIpProduct = paramBoolean;
        paramawge.ipSiteInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("ipSiteInfoBytes"));
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
        paramawge.newSoundEp = paramBoolean;
        return paramawge;
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
      paramawgp.a(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label3062;
      }
      paramawgp.a(new NoColumnError("wordingId", Long.TYPE));
      label1188:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label3077;
      }
      paramawgp.a(new NoColumnError("childEpId", String.class));
      label1223:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label3092;
      }
      paramawgp.a(new NoColumnError("minQQVersion", String.class));
      label1258:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3107;
      }
      paramawgp.a(new NoColumnError("name", String.class));
      label1293:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label3122;
      }
      paramawgp.a(new NoColumnError("mark", String.class));
      label1328:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label3137;
      }
      paramawgp.a(new NoColumnError("type", Integer.TYPE));
      label1363:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label3152;
      }
      paramawgp.a(new NoColumnError("author", String.class));
      label1398:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label3167;
      }
      paramawgp.a(new NoColumnError("expiretime", Long.TYPE));
      label1433:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3182;
      }
      paramawgp.a(new NoColumnError("status", Integer.TYPE));
      label1468:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label3197;
      }
      paramawgp.a(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label3224;
      }
      paramawgp.a(new NoColumnError("jobType", Integer.TYPE));
      label1538:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label3239;
      }
      paramawgp.a(new NoColumnError("kinId", String.class));
      label1573:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label3254;
      }
      paramawgp.a(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label3281;
      }
      paramawgp.a(new NoColumnError("downloadCount", Integer.TYPE));
      label1643:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label3296;
      }
      paramawgp.a(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1678:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label3311;
      }
      paramawgp.a(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label3338;
      }
      paramawgp.a(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label3365;
      }
      paramawgp.a(new NoColumnError("firstEmotionId", String.class));
      label1783:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label3380;
      }
      paramawgp.a(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1818:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label3395;
      }
      paramawgp.a(new NoColumnError("localVersion", Integer.TYPE));
      label1853:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label3410;
      }
      paramawgp.a(new NoColumnError("latestVersion", Integer.TYPE));
      label1888:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label3425;
      }
      paramawgp.a(new NoColumnError("jsonVersion", Integer.TYPE));
      label1923:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label3440;
      }
      paramawgp.a(new NoColumnError("updateFlag", Integer.TYPE));
      label1958:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label3455;
      }
      paramawgp.a(new NoColumnError("updateTip", String.class));
      label1993:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label3470;
      }
      paramawgp.a(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label3497;
      }
      paramawgp.a(new NoColumnError("rscType", Integer.TYPE));
      label2063:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label3512;
      }
      paramawgp.a(new NoColumnError("supportSize", String.class));
      label2098:
      i = paramCursor.getColumnIndex("extraFlags");
      if (i != -1) {
        break label3527;
      }
      paramawgp.a(new NoColumnError("extraFlags", Integer.TYPE));
      label2133:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label3542;
      }
      paramawgp.a(new NoColumnError("businessExtra", String.class));
      label2168:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label3557;
      }
      paramawgp.a(new NoColumnError("subType", Integer.TYPE));
      label2203:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label3572;
      }
      paramawgp.a(new NoColumnError("isAPNG", Integer.TYPE));
      label2238:
      i = paramCursor.getColumnIndex("copywritingType");
      if (i != -1) {
        break label3587;
      }
      paramawgp.a(new NoColumnError("copywritingType", Integer.TYPE));
      label2273:
      i = paramCursor.getColumnIndex("diversionName");
      if (i != -1) {
        break label3602;
      }
      paramawgp.a(new NoColumnError("diversionName", String.class));
      label2308:
      i = paramCursor.getColumnIndex("copywritingContent");
      if (i != -1) {
        break label3617;
      }
      paramawgp.a(new NoColumnError("copywritingContent", String.class));
      label2343:
      i = paramCursor.getColumnIndex("jumpUrl");
      if (i != -1) {
        break label3632;
      }
      paramawgp.a(new NoColumnError("jumpUrl", String.class));
      label2378:
      i = paramCursor.getColumnIndex("imageUrl");
      if (i != -1) {
        break label3647;
      }
      paramawgp.a(new NoColumnError("imageUrl", String.class));
      label2413:
      i = paramCursor.getColumnIndex("beginTime");
      if (i != -1) {
        break label3662;
      }
      paramawgp.a(new NoColumnError("beginTime", Long.TYPE));
      label2448:
      i = paramCursor.getColumnIndex("endTime");
      if (i != -1) {
        break label3677;
      }
      paramawgp.a(new NoColumnError("endTime", Long.TYPE));
      label2483:
      i = paramCursor.getColumnIndex("buttonWording");
      if (i != -1) {
        break label3692;
      }
      paramawgp.a(new NoColumnError("buttonWording", String.class));
      label2518:
      i = paramCursor.getColumnIndex("comeFom");
      if (i != -1) {
        break label3707;
      }
      paramawgp.a(new NoColumnError("comeFom", String.class));
      label2553:
      i = paramCursor.getColumnIndex("ipUrl");
      if (i != -1) {
        break label3722;
      }
      paramawgp.a(new NoColumnError("ipUrl", String.class));
      label2588:
      i = paramCursor.getColumnIndex("ipName");
      if (i != -1) {
        break label3737;
      }
      paramawgp.a(new NoColumnError("ipName", String.class));
      label2623:
      i = paramCursor.getColumnIndex("ipDetail");
      if (i != -1) {
        break label3752;
      }
      paramawgp.a(new NoColumnError("ipDetail", String.class));
      label2658:
      i = paramCursor.getColumnIndex("ipOpName");
      if (i != -1) {
        break label3767;
      }
      paramawgp.a(new NoColumnError("ipOpName", String.class));
      label2693:
      i = paramCursor.getColumnIndex("ipJumpUrl");
      if (i != -1) {
        break label3782;
      }
      paramawgp.a(new NoColumnError("ipJumpUrl", String.class));
      label2728:
      i = paramCursor.getColumnIndex("ipReqTime");
      if (i != -1) {
        break label3797;
      }
      paramawgp.a(new NoColumnError("ipReqTime", Long.TYPE));
      label2763:
      i = paramCursor.getColumnIndex("ipLastReqTime");
      if (i != -1) {
        break label3812;
      }
      paramawgp.a(new NoColumnError("ipLastReqTime", Long.TYPE));
      label2798:
      i = paramCursor.getColumnIndex("aio");
      if (i != -1) {
        break label3827;
      }
      paramawgp.a(new NoColumnError("aio", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandian");
      if (i != -1) {
        break label3854;
      }
      paramawgp.a(new NoColumnError("kandian", Boolean.TYPE));
      i = paramCursor.getColumnIndex("richIPReqTime");
      if (i != -1) {
        break label3881;
      }
      paramawgp.a(new NoColumnError("richIPReqTime", Long.TYPE));
      label2903:
      i = paramCursor.getColumnIndex("richIPLastReqTime");
      if (i != -1) {
        break label3896;
      }
      paramawgp.a(new NoColumnError("richIPLastReqTime", Long.TYPE));
      label2938:
      i = paramCursor.getColumnIndex("hasIpProduct");
      if (i != -1) {
        break label3911;
      }
      paramawgp.a(new NoColumnError("hasIpProduct", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipSiteInfoBytes");
      if (i != -1) {
        break label3938;
      }
      paramawgp.a(new NoColumnError("ipSiteInfoBytes", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("newSoundEp");
      if (i != -1) {
        break label3953;
      }
      paramawgp.a(new NoColumnError("newSoundEp", Boolean.TYPE));
      return paramawge;
      paramawge.epId = paramCursor.getString(i);
      break;
      label3062:
      paramawge.wordingId = paramCursor.getLong(i);
      break label1188;
      label3077:
      paramawge.childEpId = paramCursor.getString(i);
      break label1223;
      label3092:
      paramawge.minQQVersion = paramCursor.getString(i);
      break label1258;
      label3107:
      paramawge.name = paramCursor.getString(i);
      break label1293;
      label3122:
      paramawge.mark = paramCursor.getString(i);
      break label1328;
      label3137:
      paramawge.type = paramCursor.getInt(i);
      break label1363;
      label3152:
      paramawge.author = paramCursor.getString(i);
      break label1398;
      label3167:
      paramawge.expiretime = paramCursor.getLong(i);
      break label1433;
      label3182:
      paramawge.status = paramCursor.getInt(i);
      break label1468;
      label3197:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasSound = paramBoolean;
        break;
      }
      label3224:
      paramawge.jobType = paramCursor.getInt(i);
      break label1538;
      label3239:
      paramawge.kinId = paramCursor.getString(i);
      break label1573;
      label3254:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.valid = paramBoolean;
        break;
      }
      label3281:
      paramawge.downloadCount = paramCursor.getInt(i);
      break label1643;
      label3296:
      paramawge.mobileFeetype = paramCursor.getInt(i);
      break label1678;
      label3311:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isRecommendation = paramBoolean;
        break;
      }
      label3338:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label3365:
      paramawge.firstEmotionId = paramCursor.getString(i);
      break label1783;
      label3380:
      paramawge.upperLeftLable = paramCursor.getInt(i);
      break label1818;
      label3395:
      paramawge.localVersion = paramCursor.getInt(i);
      break label1853;
      label3410:
      paramawge.latestVersion = paramCursor.getInt(i);
      break label1888;
      label3425:
      paramawge.jsonVersion = paramCursor.getInt(i);
      break label1923;
      label3440:
      paramawge.updateFlag = paramCursor.getInt(i);
      break label1958;
      label3455:
      paramawge.updateTip = paramCursor.getString(i);
      break label1993;
      label3470:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasReadUpdatePage = paramBoolean;
        break;
      }
      label3497:
      paramawge.rscType = paramCursor.getInt(i);
      break label2063;
      label3512:
      paramawge.supportSize = paramCursor.getString(i);
      break label2098;
      label3527:
      paramawge.extraFlags = paramCursor.getInt(i);
      break label2133;
      label3542:
      paramawge.businessExtra = paramCursor.getString(i);
      break label2168;
      label3557:
      paramawge.subType = paramCursor.getInt(i);
      break label2203;
      label3572:
      paramawge.isAPNG = paramCursor.getInt(i);
      break label2238;
      label3587:
      paramawge.copywritingType = paramCursor.getInt(i);
      break label2273;
      label3602:
      paramawge.diversionName = paramCursor.getString(i);
      break label2308;
      label3617:
      paramawge.copywritingContent = paramCursor.getString(i);
      break label2343;
      label3632:
      paramawge.jumpUrl = paramCursor.getString(i);
      break label2378;
      label3647:
      paramawge.imageUrl = paramCursor.getString(i);
      break label2413;
      label3662:
      paramawge.beginTime = paramCursor.getLong(i);
      break label2448;
      label3677:
      paramawge.endTime = paramCursor.getLong(i);
      break label2483;
      label3692:
      paramawge.buttonWording = paramCursor.getString(i);
      break label2518;
      label3707:
      paramawge.comeFom = paramCursor.getString(i);
      break label2553;
      label3722:
      paramawge.ipUrl = paramCursor.getString(i);
      break label2588;
      label3737:
      paramawge.ipName = paramCursor.getString(i);
      break label2623;
      label3752:
      paramawge.ipDetail = paramCursor.getString(i);
      break label2658;
      label3767:
      paramawge.ipOpName = paramCursor.getString(i);
      break label2693;
      label3782:
      paramawge.ipJumpUrl = paramCursor.getString(i);
      break label2728;
      label3797:
      paramawge.ipReqTime = paramCursor.getLong(i);
      break label2763;
      label3812:
      paramawge.ipLastReqTime = paramCursor.getLong(i);
      break label2798;
      label3827:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.aio = paramBoolean;
        break;
      }
      label3854:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.kandian = paramBoolean;
        break;
      }
      label3881:
      paramawge.richIPReqTime = paramCursor.getLong(i);
      break label2903;
      label3896:
      paramawge.richIPLastReqTime = paramCursor.getLong(i);
      break label2938;
      label3911:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramawge.hasIpProduct = paramBoolean;
        break;
      }
      label3938:
      paramawge.ipSiteInfoBytes = paramCursor.getBlob(i);
    }
    label3953:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramawge.newSoundEp = paramBoolean;
      return paramawge;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,extraFlags INTEGER ,businessExtra TEXT ,subType INTEGER ,isAPNG INTEGER ,copywritingType INTEGER ,diversionName TEXT ,copywritingContent TEXT ,jumpUrl TEXT ,imageUrl TEXT ,beginTime INTEGER ,endTime INTEGER ,buttonWording TEXT ,comeFom TEXT ,ipUrl TEXT ,ipName TEXT ,ipDetail TEXT ,ipOpName TEXT ,ipJumpUrl TEXT ,ipReqTime INTEGER ,ipLastReqTime INTEGER ,aio INTEGER ,kandian INTEGER ,richIPReqTime INTEGER ,richIPLastReqTime INTEGER ,hasIpProduct INTEGER ,ipSiteInfoBytes BLOB ,newSoundEp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(awge paramawge, ContentValues paramContentValues)
  {
    paramawge = (EmoticonPackage)paramawge;
    paramContentValues.put("epId", paramawge.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramawge.wordingId));
    paramContentValues.put("childEpId", paramawge.childEpId);
    paramContentValues.put("minQQVersion", paramawge.minQQVersion);
    paramContentValues.put("name", paramawge.name);
    paramContentValues.put("mark", paramawge.mark);
    paramContentValues.put("type", Integer.valueOf(paramawge.type));
    paramContentValues.put("author", paramawge.author);
    paramContentValues.put("expiretime", Long.valueOf(paramawge.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramawge.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramawge.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramawge.jobType));
    paramContentValues.put("kinId", paramawge.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramawge.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramawge.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramawge.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramawge.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramawge.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramawge.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramawge.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramawge.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramawge.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramawge.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramawge.updateFlag));
    paramContentValues.put("updateTip", paramawge.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramawge.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramawge.rscType));
    paramContentValues.put("supportSize", paramawge.supportSize);
    paramContentValues.put("extraFlags", Integer.valueOf(paramawge.extraFlags));
    paramContentValues.put("businessExtra", paramawge.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramawge.subType));
    paramContentValues.put("isAPNG", Integer.valueOf(paramawge.isAPNG));
    paramContentValues.put("copywritingType", Integer.valueOf(paramawge.copywritingType));
    paramContentValues.put("diversionName", paramawge.diversionName);
    paramContentValues.put("copywritingContent", paramawge.copywritingContent);
    paramContentValues.put("jumpUrl", paramawge.jumpUrl);
    paramContentValues.put("imageUrl", paramawge.imageUrl);
    paramContentValues.put("beginTime", Long.valueOf(paramawge.beginTime));
    paramContentValues.put("endTime", Long.valueOf(paramawge.endTime));
    paramContentValues.put("buttonWording", paramawge.buttonWording);
    paramContentValues.put("comeFom", paramawge.comeFom);
    paramContentValues.put("ipUrl", paramawge.ipUrl);
    paramContentValues.put("ipName", paramawge.ipName);
    paramContentValues.put("ipDetail", paramawge.ipDetail);
    paramContentValues.put("ipOpName", paramawge.ipOpName);
    paramContentValues.put("ipJumpUrl", paramawge.ipJumpUrl);
    paramContentValues.put("ipReqTime", Long.valueOf(paramawge.ipReqTime));
    paramContentValues.put("ipLastReqTime", Long.valueOf(paramawge.ipLastReqTime));
    paramContentValues.put("aio", Boolean.valueOf(paramawge.aio));
    paramContentValues.put("kandian", Boolean.valueOf(paramawge.kandian));
    paramContentValues.put("richIPReqTime", Long.valueOf(paramawge.richIPReqTime));
    paramContentValues.put("richIPLastReqTime", Long.valueOf(paramawge.richIPLastReqTime));
    paramContentValues.put("hasIpProduct", Boolean.valueOf(paramawge.hasIpProduct));
    paramContentValues.put("ipSiteInfoBytes", paramawge.ipSiteInfoBytes);
    paramContentValues.put("newSoundEp", Boolean.valueOf(paramawge.newSoundEp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awgc
 * JD-Core Version:    0.7.0.1
 */