import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.persistence.NoColumnError;

public class atmm
  extends atna
{
  public atmm()
  {
    this.a = 55;
  }
  
  public atmo a(atmo paramatmo, Cursor paramCursor, boolean paramBoolean, atmz paramatmz)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramatmo = (EmoticonPackage)paramatmo;
    if (paramatmz == null)
    {
      paramatmo.epId = paramCursor.getString(paramCursor.getColumnIndex("epId"));
      paramatmo.wordingId = paramCursor.getLong(paramCursor.getColumnIndex("wordingId"));
      paramatmo.childEpId = paramCursor.getString(paramCursor.getColumnIndex("childEpId"));
      paramatmo.minQQVersion = paramCursor.getString(paramCursor.getColumnIndex("minQQVersion"));
      paramatmo.name = paramCursor.getString(paramCursor.getColumnIndex("name"));
      paramatmo.mark = paramCursor.getString(paramCursor.getColumnIndex("mark"));
      paramatmo.type = paramCursor.getInt(paramCursor.getColumnIndex("type"));
      paramatmo.author = paramCursor.getString(paramCursor.getColumnIndex("author"));
      paramatmo.expiretime = paramCursor.getLong(paramCursor.getColumnIndex("expiretime"));
      paramatmo.status = paramCursor.getInt(paramCursor.getColumnIndex("status"));
      if (1 == paramCursor.getShort(paramCursor.getColumnIndex("hasSound")))
      {
        paramBoolean = true;
        paramatmo.hasSound = paramBoolean;
        paramatmo.jobType = paramCursor.getInt(paramCursor.getColumnIndex("jobType"));
        paramatmo.kinId = paramCursor.getString(paramCursor.getColumnIndex("kinId"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("valid"))) {
          break label1078;
        }
        paramBoolean = true;
        label277:
        paramatmo.valid = paramBoolean;
        paramatmo.downloadCount = paramCursor.getInt(paramCursor.getColumnIndex("downloadCount"));
        paramatmo.mobileFeetype = paramCursor.getInt(paramCursor.getColumnIndex("mobileFeetype"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isRecommendation"))) {
          break label1083;
        }
        paramBoolean = true;
        label338:
        paramatmo.isRecommendation = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("isMagicFaceDownloading"))) {
          break label1088;
        }
        paramBoolean = true;
        label363:
        paramatmo.isMagicFaceDownloading = paramBoolean;
        paramatmo.firstEmotionId = paramCursor.getString(paramCursor.getColumnIndex("firstEmotionId"));
        paramatmo.upperLeftLable = paramCursor.getInt(paramCursor.getColumnIndex("upperLeftLable"));
        paramatmo.localVersion = paramCursor.getInt(paramCursor.getColumnIndex("localVersion"));
        paramatmo.latestVersion = paramCursor.getInt(paramCursor.getColumnIndex("latestVersion"));
        paramatmo.jsonVersion = paramCursor.getInt(paramCursor.getColumnIndex("jsonVersion"));
        paramatmo.updateFlag = paramCursor.getInt(paramCursor.getColumnIndex("updateFlag"));
        paramatmo.updateTip = paramCursor.getString(paramCursor.getColumnIndex("updateTip"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasReadUpdatePage"))) {
          break label1093;
        }
        paramBoolean = true;
        label514:
        paramatmo.hasReadUpdatePage = paramBoolean;
        paramatmo.rscType = paramCursor.getInt(paramCursor.getColumnIndex("rscType"));
        paramatmo.supportSize = paramCursor.getString(paramCursor.getColumnIndex("supportSize"));
        paramatmo.extraFlags = paramCursor.getInt(paramCursor.getColumnIndex("extraFlags"));
        paramatmo.businessExtra = paramCursor.getString(paramCursor.getColumnIndex("businessExtra"));
        paramatmo.subType = paramCursor.getInt(paramCursor.getColumnIndex("subType"));
        paramatmo.isAPNG = paramCursor.getInt(paramCursor.getColumnIndex("isAPNG"));
        paramatmo.copywritingType = paramCursor.getInt(paramCursor.getColumnIndex("copywritingType"));
        paramatmo.diversionName = paramCursor.getString(paramCursor.getColumnIndex("diversionName"));
        paramatmo.copywritingContent = paramCursor.getString(paramCursor.getColumnIndex("copywritingContent"));
        paramatmo.jumpUrl = paramCursor.getString(paramCursor.getColumnIndex("jumpUrl"));
        paramatmo.imageUrl = paramCursor.getString(paramCursor.getColumnIndex("imageUrl"));
        paramatmo.beginTime = paramCursor.getLong(paramCursor.getColumnIndex("beginTime"));
        paramatmo.endTime = paramCursor.getLong(paramCursor.getColumnIndex("endTime"));
        paramatmo.buttonWording = paramCursor.getString(paramCursor.getColumnIndex("buttonWording"));
        paramatmo.comeFom = paramCursor.getString(paramCursor.getColumnIndex("comeFom"));
        paramatmo.ipUrl = paramCursor.getString(paramCursor.getColumnIndex("ipUrl"));
        paramatmo.ipName = paramCursor.getString(paramCursor.getColumnIndex("ipName"));
        paramatmo.ipDetail = paramCursor.getString(paramCursor.getColumnIndex("ipDetail"));
        paramatmo.ipOpName = paramCursor.getString(paramCursor.getColumnIndex("ipOpName"));
        paramatmo.ipJumpUrl = paramCursor.getString(paramCursor.getColumnIndex("ipJumpUrl"));
        paramatmo.ipReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipReqTime"));
        paramatmo.ipLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("ipLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("aio"))) {
          break label1098;
        }
        paramBoolean = true;
        label935:
        paramatmo.aio = paramBoolean;
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("kandian"))) {
          break label1103;
        }
        paramBoolean = true;
        label960:
        paramatmo.kandian = paramBoolean;
        paramatmo.richIPReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPReqTime"));
        paramatmo.richIPLastReqTime = paramCursor.getLong(paramCursor.getColumnIndex("richIPLastReqTime"));
        if (1 != paramCursor.getShort(paramCursor.getColumnIndex("hasIpProduct"))) {
          break label1108;
        }
        paramBoolean = true;
        label1021:
        paramatmo.hasIpProduct = paramBoolean;
        paramatmo.ipSiteInfoBytes = paramCursor.getBlob(paramCursor.getColumnIndex("ipSiteInfoBytes"));
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
        paramatmo.newSoundEp = paramBoolean;
        return paramatmo;
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
      paramatmz.a(new NoColumnError("epId", String.class));
      i = paramCursor.getColumnIndex("wordingId");
      if (i != -1) {
        break label3062;
      }
      paramatmz.a(new NoColumnError("wordingId", Long.TYPE));
      label1188:
      i = paramCursor.getColumnIndex("childEpId");
      if (i != -1) {
        break label3077;
      }
      paramatmz.a(new NoColumnError("childEpId", String.class));
      label1223:
      i = paramCursor.getColumnIndex("minQQVersion");
      if (i != -1) {
        break label3092;
      }
      paramatmz.a(new NoColumnError("minQQVersion", String.class));
      label1258:
      i = paramCursor.getColumnIndex("name");
      if (i != -1) {
        break label3107;
      }
      paramatmz.a(new NoColumnError("name", String.class));
      label1293:
      i = paramCursor.getColumnIndex("mark");
      if (i != -1) {
        break label3122;
      }
      paramatmz.a(new NoColumnError("mark", String.class));
      label1328:
      i = paramCursor.getColumnIndex("type");
      if (i != -1) {
        break label3137;
      }
      paramatmz.a(new NoColumnError("type", Integer.TYPE));
      label1363:
      i = paramCursor.getColumnIndex("author");
      if (i != -1) {
        break label3152;
      }
      paramatmz.a(new NoColumnError("author", String.class));
      label1398:
      i = paramCursor.getColumnIndex("expiretime");
      if (i != -1) {
        break label3167;
      }
      paramatmz.a(new NoColumnError("expiretime", Long.TYPE));
      label1433:
      i = paramCursor.getColumnIndex("status");
      if (i != -1) {
        break label3182;
      }
      paramatmz.a(new NoColumnError("status", Integer.TYPE));
      label1468:
      i = paramCursor.getColumnIndex("hasSound");
      if (i != -1) {
        break label3197;
      }
      paramatmz.a(new NoColumnError("hasSound", Boolean.TYPE));
      i = paramCursor.getColumnIndex("jobType");
      if (i != -1) {
        break label3224;
      }
      paramatmz.a(new NoColumnError("jobType", Integer.TYPE));
      label1538:
      i = paramCursor.getColumnIndex("kinId");
      if (i != -1) {
        break label3239;
      }
      paramatmz.a(new NoColumnError("kinId", String.class));
      label1573:
      i = paramCursor.getColumnIndex("valid");
      if (i != -1) {
        break label3254;
      }
      paramatmz.a(new NoColumnError("valid", Boolean.TYPE));
      i = paramCursor.getColumnIndex("downloadCount");
      if (i != -1) {
        break label3281;
      }
      paramatmz.a(new NoColumnError("downloadCount", Integer.TYPE));
      label1643:
      i = paramCursor.getColumnIndex("mobileFeetype");
      if (i != -1) {
        break label3296;
      }
      paramatmz.a(new NoColumnError("mobileFeetype", Integer.TYPE));
      label1678:
      i = paramCursor.getColumnIndex("isRecommendation");
      if (i != -1) {
        break label3311;
      }
      paramatmz.a(new NoColumnError("isRecommendation", Boolean.TYPE));
      i = paramCursor.getColumnIndex("isMagicFaceDownloading");
      if (i != -1) {
        break label3338;
      }
      paramatmz.a(new NoColumnError("isMagicFaceDownloading", Boolean.TYPE));
      i = paramCursor.getColumnIndex("firstEmotionId");
      if (i != -1) {
        break label3365;
      }
      paramatmz.a(new NoColumnError("firstEmotionId", String.class));
      label1783:
      i = paramCursor.getColumnIndex("upperLeftLable");
      if (i != -1) {
        break label3380;
      }
      paramatmz.a(new NoColumnError("upperLeftLable", Integer.TYPE));
      label1818:
      i = paramCursor.getColumnIndex("localVersion");
      if (i != -1) {
        break label3395;
      }
      paramatmz.a(new NoColumnError("localVersion", Integer.TYPE));
      label1853:
      i = paramCursor.getColumnIndex("latestVersion");
      if (i != -1) {
        break label3410;
      }
      paramatmz.a(new NoColumnError("latestVersion", Integer.TYPE));
      label1888:
      i = paramCursor.getColumnIndex("jsonVersion");
      if (i != -1) {
        break label3425;
      }
      paramatmz.a(new NoColumnError("jsonVersion", Integer.TYPE));
      label1923:
      i = paramCursor.getColumnIndex("updateFlag");
      if (i != -1) {
        break label3440;
      }
      paramatmz.a(new NoColumnError("updateFlag", Integer.TYPE));
      label1958:
      i = paramCursor.getColumnIndex("updateTip");
      if (i != -1) {
        break label3455;
      }
      paramatmz.a(new NoColumnError("updateTip", String.class));
      label1993:
      i = paramCursor.getColumnIndex("hasReadUpdatePage");
      if (i != -1) {
        break label3470;
      }
      paramatmz.a(new NoColumnError("hasReadUpdatePage", Boolean.TYPE));
      i = paramCursor.getColumnIndex("rscType");
      if (i != -1) {
        break label3497;
      }
      paramatmz.a(new NoColumnError("rscType", Integer.TYPE));
      label2063:
      i = paramCursor.getColumnIndex("supportSize");
      if (i != -1) {
        break label3512;
      }
      paramatmz.a(new NoColumnError("supportSize", String.class));
      label2098:
      i = paramCursor.getColumnIndex("extraFlags");
      if (i != -1) {
        break label3527;
      }
      paramatmz.a(new NoColumnError("extraFlags", Integer.TYPE));
      label2133:
      i = paramCursor.getColumnIndex("businessExtra");
      if (i != -1) {
        break label3542;
      }
      paramatmz.a(new NoColumnError("businessExtra", String.class));
      label2168:
      i = paramCursor.getColumnIndex("subType");
      if (i != -1) {
        break label3557;
      }
      paramatmz.a(new NoColumnError("subType", Integer.TYPE));
      label2203:
      i = paramCursor.getColumnIndex("isAPNG");
      if (i != -1) {
        break label3572;
      }
      paramatmz.a(new NoColumnError("isAPNG", Integer.TYPE));
      label2238:
      i = paramCursor.getColumnIndex("copywritingType");
      if (i != -1) {
        break label3587;
      }
      paramatmz.a(new NoColumnError("copywritingType", Integer.TYPE));
      label2273:
      i = paramCursor.getColumnIndex("diversionName");
      if (i != -1) {
        break label3602;
      }
      paramatmz.a(new NoColumnError("diversionName", String.class));
      label2308:
      i = paramCursor.getColumnIndex("copywritingContent");
      if (i != -1) {
        break label3617;
      }
      paramatmz.a(new NoColumnError("copywritingContent", String.class));
      label2343:
      i = paramCursor.getColumnIndex("jumpUrl");
      if (i != -1) {
        break label3632;
      }
      paramatmz.a(new NoColumnError("jumpUrl", String.class));
      label2378:
      i = paramCursor.getColumnIndex("imageUrl");
      if (i != -1) {
        break label3647;
      }
      paramatmz.a(new NoColumnError("imageUrl", String.class));
      label2413:
      i = paramCursor.getColumnIndex("beginTime");
      if (i != -1) {
        break label3662;
      }
      paramatmz.a(new NoColumnError("beginTime", Long.TYPE));
      label2448:
      i = paramCursor.getColumnIndex("endTime");
      if (i != -1) {
        break label3677;
      }
      paramatmz.a(new NoColumnError("endTime", Long.TYPE));
      label2483:
      i = paramCursor.getColumnIndex("buttonWording");
      if (i != -1) {
        break label3692;
      }
      paramatmz.a(new NoColumnError("buttonWording", String.class));
      label2518:
      i = paramCursor.getColumnIndex("comeFom");
      if (i != -1) {
        break label3707;
      }
      paramatmz.a(new NoColumnError("comeFom", String.class));
      label2553:
      i = paramCursor.getColumnIndex("ipUrl");
      if (i != -1) {
        break label3722;
      }
      paramatmz.a(new NoColumnError("ipUrl", String.class));
      label2588:
      i = paramCursor.getColumnIndex("ipName");
      if (i != -1) {
        break label3737;
      }
      paramatmz.a(new NoColumnError("ipName", String.class));
      label2623:
      i = paramCursor.getColumnIndex("ipDetail");
      if (i != -1) {
        break label3752;
      }
      paramatmz.a(new NoColumnError("ipDetail", String.class));
      label2658:
      i = paramCursor.getColumnIndex("ipOpName");
      if (i != -1) {
        break label3767;
      }
      paramatmz.a(new NoColumnError("ipOpName", String.class));
      label2693:
      i = paramCursor.getColumnIndex("ipJumpUrl");
      if (i != -1) {
        break label3782;
      }
      paramatmz.a(new NoColumnError("ipJumpUrl", String.class));
      label2728:
      i = paramCursor.getColumnIndex("ipReqTime");
      if (i != -1) {
        break label3797;
      }
      paramatmz.a(new NoColumnError("ipReqTime", Long.TYPE));
      label2763:
      i = paramCursor.getColumnIndex("ipLastReqTime");
      if (i != -1) {
        break label3812;
      }
      paramatmz.a(new NoColumnError("ipLastReqTime", Long.TYPE));
      label2798:
      i = paramCursor.getColumnIndex("aio");
      if (i != -1) {
        break label3827;
      }
      paramatmz.a(new NoColumnError("aio", Boolean.TYPE));
      i = paramCursor.getColumnIndex("kandian");
      if (i != -1) {
        break label3854;
      }
      paramatmz.a(new NoColumnError("kandian", Boolean.TYPE));
      i = paramCursor.getColumnIndex("richIPReqTime");
      if (i != -1) {
        break label3881;
      }
      paramatmz.a(new NoColumnError("richIPReqTime", Long.TYPE));
      label2903:
      i = paramCursor.getColumnIndex("richIPLastReqTime");
      if (i != -1) {
        break label3896;
      }
      paramatmz.a(new NoColumnError("richIPLastReqTime", Long.TYPE));
      label2938:
      i = paramCursor.getColumnIndex("hasIpProduct");
      if (i != -1) {
        break label3911;
      }
      paramatmz.a(new NoColumnError("hasIpProduct", Boolean.TYPE));
      i = paramCursor.getColumnIndex("ipSiteInfoBytes");
      if (i != -1) {
        break label3938;
      }
      paramatmz.a(new NoColumnError("ipSiteInfoBytes", [B.class));
    }
    for (;;)
    {
      i = paramCursor.getColumnIndex("newSoundEp");
      if (i != -1) {
        break label3953;
      }
      paramatmz.a(new NoColumnError("newSoundEp", Boolean.TYPE));
      return paramatmo;
      paramatmo.epId = paramCursor.getString(i);
      break;
      label3062:
      paramatmo.wordingId = paramCursor.getLong(i);
      break label1188;
      label3077:
      paramatmo.childEpId = paramCursor.getString(i);
      break label1223;
      label3092:
      paramatmo.minQQVersion = paramCursor.getString(i);
      break label1258;
      label3107:
      paramatmo.name = paramCursor.getString(i);
      break label1293;
      label3122:
      paramatmo.mark = paramCursor.getString(i);
      break label1328;
      label3137:
      paramatmo.type = paramCursor.getInt(i);
      break label1363;
      label3152:
      paramatmo.author = paramCursor.getString(i);
      break label1398;
      label3167:
      paramatmo.expiretime = paramCursor.getLong(i);
      break label1433;
      label3182:
      paramatmo.status = paramCursor.getInt(i);
      break label1468;
      label3197:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasSound = paramBoolean;
        break;
      }
      label3224:
      paramatmo.jobType = paramCursor.getInt(i);
      break label1538;
      label3239:
      paramatmo.kinId = paramCursor.getString(i);
      break label1573;
      label3254:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.valid = paramBoolean;
        break;
      }
      label3281:
      paramatmo.downloadCount = paramCursor.getInt(i);
      break label1643;
      label3296:
      paramatmo.mobileFeetype = paramCursor.getInt(i);
      break label1678;
      label3311:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isRecommendation = paramBoolean;
        break;
      }
      label3338:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.isMagicFaceDownloading = paramBoolean;
        break;
      }
      label3365:
      paramatmo.firstEmotionId = paramCursor.getString(i);
      break label1783;
      label3380:
      paramatmo.upperLeftLable = paramCursor.getInt(i);
      break label1818;
      label3395:
      paramatmo.localVersion = paramCursor.getInt(i);
      break label1853;
      label3410:
      paramatmo.latestVersion = paramCursor.getInt(i);
      break label1888;
      label3425:
      paramatmo.jsonVersion = paramCursor.getInt(i);
      break label1923;
      label3440:
      paramatmo.updateFlag = paramCursor.getInt(i);
      break label1958;
      label3455:
      paramatmo.updateTip = paramCursor.getString(i);
      break label1993;
      label3470:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasReadUpdatePage = paramBoolean;
        break;
      }
      label3497:
      paramatmo.rscType = paramCursor.getInt(i);
      break label2063;
      label3512:
      paramatmo.supportSize = paramCursor.getString(i);
      break label2098;
      label3527:
      paramatmo.extraFlags = paramCursor.getInt(i);
      break label2133;
      label3542:
      paramatmo.businessExtra = paramCursor.getString(i);
      break label2168;
      label3557:
      paramatmo.subType = paramCursor.getInt(i);
      break label2203;
      label3572:
      paramatmo.isAPNG = paramCursor.getInt(i);
      break label2238;
      label3587:
      paramatmo.copywritingType = paramCursor.getInt(i);
      break label2273;
      label3602:
      paramatmo.diversionName = paramCursor.getString(i);
      break label2308;
      label3617:
      paramatmo.copywritingContent = paramCursor.getString(i);
      break label2343;
      label3632:
      paramatmo.jumpUrl = paramCursor.getString(i);
      break label2378;
      label3647:
      paramatmo.imageUrl = paramCursor.getString(i);
      break label2413;
      label3662:
      paramatmo.beginTime = paramCursor.getLong(i);
      break label2448;
      label3677:
      paramatmo.endTime = paramCursor.getLong(i);
      break label2483;
      label3692:
      paramatmo.buttonWording = paramCursor.getString(i);
      break label2518;
      label3707:
      paramatmo.comeFom = paramCursor.getString(i);
      break label2553;
      label3722:
      paramatmo.ipUrl = paramCursor.getString(i);
      break label2588;
      label3737:
      paramatmo.ipName = paramCursor.getString(i);
      break label2623;
      label3752:
      paramatmo.ipDetail = paramCursor.getString(i);
      break label2658;
      label3767:
      paramatmo.ipOpName = paramCursor.getString(i);
      break label2693;
      label3782:
      paramatmo.ipJumpUrl = paramCursor.getString(i);
      break label2728;
      label3797:
      paramatmo.ipReqTime = paramCursor.getLong(i);
      break label2763;
      label3812:
      paramatmo.ipLastReqTime = paramCursor.getLong(i);
      break label2798;
      label3827:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.aio = paramBoolean;
        break;
      }
      label3854:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.kandian = paramBoolean;
        break;
      }
      label3881:
      paramatmo.richIPReqTime = paramCursor.getLong(i);
      break label2903;
      label3896:
      paramatmo.richIPLastReqTime = paramCursor.getLong(i);
      break label2938;
      label3911:
      if (1 == paramCursor.getShort(i)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramatmo.hasIpProduct = paramBoolean;
        break;
      }
      label3938:
      paramatmo.ipSiteInfoBytes = paramCursor.getBlob(i);
    }
    label3953:
    if (1 == paramCursor.getShort(i)) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      paramatmo.newSoundEp = paramBoolean;
      return paramatmo;
    }
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT ,epId TEXT UNIQUE ,wordingId INTEGER ,childEpId TEXT ,minQQVersion TEXT ,name TEXT ,mark TEXT ,type INTEGER ,author TEXT ,expiretime INTEGER ,status INTEGER ,hasSound INTEGER ,jobType INTEGER ,kinId TEXT ,valid INTEGER ,downloadCount INTEGER ,mobileFeetype INTEGER ,isRecommendation INTEGER ,isMagicFaceDownloading INTEGER ,firstEmotionId TEXT ,upperLeftLable INTEGER ,localVersion INTEGER ,latestVersion INTEGER ,jsonVersion INTEGER default 0 ,updateFlag INTEGER ,updateTip TEXT ,hasReadUpdatePage INTEGER ,rscType INTEGER ,supportSize TEXT ,extraFlags INTEGER ,businessExtra TEXT ,subType INTEGER ,isAPNG INTEGER ,copywritingType INTEGER ,diversionName TEXT ,copywritingContent TEXT ,jumpUrl TEXT ,imageUrl TEXT ,beginTime INTEGER ,endTime INTEGER ,buttonWording TEXT ,comeFom TEXT ,ipUrl TEXT ,ipName TEXT ,ipDetail TEXT ,ipOpName TEXT ,ipJumpUrl TEXT ,ipReqTime INTEGER ,ipLastReqTime INTEGER ,aio INTEGER ,kandian INTEGER ,richIPReqTime INTEGER ,richIPLastReqTime INTEGER ,hasIpProduct INTEGER ,ipSiteInfoBytes BLOB ,newSoundEp INTEGER)");
    return localStringBuilder.toString();
  }
  
  public void a(atmo paramatmo, ContentValues paramContentValues)
  {
    paramatmo = (EmoticonPackage)paramatmo;
    paramContentValues.put("epId", paramatmo.epId);
    paramContentValues.put("wordingId", Long.valueOf(paramatmo.wordingId));
    paramContentValues.put("childEpId", paramatmo.childEpId);
    paramContentValues.put("minQQVersion", paramatmo.minQQVersion);
    paramContentValues.put("name", paramatmo.name);
    paramContentValues.put("mark", paramatmo.mark);
    paramContentValues.put("type", Integer.valueOf(paramatmo.type));
    paramContentValues.put("author", paramatmo.author);
    paramContentValues.put("expiretime", Long.valueOf(paramatmo.expiretime));
    paramContentValues.put("status", Integer.valueOf(paramatmo.status));
    paramContentValues.put("hasSound", Boolean.valueOf(paramatmo.hasSound));
    paramContentValues.put("jobType", Integer.valueOf(paramatmo.jobType));
    paramContentValues.put("kinId", paramatmo.kinId);
    paramContentValues.put("valid", Boolean.valueOf(paramatmo.valid));
    paramContentValues.put("downloadCount", Integer.valueOf(paramatmo.downloadCount));
    paramContentValues.put("mobileFeetype", Integer.valueOf(paramatmo.mobileFeetype));
    paramContentValues.put("isRecommendation", Boolean.valueOf(paramatmo.isRecommendation));
    paramContentValues.put("isMagicFaceDownloading", Boolean.valueOf(paramatmo.isMagicFaceDownloading));
    paramContentValues.put("firstEmotionId", paramatmo.firstEmotionId);
    paramContentValues.put("upperLeftLable", Integer.valueOf(paramatmo.upperLeftLable));
    paramContentValues.put("localVersion", Integer.valueOf(paramatmo.localVersion));
    paramContentValues.put("latestVersion", Integer.valueOf(paramatmo.latestVersion));
    paramContentValues.put("jsonVersion", Integer.valueOf(paramatmo.jsonVersion));
    paramContentValues.put("updateFlag", Integer.valueOf(paramatmo.updateFlag));
    paramContentValues.put("updateTip", paramatmo.updateTip);
    paramContentValues.put("hasReadUpdatePage", Boolean.valueOf(paramatmo.hasReadUpdatePage));
    paramContentValues.put("rscType", Integer.valueOf(paramatmo.rscType));
    paramContentValues.put("supportSize", paramatmo.supportSize);
    paramContentValues.put("extraFlags", Integer.valueOf(paramatmo.extraFlags));
    paramContentValues.put("businessExtra", paramatmo.businessExtra);
    paramContentValues.put("subType", Integer.valueOf(paramatmo.subType));
    paramContentValues.put("isAPNG", Integer.valueOf(paramatmo.isAPNG));
    paramContentValues.put("copywritingType", Integer.valueOf(paramatmo.copywritingType));
    paramContentValues.put("diversionName", paramatmo.diversionName);
    paramContentValues.put("copywritingContent", paramatmo.copywritingContent);
    paramContentValues.put("jumpUrl", paramatmo.jumpUrl);
    paramContentValues.put("imageUrl", paramatmo.imageUrl);
    paramContentValues.put("beginTime", Long.valueOf(paramatmo.beginTime));
    paramContentValues.put("endTime", Long.valueOf(paramatmo.endTime));
    paramContentValues.put("buttonWording", paramatmo.buttonWording);
    paramContentValues.put("comeFom", paramatmo.comeFom);
    paramContentValues.put("ipUrl", paramatmo.ipUrl);
    paramContentValues.put("ipName", paramatmo.ipName);
    paramContentValues.put("ipDetail", paramatmo.ipDetail);
    paramContentValues.put("ipOpName", paramatmo.ipOpName);
    paramContentValues.put("ipJumpUrl", paramatmo.ipJumpUrl);
    paramContentValues.put("ipReqTime", Long.valueOf(paramatmo.ipReqTime));
    paramContentValues.put("ipLastReqTime", Long.valueOf(paramatmo.ipLastReqTime));
    paramContentValues.put("aio", Boolean.valueOf(paramatmo.aio));
    paramContentValues.put("kandian", Boolean.valueOf(paramatmo.kandian));
    paramContentValues.put("richIPReqTime", Long.valueOf(paramatmo.richIPReqTime));
    paramContentValues.put("richIPLastReqTime", Long.valueOf(paramatmo.richIPLastReqTime));
    paramContentValues.put("hasIpProduct", Boolean.valueOf(paramatmo.hasIpProduct));
    paramContentValues.put("ipSiteInfoBytes", paramatmo.ipSiteInfoBytes);
    paramContentValues.put("newSoundEp", Boolean.valueOf(paramatmo.newSoundEp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atmm
 * JD-Core Version:    0.7.0.1
 */