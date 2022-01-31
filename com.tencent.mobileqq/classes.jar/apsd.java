import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class apsd
{
  public static String a(QQAppInterface paramQQAppInterface, beae parambeae, boolean paramBoolean)
  {
    ArrayList localArrayList = null;
    if ((paramQQAppInterface == null) && (parambeae == null)) {}
    EmoticonPackage localEmoticonPackage;
    do
    {
      return null;
      localObject = parambeae.a();
      localEmoticonPackage = (EmoticonPackage)((Bundle)localObject).getSerializable("emoticonPackage");
    } while (localEmoticonPackage == null);
    int i = ((Bundle)localObject).getInt("jsonType", apro.c);
    File localFile = (File)parambeae.jdField_a_of_type_JavaUtilMap.get(parambeae.jdField_a_of_type_JavaLangString);
    Object localObject = new apsq();
    parambeae = localArrayList;
    if (localFile != null)
    {
      if (localFile.exists()) {
        parambeae = bdhb.a(localFile);
      }
    }
    else
    {
      localArrayList = new ArrayList();
      if (!paramBoolean) {
        break label162;
      }
    }
    label162:
    for (paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, parambeae, localArrayList);; paramQQAppInterface = a(paramQQAppInterface, localEmoticonPackage, i, parambeae, localArrayList, (apsq)localObject))
    {
      if ((QLog.isColorLevel()) && (paramQQAppInterface != null)) {
        QLog.d("EmotionJsonUtils", 2, "handleJsonFileDownload : json parse result = " + paramQQAppInterface);
      }
      return paramQQAppInterface;
      parambeae = null;
      break;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseSmallJson: parseSmallJson start");
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: app is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: data is null");
      }
      return "json data is null";
    }
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson: params is null");
      }
      return "params is null";
    }
    aufn localaufn = (aufn)paramQQAppInterface.getManager(14);
    Object localObject1;
    Object localObject2;
    String str1;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      long l = paramArrayOfByte.getLong("timestamp");
      paramQQAppInterface = paramArrayOfByte.getJSONObject("data");
      localObject1 = paramQQAppInterface.getJSONArray("baseInfo");
      localObject2 = paramQQAppInterface.getJSONArray("operationInfo");
      if ((localObject1 == null) || (localObject2 == null)) {
        break label1022;
      }
      localObject1 = (JSONObject)((JSONArray)localObject1).get(0);
      localObject2 = (JSONObject)((JSONArray)localObject2).get(0);
      str1 = ((JSONObject)localObject1).getString("name");
      paramEmoticonPackage.isAPNG = (((JSONObject)localObject1).optInt("isAPNG", 0) + 1);
      if (paramEmoticonPackage.isAPNG == 2) {
        paramEmoticonPackage.rscType = 2;
      }
      j = paramEmoticonPackage.extraFlags & 0x1;
      if (!((JSONObject)localObject1).has("isOriginal")) {
        break label1016;
      }
      i = ((JSONObject)localObject1).getInt("isOriginal");
      if (j != 0) {
        break label641;
      }
      paramEmoticonPackage.extraFlags |= i;
      label279:
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson original = " + i + ", ep.extraFlags = " + paramEmoticonPackage.extraFlags);
      }
      j = 0;
      i = 6;
      if (paramArrayOfByte.has("type")) {
        i = paramArrayOfByte.getInt("type");
      }
      if (((JSONObject)localObject2).has("feeType")) {
        j = ((JSONObject)localObject2).getInt("feeType");
      }
      paramEmoticonPackage.localVersion = ((int)(l / 1000L));
      paramEmoticonPackage.name = str1;
      paramEmoticonPackage.mark = "";
      paramEmoticonPackage.type = i;
      paramEmoticonPackage.mobileFeetype = j;
      paramEmoticonPackage.jobType = 4;
      if ((paramEmoticonPackage.mobileFeetype != 1) && ((paramEmoticonPackage.epId == null) || (!"10278".equals(paramEmoticonPackage.epId)))) {
        break label714;
      }
      paramEmoticonPackage.wordingId = 1L;
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        int m;
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
        return paramArrayOfByte;
        paramArrayOfByte = localaufn.b(paramEmoticonPackage.epId);
        if (paramArrayOfByte == null) {
          break;
        }
        paramEmoticonPackage.wordingId = paramArrayOfByte.wordingId;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail OutOfMemoryError  exception=" + paramQQAppInterface.toString());
        return null;
        paramEmoticonPackage.wordingId = -1L;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label494:
      paramQQAppInterface.printStackTrace();
      label641:
      label714:
      paramArrayOfByte = paramQQAppInterface.toString();
      QLog.e("EmotionJsonUtils", 1, "parseSmallJson: fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      return paramArrayOfByte;
    }
    localaufn.a(paramEmoticonPackage);
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseSmallJson: ep = " + paramEmoticonPackage);
    }
    paramArrayOfByte = paramQQAppInterface.getJSONArray("itemInfo");
    m = paramArrayOfByte.length();
    int i = 1;
    int j = 0;
    String str2;
    if (j < m)
    {
      paramQQAppInterface = paramArrayOfByte.getJSONObject(j);
      localObject1 = paramQQAppInterface.getString("id");
      localObject2 = paramQQAppInterface.getString("name");
      str2 = paramQQAppInterface.getString("character");
      str1 = paramEmoticonPackage.epId;
      paramQQAppInterface = localaufn.a(str1, (String)localObject1);
      if (paramQQAppInterface == null)
      {
        if (paramInt == apro.d) {
          break label1013;
        }
        paramQQAppInterface = new Emoticon();
        paramQQAppInterface.eId = ((String)localObject1);
        paramQQAppInterface.epId = str1;
        paramQQAppInterface.name = ((String)localObject2);
        paramQQAppInterface.character = str2;
        paramQQAppInterface.jobType = 3;
        i = 1;
      }
    }
    for (;;)
    {
      if (paramQQAppInterface == null)
      {
        if (!QLog.isColorLevel()) {
          break label1026;
        }
        QLog.d("EmotionJsonUtils", 2, "emoticon json update, cannot find emoticon from epId: " + str1);
        break label1026;
        if (j <= 0) {
          break label279;
        }
        paramEmoticonPackage.extraFlags &= i;
        break label279;
        if ((((String)localObject1).equals(paramQQAppInterface.eId)) && (str1.equals(paramQQAppInterface.epId)) && (((String)localObject2).equals(paramQQAppInterface.name))) {
          break label1041;
        }
        paramQQAppInterface.eId = ((String)localObject1);
        paramQQAppInterface.epId = str1;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          paramQQAppInterface.name = ((String)localObject2);
        }
        if (TextUtils.isEmpty(str2)) {
          break label1035;
        }
        paramQQAppInterface.character = str2;
        break label1035;
      }
      int k = 0;
      if (apvx.a(paramEmoticonPackage)) {
        k = 1;
      }
      paramQQAppInterface.isSound = paramEmoticonPackage.hasSound;
      paramArrayList.add(paramQQAppInterface);
      if ((i != 0) && (k == 0)) {
        localaufn.a(paramQQAppInterface);
      }
      if (QLog.isColorLevel())
      {
        QLog.d("EmotionJsonUtils", 2, "parseSmallJson :emoticon eId[" + (String)localObject1 + "]eName[" + (String)localObject2 + "]");
        break label1026;
        return null;
        label1013:
        continue;
        label1016:
        i = 0;
        break;
        label1022:
        return "parseSmallJson:json data is error";
      }
      label1026:
      j += 1;
      break label494;
      label1035:
      i = 1;
      continue;
      label1041:
      i = 0;
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList<Emoticon> paramArrayList, apsq paramapsq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionJsonUtils", 2, "parseJson : parseJson start");
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : ap is null");
      }
      return "app is null";
    }
    if (paramEmoticonPackage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : ep is null");
      }
      return "ep is null";
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : json data is null");
      }
      return "json data is null";
    }
    if ((paramArrayList == null) || (paramapsq == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson : params is null");
      }
      return "params is null";
    }
    aufn localaufn = (aufn)paramQQAppInterface.getManager(14);
    String str1;
    Object localObject1;
    Object localObject5;
    int i;
    Object localObject2;
    Object localObject4;
    String str2;
    int k;
    int j;
    label389:
    label474:
    label491:
    label510:
    int m;
    label529:
    int n;
    label548:
    boolean bool;
    label584:
    int i1;
    try
    {
      paramArrayOfByte = new JSONObject(new String(paramArrayOfByte, "utf-8"));
      str1 = paramArrayOfByte.getString("id");
      localObject1 = paramArrayOfByte.getString("name");
      localObject5 = paramArrayOfByte.optJSONObject("diversionConfig");
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 1, "diversionConfig = " + localObject5);
      }
      if (localObject5 != null)
      {
        i = ((JSONObject)localObject5).optInt("diversionType");
        paramQQAppInterface = ((JSONObject)localObject5).optString("diversionName");
        localObject2 = ((JSONObject)localObject5).optString("copywriting");
        localObject3 = ((JSONObject)localObject5).optString("jumpUrl");
        localObject4 = ((JSONObject)localObject5).optString("displayImg");
        long l1 = ((JSONObject)localObject5).optLong("beginTime");
        long l2 = ((JSONObject)localObject5).optLong("endTime");
        str2 = ((JSONObject)localObject5).optString("wording");
        localObject5 = ((JSONObject)localObject5).optString("from");
        paramEmoticonPackage.copywritingType = i;
        paramEmoticonPackage.copywritingContent = ((String)localObject2);
        paramEmoticonPackage.jumpUrl = ((String)localObject3);
        paramEmoticonPackage.imageUrl = ((String)localObject4);
        paramEmoticonPackage.diversionName = paramQQAppInterface;
        paramEmoticonPackage.beginTime = l1;
        paramEmoticonPackage.endTime = l2;
        paramEmoticonPackage.buttonWording = str2;
        paramEmoticonPackage.comeFom = ((String)localObject5);
      }
      k = paramEmoticonPackage.extraFlags & 0x1;
      if (!paramArrayOfByte.has("isOriginal")) {
        break label2281;
      }
      i = paramArrayOfByte.getInt("isOriginal");
      if (paramArrayOfByte.optInt("isApng") != 1) {
        break label2300;
      }
      j = 2;
      paramEmoticonPackage.isAPNG = j;
      if (k != 0) {
        break label1513;
      }
      paramEmoticonPackage.extraFlags |= i;
      if (QLog.isColorLevel()) {
        QLog.d("EmotionJsonUtils", 2, "parseJson original = " + i + ", ep.extraFlags = " + paramEmoticonPackage.extraFlags);
      }
      if (!paramArrayOfByte.has("mark")) {
        break label2275;
      }
      paramQQAppInterface = paramArrayOfByte.getString("mark");
      if (!paramArrayOfByte.has("type")) {
        break label2269;
      }
      j = paramArrayOfByte.getInt("type");
      if (!paramArrayOfByte.has("feetype")) {
        break label2263;
      }
      k = paramArrayOfByte.getInt("feetype");
      if (!paramArrayOfByte.has("rscType")) {
        break label2257;
      }
      m = paramArrayOfByte.getInt("rscType");
      if (!paramArrayOfByte.has("updateTime")) {
        break label2251;
      }
      n = paramArrayOfByte.getInt("updateTime");
      if (!paramArrayOfByte.has("ringtype")) {
        break label2242;
      }
      localObject2 = paramArrayOfByte.getString("ringtype");
      if (!"1".equals(localObject2)) {
        break label1586;
      }
      bool = true;
      i = 1;
    }
    catch (JSONException paramQQAppInterface)
    {
      for (;;)
      {
        Object localObject3;
        int i2;
        paramQQAppInterface.printStackTrace();
        paramArrayOfByte = paramQQAppInterface.toString();
        QLog.e("EmotionJsonUtils", 1, "parseJson: PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
        return paramArrayOfByte;
        if ("2".equals(localObject2)) {
          return "qFace are not supported";
        }
        if (!"4".equals(localObject2)) {
          break label2242;
        }
        bool = false;
        i = 4;
        continue;
        if (paramQQAppInterface == null) {
          break;
        }
        paramEmoticonPackage.wordingId = paramQQAppInterface.wordingId;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      label602:
      label875:
      label1387:
      paramQQAppInterface.printStackTrace();
      label835:
      label1130:
      paramArrayOfByte = paramQQAppInterface.toString();
      label1077:
      label1207:
      label1357:
      label1513:
      QLog.d("EmotionJsonUtils", 1, "parseJson: PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramQQAppInterface.toString());
      label1296:
      label1317:
      label1586:
      return paramArrayOfByte;
    }
    if ((paramArrayOfByte.has("type")) && (1 == j))
    {
      i1 = 3;
      i2 = 0;
      if (paramArrayOfByte.has("downloadcount")) {
        i2 = paramArrayOfByte.getInt("downloadcount");
      }
      paramEmoticonPackage.epId = str1;
      paramEmoticonPackage.name = ((String)localObject1);
      paramEmoticonPackage.mark = paramQQAppInterface;
      paramEmoticonPackage.type = j;
      paramEmoticonPackage.mobileFeetype = k;
      paramEmoticonPackage.hasSound = bool;
      paramEmoticonPackage.subType = i;
      paramEmoticonPackage.downloadCount = i2;
      paramEmoticonPackage.jobType = i1;
      if (paramEmoticonPackage.copywritingType != aufm.a)
      {
        paramEmoticonPackage.extraFlags |= 0x4;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseJson, ep.extraFlags = " + paramEmoticonPackage.extraFlags);
        }
      }
      if ((paramArrayOfByte.has("type")) && (4 == j)) {
        paramEmoticonPackage.jobType = 5;
      }
      paramEmoticonPackage.rscType = m;
      if (paramInt != apro.d) {
        paramEmoticonPackage.localVersion = n;
      }
      paramQQAppInterface = localaufn.b(str1);
      if (paramQQAppInterface != null)
      {
        paramEmoticonPackage.status = paramQQAppInterface.status;
        paramEmoticonPackage.valid = paramQQAppInterface.valid;
      }
      JSONObject localJSONObject;
      if ((paramEmoticonPackage.mobileFeetype == 1) || ((str1 != null) && ("10278".equals(str1))) || (paramEmoticonPackage.jobType == 1))
      {
        paramEmoticonPackage.wordingId = 1L;
        if ((paramArrayOfByte != null) && (paramArrayOfByte.has("operationInfo")))
        {
          paramQQAppInterface = paramArrayOfByte.getJSONArray("operationInfo");
          if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
          {
            i = 0;
            j = paramQQAppInterface.length();
            if (i < j)
            {
              localObject1 = paramQQAppInterface.getJSONObject(i);
              if ((localObject1 == null) || (!((JSONObject)localObject1).has("platform")) || (!"3".equals(((JSONObject)localObject1).getString("platform")))) {
                break label2306;
              }
              if (((JSONObject)localObject1).has("minVersion"))
              {
                paramQQAppInterface = ((JSONObject)localObject1).getString("minVersion");
                if (!TextUtils.isEmpty(paramQQAppInterface)) {
                  paramEmoticonPackage.minQQVersion = paramQQAppInterface;
                }
              }
            }
          }
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.has("childEmojiId")))
        {
          paramQQAppInterface = paramArrayOfByte.getString("childEmojiId");
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            paramQQAppInterface = paramQQAppInterface.split(",");
            if ((paramQQAppInterface != null) && (paramQQAppInterface.length > 0))
            {
              paramQQAppInterface = paramQQAppInterface[0];
              if (!TextUtils.isEmpty(paramQQAppInterface))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("EmotionJsonUtils", 2, "parseJson, child magic, id=" + paramQQAppInterface);
                }
                paramEmoticonPackage.childEpId = paramQQAppInterface;
              }
            }
          }
        }
        if (paramEmoticonPackage.isAPNG != 2) {
          break label1700;
        }
        paramQQAppInterface = paramArrayOfByte.optString("supportApngSize");
        if (!TextUtils.isEmpty(paramQQAppInterface)) {
          paramEmoticonPackage.supportSize = paramQQAppInterface;
        }
        if ((paramArrayOfByte != null) && (paramArrayOfByte.has("commDiyText"))) {
          paramEmoticonPackage.businessExtra = paramArrayOfByte.getJSONArray("commDiyText").toString();
        }
        localaufn.a(paramEmoticonPackage);
        i1 = localaufn.a(str1);
        if (!apvx.a(paramEmoticonPackage)) {
          break label2230;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseJson: ep = " + paramEmoticonPackage + " ,update :" + bool);
        }
        localObject3 = paramArrayOfByte.getJSONArray("imgs");
        i2 = ((JSONArray)localObject3).length();
        i = 1;
        localObject4 = new ArrayList();
        k = 0;
        j = 0;
        if (k >= i2) {
          break label2173;
        }
        localJSONObject = ((JSONArray)localObject3).getJSONObject(k);
        str2 = localJSONObject.getString("id");
        localObject5 = localJSONObject.getString("name");
        if (QLog.isColorLevel()) {
          QLog.d("EmotionJsonUtils", 2, "parseJson: emotion.id:" + str2);
        }
        if (!localJSONObject.has("wWidthInPhone")) {
          break label2224;
        }
        m = localJSONObject.getInt("wWidthInPhone");
        if (!localJSONObject.has("wHeightInPhone")) {
          break label2218;
        }
        n = localJSONObject.getInt("wHeightInPhone");
        if (!localJSONObject.has("keywords")) {
          break label1731;
        }
        paramQQAppInterface = localJSONObject.getJSONArray("keywords");
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          paramQQAppInterface.put(localObject5);
        }
        paramQQAppInterface = paramQQAppInterface.toString();
        if (!localJSONObject.has("diyText")) {
          break label2211;
        }
        paramArrayOfByte = localJSONObject.getJSONArray("diyText");
        if (paramArrayOfByte == null) {
          break label2211;
        }
        localObject1 = paramArrayOfByte.toString();
        localObject2 = localaufn.a(str1, str2);
        if (localObject2 != null) {
          break label1762;
        }
        paramArrayOfByte = (byte[])localObject2;
        if (paramInt != apro.d)
        {
          paramArrayOfByte = new Emoticon();
          paramArrayOfByte.eId = str2;
          paramArrayOfByte.epId = str1;
          paramArrayOfByte.name = ((String)localObject5);
          paramArrayOfByte.width = m;
          paramArrayOfByte.height = n;
          paramArrayOfByte.keywords = paramQQAppInterface;
          paramArrayOfByte.businessExtra = ((String)localObject1);
          i = 1;
        }
      }
      for (;;)
      {
        if (paramArrayOfByte != null) {
          break label1922;
        }
        m = j;
        if (!QLog.isColorLevel()) {
          break label2287;
        }
        QLog.d("EmotionJsonUtils", 2, "emoticon json update, cannot find emoticon from epId: " + str1);
        m = j;
        break label2287;
        if (k <= 0) {
          break;
        }
        paramEmoticonPackage.extraFlags &= i;
        break;
        paramEmoticonPackage.wordingId = -1L;
        break label835;
        label1700:
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.has("supportSize"))) {
          break label1077;
        }
        paramEmoticonPackage.supportSize = paramArrayOfByte.getJSONArray("supportSize").toString();
        break label1077;
        label1731:
        paramQQAppInterface = "[" + (String)localObject5 + "]";
        break label1357;
        label1762:
        if ((!str2.equals(((Emoticon)localObject2).eId)) || (!str1.equals(((Emoticon)localObject2).epId)) || (!((String)localObject5).equals(((Emoticon)localObject2).name)))
        {
          ((Emoticon)localObject2).eId = str2;
          ((Emoticon)localObject2).epId = str1;
          if (!TextUtils.isEmpty((CharSequence)localObject5)) {
            ((Emoticon)localObject2).name = ((String)localObject5);
          }
          ((Emoticon)localObject2).width = m;
          ((Emoticon)localObject2).height = n;
          ((Emoticon)localObject2).keywords = paramQQAppInterface;
          ((Emoticon)localObject2).businessExtra = ((String)localObject1);
          i = 1;
          paramArrayOfByte = (byte[])localObject2;
        }
        else
        {
          i = 0;
          if (!paramQQAppInterface.equals(((Emoticon)localObject2).keywords))
          {
            i = 1;
            ((Emoticon)localObject2).keywords = paramQQAppInterface;
          }
          paramArrayOfByte = (byte[])localObject2;
          if (!((String)localObject1).equals(((Emoticon)localObject2).businessExtra))
          {
            i = 1;
            ((Emoticon)localObject2).businessExtra = ((String)localObject1);
            paramArrayOfByte = (byte[])localObject2;
          }
        }
      }
      label1922:
      if (paramEmoticonPackage.jobType == 0) {
        paramArrayOfByte.jobType = 0;
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramArrayOfByte.encryptKey)) {
          j = 1;
        }
        paramArrayOfByte.isSound = paramEmoticonPackage.hasSound;
        paramQQAppInterface = localJSONObject.optJSONObject("voiceData");
        if (paramQQAppInterface != null)
        {
          paramArrayOfByte.backColor = paramQQAppInterface.optString("backcolor", null);
          paramArrayOfByte.volumeColor = paramQQAppInterface.optString("fontcolor", null);
          paramQQAppInterface = paramQQAppInterface.optString("heightItems", null);
          paramArrayOfByte.voicePrint = paramQQAppInterface;
          if (!TextUtils.isEmpty(paramQQAppInterface))
          {
            paramArrayOfByte.voicePrintItems = paramArrayOfByte.parseSoundPrintString();
            paramEmoticonPackage.newSoundEp = true;
          }
        }
        paramArrayList.add(paramArrayOfByte);
        if (i1 != -1)
        {
          paramArrayOfByte.extensionWidth = i1;
          paramArrayOfByte.extensionHeight = i1;
        }
        if ((i != 0) && (!bool)) {
          ((ArrayList)localObject4).add(paramArrayOfByte);
        }
        m = j;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("EmotionJsonUtils", 2, "paseJson: emoticon eId[" + str2 + "]eName[" + (String)localObject5 + "]");
        m = j;
        break;
        if (paramEmoticonPackage.jobType == 1) {
          return "qFace are not supported";
        }
        if (paramEmoticonPackage.jobType == 3) {
          paramArrayOfByte.jobType = 2;
        } else if (paramEmoticonPackage.jobType == 5) {
          paramArrayOfByte.jobType = 4;
        }
      }
      label2173:
      localaufn.b((List)localObject4);
      if (!paramEmoticonPackage.newSoundEp) {
        break label2315;
      }
      localaufn.a(paramEmoticonPackage);
      break label2315;
    }
    for (;;)
    {
      label2196:
      paramapsq.a = bool;
      return null;
      label2211:
      label2218:
      label2224:
      label2230:
      label2242:
      label2251:
      label2257:
      label2263:
      label2269:
      label2275:
      label2281:
      label2287:
      label2300:
      do
      {
        bool = false;
        break label2196;
        localObject1 = "";
        break label1387;
        n = 0;
        break label1317;
        m = 0;
        break label1296;
        bool = false;
        break label1130;
        i1 = 0;
        break label602;
        bool = false;
        i = 0;
        break label584;
        n = 0;
        break label548;
        m = 0;
        break label529;
        k = 0;
        break label510;
        j = 0;
        break label491;
        paramQQAppInterface = "";
        break label474;
        i = 0;
        break;
        k += 1;
        j = m;
        break label1207;
        j = 0;
        break label389;
        i += 1;
        break label875;
      } while (j != 0);
      label2306:
      label2315:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsd
 * JD-Core Version:    0.7.0.1
 */