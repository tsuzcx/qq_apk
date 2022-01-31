import android.text.TextUtils;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.pubaccount.PublicAccountJavascriptInterface;
import com.tencent.biz.tribe.TribeVideoPlugin;
import com.tencent.biz.webviewplugin.GamePartyPlugin;
import com.tencent.biz.webviewplugin.NewerGuidePlugin;
import com.tencent.biz.webviewplugin.PayJsPlugin;
import com.tencent.biz.webviewplugin.WeizhengquanJsPlugin;
import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import com.tencent.mobileqq.apollo.game.ApolloGamePlugin;
import com.tencent.mobileqq.confess.ConfessPlugin;
import com.tencent.mobileqq.jsp.AECameraPlugin;
import com.tencent.mobileqq.jsp.MediaApiPlugin;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mobileqq.jsp.WebRecordApiPlugin;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.nearby.NearbyJsInterface;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.vashealth.HealthBusinessPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ApolloJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.AvatarPendantUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.BuscardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatBackgroundUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ChatFontUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorRingUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ColorScreenJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.DailySignInWebviewPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.EmojiSubHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.FunnyPicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.HealthUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividualRedPacketJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.KingCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.PraiseJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ProfileDiyJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QLBQJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQAioBackgroundPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQCardJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQLevelJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QQReaderJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletMixJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.QWalletPayJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.RegLiangHaoJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SignJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.StarJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.SuitUIPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeAndBubbleCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipClubJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipComicJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunCallJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VipFunctionJsPlugin;
import com.tencent.mobileqq.vaswebviewplugin.WadlWebViewJsPlugin;
import com.tencent.mobileqq.webview.sonic.SonicJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import cooperation.qzone.music.QzoneWebMusicJsPlugin;
import cooperation.troop_homework.jsp.TroopHWJsPlugin;
import java.util.HashMap;

public class bbaf
{
  public static final HashMap<String, Integer> a = new HashMap();
  
  static
  {
    a.put("qbizApi", Integer.valueOf(3));
    a.put("coupon", Integer.valueOf(1));
    a.put("eqq", Integer.valueOf(2));
    a.put("lebaPlugin", Integer.valueOf(4));
    a.put("PublicAccountJs", Integer.valueOf(6));
    a.put("publicAccountNew", Integer.valueOf(7));
    a.put("TroopMemberApiPlugin", Integer.valueOf(8));
    a.put("gameTeam", Integer.valueOf(10));
    a.put("redEnvelope", Integer.valueOf(12));
    a.put("hotchat", Integer.valueOf(13));
    a.put("NearbyTroopsPlugin", Integer.valueOf(14));
    a.put("newerguide", Integer.valueOf(15));
    a.put("offline", Integer.valueOf(16));
    a.put("openToAppDetail", Integer.valueOf(17));
    a.put(xcn.class.getSimpleName(), Integer.valueOf(20));
    a.put("mail", Integer.valueOf(21));
    a.put(xdh.a, Integer.valueOf(22));
    a.put("qztodayinhistory", Integer.valueOf(23));
    a.put("QzoneData", Integer.valueOf(24));
    a.put(xdn.a, Integer.valueOf(25));
    a.put("share", Integer.valueOf(26));
    a.put("UrlSaveVerifyV2", Integer.valueOf(171));
    a.put("troop_member_level_JS_API", Integer.valueOf(30));
    a.put("URL_CHECK", Integer.valueOf(31));
    a.put("WebSo", Integer.valueOf(32));
    a.put("QQConnect", Integer.valueOf(33));
    a.put("GCApi", Integer.valueOf(34));
    a.put("specialRing", Integer.valueOf(35));
    a.put("InputClickEvent", Integer.valueOf(36));
    a.put("data", Integer.valueOf(38));
    a.put("x5", Integer.valueOf(166));
    a.put("device", Integer.valueOf(39));
    a.put("event", Integer.valueOf(40));
    a.put("media", Integer.valueOf(41));
    a.put("QQApi", Integer.valueOf(42));
    a.put("sms", Integer.valueOf(43));
    a.put("troopApi", Integer.valueOf(44));
    a.put("ui", Integer.valueOf(45));
    a.put("docx", Integer.valueOf(134));
    a.put("webRecord", Integer.valueOf(46));
    a.put("qqmusic", Integer.valueOf(47));
    a.put("odapp", Integer.valueOf(49));
    a.put("huayang", Integer.valueOf(128));
    a.put("huiyin", Integer.valueOf(178));
    a.put("card", Integer.valueOf(50));
    a.put("usersummary", Integer.valueOf(131));
    a.put("signIn", Integer.valueOf(138));
    a.put("RealName", Integer.valueOf(95));
    a.put("newLogin", Integer.valueOf(174));
    a.put("redpoint", Integer.valueOf(52));
    a.put("REMIND", Integer.valueOf(53));
    a.put("calendar", Integer.valueOf(53));
    a.put("ptv", Integer.valueOf(54));
    a.put("troopAssistantFeeds", Integer.valueOf(57));
    a.put("troopNotice", Integer.valueOf(58));
    a.put("healthSport", Integer.valueOf(59));
    a.put("healthkit", Integer.valueOf(60));
    a.put("healthpathtrace", Integer.valueOf(127));
    a.put("apollo", Integer.valueOf(61));
    a.put("faceAddon", Integer.valueOf(62));
    a.put("bubble", Integer.valueOf(64));
    a.put("colorScreen", Integer.valueOf(154));
    a.put("face", Integer.valueOf(159));
    a.put("praise", Integer.valueOf(141));
    a.put("diycard", Integer.valueOf(148));
    a.put("chatBg", Integer.valueOf(66));
    a.put("font", Integer.valueOf(68));
    a.put("colorRing", Integer.valueOf(70));
    a.put("emoji", Integer.valueOf(73));
    a.put("qutu", Integer.valueOf(77));
    a.put("individualRedPacket", Integer.valueOf(79));
    a.put("individuation", Integer.valueOf(80));
    a.put("msgRoam", Integer.valueOf(82));
    a.put("SetPwdJsInterface", Integer.valueOf(83));
    a.put("EquipLockManager", Integer.valueOf(83));
    a.put("CAPTCHA", Integer.valueOf(83));
    a.put("qqcard", Integer.valueOf(85));
    a.put("qw_bluetooth", Integer.valueOf(156));
    a.put("qw_charge", Integer.valueOf(88));
    a.put("qw.pay", Integer.valueOf(89));
    a.put("qw_pay", Integer.valueOf(186));
    a.put("qw_mix", Integer.valueOf(188));
    a.put("cj", Integer.valueOf(198));
    a.put("starclub", Integer.valueOf(90));
    a.put("common", Integer.valueOf(92));
    a.put("theme", Integer.valueOf(93));
    a.put("qw_debug", Integer.valueOf(96));
    a.put("qw_data", Integer.valueOf(96));
    a.put("friendData", Integer.valueOf(96));
    a.put("debug", Integer.valueOf(97));
    a.put("ppreloader", Integer.valueOf(100));
    a.put("funCall", Integer.valueOf(101));
    a.put("QQVIPFunction", Integer.valueOf(102));
    a.put("video", Integer.valueOf(103));
    a.put("gift", Integer.valueOf(104));
    a.put(bbey.a, Integer.valueOf(106));
    a.put("comicFavor", Integer.valueOf(108));
    a.put("QzMusic", Integer.valueOf(111));
    a.put("Qzone", Integer.valueOf(112));
    a.put("qzDynamicAlbum", Integer.valueOf(112));
    a.put("QZImagePicker", Integer.valueOf(112));
    a.put("checkin", Integer.valueOf(112));
    a.put("qzlive", Integer.valueOf(112));
    a.put("qqexplive", Integer.valueOf(112));
    a.put("qzui", Integer.valueOf(112));
    a.put("QzoneUpload", Integer.valueOf(112));
    a.put("QzoneAudio", Integer.valueOf(112));
    a.put(bgkh.a, Integer.valueOf(113));
    a.put("QzMoodSelectPicture", Integer.valueOf(114));
    a.put("QzCover", Integer.valueOf(115));
    a.put("qzcardstorre", Integer.valueOf(116));
    a.put("QzAvatar", Integer.valueOf(116));
    a.put("QzFloat", Integer.valueOf(116));
    a.put("story", Integer.valueOf(121));
    a.put("homework", Integer.valueOf(117));
    a.put("publicAccount", Integer.valueOf(5));
    a.put("pay", Integer.valueOf(19));
    a.put("qw", Integer.valueOf(157));
    a.put(String.valueOf(2L), Integer.valueOf(72));
    a.put(String.valueOf(8L), Integer.valueOf(75));
    a.put(String.valueOf(512L), Integer.valueOf(63));
    a.put(String.valueOf(4096L), Integer.valueOf(69));
    a.put(String.valueOf(1048576L), Integer.valueOf(81));
    a.put(String.valueOf(65536L), Integer.valueOf(78));
    a.put(String.valueOf(262144L), Integer.valueOf(91));
    a.put(String.valueOf(33554432L), Integer.valueOf(67));
    a.put(String.valueOf(64L), Integer.valueOf(65));
    a.put(String.valueOf(32L), Integer.valueOf(94));
    a.put(String.valueOf(4L), Integer.valueOf(74));
    a.put(String.valueOf(4194304L), Integer.valueOf(71));
    a.put("Troop", Integer.valueOf(55));
    a.put("deviceapp", Integer.valueOf(118));
    a.put("qqreader", Integer.valueOf(119));
    a.put("sso", Integer.valueOf(29));
    a.put("nfc", Integer.valueOf(120));
    a.put("gdtReportPlugin", Integer.valueOf(122));
    a.put("pubAccountPreload", Integer.valueOf(125));
    a.put("medalwall", Integer.valueOf(124));
    a.put("pubAccountUI", Integer.valueOf(129));
    a.put("nearby", Integer.valueOf(126));
    a.put("sensor", Integer.valueOf(150));
    a.put("arcard", Integer.valueOf(164));
    a.put("sonic", Integer.valueOf(132));
    a.put("SwiftHttp", Integer.valueOf(132));
    a.put("Weiyun", Integer.valueOf(135));
    a.put("JD_REPORT", Integer.valueOf(133));
    a.put("readinjoy", Integer.valueOf(136));
    a.put("babyQ", Integer.valueOf(137));
    a.put("historyhead", Integer.valueOf(139));
    a.put("wadl_download", Integer.valueOf(140));
    a.put("comic", Integer.valueOf(142));
    a.put("campus_circle", Integer.valueOf(143));
    a.put("groupVideo", Integer.valueOf(144));
    a.put("qq_gdt_ad", Integer.valueOf(145));
    a.put("qq_imax_ad", Integer.valueOf(176));
    a.put("SocialWeekly", Integer.valueOf(146));
    a.put("msgForward", Integer.valueOf(147));
    a.put("profileJS", Integer.valueOf(149));
    a.put("nowlive", Integer.valueOf(152));
    a.put("sign", Integer.valueOf(151));
    a.put("localData", Integer.valueOf(153));
    a.put("qidian", Integer.valueOf(155));
    a.put("allpeoplevote", Integer.valueOf(158));
    a.put("ftssearch", Integer.valueOf(160));
    a.put("MixSearchWeb", Integer.valueOf(169));
    a.put("qlbq", Integer.valueOf(161));
    a.put("sayHonest", Integer.valueOf(162));
    a.put("readInJoyWebRender", Integer.valueOf(163));
    a.put("tribeVideoPlayer", Integer.valueOf(165));
    a.put("apolloGame", Integer.valueOf(167));
    a.put("GdtWebReportPlugin", Integer.valueOf(170));
    a.put("bless", Integer.valueOf(172));
    a.put("haomaReg", Integer.valueOf(173));
    a.put("extendFriend", Integer.valueOf(175));
    a.put("identification", Integer.valueOf(177));
    a.put("location", Integer.valueOf(179));
    a.put("accountRelease", Integer.valueOf(180));
    a.put("miniApp", Integer.valueOf(181));
    a.put("Gdt", Integer.valueOf(182));
    a.put("ReadinjoyAdJs", Integer.valueOf(183));
    a.put("profie_edit", Integer.valueOf(184));
    a.put("jubao", Integer.valueOf(185));
    a.put("emoticon", Integer.valueOf(190));
    a.put("addContact_SecCheck", Integer.valueOf(187));
    a.put("robotsummary", Integer.valueOf(191));
    a.put("gflivesdk", Integer.valueOf(192));
    a.put("qsubscribe", Integer.valueOf(189));
    a.put("userVerify", Integer.valueOf(385));
    a.put("friendApi", Integer.valueOf(193));
    a.put("kingCard", Integer.valueOf(194));
    a.put("vipclub", Integer.valueOf(200));
    a.put("emojiEggSetting", Integer.valueOf(195));
    a.put("interactionScore", Integer.valueOf(195));
    a.put("listenTogether", Integer.valueOf(196));
    a.put("floatingWindow", Integer.valueOf(197));
    a.put("connect", Integer.valueOf(203));
    a.put("push", Integer.valueOf(204));
    a.put("faceUnblockCamera", Integer.valueOf(199));
    a.put("levelicon", Integer.valueOf(201));
    a.put("background", Integer.valueOf(202));
    a.put("aioShareMusic", Integer.valueOf(208));
    a.put(aqab.a, Integer.valueOf(205));
    a.put("together_business", Integer.valueOf(206));
    a.put("JSRoot", Integer.valueOf(207));
    a.put("JSToast", Integer.valueOf(207));
    a.put("JSBookDir", Integer.valueOf(207));
    a.put("JSPublicAccount", Integer.valueOf(207));
    a.put("JSTopRightButton", Integer.valueOf(207));
    a.put("JSTittlebarAction", Integer.valueOf(207));
    a.put("JSPay", Integer.valueOf(207));
    a.put("JSPublicAccountUtil", Integer.valueOf(207));
    a.put("JSRedTouch", Integer.valueOf(207));
    a.put("JSBookDetailForQQ", Integer.valueOf(207));
    a.put("JSbookshelf", Integer.valueOf(207));
    a.put("JSContent", Integer.valueOf(207));
    a.put("readonline", Integer.valueOf(207));
    a.put("JSPopupList", Integer.valueOf(207));
    a.put("JSTypeface", Integer.valueOf(207));
    a.put("aecamera", Integer.valueOf(209));
    a.put("historicalSig", Integer.valueOf(210));
  }
  
  public static WebViewPlugin a(int paramInt)
  {
    switch (paramInt)
    {
    case 9: 
    case 11: 
    case 16: 
    case 18: 
    case 20: 
    case 22: 
    case 25: 
    case 27: 
    case 28: 
    case 36: 
    case 37: 
    case 40: 
    case 48: 
    case 51: 
    case 76: 
    case 84: 
    case 86: 
    case 87: 
    case 97: 
    case 98: 
    case 99: 
    case 105: 
    case 107: 
    case 109: 
    case 110: 
    case 118: 
    case 123: 
    case 130: 
    case 168: 
    case 171: 
    case 211: 
    case 212: 
    case 213: 
    case 214: 
    case 215: 
    case 216: 
    case 217: 
    case 218: 
    case 219: 
    case 220: 
    case 221: 
    case 222: 
    case 223: 
    case 224: 
    case 225: 
    case 226: 
    case 227: 
    case 228: 
    case 229: 
    case 230: 
    case 231: 
    case 232: 
    case 233: 
    case 234: 
    case 235: 
    case 236: 
    case 237: 
    case 238: 
    case 239: 
    case 240: 
    case 241: 
    case 242: 
    case 243: 
    case 244: 
    case 245: 
    case 246: 
    case 247: 
    case 248: 
    case 249: 
    case 250: 
    case 251: 
    case 252: 
    case 253: 
    case 254: 
    case 255: 
    case 256: 
    case 257: 
    case 258: 
    case 259: 
    case 260: 
    case 261: 
    case 262: 
    case 263: 
    case 264: 
    case 265: 
    case 266: 
    case 267: 
    case 268: 
    case 269: 
    case 270: 
    case 271: 
    case 272: 
    case 273: 
    case 274: 
    case 275: 
    case 276: 
    case 277: 
    case 278: 
    case 279: 
    case 280: 
    case 281: 
    case 282: 
    case 283: 
    case 284: 
    case 285: 
    case 286: 
    case 287: 
    case 288: 
    case 289: 
    case 290: 
    case 291: 
    case 292: 
    case 293: 
    case 294: 
    case 295: 
    case 296: 
    case 297: 
    case 298: 
    case 299: 
    case 300: 
    case 301: 
    case 302: 
    case 303: 
    case 304: 
    case 305: 
    case 306: 
    case 307: 
    case 308: 
    case 309: 
    case 310: 
    case 311: 
    case 312: 
    case 313: 
    case 314: 
    case 315: 
    case 316: 
    case 317: 
    case 318: 
    case 319: 
    case 320: 
    case 321: 
    case 322: 
    case 323: 
    case 324: 
    case 325: 
    case 326: 
    case 327: 
    case 328: 
    case 329: 
    case 330: 
    case 331: 
    case 332: 
    case 333: 
    case 334: 
    case 335: 
    case 336: 
    case 337: 
    case 338: 
    case 339: 
    case 340: 
    case 341: 
    case 342: 
    case 343: 
    case 344: 
    case 345: 
    case 346: 
    case 347: 
    case 348: 
    case 349: 
    case 350: 
    case 351: 
    case 352: 
    case 353: 
    case 354: 
    case 355: 
    case 356: 
    case 357: 
    case 358: 
    case 359: 
    case 360: 
    case 361: 
    case 362: 
    case 363: 
    case 364: 
    case 365: 
    case 366: 
    case 367: 
    case 368: 
    case 369: 
    case 370: 
    case 371: 
    case 372: 
    case 373: 
    case 374: 
    case 375: 
    case 376: 
    case 377: 
    case 378: 
    case 379: 
    case 380: 
    case 381: 
    case 382: 
    case 383: 
    case 384: 
    default: 
      return null;
    case 61: 
      return new ApolloJsPlugin();
    case 170: 
      return new ysq();
    case 62: 
      return new AvatarPendantJsPlugin();
    case 63: 
      return new AvatarPendantUiPlugin();
    case 64: 
      return new BubbleJsPlugin();
    case 154: 
      return new ColorScreenJsPlugin();
    case 159: 
      return new baql();
    case 65: 
      return new BubbleUiPlugin();
    case 141: 
      return new PraiseJsPlugin();
    case 66: 
      return new ChatBackgroundJsPlugin();
    case 67: 
      return new ChatBackgroundUiPlugin();
    case 68: 
      return new ChatFontJsPlugin();
    case 69: 
      return new ChatFontUiPlugin();
    case 70: 
      return new ColorRingJsPlugin();
    case 71: 
      return new ColorRingUIPlugin();
    case 1: 
      return new mpy();
    case 38: 
      return new aqrl();
    case 166: 
      return new aquh();
    case 121: 
      return new aqsl();
    case 39: 
      return new aqro();
    case 72: 
      return new EmojiHomeUiPlugin();
    case 73: 
      return new EmojiJsPlugin();
    case 74: 
      return new EmojiSubHomeUiPlugin();
    case 75: 
      return new baso();
    case 2: 
      return new mqf();
    case 77: 
      return new FunnyPicJsPlugin();
    case 34: 
      return new GameCenterAPIJavaScript();
    case 10: 
      return new GamePartyPlugin();
    case 12: 
      return new xbb();
    case 59: 
      return new HealthBusinessPlugin();
    case 60: 
      return new barr();
    case 127: 
      return new barq();
    case 78: 
      return new HealthUiPlugin();
    case 13: 
      return new xbe();
    case 79: 
      return new IndividualRedPacketJsPlugin();
    case 80: 
      return new IndividuationPlugin();
    case 81: 
      return new basp();
    case 4: 
      return new mro();
    case 83: 
      return new MQPSecJsPlugin();
    case 41: 
      return new MediaApiPlugin();
    case 82: 
      return new MessageRoamJsPlugin();
    case 47: 
      return new asaa();
    case 135: 
      return new bgtx();
    case 14: 
      return new xbo();
    case 15: 
      return new NewerGuidePlugin();
    case 49: 
      return new aqpm();
    case 128: 
      return new aqlr();
    case 178: 
      return new aqmw();
    case 95: 
      return new auos();
    case 174: 
      return new aeut();
    case 17: 
      return new xcm();
    case 19: 
      return new PayJsPlugin();
    case 157: 
      return new WeizhengquanJsPlugin();
    case 50: 
      return new atxg();
    case 131: 
      return new atxo();
    case 191: 
      return new xed();
    case 138: 
      return new DailySignInWebviewPlugin();
    case 21: 
      return new xco();
    case 7: 
      return new rsv();
    case 5: 
      return new PublicAccountJavascriptInterface();
    case 6: 
      return new ndx();
    case 42: 
      return new aqsg();
    case 85: 
      return new QQCardJsPlugin();
    case 33: 
      return new ydp();
    case 156: 
      return new QWalletBluetoothJsPlugin();
    case 88: 
      return new QWalletCommonJsPlugin();
    case 89: 
      return new QWalletPayJsPlugin();
    case 188: 
      return new QWalletMixJsPlugin();
    case 186: 
      return new basq();
    case 115: 
      return new bgkn();
    case 113: 
      return new bgkh();
    case 116: 
      return new bgkw();
    case 23: 
      return new xdg();
    case 112: 
      return new bgij();
    case 114: 
      return new bgkl();
    case 111: 
      return new QzoneWebMusicJsPlugin();
    case 24: 
      return new xdi();
    case 52: 
      return new RedTouchWebviewHandler();
    case 53: 
      return new aura();
    case 29: 
      return new xdo();
    case 3: 
      return new SensorAPIJavaScript();
    case 26: 
      return new xdz();
    case 54: 
      return new awmf();
    case 43: 
      return new aqso();
    case 90: 
      return new StarJsPlugin();
    case 91: 
      return new SuitUIPlugin();
    case 92: 
      return new ThemeAndBubbleCommonJsPlugin();
    case 93: 
      return new ThemeJsPlugin();
    case 94: 
      return new ThemeUiPlugin();
    case 44: 
      return new aqst();
    case 57: 
      return new azcl();
    case 117: 
      return new TroopHWJsPlugin();
    case 8: 
      return new wiw();
    case 30: 
      return new xec();
    case 58: 
      return new azcm();
    case 55: 
      return new ayji();
    case 45: 
      return new UiApiPlugin();
    case 134: 
      return new aqrp();
    case 31: 
      return new xee();
    case 96: 
      return new VasCommonJsPlugin();
    case 108: 
      return new bezs();
    case 100: 
      return new VipComicJsPlugin();
    case 101: 
      return new VipFunCallJsPlugin();
    case 102: 
      return new VipFunctionJsPlugin();
    case 104: 
      return new bawq();
    case 35: 
      return new ahxk();
    case 56: 
      return new ayjn();
    case 103: 
      return new basx();
    case 46: 
      return new WebRecordApiPlugin();
    case 32: 
      return new xeh();
    case 106: 
      return new bbey();
    case 119: 
      return new QQReaderJsPlugin();
    case 120: 
      return new BuscardJsPlugin();
    case 122: 
      return new bghh();
    case 124: 
      return new aqrz();
    case 125: 
      return new xcu();
    case 129: 
      return new xcv();
    case 126: 
      return new NearbyJsInterface();
    case 150: 
      return new xaw();
    case 164: 
      return new xav();
    case 132: 
      return new SonicJsPlugin();
    case 133: 
      return new xaz();
    case 136: 
      return new org();
    case 137: 
      return new ajef();
    case 139: 
      return new atuy();
    case 140: 
      return new WadlWebViewJsPlugin();
    case 142: 
      return new bfab();
    case 143: 
      return new alrj();
    case 144: 
      return new aqks();
    case 145: 
      return new ymw();
    case 176: 
      return new aqiz();
    case 146: 
      return new bbef();
    case 147: 
      return new arsp();
    case 149: 
      return new atuz();
    case 148: 
      return new ProfileDiyJsPlugin();
    case 152: 
      return new aqnz();
    case 151: 
      return new SignJsPlugin();
    case 153: 
      return new LocalDataJsPlugin();
    case 155: 
      return new bcre();
    case 158: 
      return new bbfw();
    case 160: 
      return new aquc();
    case 169: 
      return new aqsd();
    case 161: 
      return new QLBQJsPlugin();
    case 162: 
      return new ConfessPlugin();
    case 163: 
      return new xdm();
    case 165: 
      return new TribeVideoPlugin();
    case 167: 
      return new ApolloGamePlugin();
    case 172: 
      return new aeqa();
    case 173: 
      return new RegLiangHaoJsPlugin();
    case 175: 
      return new anoq();
    case 177: 
      return new aqrw();
    case 179: 
      return new xbl();
    case 180: 
      return new xay();
    case 181: 
      return new MiniAppPlugin();
    case 182: 
      return new aqsr();
    case 183: 
      return new noq();
    case 184: 
      return new atxk();
    case 185: 
      return new aquj();
    case 190: 
      return new annc();
    case 189: 
      return new vvv();
    case 187: 
      return new aesb();
    case 192: 
      return new aqrx();
    case 385: 
      return new xds();
    case 193: 
      return new aqrv();
    case 194: 
      return new KingCardJsPlugin();
    case 200: 
      return new VipClubJsPlugin();
    case 195: 
      return new aqqq();
    case 196: 
      return new aqvq();
    case 197: 
      return new bbqm();
    case 203: 
      return new aqrj();
    case 204: 
      return new aqse();
    case 198: 
      return new agvf();
    case 199: 
      return new afjt();
    case 201: 
      return new QQLevelJsPlugin();
    case 202: 
      return new QQAioBackgroundPlugin();
    case 210: 
      return new avco();
    case 208: 
      return new krr();
    case 206: 
      return new aqqc();
    case 205: 
      return new aqab();
    case 207: 
      return new bfmb();
    }
    return new AECameraPlugin();
  }
  
  public static WebViewPlugin a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (a.containsKey(paramString))) {
      return a(((Integer)a.get(paramString)).intValue());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbaf
 * JD-Core Version:    0.7.0.1
 */