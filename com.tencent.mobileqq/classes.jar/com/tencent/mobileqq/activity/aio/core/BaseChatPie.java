package com.tencent.mobileqq.activity.aio.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.FontManager;
import com.etrump.mixlayout.VasShieldFont;
import com.immersion.stickersampleapp.HapticManager;
import com.rookery.translate.AITranslator;
import com.tencent.av.audio.AudioSettingManager;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.devicelib.DeviceLib;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.MessageNotifyParam;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.abtest.ABTestController;
import com.tencent.mobileqq.abtest.ExpEntityInfo;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityConstants;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.OnChatMessageCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager;
import com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel;
import com.tencent.mobileqq.activity.aio.core.msglist.BaseMsgLoader;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListBuilder;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgListRefresher;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.coreui.msglist.Scroller;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic;
import com.tencent.mobileqq.activity.aio.drawer.BaseChatDrawer;
import com.tencent.mobileqq.activity.aio.helper.AIODtReportHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOEmoticonGuideHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOMultiActionHelper;
import com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper;
import com.tencent.mobileqq.activity.aio.helper.DecodeAIOInputBitmapHeightTask;
import com.tencent.mobileqq.activity.aio.helper.FastImageHelper;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;
import com.tencent.mobileqq.activity.aio.helper.HelperProvider;
import com.tencent.mobileqq.activity.aio.helper.HiBoomHelper;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.helper.IceBreakHelper;
import com.tencent.mobileqq.activity.aio.helper.MultiFavoriteHelper;
import com.tencent.mobileqq.activity.aio.helper.MultiForwardHelper;
import com.tencent.mobileqq.activity.aio.helper.PhotoListHelper;
import com.tencent.mobileqq.activity.aio.helper.QEffectBgProvider;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.activity.aio.helper.SelectToBottomHelper;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.SpecWordEmotionThinkHelper;
import com.tencent.mobileqq.activity.aio.helper.StickerRecHelper;
import com.tencent.mobileqq.activity.aio.helper.TempMsgBoxAIOHelper;
import com.tencent.mobileqq.activity.aio.helper.UnreadBackBottomHelper;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.LongMsgItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.MixedMsgItemBuilder.MixedHolder;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.activity.aio.item.TextItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.panel.AIOFakePanel;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.qwallet.ScrollPlayer;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper;
import com.tencent.mobileqq.activity.aio.rebuild.BaseChatpieHelper.IMECommandListener;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.msglist.PAListUI;
import com.tencent.mobileqq.activity.aio.reply.ReplyMsgUtils;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.activity.aio.tips.C2BTipsBar;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.LocationShareTipsBar;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TimTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.activity.miniaio.IChatWindow;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.activity.selectable.AIOSelectableDelegateProxy;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.IApolloResponseManager;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.item.IApolloItemBuilder.Holder;
import com.tencent.mobileqq.apollo.api.aio.item.IApolloItemBuilderHelper;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.api.handler.IApolloExtensionObserver;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteActionScript;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.apollo.api.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.api.script.ISpriteUtil;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnBottomOverScrollListener;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.business.qvip.QVipGiftConfig;
import com.tencent.mobileqq.config.business.qvip.QVipGiftProcessor;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.doutu.DoutuEmotionAdapter;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.doutu.combo.ComboUIManager;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.RichTextChatManager;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.haoliyou.orion.ChatPieInputHelper;
import com.tencent.mobileqq.hiboom.FontBubbleManager.FontBubbleObserver;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.hiboom.HiBoomManager.HiBoomAuthObserver;
import com.tencent.mobileqq.hiboom.HiBoomManager.HiBoomForwardAuthObserver;
import com.tencent.mobileqq.hiboom.RichTextPanel;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.mobileqq.jubao.JubaoHelper;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.mutualmark.oldlogic.HotReactiveHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.OldMutualMarkLogicHelper;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.ptt.PttSSCMPool;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.relationx.onewayfriend.OneWayFriendHelper;
import com.tencent.mobileqq.replymsg.ForwardMsgManager;
import com.tencent.mobileqq.replymsg.ReplyMsgSender;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.richstatus.sign.AIOSignViewHolder;
import com.tencent.mobileqq.richstatus.topic.TopicReplyUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.AIOShortVideoUtil;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.troop.data.SelfGagInfo;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyClickMovementMethod;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.SystemDragUtils;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.PlayModeUtils;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.GiftJsPlugin;
import com.tencent.mobileqq.webview.UrlSecurityCheckManager;
import com.tencent.mobileqq.widget.CommonImageView;
import com.tencent.mobileqq.widget.CommonTextView;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.DrawerFrame;
import com.tencent.mobileqq.widget.MosaicEffect;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QqViewFlipper;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.qqperf.opt.threadpriority.ThreadPriorityManager;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.theme.SkinEngine;
import com.tencent.util.InputMethodUtil;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.OnChangeMultiScreenListener;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.SystemBarCompact;
import common.config.service.QzoneConfig;
import cooperation.comic.VipComicReportUtils;
import cooperation.peak.PeakUtils;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqindividuality.QQIndividualityUtils;
import cooperation.weiyun.ResponseHandler;
import cooperation.weiyun.WeiyunSaveTipsFactory;
import dov.com.qq.im.QIMShortVideoUtils;
import dov.com.qq.im.ae.SessionWrap;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.perf.AELaunchRecorder;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class BaseChatPie
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, BaseChatItemLayout.OnChatMessageCheckedChangeListener, MediaPlayerManager.Listener, PanelIconLinearLayout.PanelIconCallback, IChatWindow, CheckPttListener, CheckPtvListener, ChatXListView.OnBottomOverScrollListener, INetInfoHandler, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, AbsListView.RecyclerListener, XPanelContainer.OnChangeMultiScreenListener, XPanelContainer.PanelCallback, Observer
{
  public static boolean M;
  public static int j;
  private static int jdField_t_of_type_Int = 0;
  private static int z;
  public static boolean z;
  private int A;
  public boolean A;
  public boolean B = false;
  public boolean C = false;
  public boolean D;
  public boolean E = false;
  public boolean F;
  public boolean G;
  protected boolean H = true;
  public boolean I = false;
  public boolean J = false;
  public boolean K;
  public boolean L;
  private boolean N = true;
  private boolean O = false;
  private boolean P = false;
  private boolean Q = false;
  private boolean R = true;
  private boolean S = false;
  private boolean T;
  private boolean U;
  private boolean V = false;
  private boolean W = false;
  private boolean X = false;
  private boolean Y = false;
  private boolean Z = true;
  protected float a;
  protected int a;
  protected long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new BaseChatPie.26(this);
  public Context a;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  public FragmentActivity a;
  private MovementMethod jdField_a_of_type_AndroidTextMethodMovementMethod = null;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View.OnClickListener a;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  protected View a;
  public ViewGroup a;
  protected ViewStub a;
  public FrameLayout a;
  public ImageButton a;
  protected ImageView a;
  protected LinearLayout a;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout a;
  protected TextView a;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver = null;
  public AIOGiftPanelContainer a;
  public AIOTipsController a;
  public ChatAdapter1 a;
  public InputLinearLayout a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public SessionInfo a;
  public AIOAnimationConatiner a;
  public AIOFooterViewDetector a;
  protected AudioPanel a;
  protected final AIOContext a;
  public final MsgList a;
  protected DoodlePanel a;
  public BaseChatDrawer a;
  public HelperProvider a;
  final StructingMsgItemBuilder.ViewCache jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = new StructingMsgItemBuilder.ViewCache();
  protected AIOFakePanel a;
  public PanelIconLinearLayout a;
  public PanelManager a;
  protected PhotoListPanel a;
  private BaseChatpieHelper.IMECommandListener jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper$IMECommandListener;
  protected BaseChatpieHelper a;
  private StickerBubbleTouchDelegate jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  protected ArkTipsBar a;
  protected C2BTipsBar a;
  protected FraudTipsBar a;
  protected LightalkBlueTipsBar a;
  protected LocationShareTipsBar a;
  protected QQOperateTips a;
  protected TimTipsBar a;
  protected TipsManager a;
  protected VideoStatusTipsBar a;
  protected VipFunCallTipsBar a;
  protected VoiceTextPanel a;
  public ChatPieApolloViewController a;
  IApolloExtensionObserver jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver = new BaseChatPie.58(this);
  public ApolloInfo a;
  public ChatApolloViewListener a;
  public InputGlobalLayoutListener a;
  public ApolloPanel a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new BaseChatPie.56(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new BaseChatPie.55(this);
  protected FriendListHandler a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new BaseChatPie.51(this);
  public QQAppInterface a;
  public QQMapActivityProxy a;
  private ShortVideoObserver jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver = new BaseChatPie.59(this);
  public ArkRecommendController a;
  public ChatXListView a;
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  public MessageForReplyText.SourceMsgInfo a;
  private NoC2CExtensionInfo jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
  private DoutuManager jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager;
  public ComboUIManager a;
  FontBubbleManager.FontBubbleObserver jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver;
  HiBoomManager.HiBoomAuthObserver jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomAuthObserver;
  HiBoomManager.HiBoomForwardAuthObserver jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomForwardAuthObserver;
  RichTextPanel jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
  public HotPicMainPanel a;
  private MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private final ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new BaseChatPie.57(this);
  public TroopAioTips a;
  protected TroopGiftAnimationController a;
  public QQCustomDialog a;
  protected QQRecorder a;
  public DrawerFrame a;
  public QQBlurView a;
  public QQProgressDialog a;
  public QqViewFlipper a;
  public ToastStyleDialog a;
  public NavBarAIO a;
  public PatchedButton a;
  public XEditTextEx a;
  public XPanelContainer a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  protected CharSequence a;
  Runnable jdField_a_of_type_JavaLangRunnable = new BaseChatPie.30(this);
  protected List<QQOperationViopTipTask> a;
  public AtomicBoolean a;
  public final MqqHandler a;
  private boolean aa = false;
  int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  public Dialog b;
  protected View b;
  public ViewGroup b;
  protected ImageView b;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  protected RelativeLayout b;
  public TextView b;
  public QQProgressDialog b;
  private ToastStyleDialog jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  private Runnable jdField_b_of_type_JavaLangRunnable;
  public String b;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  protected View c;
  public ViewGroup c;
  protected ImageView c;
  protected RelativeLayout c;
  public TextView c;
  public QQProgressDialog c;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  protected String c;
  protected boolean c;
  protected int d;
  public View d;
  public ViewGroup d;
  public ImageView d;
  protected RelativeLayout d;
  protected TextView d;
  private Runnable d;
  public String d;
  protected boolean d;
  public int e;
  protected View e;
  public ImageView e;
  public TextView e;
  protected String e;
  protected boolean e;
  protected int f;
  public View f;
  public ImageView f;
  public TextView f;
  public boolean f;
  protected int g;
  public View g;
  public ImageView g;
  public TextView g;
  protected boolean g;
  protected int h;
  public View h;
  protected ImageView h;
  protected TextView h;
  protected boolean h;
  public int i;
  protected View i;
  protected ImageView i;
  protected TextView i;
  public boolean i;
  protected View j;
  protected ImageView j;
  public TextView j;
  public boolean j;
  private int k;
  protected View k;
  public ImageView k;
  protected TextView k;
  public boolean k;
  private int jdField_l_of_type_Int = 0;
  protected View l;
  private ImageView jdField_l_of_type_AndroidWidgetImageView;
  private TextView jdField_l_of_type_AndroidWidgetTextView;
  boolean jdField_l_of_type_Boolean = false;
  private int jdField_m_of_type_Int = 1;
  private View jdField_m_of_type_AndroidViewView;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int = 0;
  private View jdField_n_of_type_AndroidViewView;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  public boolean n;
  private int jdField_o_of_type_Int = 0;
  private View jdField_o_of_type_AndroidViewView;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  protected boolean o;
  private int jdField_p_of_type_Int = 0;
  boolean jdField_p_of_type_Boolean = false;
  private int q;
  public volatile boolean q;
  private int r;
  protected boolean r;
  private int jdField_s_of_type_Int = 0;
  boolean jdField_s_of_type_Boolean = true;
  boolean jdField_t_of_type_Boolean = true;
  private int jdField_u_of_type_Int = -1;
  boolean jdField_u_of_type_Boolean = false;
  private int v;
  public boolean v;
  private int w;
  public boolean w;
  private int x;
  protected boolean x;
  private int y;
  protected boolean y;
  
  static
  {
    jdField_z_of_type_Boolean = false;
    M = false;
    jdField_j_of_type_Int = 30;
  }
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    this.jdField_b_of_type_JavaLangString = "BaseChatPie";
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_JavaLangCharSequence = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_k_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_i_of_type_Boolean = false;
    this.jdField_j_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager = null;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_q_of_type_Int = 10;
    this.jdField_r_of_type_Int = 0;
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_v_of_type_Int = 0;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_d_of_type_Int = -1;
    this.jdField_x_of_type_Boolean = false;
    this.jdField_y_of_type_Boolean = false;
    this.jdField_e_of_type_Int = -1;
    this.jdField_A_of_type_Boolean = false;
    this.jdField_w_of_type_Int = -1;
    this.jdField_x_of_type_Int = -1;
    this.jdField_y_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener = new ChatApolloViewListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = null;
    this.jdField_d_of_type_JavaLangRunnable = new BaseChatPie.1(this);
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new BaseChatPie.71(this);
    c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider = new HelperProvider(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList = a();
  }
  
  private void A(int paramInt)
  {
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      if (paramInt < 1) {
        break label43;
      }
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      if (this.jdField_h_of_type_AndroidViewView != null)
      {
        if (paramInt < 1) {
          break;
        }
        this.jdField_h_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      label43:
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    }
    this.jdField_h_of_type_AndroidViewView.setVisibility(0);
  }
  
  private void B(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 21: 
      ay();
      return;
    case 24: 
      bP();
      return;
    case 2: 
      bS();
      return;
    case 9: 
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      return;
    case 6: 
      bR();
      return;
    case 5: 
      bQ();
      return;
    case 14: 
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(14);
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005977", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
    case 22: 
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(22);
      return;
    case 31: 
      bO();
      return;
    }
    PublishHomeWorkFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "homework", "AioAssign_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) });
  }
  
  private void C(int paramInt)
  {
    if (this.jdField_o_of_type_AndroidViewView == null)
    {
      this.jdField_n_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      int i1 = Color.parseColor("#7f000000");
      this.jdField_n_of_type_AndroidViewView.setBackgroundColor(i1);
      this.jdField_n_of_type_AndroidViewView.setId(2131374569);
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131374601);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_n_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_o_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources()));
      this.jdField_o_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_o_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_o_of_type_AndroidWidgetTextView.setId(2131374601);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369142);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_o_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_o_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      localObject = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299166));
      this.jdField_o_of_type_AndroidViewView.setBackgroundColor(i1);
      this.jdField_o_of_type_AndroidViewView.setId(2131374599);
      this.jdField_o_of_type_AndroidViewView.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131377159);
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_o_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(2, 2131374601);
    this.jdField_n_of_type_AndroidViewView.setVisibility(paramInt);
    this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_o_of_type_AndroidViewView.setVisibility(paramInt);
    Object localObject = (ChatFragment)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((localObject == null) || (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)) {
      return;
    }
    if (paramInt == 0)
    {
      ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(new PorterDuffColorFilter(2130706432, PorterDuff.Mode.SRC_ATOP));
      return;
    }
    ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setStatusBarMask(null);
  }
  
  private boolean E()
  {
    boolean bool = false;
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= UinTypeUtil.c.length) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == UinTypeUtil.c[i1]))
      {
        if (i1 < UinTypeUtil.c.length) {
          bool = true;
        }
        return bool;
      }
      i1 += 1;
    }
  }
  
  private boolean F()
  {
    return (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"));
  }
  
  private boolean G()
  {
    return (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("apollo_forward_key"));
  }
  
  private boolean H()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (!this.jdField_x_of_type_Boolean);
  }
  
  private StickerBubbleTouchDelegate a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate == null)
    {
      StickerBubbleTouchDelegateCallbackForAIO localStickerBubbleTouchDelegateCallbackForAIO = new StickerBubbleTouchDelegateCallbackForAIO(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = new StickerBubbleTouchDelegate(localStickerBubbleTouchDelegateCallbackForAIO, paramView, PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      localStickerBubbleTouchDelegateCallbackForAIO.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  }
  
  @Nullable
  private MessageRecord a(MessageRecord paramMessageRecord)
  {
    Object localObject = paramMessageRecord;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      localObject = paramMessageRecord;
      if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName))
      {
        localObject = paramMessageRecord;
        if (paramMessageRecord == null)
        {
          localObject = a();
          i1 = ((List)localObject).size() - 1;
          if (i1 < 0) {
            break label106;
          }
          paramMessageRecord = (ChatMessage)((List)localObject).get(i1);
          if (paramMessageRecord.shmsgseq != this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq) {
            break label99;
          }
        }
      }
    }
    for (;;)
    {
      MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "suc_replyMsg", "reply_suc", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord);
      localObject = paramMessageRecord;
      return localObject;
      label99:
      i1 -= 1;
      break;
      label106:
      paramMessageRecord = null;
    }
  }
  
  @NotNull
  private String a(FullScreenInputHelper paramFullScreenInputHelper, int paramInt1, int paramInt2, MixedMsgInfo paramMixedMsgInfo, MessageRecord paramMessageRecord, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
      if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
        paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
      }
      if (paramMessageRecord != null) {
        paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
      }
    }
    Object localObject1 = new ArrayList();
    String str1 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
    l(true);
    Object localObject2 = new ArrayList();
    String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject2);
    boolean bool = m();
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
    if ((this.F) || (bool)) {
      if (bool) {
        ReplyMsgSender.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str1, (ArrayList)localObject1, paramSendMsgParams, paramMessageRecord, str2, (ArrayList)localObject2);
      }
    }
    do
    {
      return str1;
      a(str1, paramSendMsgParams, (ArrayList)localObject1);
      return str1;
      if ((!paramFullScreenInputHelper.c()) && (paramMixedMsgInfo != null) && (paramMixedMsgInfo.a()))
      {
        ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, (ArrayList)localObject1, paramMixedMsgInfo, paramSendMsgParams.jdField_k_of_type_Boolean);
        paramFullScreenInputHelper.c();
        return str1;
      }
      if ((localPhotoListPanel != null) && (localPhotoListPanel.a(str1)))
      {
        if (!localPhotoListPanel.a(true, this)) {
          a(str1, paramSendMsgParams, (ArrayList)localObject1);
        }
        ((PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7)).a(hashCode());
        return str1;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374332) == null) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374332) == null);
    paramMessageRecord = (MessageForTroopGift)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374332);
    paramSendMsgParams.e = paramMessageRecord.senderUin;
    paramFullScreenInputHelper = HardCodeUtil.a(2131701060);
    paramMixedMsgInfo = SharedPreUtils.i(this.jdField_a_of_type_AndroidContentContext, "wantWord");
    if (!android.text.TextUtils.isEmpty(paramMixedMsgInfo)) {
      paramFullScreenInputHelper = paramMixedMsgInfo;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramFullScreenInputHelper);
      paramFullScreenInputHelper = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramMessageRecord.senderUin + "");
      paramMixedMsgInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = this.jdField_a_of_type_AndroidContentContext;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      paramMessageRecord = paramMessageRecord.senderUin + "";
      localObject2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
      for (bool = true;; bool = false)
      {
        paramFullScreenInputHelper = AtTroopMemberSpan.a(paramMixedMsgInfo, (Context)localObject1, str1, paramMessageRecord, paramFullScreenInputHelper, false, (EditText)localObject2, bool);
        if ((paramFullScreenInputHelper != null) && (paramFullScreenInputHelper.length() != 0)) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, paramFullScreenInputHelper);
        }
        paramFullScreenInputHelper = new ArrayList();
        paramMixedMsgInfo = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramFullScreenInputHelper);
        a(paramMixedMsgInfo, paramSendMsgParams, paramFullScreenInputHelper);
        return paramMixedMsgInfo;
      }
      a(str1, paramSendMsgParams, (ArrayList)localObject1);
      if ((paramInt1 + paramInt2 <= 0) || (localPhotoListPanel == null)) {
        break;
      }
      localPhotoListPanel.a(false, null);
      ((PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7)).a(hashCode());
      return str1;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new BaseChatPie.5(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    bi();
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, int paramInt3)
  {
    boolean bool = true;
    switch (paramInt1)
    {
    case 4: 
    default: 
    case 18: 
    case 0: 
    case 1: 
    case 17000: 
    case 10: 
    case 3: 
    case 20: 
    case 21: 
    case 2000: 
    case 5: 
    case 100017: 
    case 11: 
    case 9009: 
    case 85: 
      do
      {
        return;
        n(paramIntent);
        return;
        c(false, false);
        return;
        AIOShortVideoUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt3, paramInt1);
        return;
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt1, paramIntent, 10);
        return;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.b(paramIntent);
        return;
        c(true, false);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(1024);
        return;
        paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719718));
        a(paramIntent.getExtras());
        return;
        m(paramIntent);
        return;
        x(paramInt2);
        return;
        ArrayList localArrayList = paramIntent.getStringArrayListExtra("input_full_screen_mode_result");
        if (paramIntent.getIntExtra("PhotoConst.SEND_SIZE_SPEC", 0) == 2) {}
        for (;;)
        {
          ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a(localArrayList, bool);
          return;
          bool = false;
        }
        l(paramIntent);
        return;
        k(paramIntent);
        return;
      } while (paramIntent == null);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), false, true, paramIntent.getStringExtra(QQIndividualityUtils.jdField_d_of_type_JavaLangString), null);
      return;
    case 9010: 
      RedBagVideoManager.a(paramIntent, a());
      return;
    case 9011: 
      g(paramIntent);
      return;
    case 102: 
      a(false, null, false);
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131693515, 1).a();
  }
  
  private void a(int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, int paramInt3)
  {
    if (paramInt1 == 2) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setCanLock(false);
    }
    for (;;)
    {
      b(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt1 == 4001)
      {
        EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIntent);
      }
      else if ((paramInt1 == 103) && (!paramBoolean))
      {
        c(false, true);
      }
      else if ((paramInt1 == 101) && (paramInt2 != -1))
      {
        c(false, false);
      }
      else if (paramInt1 == 13007)
      {
        q(paramIntent);
      }
      else if (paramInt1 == 11000)
      {
        c(paramInt1, paramInt2, paramIntent);
      }
      else if (paramInt1 == 13002)
      {
        p(paramIntent);
      }
      else if (paramInt1 == 13006)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResult() REQUEST_OPEN_REACTIVE_SETTING");
        }
        aL();
      }
      else if (paramInt1 == 100012)
      {
        if ((paramIntent != null) && (paramIntent.getIntExtra("camera_type", -1) == 103)) {
          aH();
        }
      }
      else if (paramInt1 == 14001)
      {
        o(paramIntent);
      }
      else if (paramInt1 == 12007)
      {
        by();
      }
      else if (paramInt1 == 12008)
      {
        a(paramInt2, paramIntent);
      }
      else if (paramInt1 == 18000)
      {
        ((MultiFavoriteHelper)a(11)).a(paramInt2, paramIntent);
      }
      else if (paramInt2 == -1)
      {
        a(paramInt1, paramInt2, paramIntent, paramInt3);
      }
      else
      {
        w(paramInt1);
      }
    }
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.a(paramInt1, paramInt2, paramString);
  }
  
  private void a(int paramInt, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramInt == -1))
    {
      TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      if (localTroopGiftPanel != null)
      {
        paramIntent = paramIntent.getExtras();
        if (paramIntent != null) {
          localTroopGiftPanel.a(paramIntent.getLong("duration_time"), paramIntent.getLong("elapsed_time"), paramIntent.getBoolean("profitable_flag", false));
        }
      }
    }
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_forwardType intent type" + paramIntent.getIntExtra("uintype", -1) + "needToBottom=" + paramBoolean);
    }
    if ((paramIntent.getExtras() != null) && (paramIntent.getExtras().containsKey("forward_type")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("forward", 2, "updateSession_forwardType from forward");
      }
      if ((paramIntent.getIntExtra("uintype", -1) == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(paramIntent.getStringExtra("uin"), true).jdField_a_of_type_Boolean)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697388, 0).b(a());
      }
    }
    else
    {
      return;
    }
    int i1 = paramIntent.getIntExtra("forward_type", 2147483647);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (i1 == 0) {
      this.jdField_i_of_type_Boolean = true;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, "updateSession_forwardType, postDelayed!");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.13(this, paramBoolean, paramIntent), 500L);
      a(false, null, false);
      return;
      if ((i1 == 1001) || (i1 == -4)) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      }
    }
  }
  
  private void a(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      aZ();
    } while ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (paramMessage.arg1 != 1));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
  }
  
  private void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
    case 0: 
      do
      {
        do
        {
          return;
        } while (!this.aa);
        a(paramView).a(paramMotionEvent);
        return;
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "hiboom icon touch down");
      } while (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty());
      a(paramView).a(paramMotionEvent);
      this.aa = true;
      return;
    }
    QLog.d(this.jdField_b_of_type_JavaLangString, 1, "hiboom icon touch up");
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty()) || (this.aa))
    {
      a(paramView).a(paramMotionEvent);
      this.aa = false;
      return;
    }
    onClick(this.jdField_a_of_type_AndroidWidgetImageButton);
  }
  
  private void a(AIOLongShotHelper paramAIOLongShotHelper)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851150);
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "set left text from set checkbox: " + this.jdField_e_of_type_JavaLangString);
    }
    if (android.text.TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.e();
      }
      if (!this.D) {
        break label350;
      }
      if (!android.text.TextUtils.isEmpty(this.jdField_c_of_type_AndroidWidgetTextView.getText())) {
        break label339;
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      MultiMsgManager.a().a();
      paramAIOLongShotHelper.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      ((AIOMultiActionHelper)a(66)).b();
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        v();
        aO();
      }
      if (this.jdField_j_of_type_Boolean)
      {
        av();
        this.jdField_j_of_type_Boolean = false;
      }
      this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369543).setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
      if ((this.jdField_n_of_type_AndroidWidgetTextView != null) && (!android.text.TextUtils.isEmpty(this.jdField_n_of_type_AndroidWidgetTextView.getText().toString())) && (!"0".equals(this.jdField_n_of_type_AndroidWidgetTextView.getText().toString())))
      {
        this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
        ((UnreadBackBottomHelper)a(53)).a();
      }
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", false);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_e_of_type_JavaLangString);
      this.jdField_e_of_type_JavaLangString = "";
      break;
      label339:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      continue;
      label350:
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void a(ShortcutBarAIOHelper paramShortcutBarAIOHelper, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramShortcutBarAIOHelper != null) && (!paramShortcutBarAIOHelper.c()) && (paramShortcutBarAIOHelper.b()) && (paramInt1 == 0) && (!BaseChatItemLayout.jdField_a_of_type_Boolean)) {
      paramShortcutBarAIOHelper.f();
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnMeasureListener(null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(paramInt2, paramInt3);
  }
  
  private void a(FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if ((localExtensionInfo == null) && (!paramFriendsManager.d())) {
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.62(this, paramFriendsManager));
    }
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(localExtensionInfo.audioPanelType, false);
    }
  }
  
  private void a(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    paramFriendsManager = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "saveC2CChatInputType | mExtensionInfo != null");
        }
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
    }
    else
    {
      if (paramFriendsManager.chatInputType != paramInt1)
      {
        paramFriendsManager.chatInputType = paramInt1;
        paramFriendsManager.isDataChanged = true;
      }
      if (paramFriendsManager.showC2CPanel != paramInt2)
      {
        paramFriendsManager.showC2CPanel = paramInt2;
        paramFriendsManager.isDataChanged = true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = null;
    }
  }
  
  private void a(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    paramFriendsManager = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo != null) {
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAudioPanelIfNeedForC2C extInfo.chatInputType = " + paramFriendsManager.chatInputType + " extInfo.showC2CPanel = " + paramFriendsManager.showC2CPanel);
      }
      if (paramFriendsManager.chatInputType == 2) {
        break label111;
      }
    }
    label111:
    while (paramFriendsManager.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAudioPanelIfNeed | ExtensionInfo = null");
      return;
    }
    e(paramBoolean1, paramBoolean2);
  }
  
  private void a(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (t())
    {
      ((AIOShakeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(65)).a(paramMessageRecord);
      if ((!paramMessageRecord.isread) && ((paramMessageRecord instanceof MessageForPoke)) && (!paramMessageRecord.isSend()))
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramMessageRecord.uniseq), (MessageForPoke)paramMessageRecord);
        ((MessageForPoke)paramMessageRecord).isPlayed = false;
      }
      if ((!paramMessageRecord.isread) && (!paramMessageRecord.isSend()) && ((paramMessageRecord instanceof MessageForArkFlashChat)) && (!y())) {
        ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a((MessageForArkFlashChat)paramMessageRecord);
      }
      bz();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
        HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
      if ((!paramMessageRecord.isSend()) && (paramMessageRecord.msgtype == -2039))
      {
        localObject = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if (!((IApolloManagerService)localObject).isInActionPlayList(paramMessageRecord.uniseq)) {
          ((IApolloManagerService)localObject).addToActionPlayList(paramMessageRecord.uniseq);
        }
      }
      localObject = (AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER);
      if (paramMessageRecord.isSend()) {
        break label351;
      }
      ((AppGuideTipsManager)localObject).a(paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForText)) {
        ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a(paramChatMessage);
      }
      if ((!(this instanceof PublicAccountChatPie)) || (!((PAListUI)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a()).jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() != this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1)) {
        break label360;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.28(this), 800L);
    }
    for (;;)
    {
      this.jdField_q_of_type_Boolean = true;
      return;
      label351:
      ((AppGuideTipsManager)localObject).a(this, paramMessageRecord);
      break;
      label360:
      paramChatMessage.mMsgAnimFlag = true;
      g(196608);
    }
  }
  
  private void a(MessageForText paramMessageForText)
  {
    if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 0))
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006211", "0X8006211", 0, 0, "", "", "", "");
      if ((paramMessageForText.atInfoList == null) || (paramMessageForText.atInfoList.size() != 1)) {
        break label125;
      }
      if (!((AtTroopMemberInfo)paramMessageForText.atInfoList.get(0)).isIncludingAll()) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006212", "0X8006212", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      return;
      label125:
      if ((paramMessageForText.atInfoList != null) && (paramMessageForText.atInfoList.size() > 1))
      {
        paramMessageForText = paramMessageForText.atInfoList.iterator();
        do
        {
          if (!paramMessageForText.hasNext()) {
            break;
          }
        } while (!((AtTroopMemberInfo)paramMessageForText.next()).isIncludingAll());
        for (int i1 = 1; i1 == 0; i1 = 0)
        {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006213", "0X8006213", 0, 0, "", "", "", "");
          return;
        }
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    if ((32768 != paramMessageRecord.extraflag) && ((paramMessageRecord instanceof MessageForApollo))) {
      ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a((MessageForApollo)paramMessageRecord, "aio");
    }
  }
  
  private void a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.msgtype != -2006) || (!(paramObject instanceof MessageForFoldMsg)))
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a();
      if ((paramMessageRecord instanceof MessageForPtt)) {
        paramObject.msg = ((MessageForPtt)paramMessageRecord).getSummaryMsg();
      }
      a(paramObject);
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "cancelSendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
    }
    a(2, paramString, paramLong);
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      StreamDataManager.a(paramString, true);
      StreamDataManager.a(paramString);
      Bundle localBundle = new Bundle();
      localBundle.putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
      StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramLong, true, 0, paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_d_of_type_Int, localBundle);
      return;
    }
    PttBuffer.a(paramString);
  }
  
  private void a(String paramString, ChatActivityFacade.SendMsgParams paramSendMsgParams, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    if (this.F)
    {
      ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramArrayList, paramSendMsgParams);
      aU();
      return;
    }
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramArrayList, paramSendMsgParams);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramString == null)) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onUpdateFriendInfo wrong uinType");
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034) || (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) && (!paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))));
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f))) {
      paramString = ContactUtils.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramString;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onUpdateFriendInfo title" + MessageRecordUtil.a(paramString));
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      if (!AppSetting.jdField_d_of_type_Boolean) {
        break;
      }
      paramString = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramString);
      a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1024) {
        paramString = CrmUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      } else {
        paramString = ContactUtils.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      }
    }
  }
  
  private void a(HashMap<String, String> paramHashMap)
  {
    if (!paramHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
    BaseBubbleBuilder.ViewHolder localViewHolder;
    for (;;)
    {
      return;
      int i1 = 0;
      while (i1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount())
      {
        paramHashMap = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
        if ((paramHashMap instanceof BaseChatItemLayout))
        {
          localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramHashMap);
          paramHashMap = AIOUtils.a(paramHashMap);
          if ((localViewHolder != null) && (paramHashMap != null) && (!paramHashMap.isSendFromLocal()) && (paramHashMap.istroop != 1) && (paramHashMap.istroop != 3000))
          {
            if (!AioApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
              break label135;
            }
            AioApolloHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramHashMap, localViewHolder);
          }
        }
        i1 += 1;
      }
    }
    label135:
    int i2;
    if ((paramHashMap.istroop == 1010) || (paramHashMap.istroop == 1001) || (paramHashMap.istroop == 10002) || (paramHashMap.istroop == 10010)) {
      if (NearbyCardManager.a(paramHashMap.senderuin)) {
        i2 = 202;
      }
    }
    label189:
    for (paramHashMap = FaceDrawable.getStrangerFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i2, paramHashMap.senderuin, true);; paramHashMap = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramHashMap.senderuin))
    {
      localViewHolder.a.setHeaderIcon(paramHashMap);
      break;
      i2 = 200;
      break label189;
    }
  }
  
  private void a(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2)
  {
    if ((!paramBoolean) || (paramInt1 != 146)) {
      return;
    }
    if (paramInt2 == 0)
    {
      UinFraudInfo.a().a(paramLong);
      return;
    }
    UinFraudInfo.a().a(paramLong, paramInt2);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.53(this, paramLong));
  }
  
  private void a(boolean paramBoolean, Object paramObject)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(24);
    HashMap localHashMap;
    int i1;
    if ((this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) || (!this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      localHashMap = new HashMap();
      if ((!paramBoolean) && ((paramObject instanceof Integer))) {
        i1 = ((Integer)paramObject).intValue();
      }
    }
    for (;;)
    {
      localHashMap.put("result", i1 + "");
      localHashMap.put("netType", NetworkUtil.a(BaseApplication.getContext()) + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeoutR", false, 30000L, 0L, localHashMap, "");
      for (;;)
      {
        return;
        if (paramBoolean) {
          break label353;
        }
        i1 = 1;
        break;
        if (MultiMsgManager.a().jdField_a_of_type_Int != 2) {
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        }
        MultiMsgManager.a().b.clear();
        if ((paramBoolean) && (paramObject != null)) {
          MultiMsgManager.a().b.putAll((Map)paramObject);
        }
        if (MultiMsgManager.a().b.size() == 0) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698460, 0).b(a());
        }
        while (QLog.isDevelopLevel())
        {
          QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
          return;
          if (paramObject != null) {
            if (MultiMsgManager.a().jdField_a_of_type_Int == 6) {
              ((MultiFavoriteHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(11)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
            } else {
              ((MultiForwardHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(1)).a((Map)paramObject, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, MultiMsgManager.a().jdField_a_of_type_Int);
            }
          }
        }
      }
      label353:
      i1 = 0;
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (!Utils.a(paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    do
    {
      return;
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramString2;
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        paramString1 = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramString1);
        a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
      }
    } while (!QLog.isDevelopLevel());
    DatingUtil.a(this.jdField_b_of_type_JavaLangString, new Object[] { "onGetFriendDateNick", paramString2 });
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)a(52);
    return ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) && (paramInt2 - paramInt1 != paramInt4 - paramInt3)) || ((localShortcutBarAIOHelper != null) && (localShortcutBarAIOHelper.a()));
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a())) {}
      for (int i1 = 1;; i1 = 0)
      {
        if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 36) && (paramInt == 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.d();
        }
        if (i1 == 0)
        {
          if (paramInt == 1) {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(false);
          }
        }
        else {
          return true;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
        return true;
      }
    }
    return paramBoolean;
  }
  
  private boolean a(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!android.text.TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseChatInputType redPacketExtra");
        }
        n(0);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null) {
      if (paramFriendsManager.d()) {}
    }
    label26:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localExtensionInfo1.timestamp = System.currentTimeMillis();
      if (UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
      for (localExtensionInfo1.chatInputType = 0;; localExtensionInfo1.chatInputType = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = localExtensionInfo1;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doChooseC2CInputType extInfo.chatInputType = " + localExtensionInfo1.chatInputType);
        }
        if (AIOInputTypeHelper.jdField_b_of_type_Boolean) {
          break;
        }
        switch (localExtensionInfo1.chatInputType)
        {
        case 1: 
        default: 
          return false;
        case 0: 
          localExtensionInfo1.chatInputType = 1;
          if (!QLog.isColorLevel()) {
            break label26;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doChooseC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser");
          return false;
        }
      }
    } while ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.jdField_l_of_type_Int = 2;
    return false;
  }
  
  private boolean a(Object paramObject)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "preCheckUpdate: finished");
        }
      }
      do
      {
        return true;
        Fragment localFragment = ((SplashActivity)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        if ((localFragment == null) || (localFragment.isVisible())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "preCheckUpdate: chat fragment not visible");
      return true;
    }
    if ((paramObject == null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "preCheckUpdate: data is null: ");
    }
    if (paramObject == null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("sendback", 2, "update mr.isBlessMsg" + paramMessageRecord.isBlessMsg);
    }
    if ((paramMessageRecord.msgtype == -1004) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin))) {
      return true;
    }
    if (a(paramMessageRecord)) {
      a((ChatMessage)paramObject, paramMessageRecord);
    }
    for (;;)
    {
      A();
      if (((paramObject instanceof MessageForStructing)) || ((paramObject instanceof MessageForText))) {
        AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, (ChatMessage)paramObject);
      }
      return false;
      if (((paramMessageRecord.istroop == 1001) || (paramMessageRecord.istroop == 10002)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin)) && (UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
        b((ChatMessage)paramObject, paramMessageRecord);
      } else if ((t()) && (!paramMessageRecord.isread)) {
        a(paramObject, paramMessageRecord);
      }
    }
  }
  
  @NotNull
  private String b(FullScreenInputHelper paramFullScreenInputHelper, int paramInt1, int paramInt2, MixedMsgInfo paramMixedMsgInfo, MessageRecord paramMessageRecord, ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
    }
    if (paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
    {
      paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
      if (((paramMessageRecord instanceof MessageForPic)) || ((paramMessageRecord instanceof MessageForMixedMsg))) {
        paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
      }
      if (paramMessageRecord != null) {
        paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord);
      }
    }
    ArrayList localArrayList = new ArrayList();
    String str = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
    boolean bool = m();
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
    if ((this.F) || (bool)) {
      if (bool) {
        ReplyMsgSender.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str, localArrayList, paramSendMsgParams, paramMessageRecord, null, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
      }
      return str;
      a(str, paramSendMsgParams, localArrayList);
      continue;
      if ((!paramFullScreenInputHelper.c()) && (paramMixedMsgInfo != null) && (paramMixedMsgInfo.a()))
      {
        ((MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MIXED_MSG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, localArrayList, paramMixedMsgInfo, false);
        paramFullScreenInputHelper.c();
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (localPhotoListPanel != null) && (localPhotoListPanel.a(str)))
      {
        if (!localPhotoListPanel.a(true, this)) {
          a(str, paramSendMsgParams, localArrayList);
        }
        ((PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7)).a(hashCode());
      }
      else
      {
        a(str, paramSendMsgParams, null);
        if ((paramInt1 + paramInt2 > 0) && (localPhotoListPanel != null))
        {
          localPhotoListPanel.a(false, null);
          ((PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7)).a(hashCode());
        }
      }
    }
  }
  
  private void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false)) || (paramIntent.getBooleanExtra("destroy_last_activity", false)))) || (paramInt2 == 4))
    {
      if ((paramIntent != null) && (paramIntent.getExtras() != null))
      {
        Bundle localBundle = paramIntent.getExtras();
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class);
        AIOUtils.a(localIntent, new int[] { 2 });
        localIntent.putExtras(new Bundle(localBundle));
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(4, paramIntent);
    }
    if ((paramInt1 == 21) && (paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      a(false, null, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt1, paramInt2, paramIntent);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = PlayModeUtils.b(paramBoolean1, paramBoolean2, paramBoolean3);
    if (i1 > 0) {
      QQToast.a(paramContext, i1, 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
    }
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void b(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FA8", "0X8007FA8", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[Doutu] handleMessage : MSG_SHOW_DOUTU_EMOTION_LAYOUT");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager == null) {
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager = ((DoutuManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DOUTU_MAGAGER));
      }
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_MqqOsMqqHandler, (DoutuItem)paramMessage.obj);
      paramMessage = (AIOEmoticonUIHelper)a(105);
      if (paramMessage != null)
      {
        paramMessage.d();
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(67);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
      }
      as();
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b(a());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
      }
      ar();
      return;
    } while ((this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager == null) || (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionAdapter == null));
    this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionAdapter.notifyDataSetChanged();
  }
  
  private void b(FriendsManager paramFriendsManager)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    if ((localNoC2CExtensionInfo == null) && (!paramFriendsManager.d())) {
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.63(this, paramFriendsManager));
    }
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(localNoC2CExtensionInfo.audioPanelType, false);
    }
  }
  
  private void b(FriendsManager paramFriendsManager, int paramInt1, int paramInt2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "saveNoC2CChatInputType | mNoC2CExtensionInfo != null");
        }
        localNoC2CExtensionInfo1 = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
    }
    else
    {
      if (localNoC2CExtensionInfo1.chatInputType != paramInt1)
      {
        localNoC2CExtensionInfo1.chatInputType = paramInt1;
        localNoC2CExtensionInfo1.isDataChanged = true;
      }
      if (localNoC2CExtensionInfo1.showC2CPanel != paramInt2)
      {
        localNoC2CExtensionInfo1.showC2CPanel = paramInt2;
        localNoC2CExtensionInfo1.isDataChanged = true;
      }
      paramFriendsManager.a(localNoC2CExtensionInfo1, false);
      this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = null;
    }
  }
  
  private void b(FriendsManager paramFriendsManager, boolean paramBoolean1, boolean paramBoolean2)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    paramFriendsManager = localNoC2CExtensionInfo;
    if (localNoC2CExtensionInfo == null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo != null) {
        paramFriendsManager = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAudioPanelIfNeedForNoC2C noC2CExtInfo.chatInputType = " + paramFriendsManager.chatInputType + " noC2CExtInfo.showC2CPanel = " + paramFriendsManager.showC2CPanel);
      }
      if (paramFriendsManager.chatInputType == 2) {
        break label118;
      }
    }
    label118:
    while (paramFriendsManager.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAudioPanelIfNeed | NoC2CExtensionInfo = null");
      return;
    }
    e(paramBoolean1, paramBoolean2);
  }
  
  private void b(ChatMessage paramChatMessage, MessageRecord paramMessageRecord)
  {
    if ((AppConstants.SYSTEM_MSG_UIN.equalsIgnoreCase(paramMessageRecord.frienduin)) && (!paramMessageRecord.isread))
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a());
      return;
    }
    if (t())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
      bz();
      paramChatMessage.mMsgAnimFlag = true;
      g(196608);
    }
    this.jdField_q_of_type_Boolean = true;
  }
  
  private void b(Object paramObject)
  {
    if ((paramObject instanceof ChatMessage))
    {
      localMessageRecord = (MessageRecord)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "update mr.msgseq" + localMessageRecord.msgseq + ",time is:" + System.currentTimeMillis() + " status:" + localMessageRecord.extraflag);
      }
      a(localMessageRecord);
      if (b(paramObject, localMessageRecord)) {}
      do
      {
        return;
        if (localMessageRecord.isSendFromLocal()) {
          break;
        }
      } while (a(paramObject, localMessageRecord));
      for (;;)
      {
        FightMsgReporter.a(0, 0, ((MessageRecord)paramObject).istroop, 1);
        return;
        b(paramObject, localMessageRecord);
      }
    }
    MessageRecord localMessageRecord = (MessageRecord)paramObject;
    if (((paramObject instanceof DataLineMsgRecord)) && (!localMessageRecord.isread) && (!localMessageRecord.isSendFromLocal())) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a());
    }
    ThreadManagerV2.excute(new BaseChatPie.27(this), 32, null, true);
  }
  
  private void b(Object paramObject, MessageRecord paramMessageRecord)
  {
    bz();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(true);
    this.jdField_q_of_type_Boolean = true;
    c(paramObject, paramMessageRecord);
    if (((paramMessageRecord instanceof MessageForStructing)) && ((paramMessageRecord.istroop == 1) || (paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 0))) {
      if ("viewMultiMsg".equals(((MessageForStructing)paramMessageRecord).structingMsg.mMsgAction)) {
        MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq, true);
      }
    }
    do
    {
      return;
      if (((paramMessageRecord instanceof MessageForText)) && (paramMessageRecord.istroop == 3000) && (paramMessageRecord.extraflag == 0))
      {
        a((MessageForText)paramMessageRecord);
        return;
      }
    } while (!(paramMessageRecord instanceof MessageForArkFlashChat));
    ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a((MessageForArkFlashChat)paramMessageRecord);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (!(paramObject instanceof Set))) {
      return;
    }
    VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Set localSet = (Set)paramObject;
    int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount();
    int i1 = 0;
    label43:
    Object localObject1;
    ChatMessage localChatMessage;
    label94:
    int i2;
    if (i1 < i3)
    {
      paramObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
      if ((paramObject instanceof BaseChatItemLayout))
      {
        localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(paramObject);
        localChatMessage = AIOUtils.a(paramObject);
        if (!localChatMessage.isSend()) {
          break label236;
        }
        paramObject = localChatMessage.selfuin;
        Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((localObject1 != null) && (((BaseBubbleBuilder.ViewHolder)localObject1).a != null) && (paramObject != null) && (localSet.contains(paramObject)))
        {
          localObject2 = ((FriendsManager)localObject2).a(paramObject);
          if (localObject2 != null)
          {
            Object localObject3 = Long.valueOf(((ExtensionInfo)localObject2).pendantId);
            if (((Long)localObject3).longValue() == 0L) {
              break label293;
            }
            localObject3 = ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(((Long)localObject3).longValue());
            localObject1 = ((BaseBubbleBuilder.ViewHolder)localObject1).a;
            if (i1 == i3) {
              break label287;
            }
            i2 = 1;
            label209:
            ((PendantInfo)localObject3).a((View)localObject1, i2, localChatMessage.uniseq, paramObject, ((ExtensionInfo)localObject2).pendantDiyId);
          }
        }
      }
    }
    for (;;)
    {
      i1 += 1;
      break label43;
      break;
      label236:
      if ((localChatMessage.istroop == 1000) || (localChatMessage.istroop == 1020) || (localChatMessage.istroop == 1004))
      {
        paramObject = localChatMessage.frienduin;
        break label94;
      }
      paramObject = localChatMessage.senderuin;
      break label94;
      label287:
      i2 = 2;
      break label209;
      label293:
      if (((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView != null)
      {
        ((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
        ((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      }
    }
  }
  
  private void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean) {}
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
    case 0: 
    case 1037: 
    case 1044: 
    case 1045: 
      do
      {
        do
        {
          return;
        } while (!paramString1.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if ((paramString2 == null) || (paramString2.length() <= 0)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramString2;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onSetComment curFriendNick" + MessageRecordUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString));
        }
        this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      } while (!AppSetting.jdField_d_of_type_Boolean);
      paramString1 = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramString1);
      a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ContactUtils.m(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      paramString2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString != null) {}
      for (paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;; paramString1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)
      {
        paramString2.jdField_d_of_type_JavaLangString = paramString1;
        break;
      }
    }
    c(false, false);
  }
  
  private boolean b(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.f();
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.m();
          continue;
          if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null)
          {
            ApolloInfo localApolloInfo = (ApolloInfo)paramMessage.obj;
            if (paramMessage.arg1 == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.g();
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(localApolloInfo);
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null)
              {
                paramMessage = (HashMap)paramMessage.obj;
                if (paramMessage != null)
                {
                  paramMessage.put("offset", "" + a());
                  this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(paramMessage);
                  continue;
                  ay();
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean b(FriendsManager paramFriendsManager)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null) {
      if (paramFriendsManager.d()) {}
    }
    label36:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseC2CChatInputType get NoC2CExtensionInfo = null");
      }
      localNoC2CExtensionInfo1 = new NoC2CExtensionInfo();
      localNoC2CExtensionInfo1.type = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      localNoC2CExtensionInfo1.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localNoC2CExtensionInfo1.chatInputType = 0;
      this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo = localNoC2CExtensionInfo1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
      for (int i1 = 1;; i1 = 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doChooseNoC2CInputType noC2CExtInfo.chatInputType = " + localNoC2CExtensionInfo1.chatInputType + " noC2CType = " + i1);
        }
        switch (localNoC2CExtensionInfo1.chatInputType)
        {
        case 1: 
        default: 
          return false;
        case 0: 
          localNoC2CExtensionInfo1.chatInputType = 1;
          if (!QLog.isColorLevel()) {
            break label36;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doChooseNoC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser ");
          return false;
        }
      }
    } while ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.jdField_l_of_type_Int = 2;
    return false;
  }
  
  private boolean b(Object paramObject, MessageRecord paramMessageRecord)
  {
    if (t())
    {
      if (((paramMessageRecord instanceof MessageForUniteGrayTip)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.senderuin)) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int)))
      {
        MessageForUniteGrayTip localMessageForUniteGrayTip = (MessageForUniteGrayTip)paramMessageRecord;
        localMessageForUniteGrayTip.hasRead = 1;
        localMessageForUniteGrayTip.updateUniteGrayTipMsgData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int == 2097153) {
          OldMutualMarkLogicHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localMessageForUniteGrayTip, this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, localMessageForUniteGrayTip.subType);
        }
      }
      AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
      return AIOAnimationControlManager.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject);
    }
    return false;
  }
  
  private boolean b(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (BaseChatItemLayout.jdField_a_of_type_Boolean)
    {
      if (!this.G)
      {
        a(false, null, false);
        bool = true;
      }
    }
    else {
      return bool;
    }
    MultiMsgManager.a().jdField_a_of_type_Int = 0;
    return paramBoolean;
  }
  
  private void bA()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getCount() - 1);
    }
  }
  
  private void bB()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
      {
        Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
        if ((localObject != null) && (((ChatMessage)localObject).msgtype == -2039))
        {
          localObject = (MessageForApollo)localObject;
          if ((!((MessageForApollo)localObject).hasPlayed) && (((MessageForApollo)localObject).isSend())) {
            ((IApolloUtil)QRoute.api(IApolloUtil.class)).setReaded((MessageForApollo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
        }
      }
    }
  }
  
  private void bC()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void bD()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow_videoStatus: mEnterExtPanel = " + this.jdField_l_of_type_Int + ", mExtPanelOnResumeTimes = " + this.jdField_m_of_type_Int);
    }
    if (this.jdField_l_of_type_Int != 0)
    {
      int i1 = this.jdField_m_of_type_Int - 1;
      this.jdField_m_of_type_Int = i1;
      if (i1 == 0)
      {
        if (this.jdField_l_of_type_Int != 1) {
          break label103;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new BaseChatPie.39(this));
      }
    }
    for (;;)
    {
      this.jdField_l_of_type_Int = 0;
      return;
      label103:
      if (this.jdField_l_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new BaseChatPie.40(this));
      }
    }
  }
  
  private void bE()
  {
    NativeVideoImage.resumeAll();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.jdField_c_of_type_Int;
    AbstractGifImage.resumeAll();
    com.etrump.mixlayout.ETTextView.enableAnimation = true;
    ApngImage.playByTag(0);
    AbstractVideoImage.resumeAll();
    NowVideoController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.d();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).b();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow_updateUI: listView.setVisibility(View.VISIBLE)");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
    bL();
    bK();
    Object localObject;
    if ((this.Y) && (!this.jdField_r_of_type_Boolean))
    {
      if (!this.N)
      {
        e(true, false);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
        this.N = true;
        this.Y = false;
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(this);
      if ((this.jdField_l_of_type_Boolean) && (this.jdField_s_of_type_Boolean))
      {
        ForwardSDKB77AIOHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider);
        this.jdField_s_of_type_Boolean = false;
      }
      if ((this.jdField_m_of_type_Boolean) && (this.jdField_t_of_type_Boolean))
      {
        localObject = (ForwardIMByThirdPartyHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(37);
        if (localObject != null) {
          ((ForwardIMByThirdPartyHelper)localObject).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), true);
        }
        this.jdField_t_of_type_Boolean = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      if (((SharedPreferences)localObject).getBoolean("sdcard_related_download_failed", false))
      {
        if (Environment.getExternalStorageState().equals("mounted")) {
          break label356;
        }
        QQToast.a(BaseApplication.getContext(), 2131694521, 0).b(a());
      }
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putBoolean("sdcard_related_download_failed", false);
      ((SharedPreferences.Editor)localObject).commit();
      if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(64))
      {
        int i1 = HotReactiveHelper.a();
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(64, i1 * 1000);
      }
      EmojiStickerManager.a().a(this);
      return;
      d(true, false);
      break;
      label356:
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1) {
        QQToast.a(BaseApplication.getContext(), 2131718861, 0).b(a());
      }
    }
  }
  
  private void bF()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().c() == 1) {}
    for (;;)
    {
      this.P = bool;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mIsMsgSignalOpen: " + this.P);
      }
      return;
      bool = false;
    }
  }
  
  private void bG()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void bH()
  {
    if ((QQLSRecentManager.jdField_e_of_type_Boolean) && (QQUtils.a(BaseApplication.getContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow_setReaded");
    }
    ThreadManager.post(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a(), 8, null, false);
  }
  
  private void bI()
  {
    this.jdField_b_of_type_JavaLangRunnable = new BaseChatPie.47(this);
  }
  
  private void bJ()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    if (i1 != 0)
    {
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      if ((i1 == 5) || (i1 == 6)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      }
    }
    while ((i2 == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null) || (y())) {
      return;
    }
    QQOperationViopTipTask localQQOperationViopTipTask = (QQOperationViopTipTask)this.jdField_a_of_type_JavaUtilList.get(i2 - 1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a(localQQOperationViopTipTask);
  }
  
  private void bK()
  {
    if (F())
    {
      Object localObject = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 4);
      if (((SharedPreferences)localObject).getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        ((SharedPreferences)localObject).edit().remove("FORWARD_EMOPGK_ID").commit();
        this.jdField_l_of_type_Int = 3;
        localObject = (AIOEmoticonPanelHelper)a(104);
        if (localObject != null) {
          ((AIOEmoticonPanelHelper)localObject).showEmoticonPanel(str);
        }
      }
    }
  }
  
  private void bL()
  {
    Intent localIntent;
    int i1;
    if (G())
    {
      this.jdField_l_of_type_Int = 21;
      localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      if (!localIntent.hasExtra("apollo_actionid_key")) {
        break label170;
      }
      i1 = localIntent.getExtras().getInt("apollo_actionid_key");
      localIntent.removeExtra("apollo_actionid_key");
    }
    for (;;)
    {
      int i2;
      if (localIntent.hasExtra("apollo_pkgid_key"))
      {
        i2 = localIntent.getExtras().getInt("apollo_pkgid_key");
        localIntent.removeExtra("apollo_pkgid_key");
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "showQuickApolloSendPanel, pkgId=", Integer.valueOf(i2), ", actionId=", Integer.valueOf(i1) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(i2, i1);
        }
        for (;;)
        {
          ay();
          this.jdField_w_of_type_Int = -1;
          this.jdField_x_of_type_Int = -1;
          return;
          this.jdField_w_of_type_Int = i1;
          this.jdField_x_of_type_Int = i2;
        }
        i2 = -1;
      }
      label170:
      i1 = -1;
    }
  }
  
  private void bM()
  {
    long l1 = System.currentTimeMillis();
    FriendsManager localFriendsManager;
    int i1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_g_of_type_Boolean))
    {
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)) {
        break label139;
      }
      i1 = 1;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break label144;
      }
      b(localFriendsManager, 0, i1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("save_inptut", 2, "saveChatInputType cost :" + (System.currentTimeMillis() - l1));
      }
      return;
      label139:
      i1 = 0;
      break;
      label144:
      if (E()) {
        a(localFriendsManager, 0, i1);
      }
    }
  }
  
  private void bN()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b())
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  private void bO()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("finish_animation_up_down", true);
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    Object localObject2 = localTroopLinkManager.a("troop_homework_create_notice");
    Object localObject1 = localObject2;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>";
    }
    localObject2 = new TroopLinkManager.LinkParams();
    ((TroopLinkManager.LinkParams)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    ((TroopLinkManager.LinkParams)localObject2).jdField_c_of_type_JavaLangString = "aio";
    ((TroopLinkManager.LinkParams)localObject2).i = "";
    localIntent.putExtra("url", localTroopLinkManager.a((String)localObject1, (TroopLinkManager.LinkParams)localObject2));
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(2130772314, 2130771992);
    TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Grp_notice", "CreateNotice_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "" });
  }
  
  private void bP()
  {
    if (this.jdField_a_of_type_Int != 1) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
    }
  }
  
  private void bQ()
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 23) {
      if (a().checkSelfPermission("android.permission.CAMERA") == 0)
      {
        i1 = 1;
        if ((i1 == 0) || (a().checkSelfPermission("android.permission.RECORD_AUDIO") != 0)) {
          break label129;
        }
        i1 = 1;
        label42:
        if ((i1 == 0) || (!PermissionUtils.isStorePermissionEnable(a()))) {
          break label134;
        }
        i1 = 1;
      }
    }
    for (;;)
    {
      label58:
      if (i1 == 0) {
        a().requestPermissions(new BaseChatPie.67(this), 1, new String[] { "android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
      }
      for (;;)
      {
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407A", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
        i1 = 0;
        break;
        label129:
        i1 = 0;
        break label42;
        label134:
        i1 = 0;
        break label58;
        ba();
      }
      i1 = 1;
    }
  }
  
  private void bR()
  {
    if (Build.VERSION.SDK_INT >= 23) {}
    for (boolean bool = PermissionUtils.isStorePermissionEnable(a());; bool = true)
    {
      if (!bool)
      {
        a().requestPermissions(new BaseChatPie.68(this), 3, new String[] { "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      j(true);
      return;
    }
  }
  
  private void bS()
  {
    int i1;
    if (Build.VERSION.SDK_INT >= 23) {
      if (a().checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 == 0)
      {
        a().requestPermissions(new BaseChatPie.69(this), 2, new String[] { "android.permission.RECORD_AUDIO" });
        return;
        i1 = 0;
      }
      else
      {
        AudioTransitionAnimManager.a().a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
        AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
        i1 = 1;
      }
    }
  }
  
  private void bT()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("power")).newWakeLock(536870918, this.jdField_b_of_type_JavaLangString);
    }
    if (!this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "remainScreenOn");
    }
  }
  
  private void bU()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter() == null)) {}
    for (;;)
    {
      return;
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      while ((i1 <= i2) && (i1 < this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getCount()))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getItem(i1);
        if ((localObject instanceof MessageForArkApp))
        {
          localObject = (MessageForArkApp)localObject;
          if (((MessageForArkApp)localObject).arkContainer != null) {
            ((MessageForArkApp)localObject).arkContainer.d();
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void bV()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageButton == null) {
      return;
    }
    Drawable localDrawable = ABTestController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(localDrawable);
  }
  
  private void bi()
  {
    if (this.D) {
      d(AIOUtils.a(1.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()));
    }
    for (;;)
    {
      if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      }
      return;
      ThreadManager.executeOnSubThread(new DecodeAIOInputBitmapHeightTask(this), true);
    }
  }
  
  private void bj()
  {
    boolean bool = false;
    if (a())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(this.jdField_c_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b(this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(8);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c(-1);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
      QQBlurView localQQBlurView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      }
      localQQBlurView.setEnableBlur(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDisableBlurDrawableRes(2130838222);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a(new BaseChatPie.6(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDirtyListener(new BaseChatPie.7(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
  }
  
  private void bk()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController = new ChatPieApolloViewController();
    }
  }
  
  private void bl()
  {
    SimpleUIAIOHelper localSimpleUIAIOHelper = (SimpleUIAIOHelper)a(29);
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) && (QQTheme.e()))
    {
      localSimpleUIAIOHelper.b(false);
      return;
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onClick fun_btn start mInputStat = " + this.jdField_a_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
    }
    ao();
    if (QLog.isColorLevel())
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onClick fun_btn end mInputStat = " + this.jdField_a_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
      }
    }
    localSimpleUIAIOHelper.b(true);
  }
  
  private void bm()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (this.jdField_b_of_type_AndroidAppDialog.isShowing()))
    {
      this.jdField_b_of_type_AndroidAppDialog.dismiss();
      this.jdField_b_of_type_AndroidAppDialog = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  private void bn()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerProxy().c();
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -3010);
      FileManagerDataCenter.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
    }
    FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localFileTransferManager != null) {
      localFileTransferManager.b();
    }
  }
  
  private void bo()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentFocus();
      if (localObject != null)
      {
        QLog.i(this.jdField_b_of_type_JavaLangString, 1, localObject.toString());
        ((View)localObject).clearFocus();
      }
    }
    Object localObject = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    c(true);
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (localObject != null)) {}
    try
    {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false) != null) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false).clear();
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374320, null);
      }
    }
    catch (RuntimeException localThrowable)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener(null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(null);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          for (;;)
          {
            if (AIOUtils.a())
            {
              localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver();
              Field localField = ViewTreeObserver.class.getDeclaredField("mOnTouchModeChangeListeners");
              localField.setAccessible(true);
              localField.set(localObject, new CopyOnWriteArrayList());
              QLog.d(this.jdField_b_of_type_JavaLangString, 1, "force clear mOnTouchModeChangeListeners success.");
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper$IMECommandListener != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper$IMECommandListener.a();
            }
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
            }
            return;
            localRuntimeException = localRuntimeException;
            QLog.e(this.jdField_b_of_type_JavaLangString, 1, localRuntimeException, new Object[0]);
          }
          localThrowable = localThrowable;
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "doOnDestroy: ", localThrowable);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d(this.jdField_b_of_type_JavaLangString, 1, "force clear mOnTouchModeChangeListeners", localException);
          }
        }
      }
    }
  }
  
  private void bp()
  {
    BaseChatPie.20 local20 = new BaseChatPie.20(this);
    if (AppSetting.jdField_f_of_type_Boolean)
    {
      ThreadManager.executeOnSubThread(local20, true);
      return;
    }
    local20.run();
  }
  
  private void bq()
  {
    ArkTipsManager.a().b(this);
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.b();
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = null;
    }
  }
  
  private void br()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverscrollHeader());
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
      b(this.jdField_i_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_j_of_type_AndroidWidgetTextView != null) {
      b(this.jdField_j_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_k_of_type_AndroidWidgetTextView != null) {
      b(this.jdField_k_of_type_AndroidWidgetTextView.getBackground());
    }
  }
  
  private void bs()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.jdField_a_of_type_Boolean = false;
    }
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if (localIApolloManagerService != null) {
      localIApolloManagerService.setApolloGameChatPie(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.f(this);
    }
    localIApolloManagerService.setActionDownloadList(null);
    ((IApolloResponseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResponseManager.class, "all")).removeResponseView();
  }
  
  private void bt()
  {
    if (this.F)
    {
      this.F = false;
      C(8);
    }
    ReceiptMsgManager.a().a();
    if (this.jdField_o_of_type_AndroidViewView != null)
    {
      this.jdField_d_of_type_AndroidViewViewGroup.removeViewInLayout(this.jdField_o_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeViewInLayout(this.jdField_n_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeViewInLayout(this.jdField_o_of_type_AndroidWidgetTextView);
      this.jdField_o_of_type_AndroidViewView = null;
      this.jdField_n_of_type_AndroidViewView = null;
      this.jdField_o_of_type_AndroidWidgetTextView = null;
      ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(2, 2131369142);
    }
  }
  
  private void bu()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
      this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
    }
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.f();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
  }
  
  private void bv()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null)
    {
      this.jdField_y_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.h();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.c();
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    }
  }
  
  private void bw()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showInputPanelIfNeeded() called");
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      boolean bool;
      do
      {
        return;
        localObject = ((Activity)localObject).getIntent();
        if (localObject == null)
        {
          QLog.e(this.jdField_b_of_type_JavaLangString, 1, "showInputPanelIfNeeded() intent == null");
          return;
        }
        bool = ((Intent)localObject).getBooleanExtra("KEY_SHOULD_SHOW_KEYBOARD", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showInputPanelIfNeeded() requestShowInputPanel = " + bool + ", Intent = " + System.identityHashCode(localObject));
        }
      } while ((!bool) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null));
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showInputPanelIfNeeded() isReadyToShow false");
    return;
    ax();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    this.jdField_c_of_type_JavaLangRunnable = new BaseChatPie.22(this, (Intent)localObject);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_c_of_type_JavaLangRunnable, 100L);
  }
  
  private void bx()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showPlusPanelIfNeeded() called");
    }
    Object localObject = a();
    if (localObject == null) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return;
          localObject = ((Activity)localObject).getIntent();
        } while (localObject == null);
        bool = ((Intent)localObject).getBooleanExtra("KEY_SHOULD_SHOW_PLUS_PANEL", false);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showPlusPanelIfNeeded() requestShowPlusPanel = " + bool + ", Intent = " + System.identityHashCode(localObject));
        }
      } while ((!bool) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null));
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.c()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showPlusPanelIfNeeded() isReadyToShow false");
    return;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.23(this, (Intent)localObject), 100L);
  }
  
  private void by()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
    {
      TroopGiftPanel localTroopGiftPanel = this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
      if (localTroopGiftPanel != null) {
        localTroopGiftPanel.a(null);
      }
    }
  }
  
  private void bz()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b();
  }
  
  private void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("faceGuide", 2, "onActivityResult = =" + paramInt1 + "resultCode" + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(5, true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(6, true);
    if (1000 == paramInt2)
    {
      paramInt1 = paramIntent.getIntExtra("click_item", 1);
      if ((paramInt1 == 9) || (paramInt1 == 10) || (paramInt1 == 14)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("XPanel", 2, "onActivityResult = setPanel=" + paramInt1);
      }
      a(Integer.valueOf(paramInt1));
    }
    while (1001 != paramInt2) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  private void c(android.os.Message paramMessage)
  {
    if (this.jdField_d_of_type_AndroidViewViewGroup == null) {
      paramMessage = "1";
    }
    for (;;)
    {
      i(paramMessage);
      return;
      if (paramMessage.obj == null)
      {
        paramMessage = "2";
      }
      else
      {
        if ((paramMessage.obj instanceof Drawable)) {
          break;
        }
        paramMessage = "3, msg.obj=" + paramMessage.obj;
      }
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
    {
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
    }
    for (;;)
    {
      aw();
      paramMessage = null;
      break;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10007)
      {
        if (!ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
        {
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
        }
      }
      else
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)paramMessage.obj);
        if (AIOMusicSkin.a().m_()) {
          AIOMusicSkin.a().b(this.jdField_d_of_type_AndroidViewViewGroup.getContext(), this.jdField_d_of_type_AndroidViewViewGroup);
        }
        ((QEffectBgProvider)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(17)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND sessionInfo:  isQimUserOnline = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean + "  isQimUserTitleForm = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean + "  isTimUserOnline = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean + " isTimUserTitleForm = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean + "  isNightMode = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean + "  curType = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        }
      }
    }
  }
  
  private void c(Object paramObject)
  {
    paramObject = (QQMessageFacade.MessageNotifyParam)paramObject;
    if ((paramObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (paramObject.jdField_a_of_type_Int == 0)) {
      c(false, true);
    }
  }
  
  private void c(Object paramObject, MessageRecord paramMessageRecord)
  {
    boolean bool;
    if ((paramMessageRecord.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int)))
    {
      ChatMessage localChatMessage = (ChatMessage)paramObject;
      if (((paramObject instanceof MessageForArkApp)) && (((MessageForArkApp)paramObject).getProcessState() == 1002)) {
        break label178;
      }
      bool = true;
      localChatMessage.mMsgAnimFlag = bool;
      if (paramMessageRecord.msgtype == -2058) {
        break label183;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "update need instantUpdate, msg= " + paramMessageRecord.toString());
      }
      c(true, true);
    }
    for (;;)
    {
      ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).a(this, paramMessageRecord);
      if ((paramMessageRecord instanceof MessageForText)) {
        ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEAMWORK_SPREAD_MANAGER)).a((ChatMessage)paramObject);
      }
      return;
      label178:
      bool = false;
      break;
      label183:
      c(false, false);
    }
  }
  
  private void c(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject + "")) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "onUpdateDelFriend exit ChatActivity now uin = " + paramObject);
      }
      b(1);
    }
  }
  
  private boolean c(int paramInt)
  {
    DoodleResHelper.a().a();
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(59)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(59);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.a(true, paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(12);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(false);
    boolean bool1 = b(false);
    if ((bool1) && (paramInt == 0)) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "basechatpie_finish 1,type:" + paramInt);
      }
    }
    do
    {
      do
      {
        do
        {
          return true;
          if (this.F)
          {
            aU();
            bool1 = true;
          }
          if ((!bool1) || (paramInt != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "basechatpie_finish 1.1,type:" + paramInt);
        return true;
        bool2 = bool1;
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null)
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b()) {
            bool2 = true;
          }
        }
        if ((!bool2) || (paramInt != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "basechatpie_finish 2,type:" + paramInt);
      return true;
      y(paramInt);
      boolean bool2 = a(paramInt, bool2);
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a())
        {
          this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramInt == 0)
        {
          bool2 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null)
          {
            bool2 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a()) {
              bool2 = true;
            }
          }
        }
      }
      if ((!bool2) || (paramInt != 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "basechatpie_finish 3,type:" + paramInt);
    return true;
    return false;
  }
  
  private boolean c(android.os.Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
      return true;
      h(paramMessage.arg1);
      return true;
      c(false, false);
      return true;
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(false);
      return true;
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(false);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131694361, 0).b(a());
    } while (paramMessage.arg1 != 1);
    UncommonMessageProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, UncommonMessageProcessor.jdField_b_of_type_Int, UncommonMessageProcessor.jdField_l_of_type_Int);
    return true;
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, "");
  }
  
  private void d(android.os.Message paramMessage)
  {
    Object localObject = (Map)paramMessage.obj;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)((Map)localObject).get("chatMessage"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "updateZanInfo pos is:" + i1);
    }
    if (i1 < 0) {}
    do
    {
      do
      {
        do
        {
          int i2;
          int i3;
          int i4;
          int i5;
          do
          {
            return;
            i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
            i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
            i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
            i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
          } while ((i1 < i2 - i3) || (i1 > i4 - i5));
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        } while (!(paramMessage instanceof LinearLayout));
        localObject = (RichStatus.SigZanInfo)((Map)localObject).get("sigZanInfo");
      } while (!(AIOUtils.a(paramMessage) instanceof RichStatItemBuilder.Holder));
      paramMessage = (RichStatItemBuilder.Holder)AIOUtils.a(paramMessage);
    } while ((((RichStatus.SigZanInfo)localObject).jdField_a_of_type_JavaLangString == null) || (!((RichStatus.SigZanInfo)localObject).jdField_a_of_type_JavaLangString.equals(paramMessage.a.jdField_b_of_type_JavaLangString)));
    paramMessage.a.jdField_d_of_type_Int = ((RichStatus.SigZanInfo)localObject).jdField_b_of_type_Int;
    paramMessage.a.jdField_f_of_type_Int = ((RichStatus.SigZanInfo)localObject).jdField_c_of_type_Int;
    paramMessage.a.j();
  }
  
  private void d(Object paramObject)
  {
    if (this.jdField_c_of_type_Int != 0) {}
    while ((RichStatItemBuilder.jdField_a_of_type_Long == 0L) || (!(paramObject instanceof RichStatus.SigZanInfo))) {
      return;
    }
    ThreadManager.post(new BaseChatPie.52(this, (RichStatus.SigZanInfo)paramObject), 5, null, false);
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {}
    for (paramObject = (Card)paramObject;; paramObject = null)
    {
      if ((paramBoolean) && (paramObject != null)) {}
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObject.uin)))
        {
          C();
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onCardDownload nick = " + MessageRecordUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString));
          }
          this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
          if (AppSetting.jdField_d_of_type_Boolean)
          {
            paramObject = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString();
            this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramObject);
            a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
          }
          if ((3000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) && ((this instanceof DiscussChatPie))) {
            ((DiscussChatPie)this).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_AndroidWidgetTextView);
          }
        }
      case 1034: 
        return;
      }
      c(false, false);
      return;
    }
  }
  
  private boolean d(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 25: 
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) && (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() != null))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
      }
      return true;
    case 38: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar, new Object[0]))
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.getSubThreadHandler().post(new BaseChatPie.16(this));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
      }
      return true;
    case 35: 
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar == null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar = new VipFunCallTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new BaseChatPie.17(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar, new Object[0]);
      return true;
    case 26: 
      ChatActivityFacade.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
      return true;
    case 58: 
      ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
      return true;
    case 28: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
      return true;
    case 31: 
      boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_notice_key", false);
      if ((!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", false)) && (bool))
      {
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", true);
        paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        BaseApplicationImpl.getApplication().startActivity(paramMessage);
      }
      return true;
    }
    ak();
    return true;
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 28)
    {
      this.K = false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(false);
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.b(false);
      }
    }
    if (paramInt2 == 28)
    {
      this.K = true;
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(true);
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.b(true);
      }
    }
  }
  
  private void e(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 40: 
    case 16711685: 
    case 16711687: 
    case 16711686: 
      do
      {
        return;
        r(paramMessage.arg1);
        return;
        bC();
        return;
        i(2);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
        aN();
      } while (this.jdField_a_of_type_Long != 0L);
      k(2131230744);
      return;
    }
    a(0, null, -1L);
  }
  
  private void e(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131369487: 
    case 2131369878: 
    case 2131370317: 
    case 2131380148: 
    case 2131369501: 
    case 2131378647: 
    case 2131379487: 
      do
      {
        return;
        if ((!this.G) && (BaseChatItemLayout.jdField_a_of_type_Boolean))
        {
          a(false, null, false);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
          {
            paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F8", "0X80064F8", 0, 0, paramView, "", "", "");
          }
        }
        for (;;)
        {
          try
          {
            paramView = this.jdField_a_of_type_AndroidWidgetTextView.getTag();
            localObject = (String[])paramView;
            if ((paramView == null) || (!"comic".equals(localObject[0]))) {
              break;
            }
            VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", localObject[1], new String[] { "1" });
            return;
          }
          catch (Exception paramView)
          {
            paramView.printStackTrace();
            return;
          }
          e(false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
          this.O = true;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.d();
        }
        z();
        paramView = ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        Object localObject = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
        QLog.d("850_reportEvent", 1, "report click setting: curType = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", mEntryFriendCard = " + this.O + ", reportType = " + paramView + ", strCurT = " + (String)localObject);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, paramView, "", (String)localObject, "");
        AIODtReportHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject);
        return;
      } while (this.G);
      a(paramView);
      return;
    }
    aU();
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if ((paramBoolean2) && (H()))
      {
        f(false);
        this.Y = false;
      }
      if (((IDPCApi)QRoute.api(IDPCApi.class)).isFeatureSupported(DPCNames.aio_input.name())) {
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) || (this.Y)) && (H()))
        {
          f(false);
          this.Y = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initAudioPanelFlag needShowAudioWhenResume  = " + this.Y);
      }
      return;
      this.Y = true;
      continue;
      if ((this.Y) && (H()))
      {
        f(true);
        this.Y = false;
      }
    }
  }
  
  private boolean e(android.os.Message paramMessage)
  {
    long l1;
    if (paramMessage.what == 16711697)
    {
      l1 = System.currentTimeMillis();
      if (l1 - this.jdField_c_of_type_Long >= 1000L) {
        break label46;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "MSG_BUBBLE_CACHE_UPDATE, frequency limit, abort");
      }
    }
    label46:
    boolean bool;
    do
    {
      do
      {
        return false;
        this.jdField_c_of_type_Long = l1;
        if (this.jdField_c_of_type_Int == 0) {
          break;
        }
        this.jdField_u_of_type_Boolean = true;
      } while (!QLog.isColorLevel());
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "MSG_BUBBLE_CACHE_UPDATE, scrolling, abort");
      return false;
      bool = VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "MSG_BUBBLE_CACHE_UPDATE, needRefresh=" + bool);
      }
    } while (!bool);
    g(196608);
    return false;
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    if (((paramInt1 == 21) || (paramInt2 == 21)) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel);
    }
    Object localObject = (ISpriteUtil)QRoute.api(ISpriteUtil.class);
    if ((((ISpriteUtil)localObject).canUseCmShow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!((ISpriteUtil)localObject).isSpriteHidden(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      localObject = ((ISpriteUtil)localObject).getActionScript(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt1 != 21) {
        break label191;
      }
      if (localObject != null) {
        ((ISpriteActionScript)localObject).a(1);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null)
      {
        paramInt2 = 0;
        paramInt1 = paramInt2;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
        {
          paramInt1 = paramInt2;
          if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
          {
            paramInt1 = paramInt2;
            if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
              paramInt1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTop();
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt1);
      }
      return;
      label191:
      if ((paramInt2 == 21) && (localObject != null)) {
        ((ISpriteActionScript)localObject).a(2);
      }
    }
  }
  
  private void f(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onClick case R.id.input");
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.e();
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return;
    } while (!HiBoomHelper.a(a(), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), b()));
    if (!ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131701059), 0).a();
      ReportController.b(a(), "dc00898", "", "", "0X800932D", "0X800932D", 0, 0, "", "", "", "");
      return;
    }
    if (com.tencent.mobileqq.text.TextUtils.isContainComplexScript(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131701031), 0).a();
      return;
    }
    boolean bool;
    if (!this.K)
    {
      bool = true;
      this.K = bool;
      bV();
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(this.K);
      if (!this.K) {
        break label370;
      }
      paramView = (AIOEmoticonUIHelper)a(105);
      if (paramView != null) {
        paramView.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b(a());
      }
      if (((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).isSpriteHidden(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label365;
      }
    }
    label365:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0) {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "zhitu", true);
      }
      HiBoomManager.c.set(false);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(28, false);
      return;
      bool = false;
      break;
    }
    label370:
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  private boolean f(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 100: 
      if (ResponseHandler.a(0)) {
        WeiyunSaveTipsFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), a());
      }
      return true;
    }
    int i1 = paramMessage.arg1;
    if (ResponseHandler.a(i1))
    {
      if (!ResponseHandler.d(i1)) {
        break label82;
      }
      ResponseHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      return true;
      label82:
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(a());
    }
  }
  
  private void g(View paramView)
  {
    Intent localIntent = (Intent)paramView.getTag();
    localIntent.putExtra("message_box_click", true);
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
    paramView.setVisibility(8);
    if (this.jdField_m_of_type_AndroidViewView != null) {
      this.jdField_m_of_type_AndroidViewView.setVisibility(8);
    }
    int i1 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localIntent);
    if (i1 == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "openAIO by start SplashAct");
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    }
    while (i1 != 2)
    {
      if ((localIntent.getBooleanExtra("finishAIO", false)) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " onClick R.id.msgbox ");
      }
      return;
    }
    QLog.e(this.jdField_b_of_type_JavaLangString, 1, "openAIO rediectToAIOWithMt 2");
  }
  
  private boolean g(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 16711681: 
      paramMessage = (String)paramMessage.obj;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessage)) {
        b(1);
      }
      return true;
    case 14: 
      c(paramMessage.arg1, paramMessage.arg2);
      return true;
    case 23: 
      n(0);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      return true;
    case 16711696: 
      b(1);
      return true;
    case 24: 
      if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698461, 0).b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131299166));
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("nickCount", paramMessage.arg1 + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeOut", false, 30000L, 0L, localHashMap, "");
      return true;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    return true;
  }
  
  private void h(Intent paramIntent)
  {
    boolean bool2 = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = paramIntent.getIntExtra("uintype", -1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      QIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      TIMUserManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1026)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 1;
      if (QLog.isDevelopLevel()) {
        QLog.i("PttShow", 4, "UIN_TYPE_HOTCHAT_TOPIC in aio");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_JavaLangString = paramIntent.getStringExtra("phonenum");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int = paramIntent.getIntExtra("entrance", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 3999);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int = paramIntent.getIntExtra("key_confess_topicid", 0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c();
    this.jdField_l_of_type_Int = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.jdField_m_of_type_Int = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("isBack2Root", false);
    this.jdField_f_of_type_Boolean = paramIntent.getBooleanExtra("open_chat_from_voice_changer_guide", false);
    if (!this.jdField_f_of_type_Boolean)
    {
      bool1 = true;
      this.N = bool1;
      if (paramIntent.getLongExtra("res_share_id", -1L) != -1L) {
        this.jdField_l_of_type_Boolean = paramIntent.getExtras().containsKey("res_share_id");
      }
      if (!this.jdField_l_of_type_Boolean) {
        this.jdField_l_of_type_Boolean = paramIntent.getBooleanExtra("is_share_flag", false);
      }
      if ("qzoneShareTopic".equals(paramIntent.getStringExtra("share_qq_ext_str"))) {
        this.jdField_l_of_type_Boolean = false;
      }
      this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("thridparty_pull_aio", false);
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
      boolean bool3 = paramIntent.getBooleanExtra("need_jump_to_msg", false);
      if (paramIntent.getIntExtra("aio_msg_source", 999) != 1) {
        break label489;
      }
      bool1 = true;
      label406:
      this.jdField_x_of_type_Boolean = bool1;
      if ((this.jdField_x_of_type_Boolean) || (bool3))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramIntent);
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b() <= -1L) {
          break label494;
        }
      }
    }
    label489:
    label494:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramIntent.b(bool1);
      AIOUtils.jdField_o_of_type_Boolean = false;
      this.jdField_y_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(2);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label406;
    }
  }
  
  private void i(Intent paramIntent)
  {
    n(0);
    ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    String str = paramIntent.getStringExtra("input_text");
    paramIntent.removeExtra("input_text");
    if (str != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str);
    }
    while (TopicReplyUtil.a(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent())) {
      return;
    }
    x();
  }
  
  private void i(String paramString)
  {
    if (paramString != null)
    {
      if ((this.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)))) {
        break label330;
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
        break label184;
      }
      this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
    }
    for (;;)
    {
      QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error. bErrMsg=" + paramString + ", show Again img=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return;
      label184:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    label330:
    QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error.. bErrMsg=" + paramString + ", afRoot=" + this.jdField_d_of_type_AndroidViewViewGroup + ", sessionInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  private void j(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(null);
    }
    long l1 = paramIntent.getLongExtra("res_share_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_otherThings appShareId=" + l1);
    }
    if (l1 > 0L) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.14(this, paramIntent), 20L);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(4);
    if (paramIntent.getIntExtra("entrance", 0) == 9)
    {
      this.G = true;
      at();
      return;
    }
    this.G = false;
  }
  
  private void k(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getStringExtra("nearby_profile_nickname");
      if ((paramIntent != null) && (!paramIntent.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResult new nick is " + paramIntent);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.post(new BaseChatPie.25(this));
      }
    }
  }
  
  private void l(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("input_full_screen_mode", false))) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        paramIntent = paramIntent.getStringExtra("input_full_screen_mode_result");
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResult fullInputMode " + paramIntent);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramIntent);
        ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a(localArrayList, false);
      }
      return;
    }
  }
  
  private void m(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResult() ENTER_CHATOPTION_REQUEST");
    }
    aL();
    if ((paramIntent != null) && (paramIntent.getExtras() != null)) {}
    for (boolean bool = paramIntent.getExtras().getBoolean("isNeedFinish");; bool = false)
    {
      if (bool) {
        b(1);
      }
      for (;;)
      {
        ((HiddenChatHelper)a(39)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
        return;
        c(false, false);
      }
    }
  }
  
  private void n(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = null;
    }
    if (paramIntent != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LBS", 2, "onActivityResult ChatActivityConstants.LBS_REQUEST");
      }
      Bundle localBundle = paramIntent.getExtras();
      if (localBundle != null)
      {
        String str4 = localBundle.getString("latitude");
        String str5 = localBundle.getString("longitude");
        String str6 = localBundle.getString("description");
        String str7 = localBundle.getString("title");
        String str8 = localBundle.getString("summary");
        String str9 = localBundle.getString("dianping_id");
        String str1 = localBundle.getString("poiId");
        String str2 = localBundle.getString("latSpan");
        String str3 = localBundle.getString("lngSpan");
        if ((str1 != null) && (str2 != null))
        {
          paramIntent = str3;
          if (str3 != null) {}
        }
        else
        {
          str1 = "";
          str2 = "";
          paramIntent = "";
        }
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str4, str5, str6, str7, str8, str9, str1, str2, paramIntent, localBundle);
      }
    }
  }
  
  private void o(Intent paramIntent)
  {
    int i1 = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int != i1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = i1;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    }
    if (paramIntent != null)
    {
      i1 = paramIntent.getIntExtra("uin_type", 0);
      String str = paramIntent.getStringExtra("peeruin");
      long l1 = paramIntent.getLongExtra("uniseq", 0L);
      d((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str, i1, l1));
    }
  }
  
  private void p(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onActivityResulte() REQUEST_OPEN_SHORT_VIDEO_PLAYER...");
    }
    c(false, false);
    try
    {
      paramIntent = paramIntent.getStringExtra("babyq_video_type");
      if (!android.text.TextUtils.isEmpty(paramIntent))
      {
        int i1 = Integer.parseInt(paramIntent);
        paramIntent = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
        if (paramIntent != null) {
          paramIntent.a(i1);
        }
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void q(Intent paramIntent)
  {
    try
    {
      int i1 = Integer.parseInt(paramIntent.getStringExtra("babyq_video_type"));
      paramIntent = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (paramIntent != null) {
        paramIntent.a(i1);
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QLog.d(this.jdField_b_of_type_JavaLangString, 1, "doOnActivityResult exception!", paramIntent);
    }
  }
  
  private void r(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.jdField_p_of_type_Boolean))
    {
      int i1 = paramIntent.getInt("aio_msg_source", 999);
      paramIntent = ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      QLog.d("850_reportEvent", 1, " AIO_MSG_SOURCE : " + i1 + ", reportType  = " + paramIntent);
      String str = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "AIO", "AIO_appear", 0, 0, paramIntent, String.valueOf(i1), str, "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, paramIntent, String.valueOf(i1), str, "");
      return;
    }
    QLog.d("850_reportEvent", 1, "do not need to report");
  }
  
  private void s(Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    if (G()) {}
    label11:
    do
    {
      do
      {
        break label11;
        do
        {
          return;
        } while ((this.jdField_r_of_type_Boolean) || (F()));
        if (!this.jdField_f_of_type_Boolean) {
          break;
        }
        e(false, false);
      } while (this.Y);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
      this.N = true;
      return;
    } while (a(paramIntent));
    boolean bool2;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_g_of_type_Boolean))
    {
      paramIntent = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        bool2 = b(paramIntent);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseChatInputType doChooseNoC2CInputType needGuide = " + bool2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      d(false, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseC2CChatInputType cost :" + (System.currentTimeMillis() - l1));
      return;
      if (E())
      {
        bool2 = a(paramIntent);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseChatInputType doChooseC2CInputType needGuide = " + bool2);
        bool1 = bool2;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (QLog.isColorLevel())) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "chooseC2CChatInputType isSimpleBar = " + this.jdField_g_of_type_Boolean);
        }
      }
      bool1 = false;
    }
  }
  
  private void t(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "mActivity == null");
      }
    }
    while (((HiddenChatHelper)a(39)).a()) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      b(1);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  private void u(boolean paramBoolean)
  {
    if ((!paramBoolean) && (t())) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2130839715, this.jdField_a_of_type_AndroidContentContext.getString(2131720242), 0).b(a());
    }
  }
  
  private void v(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() != paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onLayoutChange() update list.paddingBottom from " + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingBottom() + " to " + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setPadding(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingLeft(), this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingTop(), this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getPaddingRight(), paramInt);
    }
  }
  
  private void w(int paramInt)
  {
    if (paramInt == 2000) {
      ((HiddenChatHelper)a(39)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    }
  }
  
  private void x(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    bA();
  }
  
  private void y(int paramInt)
  {
    if (paramInt == 1) {
      bM();
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
      return;
    }
    bM();
  }
  
  private void z(int paramInt)
  {
    PttUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
  }
  
  protected void A()
  {
    int i1;
    Object localObject;
    if ((this.jdField_d_of_type_Boolean) && (!BaseChatItemLayout.jdField_a_of_type_Boolean))
    {
      int i2 = QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      i1 = 0;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localObject != null) {
        i1 = ((QQMessageFacade)localObject).b();
      }
      i1 = i2 + i1;
      localObject = (TempMsgBoxAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(95);
      if (localObject == null) {
        break label250;
      }
      i1 = ((TempMsgBoxAIOHelper)localObject).a(i1);
    }
    label250:
    for (;;)
    {
      localObject = "";
      String str1;
      if (i1 > 0)
      {
        localObject = "" + i1;
        if (i1 > 99) {
          localObject = "99+";
        }
        str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719718) + "(" + (String)localObject + ")";
      }
      for (String str2 = HardCodeUtil.a(2131701050) + this.jdField_a_of_type_AndroidContentContext.getString(2131719718) + i1 + "条未读";; str2 = HardCodeUtil.a(2131701055) + this.jdField_a_of_type_AndroidContentContext.getString(2131719718))
      {
        a(str1, str2, (String)localObject);
        return;
        str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131719718);
      }
    }
  }
  
  public boolean A()
  {
    return this.jdField_a_of_type_Int != 2;
  }
  
  protected void B()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850547, 2130850548);
  }
  
  public boolean B()
  {
    return OneWayFriendHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  protected void C()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
  }
  
  public boolean C()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void D()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.jdField_a_of_type_AndroidContentContext, 2131755176);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setBackgroundResource(2130838186);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.1F, 1.0F);
      localAlphaAnimation.setDuration(500L);
      localImageView.startAnimation(localAlphaAnimation);
      this.jdField_a_of_type_AndroidAppDialog.setContentView(localImageView, new ViewGroup.LayoutParams(-1, -1));
    }
    try
    {
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "showPttMaskDialog", localException);
    }
  }
  
  public boolean D()
  {
    return (this.jdField_c_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null);
  }
  
  public void E()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "dismissPttMaskDialog", localException);
    }
  }
  
  protected void F() {}
  
  public void G()
  {
    ((AIOEmoticonGuideHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(54)).b();
  }
  
  public void H()
  {
    C(8);
    PhotoListHelper localPhotoListHelper = (PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7);
    if (localPhotoListHelper != null) {
      localPhotoListHelper.d();
    }
  }
  
  public void I()
  {
    if (this.F) {
      C(0);
    }
  }
  
  @TargetApi(11)
  public void J()
  {
    M = false;
    if (this.I) {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "doOnDestroy return");
      }
    }
    do
    {
      return;
      this.I = true;
      URLDrawable.resume();
      this.jdField_d_of_type_Int = 9;
      AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnDestroy", hashCode(), this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().h();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(0, 0L);
      bs();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.b();
      bo();
      o();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.b();
      }
      am();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
      bu();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().e();
      bq();
      Object localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER);
      ((EmoticonManager)localObject).b();
      ((EmoticonManager)localObject).c();
      EmojiStickerManager.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_w_of_type_Boolean);
      bv();
      PokeItemHelper.a();
      PokeItemHelper.b();
      PokeItemAnimationManager.a().a(3);
      PokeItemAnimationManager.a().a(6);
      PokeItemAnimationManager.a().a(12);
      PokeItemAnimationManager.a().a(15);
      PokeItemAnimationManager.a().a(18);
      PokeItemAnimationManager.a().a(9);
      if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null)
      {
        localObject = HotPicManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (localObject != null) {
          ((HotPicManager)localObject).a(false);
        }
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      bm();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatActivity.class);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
      }
      ChatActivityUtils.b();
      ChatActivityFacade.a();
      br();
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      if (this.jdField_n_of_type_AndroidWidgetTextView != null) {
        this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.b();
      bn();
      if (AITranslator.a()) {
        AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext, true);
      }
      this.Q = false;
      this.jdField_n_of_type_Int = 60;
      this.jdField_p_of_type_Int = 0;
      this.jdField_r_of_type_Int = 0;
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      AioAnimationDetector.a().a();
      ThridAppShareHelper.a().a();
      Scroller.b(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPicPreDownloader().c();
      PttSSCMPool.a();
      RichStatItemBuilder.jdField_a_of_type_Long = 0L;
      if (jdField_t_of_type_Int == 1) {
        s(0);
      }
      ChatActivityUtils.a();
      ThreadPriorityManager.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache.a();
      NowVideoController.a().c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b();
      bp();
      BaseActivity.sActivityRoute.remove(getClass().getSimpleName());
      localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
      if (localObject != null) {
        ((AIOAnimationControlManager)localObject).c();
      }
      AIOSingleReporter.a().a();
      aN();
      DoutuManager.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a());
      if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.a();
        this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager = null;
      }
      HotPicPageView.c();
      PresenceInterfaceImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QIMUserManager.a().a(false);
      bt();
      CustomizeStrategyFactory.a().a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(14);
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      aX();
      if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
      }
      UniteGrayTipUtil.b();
      this.jdField_i_of_type_Int = 0;
      this.T = false;
      this.U = false;
      VasUtils.a();
      this.jdField_i_of_type_AndroidViewView = null;
      this.jdField_j_of_type_AndroidViewView = null;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = 0;
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView != null)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.c();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.e();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer = null;
      }
    } while (!(this.jdField_f_of_type_AndroidWidgetTextView instanceof OnlineStatusLyricView));
    ((OnlineStatusLyricView)this.jdField_f_of_type_AndroidWidgetTextView).d();
  }
  
  @Deprecated
  public void K()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) {
      bool = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a();
    }
    if (!bool)
    {
      PokeItemHelper.a();
      PokeItemHelper.b();
      PokeItemAnimationManager.a().a();
      b(1);
    }
  }
  
  public void L()
  {
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    String str = localIntent.getStringExtra("key_nearby_qzone_to_aio");
    if ((str != null) && (str.equals("nearby_qzone_to_aio")))
    {
      str = localIntent.getStringExtra("uin");
      localIntent.putExtra("key_has_talk", LBSHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(-1, localIntent);
    }
  }
  
  public void M()
  {
    this.jdField_d_of_type_Int = 3;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnStart", hashCode(), this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(5);
  }
  
  public void N()
  {
    this.jdField_d_of_type_Int = 6;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnStop", hashCode(), this.jdField_d_of_type_Int);
    this.jdField_p_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
      ai();
    }
    aB();
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {}
    for (Object localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();; localObject = null)
    {
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean)) {
        a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager, (Spanned)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, null);
      }
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow() != null)) {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().setSoftInputMode(32);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.a();
      }
      String str;
      int i1;
      ReadinjoySPEventReport localReadinjoySPEventReport;
      if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null))
      {
        str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
        i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
        localReadinjoySPEventReport = ReadinjoySPEventReport.a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) {
          break label279;
        }
      }
      label279:
      for (localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();; localObject = null)
      {
        localReadinjoySPEventReport.a(0, (List)localObject, str, i1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a());
        ShortVideoItemBuilder.g();
        ShortVideoRealItemBuilder.g();
        ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).releaseAllBrickPlayer();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(11);
        return;
      }
    }
  }
  
  public void O()
  {
    this.jdField_d_of_type_Int = 5;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnPause", hashCode(), this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b();
    ArkAioContainerWrapper.a(0);
    ArkFlashChatContainerWrapper.a(0);
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    if (!t()) {
      AbstractVideoImage.pauseAll();
    }
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    ShortVideoItemBuilder.e();
    ShortVideoRealItemBuilder.e();
    ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).pauseAllBrickPlayer();
    ((FastImageHelper)a(83)).b(true);
    ThreadManager.post(new BaseChatPie.21(this), 5, null, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b()) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.b();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.h();
    }
    this.jdField_p_of_type_Boolean = false;
    if (this.O)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.O = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.e(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(10);
    if (a()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.d();
    }
  }
  
  protected void P()
  {
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    ((SimpleUIAIOHelper)a(29)).a(this.jdField_a_of_type_AndroidWidgetTextView);
    ArkAioContainerWrapper.a(1);
    ArkFlashChatContainerWrapper.a(1);
    Q();
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0)) {
      this.jdField_e_of_type_Int = 0;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) && (c() <= 0)) {
        break label299;
      }
    }
    label299:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      StartupTracker.a("AIO_doOnResume_updateUI", null);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i2 = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299166);
      int i1 = i2;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
      {
        i1 = i2;
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) {
          i1 = i2 + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297098);
        }
      }
      localLayoutParams.topMargin = i1;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      aP();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(6);
      if (a())
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setDebugTag("AIO." + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + "." + MsfSdkUtils.getShortUin(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.a();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.c();
      }
      return;
    }
  }
  
  public void Q()
  {
    AIOLongShotHelper localAIOLongShotHelper = AIOLongShotHelper.a();
    if ((localAIOLongShotHelper != null) && (localAIOLongShotHelper.a()) && (localAIOLongShotHelper.b()))
    {
      QLog.i(this.jdField_b_of_type_JavaLangString, 1, "loadBackgroundAsync: skip for mosaic is on");
      return;
    }
    ThreadManager.postImmediately(new BaseChatPie.24(this), null, true);
  }
  
  public void R()
  {
    this.jdField_d_of_type_Int = 4;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnResume", hashCode(), this.jdField_d_of_type_Int);
    P();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.jdField_v_of_type_Boolean)
    {
      AIOUtils.a(true);
      this.jdField_w_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        PAStartupTracker.a(null, "pubAcc_structMsg_display", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      synchronized (QQMessageFacade.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_d_of_type_JavaLangRunnable, 800L);
        this.jdField_v_of_type_Boolean = false;
        if (((IDPCApi)QRoute.api(IDPCApi.class)).isInited()) {
          bF();
        }
        this.O = false;
        this.jdField_k_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLoudSpeakerState();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this);
        NowVideoController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        QQLSRecentManager.jdField_f_of_type_Boolean = true;
        ThreadRegulator.a().a(1, 1500L);
        r(((AIOLongShotHelper)a(15)).c());
        ((SimpleUIAIOHelper)a(29)).a(a());
        return;
      }
      g(131072);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow right now");
      }
      ae();
    }
  }
  
  public void S()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(21);
    AIOUtils.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(false);
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d();
    this.jdField_l_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = true;
    this.jdField_t_of_type_Boolean = true;
    this.jdField_u_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.C = false;
    this.H = true;
    this.Y = false;
    this.Z = true;
    this.R = true;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_w_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_i_of_type_AndroidWidgetTextView = null;
      this.jdField_m_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_j_of_type_AndroidWidgetTextView = null;
      this.jdField_k_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(4);
      this.jdField_e_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.c();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().g();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b(a());
    }
    aM();
  }
  
  public void T()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "return MainFragment");
    }
    Object localObject;
    FragmentTransaction localFragmentTransaction;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      Fragment localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      localFragmentTransaction.setCustomAnimations(2130772061, 2130772053);
      SplashActivity.currentFragment = 1;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("isFromAioFragment", true);
      if (localFragment != null)
      {
        localFragmentTransaction.show(localFragment);
        localFragmentTransaction.hide((Fragment)localObject);
        if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
            break label199;
          }
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        }
        label164:
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    for (;;)
    {
      SceneTracker.a().b("ChatFragment");
      return;
      localFragmentTransaction.add(16908290, MainFragment.a(), MainFragment.class.getName());
      break;
      label199:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
      {
        ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        break label164;
      }
      ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
      break label164;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "returnMainFragment() mActivity instanceof ChatActivity ");
      }
    }
  }
  
  protected void U()
  {
    try
    {
      if (this.jdField_v_of_type_Int == 0)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
        localIntentFilter.addAction("android.intent.action.PHONE_STATE");
        localIntentFilter.addAction("vivo_smart_shot_enter");
        localIntentFilter.addAction("com.huawei.hwmultidisplay.action.WINDOW_CAST_MODE");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_v_of_type_Int = 1;
      }
      for (;;)
      {
        AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this);
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "AIOTime doOnRegReceivershashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "registerReceiver but done");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "registerReceiver " + localException);
        }
      }
    }
  }
  
  protected void V()
  {
    try
    {
      if (this.jdField_v_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_v_of_type_Int = 0;
      }
      for (;;)
      {
        boolean bool = AppNetConnInfo.unregisterNetInfoHandler(this);
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "AIOTime doOnUnRegReceivers :" + bool + "hashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "unRegisterReceiver but cannot");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(this.jdField_b_of_type_JavaLangString, 2, "unregisterReceiver:" + localException);
        }
      }
    }
  }
  
  protected void W()
  {
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
    ThreadPriorityManager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
  }
  
  public void X() {}
  
  public void Y()
  {
    this.D = ThemeUtil.isDefaultOrDIYTheme(false);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "isThemeDefault" + this.D);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_Boolean = false;
      if (ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground))
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
          break label279;
        }
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.d();
      }
      try
      {
        aP();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130851153, 2130851154);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850547, 2130850548);
        }
        ((ChatPieSelectableHelper)a(4)).b();
        ((SimpleUIAIOHelper)a(29)).a(a());
        ArkAppCenterUtil.a();
        AIOMusicSkin.a().b(a(), this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
        return;
        label279:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
        {
          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850444));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
          continue;
        }
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onPostThemeChanged e:" + localException.getMessage() + "isThemeDefault" + this.D);
        }
      }
    }
  }
  
  public void Z()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  public int a()
  {
    return AIOUtils.a(this.jdField_a_of_type_AndroidContentContext);
  }
  
  protected int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  protected int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    paramInt2 = paramInt1 + paramInt2 - paramInt4 - paramInt5;
    paramInt1 = paramInt2;
    if (paramInt2 >= paramInt3 - paramInt5 - paramInt4) {
      paramInt1 = paramInt6 - 1;
    }
    if (paramInt1 >= paramInt8)
    {
      paramInt1 += paramInt4;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1));
    }
    for (;;)
    {
      if (paramInt7 == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt6, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt6));
        paramInt1 = paramInt6;
      }
      long l1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
      long l2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1);
      paramInt2 = paramInt1;
      if (l1 > 0L)
      {
        paramInt2 = paramInt1;
        if (l1 != l2)
        {
          paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(l1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt2, l1);
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "doUpdateUnreadBubble. after revise readCnt =", Integer.valueOf(paramInt2) });
        }
      }
      return paramInt6 - paramInt2;
      paramInt1 = paramInt8;
    }
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public Dialog a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt);
  }
  
  public View a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramInt);
    if (localObject != null)
    {
      if ((localObject instanceof PlusPanel)) {
        ((PlusPanel)localObject).setOneWayFriend(B());
      }
      return localObject;
    }
    long l1;
    if (paramInt == 36)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel = ((VoiceTextPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558701, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "openVoiceTextEditPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel;
    }
    if (paramInt == 2)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131561057, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
      r(-1);
      if (this.F) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setReceiptMode(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenAudioPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    }
    if (paramInt == 14)
    {
      if (!v()) {
        return null;
      }
      l1 = System.currentTimeMillis();
      localObject = ((PhotoListHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7)).a(hashCode());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, true, (Intent)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenFlashPicPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
    if (paramInt == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel = new AIOFakePanel(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel;
    }
    if (paramInt == 21)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel = ((ApolloPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558624, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_x_of_type_Int, this.jdField_w_of_type_Int, this.jdField_y_of_type_Int);
      StartupTracker.a("apollo_panel_open", null);
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel;
    }
    if (paramInt == 22) {
      return this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    }
    if (paramInt == 24)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = ((HotPicMainPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558648, null));
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
      return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
    }
    if (paramInt == 18)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel = ((DoodlePanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131558632, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, new BaseChatPie.48(this));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel;
    }
    if (paramInt == 28)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel = new RichTextPanel(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.a(this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel;
    }
    return null;
  }
  
  public ViewGroup a()
  {
    return this.jdField_c_of_type_AndroidViewViewGroup;
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public TroopGiftAioPanelData a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      return this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
    }
    return null;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public AIOAnimationConatiner a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  }
  
  protected AIOContext a()
  {
    return new AIOContext(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
  }
  
  protected MsgList a()
  {
    return new MsgListBuilder(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext).a(new Scroller()).a(new ListUI(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a(new UnreadTask(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext)).a();
  }
  
  public BaseChatDrawer a()
  {
    return null;
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt);
  }
  
  public StructingMsgItemBuilder.ViewCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  }
  
  public PanelManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager;
  }
  
  public ArkTipsBar a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar = new ArkTipsBar(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar);
    }
    boolean bool;
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder().append("showArkTips : hide? :");
      if (paramString == null)
      {
        bool = true;
        QLog.d(str, 2, bool + ",mID=" + paramLong);
      }
    }
    else
    {
      if (paramString != null) {
        break label119;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar;
      bool = false;
      break;
      label119:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar, new Object[] { paramString, Long.valueOf(paramLong) });
    }
  }
  
  public LocationShareTipsBar a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar;
  }
  
  public TipsManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  }
  
  public BaseActivity a()
  {
    return this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  }
  
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public MessageForArkApp a(ArkAppContainer paramArkAppContainer)
  {
    Object localObject;
    if (paramArkAppContainer == null)
    {
      localObject = null;
      return localObject;
    }
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a().iterator();
    MessageForArkApp localMessageForArkApp;
    do
    {
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (ChatMessage)localIterator.next();
          } while (!(localObject instanceof MessageForArkApp));
          localMessageForArkApp = (MessageForArkApp)localObject;
          localObject = localMessageForArkApp;
          if (localMessageForArkApp.arkContainer == paramArkAppContainer) {
            break;
          }
        } while (localMessageForArkApp.mExtendMsgArkAppList == null);
        localObject = localMessageForArkApp.mExtendMsgArkAppList.iterator();
      }
    } while (((MessageForArkApp)((Iterator)localObject).next()).arkContainer != paramArkAppContainer);
    return localMessageForArkApp;
    return null;
  }
  
  public MagicfaceViewController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = new MagicfaceViewController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  }
  
  public EntryModel a()
  {
    return new EntryModel(-1, 0L, "", false);
  }
  
  public TroopGiftAnimationController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = new TroopGiftAnimationController(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
  }
  
  public RecordParams.RecorderParam a()
  {
    return new RecordParams.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
  }
  
  public XPanelContainer a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer;
  }
  
  protected Boolean a()
  {
    return null;
  }
  
  protected String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  protected String a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    return ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public final List<ChatMessage> a()
  {
    return a(false);
  }
  
  protected final List<ChatMessage> a(boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramBoolean);
  }
  
  public final MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(3);
    b(false, false);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramInt1, paramInt2);
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    if ((paramInt1 == 2) && (paramInt2 != 2)) {
      jdField_z_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a(paramInt1, paramInt2);
    }
    boolean bool;
    if (paramInt1 == 24) {
      if (paramInt2 == 1)
      {
        bool = true;
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(bool);
        label74:
        if (paramInt2 != 18) {
          break label241;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.b();
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
        }
        as();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.b();
        label113:
        if (paramInt2 != 1) {
          break label280;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.c(false);
        }
      }
    }
    for (;;)
    {
      ((ChatPieSelectableHelper)a(4)).a();
      return;
      bool = false;
      break;
      if (paramInt1 == 18)
      {
        if (paramInt2 == 1) {}
        for (bool = true;; bool = false)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(bool);
          if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
            this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.c();
          }
          ar();
          break;
        }
      }
      if ((paramInt1 != 28) || (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel == null)) {
        break label74;
      }
      if (paramInt2 == 1) {}
      for (bool = true;; bool = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.c(bool);
        break;
      }
      label241:
      if (paramInt2 == 24)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.f();
        break label113;
      }
      if ((paramInt2 != 28) || (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel == null)) {
        break label113;
      }
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.d();
      break label113;
      label280:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) && (!this.jdField_a_of_type_ComTencentWidgetXPanelContainer.d())) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.c(true);
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a();
    Object localObject;
    android.os.Message localMessage;
    if (i1 < paramInt6)
    {
      i1 = a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, i1);
      if (i1 != this.jdField_k_of_type_Int)
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(13)) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
        }
        int i2 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(), i1);
        localObject = this.jdField_a_of_type_MqqOsMqqHandler;
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(13, i2, paramInt7);
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
          break label190;
        }
      }
    }
    label190:
    for (long l1 = 1500L;; l1 = 0L)
    {
      ((MqqHandler)localObject).sendMessageDelayed(localMessage, l1);
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_k_of_type_Int = i1;
      localObject = (UnreadBackBottomHelper)a(53);
      if (localObject != null)
      {
        ((UnreadBackBottomHelper)localObject).b(this.jdField_k_of_type_Int);
        ((UnreadBackBottomHelper)localObject).a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
      }
      return;
      i1 = 0;
      break;
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[doOnActivityResult], requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
    }
    boolean bool = false;
    p();
    int i1;
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      i1 = paramIntent.getIntExtra("camera_type", 1);
      bool = paramIntent.getExtras().getBoolean("progress2View");
      if ((paramInt1 == 11000) && (i1 == 103)) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      a(paramInt1, paramInt2, paramIntent, bool, i1);
      return;
      continue;
      i1 = 1;
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord)
  {
    a(paramInt1, paramLong, paramInt2, paramMessageRecord, 0, 0);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt1, paramLong, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Dialog paramDialog)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramInt, paramDialog);
  }
  
  public final void a(int paramInt, MessageHandler.MsgSendCostParams paramMsgSendCostParams, long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt, paramMsgSendCostParams, paramLong);
  }
  
  protected void a(int paramInt, String paramString, long paramLong)
  {
    switch (paramInt)
    {
    case 1: 
    default: 
    case 0: 
      do
      {
        return;
      } while ((paramString == null) || (paramLong == 0L));
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "disPlayAudioRecord updatePttRecordMessage: " + paramString);
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, -3, paramLong);
      c(true, true);
      return;
    }
    if (paramString != null)
    {
      paramString = StreamDataManager.a(paramString);
      if ((paramString != null) && (paramString.exists())) {
        paramString.delete();
      }
    }
    if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711688)) {
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711688, 1000L);
    }
    if (paramLong != 0L)
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      paramString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(paramString, paramInt, paramLong);
    }
    c(true, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null)
      {
        ((SystemBarCompact)localObject).setStatusBarDrawable(null);
        ((SystemBarCompact)localObject).setStatusBarColor(paramInt);
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    if (!paramBoolean1) {
      break label7;
    }
    label7:
    label218:
    label223:
    label224:
    for (;;)
    {
      return;
      if (!paramBoolean2)
      {
        Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
        {
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
          if (localObject != null) {
            break label223;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
        }
        for (;;)
        {
          if (localObject == null) {
            break label224;
          }
          if (paramInt == 2)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((NoC2CExtensionInfo)localObject).isDataChanged) {
            if (((NoC2CExtensionInfo)localObject).audioPanelType == paramInt) {
              break label133;
            }
          }
          for (paramBoolean1 = true;; paramBoolean1 = false)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((NoC2CExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
          ExtensionInfo localExtensionInfo = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
          localObject = localExtensionInfo;
          if (localExtensionInfo == null) {
            localObject = this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
          }
          if (localObject == null) {
            break;
          }
          if (paramInt == 2)
          {
            ((ExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((ExtensionInfo)localObject).isDataChanged) {
            if (((ExtensionInfo)localObject).audioPanelType == paramInt) {
              break label218;
            }
          }
          for (paramBoolean1 = bool;; paramBoolean1 = false)
          {
            ((ExtensionInfo)localObject).isDataChanged = paramBoolean1;
            ((ExtensionInfo)localObject).audioPanelType = paramInt;
            return;
          }
        }
      }
    }
  }
  
  public final void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(paramLong);
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vivo", 2, "isPackageExist isVivoShot=" + jdField_t_of_type_Int);
    }
    if (jdField_t_of_type_Int != 0) {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    for (;;)
    {
      return;
      String str = Build.MANUFACTURER.toUpperCase();
      if ((!str.endsWith("BBK")) && (!str.endsWith("VIVO")))
      {
        jdField_t_of_type_Int = 2;
        return;
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext.getApplicationInfo(paramString, 8192);
        jdField_t_of_type_Int = 1;
        this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vivo", 2, " isPackageExist isScrollToButtom=" + this.jdField_b_of_type_JavaLangBoolean);
        return;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          jdField_t_of_type_Int = 2;
        }
      }
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = PlayModeUtils.b(paramBoolean1, paramBoolean2, paramBoolean3);
    int i2 = PlayModeUtils.a(paramBoolean1, paramBoolean2, paramBoolean3);
    if ((i1 > 0) && (this.jdField_i_of_type_Int != i2))
    {
      this.jdField_i_of_type_Int = i2;
      QQToast.a(paramContext, i1, 0).b(paramContext.getResources().getDimensionPixelSize(2131299166));
    }
  }
  
  protected void a(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130851153, 2130851154);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    c(true, false);
    b(paramIntent);
    b(false);
    t();
    this.jdField_g_of_type_Boolean = e();
    this.jdField_h_of_type_Boolean = d();
    i(paramIntent);
    e(paramIntent);
    B();
    v();
    r();
    w();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().d();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.a(paramIntent);
  }
  
  protected void a(Intent paramIntent, int paramInt)
  {
    int i1 = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "handleRequest requestCode " + i1);
    }
    if ((i1 == 2) || (i1 == 1)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.b(paramIntent);
    }
    if (paramInt == 1) {
      FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    while ((paramInt != 2) || (this.H)) {
      return;
    }
    FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "onConfigurationChanged");
    }
    ai();
    if (paramConfiguration.orientation == 2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7B", "0X8005C7B", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(19);
    ArkAppCenterUtil.a(paramConfiguration);
  }
  
  public void a(Drawable paramDrawable)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (localObject != null)
    {
      localObject = ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact;
      if (localObject != null) {
        ((SystemBarCompact)localObject).setStatusBarDrawable(paramDrawable);
      }
    }
  }
  
  protected void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramBundle));
    a(localIntent, false);
  }
  
  protected void a(Editable paramEditable)
  {
    boolean bool3 = true;
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "input stat is " + this.jdField_a_of_type_Int);
    }
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_g_of_type_Boolean)
      {
        if ((paramEditable.length() <= 0) && (c() <= 0)) {
          break label339;
        }
        bool1 = true;
        a(bool1);
      }
      localObject = (StickerRecHelper)a(14);
      if (localObject == null) {
        break label384;
      }
      ((StickerRecHelper)localObject).e();
    }
    label384:
    for (boolean bool1 = ((StickerRecHelper)localObject).a();; bool1 = false)
    {
      boolean bool2;
      if ((paramEditable.length() > 0) || (c() > 0))
      {
        bool2 = true;
        label127:
        a(bool2);
        SimpleUIAIOHelper localSimpleUIAIOHelper = (SimpleUIAIOHelper)a(29);
        if (paramEditable.length() <= 0) {
          break label349;
        }
        bool2 = true;
        label154:
        localSimpleUIAIOHelper.a(bool2);
        if (this.V)
        {
          if (paramEditable.length() <= 0) {
            break label354;
          }
          bool2 = bool3;
          label179:
          this.V = bool2;
        }
        b(paramEditable);
        e(paramEditable.toString());
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "check zhitu condition: " + paramEditable.length() + " / " + this.F + " / " + this.K);
        }
        if (bool1) {
          ((StickerRecHelper)localObject).b(paramEditable);
        }
        if (a(paramEditable))
        {
          if (!bool1) {
            break label359;
          }
          ((StickerRecHelper)localObject).a(paramEditable);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("afterTextChanged", 2, " afterTextChanged cost: " + (System.currentTimeMillis() - l1));
        }
        c(paramEditable);
        d(paramEditable);
        return;
        label339:
        bool1 = false;
        break;
        bool2 = false;
        break label127;
        label349:
        bool2 = false;
        break label154;
        label354:
        bool2 = false;
        break label179;
        label359:
        localObject = (AIOEmoticonUIHelper)a(105);
        if (localObject != null) {
          ((AIOEmoticonUIHelper)localObject).a(paramEditable);
        }
      }
    }
  }
  
  protected void a(MotionEvent paramMotionEvent)
  {
    ISpriteUIHandler localISpriteUIHandler;
    if ((!this.G) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      Object localObject = (ISpriteScriptManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      localISpriteUIHandler = ((ISpriteScriptManager)localObject).getUIHandler();
      localObject = ((ISpriteScriptManager)localObject).getSpriteContext();
      if ((localISpriteUIHandler != null) && (localObject != null))
      {
        if (QzoneConfig.getInstance().getConfig("CMShow", "AioCMShowHeightSwitch", 0) != 0) {
          break label94;
        }
        localISpriteUIHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    label94:
    while (!localISpriteUIHandler.a(paramMotionEvent, this.jdField_a_of_type_AndroidWidgetRelativeLayout)) {
      return;
    }
    localISpriteUIHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(View paramView) {}
  
  protected void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramImageView != null)
    {
      if (this.D) {
        paramImageView.setImageResource(paramInt2);
      }
    }
    else {
      return;
    }
    paramImageView.setImageResource(paramInt1);
  }
  
  protected void a(com.tencent.imcore.message.Message paramMessage)
  {
    if (this.G) {}
    while ((!BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage)) || (y()) || (NotifyIdManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramMessage)) || (((HiddenChatHelper)a(39)).a(paramMessage)) || (24 == this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a())) {
      return;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getIntentByMessage(this.jdField_a_of_type_AndroidContentContext, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    paramMessage = new BaseChatPie.29(this, paramMessage, localIntent);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(paramMessage);
  }
  
  public void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    paramSendMsgParams.jdField_b_of_type_Int = this.jdField_p_of_type_Int;
    paramSendMsgParams.jdField_a_of_type_Int = this.jdField_n_of_type_Int;
    paramSendMsgParams.jdField_c_of_type_Boolean = this.P;
    paramSendMsgParams.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
    paramSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
    paramSendMsgParams.jdField_h_of_type_Boolean = ChatPieInputHelper.a(this).jdField_a_of_type_Boolean;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.length() > jdField_j_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.substring(0, jdField_j_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType == -1036) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.oriMsgType = 1;
      }
    }
    paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
  }
  
  protected void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, Spanned paramSpanned, QQAppInterface paramQQAppInterface, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      Object localObject = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24);
      String str = ((FullScreenInputHelper)localObject).a(paramSpanned);
      paramSpanned = ((FullScreenInputHelper)localObject).a(paramSpanned);
      localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374320);
      ThreadManager.post(new SaveTextDraftJob(this, new SessionInfo(paramSessionInfo), paramDraftTextManager, str, paramSpanned, paramQQAppInterface, paramString1, paramSourceMsgInfo, localObject, paramString2), 8, null, false);
    }
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    paramApolloInfo.send(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    AioAnimationDetector.a().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    long l1 = System.currentTimeMillis();
    ThreadManager.post(new BaseChatPie.60(this, paramChatMessage), 8, null, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
  }
  
  public final void a(ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt, long paramLong, String paramString)
  {
    if ((paramChatMessage == null) || (paramChatMessage.senderuin == null)) {}
    do
    {
      return;
      paramString = ReplyMsgUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, paramInt, paramLong, paramString);
    } while (paramString == null);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = paramString;
    if (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTroopName))
    {
      paramString = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      paramString = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, paramInt - i1 * 2, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), paramString);
      if (paramString == null) {
        break label283;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, paramString.getDrawable(), null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawablePadding(20);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374320, paramString);
      this.jdField_a_of_type_AndroidTextMethodMovementMethod = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(ReplyClickMovementMethod.a());
      aZ();
      aX();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin)))) {
        l(false);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.70(this), 200L);
      MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramChatMessage);
      return;
      paramString = null;
      break;
      label283:
      if (this.jdField_a_of_type_AndroidTextMethodMovementMethod != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(this.jdField_a_of_type_AndroidTextMethodMovementMethod);
      }
    }
  }
  
  public void a(ChatMessage paramChatMessage, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int i6 = 1;
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
    int i1;
    int i3;
    int i2;
    int i4;
    if (!localAIOLongShotHelper.a()) {
      if (AIOUtils.a(1) == 0)
      {
        i1 = 1;
        if (i1 != 0)
        {
          paramChatMessage = MultiMsgManager.a().jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
          i3 = 0;
          i2 = 0;
          i1 = 1;
          if (!paramChatMessage.hasNext()) {
            break label275;
          }
          paramCompoundButton = (Map.Entry)paramChatMessage.next();
          if (!((Boolean)paramCompoundButton.getValue()).booleanValue()) {
            break label256;
          }
          i4 = i3 + 1;
          paramCompoundButton = (ChatMessage)paramCompoundButton.getKey();
          i3 = FlashPicHelper.a(paramCompoundButton) | i2;
          if ((!MultiMsgProxy.a(paramCompoundButton)) || (i4 > 1)) {
            i1 = 0;
          }
          if (i1 != 0) {
            break label208;
          }
        }
      }
    }
    for (;;)
    {
      if (i3 == 0)
      {
        i2 = i6;
        label150:
        ((AIOMultiActionHelper)a(66)).a(i1 & i2);
        i1 = MultiMsgManager.a().c();
        ((SelectToBottomHelper)a(40)).a(i1);
        label189:
        ((AIOMultiActionHelper)a(66)).c();
        return;
        i1 = 0;
        break;
        label208:
        i2 = i1;
        i1 = i4;
      }
      for (;;)
      {
        i4 = i3;
        int i5 = i2;
        i3 = i1;
        i2 = i4;
        i1 = i5;
        break;
        i2 = 0;
        break label150;
        localAIOLongShotHelper.a(paramChatMessage, paramCompoundButton, paramBoolean);
        break label189;
        label256:
        i4 = i1;
        i1 = i3;
        i3 = i2;
        i2 = i4;
      }
      label275:
      i3 = i2;
    }
  }
  
  public void a(DraftTextInfo paramDraftTextInfo)
  {
    if (paramDraftTextInfo != null) {}
    for (Object localObject = paramDraftTextInfo.text;; localObject = "")
    {
      this.jdField_d_of_type_JavaLangString = ((String)localObject);
      localObject = (QWalletAIOLifeCycleHelper)a(27);
      if (((localObject == null) || (!((QWalletAIOLifeCycleHelper)localObject).a())) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "skip set text draft");
      }
      return;
    }
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.sourceMsgSeq != 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTroopName = paramDraftTextInfo.sourceMsgTroopName;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq = paramDraftTextInfo.sourceMsgSeq;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = paramDraftTextInfo.sourceMsgText;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin = paramDraftTextInfo.sourceSenderUin;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgToUin = paramDraftTextInfo.sourceToUin;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime = paramDraftTextInfo.mSourceMsgTime;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = paramDraftTextInfo.mSourceSummaryFlag;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = paramDraftTextInfo.mSourceType;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mRichMsg = paramDraftTextInfo.mSourceRichMsg;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAtInfoStr = paramDraftTextInfo.mSourceAtInfoStr;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.origUid = paramDraftTextInfo.mSourceUid;
      i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int i2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      int i3 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight();
      if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTroopName)) {
        break label495;
      }
      localObject = this.jdField_a_of_type_AndroidViewView$OnClickListener;
      localObject = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, i1 - i2 - i3, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), (View.OnClickListener)localObject);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, ((ReplyedMessageSpan)localObject).getDrawable(), null, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374320, localObject);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(ReplyClickMovementMethod.a());
      }
    }
    if (this.jdField_d_of_type_JavaLangString != null) {}
    for (boolean bool = true;; bool = false)
    {
      this.V = bool;
      if ((paramDraftTextInfo == null) || (paramDraftTextInfo.mixedMsgInfoHtml == null)) {
        break label507;
      }
      ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a(paramDraftTextInfo.mixedMsgInfoHtml);
      ColorNickManager.a(paramDraftTextInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((!android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) && (!(this instanceof GameRoomChatPie)) && (RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new BaseChatPie.15(this), 100L);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().length());
      this.jdField_o_of_type_Boolean = false;
      return;
      label495:
      localObject = null;
      break;
    }
    label507:
    Editable localEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
    if (this.jdField_d_of_type_JavaLangString == null) {}
    for (localObject = "";; localObject = this.jdField_d_of_type_JavaLangString)
    {
      localEditable.insert(i1, (CharSequence)localObject);
      break;
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711688))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      a(0, null, -1L);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
    d(false);
    bT();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "startRecord() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
    }
    if (((paramOnQQRecorderListener instanceof PressToSpeakPanel)) && (((PressToSpeakPanel)paramOnQQRecorderListener).b()))
    {
      str = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH + "ppt/", true);
      File localFile = new File(str);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      this.jdField_c_of_type_JavaLangString = (str + "pcmforvad.pcm");
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderParam);
    String str = BuddyTransfileProcessor.getTransferFilePath(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
    paramRecorderParam = MessageForPtt.getLocalFilePath(paramRecorderParam.jdField_c_of_type_Int, str);
    if (!str.equals(paramRecorderParam)) {
      new File(str).deleteOnExit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + paramRecorderParam);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderParam, paramBoolean);
      if (this.jdField_e_of_type_Int >= 0) {
        this.jdField_e_of_type_Int += 1;
      }
      return;
      paramRecorderParam = str;
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      this.K = false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(false);
    }
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
    AIOUtils.jdField_o_of_type_Boolean = true;
    if (!(paramObject instanceof Integer))
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "panel clicked, id: " + paramObject);
      }
      return;
    }
    int i1 = ((Integer)paramObject).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i1 + "currentID=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    ((FastImageHelper)a(83)).b(true);
    G();
    if ((y()) && ((i1 == 2) || (i1 == 10) || (i1 == 8))) {
      c(false);
    }
    if (i1 == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(i1);
    B(i1);
  }
  
  protected void a(String paramString)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_JavaLangString, false);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004953", "0X8004953", 0, 0, "", "", "", "");
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    ThreadManager.postImmediately(new BaseChatPie.37(this), null, false);
    if (!this.F)
    {
      a(paramString, this.jdField_a_of_type_Long, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean, paramInt4);
      return;
    }
    ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
    a().runOnUiThread(new BaseChatPie.38(this));
  }
  
  public void a(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
        StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, paramInt, paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_d_of_type_Int, localBundle);
      }
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, RecordParams.RecorderParam paramRecorderParam, String paramString2)
  {
    Object localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
    if (localObject != null)
    {
      ((MessageForPtt)localObject).c2cViaOffline = true;
      long l1 = ((MessageRecord)localObject).uniseq;
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramString1, l1, false, paramInt, paramRecorderParam.jdField_c_of_type_Int, true, 0, 4, false, paramRecorderParam.jdField_d_of_type_Int, (Bundle)localObject);
      a(0, paramString1, l1);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B16", "0X8005B16", 0, 0, "", "", paramString2, "8.5.5");
      paramString1 = StatisticCollector.getInstance(BaseApplication.getContext());
      paramRecorderParam = new HashMap();
      paramRecorderParam.put("param_FailCode", String.valueOf(0));
      paramRecorderParam.put("inputname", paramString2);
      paramRecorderParam.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString1.collectPerformance("", "sendPttEventFromIME", false, 0L, 0L, paramRecorderParam, "");
    }
  }
  
  protected void a(String paramString, long paramLong, int paramInt1, int paramInt2, RecordParams.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean, int paramInt4)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i1 = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label130;
      }
    }
    long l1;
    int i2;
    String str1;
    Object localObject;
    label130:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l1 = SystemClock.uptimeMillis();
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (i1 != 0) {
        break label433;
      }
      localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
      if (localObject != null) {
        break label136;
      }
      return;
      i1 = 0;
      break;
    }
    label136:
    ((MessageForPtt)localObject).c2cViaOffline = bool;
    paramLong = ((MessageRecord)localObject).uniseq;
    if ((localObject instanceof MessageForPtt))
    {
      localObject = (MessageForPtt)localObject;
      ((MessageForPtt)localObject).waveformArray = PttAudioWaveView.a(paramRecorderParam.jdField_a_of_type_ArrayOfInt, paramRecorderParam.jdField_f_of_type_Int);
      if (!StringUtil.a(paramRecorderParam.jdField_a_of_type_JavaLangString)) {
        ((MessageForPtt)localObject).sttText = paramRecorderParam.jdField_a_of_type_JavaLangString;
      }
    }
    PttInfoCollector.sPttSendCostRecorder.put(paramString, Long.valueOf(l1));
    if (!bool)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      label233:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + paramLong);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!jdField_z_of_type_Boolean) {
        break label482;
      }
    }
    label433:
    label482:
    for (int i1 = 1;; i1 = 2)
    {
      ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i1, 0, "", "", "", "8.5.5");
      jdField_z_of_type_Boolean = true;
      i1 = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
      ArrayList localArrayList = new ArrayList();
      String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i2, str1, paramString, paramLong, false, paramInt2, paramRecorderParam.jdField_c_of_type_Int, bool, paramInt3, i1, paramBoolean, paramRecorderParam.jdField_d_of_type_Int, (Bundle)localObject, localArrayList, str2, false, paramInt4);
      b(paramInt1, paramInt2);
      a(0, paramString, paramLong);
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(str1, 0, paramLong);
      if ((localObject instanceof MessageForPtt)) {
        ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      }
      break;
      PttBuffer.b(paramString);
      break label233;
    }
  }
  
  public void a(String paramString, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (this.F) {}
    label571:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
      }
      if (android.text.TextUtils.isEmpty(paramString))
      {
        QLog.e("EmojiStickerManager", 1, " send, emojiText is empty");
        return;
      }
      ChatActivityFacade.SendMsgParams localSendMsgParams;
      if ((paramString.length() > 0) && (paramStickerInfo != null))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
        PicPreDownloadUtils.a(paramString);
        if (paramString.length() > 3478)
        {
          ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131719043, 1);
          return;
        }
        localSendMsgParams = new ChatActivityFacade.SendMsgParams();
        localSendMsgParams.jdField_b_of_type_Int = this.jdField_p_of_type_Int;
        localSendMsgParams.jdField_a_of_type_Int = this.jdField_n_of_type_Int;
        localSendMsgParams.jdField_c_of_type_Boolean = this.P;
        localSendMsgParams.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
        localSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
        localSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
        localSendMsgParams.jdField_i_of_type_Boolean = this.E;
        localSendMsgParams.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo = paramStickerInfo;
        this.E = false;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
          }
          a(paramString, localSendMsgParams, new ArrayList());
          paramStickerInfo = (AIOEmoticonPanelHelper)a(104);
          if (paramStickerInfo != null) {
            paramStickerInfo.reportClassicAndSmallEmoticon(paramString, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
          }
          d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, -1);
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
          }
          if (QLog.isColorLevel()) {
            QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { paramString });
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
          break label571;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
        return;
        if (QLog.isColorLevel()) {
          QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
        }
        a(paramString, localSendMsgParams, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
        break;
        QLog.e("EmojiStickerManager", 1, " send, sticker info is empty");
      }
    }
  }
  
  public void a(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    l(0);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label28;
      }
    }
    label28:
    for (int i1 = 1; i1 == 0; i1 = 0)
    {
      StreamDataManager.a(paramString, false);
      return;
    }
    PttBuffer.b(paramString);
  }
  
  void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.post(new BaseChatPie.18(this, paramString1, paramString3, paramString2));
  }
  
  public void a(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList, int paramInt)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    localSendMsgParams.jdField_b_of_type_Int = this.jdField_p_of_type_Int;
    localSendMsgParams.jdField_a_of_type_Int = this.jdField_n_of_type_Int;
    localSendMsgParams.jdField_c_of_type_Boolean = this.P;
    localSendMsgParams.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
    localSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
    localSendMsgParams.jdField_g_of_type_Int = paramInt;
    a(paramString, localSendMsgParams, paramArrayList);
  }
  
  public void a(String paramString, boolean paramBoolean, RecordParams.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    Object localObject = RecordParams.a(paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_a_of_type_Int);
    int i1;
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null)
    {
      i1 = 1;
      if (i1 != 0) {
        break label127;
      }
      StreamDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramRecorderParam.jdField_c_of_type_Int, paramString, 0, (int)(System.currentTimeMillis() / 1000L));
      StreamDataManager.a(paramString, (byte[])localObject, localObject.length, (short)0);
      label94:
      if (paramString != null)
      {
        if (paramBoolean) {
          break label145;
        }
        this.jdField_a_of_type_Long = 0L;
        k(2131230745);
        c(true, false);
      }
    }
    label145:
    label279:
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label127:
      PttBuffer.a(paramString);
      PttBuffer.a(paramString, (byte[])localObject, localObject.length);
      break label94;
      if (this.F)
      {
        localObject = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int);
        paramString = (String)localObject;
        if (localObject != null)
        {
          ((MessageForPtt)localObject).msgVia = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int;
          ReceiptMsgManager.a().a = ((MessageForPtt)localObject);
        }
      }
      for (paramString = (String)localObject;; paramString = ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, -2, paramRecorderParam.jdField_c_of_type_Int))
      {
        if (paramString == null) {
          break label279;
        }
        if (i1 == 0) {
          paramString.setPttStreamFlag(10001);
        }
        this.jdField_a_of_type_Long = paramString.uniseq;
        paramRecorderParam.jdField_d_of_type_Int = paramString.vipSubBubbleId;
        paramRecorderParam.jdField_e_of_type_Int = paramString.vipBubbleDiyTextId;
        k(2131230733);
        break;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, RecordParams.RecorderParam paramRecorderParam)
  {
    a(paramString, this.jdField_a_of_type_Long, paramBoolean2, paramRecorderParam);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.32(this, paramBoolean1));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, RecordParams.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      StreamDataManager.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void a(List<ChatMessage> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramList, false);
    g(196613);
  }
  
  void a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    String str1;
    String str2;
    StringBuilder localStringBuilder;
    boolean bool;
    if (this.jdField_b_of_type_Boolean)
    {
      str1 = a(paramList, paramMessageRecord);
      if (QLog.isColorLevel())
      {
        str2 = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder().append("sessionInfo.curType = ").append(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).append(", mr = null ? ");
        if (paramMessageRecord != null) {
          break label175;
        }
        bool = true;
        localStringBuilder = localStringBuilder.append(bool).append("，mr.type = ");
        if (paramMessageRecord != null) {
          break label180;
        }
      }
    }
    label175:
    label180:
    for (paramMessageRecord = "null";; paramMessageRecord = Integer.valueOf(paramMessageRecord.istroop))
    {
      QLog.d(str2, 2, paramMessageRecord + ", newList.size() = " + paramList.size());
      if (str1 == null) {
        break label191;
      }
      b(true);
      this.jdField_f_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
      c(str1);
      if (jdField_a_of_type_Boolean) {
        this.jdField_f_of_type_AndroidWidgetTextView.setContentDescription(str1);
      }
      return;
      bool = false;
      break;
    }
    label191:
    b(false);
  }
  
  protected void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramList, paramCharSequence, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QVipGiftProcessor.a().isEnable())
    {
      GiftJsPlugin.openGiftBrowser(a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer == null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = new AIOGiftPanelContainer(this);
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    a(paramBoolean1, paramChatMessage, paramBoolean2, false);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramBoolean1, paramChatMessage, paramBoolean2, paramBoolean3, false);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if ((BaseChatItemLayout.jdField_a_of_type_Boolean == paramBoolean1) && (!paramBoolean4)) {
      if (QLog.isDevelopLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
    }
    label228:
    for (;;)
    {
      return;
      if (paramBoolean1)
      {
        BaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$OnChatMessageCheckedChangeListener = this;
        this.X = true;
        BaseChatItemLayout.jdField_a_of_type_Boolean = paramBoolean1;
        AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
        if (!paramBoolean3)
        {
          if (!localAIOLongShotHelper.a()) {
            MultiMsgManager.a().a(paramChatMessage, paramBoolean1);
          }
          a(paramChatMessage, null, paramBoolean1);
        }
        if ((paramBoolean1) || (paramBoolean3)) {
          break label120;
        }
        a(localAIOLongShotHelper);
      }
      for (;;)
      {
        if (paramBoolean2) {
          break label228;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
        return;
        BaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$OnChatMessageCheckedChangeListener = null;
        break;
        label120:
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        an();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0)
        {
          au();
          this.jdField_j_of_type_Boolean = true;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          if (this.jdField_b_of_type_Int == 0) {
            this.jdField_b_of_type_Int = paramChatMessage.bottomMargin;
          }
        }
        if (this.jdField_n_of_type_AndroidWidgetTextView != null) {
          this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        if (this.W) {
          MultiMsgManager.a().a();
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    ThreadManager.post(new BaseChatPie.9(this, paramString, paramBoolean), 8, null, true);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (t())
    {
      if (!paramBoolean1) {
        break label41;
      }
      D();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean2, false, false);
      b(true, paramBoolean2);
      this.jdField_k_of_type_Boolean = paramBoolean2;
      return;
      label41:
      E();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramBoolean1);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()) {
        return;
      }
    }
    this.jdField_k_of_type_Boolean = paramBoolean3;
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      }
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a()) {
      if ((paramBoolean1) || (paramBoolean4)) {
        break label130;
      }
    }
    label130:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      b(paramBoolean2, paramBoolean3);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramBoolean1);
      return;
    }
  }
  
  protected boolean a()
  {
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if ((paramInt == 2) && (this.S))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "recreate audio panel due to receipt message");
      }
      this.S = false;
      return true;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(paramInt);
  }
  
  public boolean a(android.os.Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 77: 
    case 48: 
    case 47: 
    case 61: 
    case 62: 
    case 65: 
    case 82: 
      label221:
      do
      {
        do
        {
          do
          {
            return false;
            paramMessage = (String)paramMessage.obj;
          } while (android.text.TextUtils.isEmpty(paramMessage));
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramMessage, 0).a();
          return false;
        } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        return false;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a() != null)
        {
          i1 = Math.max(AIOUtils.a(46.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramMessage.arg1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(1, i1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(i1, true, "handleMsg_showFooter", 0);
          return false;
        }
        if (1 != ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
        {
          i1 = 1;
          if ((i1 == 0) || (((ISpriteUtil)QRoute.api(ISpriteUtil.class)).isSpriteHidden(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            break label298;
          }
        }
        for (i1 = 1; i1 == 0; i1 = 0)
        {
          this.J = true;
          i1 = Math.max(AIOUtils.a(46.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramMessage.arg1);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(i1, false, "handleMsg_addFooter", 0);
          return false;
          i1 = 0;
          break label221;
        }
        this.J = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(1, 0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
        return false;
        h();
        return false;
      } while (!(paramMessage.obj instanceof ApolloActionData));
      label298:
      int i1 = paramMessage.arg1;
      String str = paramMessage.getData().getString("senderUin");
      paramMessage = (ApolloActionData)paramMessage.obj;
      ((IApolloResponseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResponseManager.class, "all")).updateQuickResponseView(this, paramMessage, i1, str);
      return false;
    }
    ((IApolloResponseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloResponseManager.class, "all")).removeResponseView();
    return false;
  }
  
  protected boolean a(Editable paramEditable)
  {
    StickerRecHelper localStickerRecHelper = (StickerRecHelper)a(14);
    return (paramEditable.length() > 0) && (!this.F) && (!this.K) && (!m()) && (!y()) && (localStickerRecHelper.b()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 10007);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      return true;
    }
    if (((ChatPieSelectableHelper)a(4)).b()) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
    while (i1 >= 0)
    {
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
      if ((paramMotionEvent != null) && ((AIOUtils.a(paramMotionEvent) instanceof ArkAppItemBubbleBuilder.Holder)))
      {
        paramMotionEvent = paramMotionEvent.findViewById(2131362998);
        Rect localRect = new Rect();
        paramMotionEvent.getGlobalVisibleRect(localRect);
        if (localRect.contains((int)f1, (int)f2)) {
          return false;
        }
      }
      i1 -= 1;
    }
    return true;
  }
  
  protected boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((UinTypeUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (UinTypeUtil.b(paramMessageRecord.istroop)))) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int));
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Long = NetConnInfoCenter.getServerTime();
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "mAIORootView == null");
      ChatFragment localChatFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      if (this.jdField_c_of_type_AndroidViewViewGroup == null)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "root view is still null");
        return false;
      }
    }
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a();
    f();
    this.jdField_d_of_type_Int = 2;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "doOnCreate", hashCode(), this.jdField_d_of_type_Int);
    c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    BaseActivity.sActivityRoute.add(getClass().getSimpleName());
    al();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    StartupTracker.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.a();
      StartupTracker.a("AIO_doOnCreate_handleRequest", null);
      return true;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), 2);
    }
  }
  
  public void aA()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(30);
  }
  
  public void aB()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_g_of_type_Boolean)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
            break;
          }
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        } while ((localObject == null) || (!((NoC2CExtensionInfo)localObject).isDataChanged));
        ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        return;
      } while (!E());
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    } while ((localObject == null) || (!((ExtensionInfo)localObject).isDataChanged));
    ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void aC()
  {
    if (((ChatPieSelectableHelper)a(4)).b()) {}
    int i1;
    int i2;
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null));
      i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount() + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (QLog.isColorLevel()) {
        QLog.d("MyOnGestureListener", 2, "onOverScrollTargetValue isScrollToButtom=" + this.C + "lastPosition=" + i1 + "toLast=" + i2);
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() != 0) || (i1 != i2) || (!this.C));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
  }
  
  public void aD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.R = true;
  }
  
  public void aE()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar = new C2BTipsBar(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsC2BTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void aF()
  {
    g(false);
  }
  
  public void aG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
  }
  
  public void aH()
  {
    j(false);
  }
  
  public void aI()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.c();
    }
  }
  
  protected void aJ()
  {
    if (this.jdField_h_of_type_AndroidViewView == null)
    {
      this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(12.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(6, 2131369142);
      this.jdField_h_of_type_AndroidViewView.setId(2131362408);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_h_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    this.jdField_h_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      AccessibilityUtil.a(this.jdField_h_of_type_AndroidViewView, false);
    }
  }
  
  protected void aK()
  {
    if (this.jdField_g_of_type_AndroidViewView == null)
    {
      this.jdField_g_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(15.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(3, 2131369142);
      this.jdField_g_of_type_AndroidViewView.setId(2131362407);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_g_of_type_AndroidViewView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_d_of_type_Boolean) {
      AccessibilityUtil.a(this.jdField_g_of_type_AndroidViewView, false);
    }
  }
  
  public void aL() {}
  
  public void aM()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
    }
  }
  
  public void aN()
  {
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()))
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "cancelRemainScreenOn");
    }
  }
  
  public void aO()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
  }
  
  protected void aP()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null)) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    } while (!this.jdField_j_of_type_Boolean);
    if (this.jdField_n_of_type_AndroidWidgetTextView != null) {
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void aQ()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374320, null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
    if (localPhotoListPanel != null) {
      localPhotoListPanel.a(false);
    }
    if (g() == 28) {
      aF();
    }
    ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).d();
  }
  
  public void aR()
  {
    int i2;
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() > 0)
      {
        i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
        if (localObject != null) {
          break label150;
        }
      }
    }
    label150:
    for (int i1 = 0;; i1 = ((View)localObject).getTop())
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(i2, i1);
      if (this.jdField_f_of_type_AndroidViewView == null)
      {
        this.jdField_f_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_f_of_type_AndroidViewView.setId(2131374570);
        localObject = new AbsListView.LayoutParams(-1, 80);
        this.jdField_f_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_f_of_type_AndroidViewView.getParent() == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_f_of_type_AndroidViewView, null, false);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
        g(196608);
      }
      return;
    }
  }
  
  public void aS()
  {
    int i1 = 0;
    int i2;
    View localView;
    if ((this.jdField_f_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() > 0)
      {
        i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
        localView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0);
        if (localView != null) {
          break label88;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromTop(i2, i1);
      if (this.jdField_f_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeFooterView(this.jdField_f_of_type_AndroidViewView);
      }
      this.jdField_f_of_type_AndroidViewView = null;
      g(196608);
      return;
      label88:
      i1 = localView.getTop();
    }
  }
  
  protected void aT() {}
  
  public void aU()
  {
    Object localObject;
    if ((!this.F) && (ReceiptUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0))
    {
      localObject = a().getString(2131698504);
      QQToast.a(a(), (CharSequence)localObject, 0).b(a().getResources().getDimensionPixelSize(2131299166));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      return;
    }
    int i1;
    if (!this.F)
    {
      bool = true;
      this.F = bool;
      ((FastImageHelper)a(83)).b(true);
      G();
      if (!this.F) {
        break label513;
      }
      if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)) {
        aX();
      }
      aT();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(true, this);
      C(0);
      i1 = ReceiptUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = String.valueOf(i1);
      if (i1 >= 4) {
        break label477;
      }
      String str = String.format(a().getString(2131698518), new Object[] { localObject });
      SpannableString localSpannableString = new SpannableString(str);
      localSpannableString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.getContext().getResources().getColor(2131167160)), str.length() - ((String)localObject).length() - 2, str.length() - 2, 18);
      this.jdField_o_of_type_AndroidWidgetTextView.setText(localSpannableString);
      label282:
      i1 = BaseApplicationImpl.getContext().getResources().getColor(2131167161);
      this.jdField_o_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374320, null);
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).showOrHideSprite(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "receipt_msg", true);
      as();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label490;
      }
      i1 = 1;
      label363:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0x80083E8", "0x80083E8", i1, 0, "", "", "", "");
      label399:
      p(this.F);
      localObject = (AIOEmoticonUIHelper)a(105);
      if (localObject != null) {
        ((AIOEmoticonUIHelper)localObject).j();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
      {
        this.S = true;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = null;
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) && (c() <= 0)) {
        break label562;
      }
    }
    label513:
    label562:
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
      bool = false;
      break;
      label477:
      this.jdField_o_of_type_AndroidWidgetTextView.setText(2131698517);
      break label282;
      label490:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        i1 = 2;
        break label363;
      }
      i1 = 3;
      break label363;
      aF();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this);
      C(8);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new BaseChatPie.73(this));
      break label399;
    }
  }
  
  public void aV()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
      b(false, false);
    }
  }
  
  public void aW()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(18);
  }
  
  public void aX()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0))
    {
      bV();
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      this.K = false;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
    }
  }
  
  public void aY()
  {
    if (SimpleUIUtil.a()) {
      break label6;
    }
    label6:
    while ((!((HiBoomHelper)a(18)).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx)) || (this.jdField_d_of_type_AndroidViewView == null)) {
      return;
    }
    if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0)
    {
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      ABTestController.a("exp_qq_msg_marketface_input_icon").a();
      this.K = false;
    }
    bV();
    this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131701047));
    int i2 = this.jdField_d_of_type_AndroidViewView.getWidth();
    if (i2 == 0) {}
    for (int i1 = AIOUtils.a(37.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());; i1 = i2)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZhituManager", 4, "showZhituIcon.rightPadding." + i1 + " ,pr = " + i2 + ",input.getPaddingRight() = " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight());
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight() < i1) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), i1, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      }
      if (this.U) {
        break;
      }
      ReportController.b(a(), "dc00898", "", "", "0X800932B", "0X800932B", 0, 0, "", "", "", "");
      this.U = true;
      return;
    }
  }
  
  public void aZ()
  {
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.K))
    {
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      bV();
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(false);
      this.K = false;
    }
  }
  
  public void aa()
  {
    Object localObject = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject).setId(2131371965);
    ((TextView)localObject).setBackgroundResource(2130838483);
    ((TextView)localObject).setGravity(1);
    ((TextView)localObject).setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
    ((TextView)localObject).setSingleLine();
    ((TextView)localObject).setTextColor(-1);
    ((TextView)localObject).setTextSize(2, 16.0F);
    ((TextView)localObject).setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(2, 2131369142);
    localLayoutParams.addRule(11);
    localLayoutParams.bottomMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
    localLayoutParams.rightMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject, localLayoutParams);
    this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(this.jdField_a_of_type_AndroidViewView);
    }
    if (this.jdField_e_of_type_AndroidViewView != null) {
      ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131371965);
    }
    localObject = (UnreadBackBottomHelper)a(53);
    ((UnreadBackBottomHelper)localObject).a(this.jdField_n_of_type_AndroidWidgetTextView);
    ((UnreadBackBottomHelper)localObject).b(this.jdField_k_of_type_Int);
  }
  
  public void ab()
  {
    int i2 = 0;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i1;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i1 = 2131698526;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(i1));
        if (i2 == 0) {
          break label247;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165624), this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165629)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131701058), (CharSequence)localObject, 0, 2131720056, null, null, new BaseChatPie.33(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "show showAbnormalRecordDlg error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i1 = 2131698528;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i1 = 2131698527;
      }
      else
      {
        i1 = 2131698524;
        i2 = 1;
      }
    }
    label247:
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, HardCodeUtil.a(2131701041), localException.toString(), HardCodeUtil.a(2131701064), "", null, new BaseChatPie.34(this)).show();
  }
  
  protected void ac()
  {
    if (this.Z)
    {
      k();
      this.Z = false;
    }
    ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).b();
  }
  
  protected void ad()
  {
    aO();
    QIMShortVideoUtils.a(BaseApplicationImpl.getContext(), new BaseChatPie.41(this), null);
    Intent localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    if (localIntent == null) {
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "onShow_otherThings: intent == null");
    }
    String str;
    do
    {
      return;
      boolean bool = localIntent.getBooleanExtra("PhotoConst.SEND_FLAG", false);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onShow_otherThings, isPhotoPlusEditSend = " + bool);
      }
      if (bool)
      {
        localIntent.removeExtra("PhotoConst.SEND_FLAG");
        AIOPanelUtiles.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localIntent);
        if (this.F) {
          aU();
        }
      }
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.42(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getQQProxyForQlink().b();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(31, 800L);
      bG();
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
      a(BaseApplication.getContext(), "com.vivo.smartshot");
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "isvivo has shot" + jdField_t_of_type_Int);
      }
      if (!((IDPCApi)QRoute.api(IDPCApi.class)).isInited()) {
        bF();
      }
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, null);
      AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), 0, 0);
      AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
      str = localIntent.getStringExtra("panel");
    } while ((str == null) || (!str.equals("ptv")));
    aH();
    localIntent.removeExtra("panel");
  }
  
  protected void ae()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "onShow start ", hashCode(), this.jdField_d_of_type_Int);
    StartupTracker.a(null, "AIO_onShow");
    StartupTracker.a(null, "AIO_onShow_emotion");
    StartupTracker.a("AIO_onShow_emotion", null);
    ac();
    StartupTracker.a(null, "AIO_onShow_updateUI");
    bE();
    StartupTracker.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    bD();
    StartupTracker.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    r(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_onShow_report", "AIO_onShow_otherThings");
    ad();
    StartupTracker.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    bH();
    StartupTracker.a("AIO_onShow_setReaded", null);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().hasExtra("launchApolloGame")) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("launchApolloGame", false))) {
      ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.d(this);
    }
    ThreadPriorityManager.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(9);
    StartupTracker.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "AIOTime onShow end");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqHiboomRichTextPanel.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager = new ComboUIManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    if (!(this instanceof TroopChatPie)) {
      n(true);
    }
    bw();
    bx();
  }
  
  @TargetApi(11)
  protected void af()
  {
    if (y()) {
      c(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a() == null) {}
    do
    {
      do
      {
        return;
        localObject1 = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
      } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
      Object localObject2 = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24);
      ((FullScreenInputHelper)localObject2).jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      if (this.jdField_h_of_type_AndroidWidgetTextView == null)
      {
        TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localTextView.setId(2131367675);
        localTextView.setBackgroundResource(2130850251);
        localTextView.setTextSize(1, 17.0F);
        localTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167012));
        localTextView.setEnabled(false);
        localTextView.setGravity(17);
        int i1 = ((ViewGroup)((FullScreenInputHelper)localObject2).jdField_a_of_type_AndroidViewView.getParent()).indexOfChild(((FullScreenInputHelper)localObject2).jdField_a_of_type_AndroidViewView);
        localObject2 = new LinearLayout.LayoutParams(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth(), -2);
        ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.a(14.0F, a().getResources());
        ((LinearLayout.LayoutParams)localObject2).gravity = 80;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView(localTextView, i1, (ViewGroup.LayoutParams)localObject2);
        this.jdField_h_of_type_AndroidWidgetTextView = localTextView;
      }
      if (localObject1 != null)
      {
        QLog.d(this.jdField_b_of_type_JavaLangString, 1, "fightgag.doDisableInputStat text" + ((SelfGagInfo)localObject1).jdField_b_of_type_JavaLangString);
        this.jdField_h_of_type_AndroidWidgetTextView.setText(((SelfGagInfo)localObject1).jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        }
      }
      if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      if (this.jdField_l_of_type_AndroidWidgetTextView != null) {
        this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
      a(false);
      Object localObject1 = (SimpleUIAIOHelper)a(29);
      if (localObject1 != null) {
        ((SimpleUIAIOHelper)localObject1).e(false);
      }
      if (VersionUtils.e())
      {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 0.6F);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
      }
      this.jdField_a_of_type_Int = 2;
      aX();
    } while (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController == null);
    this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a(paramEditable)) {
      return;
    }
    QWalletAIOLifeCycleHelper localQWalletAIOLifeCycleHelper = (QWalletAIOLifeCycleHelper)a(27);
    if (localQWalletAIOLifeCycleHelper != null) {
      localQWalletAIOLifeCycleHelper.a(paramEditable);
    }
    a(paramEditable);
  }
  
  @TargetApi(11)
  protected void ag()
  {
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
        if (VersionUtils.e()) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (this.jdField_a_of_type_Int != 2) {
              break;
            }
          } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
        } while (!VersionUtils.e());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(0.6F);
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(true);
    } while (!VersionUtils.e());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllAlpha(1.0F);
  }
  
  protected void ah()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null)
    {
      if (i1 == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
      }
    }
    else {
      return;
    }
    if (i1 == 21)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label196;
      }
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localHotChatManager != null) && (localHotChatManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        i1 = 1;
      }
    }
    for (;;)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(21);
        return;
        i1 = 0;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
        return;
        if (i1 == 23)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i1 == 18)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i1 == 35)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i1 == 24)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        if (i1 == 36)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(2);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i1);
        return;
        label196:
        i1 = 0;
      }
    }
  }
  
  public void ai()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "hideSoftInput, ", this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken() });
        }
      }
    }
  }
  
  public void aj()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b() != 1)) {}
  }
  
  public void ak()
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131689617);
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, str, 2131692207, 2131692206, new BaseChatPie.49(this), new BaseChatPie.50(this)).show();
  }
  
  protected void al()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setCheckPttListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setCheckPtvListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomAuthObserver = new HiBoomManager.HiBoomAuthObserver(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomAuthObserver);
    this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomForwardAuthObserver = new HiBoomManager.HiBoomForwardAuthObserver(a());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomForwardAuthObserver);
    this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver = new FontBubbleManager.FontBubbleObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver);
  }
  
  protected void am()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setCheckPttListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setCheckPtvListener(null);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloApiHandlerIApolloExtensionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomAuthObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomAuthObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomForwardAuthObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomManager$HiBoomForwardAuthObserver);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqHiboomFontBubbleManager$FontBubbleObserver);
  }
  
  public void an()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void ao()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
    }
    ap();
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
    }
  }
  
  public void ap()
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = null;
    if (y()) {
      c(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_l_of_type_Boolean)
    {
      BaseChatpieHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentWidgetPatchedButton, true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b(131075);
      g(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b());
      return;
    }
    FullScreenInputHelper localFullScreenInputHelper = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24);
    UniteGrayTipUtil.a();
    Object localObject1 = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
    int i1;
    label107:
    int i2;
    label116:
    MixedMsgInfo localMixedMsgInfo;
    if (localObject1 != null)
    {
      i1 = ((PhotoListPanel)localObject1).b();
      if (localObject1 == null) {
        break label323;
      }
      i2 = ((PhotoListPanel)localObject1).c();
      if ((localFullScreenInputHelper.c()) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) && (i1 + i2 <= 0)) {
        break label326;
      }
      localMixedMsgInfo = localFullScreenInputHelper.a();
      if (localMixedMsgInfo != null) {
        break label328;
      }
      localObject1 = "";
      label161:
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {
        break label337;
      }
    }
    label323:
    label326:
    label328:
    label337:
    for (Object localObject3 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();; localObject3 = localObject1)
    {
      LogcatUtil.a((String)localObject3);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131374320) == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
      }
      localObject2 = localSendMsgParams;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
      {
        localObject2 = localSendMsgParams;
        if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTroopName)) {
          localObject2 = ((ForwardMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FORWARD_MSG_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.getUniSeq());
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {
          localObject1 = ReplyMsgUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
        }
      }
      PicPreDownloadUtils.a((String)localObject3);
      if (((String)localObject3).length() <= jdField_z_of_type_Int) {
        break label343;
      }
      ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131719043, 1);
      return;
      i1 = 0;
      break label107;
      i2 = 0;
      break label116;
      break;
      localObject1 = localMixedMsgInfo.b();
      break label161;
    }
    label343:
    localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    if (localFullScreenInputHelper.a())
    {
      localSendMsgParams.jdField_k_of_type_Boolean = true;
      localFullScreenInputHelper.b(false);
    }
    a(localSendMsgParams);
    ChatPieInputHelper.a(this).jdField_a_of_type_Boolean = false;
    localSendMsgParams.jdField_i_of_type_Boolean = this.E;
    this.E = false;
    Object localObject2 = (QWalletAIOLifeCycleHelper)a(27);
    if (localObject2 != null) {
      ((QWalletAIOLifeCycleHelper)localObject2).a((String)localObject3, localSendMsgParams, 0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
      }
      localObject2 = a((MessageRecord)localObject1);
    }
    for (localObject1 = a(localFullScreenInputHelper, i1, i2, localMixedMsgInfo, (MessageRecord)localObject2, localSendMsgParams);; localObject1 = localObject3)
    {
      localObject3 = (AIOEmoticonPanelHelper)a(104);
      if (localObject3 != null) {
        ((AIOEmoticonPanelHelper)localObject3).reportClassicAndSmallEmoticon((String)localObject1, false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      aQ();
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
      }
      d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, -1);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " msgReport end currenttime:" + System.currentTimeMillis());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send end currenttime:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { localObject1 });
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation == 2) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
      }
      ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject2, "0X800A369");
      ((HiddenChatHelper)a(39)).a();
      return;
      localObject3 = b(localFullScreenInputHelper, i1, i2, localMixedMsgInfo, (MessageRecord)localObject1, localSendMsgParams);
      localObject2 = localObject1;
    }
  }
  
  public void aq()
  {
    ((AIOShakeHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(65)).a();
  }
  
  public void ar()
  {
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(52);
    if (localShortcutBarAIOHelper != null) {
      localShortcutBarAIOHelper.h();
    }
  }
  
  public void as()
  {
    ShortcutBarAIOHelper localShortcutBarAIOHelper = (ShortcutBarAIOHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(52);
    if (localShortcutBarAIOHelper != null) {
      localShortcutBarAIOHelper.i();
    }
  }
  
  public void at()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRightToStr(HardCodeUtil.a(2131701062), new BaseChatPie.61(this));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setVisibility(8);
    }
    JubaoHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a().getIntent());
    a(true, null, false, true);
  }
  
  public void au()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    if (this.jdField_g_of_type_AndroidViewView != null) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_h_of_type_AndroidViewView != null) {
      this.jdField_h_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void av()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!(this instanceof PublicAccountChatPie))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.jdField_b_of_type_Int);
    }
    ((SimpleUIAIOHelper)a(29)).c();
    if (this.jdField_g_of_type_AndroidViewView != null) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_h_of_type_AndroidViewView != null) {
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  protected void aw()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) {
        if ((!"".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString)) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString))) {
          break label368;
        }
      }
    }
    label221:
    label368:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.jdField_k_of_type_AndroidViewView + ", sessionInfo.chatBg.path=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_k_of_type_AndroidViewView != null) && (QLog.isColorLevel()))
      {
        if (this.jdField_k_of_type_AndroidViewView.getVisibility() == 0) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label313;
        }
        if ((this.jdField_k_of_type_AndroidViewView == null) || (this.jdField_k_of_type_AndroidViewView.getVisibility() != 0)) {
          break label221;
        }
      }
      do
      {
        do
        {
          return;
          if (this.jdField_k_of_type_AndroidViewView.getVisibility() == 4)
          {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
            break;
          }
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "#handleNightMask# : mMask getVisibility = GONE");
          break;
          if (this.jdField_k_of_type_AndroidViewView == null)
          {
            this.jdField_k_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
            this.jdField_k_of_type_AndroidViewView.setBackgroundColor(1996488704);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            localLayoutParams.addRule(6, 2131370460);
            localLayoutParams.addRule(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getId());
            this.jdField_k_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_k_of_type_AndroidViewView);
            return;
          }
          this.jdField_k_of_type_AndroidViewView.setVisibility(0);
          return;
        } while (this.jdField_k_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_k_of_type_AndroidViewView);
        this.jdField_k_of_type_AndroidViewView = null;
        return;
      } while ((this.jdField_k_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_k_of_type_AndroidViewView);
      this.jdField_k_of_type_AndroidViewView = null;
      return;
    }
  }
  
  public void ax()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
  }
  
  public void ay()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(21);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if ((localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 0) || (localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) == 2)) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "panel_close_show", localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportUserResult(localIApolloManagerService.getApolloUserStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)), new String[] { "" + ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) });
        }
      }
    }
  }
  
  public void az()
  {
    String str = PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((android.text.TextUtils.isEmpty(str)) || ((PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1) == 0) && (PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) == 0)) || (QidianManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("pokeMsg", 2, "pokePanelInfo " + str + ", " + PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1) + ", " + PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) + ", " + QidianManager.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
      }
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    do
    {
      return;
      PokeItemHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (!PokePanel.jdField_c_of_type_Boolean) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("pokeMsg", 2, "show pokePanel");
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(23);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("pokeMsg", 2, "XPanel is null");
    return;
    PokePanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  public AIOContext b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  }
  
  @Deprecated
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    if (jdField_z_of_type_Int == 0) {
      jdField_z_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getInteger(2131427342);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(this);
    bf();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper = new BaseChatpieHelper(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager = new PanelManager(this.jdField_a_of_type_AndroidContentContext, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a();
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(paramInt);
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    PttUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt1, paramInt2);
  }
  
  public final void b(long paramLong)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(paramLong);
  }
  
  protected void b(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_updateTitle");
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_b_of_type_JavaLangString, 2, "updateSession_updateTitle nick == null");
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updateSession_updateTitle curFriendNick" + MessageRecordUtil.a(paramIntent));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString != null)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        paramIntent = this.jdField_e_of_type_AndroidWidgetTextView.getText();
        this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        a().setTitle(this.jdField_e_of_type_AndroidWidgetTextView.getText());
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_f_of_type_AndroidWidgetImageView.setVisibility(8);
      StartupTracker.a("AIO_updateSession_updateTitle", null);
      return;
      QLog.e(this.jdField_b_of_type_JavaLangString, 1, "updateSession_updateTitle sessionInfo.curFriendNick == null");
    }
  }
  
  protected void b(Editable paramEditable)
  {
    int i1 = 1;
    boolean bool;
    if ((paramEditable.toString().trim().length() > 0) && (((HiBoomHelper)a(18)).a(this.jdField_a_of_type_AndroidContentContext, paramEditable.toString(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx)))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "check valid input condition: " + bool + " / " + this.F + " / " + ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      }
      if ((!bool) || (this.F) || (!ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) || (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) || ((this instanceof GameRoomChatPie))) {
        break label300;
      }
      bool = true;
      label150:
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "afterTextChange,isValidInput = " + bool);
      }
      ZhituManager localZhituManager = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if ((!bool) || (!localZhituManager.a(paramEditable))) {
        break label305;
      }
      label205:
      if (i1 == 0)
      {
        aZ();
        aX();
      }
      if (i1 != 0)
      {
        if (!RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          break label363;
        }
        if (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0) {
          break label315;
        }
        if ((paramEditable.length() <= 20) && (localZhituManager.a(paramEditable))) {
          break label310;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        this.K = false;
        aY();
        localZhituManager.c();
        bV();
      }
    }
    label300:
    label305:
    label310:
    label315:
    do
    {
      return;
      bool = false;
      break;
      bool = false;
      break label150;
      i1 = 0;
      break label205;
      aY();
      return;
      aY();
    } while (this.V);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D0", "0X80094D0", 0, 0, "", "", "", "");
    return;
    label363:
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), AIOUtils.a(11.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources()), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
  }
  
  public void b(MotionEvent paramMotionEvent)
  {
    ((ChatPieSelectableHelper)a(4)).a(paramMotionEvent);
  }
  
  protected void b(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            paramView = AIOUtils.a(paramView);
            if ((paramView instanceof ShortVideoItemBuilder.Holder))
            {
              ((ShortVideoItemBuilder.Holder)paramView).a();
              return;
            }
            if ((paramView instanceof ShortVideoRealItemBuilder.Holder))
            {
              ((ShortVideoRealItemBuilder.Holder)paramView).a();
              return;
            }
            if (!(paramView instanceof TextItemBuilder.Holder)) {
              break;
            }
            paramView = (TextItemBuilder.Holder)paramView;
          } while (paramView.a == null);
          paramView.a.d();
          return;
          if (!(paramView instanceof MixedMsgItemBuilder.MixedHolder)) {
            break;
          }
          paramView = (MixedMsgItemBuilder.MixedHolder)paramView;
        } while (paramView.a == null);
        paramView.a.d();
        return;
        if (!(paramView instanceof LongMsgItemBuilder.Holder)) {
          break;
        }
        paramView = (LongMsgItemBuilder.Holder)paramView;
      } while (paramView.a == null);
      paramView.a.d();
      return;
    } while (!(paramView instanceof IApolloItemBuilder.Holder));
    ((IApolloItemBuilder.Holder)paramView).a();
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage) + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {
      return;
    }
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "horMoveView is null,childIndex is:" + (i1 - i2) + ",firstPos is:" + i2 + ",pos is:" + i1);
    }
    g(196613);
  }
  
  protected void b(String paramString)
  {
    ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_JavaLangString, true);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8004954", "0X8004954", 0, 0, "", "", "", "");
    }
  }
  
  public void b(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 2) {
      if (paramInt != 1) {
        break label39;
      }
    }
    label39:
    for (bool1 = bool2;; bool1 = false)
    {
      a(paramString, this.jdField_a_of_type_Long, bool1, paramRecorderParam);
      z(paramInt);
      return;
    }
  }
  
  public void b(String paramString, RecordParams.RecorderParam paramRecorderParam)
  {
    int i1 = 1;
    d(true);
    aN();
    l(0);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "recorderEnd() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label66;
      }
    }
    while (i1 == 0)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      return;
      label66:
      i1 = 0;
    }
    PttBuffer.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    this.L = paramBoolean;
    if ((paramBoolean) && (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    }
    while ((paramBoolean) || (this.jdField_f_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
  }
  
  public void b(boolean paramBoolean, String paramString) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!DeviceInfoUtil.h())) {
      if (this.jdField_e_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2131558681, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362533);
        this.jdField_m_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362534));
        this.jdField_l_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131362532));
        this.jdField_e_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label216;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c())) {
          ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131369142);
        }
      }
    }
    label215:
    label216:
    do
    {
      do
      {
        do
        {
          break label215;
          for (;;)
          {
            this.jdField_e_of_type_AndroidViewView.setVisibility(0);
            if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
              this.jdField_m_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FF737373"));
            }
            if (!paramBoolean2) {
              break;
            }
            this.jdField_m_of_type_AndroidWidgetTextView.setText(2131690031);
            this.jdField_l_of_type_AndroidWidgetImageView.setBackgroundResource(2130850377);
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
              this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(false, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            }
            return;
            if (this.jdField_n_of_type_AndroidWidgetTextView == null) {
              ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131369142);
            }
          }
          this.jdField_m_of_type_AndroidWidgetTextView.setText(2131690030);
          this.jdField_l_of_type_AndroidWidgetImageView.setBackgroundResource(2130850376);
        } while (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(true, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        return;
      } while (this.jdField_e_of_type_AndroidViewView == null);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      paramBoolean1 = AudioSettingManager.a(BaseApplicationImpl.getContext());
      paramBoolean2 = AudioHelper.a(BaseApplicationImpl.getContext());
    } while (((!paramBoolean1) && (!paramBoolean2)) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null));
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (!this.jdField_k_of_type_Boolean) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      localNavBarAIO.a(paramBoolean1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
    }
  }
  
  public boolean b()
  {
    bk();
    return this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(this);
  }
  
  public boolean b(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
    {
      SplashActivity.sExitAIOCode = HardCoderManager.a().a(0, 1, 0, 0, 2000, 302, 8L, Process.myTid(), "exitAIO");
      SplashActivity.sExitAIOTime = SystemClock.uptimeMillis();
    }
    this.jdField_d_of_type_Int = 7;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "finish " + paramInt, hashCode(), this.jdField_d_of_type_Int);
    if (c(paramInt)) {
      return true;
    }
    PlayLastLogic.b();
    W();
    bB();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false))) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.moveTaskToBack(true);
    }
    L();
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.c();
    if (paramInt == 0) {
      T();
    }
    while (paramInt != 1)
    {
      try
      {
        Object localObject = this.jdField_a_of_type_AndroidWidgetTextView.getTag();
        String[] arrayOfString = (String[])localObject;
        if ((localObject != null) && ("comic".equals(arrayOfString[0]))) {
          VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", arrayOfString[1], new String[] { "3" });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      if ((this.jdField_x_of_type_Boolean) && (!this.jdField_y_of_type_Boolean) && (AIOUtils.jdField_o_of_type_Boolean))
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
        this.jdField_y_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
      }
      as();
      DuiButtonImageView.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(13);
      this.jdField_d_of_type_Int = 8;
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, hashCode());
      if (this.X) {
        a(false, null, false);
      }
      BaseChatItemLayout.jdField_a_of_type_Boolean = this.W;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, String.format("finish preCheckBoxVisible=[%b]", new Object[] { Boolean.valueOf(this.W) }));
      }
      return false;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
    }
    for (;;)
    {
      HapticManager localHapticManager = HapticManager.a();
      if (localHapticManager == null) {
        break;
      }
      localHapticManager.c();
      break;
      T();
    }
  }
  
  public void ba()
  {
    QLog.d("CheckPermission", 1, "CheckPermission user grant");
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      try
      {
        localObject = SmartDeviceProxyMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        if (localObject == null) {
          continue;
        }
        i1 = ((DeviceInfo)localObject).productId;
      }
      catch (Exception localException)
      {
        Object localObject;
        i1 = 0;
        continue;
        i1 = 0;
        continue;
      }
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, 0);
      localObject = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (((BabyQHandler)localObject).a(0)) {
        ((BabyQHandler)localObject).a();
      }
      return;
      int i1 = 0;
    }
  }
  
  public void bb()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 3)
    {
      AIOEmoticonPanelHelper localAIOEmoticonPanelHelper = (AIOEmoticonPanelHelper)a(104);
      if (localAIOEmoticonPanelHelper != null) {
        localAIOEmoticonPanelHelper.doOnEmoticonPanelFullScreen();
      }
    }
  }
  
  public void bc()
  {
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (i1 != 1) && (i1 != 3))
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      ax();
    }
  }
  
  public void bd()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_i_of_type_AndroidWidgetTextView = null;
      this.jdField_m_of_type_AndroidViewView = null;
    }
  }
  
  public void be()
  {
    String str;
    int i1;
    Editable localEditable;
    if ((this.jdField_e_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null))
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      InputMethodUtil.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      str = this.jdField_e_of_type_AndroidWidgetTextView.getText().toString() + " ";
      i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
      localEditable = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
      if ((i1 < 0) || (i1 >= localEditable.length())) {
        localEditable.append(str);
      }
    }
    else
    {
      return;
    }
    localEditable.insert(i1, str);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0)
    {
      AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().getSpans(paramInt1, paramInt1 + paramInt2, AtTroopMemberSpan.class);
      if ((arrayOfAtTroopMemberSpan != null) && (arrayOfAtTroopMemberSpan.length > 0)) {
        ReportController.b(null, "dc00898", "", "", "0X800A9AC", "0X800A9AC", 0, 0, "", "", "", "");
      }
    }
    ((SpecWordEmotionThinkHelper)a(41)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
    ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  protected void bf() {}
  
  public void bg()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
    }
  }
  
  public void bh()
  {
    this.jdField_a_of_type_Long = 0L;
  }
  
  protected int c()
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
    int i1;
    if (localPhotoListPanel != null)
    {
      i1 = localPhotoListPanel.b();
      if (localPhotoListPanel == null) {
        break label39;
      }
    }
    label39:
    for (int i2 = localPhotoListPanel.c();; i2 = 0)
    {
      return i2 + i1;
      i1 = 0;
      break;
    }
  }
  
  @Deprecated
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
  }
  
  protected void c()
  {
    this.jdField_b_of_type_JavaLangString = "BaseChatPie";
  }
  
  public void c(int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(25);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131698490));
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    while ((paramInt != 1) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    ag();
    ah();
    if (QLog.isColorLevel()) {
      QLog.d("inputx", 2, "doPanelChanged newPanel=" + paramInt2);
    }
    f(paramInt1, paramInt2);
    A(paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(paramInt1, paramInt2);
    }
    if ((paramInt2 == 14) && (paramInt1 != 14) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
    }
    if ((paramInt1 == 2) && (paramInt2 != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
    }
    if ((paramInt1 != 2) && (paramInt2 == 2)) {
      this.jdField_e_of_type_Int = 0;
    }
    if ((paramInt1 == 36) && (paramInt2 != 36) && (paramInt2 != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.e();
    }
    bJ();
    e(paramInt1, paramInt2);
    ((IceBreakHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(10)).a(paramInt1, paramInt2);
    ((SimpleUIAIOHelper)a(29)).a(paramInt1, paramInt2);
  }
  
  public void c(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "updateSession");
    }
    this.Y = true;
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    h(paramIntent);
    StartupTracker.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    d(paramIntent);
    a(paramIntent);
    StartupTracker.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    a(paramIntent, true);
    StartupTracker.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    j(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this);
    StartupTracker.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "AIOTime updateSession end");
    }
  }
  
  protected void c(Editable paramEditable)
  {
    if (this.P)
    {
      if ((this.Q) || (paramEditable.length() <= 0)) {
        break label82;
      }
      this.jdField_r_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
      if ((this.jdField_r_of_type_Int == 2) || (this.jdField_r_of_type_Int == 3))
      {
        this.Q = true;
        this.jdField_n_of_type_Int = 1;
        if (this.jdField_b_of_type_JavaLangRunnable == null) {
          bI();
        }
        ThreadManager.getSubThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
      }
    }
    label82:
    while (paramEditable.length() != 0) {
      return;
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    this.Q = false;
    this.jdField_n_of_type_Int = 40;
    this.jdField_p_of_type_Int = 0;
    this.jdField_o_of_type_Int = 0;
    this.jdField_r_of_type_Int = 0;
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.onTouchEvent(paramMotionEvent);
  }
  
  public void c(View paramView)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.addView(paramView);
  }
  
  public void c(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "set left text from cancel");
    }
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690779);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.e();
    }
    ((AIOMultiActionHelper)a(66)).a(paramChatMessage);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
    AIOLongShotHelper localAIOLongShotHelper = (AIOLongShotHelper)a(15);
    if (localAIOLongShotHelper.a())
    {
      localAIOLongShotHelper.d();
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    }
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369543).setVisibility(4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
    }
    a(true, paramChatMessage, false);
  }
  
  protected void c(String paramString)
  {
    this.jdField_f_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void c(String paramString, int paramInt, RecordParams.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(36);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelUiVoiceTextPanel.setParam(paramString, paramRecorderParam, paramInt, this.jdField_c_of_type_JavaLangString);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a(paramBoolean);
  }
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramBoolean1, paramBoolean2);
  }
  
  protected boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
  }
  
  public void d()
  {
    b(true, this.jdField_k_of_type_Boolean);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
  }
  
  public void d(int paramInt)
  {
    paramInt = Math.max(paramInt, 0);
    Object localObject = (LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367664);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((LinearLayout)localObject).getLayoutParams();
    if (paramInt != localLayoutParams.bottomMargin)
    {
      localLayoutParams.bottomMargin = paramInt;
      ((LinearLayout)localObject).setLayoutParams(localLayoutParams);
      ((SimpleUIAIOHelper)a(29)).d();
    }
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_d_of_type_AndroidViewView.getLayoutParams();
      paramInt = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getPaddingBottom() + paramInt;
      if (paramInt != ((RelativeLayout.LayoutParams)localObject).bottomMargin)
      {
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt;
        this.jdField_d_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
  
  protected void d(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(3);
  }
  
  protected void d(Editable paramEditable)
  {
    if ((!this.F) && (paramEditable.length() > 0) && (this.K))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(84);
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(), b(), true);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(84, 10000L);
    }
  }
  
  public void d(View paramView)
  {
    this.jdField_c_of_type_AndroidViewViewGroup.removeView(paramView);
  }
  
  public void d(ChatMessage paramChatMessage)
  {
    a(paramChatMessage, 0, 0L, null);
  }
  
  public void d(String paramString)
  {
    a(2, paramString, this.jdField_a_of_type_Long);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.36(this));
  }
  
  @TargetApi(13)
  public void d(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 1;
    int i3;
    label72:
    Point localPoint;
    if (!paramBoolean)
    {
      this.jdField_A_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getRequestedOrientation();
      i3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.b())
      {
        if (i3 == 1)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
          i1 = i2;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          ((FragmentActivity)localObject).setRequestedOrientation(i1);
          break label72;
          break label72;
        }
        while (i3 != 2) {
          return;
        }
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
        if (VersionUtils.c()) {}
        for (i1 = 6;; i1 = 0)
        {
          ((FragmentActivity)localObject).setRequestedOrientation(i1);
          return;
        }
      }
      if (VersionUtils.f())
      {
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindowManager().getDefaultDisplay();
        i2 = ((Display)localObject).getRotation();
        localPoint = new Point();
        ((Display)localObject).getSize(localPoint);
        if ((i2 == 0) || (i2 == 2)) {
          if (localPoint.jdField_x_of_type_Int > localPoint.jdField_y_of_type_Int) {
            if (i2 != 0) {}
          }
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(i1);
      return;
      i1 = 8;
      continue;
      if (i2 != 0)
      {
        i1 = 9;
        continue;
        if (localPoint.jdField_x_of_type_Int > localPoint.jdField_y_of_type_Int)
        {
          if (i2 == 1) {
            continue;
          }
          i1 = 8;
          continue;
        }
        if (i2 == 1)
        {
          i1 = 9;
          continue;
          i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindowManager().getDefaultDisplay().getRotation();
          if ((i1 == 0) || (i1 == 1))
          {
            if (i3 == 1)
            {
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(1);
              return;
            }
            if (i3 != 2) {
              break;
            }
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(0);
            return;
          }
          if ((i1 != 2) && (i1 != 3)) {
            break;
          }
          if (i3 == 1)
          {
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(9);
            return;
          }
          if (i3 != 2) {
            break;
          }
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(8);
          return;
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(this.jdField_A_of_type_Int);
          return;
        }
      }
      i1 = 1;
    }
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (!this.jdField_g_of_type_Boolean)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!localFriendsManager.d())
        {
          ThreadManager.executeOnSubThread(new BaseChatPie.64(this));
          return;
        }
        long l1 = System.currentTimeMillis();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
          b(localFriendsManager, paramBoolean1, paramBoolean2);
        }
        while (QLog.isColorLevel())
        {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAudioPanelIfNeed cost :" + (System.currentTimeMillis() - l1) + " isCallFromOnShow = " + paramBoolean1 + " guide = " + paramBoolean2);
          return;
          a(localFriendsManager, paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  protected boolean d()
  {
    return false;
  }
  
  public int e()
  {
    int i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Normal_MaxPtt") * 1000;
    int i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if ((i2 & 0x4) != 0) {
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt") * 1000;
    }
    for (;;)
    {
      i1 -= 200;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711687, i1);
      return i1 + 200;
      if ((i2 & 0x2) != 0) {
        i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt") * 1000;
      }
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(3);
    b(false, false);
    E();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void e(int paramInt)
  {
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(paramInt);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  protected void e(Intent paramIntent)
  {
    boolean bool2 = true;
    Object localObject1 = paramIntent.getExtras();
    boolean bool4;
    label83:
    Object localObject3;
    Object localObject2;
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_i_of_type_Boolean = true;
      aO();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription(HardCodeUtil.a(2131701056));
      bool1 = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
      boolean bool3 = paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false);
      bool4 = paramIntent.getBooleanExtra("need_to_show_unread_num", false);
      if (!bool3) {
        break label472;
      }
      this.jdField_d_of_type_Boolean = true;
      localObject1 = null;
      if (!this.jdField_d_of_type_Boolean) {
        break label625;
      }
      long l1 = System.currentTimeMillis();
      ThreadManagerV2.excute(new BaseChatPie.19(this), 32, null, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: " + (System.currentTimeMillis() - l1));
      }
      localObject3 = paramIntent.getStringExtra("backName");
      if (!android.text.TextUtils.isEmpty((CharSequence)localObject3))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
        aO();
        localObject2 = paramIntent.getStringExtra("comicId");
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        localTextView.setTag(new String[] { "comic", paramIntent });
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回QQ动漫");
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "set left text from update left: " + (String)localObject1 + ", back: " + (String)localObject3);
      }
      if (ChatActivityConstants.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131701033));
        if (!this.jdField_d_of_type_Boolean)
        {
          localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
          paramIntent = (Intent)localObject1;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690601).equals(localObject1)) {
            paramIntent = HardCodeUtil.a(2131701069) + (String)localObject1 + HardCodeUtil.a(2131701035);
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.e();
        paramIntent = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
        if (this.jdField_k_of_type_Boolean) {
          break label672;
        }
      }
    }
    label672:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramIntent.a(bool1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
      if (localObject1 == null) {
        break;
      }
      this.jdField_i_of_type_Boolean = ((Bundle)localObject1).getBoolean("isBack2Root");
      if (!this.jdField_i_of_type_Boolean) {
        break;
      }
      aO();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription(HardCodeUtil.a(2131701066));
      break;
      label472:
      if (bool1)
      {
        localObject1 = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (localObject1 == null) {}
        for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690778);; localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131717621, new Object[] { localObject1 }))
        {
          this.jdField_d_of_type_Boolean = false;
          break;
        }
      }
      if (bool4)
      {
        this.jdField_d_of_type_Boolean = true;
        localObject1 = null;
        break label83;
      }
      localObject1 = paramIntent.getStringExtra("leftViewText");
      if ((this.jdField_i_of_type_Boolean) || ((localObject1 != null) && (((String)localObject1).contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131719718))))) {}
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_d_of_type_Boolean = bool1;
        if (this.jdField_x_of_type_Boolean) {
          this.jdField_d_of_type_Boolean = true;
        }
        break;
      }
      label625:
      localObject3 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject1 == null) {}
      for (localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131690778);; localObject2 = localObject1)
      {
        ((TextView)localObject3).setText((CharSequence)localObject2);
        aO();
        break;
      }
    }
  }
  
  public void e(@Nullable String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) || (!PokeItemHelper.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.F)) {}
    String str;
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        i1 = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 9);
        i2 = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4);
        int i3 = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 11);
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, String.format("showStickerBubbleQuickButtonIfNeeded  peInputSwitch :%dentryType:%d,viewType:%d ", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2), Integer.valueOf(i3) }));
      }
      str = paramString;
      if (paramString == null) {
        str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      }
    } while ((!str.isEmpty()) || (StickerBubbleAnimationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()) <= 0));
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    ABTestController.a("exp_qq_msg_marketface_input_icon").a();
    this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(StickerBubbleAnimationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()));
    int i2 = this.jdField_d_of_type_AndroidViewView.getWidth();
    if (i2 == 0) {}
    for (int i1 = AIOUtils.a(37.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());; i1 = i2)
    {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight() < i1) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), i1, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("ZhituManager", 4, "showZhituIcon.rightPadding." + i1 + " ,pr = " + i2 + ",input.getPaddingRight() = " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight());
      }
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(HardCodeUtil.a(2131701040) + PEPanelHelper.a(StickerBubbleAnimationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())));
      }
      if (this.T) {
        break;
      }
      ReportController.b(a(), "dc00898", "", "", "0X8009272", "0X8009272", StickerBubbleAnimationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()), 0, "", "", "", "");
      this.T = true;
      return;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    if (y()) {}
    do
    {
      return;
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(this.jdField_b_of_type_JavaLangString, 2, "leftBackEvent() disableBackForPTV true");
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 10))
    {
      BaseChatPie.31 local31 = new BaseChatPie.31(this, paramBoolean);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131689928), this.jdField_a_of_type_AndroidContentContext.getString(2131689926), this.jdField_a_of_type_AndroidContentContext.getString(2131689927), local31, local31).show();
      return;
    }
    t(paramBoolean);
  }
  
  protected boolean e()
  {
    return false;
  }
  
  public int f()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void f()
  {
    this.jdField_d_of_type_Int = 2;
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "preStartBaseAIO", hashCode(), this.jdField_d_of_type_Int);
    this.I = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().c(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    this.jdField_v_of_type_Boolean = true;
    this.jdField_A_of_type_Boolean = false;
    this.C = false;
    this.jdField_w_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.jdField_a_of_type_Boolean = false;
    this.W = BaseChatItemLayout.jdField_a_of_type_Boolean;
    BaseChatItemLayout.jdField_a_of_type_Boolean = false;
    AIOUtils.a(false);
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    g();
    StartupTracker.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    j();
    StartupTracker.a("AIO_doOnCreate_initData", "AIO_updateSession");
  }
  
  protected void f(int paramInt) {}
  
  protected void f(Intent paramIntent)
  {
    if (ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramIntent, this.jdField_a_of_type_MqqOsMqqHandler)) {
      this.jdField_i_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isBack2Root", false);
    }
  }
  
  protected void f(String paramString)
  {
    int i3 = 0;
    if (!a().equals(paramString)) {
      return;
    }
    paramString = UinTypeUtil.c;
    int i4 = paramString.length;
    int i1 = 0;
    for (;;)
    {
      int i2 = i3;
      if (i1 < i4)
      {
        i2 = paramString[i1];
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == i2) {
          i2 = 1;
        }
      }
      else
      {
        if (i2 == 0) {
          break;
        }
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.54(this));
        return;
      }
      i1 += 1;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2, paramBoolean);
  }
  
  public boolean f()
  {
    return true;
  }
  
  public int g()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  protected void g()
  {
    this.D = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377356));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.a(this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnChangeMultiScreenListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShowChangeListener(new BaseChatPie.2(this));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362327));
    PokeItemAnimationManager.a().a((FitSystemWindowsRelativeLayout)this.jdField_d_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364598));
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131374581);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131364700));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131374586));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377159));
    this.jdField_k_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131377160));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379487));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131378647));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369487));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369525));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369878));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131380148));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369543));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369501));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369516));
    this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376828));
    this.jdField_j_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131376829));
    this.jdField_j_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369496));
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695349));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "afroot: " + this.jdField_d_of_type_AndroidViewViewGroup + ", mDefautlBtnLeft: " + this.jdField_c_of_type_AndroidWidgetTextView + ", isThemeDefault: " + this.D);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370317).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690888));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379432));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365891));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379477));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379478));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379479));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqViewFlipper = ((QqViewFlipper)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379525));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqViewFlipper.setMeasureAllChildren(false);
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379523));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131379524));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131374428));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131366067));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131370460));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new BaseChatPie.MyOnGestureListener(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362743));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a = this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = new AIOFooterViewDetector(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ((ChatPieSelectableHelper)a(4)).b();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQBlurView = ((QQBlurView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131381097));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131372729));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setHelperProvider(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369141));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.EMOTION_INPUT_FACTORY);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper$IMECommandListener = new BaseChatpieHelper.IMECommandListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper$IMECommandListener);
      DeviceLib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).a(this.jdField_c_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(0);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367663));
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setText(HardCodeUtil.a(2131701046));
      if (AppSetting.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription(HardCodeUtil.a(2131701037));
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnLongClickListener(new BaseChatPie.3(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout = ((InputLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131369142));
      this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362415);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362414));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnTouchListener(this);
      AccessibilityUtil.a(this.jdField_a_of_type_AndroidWidgetImageButton, new BaseChatPie.4(this));
      bV();
      this.K = false;
      aK();
      aJ();
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = new ArkRecommendController(this);
      }
      this.jdField_k_of_type_AndroidWidgetImageView.setVisibility(8);
      a();
      bj();
      if (Build.VERSION.SDK_INT >= 16)
      {
        ViewGroup localViewGroup = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131373454);
        SystemDragUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localViewGroup, a(), a());
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup.getParent() instanceof DrawerFrame))
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = ((DrawerFrame)this.jdField_c_of_type_AndroidViewViewGroup.getParent());
        this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame.a();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e(this.jdField_b_of_type_JavaLangString, 1, "input set error", localException);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetDrawerFrame = new DrawerFrame(this.jdField_a_of_type_AndroidContentContext, this.jdField_c_of_type_AndroidViewViewGroup);
    }
  }
  
  public final void g(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramInt);
  }
  
  public void g(Intent paramIntent)
  {
    if (paramIntent == null) {}
    while ((!paramIntent.getBooleanExtra("click_long_screen_shot", false)) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivitySelectableChatSelCurPageForLSSHelper.a();
  }
  
  public void g(String paramString)
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_AndroidContentContext, paramString, new BaseChatPie.65(this), null);
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365802)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131694615));
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131365807)).setText(paramString);
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  public void g(boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)
    {
      localObject = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
      if (((InputMethodManager)localObject).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))
      {
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
        }
      }
      else if (((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() instanceof VoiceTextPanel)) && (((InputMethodManager)localObject).isActive()))
      {
        if (!paramBoolean) {
          break label92;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
      }
    }
    label92:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      break;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      return;
      localObject = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    } while ((localObject == null) || (((View)localObject).getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "hideAllPanels  curPanel = " + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public boolean g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a()))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.b()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer.a(true);
      }
      return true;
    }
    ChatPieSelectableHelper localChatPieSelectableHelper = (ChatPieSelectableHelper)a(4);
    if ((localChatPieSelectableHelper != null) && (localChatPieSelectableHelper.a())) {
      return true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b(a());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onBackEvent() disableBackForPTV true");
      }
      return false;
    }
    if (((HiddenChatHelper)a(39)).a()) {
      return true;
    }
    ((SpecWordEmotionThinkHelper)a(41)).a();
    return b(0);
  }
  
  public int h()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "[initApolloSurfaceView],mCurrentAIOState:" + this.jdField_d_of_type_Int);
    }
    bk();
    this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.b(this);
  }
  
  protected void h(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_b_of_type_JavaLangString, 2, "updateListUnRead: " + paramInt);
    }
    if ((paramInt == 0) && (this.jdField_n_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_n_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt));
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    while (paramInt <= 0)
    {
      if ((this.jdField_n_of_type_AndroidWidgetTextView != null) && (BaseChatItemLayout.jdField_a_of_type_Boolean)) {
        this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_n_of_type_AndroidWidgetTextView == null) {
      aa();
    }
    TextView localTextView = this.jdField_n_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (String str = "99";; str = Integer.toString(paramInt))
    {
      localTextView.setText(str);
      this.jdField_n_of_type_AndroidWidgetTextView.setVisibility(0);
      ((UnreadBackBottomHelper)a(53)).a();
      break;
    }
  }
  
  public void h(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  public void h(boolean paramBoolean) {}
  
  public boolean h()
  {
    return ((this instanceof TroopChatPie)) || ((this instanceof DiscussChatPie));
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(paramMessage)) {}
    do
    {
      do
      {
        do
        {
          RelativeLayout.LayoutParams localLayoutParams;
          do
          {
            do
            {
              return true;
              g(paramMessage);
              c(paramMessage);
              d(paramMessage);
              a(paramMessage);
              b(paramMessage);
              a(paramMessage);
              b(paramMessage);
              e(paramMessage);
              ((FastImageHelper)a(83)).a(paramMessage);
              e(paramMessage);
              f(paramMessage);
              switch (paramMessage.what)
              {
              default: 
                return true;
              case 42: 
                boolean bool = paramMessage.getData().getBoolean("showRedDot");
                if (bool) {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B00", "0X8005B00", 0, 0, "", "", "", "");
                }
                this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b(bool);
                return true;
              case 16711683: 
                QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131719024, 1).b(a());
                return true;
              }
            } while ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (paramMessage.arg1 <= 50));
            localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
          } while ((localLayoutParams == null) || (localLayoutParams.bottomMargin == paramMessage.arg1));
          localLayoutParams.setMargins(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.rightMargin, paramMessage.arg1);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(localLayoutParams);
          return true;
          c(paramMessage);
          return true;
          paramMessage = (PlusPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(8);
        } while (paramMessage == null);
        paramMessage.a();
        return true;
        d(paramMessage);
        return true;
        d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 3);
        return true;
        c(true, true);
        return true;
        aL();
        return true;
      } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager == null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.c();
      return true;
    } while ((!(paramMessage.obj instanceof CharSequence)) || (this.jdField_i_of_type_AndroidWidgetTextView == null));
    paramMessage = (CharSequence)paramMessage.obj;
    this.jdField_i_of_type_AndroidWidgetTextView.setText(paramMessage);
    this.jdField_i_of_type_AndroidWidgetTextView.requestLayout();
    return true;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTypeface(VasShieldFont.a());
    return true;
  }
  
  public int i()
  {
    return this.jdField_c_of_type_AndroidViewViewGroup.getMeasuredHeight();
  }
  
  public void i()
  {
    bk();
    this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.c(this);
  }
  
  public void i(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_h_of_type_Int = paramInt;
      android.os.Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
    }
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_t_of_type_Boolean = paramBoolean;
  }
  
  public boolean i()
  {
    return l();
  }
  
  protected void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = new AIOTipsController(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    if (this.jdField_a_of_type_ComTencentAvGaudioAVObserver == null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new BaseChatPie.MyAVObserver(this, null);
    }
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLoudSpeakerState();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_p_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(1);
  }
  
  public void j(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void j(boolean paramBoolean)
  {
    int i2 = 0;
    Object localObject = (FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034)) {}
    for (int i1 = 1; (((FullScreenInputHelper)localObject).b()) && ((i1 != 0) || (m())); i1 = 0)
    {
      ((FullScreenInputHelper)localObject).a(true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    if ((paramBoolean) && (((FullScreenInputHelper)localObject).b())) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "doShowPtv clickAioPanel:" + paramBoolean + ", fullMode:" + y());
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isUsingCameraOnVideo()) {
        break label226;
      }
      QQToast.a(BaseApplicationImpl.getContext(), 2131695877, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299166));
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005E91", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 1) {
        break;
      }
      ai();
      return;
    }
    label226:
    if (CaptureUtil.a())
    {
      localObject = StoryPublishLauncher.a(new SessionWrap(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString), this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getClass().getName(), 10000, 100);
      ((Bundle)localObject).putInt("VIDEO_STORY_FROM_TYPE", AECameraEntry.e.a());
      if (bool) {}
      for (i1 = 200;; i1 = 205)
      {
        ((Bundle)localObject).putInt("AECAMERA_MODE", i1);
        ((Bundle)localObject).putInt("qq_sub_business_id", 106);
        ((Bundle)localObject).putBoolean("input_full_screen_mode", bool);
        StoryPublishLauncher.a().a(a(), (Bundle)localObject, 11);
        AELaunchRecorder.a().a(false);
        AELaunchRecorder.a().e();
        break;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
    for (;;)
    {
      try
      {
        localObject = SmartDeviceProxyMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        i1 = i2;
        if (localObject != null) {
          i1 = ((DeviceInfo)localObject).productId;
        }
      }
      catch (Exception localException)
      {
        i1 = 0;
        continue;
      }
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, 1);
      break;
      i1 = 0;
    }
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.jdField_b_of_type_Boolean;
  }
  
  protected void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips = new QQOperateTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ReaderTipsBar localReaderTipsBar = new ReaderTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar = new FraudTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_MqqOsMqqHandler);
    HongbaoKeywordGrayTips localHongbaoKeywordGrayTips = new HongbaoKeywordGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ComicTipsBar localComicTipsBar = new ComicTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar = new LocationShareTipsBar(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localReaderTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localComicTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localHongbaoKeywordGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localVipSpecialCareGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLocationShareTipsBar);
  }
  
  public void k(int paramInt)
  {
    AudioUtil.b(paramInt, false);
  }
  
  public void k(boolean paramBoolean)
  {
    Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBoolean) {
      if ((localFragment != null) && (((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
        ((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_Boolean = paramBoolean;
      }
      return;
      if ((localFragment != null) && (((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
        ((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
      }
    }
  }
  
  public boolean k()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b());
  }
  
  protected void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "showAddFriendAndShield() ==== called.");
    }
    String str = a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    View localView;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      BaseChatPie.8 local8 = new BaseChatPie.8(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setId(2131362584);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131297098));
      localLayoutParams.addRule(3, 2131377159);
      if (!this.D) {
        localLayoutParams.topMargin = 0;
      }
      this.jdField_j_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals(""))))
      {
        this.jdField_j_of_type_AndroidWidgetTextView.setEnabled(false);
        this.jdField_j_of_type_AndroidWidgetTextView.setClickable(false);
        this.jdField_j_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131296474));
        this.jdField_j_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
        this.jdField_j_of_type_AndroidWidgetTextView.setOnClickListener(local8);
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
        localLayoutParams1.weight = 1.0F;
        localView = new View(this.jdField_a_of_type_AndroidContentContext);
        LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(1, -1);
        this.jdField_k_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_k_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131689912));
        this.jdField_k_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296474));
        if (!this.D) {
          break label814;
        }
        localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838059);
        label393:
        this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
        this.jdField_k_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        this.jdField_k_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_k_of_type_AndroidWidgetTextView.getText());
        this.jdField_k_of_type_AndroidWidgetTextView.setOnClickListener(local8);
        this.jdField_k_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(3));
        localObject = new LinearLayout.LayoutParams(0, -1);
        ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
        if (!this.D) {
          break label831;
        }
        localView.setBackgroundColor(Color.parseColor("#d3d5dc"));
        this.jdField_j_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838396));
        this.jdField_k_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838396));
        this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167110));
        this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167110));
        label577:
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_j_of_type_AndroidWidgetTextView, localLayoutParams1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_k_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
        this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      }
    }
    else
    {
      if (!this.D) {
        break label938;
      }
    }
    label938:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838397);; localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838400))
    {
      boolean bool = B();
      if (bool)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838083);
        this.jdField_j_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719436));
        this.jdField_j_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
      }
      this.jdField_j_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      a(bool, str);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131297098) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299166));
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      this.jdField_j_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_j_of_type_AndroidWidgetTextView.setClickable(true);
      break;
      label814:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838062);
      break label393;
      label831:
      this.jdField_j_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130838395));
      this.jdField_k_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838395));
      localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166465));
      this.jdField_j_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131167109));
      this.jdField_k_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167109));
      break label577;
    }
  }
  
  public void l(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.35(this, paramInt));
  }
  
  public void l(boolean paramBoolean)
  {
    int i1 = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
      break label26;
    }
    label26:
    while ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) || (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName))) {
      return;
    }
    boolean bool1;
    label75:
    Object localObject;
    QQAppInterface localQQAppInterface;
    Context localContext;
    String str1;
    String str2;
    XEditTextEx localXEditTextEx;
    if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) != null)
    {
      bool1 = true;
      localObject = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localContext = this.jdField_a_of_type_AndroidContentContext;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "";
      localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label253;
      }
    }
    label253:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject = AtTroopMemberSpan.a(localQQAppInterface, localContext, str1, str2, (String)localObject, bool1, localXEditTextEx, bool2, true);
      if ((localObject == null) || (((SpannableString)localObject).length() <= 0)) {
        break;
      }
      if (!paramBoolean) {
        break label259;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject);
      return;
      bool1 = false;
      break label75;
    }
    label259:
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart() < 0) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(i1, (CharSequence)localObject);
      return;
      i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
    }
  }
  
  public boolean l()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  protected void m()
  {
    boolean bool2 = B();
    if (bool2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "Manage_stranger", "Manage_str_add", 0, 0, "", "", "", "");
    }
    FragmentActivity localFragmentActivity = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
    SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131690778);
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("param_return_addr") != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ChatActivityUtils.a(localFragmentActivity, localSessionInfo, str, bool1, bool2, a());
      return;
    }
  }
  
  public void m(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(7);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(true);
    StartupTracker.a("AIO_SysMsgCost", "AIO_onShow_first");
    this.jdField_w_of_type_Boolean = true;
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    AIOUtils.a(this.jdField_b_of_type_JavaLangString, "onShowFirst " + paramInt, hashCode(), this.jdField_d_of_type_Int);
    AIOUtils.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(false);
    g(131072);
    p();
    q();
    s(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(true);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
      ThreadManager.executeOnSubThread(new BaseChatPie.43(this), true);
    }
    Object localObject = new BaseChatPie.44(this);
    if (AppSetting.jdField_f_of_type_Boolean) {
      ThreadManager.executeOnSubThread((Runnable)localObject, true);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.a(false, 0);
      }
      bk();
      ae();
      ((ISpriteUtil)QRoute.api(ISpriteUtil.class)).canInitCmShow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      StartupTracker.a(null, "AIO_apolloSurface");
      if ((this.G) || (!b()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_b_of_type_JavaLangString, 2, "remove footerview for initApolloSurfaceView failed");
        }
      }
      u();
      ArkTipsManager.a().a(this);
      StartupTracker.a("AIO_apolloSurface", null);
      DuiButtonImageView.a();
      StartupTracker.a("AIO_onShow_first", null);
      localObject = (IApolloExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
      ((IApolloExtensionHandler)localObject).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      ((IApolloExtensionHandler)localObject).e(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if (Build.VERSION.SDK_INT >= 26) {}
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, new Object[] { Integer.valueOf(8) });
        CustomizeStrategyFactory.a().a(true);
        PokePanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!PokeItemHelper.jdField_b_of_type_Boolean)
        {
          ThreadManager.executeOnSubThread(new BaseChatPie.45(this));
          if (SplashActivity.sOpenAIOCode != 0)
          {
            HardCoderManager.a().a(SplashActivity.sOpenAIOCode);
            SplashActivity.sOpenAIOCode = 0;
          }
          VasShieldFont.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          localObject = (UrlSecurityCheckManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER);
          ((UrlSecurityCheckManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          ((UrlSecurityCheckManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
          bw();
          bx();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(8);
          return;
          ((Runnable)localObject).run();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.w(this.jdField_b_of_type_JavaLangString, 2, "disable auto fill error", localException);
          continue;
          if (!PEPanelHelper.jdField_a_of_type_Boolean) {
            ThreadManager.executeOnSubThread(new BaseChatPie.46(this));
          }
        }
      }
    }
  }
  
  public void m(boolean paramBoolean)
  {
    a(paramBoolean, TroopGiftPanel.jdField_e_of_type_Int);
  }
  
  public boolean m()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null;
  }
  
  protected void n()
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(a(), null);
    localActionSheet.setMainTitle(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131719438));
    localActionSheet.addButton(2131719436, 3);
    localActionSheet.addButton(2131719435);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new BaseChatPie.10(this, localActionSheet));
    localActionSheet.show();
    ReportController.b(null, "dc00898", "", "", "0X800ACA2", "0X800ACA2", 0, 0, "", "0", "0", "");
  }
  
  @TargetApi(11)
  public void n(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.jdField_a_of_type_Int + " currenttime:" + System.currentTimeMillis());
    }
    Object localObject;
    if (paramInt != this.jdField_a_of_type_Int)
    {
      if (paramInt != 1) {
        break label365;
      }
      if (this.jdField_l_of_type_AndroidWidgetTextView == null)
      {
        localObject = new Button(this.jdField_a_of_type_AndroidContentContext);
        ((Button)localObject).setId(2131381750);
        ((Button)localObject).setBackgroundResource(2130850415);
        ((Button)localObject).setTextSize(2, 14.0F);
        ((Button)localObject).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167011));
        ((Button)localObject).setText(2131690014);
        ((Button)localObject).setOnTouchListener(this);
        int i1 = ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).indexOfChild(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.addView((View)localObject, i1, localLayoutParams);
        this.jdField_l_of_type_AndroidWidgetTextView = ((TextView)localObject);
      }
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      a(true);
      localObject = (SimpleUIAIOHelper)a(29);
      if (localObject != null) {
        ((SimpleUIAIOHelper)localObject).e(true);
      }
      if (VersionUtils.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 1.0F);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      }
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      ag();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label365:
      if (paramInt != 2) {
        break;
      }
      af();
    }
    if (this.jdField_l_of_type_AndroidWidgetTextView != null) {
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) || (c() > 0)) {
      a(true);
    }
    for (;;)
    {
      localObject = (SimpleUIAIOHelper)a(29);
      if (localObject != null) {
        ((SimpleUIAIOHelper)localObject).e(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      if (VersionUtils.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 1.0F);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      }
      if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo == null) && (!(this instanceof GameRoomChatPie)) && (RichTextChatManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        aY();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
      }
      ar();
      break;
      a(false);
    }
  }
  
  public void n(boolean paramBoolean)
  {
    if (((a() instanceof SplashActivity)) && (SplashActivity.currentFragment != 2)) {
      return;
    }
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    localAIOAnimationControlManager.a(this);
    if (paramBoolean) {
      localAIOAnimationControlManager.b();
    }
    localAIOAnimationControlManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("AIOAnimationControlManager_limit_key", 4));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "playTroopGiftAnimationPlayList");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new BaseChatPie.72(this, localAIOAnimationControlManager, paramBoolean));
  }
  
  public boolean n()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0;
  }
  
  protected void o()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      int i1 = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131299166);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.topMargin = i1;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void o(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c(paramInt);
    }
    ((UnreadBackBottomHelper)a(53)).c(paramInt);
  }
  
  public void o(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramBoolean);
  }
  
  public boolean o()
  {
    return b() == 1008;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131369487) && (i1 != 2131369878) && (i1 != 2131380148) && (i1 != 2131370317)) {
      AIOUtils.jdField_o_of_type_Boolean = true;
    }
    if ((i1 != 2131362409) && (i1 != 2131373298)) {
      ((FastImageHelper)a(83)).b(true);
    }
    G();
    e(paramView);
    f(paramView);
    switch (i1)
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).setActionPlayList(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount(), this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount()));
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a() > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().e();
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 0);
      }
      paramView.setVisibility(8);
      ((UnreadBackBottomHelper)a(53)).onClick(paramView);
      continue;
      bl();
      continue;
      g(paramView);
      continue;
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!this.jdField_k_of_type_Boolean) {}
      for (boolean bool = true;; bool = false)
      {
        localQQAppInterface.setLoudSpeakerState(bool);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
        ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_k_of_type_Boolean);
        break;
      }
      ((FastImageHelper)a(83)).c();
    }
  }
  
  public void onMovedToScrapHeap(View paramView)
  {
    if (paramView == null) {}
    Object localObject1;
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
            PokeItemAnimationManager.a().a(paramView);
            localObject1 = AIOUtils.a(paramView);
          } while (!(localObject1 instanceof StructingMsgItemBuilder.StructingMsgViewHolder));
          localObject1 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
        } while ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForStructing)));
        localObject2 = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      } while ((!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForGeneralShare)) || ((!(this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) && (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))));
      if (((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).mIsPAVideoStructMsg) {
        AIOVideoPlayController.a().a(paramView, (StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg);
      }
      localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();
      localObject2 = ((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).getLayoutStr();
    } while (localObject1 == null);
    ((StructingMsgItemBuilder.ViewCache)localObject1).a((String)localObject2, (ViewGroup)paramView.findViewById(2131364634));
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetMobile2Wifi readconfirm network change");
    }
    bN();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetNone2Mobile readconfirm network change");
    }
    bN();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetNone2Wifi readconfirm network change");
    }
    bN();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "onNetWifi2Mobile readconfirm network change");
    }
    bN();
  }
  
  public void onNetWifi2None() {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(20);
    int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int i1 = paramInt3 - i3 - i2;
    int i4 = i1 - (paramInt1 - i3) - paramInt2;
    if (QLog.isColorLevel()) {
      QLog.i("BaseChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + i2 + ",headerCnt = " + i3 + ",botCnt=" + i4);
    }
    Object localObject = (QWalletAIOLifeCycleHelper)a(27);
    if (localObject != null) {
      ((QWalletAIOLifeCycleHelper)localObject).a(paramInt1);
    }
    a(paramInt1, paramInt2, paramInt3, i2, i3, i1, i4);
    localObject = PlayLastLogic.a();
    if (paramAbsListView.getChildAt(0) != null)
    {
      i1 = paramAbsListView.getChildAt(0).getTop();
      ((PlayLastLogic)localObject).a(paramInt1, paramInt2, i3, i2, paramInt3, i1, paramAbsListView.getWidth(), paramAbsListView.getHeight());
      if (this.jdField_f_of_type_Int >= paramInt1) {
        break label322;
      }
      b(this.jdField_i_of_type_AndroidViewView);
    }
    for (;;)
    {
      this.jdField_f_of_type_Int = paramInt1;
      if (paramInt1 + paramInt2 - 1 >= 0) {
        this.jdField_g_of_type_Int = (paramInt1 + paramInt2 - 1);
      }
      this.jdField_i_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
      this.jdField_j_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
      ((IceBreakHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(10)).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      if (paramInt1 + paramInt2 == paramInt3) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().f();
      }
      return;
      i1 = 0;
      break;
      label322:
      if ((paramInt1 + paramInt2 - 1 < this.jdField_g_of_type_Int) && (paramInt1 + paramInt2 - 1 > 0)) {
        b(this.jdField_j_of_type_AndroidViewView);
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool;
    if (AppSetting.jdField_k_of_type_Boolean)
    {
      if (paramInt != 0)
      {
        bool = true;
        ThreadPriorityManager.a(bool);
      }
    }
    else
    {
      this.jdField_c_of_type_Int = paramInt;
      NowVideoController.a().a(paramAbsListView, paramInt);
      ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, paramInt);
      if (paramInt != 0) {
        break label413;
      }
      ScrollPlayer.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      VasFaceManager.b();
      com.etrump.mixlayout.ETTextView.enableAnimation = true;
      FontManager.a(this);
      ShortVideoItemBuilder.f();
      ShortVideoRealItemBuilder.f();
      ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).resumeAllBrickPlayer();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.d();
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).bulkUpdateUserDress();
      ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).b();
      if (this.jdField_u_of_type_Boolean)
      {
        this.jdField_u_of_type_Boolean = false;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711697);
        paramAbsListView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711697);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramAbsListView, BubbleManager.jdField_a_of_type_Long);
      }
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      DiyPendantFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      EmojiStickerManager.a().b(this);
      DropFrameMonitor.a().a("list_aio_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
      DuiButtonImageView.d();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().b() == 0) {
        AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      ((UrlSecurityCheckManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(17);
      PlayLastLogic.a().a(this.jdField_c_of_type_Int);
      if (paramInt != 1) {
        break label571;
      }
      bU();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(15);
    }
    for (;;)
    {
      if (paramInt == 1) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().f();
      }
      return;
      bool = false;
      break;
      label413:
      ScrollPlayer.a(true);
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      }
      for (;;)
      {
        VasFaceManager.a();
        URLDrawable.pause();
        if (!PicItemBuilder.jdField_j_of_type_Boolean)
        {
          AbstractGifImage.pauseAll();
          ApngImage.pauseAll();
          com.etrump.mixlayout.ETTextView.enableAnimation = false;
        }
        AbstractVideoImage.pauseAll();
        ShortVideoItemBuilder.e();
        ShortVideoRealItemBuilder.e();
        ((IApolloItemBuilderHelper)QRoute.api(IApolloItemBuilderHelper.class)).pauseAllBrickPlayer();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
        if (paramInt == 1) {
          h(false);
        }
        ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a();
        DropFrameMonitor.a().a("list_aio_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
        DuiButtonImageView.c();
        ((UrlSecurityCheckManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.URL_SECURITY_CHECK_MANAGER)).a();
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
      }
      label571:
      if (paramInt == 2) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(16);
      }
    }
  }
  
  public void onScrollToButtom(int paramInt)
  {
    if (paramInt < 0)
    {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
      s(1);
      this.C = true;
      UnreadBackBottomHelper localUnreadBackBottomHelper = (UnreadBackBottomHelper)a(53);
      if (localUnreadBackBottomHelper != null) {
        localUnreadBackBottomHelper.a(paramInt);
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      ChatPieInputHelper.a(this).a(paramInt3);
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    aM();
    int i1 = paramMotionEvent.getAction();
    if (i1 == 0)
    {
      AIOEmoticonUIHelper localAIOEmoticonUIHelper = (AIOEmoticonUIHelper)a(105);
      if ((localAIOEmoticonUIHelper != null) && (localAIOEmoticonUIHelper.b()))
      {
        localAIOEmoticonUIHelper.d();
        if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
        }
        ar();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b(a());
    }
    ((FastImageHelper)a(83)).b(true);
    G();
    switch (paramView.getId())
    {
    default: 
      return false;
    case 2131370460: 
      if (this.K)
      {
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
        bV();
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        this.K = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(paramMotionEvent);
      }
      if (i1 == 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        return false;
        if ((i1 == 1) || (i1 == 3)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b(true);
        }
      }
    case 2131369141: 
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.onTouch(paramView, paramMotionEvent);
      return false;
    }
    a(paramView, paramMotionEvent);
    if ((g() != 28) && (paramMotionEvent.getAction() == 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80094D1", "0X80094D1", 0, 0, "", "", "", "");
    }
    return true;
  }
  
  public void p()
  {
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
      }
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.11(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new BaseChatPie.12(this));
  }
  
  public void p(int paramInt)
  {
    int i1 = -1;
    if (paramInt == 0) {
      i1 = ((IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a(i1);
      }
      this.jdField_y_of_type_Int = i1;
      ay();
      return;
      if (paramInt == 1) {
        i1 = 7;
      }
    }
  }
  
  public void p(boolean paramBoolean)
  {
    PhotoListPanel localPhotoListPanel = (PhotoListPanel)this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.b(4);
    if (localPhotoListPanel == null) {
      return;
    }
    localPhotoListPanel.setReceiptMode(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      localPhotoListPanel.setSelectLimitListener(new BaseChatPie.74(this));
      return;
    }
    localPhotoListPanel.setSelectLimitListener(null);
  }
  
  public boolean p()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1);
  }
  
  public void q()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378232);
      ((View)localObject).setBackgroundResource(2130839232);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setVisible(true, false);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.findViewById(2131378232).setVisibility(8);
  }
  
  public void q(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(paramInt);
  }
  
  public void q(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setIsInMultiScreen(paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_Boolean = paramBoolean;
    }
  }
  
  public boolean q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY ");
    }
    int i1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (i1 == 1)
    {
      if (!((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))
      {
        this.R = false;
        return true;
      }
    }
    else if ((i1 == 0) || ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
        this.R = false;
      }
      return true;
    }
    return false;
  }
  
  protected void r()
  {
    StartupTracker.a(null, "AIO_apolloFooterview");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
    IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    ISpriteUtil localISpriteUtil = (ISpriteUtil)QRoute.api(ISpriteUtil.class);
    int i2;
    if ((localIApolloManagerService.isInitDone()) && (1 == localIApolloManagerService.getApolloStatus(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) && (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!localISpriteUtil.isSpriteHidden(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (localISpriteUtil.canUseCmShow(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      i2 = localISpriteUtil.getWaitingMargin(this.jdField_a_of_type_AndroidContentContext);
      i1 = i2;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_b_of_type_JavaLangString, 2, new Object[] { "add apollo footerview on init UI, footerHeight:", Integer.valueOf(i2) });
      }
    }
    for (int i1 = i2;; i1 = 0)
    {
      if (i1 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(i1, false, "initUI", 0);
      }
      StartupTracker.a("AIO_apolloFooterview", null);
      return;
    }
  }
  
  protected void r(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {}
    FriendsManager localFriendsManager;
    do
    {
      do
      {
        return;
      } while (this.jdField_f_of_type_Boolean);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(paramInt, false);
        return;
      }
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        b(localFriendsManager);
        return;
      }
    } while (!E());
    a(localFriendsManager);
  }
  
  public void r(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((CommonTextView)this.jdField_e_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      ((OnlineStatusLyricView)this.jdField_f_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      ((CommonTextView)this.jdField_g_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.jdField_e_of_type_AndroidWidgetImageView).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.jdField_f_of_type_AndroidWidgetImageView).setMosaicEffect(new MosaicEffect(10));
      ((CommonImageView)this.jdField_g_of_type_AndroidWidgetImageView).setMosaicEffect(new MosaicEffect(10));
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131366102);
      if (localObject != null) {
        ((CommonImageView)localObject).setMosaicEffect(new MosaicEffect(10));
      }
      ((CommonTextView)this.jdField_d_of_type_AndroidWidgetTextView).setMosaicEffect(new MosaicEffect(10));
      if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        localObject = SkinEngine.getInstances().getDefaultThemeDrawable(2130850444);
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      return;
    }
    ((CommonTextView)this.jdField_e_of_type_AndroidWidgetTextView).setMosaicEffect(null);
    ((OnlineStatusLyricView)this.jdField_f_of_type_AndroidWidgetTextView).setMosaicEffect(null);
    ((CommonTextView)this.jdField_g_of_type_AndroidWidgetTextView).setMosaicEffect(null);
    ((CommonImageView)this.jdField_e_of_type_AndroidWidgetImageView).setMosaicEffect(null);
    ((CommonImageView)this.jdField_f_of_type_AndroidWidgetImageView).setMosaicEffect(null);
    ((CommonImageView)this.jdField_g_of_type_AndroidWidgetImageView).setMosaicEffect(null);
    Object localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.findViewById(2131366102);
    if (localObject != null) {
      ((CommonImageView)localObject).setMosaicEffect(null);
    }
    ((CommonTextView)this.jdField_d_of_type_AndroidWidgetTextView).setMosaicEffect(null);
    Q();
  }
  
  public boolean r()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar = new TimTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar, new Object[0]);
  }
  
  public void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelManager.s();
    if (this.jdField_g_of_type_AndroidViewView != null) {
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_h_of_type_AndroidViewView != null) {
      this.jdField_h_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 22)) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    }
  }
  
  public void s(int paramInt)
  {
    if (jdField_t_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "setVivoSetting isButtom=" + paramInt);
      }
      ThreadManager.getSubThreadHandler().post(new BaseChatPie.66(this, paramInt));
    }
  }
  
  public void s(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(paramBoolean);
  }
  
  protected final boolean s()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() == 0);
  }
  
  protected void t() {}
  
  public void t(int paramInt)
  {
    Object localObject = FlowCameraActivity2.class;
    if (CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString)) {
      localObject = MX3FlowCameraActivity.class;
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    ((Intent)localObject).putExtra("flow_camera_height", XPanelContainer.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("selected_item", 5);
    ((Intent)localObject).putExtra("selected_data", this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this));
    ((Intent)localObject).putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((Intent)localObject).putExtra("sv_config", ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SV658Cfg.name(), null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildBaseChatpieHelper.c((Intent)localObject);
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1010) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002)) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    if (paramInt == 1) {
      ((Intent)localObject).putExtra("flow_camera_capture_mode", true);
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("flow_camera_use_filter_function", PtvFilterSoLoad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()));
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject, 11000);
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005E7D", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a()) {
        MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      }
      if (PeakUtils.a != null) {
        PeakUtils.a.b();
      }
      return;
      if (paramInt == 2) {
        ((Intent)localObject).putExtra("flow_camera_video_mode", true);
      }
    }
  }
  
  public boolean t()
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isInMultiWindow()))) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 6) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 5)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (QLog.isColorLevel())) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "isActivityResume = " + bool);
    }
    return bool;
  }
  
  protected void u() {}
  
  protected void u(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a(paramInt);
    }
  }
  
  public boolean u()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_i_of_type_AndroidWidgetTextView != null)
    {
      bool1 = bool2;
      if (this.jdField_i_of_type_AndroidWidgetTextView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (a(paramObject)) {}
    do
    {
      return;
      if ((paramObject instanceof MessageRecord))
      {
        b(paramObject);
        return;
      }
      if ((paramObject instanceof QQMessageFacade.RefreshMessageContext))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList.a().a(paramObject);
        return;
      }
    } while (!(paramObject instanceof QQMessageFacade.MessageNotifyParam));
    c(paramObject);
  }
  
  protected void v()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public boolean v()
  {
    return false;
  }
  
  protected void w()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDrawerBaseChatDrawer = a();
  }
  
  protected boolean w()
  {
    return true;
  }
  
  protected void x()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_o_of_type_Boolean = true;
    ThreadManager.post(new GetTextDraftJob(this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this), 8, null, true);
  }
  
  public boolean x()
  {
    return this.jdField_w_of_type_Boolean;
  }
  
  protected void y() {}
  
  public boolean y()
  {
    return ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider.a(24)).b();
  }
  
  public void z()
  {
    if ((BusinessUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (BusinessUtils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  public boolean z()
  {
    return this.jdField_a_of_type_ComTencentWidgetPatchedButton.isEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */