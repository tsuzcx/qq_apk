import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.SparseArray;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.teamwork.DocsGrayTipsInfo;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.1;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.2;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.4;
import com.tencent.mobileqq.teamwork.fragment.TeamWorkDocsListFragment;
import com.tencent.mobileqq.teamworkforgroup.GroupPadTemplateInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.Pair;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import msf.msgcomm.msg_comm.C2CTmpMsgHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.oidb.cmd0x857.TroopTips0x857.TroopFormGrayTipsInfo;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;
import tencent.im.s2c.msgtype0x210.submsgtype0x119.SubMsgType0x119.MsgBody;

public class ayfx
{
  private static volatile int a;
  public static long a;
  public static final SparseArray<Pair<Integer, String>> a;
  public static String a;
  public static final HashMap<String, String> a;
  public static final Map<Integer, String> a;
  private static long b;
  public static final SparseArray<Pair<Integer, String>> b;
  public static String b;
  public static final Map<String, Integer> b;
  public static String c;
  public static String d;
  public static final String e;
  public static final String f;
  public static final String g;
  public static final String h;
  private static String i = "TeamWorkUtils";
  
  static
  {
    jdField_a_of_type_JavaLangString = ".doc|.docx|.xls|.xlsx|";
    jdField_a_of_type_Long = 101458937L;
    jdField_b_of_type_JavaLangString = "https://docs.qq.com/desktop/m/index.html?_wv=2";
    c = "docs.qq.com/desktop/m";
    jdField_d_of_type_JavaLangString = "https://docs.qq.com/desktop/favicon.ico";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(9), "s_qq_mini_importing");
    jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(12), "s_qq_url_2_doc");
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aiomsg", "docs_miniapp_config_aio_msg");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile", "docs_miniapp_config_my_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile_yindao", "docs_miniapp_config_my_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile_banner", "docs_miniapp_config_my_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_myfile_menu_create", "docs_miniapp_config_templatelist");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_grpfile", "docs_miniapp_config_troop_file");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aio_grey", "docs_miniapp_config_gray_bar");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aio_edit", "docs_miniapp_config_aio_edit");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_file_edit", "docs_miniapp_config_bottom_edit");
    jdField_a_of_type_JavaUtilHashMap.put("s_QQ_file_share_edit", "docs_miniapp_config_menu_edit");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_file_preview", "docs_miniapp_config_online_preview");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_ocr_save", "docs_miniapp_config_ocr_save");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_url_2_doc", "docs_miniapp_config_url_2_doc");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_mini_importing", "s_qq_mini_importing");
    jdField_a_of_type_JavaUtilHashMap.put("s_qq_aio_ark_h5", "docs_miniapp_config_aio_ark_h5");
    jdField_b_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_JavaUtilMap.put("docx", Integer.valueOf(1));
    jdField_b_of_type_JavaUtilMap.put("sheet", Integer.valueOf(2));
    jdField_b_of_type_JavaUtilMap.put("form", Integer.valueOf(3));
    jdField_b_of_type_JavaUtilMap.put("slide", Integer.valueOf(4));
    jdField_b_of_type_JavaUtilMap.put("pdf", Integer.valueOf(5));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, new Pair(Integer.valueOf(2130848651), "static://DefaultTeamWorkMiniShareDoc"));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, new Pair(Integer.valueOf(2130848658), "static://DefaultTeamWorkMiniShareSheet"));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, new Pair(Integer.valueOf(2130848654), "static://DefaultTeamWorkMiniShareForm"));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, new Pair(Integer.valueOf(2130848660), "static://DefaultTeamWorkMiniShareSlide"));
    jdField_a_of_type_AndroidUtilSparseArray.put(5, new Pair(Integer.valueOf(2130848656), "static://DefaultTeamWorkMiniSharePdf"));
    jdField_b_of_type_AndroidUtilSparseArray.put(1, new Pair(Integer.valueOf(2130848650), "static://DefaultTeamWorkH5ShareDoc"));
    jdField_b_of_type_AndroidUtilSparseArray.put(2, new Pair(Integer.valueOf(2130848657), "static://DefaultTeamWorkH5ShareSheet"));
    jdField_b_of_type_AndroidUtilSparseArray.put(3, new Pair(Integer.valueOf(2130848653), "static://DefaultTeamWorkH5ShareForm"));
    jdField_b_of_type_AndroidUtilSparseArray.put(4, new Pair(Integer.valueOf(2130848659), "static://DefaultTeamWorkH5ShareSlide"));
    jdField_b_of_type_AndroidUtilSparseArray.put(5, new Pair(Integer.valueOf(2130848655), "static://DefaultTeamWorkH5SharePdf"));
    jdField_e_of_type_JavaLangString = ajya.a(2131714757);
    f = ajya.a(2131714787);
    g = ajya.a(2131714772);
    h = ajya.a(2131714813);
    jdField_a_of_type_Int = -2147483648;
  }
  
  public static Bitmap a(int paramInt)
  {
    return a(jdField_a_of_type_AndroidUtilSparseArray, 2130848651, "static://DefaultTeamWorkMiniShareDoc", paramInt);
  }
  
  private static Bitmap a(SparseArray<Pair<Integer, String>> paramSparseArray, int paramInt1, String paramString, int paramInt2)
  {
    int j = paramInt1;
    String str = paramString;
    if (paramSparseArray != null)
    {
      paramSparseArray = (Pair)paramSparseArray.get(paramInt2);
      j = paramInt1;
      str = paramString;
      if (paramSparseArray != null)
      {
        str = (String)paramSparseArray.second;
        j = ((Integer)paramSparseArray.first).intValue();
      }
    }
    if (BaseApplicationImpl.sImageCache != null) {}
    for (paramSparseArray = (Bitmap)BaseApplicationImpl.sImageCache.get(str);; paramSparseArray = null)
    {
      paramString = paramSparseArray;
      if (paramSparseArray == null)
      {
        paramSparseArray = baxi.b(BaseApplicationImpl.getApplication().getResources(), j);
        paramString = paramSparseArray;
        if (paramSparseArray != null)
        {
          paramString = paramSparseArray;
          if (BaseApplicationImpl.sImageCache != null)
          {
            BaseApplicationImpl.sImageCache.put(str, paramSparseArray);
            paramString = paramSparseArray;
          }
        }
      }
      return paramString;
    }
  }
  
  public static Bitmap a(String paramString)
  {
    Object localObject2 = null;
    try
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.e(i, 2, "getTeamWorkForWXMiniProShareBitMap mMiniProgramImageUrl = " + paramString);
      }
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = localObject2;
        if (d(paramString)) {
          localObject1 = b(paramString);
        }
      }
      return localObject1;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (OutOfMemoryError paramString) {}
    return null;
  }
  
  public static QIPCModule a()
  {
    return new ayfz();
  }
  
  public static DocsGrayTipsInfo a(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      com.tencent.qphone.base.util.QLog.d(i + ayed.i, 2, " gray tips jason null");
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        localDocsGrayTipsInfo = new DocsGrayTipsInfo();
        try
        {
          localDocsGrayTipsInfo.jdField_a_of_type_JavaLangString = paramString2;
          localDocsGrayTipsInfo.jdField_b_of_type_JavaLangString = paramString3;
          paramString2 = new JSONObject(paramString1);
          if (paramString2.has("type")) {
            localDocsGrayTipsInfo.c = paramString2.getString("type");
          }
          if (paramString2.has("optType")) {
            localDocsGrayTipsInfo.jdField_d_of_type_JavaLangString = paramString2.getString("optType");
          }
          if (paramString2.has("authTips")) {
            localDocsGrayTipsInfo.jdField_e_of_type_JavaLangString = paramString2.getString("authTips");
          }
          if (paramString2.has("highlightText")) {
            localDocsGrayTipsInfo.f = paramString2.getString("highlightText");
          }
          if (paramString2.has("setpolicy")) {
            localDocsGrayTipsInfo.h = paramString2.getString("setpolicy");
          }
          if (paramString2.has("setflag")) {
            localDocsGrayTipsInfo.g = paramString2.getString("setflag");
          }
          if (paramString2.has("setonly")) {
            localDocsGrayTipsInfo.i = paramString2.getString("setonly");
          }
          if (paramString2.has("sucResult")) {
            localDocsGrayTipsInfo.j = paramString2.getString("sucResult");
          }
          if (paramString2.has("failResult")) {
            localDocsGrayTipsInfo.k = paramString2.getString("failResult");
          }
          if (paramString2.has("netFailResult")) {
            localDocsGrayTipsInfo.l = paramString2.getString("netFailResult");
          }
          if (paramString2.has("policy")) {
            localDocsGrayTipsInfo.m = paramString2.getString("policy");
          }
          if (paramString2.has("privilege")) {
            localDocsGrayTipsInfo.n = paramString2.getString("privilege");
          }
          if (paramString2.has("member_number")) {
            localDocsGrayTipsInfo.o = paramString2.getString("member_number");
          }
          if (paramString2.has("exp_remain_time")) {
            localDocsGrayTipsInfo.p = paramString2.getString("exp_remain_time");
          }
          if (paramString2.has("exp_set_time")) {
            localDocsGrayTipsInfo.q = paramString2.getString("exp_set_time");
          }
          if (paramString2.has("bNeedSetTime")) {
            localDocsGrayTipsInfo.r = paramString2.getString("bNeedSetTime");
          }
          if (paramString2.has("tiptype")) {
            localDocsGrayTipsInfo.s = paramString2.getString("tiptype");
          }
          paramString1 = localDocsGrayTipsInfo;
          if (paramString2.has("tipurl"))
          {
            localDocsGrayTipsInfo.t = paramString2.getString("tipurl");
            return localDocsGrayTipsInfo;
          }
        }
        catch (Exception paramString1) {}
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          DocsGrayTipsInfo localDocsGrayTipsInfo = null;
        }
      }
    }
    com.tencent.qphone.base.util.QLog.e(i + ayed.i, 1, " paseDocsGrayTipsInfoFromJson e =" + paramString1.toString());
    return localDocsGrayTipsInfo;
  }
  
  public static TeamWorkFileImportInfo a(FileManagerEntity paramFileManagerEntity, boolean paramBoolean)
  {
    Object localObject;
    if (paramFileManagerEntity == null) {
      localObject = null;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    do
    {
      do
      {
        return localObject;
        localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
        localTeamWorkFileImportInfo.jdField_e_of_type_Boolean = false;
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
        localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
        localTeamWorkFileImportInfo.c = paramFileManagerEntity.strFilePath;
        localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
        localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = paramBoolean;
        localTeamWorkFileImportInfo.n = paramFileManagerEntity.WeiYunFileId;
        localTeamWorkFileImportInfo.o = paramFileManagerEntity.Uuid;
        localTeamWorkFileImportInfo.g = paramFileManagerEntity.bSend;
        localObject = localTeamWorkFileImportInfo;
      } while (TextUtils.isEmpty(paramFileManagerEntity.peerUin));
      localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
      localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
      localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
      localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
      localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
      localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
      localObject = localTeamWorkFileImportInfo;
    } while (paramFileManagerEntity.status == 16);
    localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    return localTeamWorkFileImportInfo;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt <= 0) {
      return null;
    }
    Object localObject = "";
    paramInt -= 1;
    int j;
    String str;
    do
    {
      j = paramInt;
      if (((String)localObject).length() > 0) {
        j = paramInt - 1;
      }
      str = (char)(j % 26 + 65) + (String)localObject;
      j = (j - j % 26) / 26;
      localObject = str;
      paramInt = j;
    } while (j > 0);
    return str;
  }
  
  public static String a(long paramLong)
  {
    try
    {
      String str = e(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong)));
      if (str.equals(f)) {
        return f + " " + new SimpleDateFormat("HH:mm").format(Long.valueOf(paramLong));
      }
      if (str.equals(g)) {
        return g + " " + new SimpleDateFormat("HH:mm").format(Long.valueOf(paramLong));
      }
      str = new SimpleDateFormat("MM-dd HH:mm").format(Long.valueOf(paramLong));
      return str;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    String str = "";
    if (paramInt == 1) {
      str = "groupid=" + paramString + "&groupname=" + bbcz.a(paramQQAppInterface, paramString, false) + "&uinType=" + paramInt;
    }
    while (paramInt != 0) {
      return str;
    }
    return "groupid=" + paramString + "&groupname=" + bbcz.m(paramQQAppInterface, paramString) + "&uinType=" + paramInt;
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    int j = 0;
    com.tencent.qphone.base.util.QLog.e(i + ayed.i, 1, "troopFormLog getTroopFormGrayContent =." + paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString1);
    int k = 0;
    while (localMatcher.find())
    {
      int m = localMatcher.start();
      int n = localMatcher.end();
      Object localObject1 = paramString1.substring(m + 1, n);
      Object localObject2 = paramString1.substring(k, m);
      n += 1;
      localSpannableStringBuilder.append((CharSequence)localObject2);
      m = j;
      label310:
      String str1;
      for (;;)
      {
        String str2;
        try
        {
          localObject1 = new JSONObject((String)localObject1);
          m = j;
          if (!((JSONObject)localObject1).has("uin")) {
            break label324;
          }
          m = j;
          str2 = ((JSONObject)localObject1).getString("uin");
          m = j;
          String str3 = paramQQAppInterface.getCurrentAccountUin();
          m = j;
          if (TextUtils.isEmpty(paramString2)) {
            break label310;
          }
          m = j;
          localObject1 = bbcz.f(paramQQAppInterface, paramString2, str2);
          k = j;
          localObject2 = localObject1;
          m = j;
          if (!TextUtils.isEmpty(str3))
          {
            k = j;
            localObject2 = localObject1;
            m = j;
            if (str3.equals(str2))
            {
              k = j;
              localObject2 = localObject1;
              if (j == 0)
              {
                m = j;
                localObject2 = jdField_e_of_type_JavaLangString;
                k = 1;
              }
            }
          }
          m = k;
          localSpannableStringBuilder.append((CharSequence)localObject2);
          j = k;
          k = n;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          j = m;
          k = n;
        }
        break;
        m = j;
        str1 = bbcz.m(paramQQAppInterface, str2);
      }
      label324:
      k = n;
      m = j;
      if (str1.has("text"))
      {
        k = n;
        m = j;
        if (str1.has("isLink"))
        {
          k = n;
          m = j;
          if (str1.getString("isLink").equals("1"))
          {
            m = j;
            str1 = str1.getString("text");
            k = n;
            m = j;
            if (!TextUtils.isEmpty(str1))
            {
              m = j;
              localSpannableStringBuilder.append(str1);
              k = n;
            }
          }
        }
      }
    }
    if (k != paramString1.length()) {
      localSpannableStringBuilder.append(paramString1.subSequence(k, paramString1.length()));
    }
    return localSpannableStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    paramString = apvd.a(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return paramString.toLowerCase().replace(".", "");
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str1 = "";
    try
    {
      String str2 = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str1;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString2 = "?edited_url=" + str2;
        if (paramString1.contains("?")) {
          paramString2 = "&edited_url=" + str2;
        }
        paramString2 = paramString1 + paramString2;
      }
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      com.tencent.qphone.base.util.QLog.e(i, 1, paramString1.getLocalizedMessage(), paramString1);
    }
    return "";
  }
  
  public static List<ChatMessage> a(List<TencentDocData> paramList, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if (a(paramList))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (TencentDocData)paramList.next();
        MessageForStructing localMessageForStructing = new MessageForStructing();
        localMessageForStructing.structingMsg = new StructMsgForGeneralShare();
        localMessageForStructing.senderuin = String.valueOf(((TencentDocData)localObject).sendUin);
        localMessageForStructing.selfuin = paramString1;
        localMessageForStructing.frienduin = paramString2;
        localMessageForStructing.issend = 1;
        localMessageForStructing.msgtype = -2011;
        localMessageForStructing.time = ((TencentDocData)localObject).aioTime;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgAction = ((TencentDocData)localObject).action;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAction = ((TencentDocData)localObject).sourceAction;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgServiceID = ((TencentDocData)localObject).serviceId;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover = ((TencentDocData)localObject).docIcon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary = ((TencentDocData)localObject).summary;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle = ((TencentDocData)localObject).getTitle();
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceIcon = ((TencentDocData)localObject).icon;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceName = ((TencentDocData)localObject).sourceName;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgBrief = ((TencentDocData)localObject).getBriefDes(BaseApplication.getContext());
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceUrl = ((TencentDocData)localObject).url;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mSourceAppid = ((TencentDocData)localObject).appid;
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mMsgUrl = ((TencentDocData)localObject).docUrl;
        localObject = new axxi();
        ((axuq)localObject).b(0);
        axws localaxws = new axws(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentCover);
        localaxws.p = axws.m;
        ((axuq)localObject).a(localaxws);
        ((axuq)localObject).a(new StructMsgItemTitle(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentTitle));
        ((axuq)localObject).a(new axzj(((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mContentSummary));
        ((StructMsgForGeneralShare)localMessageForStructing.structingMsg).mStructMsgItemLists.add(localObject);
        localArrayList.add(localMessageForStructing);
      }
    }
    return localArrayList;
  }
  
  public static online_docs.DocId a(long paramLong, String paramString)
  {
    online_docs.DocId localDocId = new online_docs.DocId();
    localDocId.pad_id.set(ByteStringMicro.copyFromUtf8(paramString));
    localDocId.domain_id.set(paramLong);
    return localDocId;
  }
  
  public static void a(Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity == null) || (paramFileManagerEntity.bombData == null))
    {
      com.tencent.qphone.base.util.QLog.i(i, 1, "forwardRecentFileRecord. tencentDoc data is null");
      return;
    }
    try
    {
      Intent localIntent = new Intent();
      Object localObject = new JSONObject(new String(paramFileManagerEntity.bombData));
      paramFileManagerEntity = new Bundle();
      paramFileManagerEntity.putInt("forward_type", -3);
      paramFileManagerEntity.putInt("structmsg_service_id", ((JSONObject)localObject).getInt("structmsg_service_id"));
      paramFileManagerEntity.putByteArray("stuctmsg_bytes", Base64.decode(((JSONObject)localObject).getString("stuctmsg_bytes"), 0));
      paramFileManagerEntity.putLong("structmsg_uniseq", ((JSONObject)localObject).getLong("structmsg_uniseq"));
      paramFileManagerEntity.putInt("accostType", ((JSONObject)localObject).getInt("accostType"));
      paramFileManagerEntity.putBoolean("forwardDirect", true);
      localObject = new Intent();
      ((Intent)localObject).putExtra("forward_type", -3);
      ((Intent)localObject).putExtras(paramFileManagerEntity);
      localIntent.putExtra("forwardDirect", true);
      aqbe.a(paramActivity, (Intent)localObject, 103);
      return;
    }
    catch (JSONException paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      if (TextUtils.isEmpty(anbq.a().h())) {}
      String str2;
      for (String str1 = "https://docs.qq.com/desktop/m/index.html?_from=1";; str1 = anbq.a().h())
      {
        str2 = b(str1, paramString);
        localIntent.putExtra("tdsourcetag", paramString);
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        localIntent.putExtra("fragment_class", TeamWorkDocsListFragment.class.getCanonicalName());
        str1 = paramString;
        if (TextUtils.equals(paramString, "s_qq_history_tab")) {
          str1 = "s_qq_myfile";
        }
        if (TeamWorkDocEditBrowserActivity.a(paramActivity, str2, str1)) {
          return;
        }
        if (paramInt >= 0) {
          break;
        }
        paramActivity.startActivity(localIntent.putExtra("url", str2));
        return;
      }
      paramActivity.startActivityForResult(localIntent.putExtra("url", str2), paramInt);
      return;
    }
    catch (Exception paramActivity)
    {
      com.tencent.qphone.base.util.QLog.i(i, 1, paramActivity.toString());
    }
  }
  
  public static void a(Intent paramIntent, String paramString)
  {
    if ((paramIntent == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      paramIntent = paramIntent.getStringExtra("tdsourcetype");
    } while (TextUtils.isEmpty(paramIntent));
    if (paramIntent.contains("1")) {}
    for (int j = 1;; j = 2)
    {
      axqy.b(null, "dc00898", "", "", paramString, paramString, j, 0, "", "", "s_qq_history_tab", paramIntent.substring(0, paramIntent.length() - 1));
      return;
    }
  }
  
  public static void a(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {}
    do
    {
      return;
      paramBundle.setClassLoader(ayfx.class.getClassLoader());
    } while (!(paramBundle.getParcelable("key_team_work_file_import_info") instanceof TeamWorkFileImportInfo));
    a((TeamWorkFileImportInfo)paramBundle.getParcelable("key_team_work_file_import_info"), paramBundle.getString("url"), paramString);
  }
  
  public static void a(TextView paramTextView, View.OnClickListener paramOnClickListener)
  {
    if (paramTextView == null) {
      return;
    }
    Object localObject2 = anbi.a();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new anbh();
    }
    localObject2 = ((anbh)localObject1).a();
    String str = ((anbh)localObject1).b();
    if (TextUtils.isEmpty(str))
    {
      paramTextView.setText((CharSequence)localObject2);
      return;
    }
    int m = ((String)localObject2).indexOf(str);
    if (m < 0)
    {
      paramTextView.setText(((anbh)localObject1).a());
      return;
    }
    int k = str.length() + m;
    int j = k;
    if (k > ((String)localObject2).length()) {
      j = ((String)localObject2).length();
    }
    k = Color.parseColor("#4D94FF");
    int n = Color.parseColor("#804D94FF");
    localObject1 = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { n, k });
    localObject2 = new SpannableString((CharSequence)localObject2);
    ((SpannableString)localObject2).setSpan(new annk(paramOnClickListener, (ColorStateList)localObject1), m, j, 33);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setText((CharSequence)localObject2);
    paramTextView.setFocusable(false);
    paramTextView.setClickable(false);
    paramTextView.setLongClickable(false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    int j = 2;
    String str1 = "";
    String str2 = String.valueOf(paramLong1);
    if (paramInt == 1)
    {
      str1 = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + "docs.qq.com/desktop/m/templates_list.html?padtype=0&_wv=2&_wwv=512" + "&group_code=" + str2 + "&group_type=" + paramLong2 + "&create_from=" + paramString;
      if (paramInt != 1) {
        break label341;
      }
      j = 1;
    }
    for (;;)
    {
      label97:
      paramString = new Bundle();
      paramString.putString("url", str1);
      paramString.putString("title", paramActivity.getString(2131720148));
      paramString.putInt("key_team_work_edit_type", j);
      paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(String.valueOf(paramLong1));
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopname))) {
        paramString.putString("troop_name", paramQQAppInterface.troopname);
      }
      for (;;)
      {
        TeamWorkDocEditBrowserActivity.a(paramActivity, paramString, true);
        return;
        if (paramInt == 2)
        {
          str1 = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + "docs.qq.com/desktop/m/templates_list.html?padtype=1&_wv=2&_wwv=512" + "&group_code=" + str2 + "&group_type=" + paramLong2 + "&create_from=" + paramString;
          break;
        }
        if (paramInt != 3) {
          break;
        }
        str1 = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + "docs.qq.com/desktop/m/templates_list.html?padtype=2&_wv=2&_wwv=512" + "&group_code=" + str2 + "&group_type=" + paramLong2 + "&create_from=" + paramString;
        break;
        label341:
        if (paramInt == 2) {
          break label97;
        }
        if (paramInt != 3) {
          break label388;
        }
        j = 3;
        break label97;
        paramString.putString("troop_name", "" + paramLong1);
      }
      label388:
      j = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    String str = apvm.a(paramQQAppInterface, paramLong1, paramLong3);
    if (!TextUtils.isEmpty(str))
    {
      bcql.a(paramActivity, str, 0).a();
      return;
    }
    a(paramQQAppInterface, paramActivity, paramInt, paramString, paramLong1, paramLong2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, TencentDocData paramTencentDocData, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject1 = ancl.a();
    if (localObject1 != null) {}
    for (boolean bool = ((anch)localObject1).a(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);; bool = false)
    {
      int j;
      Intent localIntent;
      if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)) && (TextUtils.isEmpty(paramTeamWorkFileImportInfo.n)))
      {
        j = 1;
        localIntent = new Intent();
        localIntent.putExtra("key_flag_from_plugin", true);
        localIntent.putExtra("k_forward_show_direct_share_tips", true);
        localIntent.putExtra("forward_type", 1001);
        localIntent.putExtra("req_type", 95);
        localIntent.putExtra("pluginName", "web_share");
        localIntent.putExtra("image_url_remote", paramTencentDocData.docIcon);
        Object localObject2 = new StringBuilder().append(paramQQAppInterface.getCurrentNickname()).append(ajya.a(2131714786));
        if (!bool) {
          break label618;
        }
        localObject1 = ajya.a(2131714777);
        label174:
        localObject2 = (String)localObject1 + "《" + paramTencentDocData.title + "》";
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 45) {
            localObject1 = ((String)localObject2).substring(0, 45) + "…";
          }
        }
        localIntent.putExtra("title", (String)localObject1);
        localObject1 = paramTencentDocData.summary;
        if ((localObject1 == null) || (((String)localObject1).length() <= 60)) {
          break label675;
        }
        localObject1 = ((String)localObject1).substring(0, 60) + "…";
      }
      label647:
      label658:
      label668:
      label675:
      for (;;)
      {
        localIntent.putExtra("desc", (String)localObject1);
        localIntent.putExtra("detail_url", paramTencentDocData.docUrl);
        localIntent.putExtra("struct_share_key_content_action", "web");
        localIntent.putExtra("struct_share_key_source_action", "web");
        localIntent.putExtra("struct_share_key_source_icon", jdField_d_of_type_JavaLangString);
        localIntent.putExtra("app_name", paramActivity.getString(2131720172));
        localIntent.putExtra("source_url", "https://docs.qq.com/desktop/m/index.html?_wv=2097154");
        localIntent.putExtra("forward _key_nojump", true);
        paramTencentDocData = axva.a(localIntent.getExtras());
        if (paramTencentDocData != null)
        {
          localIntent.putExtra("stuctmsg_bytes", paramTencentDocData.getBytes());
          if (j != 0)
          {
            localIntent.putExtra("uintype", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
            localIntent.putExtra("uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
            localIntent.putExtra("troop_uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
            localIntent.putExtra("uinname", bbcz.a(paramQQAppInterface, paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString, paramTeamWorkFileImportInfo.jdField_a_of_type_Int));
          }
          paramQQAppInterface = new StringBuilder(ajya.a(2131714750));
          if ((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000)) {
            break label629;
          }
          paramQQAppInterface.append("群成员");
          label547:
          if (!bool) {
            break label647;
          }
          paramQQAppInterface.append("一起编辑文档：");
          label560:
          localIntent.putExtra("key_send_tips", paramQQAppInterface.toString());
          if (j != 0) {
            break label658;
          }
          ayhm.a(null, "0X800A5A1");
          label585:
          if (j == 0) {
            break label668;
          }
        }
        for (paramQQAppInterface = DirectForwardActivity.class;; paramQQAppInterface = ForwardRecentActivity.class)
        {
          localIntent.setClass(paramActivity, paramQQAppInterface);
          paramActivity.startActivityForResult(localIntent, 2864);
          return;
          j = 0;
          break;
          label618:
          localObject1 = ajya.a(2131714790);
          break label174;
          label629:
          if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 0) {
            break label547;
          }
          paramQQAppInterface.append("好友");
          break label547;
          paramQQAppInterface.append("一起查看文档：");
          break label560;
          ayhm.a(null, "0X800A5A2");
          break label585;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, long paramLong, GroupPadTemplateInfo paramGroupPadTemplateInfo)
  {
    String str2 = "";
    String str1 = "";
    int m;
    int k;
    if (paramGroupPadTemplateInfo != null)
    {
      m = paramGroupPadTemplateInfo.docOrSheetType;
      k = paramGroupPadTemplateInfo.templateID;
      str2 = String.valueOf(paramGroupPadTemplateInfo.groupCode);
    }
    for (paramGroupPadTemplateInfo = paramGroupPadTemplateInfo.templateUrl;; paramGroupPadTemplateInfo = str1)
    {
      int j;
      if (!TextUtils.isEmpty(paramGroupPadTemplateInfo))
      {
        str1 = "https:" + paramGroupPadTemplateInfo;
        if (bfnx.a(str1)) {
          break label522;
        }
        j = 1;
      }
      for (;;)
      {
        paramGroupPadTemplateInfo = str1;
        if (j != 0)
        {
          if (m == 1)
          {
            paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=doc&tid=%s&pdid=null", new Object[] { Integer.valueOf(k) });
            paramGroupPadTemplateInfo = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + paramGroupPadTemplateInfo + "&group_code=" + str2;
          }
        }
        else
        {
          label170:
          if ((TextUtils.isEmpty(paramString)) || (paramLong == -1L) || (TextUtils.isEmpty(paramGroupPadTemplateInfo))) {
            break label516;
          }
          if (!paramGroupPadTemplateInfo.contains("?")) {
            break label427;
          }
          paramString = paramGroupPadTemplateInfo + "&group_type=" + paramLong + "&create_from=" + paramString;
        }
        for (;;)
        {
          label240:
          if (m == 1) {
            j = 1;
          }
          for (;;)
          {
            label249:
            paramGroupPadTemplateInfo = new Bundle();
            paramGroupPadTemplateInfo.putString("tdsourcetag", "s_qq_grpfile");
            paramGroupPadTemplateInfo.putString("url", paramString);
            paramGroupPadTemplateInfo.putInt("key_team_work_edit_type", j);
            paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(str2);
            if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.troopname))) {
              paramGroupPadTemplateInfo.putString("troop_name", paramQQAppInterface.troopname);
            }
            for (;;)
            {
              TeamWorkDocEditBrowserActivity.a(paramActivity, paramGroupPadTemplateInfo, true);
              return;
              str1 = "";
              j = 1;
              break;
              paramGroupPadTemplateInfo = str1;
              if (m != 2) {
                break label170;
              }
              paramGroupPadTemplateInfo = String.format("docs.qq.com/template/preview?padtype=sheet&tid=%s&pdid=null", new Object[] { Integer.valueOf(k) });
              paramGroupPadTemplateInfo = "https://" + paramQQAppInterface.getCurrentAccountUin() + "." + paramGroupPadTemplateInfo + "&group_code=" + str2;
              break label170;
              label427:
              paramString = paramGroupPadTemplateInfo + "?group_type=" + paramLong + "&create_from=" + paramString;
              break label240;
              if (m != 2) {
                break label510;
              }
              j = 2;
              break label249;
              paramGroupPadTemplateInfo.putString("troop_name", "" + str2);
            }
            label510:
            j = 1;
          }
          label516:
          paramString = paramGroupPadTemplateInfo;
        }
        label522:
        j = 0;
      }
      k = 0;
      m = 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramQQAppInterface == null) || (paramTeamWorkFileImportInfo == null)) {
      return;
    }
    paramTeamWorkFileImportInfo.jdField_d_of_type_Int = 7;
    ayee.a(paramQQAppInterface, paramContext, paramString, paramTeamWorkFileImportInfo, null);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramQQAppInterface.getApp().getString(2131720151).equals(str))
      {
        paramContext = paramQQAppInterface.a().a(localDocsGrayTipsInfo.jdField_a_of_type_JavaLangString, 0, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.a != null)) {
            paramArrayOfObject.tipParam.a.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      for (;;)
      {
        com.tencent.qphone.base.util.QLog.i(ayed.i, 2, " onGetUserAuth  isSuccess = " + paramBoolean + " tips =" + str);
        return;
        bcql.a(paramContext, str, 0).a();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(ayed.i, 2, " onGetUserAuth  exception = " + paramQQAppInterface.toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, String paramString, int paramInt)
  {
    if (paramQQAppInterface == null) {}
    Object localObject2;
    Object localObject1;
    do
    {
      return;
      Intent localIntent = new Intent();
      localIntent.putExtra("type", g(paramFileManagerEntity.Uuid));
      localIntent.putExtra("miniprogram_image_url", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("key_flag_from_plugin", false);
      localIntent.putExtra("isFromShare", true);
      localIntent.putExtra("forward_type", 1001);
      localIntent.putExtra("req_type", 95);
      localIntent.putExtra("detail_url", paramFileManagerEntity.Uuid);
      localIntent.putExtra("image_url_remote", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("req_share_id", jdField_a_of_type_Long);
      localIntent.putExtra("source_url", jdField_b_of_type_JavaLangString);
      localIntent.putExtra("app_name", ajya.a(2131714795));
      localIntent.putExtra("struct_share_key_source_icon", jdField_d_of_type_JavaLangString);
      localIntent.putExtra("struct_share_key_source_action", "web");
      localIntent.putExtra("pubUin", "");
      localIntent.putExtra("struct_uin", "");
      localObject2 = paramFileManagerEntity.fileName;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 45) {
          localObject1 = ((String)localObject2).substring(0, 45) + "…";
        }
      }
      String str = ajya.a(2131714818);
      localIntent.putExtra("title", (String)localObject1);
      localObject2 = str;
      if (str != null)
      {
        localObject2 = str;
        if (str.length() > 60) {
          localObject2 = str.substring(0, 60) + "…";
        }
      }
      localIntent.putExtra("desc", (String)localObject2);
      localIntent.putExtra("forward_thumb", paramFileManagerEntity.strThumbPath);
      localIntent.putExtra("struct_share_key_content_action", "web");
      localIntent.putExtra("req_share_id", -1L);
      localIntent.putExtra("brief_key", BaseApplicationImpl.sApplication.getString(2131696698, new Object[] { localObject1 }));
      localIntent.putExtra("to_uin", paramString);
      localIntent.putExtra("uin_type", paramInt);
      localObject2 = localIntent.getExtras();
      paramFileManagerEntity = axva.a((Bundle)localObject2);
      paramInt = ((Bundle)localObject2).getInt("uin_type");
      paramString = ((Bundle)localObject2).getString("to_uin");
      localObject1 = ((Bundle)localObject2).getString("docs_gray_tips_info_json");
      localObject2 = ((Bundle)localObject2).getString("detail_url");
    } while (paramFileManagerEntity == null);
    paramFileManagerEntity.mExtraData = "aioPlusPanelTencentDoc";
    bbjx.a(paramQQAppInterface, paramString, paramInt, paramFileManagerEntity, null, (String)localObject1, (String)localObject2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    axqy.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, long paramLong1, long paramLong2, String paramString2, String paramString3)
  {
    DocsGrayTipsInfo localDocsGrayTipsInfo = a(paramString2, paramString1, paramString3);
    if (localDocsGrayTipsInfo != null)
    {
      com.tencent.qphone.base.util.QLog.i(i + ayed.i, 1, "addTeamWorkGrayTips. docsGrayTipsInfo = " + localDocsGrayTipsInfo.toString());
      int j;
      label258:
      aqvb localaqvb;
      if ((!TextUtils.isEmpty(localDocsGrayTipsInfo.c)) && (Integer.valueOf(localDocsGrayTipsInfo.c).intValue() == 1))
      {
        if (paramInt == 1)
        {
          j = ancx.a().b();
          com.tencent.qphone.base.util.QLog.i(i + ayed.i, 1, "addTeamWorkGrayTips. groupFlag = " + j);
          if (j == 0) {}
          int k;
          do
          {
            return;
            j = bbkb.aL(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()) + 1;
            k = ancx.a().a();
            com.tencent.qphone.base.util.QLog.i(i + ayed.i, 1, "addTeamWorkGrayTips. groupShowedCount = " + j + ", groupShowCount = " + k);
          } while (j > k);
          bbkb.ab(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), j);
        }
      }
      else
      {
        MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
        if (paramInt != 1) {
          break label631;
        }
        localaqvb = new aqvb(paramString1, paramQQAppInterface.getCurrentAccountUin(), localDocsGrayTipsInfo.jdField_e_of_type_JavaLangString, 1, -5020, 3276802, paramLong2);
        localMessageForUniteGrayTip.shmsgseq = (1L + paramLong1);
        label308:
        Bundle localBundle = new Bundle();
        localBundle.putInt("key_action", 33);
        localBundle.putString("textColor", "#40A0FF");
        localBundle.putString("key_action_DATA", paramString2 + "@#@" + String.valueOf(localMessageForUniteGrayTip.uniseq));
        localBundle.putString("key_a_action_DATA", paramString3);
        localBundle.putString("troop_mem_uin", paramString1);
        paramString1 = localDocsGrayTipsInfo.a();
        localaqvb.a(paramString1[0], paramString1[1], localBundle);
        localMessageForUniteGrayTip.initGrayTipMsg(paramQQAppInterface, localaqvb);
        aqvc.a(paramQQAppInterface, localMessageForUniteGrayTip);
        if (!"1".equals(localDocsGrayTipsInfo.jdField_d_of_type_JavaLangString)) {
          break label667;
        }
        if (paramInt != 1) {
          break label662;
        }
        paramInt = 1;
        label452:
        axqy.b(null, "CliOper", "", "", "0X80095F2", "0X80095F2", paramInt, 0, "", "", "", "");
      }
      label662:
      label667:
      for (;;)
      {
        label485:
        if (localDocsGrayTipsInfo.s.equals(ayed.k))
        {
          axqy.b(paramQQAppInterface, "dc00898", "", "", "0X8009C78", "0X8009C78", 0, 0, "", "", "", "");
          return;
          if (ancx.a().d() == 0) {
            break;
          }
          j = bbkb.aK(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin()) + 1;
          if (j > ancx.a().c()) {
            break;
          }
          bbkb.aa(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), j);
          com.tencent.qphone.base.util.QLog.d(i + ayed.i, 2, "yunying gray tip showed count = " + j);
          break label258;
          label631:
          localaqvb = new aqvb(paramString1, paramQQAppInterface.getCurrentAccountUin(), localDocsGrayTipsInfo.jdField_e_of_type_JavaLangString, 0, -5020, 3276802, paramLong2);
          break label308;
          paramInt = 0;
          break label452;
          if ("2".equals(localDocsGrayTipsInfo.jdField_d_of_type_JavaLangString)) {
            if (paramInt != 1) {
              break label724;
            }
          }
        }
      }
      label724:
      for (paramInt = 1;; paramInt = 0)
      {
        axqy.b(null, "CliOper", "", "", "0X80095F1", "0X80095F1", paramInt, 0, "", "", "", "");
        break label485;
        break;
      }
    }
    com.tencent.qphone.base.util.QLog.e(i + ayed.i, 1, "addTeamWorkGrayTips. docsGrayTipsInfo is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    String str = "";
    if (localTroopManager != null) {}
    for (paramString2 = localTroopManager.b(paramString2);; paramString2 = null)
    {
      if (paramString2 != null) {
        str = "" + paramString2.dwGroupClassExt;
      }
      axqy.b(paramQQAppInterface, "CliOper", "", "", paramString1, paramString1, 0, 0, "", "", str, "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TroopTips0x857.TroopFormGrayTipsInfo paramTroopFormGrayTipsInfo, String paramString)
  {
    if (paramTroopFormGrayTipsInfo != null)
    {
      com.tencent.qphone.base.util.QLog.i(i + ayed.i, 1, "troopFormLog insertTroopFormGrayTips troop = " + paramTroopFormGrayTipsInfo.toString());
      String str1 = paramQQAppInterface.getApp().getString(2131720470);
      String str2 = paramTroopFormGrayTipsInfo.bytes_opt_bytes_url.get().toStringUtf8();
      String str3 = paramTroopFormGrayTipsInfo.uint64_writer_uin.get() + "";
      String str4 = paramTroopFormGrayTipsInfo.uint64_creator_uin.get() + "";
      String str5 = paramTroopFormGrayTipsInfo.bytes_rich_content.get().toStringUtf8();
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips url = " + str2);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips writerUin = " + str3);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips creatorUin = " + str4);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips context = " + str5);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips creator_nick = " + paramTroopFormGrayTipsInfo.bytes_creator_nick.get().toStringUtf8());
      paramTroopFormGrayTipsInfo = paramQQAppInterface.c();
      if ((TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(paramTroopFormGrayTipsInfo)) || ((!paramTroopFormGrayTipsInfo.equals(str3)) && (!paramTroopFormGrayTipsInfo.equals(str4)))) {}
      int j;
      do
      {
        do
        {
          return;
          paramTroopFormGrayTipsInfo = a(paramQQAppInterface, str5, paramString);
          com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips tips = " + paramTroopFormGrayTipsInfo);
          com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips troopUin = " + paramString);
        } while (TextUtils.isEmpty(paramTroopFormGrayTipsInfo));
        j = paramTroopFormGrayTipsInfo.indexOf(str1);
      } while (j == -1);
      new Thread(new TeamWorkUtils.1(paramString, paramTroopFormGrayTipsInfo, paramQQAppInterface, str2, j, str1)).start();
      return;
    }
    com.tencent.qphone.base.util.QLog.e(i + ayed.i, 1, "troopFormLog insertTroopFormGrayTips Info is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SubMsgType0x119.MsgBody paramMsgBody)
  {
    if (paramMsgBody != null)
    {
      com.tencent.qphone.base.util.QLog.i(i + ayed.i, 1, "troopFormLog insertTroopFormGrayTips c2c = " + paramMsgBody.toString());
      String str1 = paramQQAppInterface.getApp().getString(2131720470);
      String str2 = paramMsgBody.bytes_opt_bytes_url.get().toStringUtf8();
      String str3 = paramMsgBody.uint64_writer_uin.get() + "";
      String str4 = paramMsgBody.uint64_creator_uin.get() + "";
      String str5 = paramMsgBody.bytes_rich_content.get().toStringUtf8();
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips url = " + str2);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips writerUin = " + str3);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips creatorUin = " + str4);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips context = " + str5);
      com.tencent.qphone.base.util.QLog.i(i, 1, "troopFormLog insertTroopFormGrayTips creator_nick = " + paramMsgBody.bytes_creator_nick.get().toStringUtf8());
      paramMsgBody = paramQQAppInterface.c();
      if ((TextUtils.isEmpty(str5)) || (TextUtils.isEmpty(paramMsgBody)) || ((!paramMsgBody.equals(str3)) && (!paramMsgBody.equals(str4)))) {}
      int j;
      do
      {
        do
        {
          return;
          str5 = a(paramQQAppInterface, str5, "");
        } while (TextUtils.isEmpty(str5));
        j = str5.indexOf(str1);
      } while (j == -1);
      new Thread(new TeamWorkUtils.2(paramMsgBody, str3, str4, paramQQAppInterface, str5, str2, j, str1)).start();
      return;
    }
    com.tencent.qphone.base.util.QLog.e(i + ayed.i, 1, "troopFormLog insertTroopFormGrayTipsInfo is null.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    bbkb.b(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_enable_assistant", paramBoolean);
    paramQQAppInterface = (ayfg)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {}
    do
    {
      do
      {
        Object localObject2;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (!(paramMessageRecord instanceof MessageForStructing)) {
                  break;
                }
                paramMessageRecord = (MessageForStructing)paramMessageRecord;
              } while ((paramMessageRecord.structingMsg == null) || (TextUtils.isEmpty(paramMessageRecord.structingMsg.mMsgUrl)) || (!apej.a(paramMessageRecord.structingMsg.mMsgUrl)));
              try
              {
                if ((paramMessageRecord.structingMsg instanceof StructMsgForGeneralShare))
                {
                  StructMsgForGeneralShare localStructMsgForGeneralShare = (StructMsgForGeneralShare)paramMessageRecord.structingMsg;
                  localObject2 = ayfg.a(localStructMsgForGeneralShare.mMsgUrl, paramMessageRecord.selfuin);
                  if (((JSONObject)localObject2).getInt("retcode") == 0) {
                    localStructMsgForGeneralShare.mContentTitle = ((String)((JSONObject)((JSONObject)localObject2).get("doc_meta")).get("title"));
                  }
                }
                return;
              }
              catch (JSONException localJSONException)
              {
                if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
                  com.tencent.qphone.base.util.QLog.e(ayed.i, 2, localJSONException.getMessage());
                }
                return;
              }
              finally
              {
                b(paramMessageRecord, paramQQAppInterface);
              }
              if (!(paramMessageRecord instanceof MessageForArkApp)) {
                break;
              }
              paramMessageRecord = (MessageForArkApp)paramMessageRecord;
              paramQQAppInterface = paramMessageRecord.ark_app_message.metaList;
            } while (TextUtils.isEmpty(paramQQAppInterface));
            try
            {
              paramQQAppInterface = new JSONObject(new JSONObject(paramQQAppInterface).getString(paramMessageRecord.ark_app_message.appView));
              String str = paramQQAppInterface.optString("appid");
              localObject2 = paramQQAppInterface.optString("qqdocurl");
              if ((TextUtils.isEmpty(str)) || (!str.equals(String.valueOf(jdField_a_of_type_Long)))) {
                break;
              }
              a(paramQQAppInterface.getString("jumpUrl").replace("\\", ""), paramMessageRecord.frienduin);
              return;
            }
            catch (JSONException paramMessageRecord) {}
          } while (!com.tencent.qphone.base.util.QLog.isColorLevel());
          com.tencent.qphone.base.util.QLog.e(ayed.i, 2, paramMessageRecord.getMessage());
          return;
        } while ((TextUtils.isEmpty((CharSequence)localObject2)) || (!apej.a((String)localObject2)));
        a((String)localObject2, paramMessageRecord.frienduin);
        return;
      } while (!(paramMessageRecord instanceof MessageForText));
      paramMessageRecord = (MessageForText)paramMessageRecord;
    } while (!apej.a(paramMessageRecord.msg));
    a(paramMessageRecord.msg, paramMessageRecord.frienduin);
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString1, String paramString2)
  {
    if ((paramTeamWorkFileImportInfo == null) || (!paramTeamWorkFileImportInfo.d())) {}
    while (TextUtils.isEmpty(paramString2)) {
      return;
    }
    String str1 = paramTeamWorkFileImportInfo.k;
    String str2 = a(paramTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString);
    long l = paramTeamWorkFileImportInfo.jdField_d_of_type_Long;
    if ((paramString1 != null) && (paramString1.contains("m_readonly"))) {}
    for (boolean bool = true;; bool = false)
    {
      ayhm.a(null, str1, paramString2, str2, String.valueOf(bool), String.valueOf(l));
      return;
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, null);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        String str = localQQAppInterface.getCurrentAccountUin();
        JSONObject localJSONObject = ayfg.a(paramString1, str);
        if (localJSONObject.getInt("retcode") == 0)
        {
          TencentDocData localTencentDocData = new TencentDocData();
          TencentDocData.obtainFromJsonObject(localJSONObject, null, localTencentDocData);
          localTencentDocData.docUrl = paramString1;
          localTencentDocData.sendUin = Long.parseLong(str);
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = str;
          }
          localTencentDocData.aioTime = (System.currentTimeMillis() / 1000L);
          paramString2 = new ArrayList();
          paramString2.add(localTencentDocData);
          paramString1 = a(paramString2, str, paramString1).iterator();
          while (paramString1.hasNext()) {
            b((ChatMessage)paramString1.next(), localQQAppInterface);
          }
          if (!com.tencent.qphone.base.util.QLog.isColorLevel()) {}
        }
      }
      catch (JSONException paramString1) {}
    }
    com.tencent.qphone.base.util.QLog.e(i, 2, paramString1, new Object[0]);
  }
  
  public static boolean a()
  {
    boolean bool = true;
    long l = System.currentTimeMillis();
    if (l - jdField_b_of_type_Long >= 1000L) {
      bool = false;
    }
    jdField_b_of_type_Long = l;
    return bool;
  }
  
  /* Error */
  public static boolean a(int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 202	ayfx:jdField_a_of_type_Int	I
    //   6: iload_0
    //   7: if_icmpne +14 -> 21
    //   10: iconst_1
    //   11: istore_1
    //   12: iload_0
    //   13: putstatic 202	ayfx:jdField_a_of_type_Int	I
    //   16: ldc 2
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -11 -> 12
    //   26: astore_2
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	paramInt	int
    //   11	12	1	bool	boolean
    //   26	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	10	26	finally
    //   12	16	26	finally
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
      paramContext.startActivity(localIntent.putExtra("url", paramString));
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    com.tencent.qphone.base.util.QLog.d(i, 1, "troopFormLog openTroopFormMiniApp =" + paramString1);
    try
    {
      LaunchParam localLaunchParam = new LaunchParam();
      localLaunchParam.scene = 0;
      localLaunchParam.miniAppId = "1108961705";
      localLaunchParam.entryPath = "pages/detail/detail";
      StringBuilder localStringBuilder;
      if (!TextUtils.isEmpty(paramString1))
      {
        localStringBuilder = new StringBuilder().append(localLaunchParam.entryPath).append("?url=").append(URLEncoder.encode(paramString1, "utf-8"));
        if (!TextUtils.isEmpty(paramString2)) {
          break label247;
        }
      }
      label247:
      for (paramString2 = "";; paramString2 = "&" + paramString2)
      {
        localLaunchParam.entryPath = paramString2;
        localLaunchParam.navigateExtData = ("url=" + paramString1);
        MiniAppLauncher.launchMiniAppById(paramContext, localLaunchParam.miniAppId, localLaunchParam.entryPath, localLaunchParam.navigateExtData, localLaunchParam.envVersion, localLaunchParam.reportData, localLaunchParam.scene);
        if (!com.tencent.TMG.utils.QLog.isColorLevel()) {
          break;
        }
        com.tencent.TMG.utils.QLog.i(i, 0, "openTroopFormMiniApp:open :scene = " + localLaunchParam.scene + "miniAppId = " + localLaunchParam.miniAppId + "entryPath = " + localLaunchParam.entryPath + "navigateExtData = " + localLaunchParam.navigateExtData);
        break;
      }
      return true;
    }
    catch (UnsupportedEncodingException paramContext)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.e(i, 0, "openTroopFormMiniApp " + paramContext.getMessage());
      }
      return false;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ayfg)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      if (TextUtils.isEmpty(anbq.a().h())) {}
      for (paramQQAppInterface = "https://docs.qq.com/desktop/m/index.html?_from=1";; paramQQAppInterface = anbq.a().h())
      {
        localIntent.putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
        paramActivity.startActivity(localIntent.putExtra("url", paramQQAppInterface));
        break;
      }
      return true;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, int paramInt, String paramString2)
  {
    try
    {
      localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      paramQQAppInterface.getCurrentAccountUin();
      str1 = anbk.a().a();
      if (str1 != null) {
        break label352;
      }
      str1 = "https://docs.qq.com/desktop/m/send.html";
    }
    catch (Exception paramQQAppInterface)
    {
      label352:
      for (;;)
      {
        Intent localIntent;
        String str1;
        String str2;
        long l;
        paramQQAppInterface.printStackTrace();
        continue;
        paramQQAppInterface = "group_aio";
        continue;
        paramQQAppInterface = "";
      }
    }
    str2 = URLEncoder.encode(paramString2, "UTF-8");
    l = -1L;
    if (paramInt == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.b(paramString1);
        if (paramQQAppInterface != null)
        {
          l = paramQQAppInterface.dwGroupClassExt;
          paramQQAppInterface = "group_aio";
          paramString2 = str1 + "?toUin=" + paramString1 + "&uinType=" + String.valueOf(paramInt) + "&remarkName=" + str2;
          if (str1.contains("?")) {
            paramString2 = str1 + "&toUin=" + paramString1 + "&uinType=" + String.valueOf(paramInt) + "&remarkName=" + str2;
          }
          str1 = paramString2;
          if (!TextUtils.isEmpty(paramQQAppInterface)) {
            str1 = paramString2 + "&create_from=" + paramQQAppInterface;
          }
          paramQQAppInterface = str1;
          if (l != -1L) {
            paramQQAppInterface = str1 + "&group_type=" + l;
          }
          localIntent.putExtra("url", paramQQAppInterface);
          localIntent.putExtra("toUin", paramString1);
          localIntent.putExtra("uinType", paramInt);
          localIntent.putExtra("big_brother_source_key", "biz_src_jc_xiaolv");
          paramActivity.startActivity(localIntent);
          return true;
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("docs.qq.com"))
      {
        bool1 = bool3;
        if (!paramString.contains("docx.qq.com")) {
          break label100;
        }
      }
    }
    try
    {
      paramString = new URL(paramString).getPath();
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("/")) && (!paramString.equals("/index.html")) && (!paramString.equals("/mobile.html")))
      {
        bool3 = paramString.equals("/login.html");
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = false;
      }
      label100:
      return bool1;
    }
    catch (Exception paramString)
    {
      com.tencent.qphone.base.util.QLog.e("docHome", 1, " detect docHome error: " + paramString.toString());
    }
    return true;
  }
  
  public static boolean a(String paramString, Context paramContext)
  {
    return a(paramString, paramContext, -1, null, null);
  }
  
  public static boolean a(String paramString, Context paramContext, int paramInt, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface)
  {
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d(i, 2, "TencentDoc clickWeb url = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      if ((paramFileManagerEntity != null) && (paramQQAppInterface != null)) {
        ThreadManager.postImmediately(new TeamWorkUtils.4(paramString, paramQQAppInterface, paramFileManagerEntity), null, true);
      }
      paramString = paramString.trim();
    } while (!a(paramString));
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putString("url", paramString);
    paramFileManagerEntity.putString("tdsourcetag", "s_qq_aiomsg");
    paramFileManagerEntity.putInt("tdsourcetab", paramInt);
    TeamWorkDocEditBrowserActivity.a(paramContext, paramFileManagerEntity, false);
    return true;
  }
  
  public static boolean a(String paramString1, String paramString2, long paramLong)
  {
    anby localanby = anca.a();
    if (localanby != null)
    {
      boolean bool2 = a(localanby.jdField_a_of_type_JavaUtilMap, paramString1, paramString2, paramLong);
      boolean bool1 = bool2;
      if (bool2) {
        bool1 = localanby.a(paramString2);
      }
      return bool1;
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = false;
    String str = paramString2;
    if (TextUtils.isEmpty(paramString2))
    {
      str = paramString2;
      if (!TextUtils.isEmpty(paramString1))
      {
        paramString1 = new File(paramString1);
        str = paramString2;
        if (paramString1 != null)
        {
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
    }
    paramString1 = apvd.a(str);
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (paramString3.indexOf(paramString1.toLowerCase()) >= 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(Collection paramCollection)
  {
    return (paramCollection != null) && (!paramCollection.isEmpty());
  }
  
  public static boolean a(Map<String, Long> paramMap, String paramString1, String paramString2, long paramLong)
  {
    if ((paramMap == null) || (paramMap.isEmpty())) {}
    do
    {
      return false;
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        str = paramString2;
        if (!TextUtils.isEmpty(paramString1))
        {
          paramString1 = new File(paramString1);
          str = paramString2;
          if (paramString1.exists()) {
            str = paramString1.getName();
          }
        }
      }
      paramString1 = a(str);
    } while ((TextUtils.isEmpty(paramString1)) || (!paramMap.containsKey(paramString1)));
    if (((Long)paramMap.get(paramString1)).longValue() > paramLong) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static Bitmap b(int paramInt)
  {
    return a(jdField_b_of_type_AndroidUtilSparseArray, 2130848650, "static://DefaultTeamWorkH5ShareDoc", paramInt);
  }
  
  public static Bitmap b(String paramString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      if (Build.VERSION.SDK_INT > 19) {}
      for (localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;; localOptions.inPreferredConfig = Bitmap.Config.ARGB_4444)
      {
        paramString = Base64.decode(paramString.split(",")[1], 0);
        return BitmapFactory.decodeByteArray(paramString, 0, paramString.length, localOptions);
      }
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
        com.tencent.qphone.base.util.QLog.d(i, 2, "Texture: cannot decode base64: " + com.tencent.qphone.base.util.QLog.getStackTraceString(paramString));
      }
    }
  }
  
  public static String b(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString))
    {
      str = "?m_readonly=1";
      if (paramString.contains("?")) {
        str = "&m_readonly=1";
      }
      str = paramString + str;
    }
    return str;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString1))
    {
      str = "?tdsourcetag=" + paramString2;
      if (paramString1.contains("?")) {
        str = "&tdsourcetag=" + paramString2;
      }
      str = paramString1 + str;
      ayhm.a(null, ayhm.c(paramString1), "0X8009EA0", paramString2, ayhm.d(paramString1), "");
      ayhm.a(i, "tdsourcetag", paramString2);
    }
    return str;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      com.tencent.qphone.base.util.QLog.i(ayed.i, 2, " onSetUserAuth  isSuccess = " + paramBoolean);
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramBoolean)
      {
        paramContext = paramQQAppInterface.a().a(localDocsGrayTipsInfo.jdField_a_of_type_JavaLangString, 0, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.a != null)) {
            paramArrayOfObject.tipParam.a.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      else
      {
        bcql.a(paramContext, str, 0).a();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(ayed.i, 1, " onSetUserAuth  exception  = " + paramQQAppInterface.toString());
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    bbkb.b(paramQQAppInterface.getApp(), paramQQAppInterface.c(), "tencent_docs_config_preload_tool_process", paramBoolean);
    paramQQAppInterface = (ayfg)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.jdField_b_of_type_Boolean = paramBoolean;
    }
  }
  
  private static void b(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    MessageForStructing localMessageForStructing;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.structingMsg != null) && (!TextUtils.isEmpty(localMessageForStructing.structingMsg.mMsgUrl))) {}
    }
    else
    {
      return;
    }
    if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
      com.tencent.qphone.base.util.QLog.d(ayed.i, 2, "tencentdoc also need insert into fm db");
    }
    msg_comm.Msg localMsg = new msg_comm.Msg();
    Object localObject1 = new msg_comm.MsgHead();
    localMsg.msg_head.set((MessageMicro)localObject1);
    ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_uid.set(localMessageForStructing.longMsgId);
    ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_time.set((int)localMessageForStructing.time);
    if ((localMessageForStructing.senderuin != null) && (localMessageForStructing.frienduin != null) && (localMessageForStructing.selfuin != null))
    {
      if (!localMessageForStructing.senderuin.equals(localMessageForStructing.frienduin)) {
        break label636;
      }
      ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
      ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.selfuin));
    }
    for (;;)
    {
      if (localMessageForStructing.istroop == 1)
      {
        localObject1 = new msg_comm.C2CTmpMsgHead();
        ((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.set((MessageMicro)localObject1);
        ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).service_type.set(1);
        ((msg_comm.C2CTmpMsgHead)((msg_comm.MsgHead)localMsg.msg_head.get()).c2c_tmp_msg_head.get()).group_code.set(Integer.parseInt(localMessageForStructing.frienduin));
      }
      ((msg_comm.MsgHead)localMsg.msg_head.get()).msg_seq.set((short)(int)localMessageForStructing.msgseq);
      localObject1 = new im_msg_body.NotOnlineFile();
      ((im_msg_body.NotOnlineFile)localObject1).uint32_file_type.set(0);
      ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(localMessageForStructing.structingMsg.mMsgUrl));
      ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.set(0L);
      ((im_msg_body.NotOnlineFile)localObject1).uint32_subcmd.set(1);
      Object localObject2;
      JSONObject localJSONObject;
      if ((localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
      {
        localObject2 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
        if (TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentCover)) {
          ((StructMsgForGeneralShare)localObject2).mContentCover = f(((StructMsgForGeneralShare)localObject2).mMsgUrl);
        }
        if (!TextUtils.isEmpty(((StructMsgForGeneralShare)localObject2).mContentTitle)) {
          ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentTitle));
        }
        localJSONObject = new JSONObject();
      }
      try
      {
        localJSONObject.put("structmsg_service_id", ((StructMsgForGeneralShare)localObject2).mMsgServiceID);
        localJSONObject.put("stuctmsg_bytes", Base64.encodeToString(((StructMsgForGeneralShare)localObject2).getBytes(), 0));
        localJSONObject.put("structmsg_uniseq", paramMessageRecord.uniseq);
        localJSONObject.put("accostType", ((StructMsgForGeneralShare)localObject2).sourceAccoutType);
        ((im_msg_body.NotOnlineFile)localObject1).bytes_note.set(ByteStringMicro.copyFromUtf8(((StructMsgForGeneralShare)localObject2).mContentCover));
        ((im_msg_body.NotOnlineFile)localObject1).bytes_pb_reserve.set(ByteStringMicro.copyFrom(localJSONObject.toString().getBytes()));
        paramMessageRecord = new ArrayList(paramQQAppInterface.a().b()).iterator();
        while (paramMessageRecord.hasNext())
        {
          localObject2 = (FileManagerEntity)paramMessageRecord.next();
          if ((((FileManagerEntity)localObject2).Uuid != null) && (((FileManagerEntity)localObject2).Uuid.equalsIgnoreCase(localMessageForStructing.structingMsg.mMsgUrl)))
          {
            ((FileManagerEntity)localObject2).srvTime = (localMessageForStructing.time * 1000L);
            ((FileManagerEntity)localObject2).bDelInFM = false;
            paramQQAppInterface.a().c((FileManagerEntity)localObject2);
            return;
            label636:
            ((msg_comm.MsgHead)localMsg.msg_head.get()).from_uin.set(Long.parseLong(localMessageForStructing.senderuin));
            ((msg_comm.MsgHead)localMsg.msg_head.get()).to_uin.set(Long.parseLong(localMessageForStructing.frienduin));
          }
        }
      }
      catch (JSONException paramMessageRecord)
      {
        for (;;)
        {
          if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
            com.tencent.qphone.base.util.QLog.e(ayed.i, 2, paramMessageRecord.getMessage());
          }
        }
        paramQQAppInterface.a().a(paramQQAppInterface.a(), new ArrayList(), localMsg, (im_msg_body.NotOnlineFile)localObject1, localMessageForStructing.frienduin, false, false, localMessageForStructing.vipBubbleID, localMessageForStructing.vipBubbleDiyTextId, null);
      }
    }
  }
  
  private static void b(String paramString, QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      try
      {
        paramString = ayfg.a(paramString, paramQQAppInterface.getCurrentAccountUin());
        if (paramString.getInt("retcode") == 0)
        {
          paramString = (String)((JSONObject)paramString.get("doc_meta")).get("title");
          if (!paramFileManagerEntity.fileName.equals(paramString))
          {
            paramFileManagerEntity.fileName = paramString;
            paramQQAppInterface.a().c(paramFileManagerEntity);
            return;
          }
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ayfg)paramQQAppInterface.a(122);
    if (paramQQAppInterface != null) {
      return paramQQAppInterface.jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1 = bool3;
    if (!TextUtils.isEmpty(paramString)) {
      if (!paramString.contains("docs.qq.com/form"))
      {
        bool1 = bool3;
        if (!paramString.contains("docx.qq.com/form")) {
          break label100;
        }
      }
    }
    try
    {
      paramString = new URL(paramString).getPath();
      if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals("/")) && (!paramString.equals("/index.html")) && (!paramString.equals("/mobile.html")))
      {
        bool3 = paramString.equals("/login.html");
        bool1 = bool2;
        if (!bool3) {}
      }
      else
      {
        bool1 = false;
      }
      label100:
      return bool1;
    }
    catch (Exception paramString)
    {
      com.tencent.qphone.base.util.QLog.e("docHome", 1, " detect docHome error: " + paramString.toString());
    }
    return true;
  }
  
  public static boolean b(String paramString1, String paramString2, long paramLong)
  {
    return a(ancl.a().jdField_a_of_type_JavaUtilMap, paramString1, paramString2, paramLong);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString;
    do
    {
      return paramString;
      arrayOfString = paramString.split("\\?");
    } while ((arrayOfString == null) || (arrayOfString.length <= 0));
    return arrayOfString[0];
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramQQAppInterface.getApp().getString(2131720151).equals(str))
      {
        paramContext = paramQQAppInterface.a().a(localDocsGrayTipsInfo.jdField_a_of_type_JavaLangString, 1, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.a != null)) {
            paramArrayOfObject.tipParam.a.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      for (;;)
      {
        com.tencent.qphone.base.util.QLog.i(i + ayed.i, 1, " onGetGroupAuth  isSuccess = " + paramBoolean + " tips =" + str);
        return;
        bcql.a(paramContext, str, 0).a();
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(i + ayed.i, 1, " onGetGroupAuth  exception = " + paramQQAppInterface.toString());
    }
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString)) {
      if ((!paramString.contains("docs.qq.com/doc/")) && (!paramString.contains("docs.qq.com/sheet/")) && (!paramString.contains("docs.qq.com/form/fill/")))
      {
        bool1 = bool2;
        if (!paramString.contains("docs.qq.com/form/edit/")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean c(String paramString1, String paramString2, long paramLong)
  {
    return a(anct.a().a(), paramString1, paramString2, paramLong);
  }
  
  public static String d(String paramString)
  {
    paramString = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]").matcher(paramString);
    if (paramString.find()) {
      return paramString.group(0);
    }
    return "";
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Context paramContext, MqqHandler paramMqqHandler, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    try
    {
      com.tencent.qphone.base.util.QLog.i(i + ayed.i, 1, " onSetGroupAuth  isSuccess = " + paramBoolean);
      DocsGrayTipsInfo localDocsGrayTipsInfo = (DocsGrayTipsInfo)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      long l = ((Long)paramArrayOfObject[2]).longValue();
      if (paramBoolean)
      {
        paramContext = paramQQAppInterface.a().a(localDocsGrayTipsInfo.jdField_a_of_type_JavaLangString, 1, l);
        if ((paramContext != null) && ((paramContext instanceof MessageForUniteGrayTip)))
        {
          paramArrayOfObject = (MessageForUniteGrayTip)paramContext;
          if ((paramArrayOfObject.tipParam != null) && (paramArrayOfObject.tipParam.a != null)) {
            paramArrayOfObject.tipParam.a.clear();
          }
          paramArrayOfObject.updateUniteGrayTipMsg(paramQQAppInterface, str);
          paramQQAppInterface = new Message();
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putLong("messageUniseq", paramContext.uniseq);
          paramQQAppInterface.setData(paramArrayOfObject);
          paramQQAppInterface.what = 78;
          paramQQAppInterface.arg1 = 0;
          paramMqqHandler.sendMessage(paramQQAppInterface);
        }
      }
      else
      {
        bcql.a(paramContext, str, 0).a();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      com.tencent.qphone.base.util.QLog.e(i + ayed.i, 1, " onSetGroupAuth  exception  = " + paramQQAppInterface.toString());
    }
  }
  
  public static boolean d(String paramString)
  {
    return (paramString.startsWith("data:image/jpg;base64,")) || (paramString.startsWith("data:image/png;base64,")) || (paramString.startsWith("data:image/jpeg;base64,")) || (paramString.startsWith("data:image/gif;base64,"));
  }
  
  public static boolean d(String paramString1, String paramString2, long paramLong)
  {
    return a(anbq.a().a(), paramString1, paramString2, paramLong);
  }
  
  public static String e(String paramString)
  {
    Object localObject1 = new SimpleDateFormat("yyyy-MM-dd");
    Object localObject2 = d(paramString);
    String str = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    localObject2 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
    localObject1 = ((SimpleDateFormat)localObject1).parse(str);
    if (((Date)localObject1).getTime() - ((Date)localObject2).getTime() == 0L) {
      return f;
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject2).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject2).getTime() <= 86400000L)) {
      return g;
    }
    if ((((Date)localObject1).getTime() - ((Date)localObject2).getTime() > 0L) && (((Date)localObject1).getTime() - ((Date)localObject2).getTime() <= 604800000L)) {
      return h;
    }
    localObject1 = paramString.substring(0, 4);
    paramString = paramString.substring(5, 7);
    return (String)localObject1 + ajya.a(2131714804) + paramString + ajya.a(2131714770);
  }
  
  public static String f(String paramString)
  {
    if (apej.b(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fd11abde219141a6f97e79c7fde6b71f.png";
    }
    if (apej.c(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/f15795a2b4c9a5f7668f10eb78d27499.png";
    }
    if (apej.e(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/ed532c207b5439a6c29ce241ad7decb7.png";
    }
    if (apej.d(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/fcbfa8f749abb54bf66b48e93c82b295.png";
    }
    if (apej.f(paramString)) {
      return "https://pub.idqqimg.com/pc/misc/files/20200116/90226039f41abf0e1f42e46a5350e364.png";
    }
    return "";
  }
  
  public static String g(String paramString)
  {
    if (apej.b(paramString)) {
      return String.valueOf(1);
    }
    if (apej.c(paramString)) {
      return String.valueOf(2);
    }
    if (apej.e(paramString)) {
      return String.valueOf(3);
    }
    if (apej.d(paramString)) {
      return String.valueOf(4);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayfx
 * JD-Core Version:    0.7.0.1
 */