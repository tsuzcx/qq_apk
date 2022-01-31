package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.StatFs;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
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
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
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
import com.rookery.translate.AITranslator;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVObserver;
import com.tencent.av.ui.AIOTopRightButtonConfig;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.now.NowVideoController;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.qqstory.takevideo.EditPicActivity;
import com.tencent.biz.thridappshare.ThridAppShareHelper;
import com.tencent.biz.troopgift.AIOGiftPanelContainer;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.widgets.ShareAioResultDialog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.devicelib.DeviceLib;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.AbstractVideoImage;
import com.tencent.image.ApngImage;
import com.tencent.image.NativeVideoImage;
import com.tencent.image.QQLiveImage;
import com.tencent.image.URLDrawable;
import com.tencent.logcat.LogcatUtil;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mobileqq.activity.aio.AIOInputTypeHelper;
import com.tencent.mobileqq.activity.aio.AIOTipsController;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout.OnChatMessageCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatContext;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager.Listener;
import com.tencent.mobileqq.activity.aio.PlusPanel;
import com.tencent.mobileqq.activity.aio.PlusPanelUtils;
import com.tencent.mobileqq.activity.aio.PokePanel;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.mobileqq.activity.aio.anim.AioAnimationDetector;
import com.tencent.mobileqq.activity.aio.anim.MoveToBottomScroller;
import com.tencent.mobileqq.activity.aio.anim.goldmsg.GoldMsgAnimatorCtr;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodlePanel;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.activity.aio.doodle.PlayLastLogic;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ItemBuilderFactory;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PokeItemAnimationManager;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoPTVItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ShortVideoRealItemBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.StructingMsgViewHolder;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.ViewCache;
import com.tencent.mobileqq.activity.aio.panel.AIOFakePanel;
import com.tencent.mobileqq.activity.aio.panel.AIOPanelUtiles;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout.PanelIconCallback;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanel;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageCountChangedListener;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.ImageSentListener;
import com.tencent.mobileqq.activity.aio.qim.QIMUserManager;
import com.tencent.mobileqq.activity.aio.qwallet.ScrollPlayer;
import com.tencent.mobileqq.activity.aio.rebuild.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.FriendChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GetTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.SaveTextDraftJob;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.activity.aio.stickerbubble.PEPanelHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationHelper;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegate;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleTouchDelegateCallbackForAIO;
import com.tencent.mobileqq.activity.aio.tim.TIMUserManager;
import com.tencent.mobileqq.activity.aio.tips.ArkTipsBar;
import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.FriendHotTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HongbaoKeywordGrayTips;
import com.tencent.mobileqq.activity.aio.tips.LightalkBlueTipsBar;
import com.tencent.mobileqq.activity.aio.tips.QQOperateTips;
import com.tencent.mobileqq.activity.aio.tips.ReaderTipsBar;
import com.tencent.mobileqq.activity.aio.tips.SougouInputGrayTips;
import com.tencent.mobileqq.activity.aio.tips.TimTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.activity.aio.tips.VideoStatusTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipFunCallTipsBar;
import com.tencent.mobileqq.activity.aio.tips.VipSpecialCareGrayTips;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.activity.qwallet.GoldConfigObserver;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgAioState;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgPayManager;
import com.tencent.mobileqq.activity.qwallet.widget.HongBaoPanel;
import com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import com.tencent.mobileqq.activity.richmedia.MX3FlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.MX3FlowNewCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.activity.richmedia.ShortVideoMtaReport;
import com.tencent.mobileqq.addon.DiyPendantFetcher;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.ApolloPanelManager;
import com.tencent.mobileqq.apollo.ApolloResponseManager;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.ChatPieApolloViewController;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteCommFunc;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.apollo.view.ApolloPanel;
import com.tencent.mobileqq.apollo.view.ChatApolloViewListener;
import com.tencent.mobileqq.apollo.view.InputGlobalLayoutListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.EmoticonObserver;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandler.MsgSendCostParams;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.VibrateListener;
import com.tencent.mobileqq.app.message.BaseMessageManager;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.QQMessageFacade.MessageNotifyParam;
import com.tencent.mobileqq.app.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.ArkAppManagerPanel;
import com.tencent.mobileqq.ark.ArkRecommendController;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.bubble.BubbleDiyFetcher;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUtils;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.bubble.ChatXListView.OnBottomOverScrollListener;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DraftTextInfo;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.doutu.DoutuEmotionAdapter;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuManager;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.doutu.combo.ComboUIManager;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.earlydownload.handler.PokeResHandler;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.emoticon.EmotionJsonDownloadListener;
import com.tencent.mobileqq.emoticon.SogouEmoji;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.FastImagePreviewLayout;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatObserver;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.hiboom.HiBoomManager;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.hotpic.HotPicHelper;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;
import com.tencent.mobileqq.hotpic.HotPicManager;
import com.tencent.mobileqq.hotpic.HotPicPageView;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl;
import com.tencent.mobileqq.lightReply.FacePicDectect;
import com.tencent.mobileqq.lightReply.LightReplyEmojs;
import com.tencent.mobileqq.lightReply.LightReplyMenuManager;
import com.tencent.mobileqq.lovelanguage.LoveLanguageConfig;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.service.MagicfaceActionManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.managers.DraftTextManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.nearby.FaceScoreUtils;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicUiInterface;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.ptt.PttSSCMPool;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.receipt.ReceiptUtil;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.richmedia.capture.activity.CameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.activity.CaptureSoDownloadActivity;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.fragment.AIOEffectsCameraCaptureFragment.Session;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.richstatus.RichStatus.SigZanInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoErrorReport;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.util.NativeSoLoader;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.QQCatchedExceptionReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.streamtransfile.StreamDataManager;
import com.tencent.mobileqq.structmsg.AIOVideoPlayController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.transfile.ShortVideoUploadABTest;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.troop.data.TroopAioAgent.Message;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager.UserActionStateInParallelPullPeriod;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.troop.text.ReplyClickMovementMethod;
import com.tencent.mobileqq.troop.text.ReplyedMessageSpan;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.SelfGagInfo;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troop.utils.TroopTopicMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troopgift.TroopGiftAnimationController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ThreadPriorityManager;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PAStartupTracker;
import com.tencent.mobileqq.utils.PerformanceReportUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.DrawableCenterTextView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mqq.shared_file_accessor.LogUtil;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollButtomListener;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AbsListView.RecyclerListener;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PatchedButton;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.SizeChangedCallback;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.OnChangeMultiScreenListener;
import com.tencent.widget.XPanelContainer.PanelCallback;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.comic.VipComicReportUtils;
import cooperation.peak.PeakUtils;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qlink.QQProxyForQlink;
import cooperation.qqindividuality.QQIndividualityUtils;
import cooperation.weiyun.ResponseHandler;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import rlu;
import rlv;
import rlw;
import rlx;
import rly;
import rlz;
import rma;
import rmb;
import rmc;
import rmd;
import rme;
import rmk;
import rml;
import rmm;
import rmn;
import rmo;
import rmp;
import rmq;
import rmr;
import rms;
import rmt;
import rmu;
import rmv;
import rmw;
import rmx;
import rmy;
import rmz;
import rna;
import rnb;
import rnc;
import rnd;
import rne;
import rnf;
import rng;
import rnh;
import rni;
import rnk;
import rnl;
import rnm;
import rno;
import rnp;
import rnq;
import rnr;
import rns;
import rnt;
import rnu;
import rnv;
import rnw;
import rnx;
import rny;
import rnz;
import roa;
import rob;
import roc;
import rod;
import rof;
import rog;
import roh;
import roi;
import roj;
import rok;
import rom;
import ron;
import roo;
import rop;
import roq;
import ror;
import ros;
import rot;
import rou;
import rox;
import roy;
import roz;
import rpa;
import rpb;
import rpc;
import rpd;
import rpe;
import rpf;
import rpg;
import rph;
import rpi;
import rpj;
import rpk;
import rpl;
import rpn;
import rpo;
import rpp;
import rpq;
import rpr;
import rps;
import rpt;
import rpu;
import rpy;
import rpz;
import rqb;
import rqc;
import rqd;
import rqi;
import rqk;
import rqn;
import rqq;
import rqs;
import rqt;
import rqu;
import rqv;
import rqw;
import rqx;
import rqz;
import rrd;
import rre;
import rrf;
import rrg;
import rrj;
import rrk;
import rrl;
import rrm;

public class BaseChatPie
  implements Handler.Callback, TextWatcher, View.OnClickListener, View.OnTouchListener, ChatActivityConstants, BaseChatItemLayout.OnChatMessageCheckedChangeListener, MediaPlayerManager.Listener, PanelIconLinearLayout.PanelIconCallback, CheckPttListener, CheckPtvListener, VibrateListener, ChatXListView.OnBottomOverScrollListener, EmoticonCallback, INetInfoHandler, AbsListView.OnScrollButtomListener, AbsListView.OnScrollListener, AbsListView.RecyclerListener, OverScrollViewListener, XPanelContainer.OnChangeMultiScreenListener, XPanelContainer.PanelCallback, Observer
{
  private static int E;
  private static boolean V;
  public static int l;
  private static int y;
  public static boolean z;
  private int A;
  public boolean A;
  private int B;
  public boolean B;
  private int C;
  public boolean C;
  private int D;
  public boolean D;
  public boolean E;
  private int F;
  public boolean F;
  private int G;
  public boolean G;
  private int H;
  public boolean H;
  public boolean I;
  public boolean J;
  public boolean K;
  boolean L;
  public boolean M;
  private boolean O = true;
  private boolean P = true;
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T = false;
  private boolean U;
  private boolean W = true;
  private volatile boolean X;
  private boolean Y;
  private boolean Z = true;
  public float a;
  protected int a;
  protected long a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new rnv(this);
  public Context a;
  protected MessageQueue.IdleHandler a;
  private PowerManager.WakeLock jdField_a_of_type_AndroidOsPowerManager$WakeLock;
  public FragmentActivity a;
  private MovementMethod jdField_a_of_type_AndroidTextMethodMovementMethod;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  protected View.OnClickListener a;
  protected View a;
  public ViewGroup a;
  public ViewStub a;
  public ImageButton a;
  public ImageView a;
  protected LinearLayout a;
  RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout a;
  public TextView a;
  private AVObserver jdField_a_of_type_ComTencentAvGaudioAVObserver;
  public AIOGiftPanelContainer a;
  private ShareAioResultDialog jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog;
  public AIOTipsController a;
  public ChatAdapter1 a;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  public PlusPanel a;
  public SessionInfo a;
  private AIOAnimationConatiner jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  public AIOFooterViewDetector a;
  public MoveToBottomScroller a;
  public GoldMsgAnimatorCtr a;
  public AudioPanel a;
  protected DoodlePanel a;
  final StructingMsgItemBuilder.ViewCache jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache = new StructingMsgItemBuilder.ViewCache();
  protected AIOFakePanel a;
  public PanelIconLinearLayout a;
  public PokeAndEmoPanel a;
  protected PhotoListPanel.ImageCountChangedListener a;
  private PhotoListPanel.ImageSentListener jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener = new rms(this);
  public PhotoListPanel a;
  private StickerBubbleTouchDelegate jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  protected ArkTipsBar a;
  public FraudTipsBar a;
  public LightalkBlueTipsBar a;
  public QQOperateTips a;
  protected TimTipsBar a;
  public TipsManager a;
  public VideoStatusTipsBar a;
  protected VipFunCallTipsBar a;
  GoldConfigObserver jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldConfigObserver = new rps(this);
  public PasswdRedBagManager a;
  public GoldMsgAioState a;
  protected HongBaoPanel a;
  public ChatPieApolloViewController a;
  public ApolloInfo a;
  public ApolloPanel a;
  public ChatApolloViewListener a;
  public InputGlobalLayoutListener a;
  private CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new rqc(this);
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new rqb(this);
  private EmoticonObserver jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver = new rqi(this);
  public FriendListHandler a;
  private FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new rpu(this);
  private MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new rpz(this);
  public QQAppInterface a;
  public QQMapActivityProxy a;
  private ShortVideoObserver jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver = new rqk(this);
  public QQMessageFacade.RefreshMessageContext a;
  protected ArkAppManagerPanel a;
  public ArkRecommendController a;
  public ChatXListView a;
  protected ChatMessage a;
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  public MessageForReplyText.SourceMsgInfo a;
  private NoC2CExtensionInfo jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
  private DoutuManager jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager;
  public ComboUIManager a;
  private SogouEmoji jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji;
  public EmoticonMainPanel a;
  private EmotionKeywordAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter;
  private EmotionKeywordHorizonListView jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView;
  public FastImagePreviewLayout a;
  private FMObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver;
  FlashChatObserver jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver = new rpy(this);
  FlashChatPanel jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel;
  protected HotPicMainPanel a;
  private MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  private DraftTextManager jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager;
  private EmoticonManager jdField_a_of_type_ComTencentMobileqqModelEmoticonManager;
  public AIOShareActionSheet a;
  public TroopAioTips a;
  public TroopMessageManager.UserActionStateInParallelPullPeriod a;
  public TroopGiftAnimationController a;
  public QQCustomDialog a;
  public QQRecorder a;
  VasExtensionObserver jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver = new rqd(this);
  public QQProgressDialog a;
  public ScrollerRunnable a;
  public ToastStyleDialog a;
  public NavBarAIO a;
  public PatchedButton a;
  XEditTextEx.SizeChangedCallback jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback = new rnb(this);
  public XEditTextEx a;
  public XPanelContainer a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  public CharSequence a;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  public String a;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder("");
  protected List a;
  public AtomicBoolean a;
  public final MqqHandler a;
  protected rrf a;
  public boolean a;
  public View[] a;
  ViewGroup[] jdField_a_of_type_ArrayOfAndroidViewViewGroup;
  AnimationSet[] jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet;
  public FrameLayout[] a;
  ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private boolean aa;
  private boolean ab;
  private boolean ac;
  private boolean ad;
  private boolean ae = true;
  private boolean af;
  protected final int b;
  public long b;
  public Dialog b;
  protected View b;
  public ViewGroup b;
  public ImageView b;
  public LinearLayout b;
  RelativeLayout.LayoutParams jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  public RelativeLayout b;
  public TextView b;
  protected PhotoListPanel b;
  protected ChatMessage b;
  public QQCustomDialog b;
  public QQProgressDialog b;
  private ToastStyleDialog jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  public Runnable b;
  protected String b;
  private List jdField_b_of_type_JavaUtilList;
  public boolean b;
  public int c;
  public long c;
  public Dialog c;
  public View c;
  public ViewGroup c;
  public ImageView c;
  public LinearLayout c;
  RelativeLayout.LayoutParams jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  protected RelativeLayout c;
  public TextView c;
  public QQProgressDialog c;
  private Runnable jdField_c_of_type_JavaLangRunnable;
  public String c;
  public boolean c;
  public int d;
  protected long d;
  public Dialog d;
  public View d;
  public ViewGroup d;
  public ImageView d;
  private LinearLayout jdField_d_of_type_AndroidWidgetLinearLayout;
  public RelativeLayout d;
  public TextView d;
  private Runnable jdField_d_of_type_JavaLangRunnable = new rlu(this);
  protected String d;
  public boolean d;
  public int e;
  long e;
  public Dialog e;
  public View e;
  public ImageView e;
  public TextView e;
  public String e;
  public boolean e;
  int f;
  public long f;
  public Dialog f;
  public View f;
  public ImageView f;
  public TextView f;
  public boolean f;
  public int g;
  long g;
  public View g;
  public ImageView g;
  public TextView g;
  public final boolean g;
  protected int h;
  private long h;
  public View h;
  public ImageView h;
  public TextView h;
  public boolean h;
  public int i;
  protected View i;
  protected ImageView i;
  public TextView i;
  public boolean i;
  public int j;
  public View j;
  protected ImageView j;
  private TextView j;
  public boolean j;
  protected int k;
  public View k;
  protected ImageView k;
  private TextView k;
  public boolean k;
  public View l;
  protected ImageView l;
  private TextView l;
  public boolean l;
  private int jdField_m_of_type_Int;
  public View m;
  public ImageView m;
  private TextView jdField_m_of_type_AndroidWidgetTextView;
  public boolean m;
  private int jdField_n_of_type_Int;
  public View n;
  private TextView jdField_n_of_type_AndroidWidgetTextView;
  public boolean n;
  private int jdField_o_of_type_Int = 1;
  private View jdField_o_of_type_AndroidViewView;
  private TextView jdField_o_of_type_AndroidWidgetTextView;
  public boolean o;
  private int jdField_p_of_type_Int;
  private View jdField_p_of_type_AndroidViewView;
  private TextView jdField_p_of_type_AndroidWidgetTextView;
  boolean jdField_p_of_type_Boolean = false;
  private int jdField_q_of_type_Int = 0;
  private View jdField_q_of_type_AndroidViewView;
  public volatile boolean q;
  private int jdField_r_of_type_Int = 1;
  private View jdField_r_of_type_AndroidViewView;
  public boolean r;
  private int jdField_s_of_type_Int;
  private View jdField_s_of_type_AndroidViewView;
  boolean jdField_s_of_type_Boolean = true;
  private int jdField_t_of_type_Int;
  boolean jdField_t_of_type_Boolean = false;
  private int u;
  public boolean u;
  private int v;
  protected boolean v;
  private int w;
  protected boolean w;
  private int x;
  protected boolean x;
  protected boolean y;
  private int z;
  
  static
  {
    jdField_l_of_type_Int = 30;
  }
  
  public BaseChatPie(QQAppInterface paramQQAppInterface, ViewGroup paramViewGroup, FragmentActivity paramFragmentActivity, Context paramContext)
  {
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_g_of_type_Boolean = true;
    this.jdField_h_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_Int = 300;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
    this.jdField_k_of_type_Boolean = true;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 131074;
    this.jdField_e_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_v_of_type_Int = 10;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_z_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_C_of_type_Boolean = true;
    this.jdField_B_of_type_Int = -1;
    this.jdField_C_of_type_Int = -1;
    this.jdField_D_of_type_Int = -1;
    this.jdField_H_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener = new ChatApolloViewListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState = new GoldMsgAioState();
    this.jdField_F_of_type_Int = 0;
    this.jdField_h_of_type_Long = -1L;
    this.jdField_b_of_type_JavaLangRunnable = new roo(this);
    this.jdField_j_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new rmo(this);
    this.jdField_g_of_type_Long = -1L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
    if (jdField_E_of_type_Int == 0) {
      jdField_E_of_type_Int = paramContext.getResources().getInteger(2131689485);
    }
  }
  
  private int a(List paramList, long paramLong)
  {
    int i1 = 0;
    while (i1 < paramList.size())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        if (((ChatMessage)paramList.get(i1)).shmsgseq != paramLong) {}
      }
      else {
        while (((ChatMessage)paramList.get(i1)).time == paramLong) {
          return i1;
        }
      }
      i1 += 1;
    }
    return -1;
  }
  
  private StickerBubbleTouchDelegate a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate == null)
    {
      StickerBubbleTouchDelegateCallbackForAIO localStickerBubbleTouchDelegateCallbackForAIO = new StickerBubbleTouchDelegateCallbackForAIO(this.jdField_a_of_type_AndroidContentContext, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate = new StickerBubbleTouchDelegate(localStickerBubbleTouchDelegateCallbackForAIO, paramView);
      localStickerBubbleTouchDelegateCallbackForAIO.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleStickerBubbleTouchDelegate;
  }
  
  private String a(String paramString)
  {
    return paramString;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString)
  {
    ThreadManager.post(new rmx(this, paramInt2, paramInt1, paramString), 2, null, false);
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
      if ((paramIntent.getIntExtra("uintype", -1) == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramIntent.getStringExtra("uin"), true).jdField_a_of_type_Boolean)) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131430256, 0).b(a());
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
        QLog.i("Q.aio.BaseChatPie", 1, "updateSession_forwardType, postDelayed!");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rph(this, paramBoolean, paramIntent, paramIntent), 500L);
      a(false, null, false);
      return;
      if ((i1 == 1001) || (i1 == -4)) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      }
    }
  }
  
  private void a(Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(new Bundle(paramBundle));
    a(localIntent, false);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Map)paramMessage.obj;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.get("chatMessage"));
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "pos is:" + i1);
    }
    if (i1 < 0) {}
    for (;;)
    {
      return;
      int i2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if ((i1 >= i2 - i3) && (i1 <= i4 - i5))
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1 - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition());
        if ((localObject != null) && ((localObject instanceof LinearLayout)))
        {
          paramMessage = (RichStatus.SigZanInfo)paramMessage.get("sigZanInfo");
          if ((AIOUtils.a((View)localObject) instanceof RichStatItemBuilder.Holder))
          {
            localObject = (RichStatItemBuilder.Holder)AIOUtils.a((View)localObject);
            if ((paramMessage.jdField_a_of_type_JavaLangString != null) && (paramMessage.jdField_a_of_type_JavaLangString.equals(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_JavaLangString)))
            {
              ((RichStatItemBuilder.Holder)localObject).jdField_e_of_type_Int = paramMessage.jdField_b_of_type_Int;
              ((RichStatItemBuilder.Holder)localObject).jdField_d_of_type_Int = paramMessage.jdField_c_of_type_Int;
              ((RichStatItemBuilder.Holder)localObject).a.jdField_b_of_type_JavaLangString = String.valueOf(paramMessage.jdField_b_of_type_Int);
              SignatureManager localSignatureManager = (SignatureManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(57);
              if (paramMessage.jdField_c_of_type_Int == 0) {}
              for (paramMessage = localSignatureManager.a(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int, 7, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F)); paramMessage != null; paramMessage = localSignatureManager.a(((RichStatItemBuilder.Holder)localObject).jdField_c_of_type_Int, 8, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 14.0F), DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 19.0F)))
              {
                ((RichStatItemBuilder.Holder)localObject).a.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramMessage;
                return;
              }
            }
          }
        }
      }
    }
  }
  
  private void a(Editable paramEditable)
  {
    if ((paramEditable != null) && (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView != null) && (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008))
    {
      String str = paramEditable.toString().toLowerCase();
      if (this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager.a(str)) {
        ThreadManager.post(new rpl(this, str, paramEditable), 5, null, true);
      }
      return;
    }
    QLog.e("Q.aio.BaseChatPie", 1, "emotionkeyword error");
  }
  
  private void a(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty());
      a(paramView).a(paramMotionEvent);
      this.af = true;
      return;
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().isEmpty()) || (this.af))
    {
      a(paramView).a(paramMotionEvent);
      this.af = false;
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008C70", "0X8008C70", ZhituManager.a(b()), 0, "", "", "", "");
    if (!ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText()))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "含有非常规字符，不支持转智图。", 0).a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 24)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "24个字符以内才支持转为智图。", 0).a();
      return;
    }
    if (!this.K)
    {
      bool = true;
      this.K = bool;
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837620);
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(this.K);
      if (!this.K) {
        break label399;
      }
      if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b();
      }
      if (SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label394;
      }
    }
    label394:
    for (boolean bool = true;; bool = false)
    {
      if (bool) {
        SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "zhitu", true);
      }
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, bool, this.jdField_a_of_type_MqqOsMqqHandler);
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText(), this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(), b(), false);
      return;
      bool = false;
      break;
    }
    label399:
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
  }
  
  private void a(FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    if ((localExtensionInfo == null) && (!paramFriendsManager.f())) {
      ThreadManager.getSubThreadHandler().post(new rlz(this, paramFriendsManager));
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
          QLog.d("Q.aio.BaseChatPie", 2, "saveC2CChatInputType | mExtensionInfo != null");
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
        QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeedForC2C extInfo.chatInputType = " + paramFriendsManager.chatInputType + " extInfo.showC2CPanel = " + paramFriendsManager.showC2CPanel);
      }
      if (paramFriendsManager.chatInputType == 2) {
        break label109;
      }
    }
    label109:
    while (paramFriendsManager.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeed | ExtensionInfo = null");
      return;
    }
    e(paramBoolean1, paramBoolean2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
    {
      paramInt1 = 1;
      if (paramInt2 != 8) {
        break label160;
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006189", "0X8006189", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report send ptt, send source = " + paramInt2 + ", sessionType = " + paramInt1 + ", seconds = " + paramInt3);
      }
      return;
      if (paramInt1 == 3000)
      {
        paramInt1 = 2;
        break;
      }
      if (paramInt1 == 1)
      {
        paramInt1 = 3;
        break;
      }
      paramInt1 = 4;
      break;
      label160:
      if ((paramInt2 == 1) || (paramInt2 == 2))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        if (paramInt2 == 1) {}
        for (int i1 = 1;; i1 = 2)
        {
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004600", "0X8004600", 0, 0, i1 + "", paramInt1 + "", paramInt3 + "", "");
          break;
        }
      }
      if (paramInt2 == 4) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8005C1E", "0X8005C1E", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      } else {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004601", "0X8004601", 0, 0, "", paramInt1 + "", paramInt3 + "", "");
      }
    }
  }
  
  private void a(AbsShareMsg paramAbsShareMsg, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog == null) {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = new ShareAioResultDialog(this.jdField_a_of_type_AndroidContentContext);
    }
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131430135);
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + paramString;
    }
    paramAbsShareMsg = new rmy(this, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(str1, paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.a(paramAbsShareMsg);
    this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.show();
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
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
  
  private void a(String paramString, ChatActivityFacade.SendMsgParams paramSendMsgParams, ArrayList paramArrayList)
  {
    Object localObject1;
    int i3;
    int i1;
    int i2;
    if (this.L)
    {
      localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
      Object localObject2 = ((FlashChatManager)localObject1).b();
      i3 = -1;
      if (localObject2 == null) {
        break label328;
      }
      localObject2 = ((String)localObject2).split(":");
      if ((localObject2.length != 2) || (android.text.TextUtils.isEmpty(localObject2[0])) || (!android.text.TextUtils.isDigitsOnly(localObject2[0]))) {
        break label328;
      }
      int i4 = Integer.parseInt(localObject2[0]);
      i1 = i3;
      i2 = i4;
      if (!android.text.TextUtils.isEmpty(localObject2[1]))
      {
        i1 = i3;
        i2 = i4;
        if (android.text.TextUtils.isDigitsOnly(localObject2[1]))
        {
          i1 = Integer.parseInt(localObject2[1]);
          i2 = i4;
        }
      }
    }
    for (;;)
    {
      if ((i2 == 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 20))
      {
        localObject1 = ((FlashChatManager)localObject1).a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        if (localObject1 != null)
        {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131362132, null);
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
          ChatActivityFacade.a((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime(), a(), (ArkFlashChatMessage)localObject1);
        }
      }
      else
      {
        while ((i2 == 1) && (i1 > 0) && (((HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(218)).a(this, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString(), i1))) {
          return;
        }
      }
      if (this.jdField_G_of_type_Boolean)
      {
        ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramArrayList, paramSendMsgParams);
        aP();
        return;
      }
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramArrayList, paramSendMsgParams);
      return;
      label328:
      i2 = 0;
      i1 = i3;
    }
  }
  
  private void a(String paramString, boolean paramBoolean, EmoticonMainPanel paramEmoticonMainPanel, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.post(new rrl(paramString, paramBoolean, paramEmoticonMainPanel, paramQQAppInterface, b()), 2, null, false);
  }
  
  private boolean a(FriendsManager paramFriendsManager)
  {
    ExtensionInfo localExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    ExtensionInfo localExtensionInfo1 = localExtensionInfo2;
    if (localExtensionInfo2 == null) {
      if (paramFriendsManager.f()) {}
    }
    label26:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType get ExtensionInfo = null");
      }
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      localExtensionInfo1.timestamp = System.currentTimeMillis();
      if (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {}
      for (localExtensionInfo1.chatInputType = 0;; localExtensionInfo1.chatInputType = 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = localExtensionInfo1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "doChooseC2CInputType extInfo.chatInputType = " + localExtensionInfo1.chatInputType);
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
          QLog.d("Q.aio.BaseChatPie", 2, "doChooseC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser");
          return false;
        }
      }
    } while ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.jdField_q_of_type_Int = 2;
    return false;
  }
  
  private boolean a(Object[] paramArrayOfObject, int paramInt)
  {
    List localList = MultiMsgManager.a().a();
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfObject != null) {
      paramArrayOfObject[0] = localList;
    }
    boolean bool2;
    if (localList.size() == 0)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433406, 0).b(a());
      bool2 = false;
      return bool2;
    }
    paramArrayOfObject = localList.iterator();
    boolean bool1;
    while (paramArrayOfObject.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramArrayOfObject.next();
      if ((localChatMessage instanceof MessageForTroopFile))
      {
        localArrayList.add(localChatMessage);
      }
      else if (!MultiMsgProxy.a(localChatMessage))
      {
        localArrayList.add(localChatMessage);
        if ((localChatMessage instanceof MessageForPtt)) {
          PttInfoCollector.a(8);
        }
      }
      else
      {
        if ((localChatMessage instanceof MessageForPic))
        {
          Object localObject = (MessageForPic)localChatMessage;
          bool2 = HotPicHelper.a(URLDrawableHelper.a(this.jdField_a_of_type_AndroidContentContext, (PicUiInterface)localObject, 65537), (MessageForPic)localObject);
          if (FlashPicHelper.a(localChatMessage)) {
            bool1 = false;
          }
          for (;;)
          {
            label191:
            if (!bool1)
            {
              localArrayList.add(localChatMessage);
              break;
              bool1 = bool2;
              if (((MessageForPic)localObject).isSendFromLocal())
              {
                bool1 = bool2;
                if (((MessageForPic)localObject).size <= 0L)
                {
                  localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject).frienduin, ((MessageForPic)localObject).uniseq);
                  bool1 = bool2;
                  if ((localObject instanceof BaseTransProcessor))
                  {
                    localObject = (BaseTransProcessor)localObject;
                    if ((((BaseTransProcessor)localObject).c() == 1003L) || (((BaseTransProcessor)localObject).d() == 1003L)) {
                      break label301;
                    }
                  }
                }
              }
            }
          }
          label301:
          for (bool1 = false;; bool1 = bool2)
          {
            break label191;
            break;
          }
        }
        if (((localChatMessage instanceof MessageForShortVideo)) && (!((MessageForShortVideo)localChatMessage).checkForward())) {
          localArrayList.add(localChatMessage);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      bool1 = true;
      localList.removeAll(localArrayList);
    }
    for (;;)
    {
      bool2 = bool1;
      if (localList.size() != 0) {
        break;
      }
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(paramInt)).setPositiveButton(17039370, new rnd(this)).setNegativeButton(17039360, new rnc(this)).show();
      return bool1;
      bool1 = false;
    }
  }
  
  private void aX()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController = new ChatPieApolloViewController();
    }
  }
  
  private void aY()
  {
    if (this.Z)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "do jumpToSpecifiedMsg");
      }
      long l1 = System.currentTimeMillis();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
      if (((List)localObject).size() > 0)
      {
        int i1 = a((List)localObject, this.jdField_d_of_type_Long);
        if (i1 >= 0) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new rnl(this, i1));
        }
      }
      else
      {
        StatisticCollector.a(BaseApplication.getContext()).a(null, "SearchToAIOLoadTime", true, System.currentTimeMillis() - l1, 0L, null, null);
        this.Z = false;
      }
    }
    else
    {
      return;
    }
    List localList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_d_of_type_Long);
    if (1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {}
    for (Object localObject = ChatActivityUtils.b(localList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);; localObject = ChatActivityUtils.a(localList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      a(localList, ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject));
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new rno(this));
      break;
    }
  }
  
  private void aZ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      if (!this.X)
      {
        if (!StringUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          M();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          }
          QLog.d("Q.aio.BaseChatPie", 1, "setReaded() call");
        }
        this.X = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0)
      {
        Object localObject = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1);
        if ((localObject != null) && (((ChatMessage)localObject).msgtype == -2039))
        {
          localObject = (MessageForApollo)localObject;
          if ((!((MessageForApollo)localObject).hasPlayed) && (((MessageForApollo)localObject).isSend())) {
            ApolloUtil.a((MessageForApollo)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          }
        }
      }
    }
  }
  
  public static void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (!AppSetting.jdField_b_of_type_Boolean)
    {
      if (!paramBoolean3) {
        break label37;
      }
      i1 = 2131433872;
    }
    for (;;)
    {
      QQToast.a(paramContext, i1, 0).b(paramContext.getResources().getDimensionPixelSize(2131558448));
      return;
      label37:
      if (paramBoolean2) {
        i1 = 2131433873;
      } else if (paramBoolean1) {
        i1 = 2131433871;
      } else {
        i1 = 2131433870;
      }
    }
  }
  
  private void b(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  private void b(FriendsManager paramFriendsManager)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    if ((localNoC2CExtensionInfo == null) && (!paramFriendsManager.f())) {
      ThreadManager.getSubThreadHandler().post(new rma(this, paramFriendsManager));
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
          QLog.d("Q.aio.BaseChatPie", 2, "saveNoC2CChatInputType | mNoC2CExtensionInfo != null");
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
        QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeedForNoC2C noC2CExtInfo.chatInputType = " + paramFriendsManager.chatInputType + " noC2CExtInfo.showC2CPanel = " + paramFriendsManager.showC2CPanel);
      }
      if (paramFriendsManager.chatInputType == 2) {
        break label116;
      }
    }
    label116:
    while (paramFriendsManager.showC2CPanel != 1)
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeed | NoC2CExtensionInfo = null");
      return;
    }
    e(paramBoolean1, paramBoolean2);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i1 = 8;
    if (paramInt == 8) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004603", "0X8004603", 0, 0, i1 + "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "report cancle send ptt, cancel source = " + paramInt);
      }
      return;
      if (paramInt == 1) {
        i1 = 1;
      } else if (paramInt == 2) {
        i1 = 2;
      } else {
        i1 = 3;
      }
    }
  }
  
  private void b(List paramList)
  {
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, null);
    localActionSheet.c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433745));
    localActionSheet.c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getString(2131433746));
    localActionSheet.c(2131432998);
    localActionSheet.a(new rne(this, paramList, localActionSheet));
    localActionSheet.show();
  }
  
  private boolean b(FriendsManager paramFriendsManager)
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo2 = paramFriendsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
    NoC2CExtensionInfo localNoC2CExtensionInfo1 = localNoC2CExtensionInfo2;
    if (localNoC2CExtensionInfo2 == null) {
      if (paramFriendsManager.f()) {}
    }
    label36:
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType get NoC2CExtensionInfo = null");
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
          QLog.d("Q.aio.BaseChatPie", 2, "doChooseNoC2CInputType noC2CExtInfo.chatInputType = " + localNoC2CExtensionInfo1.chatInputType + " noC2CType = " + i1);
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
          QLog.d("Q.aio.BaseChatPie", 2, "doChooseNoC2CInputType AIOInputTypeHelper.isInputTypeChangedByUser ");
          return false;
        }
      }
    } while ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("enter_ext_panel", 0) != 0));
    this.jdField_q_of_type_Int = 2;
    return false;
  }
  
  private void ba()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMusicItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  private void bb()
  {
    if ((!q()) || (this.jdField_d_of_type_AndroidWidgetLinearLayout == null)) {}
    try
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout = ((LinearLayout)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968634, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView = ((EmotionKeywordHorizonListView)this.jdField_d_of_type_AndroidWidgetLinearLayout.findViewById(2131362964));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(2, 2131363476);
      localLayoutParams.addRule(11);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_d_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter = new EmotionKeywordAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordHorizonListView.setTouchListener(new rpa(this));
      this.jdField_a_of_type_ComTencentMobileqqModelEmoticonManager = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.aio.BaseChatPie", 2, "EmotionPreviewLayout InflateException = " + localException);
      }
    }
  }
  
  private void bc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onShow_videoStatus: mEnterExtPanel = " + this.jdField_q_of_type_Int + ", mExtPanelOnResumeTimes = " + this.jdField_r_of_type_Int);
    }
    if (this.jdField_q_of_type_Int != 0)
    {
      int i1 = this.jdField_r_of_type_Int - 1;
      this.jdField_r_of_type_Int = i1;
      if (i1 == 0)
      {
        if (this.jdField_q_of_type_Int != 1) {
          break label102;
        }
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new rpb(this));
      }
    }
    for (;;)
    {
      this.jdField_q_of_type_Int = 0;
      return;
      label102:
      if (this.jdField_q_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.post(new rpc(this));
      }
    }
  }
  
  private void bd()
  {
    NativeVideoImage.resumeAll();
    com.tencent.image.AbstractGifImage.DoAccumulativeRunnable.DELAY = PicItemBuilder.jdField_b_of_type_Int;
    AbstractGifImage.resumeAll();
    com.etrump.mixlayout.ETTextView.jdField_i_of_type_Boolean = true;
    ApngImage.playByTag(0);
    AbstractVideoImage.resumeAll();
    QQLiveImage.resumeAll();
    NowVideoController.a().a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).b();
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onShow_updateUI: listView.setVisibility(View.VISIBLE)");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1000, new Object[0]);
    bk();
    bj();
    if ((this.ad) && (!this.jdField_r_of_type_Boolean))
    {
      if (this.O) {
        break label442;
      }
      e(true, false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
      this.O = true;
    }
    for (;;)
    {
      this.ad = false;
      this.jdField_l_of_type_Boolean = SettingCloneUtil.readValue(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131433609), "qqsetting_enter_sendmsg_key", false);
      if (this.jdField_l_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setImeOptions(4);
        if (this.jdField_a_of_type_Rrf == null) {
          this.jdField_a_of_type_Rrf = new rrf(this, null);
        }
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(this.jdField_a_of_type_Rrf);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener(this.jdField_a_of_type_Rrf);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(this);
      }
      try
      {
        bool = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().getBoolean("refuse_show_share_result_dialog", false);
        Object localObject1;
        if ((this.jdField_m_of_type_Boolean) && (!bool) && (this.jdField_s_of_type_Boolean))
        {
          localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
          String str = ((Bundle)localObject1).getString("app_name");
          localObject1 = StructMsgFactory.a((Bundle)localObject1);
          if ((localObject1 != null) && ((localObject1 instanceof AbsShareMsg)))
          {
            localObject1 = (AbsShareMsg)localObject1;
            a((AbsShareMsg)localObject1, str);
            this.jdField_s_of_type_Boolean = false;
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
          if (((SharedPreferences)localObject1).getBoolean("sdcard_related_download_failed", false))
          {
            if (!Environment.getExternalStorageState().equals("mounted"))
            {
              QQToast.a(BaseApplication.getContext(), 2131433422, 0).b(a());
              localObject1 = ((SharedPreferences)localObject1).edit();
              ((SharedPreferences.Editor)localObject1).putBoolean("sdcard_related_download_failed", false);
              ((SharedPreferences.Editor)localObject1).commit();
            }
          }
          else
          {
            if (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(64))
            {
              int i1 = HotReactiveHelper.a();
              this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(64, i1 * 1000);
            }
            EmojiStickerManager.a().a(this);
            return;
            label442:
            c(true, false);
            continue;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setImeOptions(0);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
          continue;
          if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1)
          {
            QQToast.a(BaseApplication.getContext(), 2131433423, 0).b(a());
            continue;
            Object localObject2 = null;
          }
        }
      }
    }
  }
  
  private void be()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b() == 1) {}
    for (;;)
    {
      this.T = bool;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "mIsMsgSignalOpen: " + this.T);
      }
      return;
      bool = false;
    }
  }
  
  private void bf()
  {
    Bundle localBundle = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras();
    if ((localBundle != null) && (localBundle.getBoolean("key_notification_click_action", false))) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80046A7", "0X80046A7", 0, 0, "", "", "", "");
    }
  }
  
  private void bg()
  {
    if ((QQLSRecentManager.jdField_e_of_type_Boolean) && (QQUtils.a(BaseApplication.getContext())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "setReaded return : QQLSActivity is alive");
      }
      return;
    }
    ThreadManager.post(new rrm(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), 8, null, false);
  }
  
  private void bh()
  {
    this.jdField_c_of_type_JavaLangRunnable = new rpn(this);
  }
  
  private void bi()
  {
    int i2 = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "cancelMultiDelAnim() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(17);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(52);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.clearDelAnim();
    }
    int i1;
    if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout != null)
    {
      i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1] != null) {
          this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1].setVisibility(8);
        }
        i1 += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
    {
      i1 = 0;
      while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
      {
        if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] != null) {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
        }
        i1 += 1;
      }
    }
    if (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup != null)
    {
      i1 = i2;
      while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewViewGroup.length)
      {
        if ((this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent() != null)) {
          ((ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent()).removeView(this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1]);
        }
        i1 += 1;
      }
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView = null;
    this.jdField_a_of_type_ArrayOfAndroidViewViewGroup = null;
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = null;
    this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet = null;
    this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout = null;
  }
  
  private void bj()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID")))
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("mobileQQ", 4);
      if (localSharedPreferences.getBoolean("FORWARD_EMOPGK_ID", false))
      {
        String str = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().getInt("FORWARD_EMOPGK_ID") + "";
        localSharedPreferences.edit().remove("FORWARD_EMOPGK_ID").commit();
        this.jdField_q_of_type_Int = 3;
        c(str);
      }
    }
  }
  
  private void bk()
  {
    Intent localIntent;
    int i1;
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("apollo_forward_key")))
    {
      this.jdField_q_of_type_Int = 21;
      localIntent = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      if (!localIntent.hasExtra("apollo_actionid_key")) {
        break label211;
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
          QLog.d("Q.aio.BaseChatPie", 2, new Object[] { "showQuickApolloSendPanel, pkgId=", Integer.valueOf(i2), ", actionId=", Integer.valueOf(i1) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b(i2, i1);
        }
        for (;;)
        {
          as();
          this.jdField_B_of_type_Int = -1;
          this.jdField_C_of_type_Int = -1;
          return;
          this.jdField_B_of_type_Int = i1;
          this.jdField_C_of_type_Int = i2;
        }
        i2 = -1;
      }
      label211:
      i1 = -1;
    }
  }
  
  private void bl()
  {
    long l1 = System.currentTimeMillis();
    FriendsManager localFriendsManager;
    int i1;
    int i2;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_e_of_type_Boolean))
    {
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) {
        break label151;
      }
      i1 = 2;
      if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == null) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)) {
        break label156;
      }
      i2 = 1;
      label81:
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break label161;
      }
      b(localFriendsManager, i1, i2);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("save_inptut", 2, "saveChatInputType cost :" + (System.currentTimeMillis() - l1));
      }
      return;
      label151:
      i1 = 1;
      break;
      label156:
      i2 = 0;
      break label81;
      label161:
      if (x()) {
        a(localFriendsManager, i1, i2);
      }
    }
  }
  
  private void bm()
  {
    ThreadManager.post(new rme(this), 8, null, true);
  }
  
  private void bn()
  {
    boolean bool2 = true;
    int i1 = 120;
    int i2 = VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    QQRecorder.RecorderParam localRecorderParam;
    Object localObject;
    if ((i2 & 0x4) != 0)
    {
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SVIP_MaxPtt");
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).getInt("Channels") != 1)
      {
        localRecorderParam = a();
        localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true);
        if (this.jdField_e_of_type_Boolean) {
          break label234;
        }
        bool1 = true;
        label75:
        ((Bundle)localObject).putBoolean("DoesSupportDirectlyAudio", bool1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("Channels", 1);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("SampleRate", localRecorderParam.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("TimeLength", i1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("sougouptt params : support = ");
          if (this.jdField_e_of_type_Boolean) {
            break label239;
          }
        }
      }
    }
    label234:
    label239:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QLog.d("Q.aio.BaseChatPie", 2, bool1 + "sample = " + localRecorderParam.jdField_a_of_type_Int + " max = " + i1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.jdField_a_of_type_JavaLangObject = localRecorderParam;
      return;
      if ((i2 & 0x2) == 0) {
        break;
      }
      i1 = PttItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "VIP_MaxPtt");
      break;
      bool1 = false;
      break label75;
    }
  }
  
  private void bo()
  {
    List localList = SystemAndEmojiEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((localList != null) && (localList.size() > 0))
    {
      int i1 = 0;
      while ((i1 < 84) && (i1 < localList.size()))
      {
        Object localObject = (EmotionPanelData)localList.get(i1);
        if ((localObject instanceof SystemAndEmojiEmoticonInfo))
        {
          localObject = (SystemAndEmojiEmoticonInfo)localObject;
          if ((localObject != null) && (((SystemAndEmojiEmoticonInfo)localObject).jdField_c_of_type_Int != 3) && (((SystemAndEmojiEmoticonInfo)localObject).jdField_b_of_type_Int != -1))
          {
            localObject = (URLDrawable)((SystemAndEmojiEmoticonInfo)localObject).a(false);
            if ((localObject != null) && (((URLDrawable)localObject).getStatus() != 1)) {
              ((URLDrawable)localObject).startDownload();
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void bp()
  {
    if (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock == null) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = ((PowerManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("power")).newWakeLock(536870918, "Q.aio.BaseChatPie");
    }
    if (!this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()) {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.acquire();
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "remainScreenOn");
    }
  }
  
  private void bq()
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
  
  private void c(List paramList)
  {
    MultiMsgManager.a().b(paramList);
    if (QLog.isDevelopLevel()) {
      QLog.d("MultiMsg", 4, "multiForwardSperate|checklist.size = " + paramList.size());
    }
    if (paramList.size() == 0) {
      return;
    }
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    MultiMsgManager.a().b.clear();
    MultiMsgManager.a().b.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    a(MultiMsgManager.a().b, MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList, 1);
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      paramList = "0X80078B8";
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      paramList = "0X80078B8";
      continue;
      paramList = "0X80078B9";
      continue;
      paramList = "0X80078BA";
    }
  }
  
  private void d(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, "");
  }
  
  private void d(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!AIOUtils.b())) {
      if (this.jdField_g_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130968660, this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        this.jdField_g_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363035);
        this.jdField_n_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363037));
        this.jdField_g_of_type_AndroidViewView.setOnClickListener(this);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
          break label150;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c())) {
          ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131363476);
        }
      }
    }
    label149:
    label150:
    while (this.jdField_g_of_type_AndroidViewView == null)
    {
      break label149;
      this.jdField_g_of_type_AndroidViewView.setVisibility(0);
      if (paramBoolean2) {
        this.jdField_n_of_type_AndroidWidgetTextView.setText(2131433359);
      }
      for (;;)
      {
        this.jdField_g_of_type_AndroidViewView.setSelected(paramBoolean2);
        return;
        if (this.jdField_o_of_type_AndroidWidgetTextView != null) {
          break;
        }
        ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131363476);
        break;
        this.jdField_n_of_type_AndroidWidgetTextView.setText(2131433360);
      }
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void e(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      if ((paramBoolean2) && (y()))
      {
        q(false);
        this.ad = false;
      }
      if (DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_input.name())) {
        if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) || (this.ad)) && (y()))
        {
          q(false);
          this.ad = false;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "initAudioPanelFlag needShowAudioWhenResume  = " + this.ad);
      }
      return;
      this.ad = true;
      continue;
      if ((this.ad) && (y()))
      {
        q(true);
        this.ad = false;
      }
    }
  }
  
  private void k(Intent paramIntent)
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
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = new QQMessageFacade.RefreshMessageContext();
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject = new ChatContext(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString = paramIntent.getStringExtra("troop_uin");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Int = paramIntent.getIntExtra("add_friend_source_id", 3999);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int = paramIntent.getIntExtra("key_confess_topicid", 0);
    this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int;
    this.jdField_q_of_type_Int = paramIntent.getIntExtra("enter_ext_panel", 0);
    this.jdField_r_of_type_Int = paramIntent.getIntExtra("ext_panel_onresume", 1);
    this.jdField_i_of_type_Boolean = paramIntent.getBooleanExtra("isBack2Root", false);
    this.jdField_d_of_type_Boolean = paramIntent.getBooleanExtra("open_chat_from_voice_changer_guide", false);
    if (!this.jdField_d_of_type_Boolean)
    {
      bool1 = true;
      this.O = bool1;
      if (paramIntent.getLongExtra("res_share_id", -1L) != -1L) {
        this.jdField_m_of_type_Boolean = paramIntent.getExtras().containsKey("res_share_id");
      }
      if (!this.jdField_m_of_type_Boolean) {
        this.jdField_m_of_type_Boolean = paramIntent.getBooleanExtra("is_share_flag", false);
      }
      if ("qzoneShareTopic".equals(paramIntent.getStringExtra("share_qq_ext_str"))) {
        this.jdField_m_of_type_Boolean = false;
      }
      this.jdField_n_of_type_Boolean = paramIntent.getBooleanExtra("is_from_manage_stranger", false);
      boolean bool3 = paramIntent.getBooleanExtra("need_jump_to_msg", false);
      if (paramIntent.getIntExtra("aio_msg_source", 999) != 1) {
        break label494;
      }
      bool1 = true;
      label430:
      this.jdField_w_of_type_Boolean = bool1;
      if ((this.jdField_w_of_type_Boolean) || (bool3))
      {
        this.jdField_d_of_type_Long = paramIntent.getLongExtra("searched_timeorseq", -1L);
        if (this.jdField_d_of_type_Long <= -1L) {
          break label499;
        }
      }
    }
    label494:
    label499:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.jdField_x_of_type_Boolean = bool1;
      AIOUtils.jdField_m_of_type_Boolean = false;
      this.jdField_y_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label430;
    }
  }
  
  private void l(Intent paramIntent)
  {
    k(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMaxLines(6);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
    String str = paramIntent.getStringExtra("input_text");
    paramIntent.removeExtra("input_text");
    if (str != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(str);
    }
    for (;;)
    {
      ag();
      return;
      r();
    }
  }
  
  private void m(Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(null);
    }
    long l1 = paramIntent.getLongExtra("res_share_id", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "updateSession_otherThings appShareId=" + l1);
    }
    if (l1 > 0L) {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rpt(this, paramIntent), 20L);
    }
  }
  
  private void n(Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(4);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "doOnNewIntent_updateUI: listView.setVisibility(View.INVISIBLE)");
    }
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {
      a(false, null, false);
    }
    Bundle localBundle = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433280);
      aJ();
      this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
    }
    for (;;)
    {
      this.jdField_q_of_type_Int = paramIntent.getIntExtra("enter_ext_panel", 0);
      this.jdField_r_of_type_Int = paramIntent.getIntExtra("ext_panel_onresume", 1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "mEnterExtPanel = " + this.jdField_q_of_type_Int + ", mExtPanelOnResumeTimes = " + this.jdField_r_of_type_Int);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
      }
      AioAnimationDetector.a().a();
      aU();
      return;
      if (localBundle != null)
      {
        this.jdField_i_of_type_Boolean = localBundle.getBoolean("isBack2Root");
        if (this.jdField_i_of_type_Boolean)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433280);
          aJ();
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回消息界面");
        }
      }
    }
  }
  
  private void o(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if ((paramIntent != null) && (this.jdField_p_of_type_Boolean))
    {
      int i1 = paramIntent.getInt("aio_msg_source", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " AIO_MSG_SOURCE : " + i1);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "AIO", "AIO_appear", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), String.valueOf(i1), "", "");
    }
  }
  
  @TargetApi(9)
  private void o(boolean paramBoolean)
  {
    Object localObject;
    int i1;
    if ((this.jdField_m_of_type_AndroidWidgetTextView != null) && (this.jdField_m_of_type_AndroidWidgetTextView.getVisibility() == 0))
    {
      if (paramBoolean) {
        this.jdField_m_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      i1 = ((SharedPreferences)localObject).getInt("short_video_more_filter_tip", 3);
      if (i1 > 0)
      {
        if (!paramBoolean) {
          break label118;
        }
        i1 = 0;
      }
    }
    for (;;)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("short_video_more_filter_tip", i1);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.BaseChatPie", 4, "dismissShortVideoMergeTips " + i1);
      }
      return;
      label118:
      i1 -= 1;
    }
  }
  
  private void p(Intent paramIntent)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("apollo_forward_key"))) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_r_of_type_Boolean) || ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getExtras().containsKey("FORWARD_EMOPGK_ID"))));
      if (!this.jdField_d_of_type_Boolean) {
        break;
      }
      e(false, false);
    } while (this.ad);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(0, true);
    this.O = true;
    return;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)))
    {
      paramIntent = paramIntent.getStringExtra("input_text_redpacket");
      if (!android.text.TextUtils.isEmpty(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "chooseChatInputType redPacketExtra");
        }
        k(0);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramIntent);
        return;
      }
    }
    boolean bool2;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (!this.jdField_e_of_type_Boolean))
    {
      paramIntent = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        bool2 = b(paramIntent);
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.aio.BaseChatPie", 2, "chooseChatInputType doChooseNoC2CInputType needGuide = " + bool2);
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      c(false, bool1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType cost :" + (System.currentTimeMillis() - l1));
      return;
      if (x())
      {
        bool2 = a(paramIntent);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.aio.BaseChatPie", 2, "chooseChatInputType doChooseC2CInputType needGuide = " + bool2);
        bool1 = bool2;
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_e_of_type_Boolean) && (QLog.isColorLevel())) {
          QLog.d("Q.aio.BaseChatPie", 2, "chooseC2CChatInputType isSimpleBar = " + this.jdField_e_of_type_Boolean);
        }
      }
      bool1 = false;
    }
  }
  
  private void p(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "mActivity == null");
      }
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      b(1);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
  }
  
  private void q(Intent paramIntent)
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.PreUploadVideoConfig.name(), "0|0|1.0|5|480000|0");
    LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig of PreUploadVideoConfig :" + (String)localObject);
    float f1 = 0.0F;
    float f3 = 0.0F;
    float f2 = 0.0F;
    long l2 = 0L;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject == null) || (localObject.length < 5)) {}
    }
    for (;;)
    {
      int i1;
      long l1;
      int i6;
      try
      {
        i3 = Integer.valueOf(localObject[0]).intValue();
        boolean bool3;
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        try
        {
          i2 = Integer.valueOf(localObject[1]).intValue();
          f2 = f3;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          for (;;)
          {
            boolean bool1;
            boolean bool2;
            int i2 = 0;
            i1 = 0;
            i6 = i3;
          }
        }
        try
        {
          f1 = Float.valueOf(localObject[2]).floatValue();
          f2 = f1;
          i1 = Integer.valueOf(localObject[3]).intValue();
        }
        catch (NumberFormatException localNumberFormatException3)
        {
          i1 = 0;
          f1 = f2;
          i6 = i3;
          break label613;
        }
        try
        {
          l1 = Long.valueOf(localObject[4]).longValue();
          i5 = i3;
          i4 = i2;
          i3 = i1;
          f2 = f1;
          LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> DPCConfig PreUpEnable:" + i5 + " HardEncodeEnable:" + i4 + " Limits:" + i3 + " dpcDuration:" + f2 + " dpcTimeout:" + l1);
          bool3 = VideoUpConfigInfo.isPreUpload();
          bool1 = VideoUpConfigInfo.sIsHardCodeEnable;
          if ((i4 != 1) || (!bool1)) {
            break label670;
          }
          bool2 = true;
          LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> HardCodeEnable: " + bool2 + " DPC:" + i4 + " BDH:" + bool1);
          if (!VideoUpConfigInfo.getIsUpdated())
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "<BDH_LOG>VideoUpConfigInfo is not updated");
            }
            HwServlet.getConfig(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            VideoUpConfigInfo.setIsUpdated();
          }
          if (!NetworkUtil.h(BaseApplication.getContext())) {
            break label682;
          }
          if ((i5 != 1) || (!bool3)) {
            break label676;
          }
          bool1 = true;
          LogTag.a(String.valueOf(0), "checking", "<BDH_LOG> Enable: " + bool1 + " DPC:" + i5 + " BDH:" + bool3 + " isWifi");
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)) {
            bool1 = false;
          }
          bool3 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0)
          {
            bool3 = bool1;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)
            {
              bool3 = bool1;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)
              {
                bool3 = bool1;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) {
                  bool3 = false;
                }
              }
            }
          }
          if ((!bool3) || (!ShortVideoUploadABTest.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label688;
          }
          paramIntent.putExtra("key_video_presend_enable", true);
          paramIntent.putExtra("key_video_hard_encode_enable", bool2);
          paramIntent.putExtra("key_video_presend_slice_duration", f2);
          com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_a_of_type_Boolean = bool2;
          com.tencent.mobileqq.shortvideo.hwcodec.HwEnvData.jdField_b_of_type_Boolean = bool3;
          return;
        }
        catch (NumberFormatException localNumberFormatException4)
        {
          i6 = i3;
          break label613;
        }
        localNumberFormatException1 = localNumberFormatException1;
        i2 = 0;
        i6 = 0;
        i1 = 0;
      }
      label613:
      f2 = f1;
      int i3 = i1;
      int i4 = i2;
      int i5 = i6;
      if (QLog.isColorLevel())
      {
        QLog.e("Q.aio.BaseChatPie", 2, "<BDH_LOG>get DpcConfig Erro", localNumberFormatException1);
        l1 = l2;
        f2 = f1;
        i3 = i1;
        i4 = i2;
        i5 = i6;
        continue;
        label670:
        bool2 = false;
        continue;
        label676:
        bool1 = false;
        continue;
        label682:
        bool1 = false;
        continue;
        label688:
        paramIntent.putExtra("key_video_presend_enable", false);
        continue;
        i3 = 0;
        i4 = 0;
        i5 = 0;
        l1 = l2;
      }
    }
  }
  
  private void q(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2, paramBoolean);
  }
  
  private void r(boolean paramBoolean)
  {
    this.Y = paramBoolean;
  }
  
  private void s(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setReceiptMode(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(new rmr(this));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setSelectLimitListener(null);
  }
  
  private void v(int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_o_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_o_of_type_AndroidWidgetTextView.setText(Integer.toString(paramInt));
      this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
      }
    }
    while (paramInt <= 0)
    {
      if ((this.jdField_o_of_type_AndroidWidgetTextView != null) && (BaseChatItemLayout.jdField_a_of_type_Boolean)) {
        this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
    }
    if (this.jdField_o_of_type_AndroidWidgetTextView == null)
    {
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject1).setId(2131361891);
      ((TextView)localObject1).setBackgroundResource(2130837953);
      ((TextView)localObject1).setGravity(1);
      ((TextView)localObject1).setPadding(0, (int)(2.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      ((TextView)localObject1).setSingleLine();
      ((TextView)localObject1).setTextColor(-1);
      ((TextView)localObject1).setTextSize(2, 16.0F);
      ((TextView)localObject1).setOnClickListener(this);
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131363476);
      ((RelativeLayout.LayoutParams)localObject2).addRule(11);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.jdField_a_of_type_Float * 10.0F + 0.5F));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      this.jdField_o_of_type_AndroidWidgetTextView = ((TextView)localObject1);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.bringChildToFront(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_g_of_type_AndroidViewView != null) {
        ((RelativeLayout.LayoutParams)this.jdField_g_of_type_AndroidViewView.getLayoutParams()).addRule(2, 2131361891);
      }
    }
    Object localObject2 = this.jdField_o_of_type_AndroidWidgetTextView;
    if (paramInt > 99) {}
    for (Object localObject1 = "99";; localObject1 = Integer.toString(paramInt))
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
      break;
    }
  }
  
  private void w(int paramInt)
  {
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
  }
  
  private void x(int paramInt)
  {
    if (this.jdField_s_of_type_AndroidViewView == null)
    {
      this.jdField_r_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      localObject = new RelativeLayout.LayoutParams(-1, -1);
      int i1 = Color.parseColor("#7f000000");
      this.jdField_r_of_type_AndroidViewView.setBackgroundColor(i1);
      this.jdField_r_of_type_AndroidViewView.setId(2131362015);
      this.jdField_r_of_type_AndroidViewView.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131362014);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_r_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
      this.jdField_p_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject = new RelativeLayout.LayoutParams(-1, AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources()));
      this.jdField_p_of_type_AndroidWidgetTextView.setGravity(17);
      this.jdField_p_of_type_AndroidWidgetTextView.setTextSize(14.0F);
      this.jdField_p_of_type_AndroidWidgetTextView.setId(2131362014);
      ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131363476);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_p_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_s_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      localObject = new RelativeLayout.LayoutParams(-1, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
      this.jdField_s_of_type_AndroidViewView.setBackgroundColor(i1);
      this.jdField_s_of_type_AndroidViewView.setId(2131362013);
      this.jdField_s_of_type_AndroidViewView.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)localObject).addRule(6, 2131363226);
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_s_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    }
    ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(2, 2131362014);
    this.jdField_r_of_type_AndroidViewView.setVisibility(paramInt);
    this.jdField_p_of_type_AndroidWidgetTextView.setVisibility(paramInt);
    this.jdField_s_of_type_AndroidViewView.setVisibility(paramInt);
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
  
  private boolean x()
  {
    boolean bool = false;
    int i1 = 0;
    for (;;)
    {
      if ((i1 >= MsgProxyUtils.q.length) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == MsgProxyUtils.q[i1]))
      {
        if (i1 < MsgProxyUtils.q.length) {
          bool = true;
        }
        return bool;
      }
      i1 += 1;
    }
  }
  
  private boolean y()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008) && (!this.jdField_w_of_type_Boolean);
  }
  
  @Deprecated
  public void A()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 10))
    {
      rng localrng = new rng(this);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131439042), this.jdField_a_of_type_AndroidContentContext.getString(2131439043), this.jdField_a_of_type_AndroidContentContext.getString(2131439044), localrng, localrng).show();
      return;
    }
    PokeItemHelper.a();
    PokeItemHelper.b();
    b(1);
  }
  
  public void B()
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
  
  public void C()
  {
    this.jdField_h_of_type_Int = 3;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnStart", hashCode(), this.jdField_h_of_type_Int);
  }
  
  public void D()
  {
    this.jdField_h_of_type_Int = 6;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnStop", hashCode(), this.jdField_h_of_type_Int);
    this.jdField_p_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)) {
      ac();
    }
    av();
    Editable localEditable2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
    Editable localEditable1 = localEditable2;
    if (localEditable2 != null)
    {
      localEditable1 = localEditable2;
      if (!ArkAiAppCenter.jdField_f_of_type_Boolean)
      {
        localEditable1 = localEditable2;
        if (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
        {
          String str = localEditable2.toString();
          if (!"@babyQ".equals(str))
          {
            localEditable1 = localEditable2;
            if (!("@babyQ" + ArkRecommendController.jdField_b_of_type_JavaLangString).equals(str)) {}
          }
          else
          {
            localEditable1 = null;
          }
        }
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager, localEditable1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow() != null)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().setSoftInputMode(32);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.c();
    }
  }
  
  public void E()
  {
    this.jdField_h_of_type_Int = 5;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnPause", hashCode(), this.jdField_h_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    ArkAioContainerWrapper.a(0);
    ArkFlashChatContainerWrapper.a(0);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.d();
    }
    NativeVideoImage.pauseAll();
    AbstractGifImage.pauseAll();
    ApngImage.pauseByTag(0);
    if (!q()) {
      AbstractVideoImage.pauseAll();
    }
    ShortVideoPTVItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    QQLiveImage.pauseAll();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      a(true);
    }
    ThreadManager.post(new rnh(this), 5, null, false);
    if (this.Q) {
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.a();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a(0);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.h();
    }
    this.jdField_p_of_type_Boolean = false;
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).c();
    if (this.S)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.S = false;
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
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.d(this);
    }
    StickerBubbleAnimationHelper.a(this.jdField_d_of_type_AndroidViewViewGroup);
  }
  
  public void F()
  {
    boolean bool = true;
    StartupTracker.a(null, "AIO_doOnResume_updateUI");
    ArkAioContainerWrapper.a(1);
    ArkFlashChatContainerWrapper.a(1);
    ThreadManager.postImmediately(new rni(this), null, true);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.c();
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.postDelayed(new rnk(this), 2000L);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.getVisibility() == 0)) {
      this.jdField_i_of_type_Int = 0;
    }
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentWidgetPatchedButton != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null))
    {
      localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() <= 0) {
        break label290;
      }
    }
    for (;;)
    {
      ((PatchedButton)localObject).setEnabled(bool);
      StartupTracker.a("AIO_doOnResume_updateUI", null);
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
      }
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      int i2 = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131558448);
      int i1 = i2;
      if (this.jdField_E_of_type_Boolean) {
        i1 = i2 - AIOUtils.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
      }
      ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      aK();
      if (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
        a(-5693, false);
      }
      return;
      label290:
      bool = false;
    }
  }
  
  public void G()
  {
    this.jdField_h_of_type_Int = 4;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnResume", hashCode(), this.jdField_h_of_type_Int);
    F();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (this.jdField_u_of_type_Boolean)
    {
      AIOUtils.a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        PAStartupTracker.a(null, "pubAcc_structMsg_display", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      synchronized (QQMessageFacade.jdField_a_of_type_JavaLangObject)
      {
        N();
        r(true);
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_d_of_type_JavaLangRunnable, 800L);
        this.jdField_u_of_type_Boolean = false;
        if (DeviceProfileManager.jdField_b_of_type_Boolean) {
          be();
        }
        this.S = false;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, this);
        NowVideoController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
        QQLSRecentManager.jdField_f_of_type_Boolean = true;
        ThreadRegulator.a().a(1, 1500L);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
        {
          boolean bool = GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a(this, bool, true, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        return;
      }
      b(131072);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onShow right now");
      }
      X();
    }
  }
  
  public void H()
  {
    PerformanceReportUtils.a();
    AIOUtils.a(false);
    this.Y = false;
    this.X = false;
    this.jdField_i_of_type_Boolean = false;
    this.jdField_k_of_type_Boolean = true;
    this.jdField_l_of_type_Boolean = false;
    this.P = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_m_of_type_Boolean = false;
    this.Q = false;
    this.R = false;
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_s_of_type_Boolean = true;
    this.jdField_t_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    this.jdField_D_of_type_Boolean = false;
    this.jdField_H_of_type_Boolean = true;
    this.ad = false;
    this.ae = true;
    this.W = true;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_g_of_type_AndroidWidgetTextView = null;
      this.jdField_p_of_type_AndroidViewView = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    if ((this.jdField_c_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidWidgetLinearLayout);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = null;
      this.jdField_h_of_type_AndroidWidgetTextView = null;
      this.jdField_i_of_type_AndroidWidgetTextView = null;
    }
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(4);
      this.jdField_g_of_type_AndroidViewView = null;
    }
    if ((this.jdField_d_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_d_of_type_AndroidWidgetLinearLayout);
      this.jdField_d_of_type_AndroidWidgetLinearLayout = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    this.jdField_d_of_type_Long = 0L;
    this.jdField_x_of_type_Boolean = false;
    this.Z = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) && (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b();
    }
    LightReplyMenuManager localLightReplyMenuManager = LightReplyMenuManager.a();
    if ((localLightReplyMenuManager != null) && (localLightReplyMenuManager.b())) {
      localLightReplyMenuManager.a();
    }
    aH();
  }
  
  public void I()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "return MainFragment");
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager();
      localFragmentTransaction = ((FragmentManager)localObject).beginTransaction();
      localFragment = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
      localObject = ((FragmentManager)localObject).findFragmentByTag(ChatFragment.class.getName());
      localFragmentTransaction.setCustomAnimations(2131034177, 2131034174);
      SplashActivity.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().putExtra("isFromAioFragment", true);
      if (localFragment != null)
      {
        localFragmentTransaction.show(localFragment);
        localFragmentTransaction.hide((Fragment)localObject);
        if ((localObject != null) && (((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null))
        {
          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
            break label189;
          }
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        }
        localFragmentTransaction.commitAllowingStateLoss();
      }
    }
    label189:
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        Object localObject;
        FragmentTransaction localFragmentTransaction;
        Fragment localFragment;
        return;
        localFragmentTransaction.add(16908290, MainFragment.a(), MainFragment.class.getName());
        continue;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
        } else {
          ((ChatFragment)localObject).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 450);
        }
      }
    }
    QLog.d("Q.aio.BaseChatPie", 4, "returnMainFragment() mActivity instanceof ChatActivity ");
  }
  
  public void J()
  {
    try
    {
      if (this.jdField_A_of_type_Int == 0)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
        localIntentFilter.addAction("android.intent.action.PHONE_STATE");
        localIntentFilter.addAction("vivo_smart_shot_enter");
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
        this.jdField_A_of_type_Int = 1;
      }
      for (;;)
      {
        AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this);
        QLog.d("Q.aio.BaseChatPie", 1, "AIOTime doOnRegReceivershashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "registerReceiver but done");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "registerReceiver " + localException);
        }
      }
    }
  }
  
  public void K()
  {
    try
    {
      if (this.jdField_A_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_A_of_type_Int = 0;
      }
      for (;;)
      {
        boolean bool = AppNetConnInfo.unregisterNetInfoHandler(this);
        QLog.d("Q.aio.BaseChatPie", 1, "AIOTime doOnUnRegReceivers :" + bool + "hashCode = " + Integer.toHexString(hashCode()));
        return;
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "unRegisterReceiver but cannot");
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.BaseChatPie", 2, "unregisterReceiver:" + localException);
        }
      }
    }
  }
  
  public void L()
  {
    ThreadManager.post(new rof(this), 8, null, true);
  }
  
  public void M()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void N()
  {
    if (this.Y) {}
    do
    {
      do
      {
        return;
        ah();
        bi();
      } while ((this.jdField_d_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null));
      this.X = false;
    } while (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setVisibility(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "refreshListAdapter: listView.setVisibility(View.VISIBLE)");
    }
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    int i10 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getScrollY();
    int i7 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition() - this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int i8 = this.jdField_d_of_type_Int & 0xFFFF0000;
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "refreshListAdapter refreshFlag: " + i8);
    }
    Object localObject1;
    int i4;
    int i9;
    int i3;
    int i1;
    int i2;
    long l1;
    label477:
    label497:
    Object localObject2;
    label562:
    label608:
    label748:
    Object localObject5;
    switch (this.jdField_d_of_type_Int & 0xFFFF0000)
    {
    default: 
    case 65536: 
      for (localObject1 = localObject4;; localObject1 = localObject4)
      {
        i4 = this.jdField_m_of_type_Int;
        i9 = ((List)localObject4).size();
        i3 = ((List)localObject1).size();
        i1 = this.jdField_d_of_type_Int & 0xFFFF;
        if (QLog.isColorLevel()) {
          QLog.d("update1", 2, "refreshlistadapter dirtyFlag=" + i1);
        }
        if ((!this.jdField_x_of_type_Boolean) || (!this.Z)) {
          break;
        }
        i2 = 7;
        if (QLog.isColorLevel()) {
          QLog.d("update1", 2, "refreshlistadapter after set dirtyFlag=" + i2);
        }
        switch (i2)
        {
        case 4: 
        case 8: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        case 15: 
        default: 
          if (localObject4 == localObject1) {
            break label3284;
          }
          if ((i9 <= 0) || (i3 <= 0)) {
            break label3290;
          }
          l1 = ((ChatMessage)((List)localObject4).get(i9 - 1)).uniseq;
          i1 = i3 - 1;
          if (i1 < 0) {
            break label3290;
          }
          if ((i1 != i3 - 1) || (!UniteGrayTipUtil.a((MessageRecord)((List)localObject1).get(i1)))) {
            break label2868;
          }
          i1 = -1;
          if (i1 < 0) {
            break label2898;
          }
          i1 = i3 - (i9 - this.jdField_m_of_type_Int + i3 - 1 - i1);
          if (i2 != 5) {
            break label2926;
          }
          i1 = this.jdField_m_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), -1, null);
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, this.jdField_a_of_type_AndroidContentContext.getString(2131430171), 3000).b(a());
          i1 = i3 - (i9 - i1);
          this.jdField_d_of_type_Int = 0;
          this.jdField_h_of_type_Long = SystemClock.uptimeMillis();
          this.jdField_m_of_type_Int = i1;
          switch (i8)
          {
          default: 
            if ((this.jdField_b_of_type_JavaUtilList != null) && (this.jdField_b_of_type_JavaUtilList.size() > 0))
            {
              localObject2 = (MessageForShakeWindow)this.jdField_b_of_type_JavaUtilList.get(this.jdField_b_of_type_JavaUtilList.size() - 1);
              if (!((MessageForShakeWindow)localObject2).isSendFromLocal()) {
                break label3054;
              }
              this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new roj(this, (MessageForShakeWindow)localObject2), 20L);
              label681:
              this.jdField_b_of_type_JavaUtilList.clear();
            }
            if (i1 == i3)
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.d();
              localObject2 = LightReplyMenuManager.a();
              if ((localObject2 != null) && (((LightReplyMenuManager)localObject2).b())) {
                ((LightReplyMenuManager)localObject2).a();
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
              break label3267;
            }
            if (1 != ArkAiAppCenter.jdField_a_of_type_Int) {
              break label3252;
            }
            localObject2 = ((List)localObject1).iterator();
            for (;;)
            {
              if (!((Iterator)localObject2).hasNext()) {
                break label3267;
              }
              localObject4 = (ChatMessage)((Iterator)localObject2).next();
              localObject5 = ((ChatMessage)localObject4).getExtInfoFromExtStr("ark_text_analysis_flag");
              if (!"1".equals(localObject5)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a((ChatMessage)localObject4);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
          }
          break;
        }
      }
    }
    List localList = a(this.jdField_v_of_type_Boolean);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.c(localList);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      StartupTracker.a(null, "AIO_BaseChatPie_Remove_Sticker_Cost");
      EmojiStickerManager.a().a(this, localList);
      StartupTracker.a("AIO_BaseChatPie_Remove_Sticker_Cost", null);
    }
    if ((this.R) && (localList.size() > 0))
    {
      localObject5 = (ChatMessage)localList.get(localList.size() - 1);
      ((ChatMessage)localObject5).mPendantAnimatable = true;
      if ((localObject5 instanceof MessageForMarketFace))
      {
        localObject2 = ((MessageForMarketFace)localObject5).mMarkFaceMessage;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          ((ChatMessage)localObject5).parse();
          localObject1 = ((MessageForMarketFace)localObject5).mMarkFaceMessage;
        }
        if (((((MarkFaceMessage)localObject1).mobileparam != null) && (((MarkFaceMessage)localObject1).mobileparam.length > 0)) || ((((MarkFaceMessage)localObject1).mediaType == 3) && (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))) {
          ((MessageForMarketFace)localObject5).needToPlay = true;
        }
      }
    }
    if ((1000 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1004 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (1022 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))
    {
      localObject2 = ChatActivityUtils.b(localList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      label1072:
      if (this.jdField_a_of_type_Boolean)
      {
        if ((1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) || (localObject2 != null) || (localList.size() != 0)) {
          break label1735;
        }
        localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_JavaLangString);
        label1127:
        if (localObject1 == null) {
          break label1922;
        }
        b(true);
        this.jdField_e_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        if (N) {
          this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription((CharSequence)localObject1);
        }
      }
      label1180:
      localObject5 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (MessageRecord)localObject2);
      if (1000 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
        localObject1 = localObject5;
        if (1004 != this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {}
      }
      else
      {
        localObject2 = localObject5;
        if (localList.size() >= 15)
        {
          localObject2 = localObject5;
          if (!((ChatMessage)localList.get(0)).mNeedGrayTips) {
            localObject2 = null;
          }
        }
        localObject1 = localObject2;
        if (!localList.isEmpty())
        {
          localObject1 = localObject2;
          if (((ChatMessage)localList.get(0)).mMessageSource == null)
          {
            localObject1 = localObject2;
            if (((ChatMessage)localList.get(0)).mNeedGrayTips)
            {
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                ((ChatMessage)localList.get(0)).mNeedGrayTips = false;
                localObject1 = localObject2;
              }
            }
          }
        }
      }
      localObject2 = localObject1;
      if (1001 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) {
        if (!FaceScoreUtils.jdField_a_of_type_JavaUtilHashSet.contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
        {
          localObject2 = localObject1;
          if (!FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {}
        }
        else
        {
          localObject2 = null;
        }
      }
      localObject1 = localObject2;
      if (10002 == this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
        localObject1 = localObject2;
        if (FaceScoreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          localObject1 = null;
        }
      }
      if (MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) != 1032) {
        break label3332;
      }
      localObject1 = null;
    }
    label1922:
    label3332:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        localObject2 = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(131);
        if (((TroopBindPublicAccountMgr)localObject2).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          ((TroopBindPublicAccountMgr)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localList);
        }
      }
      if ((localList != null) && (localList.size() != 0))
      {
        localObject2 = (ChatMessage)localList.get(localList.size() - 1);
        if ((!((ChatMessage)localObject2).isSend()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0))
        {
          if (!(localObject2 instanceof MessageForPoke)) {
            break label1930;
          }
          if (!((MessageForPoke)localObject2).isPlayed)
          {
            localObject5 = (MessageForPoke)localObject2;
            PokeItemAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForPoke)localObject5).interactType, 0, ((MessageForPoke)localObject5).strength);
            if (QLog.isColorLevel()) {
              QLog.d("PokeMsg", 2, "receive PokeMsg strength:" + ((MessageForPoke)localObject5).strength + "." + localObject2);
            }
          }
        }
      }
      for (;;)
      {
        a(localList, (CharSequence)localObject1, this.jdField_d_of_type_Int);
        v();
        ChatFragment.a(true);
        this.jdField_c_of_type_AndroidViewViewGroup.invalidate();
        localObject1 = localList;
        break;
        localObject2 = ChatActivityUtils.a(localList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break label1072;
        label1735:
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1025))
        {
          localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          break label1127;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10002))
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1001) {}
          for (i1 = 2131435840;; i1 = 2131437406)
          {
            localObject1 = ((Context)localObject1).getString(i1);
            break;
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 10004)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131435852);
          break label1127;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1029)
        {
          localObject1 = this.jdField_a_of_type_AndroidContentContext.getString(2131435847);
          break label1127;
        }
        localObject1 = ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, (MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break label1127;
        b(false);
        break label1180;
        label1930:
        PokeItemAnimationManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, -1, 0, -1);
        if (QLog.isColorLevel()) {
          QLog.d("PokeMsg", 2, "receive unPokeMsg strength:-1." + localObject2);
        }
      }
      int i5;
      label2070:
      int i6;
      if (i1 == 0)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() < 0) {
          break label3323;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1);
        if (localObject2 == null) {
          break label3318;
        }
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount() > 0)
        {
          i2 = i1;
          if (((View)localObject2).getId() == 2131361978)
          {
            i2 = i1;
            if (i1 == 0) {
              i2 = 1;
            }
          }
        }
        i5 = ((View)localObject2).getBottom();
        i1 = i2;
        i2 = i5;
        i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
        if (QLog.isColorLevel()) {
          QLog.d("update1", 2, "refreshlistadapter=====lastbuttom=" + i2 + " listHeight=" + i5);
        }
        i6 = i2;
      }
      for (;;)
      {
        i2 = i1;
        if (i6 <= i5)
        {
          i2 = i1;
          if (i1 == 0) {
            i2 = 1;
          }
        }
        break;
        if (!v())
        {
          i2 = 0;
          break;
        }
        label2442:
        label2616:
        label2898:
        label3284:
        if ((i1 & 0x10) == 16)
        {
          i2 = 16;
          break;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
            this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.postDelayed(new rog(this), 300L);
          }
          for (;;)
          {
            i1 = i3;
            break;
            this.jdField_x_of_type_Int += 1;
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "[refreshListAdapter]: refreshBottomCount=" + this.jdField_x_of_type_Int + ",refreshDelayForNextPie=" + V);
            }
            if (V)
            {
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new roh(this));
              V = false;
            }
            else if (this.jdField_x_of_type_Int == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 0);
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.post(new roi(this));
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.a();
          i1 = i3;
          break label497;
          if ((i9 > 0) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount() + i7 >= 0))
          {
            i5 = -1;
            i4 = i5;
            if (i3 <= 0) {
              break label3295;
            }
            if (i7 < ((List)localObject4).size()) {
              break label3307;
            }
          }
          label2521:
          label3290:
          label3295:
          label3307:
          for (i1 = ((List)localObject4).size() - 1;; i1 = i7)
          {
            if (i1 < 0) {}
            for (i6 = i1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();; i6 = i1)
            {
              l1 = ((ChatMessage)((List)localObject4).get(i6)).uniseq;
              i4 = 0;
              i1 = i5;
              if (i4 < i3)
              {
                if (((ChatMessage)((List)localObject1).get(i4)).uniseq == l1) {
                  i1 = i4;
                }
              }
              else
              {
                i4 = i1;
                if (i1 >= 0) {
                  break label3295;
                }
                i4 = i1;
                if (((List)localObject4).size() <= i6 + 1) {
                  break label3295;
                }
                l1 = ((ChatMessage)((List)localObject4).get(i6 + 1)).uniseq;
                i5 = 0;
                i4 = i1;
                if (i5 >= i3) {
                  break label3295;
                }
                if (((ChatMessage)((List)localObject1).get(i5)).uniseq != l1) {
                  break label2616;
                }
                i1 = 1;
                i4 = i5;
              }
              for (i5 = i1;; i5 = 0)
              {
                if (i4 >= 0)
                {
                  i6 = this.jdField_m_of_type_Int + i4;
                  i1 = i6;
                  if (i5 != 0) {
                    i1 = i6 - 1;
                  }
                  if ((i10 < 0) && (i4 == 0))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.springBackOverScrollHeaderView();
                    break label497;
                    i4 += 1;
                    break label2442;
                    i5 += 1;
                    break label2521;
                  }
                  if (i10 < 0)
                  {
                    i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
                    try
                    {
                      i6 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
                      i5 -= i6;
                    }
                    catch (NullPointerException localNullPointerException1)
                    {
                      for (;;)
                      {
                        i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
                      }
                    }
                    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
                    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i4 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), i5 + i10);
                    break label497;
                  }
                  i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
                  try
                  {
                    i6 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount()).getBottom();
                    i5 -= i6;
                  }
                  catch (NullPointerException localNullPointerException2)
                  {
                    for (;;)
                    {
                      i5 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeight();
                    }
                  }
                  this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(i4 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount(), i5);
                  break label497;
                }
                this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.hideOverScrollHeaderView();
                i1 = i3;
                break label497;
                aY();
                i1 = i4;
                break label497;
                Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
                if ((((List)localObject3).size() > 0) && (this.jdField_g_of_type_Long >= 0L))
                {
                  i1 = a((List)localObject3, this.jdField_g_of_type_Long);
                  if (i1 >= 0)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.b(i1);
                    this.jdField_g_of_type_Long = -1L;
                  }
                  i1 = i4;
                  break label497;
                  if (((ChatMessage)((List)localObject1).get(i1)).uniseq == l1) {
                    break label477;
                  }
                  i1 -= 1;
                  break;
                  if ((i3 > 0) && (!UniteGrayTipUtil.a((MessageRecord)((List)localObject1).get(i3 - 1))))
                  {
                    i1 = i3;
                    break label497;
                    label2926:
                    if (i2 == 6)
                    {
                      i4 = this.jdField_m_of_type_Int;
                      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
                      i1 = 0;
                      if (i1 < i2)
                      {
                        localObject3 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getItem(i1);
                        if ((localObject3 == null) || (((ChatMessage)localObject3).msgtype != -4009)) {}
                      }
                      for (;;)
                      {
                        localObject3 = this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable;
                        if (i1 == 0) {}
                        for (i2 = 0;; i2 = -1)
                        {
                          ((ScrollerRunnable)localObject3).a(i1, i2, null);
                          i1 = i3 - (i9 - i4);
                          break;
                          i1 += 1;
                          break label2948;
                        }
                        if (!this.jdField_q_of_type_Boolean) {
                          break label608;
                        }
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1001, new Object[0]);
                        this.jdField_q_of_type_Boolean = false;
                        break label608;
                        label3054:
                        l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.msg.shakemsg", 2, "time is:" + System.currentTimeMillis() + ",shmsgseq is:" + ((MessageForShakeWindow)localObject3).shmsgseq + ",msgUid is:" + ((MessageForShakeWindow)localObject3).msgUid + ",uniseq is:" + ((MessageForShakeWindow)localObject3).uniseq + ",onlineStatus is:" + l1 + ",userActiveStatus is:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int);
                        }
                        if ((l1 != 11L) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.jdField_a_of_type_Int != 0)) {
                          break label681;
                        }
                        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rom(this, (MessageForShakeWindow)localObject3), 20L);
                        break label681;
                        if (!"0".equals(localObject5)) {
                          break label748;
                        }
                        localObject5 = new ArrayList();
                        ((List)localObject5).add(localObject4);
                        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a((List)localObject5);
                        break label748;
                        if (ArkAiAppCenter.jdField_a_of_type_Int == 0) {
                          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a((List)localObject1);
                        }
                        PlayLastLogic.a().a((List)localObject1);
                        return;
                        i1 = 0;
                      }
                    }
                    break label562;
                  }
                }
                i1 = i4;
                break label497;
                i1 = -1;
                break label477;
              }
            }
          }
        }
        label2868:
        label3252:
        label3267:
        i2 = i1;
        label2948:
        break;
        label3318:
        i2 = 0;
        break label2070;
        label3323:
        i6 = 0;
        i5 = 0;
      }
    }
  }
  
  public void O()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getAdapter().getCount() - 1);
    }
  }
  
  protected void P()
  {
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
    ThreadPriorityManager.a(true);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a();
    AbstractGifImage.pauseAll();
    ApngImage.pauseAll();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr = null;
    }
  }
  
  public void Q()
  {
    this.jdField_E_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "isThemeDefault" + this.jdField_E_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_Boolean = false;
      if (ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground))
      {
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
          break label241;
        }
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
      }
      try
      {
        aK();
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(2130846138, 2130846139);
          this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845772, 2130845773);
        }
        return;
      }
      catch (Exception localException)
      {
        label241:
        QLog.d("Q.aio.BaseChatPie", 2, "onPostThemeChanged e:" + localException.getMessage() + "isThemeDefault" + this.jdField_E_of_type_Boolean);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
      }
      else
      {
        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  public void R()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQPlayerService", 2, "chatactivity refreshMagicFaceItem");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
  }
  
  protected void R_()
  {
    this.jdField_h_of_type_Int = 2;
    AIOUtils.a("Q.aio.BaseChatPie", "preStartBaseAIO", hashCode(), this.jdField_h_of_type_Int);
    this.I = false;
    this.X = false;
    this.Y = false;
    this.jdField_u_of_type_Boolean = true;
    this.jdField_B_of_type_Boolean = false;
    this.jdField_D_of_type_Boolean = false;
    this.jdField_v_of_type_Boolean = false;
    this.jdField_A_of_type_Boolean = false;
    AIOUtils.a(false);
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_begin", null, false, null);
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().density;
    StartupTracker.a(null, "AIO_doOnCreate_initUI");
    d();
    StartupTracker.a("AIO_doOnCreate_initUI", "AIO_doOnCreate_initData");
    g();
    StartupTracker.a("AIO_doOnCreate_initData", "AIO_updateSession");
  }
  
  public void S()
  {
    d(true, this.jdField_k_of_type_Boolean);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addFlags(128);
  }
  
  public void T()
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(3);
    d(false, false);
    x();
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(128);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(25, 1000L);
  }
  
  public void U()
  {
    int i2 = 0;
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && ((this.jdField_a_of_type_AndroidContentContext == null) || (((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "showAbnormalRecordDlg failed, mContext not valid");
      }
      return;
    }
    Object localObject = Build.MANUFACTURER;
    int i1;
    if (((String)localObject).equalsIgnoreCase("meizu")) {
      i1 = 2131433373;
    }
    for (;;)
    {
      try
      {
        localObject = new SpannableString(this.jdField_a_of_type_AndroidContentContext.getString(i1));
        if (i2 == 0) {
          break label249;
        }
        ((SpannableString)localObject).setSpan(new StatableSpanTextView.StatableForegroundColorSpan(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493061), this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493062)), ((SpannableString)localObject).length() - 7, ((SpannableString)localObject).length() - 1, 33);
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, "权限提示", (CharSequence)localObject, 0, 2131435179, null, null, new ror(this)).show();
        return;
      }
      catch (Exception localException) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.aio.BaseChatPie", 2, "show showAbnormalRecordDlg error : " + localException.getMessage());
      return;
      if (localException.equalsIgnoreCase("xiaomi"))
      {
        i1 = 2131433374;
      }
      else if (localException.equalsIgnoreCase("vivo"))
      {
        i1 = 2131433375;
      }
      else
      {
        i1 = 2131433372;
        i2 = 1;
      }
    }
    label249:
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, "权限提示", localException.toString(), "我知道了", "", null, new ros(this)).show();
  }
  
  public void V()
  {
    if (this.ae)
    {
      h();
      this.ae = false;
    }
    ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).b();
  }
  
  public void W()
  {
    aJ();
    try
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("CrashControl_com.tencent.mobileqq:peak", 4);
      if ((localObject == null) || (((SharedPreferences)localObject).getBoolean("allowpreload", true))) {
        break label785;
      }
      long l1 = ((SharedPreferences)localObject).getLong("starttime", 0L);
      i1 = ((SharedPreferences)localObject).getInt("controlwindow", 86400);
      long l2 = System.currentTimeMillis();
      if ((l1 <= 0L) || (i1 <= 0) || (l2 <= l1) || (l2 - l1 <= i1 * 1000)) {
        break label665;
      }
      ((SharedPreferences)localObject).edit().putBoolean("allowpreload", true).commit();
      i1 = 1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          MixedMsgManager localMixedMsgManager;
          ArrayList localArrayList1;
          ArrayList localArrayList2;
          String str;
          StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actNoPreloadPeak", true, 0L, 0L, null, "");
          i1 = 0;
        }
        catch (Exception localException2)
        {
          boolean bool;
          i1 = 0;
          continue;
        }
        localException1 = localException1;
        int i1 = 1;
        localException1.printStackTrace();
        continue;
        bool = false;
        continue;
        AIOPanelUtiles.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localException1);
        if (this.jdField_G_of_type_Boolean)
        {
          aP();
          continue;
          AIOPanelUtiles.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, localException1);
          if (this.jdField_G_of_type_Boolean)
          {
            aP();
            continue;
            i1 = 1;
          }
        }
      }
    }
    if (i1 != 0)
    {
      if (PeakUtils.a == null)
      {
        PeakUtils.a = new PreloadProcHitSession("peak_preload", "com.tencent.mobileqq:peak");
        PeakUtils.a.a();
      }
      ThreadManager.getSubThreadHandler().post(new rpd(this));
    }
    bool = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("PhotoConst.SEND_FLAG", false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onShow_otherThings, isPhotoPlusEditSend = " + bool);
    }
    if (bool)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
      ((Intent)localObject).removeExtra("PhotoConst.SEND_FLAG");
      localMixedMsgManager = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173);
      localArrayList1 = ((Intent)localObject).getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (MixedMsgManager.a((Intent)localObject))) {
        break label751;
      }
      localArrayList2 = new ArrayList();
      str = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList2);
      if ((android.text.TextUtils.isEmpty(str)) || (localArrayList1 == null) || (localArrayList1.size() <= 0) || (this.jdField_G_of_type_Boolean)) {
        break label724;
      }
      if (((Intent)localObject).getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0) == 2)
      {
        bool = true;
        localMixedMsgManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, localArrayList1, bool, str, localArrayList2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
        this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().removeExtra("PhotoConst.SELECTED_PATHS");
        aL();
      }
    }
    else
    {
      ThreadManager.getSubThreadHandler().post(new rpe(this));
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(31, 800L);
      bf();
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, null);
      a(BaseApplication.getContext(), "com.vivo.smartshot");
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "isvivo has shot" + jdField_y_of_type_Int);
      }
      if (!DeviceProfileManager.jdField_b_of_type_Boolean) {
        be();
      }
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, null);
      AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, (int)(5.0F * this.jdField_a_of_type_Float + 0.5F), (int)(5.0F * this.jdField_a_of_type_Float + 0.5F), 0, 0);
      AIOUtils.a(this.jdField_b_of_type_AndroidWidgetImageView, 0, 0, 0, (int)(50.0F * this.jdField_a_of_type_Float + 0.5F));
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null)
      {
        localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("panel");
        if ((localObject != null) && (((String)localObject).equals("ptv")))
        {
          h(false);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().removeExtra("panel");
        }
      }
      return;
      label665:
      QLog.d("Q.aio.BaseChatPie", 1, "preloadPeakProcess is not allowed as crash frequently.");
    }
  }
  
  public void X()
  {
    LogUtil.timeLogEnd(BaseApplicationImpl.getContext(), null, null, null, null, "aio_end", null, false, null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime onShow start");
    }
    StartupTracker.a(null, "AIO_onShow");
    StartupTracker.a(null, "AIO_onShow_emotion");
    bb();
    StartupTracker.a("AIO_onShow_emotion", null);
    V();
    StartupTracker.a(null, "AIO_onShow_updateUI");
    bd();
    StartupTracker.a("AIO_onShow_updateUI", "AIO_onShow_videoStatus");
    bc();
    StartupTracker.a("AIO_onShow_videoStatus", "AIO_onShow_report");
    o(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_onShow_report", "AIO_onShow_otherThings");
    W();
    StartupTracker.a("AIO_onShow_otherThings", "AIO_onShow_setReaded");
    bg();
    StartupTracker.a("AIO_onShow_setReaded", null);
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().hasExtra("launchApolloGame")) && (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("launchApolloGame", false))) {
      ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.c(this);
    }
    ThreadPriorityManager.a(false);
    StartupTracker.a("AIO_onShow", null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime onShow end");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager = new ComboUIManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
    }
    if (!(this instanceof TroopChatPie)) {
      l(true);
    }
  }
  
  public void Y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("fastimage", 2, "initAndQueryFastImage start! ");
    }
    if (!this.jdField_h_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "initAndQueryFastImage return!,  mAllowFastImage = " + this.jdField_h_of_type_Boolean);
      }
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout = ((FastImagePreviewLayout)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getLayoutInflater().inflate(2130968636, null));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131363476);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(7, 2131363476);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.rightMargin = ((int)(10.5D * this.jdField_a_of_type_Float + 0.5D));
        this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ((int)(4.0F * this.jdField_a_of_type_Float + 0.5F));
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setId(2131362057);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setHandler(this.jdField_a_of_type_MqqOsMqqHandler);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.b();
    } while (!QLog.isColorLevel());
    QLog.d("fastimage", 2, "initAndQueryFastImage end! ");
  }
  
  @TargetApi(11)
  public void Z()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a() == null) {}
    TroopGagMgr.SelfGagInfo localSelfGagInfo;
    do
    {
      return;
      localSelfGagInfo = ((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true);
    } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null);
    if (this.jdField_f_of_type_AndroidWidgetTextView == null)
    {
      TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localTextView.setId(2131362026);
      localTextView.setBackgroundResource(2130845508);
      localTextView.setTextSize(2, 14.0F);
      localTextView.setTextColor(-7829368);
      localTextView.setEnabled(false);
      localTextView.setGravity(17);
      int i1 = ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).indexOfChild(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.weight = 1.0F;
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localTextView, i1, localLayoutParams);
      this.jdField_f_of_type_AndroidWidgetTextView = localTextView;
    }
    if (localSelfGagInfo != null)
    {
      if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(localSelfGagInfo.jdField_b_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 2) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (this.jdField_l_of_type_AndroidWidgetTextView != null) {
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllEnable(false);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
    if (VersionUtils.e())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 0.6F);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(0.6F);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(0.6F);
    }
    this.jdField_e_of_type_Int = 2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
  }
  
  public int a(int paramInt)
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
  
  protected Dialog a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 230: 
      this.jdField_c_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624515);
      this.jdField_c_of_type_AndroidAppDialog.setContentView(2130968851);
      localTextView1 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131364010);
      localObject = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131362758);
      TextView localTextView2 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131364013);
      TextView localTextView3 = (TextView)this.jdField_c_of_type_AndroidAppDialog.findViewById(2131364014);
      localTextView1.setText(2131435108);
      ((TextView)localObject).setText(2131435111);
      localTextView3.setText(2131435110);
      localTextView3.setOnClickListener(new rns(this));
      localTextView2.setText(2131432998);
      localTextView2.setOnClickListener(new rnt(this));
      return this.jdField_c_of_type_AndroidAppDialog;
    case 231: 
      this.jdField_d_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624515);
      this.jdField_d_of_type_AndroidAppDialog.setContentView(2130968595);
      ((TextView)this.jdField_d_of_type_AndroidAppDialog.findViewById(2131362758)).setText(2131435104);
      return this.jdField_d_of_type_AndroidAppDialog;
    case 232: 
      this.jdField_e_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624515);
      this.jdField_e_of_type_AndroidAppDialog.setContentView(2130971594);
      localTextView1 = (TextView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131365531);
      localObject = (ImageView)this.jdField_e_of_type_AndroidAppDialog.findViewById(2131362749);
      localTextView1.setText(2131433453);
      ((ImageView)localObject).setImageResource(2130838746);
      return this.jdField_e_of_type_AndroidAppDialog;
    }
    this.jdField_f_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624515);
    this.jdField_f_of_type_AndroidAppDialog.setContentView(2130971594);
    TextView localTextView1 = (TextView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131365531);
    Object localObject = (ImageView)this.jdField_f_of_type_AndroidAppDialog.findViewById(2131362749);
    localTextView1.setText(2131433452);
    ((ImageView)localObject).setImageResource(2130838735);
    return this.jdField_f_of_type_AndroidAppDialog;
  }
  
  public View a()
  {
    return this.jdField_d_of_type_AndroidWidgetLinearLayout;
  }
  
  public View a(int paramInt)
  {
    long l1;
    if (paramInt == 8)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel = ((PlusPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968654, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenIconPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
    }
    if (paramInt == 3)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968963, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = this.jdField_G_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_e_of_type_Boolean = this.jdField_G_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_c_of_type_Boolean = this.jdField_G_of_type_Boolean;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_e_of_type_JavaLangString, this);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenEmoticonMainPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    if (paramInt == 2)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = ((AudioPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130970166, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (InputLinearLayout)this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout);
      p(-1);
      if (this.jdField_G_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setReceiptMode(true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenAudioPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
    }
    if (paramInt == 4)
    {
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener = new rpo(this);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setImageCountChangedListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener);
      }
      s(this.jdField_G_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setImageSentListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageSentListener);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenPhotolistPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
    if (paramInt == 14)
    {
      if (!t()) {
        return null;
      }
      l1 = System.currentTimeMillis();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_b_of_type_AndroidWidgetLinearLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, true);
      if (QLog.isColorLevel()) {
        QLog.d("OpenPanel", 2, "OpenFlashPicPanel:" + (System.currentTimeMillis() - l1));
      }
      return this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
    }
    if (paramInt == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel = new AIOFakePanel(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelAIOFakePanel;
    }
    if (paramInt == 21)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel = ((ApolloPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968624, null));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_C_of_type_Int, this.jdField_B_of_type_Int, this.jdField_D_of_type_Int);
      StartupTracker.a("apollo_panel_open", null);
      return this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel;
    }
    if (paramInt == 22) {
      return this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    }
    if (paramInt == 30)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel = ((ArkAppManagerPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968702, null));
      this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return this.jdField_a_of_type_ComTencentMobileqqArkArkAppManagerPanel;
    }
    if (paramInt == 23)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel = ((PokeAndEmoPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968652, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel;
    }
    if (paramInt == 24)
    {
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel = ((HotPicMainPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968641, null));
      this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, this.jdField_a_of_type_ComTencentWidgetXPanelContainer);
      return this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel;
    }
    if (paramInt == 18)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel = ((DoodlePanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130968630, null));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString).longValue(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, new rpp(this));
      }
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel;
    }
    if (paramInt == 28)
    {
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel = ((FlashChatPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130969422, null));
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel.a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      return this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel;
    }
    if (paramInt == 10)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel = ((HongBaoPanel)View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130969782, null));
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel;
    }
    return null;
  }
  
  public ViewGroup a()
  {
    return this.jdField_c_of_type_AndroidViewViewGroup;
  }
  
  public ImageView a()
  {
    return this.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public TextView a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView;
  }
  
  public TroopGiftAioPanelData a()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      return this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
    }
    return null;
  }
  
  public PlusPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel;
  }
  
  public SessionInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  }
  
  public AIOAnimationConatiner a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  }
  
  public StructingMsgItemBuilder.ViewCache a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache;
  }
  
  public PhotoListPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
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
      StringBuilder localStringBuilder = new StringBuilder().append("showArkTips : hide? :");
      if (paramString == null)
      {
        bool = true;
        QLog.d("Q.aio.BaseChatPie", 2, bool + ",mID=" + paramLong);
      }
    }
    else
    {
      if (paramString != null) {
        break label114;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    }
    for (;;)
    {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar;
      bool = false;
      break;
      label114:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsArkTipsBar, new Object[] { paramString, Long.valueOf(paramLong) });
    }
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
  
  public EmoticonMainPanel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  public MagicfaceViewController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController == null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = new MagicfaceViewController(this);
    }
    return this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  }
  
  public TroopGiftAnimationController a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController = new TroopGiftAnimationController(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_ComTencentMobileqqTroopgiftTroopGiftAnimationController;
  }
  
  public QQRecorder.RecorderParam a()
  {
    return new QQRecorder.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
  }
  
  @Deprecated
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
  }
  
  public List a()
  {
    return a(false);
  }
  
  public List a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -1L, paramBoolean);
  }
  
  public List a(boolean paramBoolean)
  {
    return a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
  }
  
  public final MqqHandler a()
  {
    return this.jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(14, paramInt1, paramInt2).sendToTarget();
    if ((paramInt1 == 2) && (paramInt2 != 2)) {
      jdField_z_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a(paramInt1, paramInt2);
    }
    if (paramInt1 == 24) {
      if (paramInt2 == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.a(bool1);
        label68:
        if (paramInt2 != 23) {
          break label164;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.a();
        }
      }
    }
    for (;;)
    {
      if ((paramInt1 == 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.c();
      }
      if (paramInt1 == 8)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.b();
      }
      return;
      bool1 = false;
      break;
      if (paramInt1 != 18) {
        break label68;
      }
      if (paramInt2 == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(bool1);
        break;
      }
      label164:
      if (paramInt2 == 18) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.b();
      } else if (paramInt2 == 24) {
        this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicMainPanel.f();
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "[doOnActivityResult], requestCode:" + paramInt1 + ",resultCode:" + paramInt2);
    }
    k();
    int i1;
    boolean bool1;
    if ((paramIntent != null) && (paramIntent.getExtras() != null))
    {
      i1 = paramIntent.getIntExtra("camera_type", 1);
      bool1 = paramIntent.getExtras().getBoolean("progress2View");
      if ((paramInt1 == 11000) && (i1 == 103)) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      Object localObject1;
      Object localObject4;
      if ((paramIntent != null) && (paramInt1 == 14002) && (paramInt2 == -1))
      {
        localObject1 = StructMsgFactory.a(paramIntent.getByteArrayExtra("stuctmsg_bytes"));
        if (localObject1 == null) {
          return;
        }
        localObject4 = paramIntent.getStringExtra("uin");
        i1 = paramIntent.getIntExtra("uintype", -1);
        int i2 = paramIntent.getIntExtra("cmshow_game_id", -1);
        ShareMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject4, i1, (AbsStructMsg)localObject1, null);
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "share_url_succeed", ApolloUtil.b(i1), 0, new String[] { Integer.toString(i2) });
      }
      for (;;)
      {
        if (((paramIntent != null) && (paramIntent.getExtras() != null) && ((paramIntent.getBooleanExtra("foward_editbar", false) == true) || (paramIntent.getBooleanExtra("destroy_last_activity", false) == true))) || (paramInt2 == 4))
        {
          if ((paramIntent != null) && (paramIntent.getExtras() != null))
          {
            localObject1 = paramIntent.getExtras();
            localObject4 = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidContentContext, SplashActivity.class), new int[] { 2 });
            ((Intent)localObject4).putExtras(new Bundle((Bundle)localObject1));
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject4);
          }
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setResult(4, paramIntent);
        }
        if ((paramInt1 != 21) || (paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
          break;
        }
        a(false, null, false);
        return;
        if (paramInt1 == 2)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setCanLock(false);
        }
        else if (paramInt1 == 4001)
        {
          EmojiHomeUiPlugin.statisticEmojiHomePageInfo(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramIntent);
        }
        else if ((paramInt1 == 103) && (!bool1))
        {
          a(false, true);
        }
        else if ((paramInt1 == 101) && (paramInt2 != -1))
        {
          a(false, false);
        }
        else if ((paramInt1 == 4779) && (paramInt2 == 8213))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(17);
        }
        else if ((paramInt1 == 4813) && (paramInt2 == 8213))
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(18);
        }
        else if (paramInt1 == 9999)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "isActionBack");
            }
            ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 128, "apolloPanel");
          }
        }
        else if (paramInt1 == 14003)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloPanel", 2, "check slave");
            }
            ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a().a(null);
          }
        }
        else if (paramInt1 == 13007)
        {
          try
          {
            i1 = Integer.parseInt(paramIntent.getStringExtra("babyq_video_type"));
            localObject1 = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
            if (localObject1 == null) {
              continue;
            }
            ((BabyQHandler)localObject1).a(i1);
          }
          catch (Exception localException1)
          {
            QLog.d("Q.aio.BaseChatPie", 1, "doOnActivityResult exception!", localException1);
          }
        }
        else if (paramInt1 == 11000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("faceGuide", 2, "onActivityResult = =" + paramInt1 + "resultCode" + paramInt2);
          }
          this.jdField_A_of_type_Boolean = false;
          this.aa = false;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(5, true);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(6, true);
          if (1000 == paramInt2)
          {
            i1 = paramIntent.getIntExtra("click_item", 1);
            if ((i1 == 9) || (i1 == 10) || (i1 == 14)) {
              this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
            }
            if (QLog.isColorLevel()) {
              QLog.d("XPanel", 2, "onActivityResult = setPanel=" + i1);
            }
            a(Integer.valueOf(i1));
          }
          else if (1001 == paramInt2)
          {
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          }
        }
        else if (paramInt1 == 13002)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "onActivityResulte() REQUEST_OPEN_SHORT_VIDEO_PLAYER...");
          }
          a(false, false);
          try
          {
            Object localObject2 = paramIntent.getStringExtra("babyq_video_type");
            if (android.text.TextUtils.isEmpty((CharSequence)localObject2)) {
              continue;
            }
            i1 = Integer.parseInt((String)localObject2);
            localObject2 = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
            if (localObject2 == null) {
              continue;
            }
            ((BabyQHandler)localObject2).a(i1);
          }
          catch (Exception localException2)
          {
            QLog.d("Q.aio.BaseChatPie", 1, "doOnActivityResult exception!", localException2);
          }
        }
        else if (paramInt1 == 13006)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult() REQUEST_OPEN_REACTIVE_SETTING");
          }
          aF();
        }
        else if (paramInt1 == 6)
        {
          if (((PhotoPlusManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getAppRuntime().getManager(168)).a()) {
            h(true);
          }
        }
        else if (paramInt1 == 100012)
        {
          if ((paramIntent != null) && (paramIntent.getIntExtra("camera_type", -1) == 103)) {
            h(true);
          }
        }
        else if (paramInt1 == 14001)
        {
          i1 = ChatTextSizeSettingActivity.a(this.jdField_a_of_type_AndroidContentContext);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int != i1)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int = i1;
            this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Int);
          }
        }
        else if (paramInt1 == 14004)
        {
          try
          {
            if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel == null) {
              continue;
            }
            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.l();
          }
          catch (Throwable localThrowable)
          {
            QLog.e("Q.aio.BaseChatPie", 1, localThrowable, new Object[0]);
          }
        }
        else
        {
          Object localObject3;
          if ((paramInt1 == 14006) || (paramInt1 == 14005))
          {
            localObject3 = CmGameUtil.a();
            if (localObject3 != null) {
              ((ApolloSurfaceView)localObject3).queueEvent(new rnp(this, (ApolloSurfaceView)localObject3, paramInt1, paramInt2, paramIntent));
            }
          }
          else if (paramInt2 == -1)
          {
            switch (paramInt1)
            {
            default: 
              break;
            case 0: 
              a(false, false);
              break;
            case 18: 
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
                  String str3 = localBundle.getString("latitude");
                  String str4 = localBundle.getString("longitude");
                  String str5 = localBundle.getString("description");
                  String str6 = localBundle.getString("title");
                  String str7 = localBundle.getString("summary");
                  String str8 = localBundle.getString("dianping_id");
                  localObject4 = localBundle.getString("poiId");
                  String str1 = localBundle.getString("latSpan");
                  String str2 = localBundle.getString("lngSpan");
                  if ((localObject4 != null) && (str1 != null))
                  {
                    localObject3 = str2;
                    if (str2 != null) {}
                  }
                  else
                  {
                    localObject4 = "";
                    str1 = "";
                    localObject3 = "";
                  }
                  ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, str3, str4, str5, str6, str7, str8, (String)localObject4, str1, (String)localObject3, localBundle);
                }
              }
              break;
            case 1: 
              localObject3 = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).getString("camera_photo_path", "");
              if ("".equals(localObject3))
              {
                QLog.d("Q.aio.BaseChatPie", 1, "camera result null");
                return;
              }
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501)
              {
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, paramIntent, 1);
              }
              else
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.BaseChatPie", 2, "on camera result " + i1);
                }
                localObject3 = EditPicActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (String)localObject3, true, true, true, true, true, 2, 99, 1);
                AIOUtils.a((Intent)localObject3, null);
                ((Intent)localObject3).putExtra("camera_type", i1);
                if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
                  ((Intent)localObject3).putExtra("babyq_ability", ((BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53)).a());
                }
                ((Intent)localObject3).putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
                ((Intent)localObject3).putExtra("editpic_cameratype", 3);
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject3);
              }
              break;
            case 10: 
              ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramInt1, paramIntent, 10);
              break;
            case 3: 
              j(paramIntent);
              break;
            case 20: 
              a(true, false);
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().clearFlags(1024);
              break;
            case 21: 
              paramIntent.putExtra("selfSet_leftViewText", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131433280));
              a(paramIntent.getExtras());
              break;
            case 2000: 
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult() ENTER_CHATOPTION_REQUEST");
              }
              aF();
              boolean bool2 = false;
              bool1 = bool2;
              if (paramIntent != null)
              {
                bool1 = bool2;
                if (paramIntent.getExtras() != null) {
                  bool1 = paramIntent.getExtras().getBoolean("isNeedFinish");
                }
              }
              if (bool1) {
                b(1);
              } else {
                a(false, false);
              }
              break;
            case 5: 
              switch (paramInt2)
              {
              }
            case 4: 
              while ((paramIntent != null) && ("AioVIP".equals(paramIntent.getStringExtra("callbackSn"))))
              {
                break;
                O();
              }
            case 100004: 
            case 100005: 
            case 100006: 
            case 100008: 
              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
                this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(paramInt1, paramIntent);
              }
              break;
            case 110: 
              if (paramIntent != null)
              {
                localObject3 = paramIntent.getStringExtra("roomId");
                if (!android.text.TextUtils.isEmpty((CharSequence)localObject3))
                {
                  localObject4 = paramIntent.getStringArrayListExtra("qqPhoneUserList");
                  ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Activity)this.jdField_a_of_type_AndroidContentContext, 3000, (String)localObject3, true, true, true, null, (ArrayList)localObject4, 1, 0);
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006407", "0X8006407", 3, 0, "", "", "", "");
                }
              }
              break;
            case 9009: 
              if (paramIntent != null)
              {
                localObject3 = paramIntent.getStringExtra("nearby_profile_nickname");
                if ((localObject3 != null) && (!((String)localObject3).equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString)))
                {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = ((String)localObject3);
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.aio.BaseChatPie", 2, "onActivityResult new nick is " + (String)localObject3);
                  }
                  this.jdField_a_of_type_MqqOsMqqHandler.post(new rnq(this));
                }
              }
              break;
            case 85: 
              if (paramIntent != null) {
                ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH"), false, true, paramIntent.getStringExtra(QQIndividualityUtils.jdField_d_of_type_JavaLangString), null);
              }
              break;
            case 9010: 
              RedBagVideoManager.a(paramIntent, a());
            }
          }
        }
      }
      continue;
      i1 = 1;
      bool1 = false;
    }
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.troop.special_msg", 2, "refreshHeadMessage==>type:" + paramInt1 + "|value:" + paramLong);
    }
    long l2 = 0L;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    long l1 = l2;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        l1 = l2;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (ChatMessage)((Iterator)localObject1).next();
      } while (MsgProxyUtils.a((MessageRecord)localObject2));
      l1 = ((ChatMessage)localObject2).shmsgseq;
    }
    localObject1 = new roc(this);
    int i1 = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a() == 9) {
      i1 = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie.troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + l1 + "|value:" + paramLong);
    }
    if (i1 == 0)
    {
      if (paramInt1 != 1) {
        break label255;
      }
      if ((int)l1 >= 1L + paramLong)
      {
        if (l1 - paramLong <= 200L) {
          break label1168;
        }
        paramLong = l1 - 200L;
      }
    }
    label1156:
    label1162:
    label1168:
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, true);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, (Runnable)localObject1);
      return;
      label255:
      if ((paramInt1 == 21) || (paramInt1 == 13) || (paramInt1 == 6) || (paramInt1 == 19) || (paramInt1 == 4) || (paramInt1 == 3) || (paramInt1 == 24) || (paramInt1 == 16) || (paramInt1 == 17) || (paramInt1 == 5) || (paramInt1 == 18) || (paramInt1 == 12))
      {
        ThreadManager.post(new rod(this, paramLong, paramInt2, l1, paramInt1, (Runnable)localObject1), 8, null, true);
        return;
      }
      if (paramInt1 == 20) {
        if (!(paramMessageRecord instanceof MessageForReplyText)) {
          break label1162;
        }
      }
      for (paramMessageRecord = (MessageForReplyText)paramMessageRecord;; paramMessageRecord = null)
      {
        if (paramInt2 <= 200)
        {
          if ((int)l1 >= 1L + paramLong)
          {
            if (!NetworkUtil.g(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
            {
              QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131430281, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
              TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, false);
              return;
            }
            if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
              this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, false);
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, (Runnable)localObject1);
            TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, true);
            return;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong, 0L);
          if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
            break label1156;
          }
          paramInt2 = 0;
          label530:
          if (paramInt2 >= ((List)localObject2).size()) {
            break label1156;
          }
          localObject1 = (MessageRecord)((List)localObject2).get(paramInt2);
          if ((MsgProxyUtils.a((MessageRecord)localObject1)) || ((localObject1 instanceof MessageForSafeGrayTips))) {}
        }
        for (;;)
        {
          if ((localObject1 != null) && (!UniteGrayTipUtil.a((MessageRecord)localObject1)))
          {
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(((MessageRecord)localObject1).uniseq);
            if (paramInt2 != -1)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null);
              TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, true);
              return;
              paramInt2 += 1;
              break label530;
            }
            if (((MessageRecord)localObject1).msgtype != -2006) {
              break;
            }
            QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, "原文被删除", 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
            return;
          }
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131430725, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, false);
          return;
          QQToast.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 2131430724, 0).b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
          TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "obj", "locate_post", paramMessageRecord, false);
          return;
          if ((paramInt1 != 15) && (paramInt1 != 10)) {
            break;
          }
          paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramLong);
          if ((paramMessageRecord != null) && (paramInt2 <= 200))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie.troop.special_msg", 2, "refreshHeadMessage==>unreadMsgCount:" + paramInt2 + ", fistseq:" + l1 + ", mr.shmsgseq:" + paramMessageRecord.shmsgseq);
            }
            if ((int)l1 >= paramMessageRecord.shmsgseq + 1L)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramMessageRecord.shmsgseq, false);
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, (Runnable)localObject1, this.jdField_a_of_type_MqqOsMqqHandler);
              return;
            }
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.c(paramLong);
            if (paramInt2 == -1) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.jdField_a_of_type_MqqOsMqqHandler);
            return;
          }
          boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie.trooptroop_pull_msg", 2, "所要定位的消息还没拉回来本地，并发拉取中...mUserActionState create, natvigateSeq:" + paramLong + ",isAioParallelPullMsgDone:" + bool);
          }
          if (bool)
          {
            if ((int)l1 >= 1L + paramLong)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips != null) {
                this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(l1, paramLong, false);
              }
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, 0, -1, (Runnable)localObject1, this.jdField_a_of_type_MqqOsMqqHandler);
              return;
            }
            paramInt2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.c(paramLong);
            if (paramInt2 == -1) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(paramInt1, paramInt2, paramInt2, null, this.jdField_a_of_type_MqqOsMqqHandler);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod = new TroopMessageManager.UserActionStateInParallelPullPeriod();
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.jdField_d_of_type_Int = TroopMessageManager.UserActionStateInParallelPullPeriod.jdField_c_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageManager$UserActionStateInParallelPullPeriod.a = TroopAioAgent.Message.a(paramInt1, paramLong, paramInt2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().addObserver(this);
          return;
          localObject1 = null;
        }
      }
    }
  }
  
  protected void a(int paramInt, Dialog paramDialog)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rnu(this), 1000L);
  }
  
  public void a(int paramInt, View paramView, ListView paramListView) {}
  
  public void a(int paramInt, MessageHandler.MsgSendCostParams paramMsgSendCostParams, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "refresh with dirty: " + paramInt + " uniseq: " + paramLong + " currentPauseRefreshFlag: " + this.Y);
    }
    if ((this.Y) && (this.jdField_d_of_type_Int == paramInt)) {}
    Message localMessage;
    label270:
    do
    {
      return;
      int i1 = paramInt & 0xFFFF0000;
      if ((paramInt & 0xFFFF) > (this.jdField_d_of_type_Int & 0xFFFF)) {
        paramInt &= 0xFFFF;
      }
      for (;;)
      {
        this.jdField_d_of_type_Int = (i1 | paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "refresh with refreshFlag: " + i1 + " scrollFlag: " + paramInt);
        }
        if ((!q()) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 6) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 5)) {
          break;
        }
        if (i1 != 262144) {
          break label270;
        }
        localMessage = new Message();
        Bundle localBundle = new Bundle();
        localBundle.putLong("messageUniseq", paramLong);
        localMessage.setData(localBundle);
        localMessage.what = 78;
        localMessage.obj = paramMsgSendCostParams;
        localMessage.arg1 = 0;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 400L);
        return;
        paramInt = this.jdField_d_of_type_Int & 0xFFFF;
      }
      localMessage = new Message();
      localMessage.what = 12;
      if (paramMsgSendCostParams != null) {
        localMessage.obj = paramMsgSendCostParams;
      }
      if (i1 < 196608) {
        break;
      }
    } while (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(12));
    paramLong = SystemClock.uptimeMillis();
    if (paramLong - this.jdField_h_of_type_Long > 1000L)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 1000L - (paramLong - this.jdField_h_of_type_Long));
    return;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new rob(this));
    }
    for (;;)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(12);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.d();
    }
  }
  
  public void a(int paramInt, String paramString, long paramLong)
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
      a(true, true);
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, paramLong);
    }
    a(true, false);
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
    label217:
    label222:
    label223:
    for (;;)
    {
      return;
      if (!paramBoolean2)
      {
        Object localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
        {
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
          if (localObject != null) {
            break label222;
          }
          localObject = this.jdField_a_of_type_ComTencentMobileqqDataNoC2CExtensionInfo;
        }
        for (;;)
        {
          if (localObject == null) {
            break label223;
          }
          if (paramInt == 2)
          {
            ((NoC2CExtensionInfo)localObject).isDataChanged = true;
            return;
          }
          if (!((NoC2CExtensionInfo)localObject).isDataChanged) {
            if (((NoC2CExtensionInfo)localObject).audioPanelType == paramInt) {
              break label132;
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
              break label217;
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
  
  public void a(long paramLong)
  {
    if (paramLong < 0L) {
      return;
    }
    this.jdField_g_of_type_Long = paramLong;
    b(65552);
  }
  
  public void a(Context paramContext, int paramInt1, String paramString, long paramLong, int paramInt2, LightReplyEmojs paramLightReplyEmojs)
  {
    if ((paramInt1 == 1) && (((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramString, true).jdField_a_of_type_Boolean)) {
      QQToast.a(a(), 2131430256, 0).b(a().getTitleBarHeight());
    }
    MessageRecord localMessageRecord;
    do
    {
      do
      {
        return;
        localMessageRecord = ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, paramInt1, paramLong);
        if (!(localMessageRecord instanceof MessageForUniteGrayTip)) {
          break;
        }
        paramContext = (MessageForUniteGrayTip)localMessageRecord;
      } while ((paramContext.tipParam == null) || (paramContext.tipParam.jdField_b_of_type_Int != 1));
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, "图片已删除", 0).a();
      return;
      if ((localMessageRecord instanceof ChatMessage))
      {
        a(paramContext, (ChatMessage)localMessageRecord, paramInt2, paramLightReplyEmojs);
        return;
      }
    } while (localMessageRecord != null);
    ThreadManager.post(new rqx(this, paramString, paramInt1, paramLong, paramContext, paramInt2, paramLightReplyEmojs), 8, null, true);
  }
  
  public void a(Context paramContext, ChatMessage paramChatMessage, int paramInt, LightReplyEmojs paramLightReplyEmojs)
  {
    Object localObject2 = new MessageForReplyText.SourceMsgInfo();
    ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSeq = paramChatMessage.shmsgseq;
    ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSenderUin = Long.parseLong(paramChatMessage.senderuin);
    ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgTime = ((int)paramChatMessage.time);
    ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceSummaryFlag = 1;
    ((MessageForReplyText.SourceMsgInfo)localObject2).mType = 2;
    ((MessageForReplyText.SourceMsgInfo)localObject2).mRichMsg2 = MessageForReplyText.parseMsgToJsonText(paramChatMessage, paramLightReplyEmojs.emoCode, paramInt);
    Object localObject1 = AnonymousChatHelper.a(paramChatMessage);
    if (!android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString)) {
      ((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName = ((AnonymousChatHelper.AnonymousExtInfo)localObject1).jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      ((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgText = paramChatMessage.getSummaryMsg();
      localObject1 = new ChatActivityFacade.SendMsgParams();
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_b_of_type_Int = this.jdField_u_of_type_Int;
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_a_of_type_Int = this.jdField_s_of_type_Int;
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_c_of_type_Boolean = this.T;
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
      ((ChatActivityFacade.SendMsgParams)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = ((MessageForReplyText.SourceMsgInfo)localObject2);
      localObject2 = ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin, paramChatMessage.senderuin);
      paramContext = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramContext, paramChatMessage.senderuin, paramChatMessage.senderuin, (String)localObject2, false, true);
      localObject2 = new ArrayList();
      paramChatMessage = AtTroopMemberSpan.a(paramContext, (ArrayList)localObject2);
      paramContext = paramChatMessage;
      if (!android.text.TextUtils.isEmpty(paramLightReplyEmojs.android_key)) {}
      try
      {
        paramContext = Base64Util.decode(paramLightReplyEmojs.android_key, 0);
        paramContext = paramChatMessage + new String(paramContext, "ISO-8859-1");
        a(paramContext, (ChatActivityFacade.SendMsgParams)localObject1, (ArrayList)localObject2);
        return;
        if ((((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSenderUin != 50000000L) && (((MessageForReplyText.SourceMsgInfo)localObject2).mSourceMsgSenderUin != 1000000L)) {
          continue;
        }
        localObject1 = TroopBusinessUtil.a(paramChatMessage);
        if (localObject1 == null) {
          continue;
        }
        ((MessageForReplyText.SourceMsgInfo)localObject2).mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject1).jdField_c_of_type_JavaLangString;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
          paramContext = paramChatMessage;
        }
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vivo", 2, "isPackageExist isVivoShot=" + jdField_y_of_type_Int);
    }
    if (jdField_y_of_type_Int != 0) {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
    for (;;)
    {
      return;
      String str = Build.MANUFACTURER.toUpperCase();
      if ((!str.endsWith("BBK")) && (!str.endsWith("VIVO")))
      {
        jdField_y_of_type_Int = 2;
        return;
      }
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext.getApplicationInfo(paramString, 8192);
        jdField_y_of_type_Int = 1;
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
          jdField_y_of_type_Int = 2;
        }
      }
    }
  }
  
  protected void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    b(paramContext, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public void a(Intent paramIntent)
  {
    if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130846138, 2130846139);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
    a(true, false);
    b(paramIntent);
    b(false);
    n();
    this.jdField_e_of_type_Boolean = d();
    this.jdField_f_of_type_Boolean = c();
    l(paramIntent);
    e(paramIntent);
    u();
    p();
    m();
    this.jdField_o_of_type_Int = 1;
    this.P = true;
    this.jdField_c_of_type_Int = 0;
    f(false);
  }
  
  public void a(Intent paramIntent, int paramInt)
  {
    int i1 = paramIntent.getIntExtra(AlbumConstants.h, -1);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "handleRequest requestCode " + i1);
    }
    if ((i1 == 2) || (i1 == 1)) {
      j(paramIntent);
    }
    if (paramInt == 1) {
      FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    while ((paramInt != 2) || (this.jdField_H_of_type_Boolean)) {
      return;
    }
    FriendHotTipsBar.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.BaseChatPie", 2, "onConfigurationChanged");
    }
    ac();
    if (paramConfiguration.orientation == 2) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7B", "0X8005C7B", 0, 0, "", "", "", "");
    }
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
  
  public void a(View paramView) {}
  
  public void a(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramImageView != null)
    {
      if (this.jdField_E_of_type_Boolean) {
        paramImageView.setImageResource(paramInt2);
      }
    }
    else {
      return;
    }
    paramImageView.setImageResource(paramInt1);
  }
  
  public void a(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    paramSendMsgParams.jdField_b_of_type_Int = this.jdField_u_of_type_Int;
    paramSendMsgParams.jdField_a_of_type_Int = this.jdField_s_of_type_Int;
    paramSendMsgParams.jdField_c_of_type_Boolean = this.T;
    paramSendMsgParams.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
    paramSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.length() > jdField_l_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText.substring(0, jdField_l_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = 0;
    }
    paramSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
  }
  
  public void a(SessionInfo paramSessionInfo, DraftTextManager paramDraftTextManager, CharSequence paramCharSequence, QQAppInterface paramQQAppInterface, String paramString, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    ThreadManager.post(new SaveTextDraftJob(this, paramSessionInfo, paramDraftTextManager, paramCharSequence, paramQQAppInterface, paramString, paramSourceMsgInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131362132)), 8, null, false);
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    paramApolloInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, true);
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool2 = true;
    int i2 = 0;
    boolean bool1;
    int i1;
    if (paramInt > 0)
    {
      bool1 = true;
      this.R = bool1;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label108;
      }
      i1 = 1;
      bool1 = false;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("sendback", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "isC2C=" + bool1);
      }
      if ((i1 == 0) && (!bool1))
      {
        return;
        bool1 = false;
        break;
        label108:
        if (!MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) {
          break label411;
        }
        i1 = 0;
        bool1 = bool2;
        continue;
      }
      int i3;
      ChatMessage localChatMessage;
      long l2;
      if (this.R)
      {
        paramQQAppInterface = a();
        i3 = paramQQAppInterface.size();
        if (i2 >= i3) {
          break label403;
        }
        localChatMessage = (ChatMessage)paramQQAppInterface.get(i2);
        if (!localChatMessage.isread) {
          if (i1 != 0) {
            l2 = localChatMessage.shmsgseq;
          }
        }
      }
      for (;;)
      {
        label189:
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.aio.BaseChatPie", 2, "onPreSetReadConfirm_AIOEggs hasUnreadCount=" + paramInt + "totalList count=" + i3);
          l1 = l2;
        }
        for (;;)
        {
          label241:
          if (QLog.isColorLevel()) {
            QLog.d("AioAnimationDetector", 2, "onPreSetReadConfirm_AIOEggs: hasUnread=" + this.R + ", lastMsgTimeOrSeq=" + l1);
          }
          paramQQAppInterface = AioAnimationDetector.a();
          paramQQAppInterface.jdField_a_of_type_Boolean = this.R;
          paramQQAppInterface.jdField_a_of_type_Long = l1;
          if (this.R) {}
          for (;;)
          {
            ChatActivityFacade.jdField_a_of_type_Long = l1;
            return;
            l2 = localChatMessage.time;
            break label189;
            i2 += 1;
            break;
            paramQQAppInterface = paramQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
            if (paramQQAppInterface == null) {
              break label395;
            }
            if (i1 != 0)
            {
              l1 = paramQQAppInterface.shmsgseq;
              break label241;
            }
            l1 = paramQQAppInterface.time;
            break label241;
            l1 += 1L;
          }
          label395:
          l1 = -1L;
        }
        label403:
        l2 = -1L;
      }
      label411:
      bool1 = false;
      i1 = 0;
    }
  }
  
  public void a(QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramMessage.isread) || (paramMessage.isSendFromLocal()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramMessage)) || (MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessage))) {}
    while ((((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(paramMessage.frienduin)) || ((paramMessage.istroop == 7220) && ((paramMessage.extInt == 5) || (paramMessage.extInt == 6))) || (MsgProxyUtils.d(paramMessage.senderuin)) || (((paramMessage.istroop == 1001) || (paramMessage.istroop == 10002)) && ((MsgProxyUtils.c(paramMessage)) || (MsgProxyUtils.d(paramMessage)) || (paramMessage.msgtype == -2058) || ((paramMessage.istroop != 7220) && (android.text.TextUtils.equals(paramMessage.frienduin, AppConstants.ar))) || (ConfessMsgUtil.a(paramMessage))))) {
      return;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_AndroidContentContext, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    paramMessage = new ron(this, paramMessage, localIntent);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(paramMessage);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    long l1 = paramChatMessage.time;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {}
    for (l1 = paramChatMessage.shmsgseq;; l1 = paramChatMessage.time)
    {
      if (localList.size() > 0)
      {
        int i1 = a(localList, l1);
        if (i1 >= 0) {
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelection(i1);
        }
      }
      return;
    }
  }
  
  public void a(ChatMessage paramChatMessage, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramChatMessage, paramInt);
  }
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    int i7 = 1;
    int i4;
    int i3;
    int i2;
    int i1;
    int i5;
    if (AIOUtils.a(1) == 0)
    {
      i4 = 1;
      if (i4 != 0)
      {
        paramChatMessage = MultiMsgManager.a().jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
        i3 = 0;
        i2 = 0;
        i1 = 1;
        if (!paramChatMessage.hasNext()) {
          break label229;
        }
        Object localObject = (Map.Entry)paramChatMessage.next();
        if (!((Boolean)((Map.Entry)localObject).getValue()).booleanValue()) {
          break label212;
        }
        i5 = i3 + 1;
        localObject = (ChatMessage)((Map.Entry)localObject).getKey();
        i3 = FlashPicHelper.a((MessageRecord)localObject) | i2;
        i2 = i1;
        if (i4 != 0)
        {
          i2 = i1;
          if (i1 != 0) {
            if (MultiMsgProxy.b((ChatMessage)localObject))
            {
              i2 = i1;
              if (i5 <= 1) {}
            }
            else
            {
              i2 = 0;
            }
          }
        }
        if (i2 != 0) {
          break label182;
        }
        i1 = i2;
      }
    }
    for (;;)
    {
      if (i3 == 0)
      {
        i2 = i7;
        label157:
        if (this.jdField_j_of_type_AndroidWidgetImageView != null) {
          this.jdField_j_of_type_AndroidWidgetImageView.setEnabled(i1 & i2);
        }
        return;
        i4 = 0;
        break;
        label182:
        i1 = i5;
      }
      for (;;)
      {
        i5 = i3;
        int i6 = i2;
        i3 = i1;
        i2 = i5;
        i1 = i6;
        break;
        i2 = 0;
        break label157;
        label212:
        i5 = i1;
        i1 = i3;
        i3 = i2;
        i2 = i5;
      }
      label229:
      i3 = i2;
    }
  }
  
  public void a(DraftTextInfo paramDraftTextInfo)
  {
    if (paramDraftTextInfo != null) {}
    for (Object localObject = paramDraftTextInfo.text;; localObject = "")
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject);
      if ((this.jdField_o_of_type_AndroidViewView.getVisibility() != 0) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)) {
        break;
      }
      return;
    }
    if ((paramDraftTextInfo != null) && (paramDraftTextInfo.sourceMsgSeq != 0L))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq = paramDraftTextInfo.sourceMsgSeq;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = paramDraftTextInfo.sourceMsgText;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin = paramDraftTextInfo.sourceSenderUin;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime = paramDraftTextInfo.mSourceMsgTime;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = paramDraftTextInfo.mSourceSummaryFlag;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = paramDraftTextInfo.mSourceType;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mRichMsg = paramDraftTextInfo.mSourceRichMsg;
      i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int i2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      int i3 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight();
      paramDraftTextInfo = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, i1 - i2 - i3, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (paramDraftTextInfo != null)
      {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, paramDraftTextInfo.getDrawable(), null, null);
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131362132, paramDraftTextInfo);
      }
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
    int i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length();
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (paramDraftTextInfo = "";; paramDraftTextInfo = this.jdField_a_of_type_JavaLangString)
    {
      ((Editable)localObject).insert(i1, paramDraftTextInfo);
      if ((ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c()) && (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_JavaLangString.length() > 10)) {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rqq(this), 100L);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().length());
      this.jdField_o_of_type_Boolean = false;
      return;
    }
  }
  
  public void a(Emoticon paramEmoticon)
  {
    ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramEmoticon);
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b() != 1)) {}
    ActionGlobalData localActionGlobalData;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) && (paramInt == 1) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0));
      localActionGlobalData = MagicfaceActionManager.a(paramEmoticon, 1);
    } while ((!paramBoolean) && (localActionGlobalData != null) && (paramInt == 1) && (!localActionGlobalData.jdField_c_of_type_Boolean));
    a().a(paramEmoticon, paramInt, paramString);
  }
  
  public void a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if (paramMessageForShakeWindow == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList == null) {
      this.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_b_of_type_JavaUtilList.add(paramMessageForShakeWindow);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    try
    {
      String str1 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_current_amount");
      String str2 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_total_amount");
      long l1 = Long.parseLong(str1);
      long l2 = Long.parseLong(str2);
      if ((l1 > 0L) && (l2 > 0L) && (l1 <= l2))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr = new GoldMsgAnimatorCtr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rnw(this, l1, l2, paramMessageRecord), paramLong);
      }
      return;
    }
    catch (Exception paramMessageRecord)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.aio.BaseChatPie", 2, "postGoldMsgAnim start animation fail!");
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    paramEmoticonInfo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentWidgetXEditTextEx, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void a(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable)
  {
    if ((paramEmoticonInfo2.jdField_c_of_type_Int == 6) && ((paramEmoticonInfo2 instanceof PicEmoticonInfo)) && (((PicEmoticonInfo)paramEmoticonInfo2).a())) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711688))
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
        a(0, null, -1L);
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
    }
    d(false);
    bp();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "startRecord() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(false);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderParam);
    String str = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null, false);
    paramRecorderParam = MessageForPtt.getLocalFilePath(paramRecorderParam.jdField_c_of_type_Int, str);
    if ((str != null) && (!str.equals(paramRecorderParam))) {
      new File(str).deleteOnExit();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + paramRecorderParam);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramRecorderParam, paramBoolean);
      if (this.jdField_i_of_type_Int >= 0) {
        this.jdField_i_of_type_Int += 1;
      }
      return;
      paramRecorderParam = str;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    NowVideoController.a().a(paramAbsListView, paramInt);
    ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, paramInt);
    if (paramInt == 0)
    {
      ScrollPlayer.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
      URLDrawable.resume();
      AbstractGifImage.resumeAll();
      AbstractVideoImage.resumeAll();
      ApngImage.playByTag(0);
      VasFaceManager.b();
      com.etrump.mixlayout.ETTextView.jdField_i_of_type_Boolean = true;
      FontManager.a(this);
      QQLiveImage.resumeAll();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.c();
      AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).f();
      ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a(2, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).b();
      if ((this.jdField_t_of_type_Boolean) && (this.jdField_a_of_type_MqqOsMqqHandler != null))
      {
        this.jdField_t_of_type_Boolean = false;
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711697);
        paramAbsListView = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711697);
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramAbsListView, BubbleManager.jdField_a_of_type_Long);
      }
      BubbleDiyFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      DiyPendantFetcher.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
      EmojiStickerManager.a().b(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_v_of_type_Boolean));
      DropFrameMonitor.a().a("list_aio_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
      DuiButtonImageView.d();
      if (this.jdField_d_of_type_Int == 0) {
        AIOSingleReporter.a().a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      }
      PlayLastLogic.a().a(this.jdField_g_of_type_Int);
      if (paramInt == 1) {
        bq();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.a(this.jdField_g_of_type_Int);
      }
      return;
    }
    ScrollPlayer.a(true);
    if (paramInt == 2) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
    }
    for (;;)
    {
      VasFaceManager.a();
      URLDrawable.pause();
      if (!PicItemBuilder.jdField_f_of_type_Boolean)
      {
        AbstractGifImage.pauseAll();
        ApngImage.pauseAll();
        com.etrump.mixlayout.ETTextView.jdField_i_of_type_Boolean = false;
      }
      AbstractVideoImage.pauseAll();
      QQLiveImage.pauseAll();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b();
      if (paramInt == 1) {
        g(false);
      }
      ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45)).a();
      DropFrameMonitor.a().a("list_aio_" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      DuiButtonImageView.c();
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.b();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
    int i6 = paramInt3 - i4 - i3;
    int i5 = i6 - (paramInt1 - i4) - paramInt2;
    if (QLog.isColorLevel()) {
      QLog.i("BaseChatPieOnScroll", 2, "firstVisibleItem = " + paramInt1 + ",visibleItemCount = " + paramInt2 + ",totalItemCount = " + paramInt3 + ",footerCnt = " + i3 + ",headerCnt = " + i4);
    }
    if (this.jdField_k_of_type_Int == 0) {
      this.jdField_k_of_type_Int = paramInt1;
    }
    if ((!android.text.TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) && (this.jdField_k_of_type_Int - paramInt1 > 5)) {
      aj();
    }
    Object localObject;
    long l1;
    if (this.jdField_m_of_type_Int < i6)
    {
      int i2 = paramInt1 + paramInt2 - i3 - i4;
      i1 = i2;
      if (i2 >= paramInt3 - i4 - i3) {
        i1 = i6 - 1;
      }
      if (i1 >= this.jdField_m_of_type_Int) {
        this.jdField_m_of_type_Int = (i1 + i3);
      }
      if (i5 == 0) {
        this.jdField_m_of_type_Int = i6;
      }
      i1 = i6 - this.jdField_m_of_type_Int;
      if (i1 != this.jdField_n_of_type_Int)
      {
        if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(13)) {
          this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(13);
        }
        localObject = this.jdField_a_of_type_MqqOsMqqHandler;
        Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(13, i1, i5);
        if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue()) {
          break label375;
        }
        l1 = 1500L;
        label298:
        ((MqqHandler)localObject).sendMessageDelayed(localMessage, l1);
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        this.jdField_n_of_type_Int = i1;
      }
      localObject = PlayLastLogic.a();
      if (paramAbsListView.getChildAt(0) == null) {
        break label381;
      }
    }
    label375:
    label381:
    for (int i1 = paramAbsListView.getChildAt(0).getTop();; i1 = 0)
    {
      ((PlayLastLogic)localObject).a(paramInt1, paramInt2, i4, i3, paramInt3, i1, paramAbsListView.getWidth(), paramAbsListView.getHeight());
      return;
      i1 = 0;
      break;
      l1 = 0L;
      break label298;
    }
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageButton != null)
    {
      this.K = false;
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(this.K);
    }
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
    AIOUtils.jdField_m_of_type_Boolean = true;
    if ((paramObject == null) || (!(paramObject instanceof Integer))) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.BaseChatPie", 2, "panel clicked, id: " + paramObject);
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
            do
            {
              return;
              i1 = ((Integer)paramObject).intValue();
              if (QLog.isColorLevel()) {
                QLog.d("XPanel", 2, "onPanelIconClick panelID=" + i1 + "currentID=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("fastimage", 2, "onPanelIconClick  removeFastImage");
                }
                a(true);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
                this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.g();
              }
              if (i1 == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a())
              {
                this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
                return;
              }
              switch (i1)
              {
              case 7: 
              case 11: 
              case 12: 
              case 13: 
              case 15: 
              case 16: 
              case 17: 
              case 18: 
              case 20: 
              case 25: 
              case 27: 
              case 28: 
              case 29: 
              case 30: 
              default: 
                return;
              case 2: 
                this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(2);
                AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAC", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                return;
              case 21: 
                as();
                return;
              }
            } while (this.jdField_e_of_type_Int == 1);
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(24);
            return;
          } while (this.jdField_e_of_type_Int == 1);
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
          if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
            this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
          }
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005CAD", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), "ep_mall", "0X8005795", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
          return;
          Y();
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(8);
          k(0);
          AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004078", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
          paramObject = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(76);
        } while (paramObject == null);
        paramObject = (PokeResHandler)paramObject.a("qq.android.poke.res_1228");
      } while ((paramObject == null) || (paramObject.h()));
      paramObject.a(false);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(4);
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8004079", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(10);
      return;
      o(true);
      h(false);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      }
      i2 = 0;
      i1 = i2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 9501) {}
      try
      {
        paramObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString));
        i1 = i2;
        if (paramObject != null) {
          i1 = paramObject.productId;
        }
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          Intent localIntent;
          TroopLinkManager localTroopLinkManager;
          Object localObject;
          i1 = i2;
        }
      }
      PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1);
      paramObject = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (paramObject.a(0)) {
        paramObject.b();
      }
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X800407A", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(14);
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005977", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
    } while (!(this instanceof HotChatPie));
    ((HotChatPie)this).k(true);
    if ((((HotChatPie)this).a != null) && (((HotChatPie)this).a.isBuLuoHotChat())) {}
    for (paramObject = "507";; paramObject = "503")
    {
      NearbyFlowerManager.a("gift_aio", "clk_icon", ((HotChatPie)this).c(), paramObject, "", "");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(23, false);
    PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    at();
    a().reportClickEvent("CliOper", "0X8007F20");
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setShowRed(26, false);
    PokeItemHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    i1 = PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, i1, "", "");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X8007F23", "0X8007F23", i1, 0, "", "", "", "");
    return;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(22);
    return;
    localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("finish_animation_up_down", true);
    localTroopLinkManager = TroopLinkManager.a();
    localObject = localTroopLinkManager.a("troop_homework_create_notice");
    paramObject = localObject;
    if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
      paramObject = "https://web.qun.qq.com/mannounce/schooledit.html?_bid=148&_wv=1031&from=<$FROM>&content=<$CONTENT>&gc=<$GC>";
    }
    localObject = new TroopLinkManager.LinkParams();
    ((TroopLinkManager.LinkParams)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    ((TroopLinkManager.LinkParams)localObject).jdField_c_of_type_JavaLangString = "aio";
    ((TroopLinkManager.LinkParams)localObject).i = "";
    localIntent.putExtra("url", localTroopLinkManager.a(paramObject, (TroopLinkManager.LinkParams)localObject));
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(2131034380, 2131034131);
    TroopReportor.a("Grp_edu", "Grp_notice", "CreateNotice_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", "" });
    return;
    PublishHomeWorkFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    TroopReportor.a("Grp_edu", "homework", "AioAssign_Clk", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) });
  }
  
  public void a(String paramString)
  {
    a(2, paramString, this.jdField_c_of_type_Long);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new rox(this));
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    ThreadManager.postImmediately(new roy(this), null, false);
    if (!this.jdField_G_of_type_Boolean)
    {
      a(paramString, this.jdField_c_of_type_Long, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
      return;
    }
    ReceiptMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt1, paramInt2, paramRecorderParam, paramInt3, paramBoolean);
    a().runOnUiThread(new roz(this));
  }
  
  public void a(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0)
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
        StreamDataManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Long, paramInt, paramRecorderParam.jdField_c_of_type_Int, paramRecorderParam.jdField_d_of_type_Int, localBundle);
      }
      return;
    }
  }
  
  public void a(String paramString1, int paramInt, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
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
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B16", "0X8005B16", 0, 0, "", "", paramString2, "7.6.0");
      paramString1 = StatisticCollector.a(BaseApplication.getContext());
      paramRecorderParam = new HashMap();
      paramRecorderParam.put("param_FailCode", String.valueOf(0));
      paramRecorderParam.put("inputname", paramString2);
      paramRecorderParam.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString1.a("", "sendPttEventFromIME", false, 0L, 0L, paramRecorderParam, "");
    }
  }
  
  public void a(String paramString, long paramLong, int paramInt1, int paramInt2, QQRecorder.RecorderParam paramRecorderParam, int paramInt3, boolean paramBoolean)
  {
    if ((paramInt1 == 2) || (paramInt1 == 1))
    {
      i1 = 1;
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label130;
      }
    }
    long l2;
    int i2;
    String str1;
    Object localObject;
    label130:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "sendPttInner(),recordingUniseq is:" + paramLong + ",path is:" + paramString);
      }
      l2 = SystemClock.uptimeMillis();
      i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      str1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      if (i1 != 0) {
        break label381;
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
    long l1 = ((MessageRecord)localObject).uniseq;
    PttInfoCollector.a.put(paramString, Long.valueOf(l2));
    if (!bool)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      label180:
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "recordingUniseq is:" + l1);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!jdField_z_of_type_Boolean) {
        break label447;
      }
    }
    label447:
    for (int i1 = 1;; i1 = 2)
    {
      ReportController.b((QQAppInterface)localObject, "CliOper", "", "", "0X8005B57", "0X8005B57", i1, 0, "", "", "", "7.6.0");
      jdField_z_of_type_Boolean = true;
      i1 = a(paramInt1);
      localObject = new Bundle();
      ((Bundle)localObject).putInt("DiyTextId", paramRecorderParam.jdField_e_of_type_Int);
      ArrayList localArrayList = new ArrayList();
      String str2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), localArrayList);
      ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i2, str1, paramString, l1, false, paramInt2, paramRecorderParam.jdField_c_of_type_Int, bool, paramInt3, i1, paramBoolean, paramRecorderParam.jdField_d_of_type_Int, (Bundle)localObject, localArrayList, str2, false);
      b(paramInt1, paramInt2);
      a(0, paramString, l1);
      return;
      label381:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 0, paramLong);
      l1 = paramLong;
      if (localObject == null) {
        break;
      }
      l1 = paramLong;
      if (!MessageForPtt.class.isInstance(localObject)) {
        break;
      }
      ((MessageForPtt)localObject).voiceLength = QQRecorder.a(paramInt2);
      l1 = paramLong;
      break;
      PttBuffer.b(paramString);
      break label180;
    }
  }
  
  public void a(String paramString, ChatActivityFacade.SendMsgParams paramSendMsgParams, int paramInt)
  {
    paramString = a(paramString, paramInt);
    if ((paramString != null) && (paramString.length == 4))
    {
      paramSendMsgParams.jdField_d_of_type_Int = ((Integer)paramString[0]).intValue();
      paramSendMsgParams.jdField_b_of_type_Long = ((Long)paramString[1]).longValue();
      if ((paramString[2] != null) && (PasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
      {
        paramSendMsgParams.jdField_a_of_type_JavaLangString = ((String)paramString[2]);
        paramSendMsgParams.jdField_b_of_type_JavaLangString = ((String)paramString[3]);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124));
        paramSendMsgParams.jdField_d_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramSendMsgParams.jdField_a_of_type_JavaLangString, paramSendMsgParams.jdField_b_of_type_JavaLangString).booleanValue();
      }
      if (QLog.isColorLevel()) {
        QLog.d("msgFold", 2, String.format("Send, get RedBagId, friendUin: %s, senderUin: %d, redBagFlag: %d, foldFlag: %s, redBagId: %s, redBagIndex: %s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, Long.valueOf(paramSendMsgParams.jdField_b_of_type_Long), Integer.valueOf(paramSendMsgParams.jdField_d_of_type_Int), Boolean.valueOf(paramSendMsgParams.jdField_d_of_type_Boolean), paramSendMsgParams.jdField_a_of_type_JavaLangString, paramSendMsgParams.jdField_b_of_type_JavaLangString }));
      }
    }
  }
  
  public void a(String paramString, EmojiStickerManager.StickerInfo paramStickerInfo)
  {
    if (this.jdField_G_of_type_Boolean) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
      }
      if (!android.text.TextUtils.isEmpty(paramString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EmojiStickerManager", 2, " send, emojiText is empty");
    return;
    ArrayList localArrayList1;
    int i1;
    label300:
    boolean bool;
    if ((paramString.length() > 0) && (paramStickerInfo != null))
    {
      paramString = paramString + "sticker_start_tag_for_text" + paramStickerInfo.toJsonString() + "sticker_end_tag_for_text";
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
      PicPreDownloadUtils.a(paramString);
      if ((paramString != null) && (paramString.length() > 3478))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131433361, 1);
        return;
      }
      paramStickerInfo = new ChatActivityFacade.SendMsgParams();
      paramStickerInfo.jdField_b_of_type_Int = this.jdField_u_of_type_Int;
      paramStickerInfo.jdField_a_of_type_Int = this.jdField_s_of_type_Int;
      paramStickerInfo.jdField_c_of_type_Boolean = this.T;
      paramStickerInfo.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
      paramStickerInfo.jdField_a_of_type_Long = System.currentTimeMillis();
      paramStickerInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
      paramStickerInfo.jdField_g_of_type_Boolean = this.jdField_F_of_type_Boolean;
      this.jdField_F_of_type_Boolean = false;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label659;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
      }
      localArrayList1 = new ArrayList();
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel == null) {
        break label637;
      }
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
      if ((android.text.TextUtils.isEmpty(paramString)) || (i1 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
        break label648;
      }
      ArrayList localArrayList2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
      MixedMsgManager localMixedMsgManager = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_f_of_type_Int != 2) {
        break label642;
      }
      bool = true;
      label383:
      localMixedMsgManager.a(localQQAppInterface, str, i1, localArrayList2, bool, paramString, localArrayList1, paramStickerInfo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().removeExtra("PhotoConst.SELECTED_PATHS");
    }
    for (;;)
    {
      a(paramString, false, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.e();
      return;
      label637:
      i1 = 0;
      break label300;
      label642:
      bool = false;
      break label383;
      label648:
      a(paramString, paramStickerInfo, localArrayList1);
      continue;
      label659:
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
      }
      new ArrayList();
      a(paramString, paramStickerInfo, null);
      if (QLog.isColorLevel()) {
        QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
      }
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    i(0);
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
    this.jdField_a_of_type_MqqOsMqqHandler.post(new rmw(this, paramString1, paramString3, paramString2));
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
    localSendMsgParams.jdField_b_of_type_Int = this.jdField_u_of_type_Int;
    localSendMsgParams.jdField_a_of_type_Int = this.jdField_s_of_type_Int;
    localSendMsgParams.jdField_c_of_type_Boolean = this.T;
    localSendMsgParams.jdField_c_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
    localSendMsgParams.jdField_a_of_type_Long = System.currentTimeMillis();
    localSendMsgParams.jdField_e_of_type_Int = paramInt;
    a(paramString, localSendMsgParams, paramArrayList);
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
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
        this.jdField_c_of_type_Long = 0L;
        h(2131230744);
        a(true, false);
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
      if (this.jdField_G_of_type_Boolean)
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
        this.jdField_c_of_type_Long = paramString.uniseq;
        paramRecorderParam.jdField_d_of_type_Int = paramString.vipSubBubbleId;
        paramRecorderParam.jdField_e_of_type_Int = paramString.vipBubbleDiyTextId;
        h(2131230732);
        break;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, QQRecorder.RecorderParam paramRecorderParam)
  {
    a(paramString, this.jdField_c_of_type_Long, paramBoolean2, paramRecorderParam);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new roq(this, paramBoolean1));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (paramRecorderParam.jdField_a_of_type_JavaLangObject == null) {}
    for (paramInt2 = 1; paramInt2 == 0; paramInt2 = 0)
    {
      StreamDataManager.a(paramString, paramArrayOfByte, paramInt1, (short)0);
      return;
    }
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
  }
  
  public void a(List paramList)
  {
    int i1 = paramList.size();
    int i2 = -1;
    int[] arrayOfInt = new int[i1];
    boolean[] arrayOfBoolean = new boolean[i1];
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup != null) {
      bi();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, false);
    i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    Object localObject1 = paramList.iterator();
    int i4 = 0;
    Object localObject2;
    int i3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ChatMessage)((Iterator)localObject1).next();
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject2);
      i3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)localObject2) + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.delmsg", 2, "pos is:" + i3);
      }
      if (i3 >= 0)
      {
        i3 -= i1;
        if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i3) != null)
        {
          arrayOfInt[i4] = i3;
          if (((ChatMessage)localObject2).isSend()) {
            arrayOfBoolean[i4] = true;
          }
          i4 += 1;
          localArrayList.add(localObject2);
          ((Iterator)localObject1).remove();
        }
      }
    }
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[i4];
    this.jdField_a_of_type_ArrayOfAndroidViewViewGroup = new ViewGroup[i4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[i4];
    this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet = new AnimationSet[i4];
    this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout = new FrameLayout[i4];
    i1 = 0;
    while (i1 < i4)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[i1] = new View(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1] = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i1] = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i1] = new AnimationSet(true);
      this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1] = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
      i1 += 1;
    }
    int i5 = 0;
    i1 = i2;
    while (i5 < i4)
    {
      this.jdField_a_of_type_ArrayOfAndroidViewView[i5] = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(arrayOfInt[i5]);
      localObject1 = null;
      label615:
      LinearInterpolator localLinearInterpolator;
      try
      {
        localObject2 = Bitmap.createBitmap(this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getWidth(), this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getHeight(), Bitmap.Config.ARGB_8888);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          localObject3 = new Canvas((Bitmap)localObject2);
          localObject1 = localObject2;
          this.jdField_a_of_type_ArrayOfAndroidViewView[i5].draw((Canvas)localObject3);
        }
        localObject1 = localObject2;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          int i6;
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "multi delete animation draw canvas oom", localOutOfMemoryError);
          }
          continue;
          i3 += 1;
        }
        Object localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((RelativeLayout.LayoutParams)localObject3).addRule(6, 2131363489);
        ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131363489);
        ((RelativeLayout.LayoutParams)localObject3).addRule(5, 2131363489);
        ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131363489);
        localOutOfMemoryError.addView(this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i5], i2 + 1, (ViewGroup.LayoutParams)localObject3);
        this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i5].setOnTouchListener(new rqs(this));
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i5].setImageBitmap((Bitmap)localObject1);
        this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i5] = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject1 = new FrameLayout.LayoutParams(this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getWidth(), this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getHeight());
        ((FrameLayout.LayoutParams)localObject1).gravity = 51;
        this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i5].addView(this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i5], (ViewGroup.LayoutParams)localObject1);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i5].setVisibility(4);
        this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i5].addView(this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i5], new FrameLayout.LayoutParams(-1, -1));
        ((FrameLayout.LayoutParams)localObject1).leftMargin = this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getLeft();
        ((FrameLayout.LayoutParams)localObject1).topMargin = this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getTop();
        ((FrameLayout.LayoutParams)localObject1).rightMargin = 0;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = 0;
        localLinearInterpolator = new LinearInterpolator();
        this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i5] = new AnimationSet(true);
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(600L);
        ((AlphaAnimation)localObject1).setInterpolator(localLinearInterpolator);
        this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i5].addAnimation((Animation)localObject1);
        if (arrayOfBoolean[i5] == 0) {
          break label1002;
        }
      }
      i3 = i1;
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363474);
        i6 = ((ViewGroup)localObject2).getChildCount();
        i2 = i1;
        if (i1 == -1)
        {
          i3 = 0;
          i2 = i1;
          if (i3 < i6)
          {
            if (((ViewGroup)localObject2).getChildAt(i3) != this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView) {
              break label615;
            }
            i2 = i3;
          }
        }
        if (i2 == -1)
        {
          i3 = i2;
          if (!QLog.isColorLevel()) {
            break label996;
          }
          QLog.d("Q.msg.delmsg", 2, "listViewIndex is:" + i2 + ",can not find listView");
          i1 = i2;
          i5 += 1;
        }
      }
      label996:
      label1002:
      for (localObject1 = new TranslateAnimation(0.0F, this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getRight(), 0.0F, 0.0F);; localObject1 = new TranslateAnimation(0.0F, -this.jdField_a_of_type_ArrayOfAndroidViewView[i5].getRight(), 0.0F, 0.0F))
      {
        ((TranslateAnimation)localObject1).setDuration(600L);
        ((TranslateAnimation)localObject1).setInterpolator(localLinearInterpolator);
        this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i5].addAnimation((Animation)localObject1);
        i3 = i2;
        i1 = i3;
        break;
      }
    }
    i1 = 0;
    while (i1 < i4)
    {
      if ((this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i1] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i1] != null)) {
        this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[i1].startAnimation(this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet[i1]);
      }
      i1 += 1;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rqt(this), 600L);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rqu(this, localArrayList), 400L);
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rqv(this, paramList), 800L);
  }
  
  public void a(List paramList, int paramInt)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131432992, 0).b(a());
    }
    do
    {
      return;
      MultiMsgManager.a().b(paramList);
      if (QLog.isDevelopLevel()) {
        QLog.d("MultiMsg", 4, "multiForwardTogether|checklist.size = " + paramList.size());
      }
    } while (paramList.size() == 0);
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    }
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131433405);
    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = MsgProxyUtils.c((ChatMessage)localIterator.next());
      if (!localArrayList.contains(str)) {
        localArrayList.add(str);
      }
    }
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.clear();
    MultiMsgManager.a().jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    MultiMsgManager.a().jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
    {
      ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, localArrayList, false, null);
      paramList = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(24);
      paramList.arg1 = localArrayList.size();
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramList, 30000L);
      switch (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        paramList = "0X80078BB";
      }
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", paramList, paramList, 0, 0, "", "", "", "");
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1004)) {
        break;
      }
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(localArrayList);
      break;
      paramList = "0X80078BB";
      continue;
      paramList = "0X80078BC";
      continue;
      paramList = "0X80078BD";
    }
  }
  
  public void a(List paramList, CharSequence paramCharSequence)
  {
    a(paramList, paramCharSequence, 0);
  }
  
  public void a(List paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(paramList, paramCharSequence, paramInt);
  }
  
  public void a(Map paramMap, ArrayList paramArrayList, int paramInt)
  {
    boolean bool = true;
    if (paramInt == 4) {
      if (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet != null) {
        this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.b(paramMap, paramArrayList);
      }
    }
    do
    {
      return;
      if (paramInt != 3) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet == null);
    this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a(paramMap, paramArrayList);
    return;
    String str = " ";
    label78:
    Context localContext;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0)
    {
      str = ContactUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      localContext = this.jdField_a_of_type_AndroidContentContext;
      if (paramInt == 1) {
        break label182;
      }
    }
    for (;;)
    {
      paramMap = ChatActivityFacade.a(localContext, str, paramArrayList, paramMap, bool);
      if (paramMap == null) {
        break;
      }
      if (paramInt != 2) {
        break label188;
      }
      MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, paramMap, 0L, false, paramInt);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000)) {
        break label78;
      }
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
      break label78;
      label182:
      bool = false;
    }
    label188:
    paramMap.mMsg_A_ActionData = null;
    paramArrayList = new Intent();
    paramArrayList.putExtra("forward_type", -3);
    paramArrayList.putExtra("stuctmsg_bytes", paramMap.getBytes());
    paramArrayList.putExtra("is_need_show_sources", false);
    paramArrayList.putExtra("forward_msg_from_together", paramInt);
    ForwardBaseOption.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, paramArrayList, 21);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a(paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer == null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer = new AIOGiftPanelContainer(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel);
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a(paramBoolean, paramInt);
  }
  
  public void a(boolean paramBoolean1, ChatMessage paramChatMessage, boolean paramBoolean2)
  {
    if (BaseChatItemLayout.jdField_a_of_type_Boolean == paramBoolean1) {
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.BaseChatPie", 4, "setLeftCheckBoxVisible visible is not change so no need change");
      }
    }
    label519:
    label708:
    for (;;)
    {
      return;
      if (paramBoolean1)
      {
        BaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$OnChatMessageCheckedChangeListener = this;
        BaseChatItemLayout.jdField_a_of_type_Boolean = paramBoolean1;
        MultiMsgManager.a().a(paramChatMessage, paramBoolean1);
        a(paramChatMessage, paramBoolean1);
        if (paramBoolean1) {
          break label519;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846136);
        if (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          break label463;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433280);
        label84:
        if (!android.text.TextUtils.isEmpty(this.jdField_b_of_type_AndroidWidgetTextView.getText())) {
          break label484;
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        label106:
        MultiMsgManager.a().a();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
        if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_b_of_type_AndroidViewView != null) {
          this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        }
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          if ((!ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
            break label507;
          }
          if (!AIOTopRightButtonConfig.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
            break label495;
          }
          this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
        }
        label243:
        if (this.jdField_j_of_type_Boolean)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) && (!(this instanceof PublicAccountChatPie))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(PanelIconLinearLayout.jdField_b_of_type_Int);
          }
          if (this.jdField_j_of_type_AndroidViewView != null) {
            this.jdField_j_of_type_AndroidViewView.setVisibility(0);
          }
          if (this.jdField_k_of_type_AndroidViewView != null) {
            this.jdField_k_of_type_AndroidViewView.setVisibility(0);
          }
          this.jdField_j_of_type_Boolean = false;
        }
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363228).setVisibility(0);
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, this.jdField_f_of_type_Int);
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
        }
        if ((this.jdField_o_of_type_AndroidWidgetTextView != null) && (!android.text.TextUtils.isEmpty(this.jdField_o_of_type_AndroidWidgetTextView.getText().toString())) && (!"0".equals(this.jdField_o_of_type_AndroidWidgetTextView.getText().toString()))) {
          this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(0);
        }
        SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "select_more_msg", false);
      }
      for (;;)
      {
        if (paramBoolean2) {
          break label708;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.notifyDataSetChanged();
        return;
        BaseChatItemLayout.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout$OnChatMessageCheckedChangeListener = null;
        break;
        label463:
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_b_of_type_JavaLangString);
        this.jdField_b_of_type_JavaLangString = "";
        break label84;
        label484:
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        break label106;
        label495:
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break label243;
        label507:
        this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
        break label243;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        ai();
        if (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)
        {
          this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
          }
          if (this.jdField_j_of_type_AndroidViewView != null) {
            this.jdField_j_of_type_AndroidViewView.setVisibility(8);
          }
          if (this.jdField_k_of_type_AndroidViewView != null) {
            this.jdField_k_of_type_AndroidViewView.setVisibility(8);
          }
          this.jdField_j_of_type_Boolean = true;
        }
        paramChatMessage = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
        if ((paramChatMessage instanceof ViewGroup.MarginLayoutParams))
        {
          paramChatMessage = (ViewGroup.MarginLayoutParams)paramChatMessage;
          if (this.jdField_f_of_type_Int == 0) {
            this.jdField_f_of_type_Int = paramChatMessage.bottomMargin;
          }
          paramChatMessage.setMargins(paramChatMessage.leftMargin, paramChatMessage.rightMargin, paramChatMessage.rightMargin, this.jdField_f_of_type_Int + AIOUtils.a(50.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
          this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams(paramChatMessage);
        }
        if (this.jdField_o_of_type_AndroidWidgetTextView != null) {
          this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = 2;
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "instantUpdate: " + paramBoolean1 + " / " + paramBoolean2);
    }
    if (paramBoolean1) {
      if (!paramBoolean2) {}
    }
    for (i1 = 1;; i1 = 0)
    {
      b(i1 | 0x20000);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean4)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramBoolean1);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
        return;
      }
    }
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      }
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean3, paramBoolean1, paramBoolean4);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.b()) {
      if ((paramBoolean1) || (paramBoolean4)) {
        break label120;
      }
    }
    label120:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      d(paramBoolean2, paramBoolean3);
      this.jdField_k_of_type_Boolean = paramBoolean3;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramBoolean1);
      return;
    }
  }
  
  public boolean a()
  {
    aX();
    return this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(this);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt == 2)
    {
      bool1 = bool2;
      if (this.ab)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "recreate audio panel due to receipt message");
        }
        this.ab = false;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "listView onViewCompleteVisableAndReleased");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() > 0))
    {
      this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      ((ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject).a(this.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 21, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, 20, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext);
      return true;
    }
    f(false);
    return true;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {}
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
      while (i1 >= 0)
      {
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
        if ((paramMotionEvent != null) && ((AIOUtils.a(paramMotionEvent) instanceof ArkAppItemBuilder.Holder)))
        {
          paramMotionEvent = paramMotionEvent.findViewById(2131363294);
          Rect localRect = new Rect();
          paramMotionEvent.getGlobalVisibleRect(localRect);
          if (localRect.contains((int)f1, (int)f2)) {
            return false;
          }
        }
        i1 -= 1;
      }
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageRecord.frienduin)) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == paramMessageRecord.istroop) || ((MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)) && (MsgProxyUtils.c(paramMessageRecord.istroop)))) && (ConfessMsgUtil.a(paramMessageRecord.istroop, paramMessageRecord.getConfessTopicId(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int));
  }
  
  public boolean a(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewViewGroup == null)
    {
      QLog.e("Q.aio.BaseChatPie", 1, "mAIORootView == null");
      ChatFragment localChatFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getChatFragment();
      if (localChatFragment != null) {
        this.jdField_c_of_type_AndroidViewViewGroup = localChatFragment.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      }
      if (this.jdField_c_of_type_AndroidViewViewGroup == null) {
        QQCatchedExceptionReporter.reportQQCatchedException(new IllegalStateException("CreateAIOError: root view is null"), "CreateAIOCatchedException", null);
      }
    }
    this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
    R_();
    this.jdField_h_of_type_Int = 2;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnCreate", hashCode(), this.jdField_h_of_type_Int);
    c(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    StartupTracker.a("AIO_updateSession", "AIO_doOnCreate_otherCost");
    L();
    BaseActivity.sActivityRoute.add(getClass().getSimpleName());
    ae();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setHandler(ChatActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    StartupTracker.a("AIO_doOnCreate_otherCost", "AIO_doOnCreate_handleRequest");
    if (paramBoolean) {
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), 1);
    }
    for (;;)
    {
      StartupTracker.a("AIO_doOnCreate_handleRequest", null);
      return true;
      a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent(), 2);
    }
  }
  
  public Object[] a(String paramString, int paramInt)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    Object[] arrayOfObject;
    do
    {
      return null;
      if (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124));
        if ((!android.text.TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (paramString.equals(this.jdField_d_of_type_JavaLangString))) {}
        for (arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_c_of_type_JavaLangString, paramInt); (arrayOfObject != null) && (((Integer)arrayOfObject[0]).intValue() == 1); arrayOfObject = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramString, paramInt))
        {
          this.jdField_c_of_type_JavaLangString = "";
          this.jdField_d_of_type_JavaLangString = "";
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(12);
          if (!QLog.isColorLevel()) {
            break;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString.charAt(0));
          localStringBuilder.append("|");
          localStringBuilder.append(paramString.length());
          QLog.d("PasswdRedBagManager", 2, "passwdredbags result[0]=" + arrayOfObject[0] + ",result[1]=" + arrayOfObject[1] + ",send str=" + localStringBuilder.toString());
          return arrayOfObject;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("PasswdRedBagManager", 2, "current is in Anonymous, dont search passwdredbags");
    return null;
    return arrayOfObject;
  }
  
  public void aA() {}
  
  public void aB() {}
  
  public void aC()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.c();
    }
  }
  
  protected void aD()
  {
    if (this.jdField_k_of_type_AndroidViewView == null)
    {
      this.jdField_k_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(10.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(2, 2131363476);
      this.jdField_k_of_type_AndroidViewView.setId(2131362059);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_k_of_type_AndroidViewView, this.jdField_c_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    this.jdField_k_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_b_of_type_Boolean) {
      AccessibilityUtil.a(this.jdField_k_of_type_AndroidViewView, false);
    }
  }
  
  protected void aE()
  {
    if (this.jdField_j_of_type_AndroidViewView == null)
    {
      this.jdField_j_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-1, (int)(15.0F * this.jdField_a_of_type_Float + 0.5F));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(3, 2131363476);
      this.jdField_j_of_type_AndroidViewView.setId(2131362058);
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_j_of_type_AndroidViewView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      }
    }
    this.jdField_j_of_type_AndroidViewView.setVisibility(0);
    this.jdField_j_of_type_AndroidViewView.setOnClickListener(this);
    if (AppSetting.jdField_b_of_type_Boolean) {
      AccessibilityUtil.a(this.jdField_j_of_type_AndroidViewView, false);
    }
  }
  
  public void aF() {}
  
  public void aG()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(true);
    }
  }
  
  public void aH()
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
    }
  }
  
  public void aI()
  {
    if ((this.jdField_a_of_type_AndroidOsPowerManager$WakeLock != null) && (this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.isHeld()))
    {
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock.release();
      this.jdField_a_of_type_AndroidOsPowerManager$WakeLock = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "cancelRemainScreenOn");
    }
  }
  
  public void aJ()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a();
  }
  
  public void aK()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void aL()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131362132, null);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
    }
  }
  
  public void aM()
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
      if (this.jdField_h_of_type_AndroidViewView == null)
      {
        this.jdField_h_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_h_of_type_AndroidViewView.setId(2131362321);
        localObject = new AbsListView.LayoutParams(-1, 80);
        this.jdField_h_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      if (this.jdField_h_of_type_AndroidViewView.getParent() == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addFooterView(this.jdField_h_of_type_AndroidViewView, null, false);
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
        b(196608);
      }
      return;
    }
  }
  
  public void aN()
  {
    int i1 = 0;
    int i2;
    View localView;
    if ((this.jdField_h_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)) {
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
      if (this.jdField_h_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.removeFooterView(this.jdField_h_of_type_AndroidViewView);
      }
      this.jdField_h_of_type_AndroidViewView = null;
      b(196608);
      return;
      label88:
      i1 = localView.getTop();
    }
  }
  
  public void aO() {}
  
  public void aP()
  {
    String str1;
    if ((!this.jdField_G_of_type_Boolean) && (ReceiptUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) <= 0))
    {
      str1 = a().getString(2131438974);
      QQToast.a(a(), str1, 0).b(a().getResources().getDimensionPixelSize(2131558448));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0x80083EC", "0x80083EC", 0, 0, "", "", "", "");
      return;
    }
    boolean bool;
    label100:
    int i1;
    if (!this.jdField_G_of_type_Boolean)
    {
      bool = true;
      this.jdField_G_of_type_Boolean = bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
        a(true);
      }
      if (!this.jdField_G_of_type_Boolean) {
        break label555;
      }
      if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0)) {
        aU();
      }
      aO();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(true);
      x(0);
      i1 = ReceiptUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      str1 = String.valueOf(i1);
      if (i1 >= 4) {
        break label519;
      }
      String str2 = String.format(a().getString(2131438947), new Object[] { str1 });
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new ForegroundColorSpan(BaseApplicationImpl.getContext().getResources().getColor(2131494291)), str2.length() - str1.length() - 2, str2.length() - 2, 18);
      this.jdField_p_of_type_AndroidWidgetTextView.setText(localSpannableString);
      label286:
      i1 = BaseApplicationImpl.getContext().getResources().getColor(2131494292);
      this.jdField_p_of_type_AndroidWidgetTextView.setTextColor(i1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131362132, null);
      SpriteCommFunc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "receipt_msg", true);
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.i();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {
        break label532;
      }
      i1 = 1;
      label366:
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0x80083E8", "0x80083E8", i1, 0, "", "", "", "");
    }
    for (;;)
    {
      s(this.jdField_G_of_type_Boolean);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_b_of_type_Boolean = this.jdField_G_of_type_Boolean;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_e_of_type_Boolean = this.jdField_G_of_type_Boolean;
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_c_of_type_Boolean = this.jdField_G_of_type_Boolean;
        if (!this.jdField_G_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_d_of_type_Boolean = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentContext, a(), this.jdField_e_of_type_JavaLangString, this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {
        break;
      }
      this.ab = true;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = null;
      return;
      bool = false;
      break label100;
      label519:
      this.jdField_p_of_type_AndroidWidgetTextView.setText(2131438946);
      break label286;
      label532:
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)
      {
        i1 = 2;
        break label366;
      }
      i1 = 3;
      break label366;
      label555:
      ay();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
      x(8);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new rmq(this));
    }
  }
  
  public void aQ()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
      d(false, false);
    }
  }
  
  public void aR()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(18);
  }
  
  public void aS()
  {
    if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(4);
    }
  }
  
  public void aT()
  {
    if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter.d();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
    }
  }
  
  public void aU()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_e_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837620);
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
      this.K = false;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), 0, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
    }
  }
  
  public void aV()
  {
    int i2;
    if (this.jdField_e_of_type_AndroidViewView != null)
    {
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 0)
      {
        this.jdField_e_of_type_AndroidViewView.setVisibility(0);
        this.K = false;
      }
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837620);
      i2 = this.jdField_e_of_type_AndroidViewView.getWidth();
      if (i2 != 0) {
        break label166;
      }
    }
    label166:
    for (int i1 = AIOUtils.a(32.0F, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources());; i1 = i2)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ZhituManager", 4, "showZhituIcon.rightPadding." + i1 + " ,pr = " + i2 + ",input.getPaddingRight() = " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight());
      }
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight() < i1) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop(), i1, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom());
      }
      return;
    }
  }
  
  public void aW()
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.K))
    {
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837620);
      this.jdField_a_of_type_AndroidWidgetImageButton.setActivated(false);
      this.K = false;
    }
  }
  
  @TargetApi(11)
  protected void aa()
  {
    if (this.jdField_e_of_type_Int == 1) {
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
            if (this.jdField_e_of_type_Int != 2) {
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
  
  protected void ab()
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
        break label168;
      }
      HotChatManager localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
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
          if (PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0) != 0)
          {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i1);
          return;
        }
        if (i1 == 18)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(8);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setSelected(i1);
        return;
        label168:
        i1 = 0;
      }
    }
  }
  
  public void ac()
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "hideSoftInput");
        }
      }
    }
  }
  
  public void ad()
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getString(2131434485);
    DialogUtil.b(this.jdField_a_of_type_AndroidContentContext, 230, null, str, 2131436063, 2131436064, new rpq(this), new rpr(this)).show();
  }
  
  public void ae()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
  }
  
  public void af()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_a_of_type_ComTencentAvGaudioAVObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppEmoticonObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqVasVasExtensionObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldConfigObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppShortVideoObserver);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    LoveLanguageManager localLoveLanguageManager = (LoveLanguageManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(273);
    if (!localLoveLanguageManager.c()) {
      return;
    }
    if (paramEditable.toString().equals(this.jdField_d_of_type_JavaLangString)) {
      aj();
    }
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "input stat is " + this.jdField_e_of_type_Int);
    }
    boolean bool;
    label138:
    label227:
    label250:
    int i1;
    if (this.jdField_e_of_type_Int == 0)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel.b())) {
        this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel.d();
      }
      if (this.jdField_e_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
        if (paramEditable.length() <= 0) {
          break label1009;
        }
        bool = true;
        ((PatchedButton)localObject).setEnabled(bool);
      }
      if ((this.jdField_d_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_d_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
      {
        this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(67);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter.d();
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentWidgetPatchedButton;
      if (paramEditable.length() <= 0) {
        break label1015;
      }
      bool = true;
      ((PatchedButton)localObject).setEnabled(bool);
      if (paramEditable.toString().trim().length() <= 0) {
        break label1021;
      }
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "check valid input condition: " + bool + " / " + this.jdField_G_of_type_Boolean + " / " + GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo) + " / " + ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int));
      }
      if ((!bool) || (this.jdField_G_of_type_Boolean) || (GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) || (!ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int))) {
        break label1027;
      }
      bool = true;
      label370:
      if (QLog.isColorLevel()) {
        QLog.d("ZhituManager", 2, "afterTextChange,isValidInput = " + bool);
      }
      if (!bool)
      {
        aW();
        aU();
      }
      if (bool)
      {
        localObject = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (!((ZhituManager)localObject).c()) {
          break label1047;
        }
        if (this.jdField_e_of_type_AndroidViewView.getVisibility() != 0) {
          break label1040;
        }
        if ((paramEditable.length() <= 24) && (((ZhituManager)localObject).a(paramEditable))) {
          break label1033;
        }
        this.jdField_a_of_type_AndroidWidgetImageButton.setSelected(false);
        this.K = false;
        aV();
        ((ZhituManager)localObject).c();
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837620);
      }
      label501:
      b(paramEditable.toString());
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "check zhitu condition: " + paramEditable.length() + " / " + this.jdField_G_of_type_Boolean + " / " + this.K);
      }
      if ((paramEditable.length() > 0) && (!this.jdField_G_of_type_Boolean) && (!this.K))
      {
        a(paramEditable);
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.g();
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.b(paramEditable);
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) && (this.jdField_h_of_type_Int != 2) && (!this.jdField_o_of_type_Boolean) && (!this.jdField_G_of_type_Boolean) && (!this.K)) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a(paramEditable);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
        break label1112;
      }
      localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      if ((localObject == null) || (!((HotChatManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label1059;
      }
      i1 = 1;
    }
    for (;;)
    {
      label714:
      if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000)) && (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_G_of_type_Boolean) && (i1 == 0) && (localLoveLanguageManager.a()) && (localLoveLanguageManager.a(paramEditable.toString()))) {
        localLoveLanguageManager.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      }
      if (QLog.isColorLevel()) {
        QLog.d("afterTextChanged", 2, " afterTextChanged cost: " + (System.currentTimeMillis() - l1));
      }
      if (this.T)
      {
        if ((this.U) || (paramEditable.length() <= 0)) {
          break label1064;
        }
        this.jdField_w_of_type_Int = NetworkUtil.a(BaseApplication.getContext());
        if ((this.jdField_w_of_type_Int == 2) || (this.jdField_w_of_type_Int == 3))
        {
          this.U = true;
          this.jdField_s_of_type_Int = 1;
          if (this.jdField_c_of_type_JavaLangRunnable == null) {
            bh();
          }
          ThreadManager.getSubThreadHandler().post(this.jdField_c_of_type_JavaLangRunnable);
        }
      }
      for (;;)
      {
        ag();
        if ((this.jdField_G_of_type_Boolean) || (paramEditable.length() <= 0) || (!this.K)) {
          break;
        }
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(85);
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramEditable, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(), b(), true);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(85, 10000L);
        return;
        label1009:
        bool = false;
        break label138;
        label1015:
        bool = false;
        break label227;
        label1021:
        bool = false;
        break label250;
        label1027:
        bool = false;
        break label370;
        label1033:
        aV();
        break label501;
        label1040:
        aV();
        break label501;
        label1047:
        this.jdField_e_of_type_AndroidViewView.setVisibility(8);
        break label501;
        label1059:
        i1 = 0;
        break label714;
        label1064:
        if (paramEditable.length() == 0)
        {
          ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          this.U = false;
          this.jdField_s_of_type_Int = 40;
          this.jdField_u_of_type_Int = 0;
          this.jdField_t_of_type_Int = 0;
          this.jdField_w_of_type_Int = 0;
        }
      }
      label1112:
      i1 = 0;
    }
  }
  
  public void ag()
  {
    Object localObject1 = (FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
    if ((((FlashChatManager)localObject1).a()) && (b() != 1008) && (b() != 7200) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {}
    ImageView localImageView;
    for (boolean bool = true;; bool = false)
    {
      this.L = bool;
      if (!this.L) {
        break label216;
      }
      this.jdField_n_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363484);
      this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_n_of_type_AndroidViewView.setVisibility(0);
      this.jdField_n_of_type_AndroidViewView.setContentDescription("文本特效 按钮");
      localImageView = (ImageView)this.jdField_n_of_type_AndroidViewView.findViewById(2131363485);
      localObject2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((localObject2 == null) || (((String)localObject2).length() <= 20)) {
        break;
      }
      localImageView.setImageResource(2130842435);
      return;
    }
    localObject1 = ((FlashChatManager)localObject1).a("1");
    Object localObject2 = (HiBoomManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(218);
    if ((localObject1 == null) && (!((HiBoomManager)localObject2).a()))
    {
      localImageView.setImageResource(2130842437);
      return;
    }
    localImageView.setImageResource(2130842433);
    return;
    label216:
    this.jdField_n_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363484);
    this.jdField_n_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_n_of_type_AndroidViewView.setVisibility(8);
  }
  
  protected void ah()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "cancelDelAnim() is called,time is:" + System.currentTimeMillis());
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(15);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16);
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.clearDelAnim();
    }
    if (this.jdField_f_of_type_AndroidViewView != null) {
      this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null)) {
      ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_b_of_type_AndroidViewViewGroup);
    }
    this.jdField_f_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
  }
  
  public void ai()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void aj()
  {
    this.jdField_j_of_type_AndroidWidgetTextView.setText("");
    this.jdField_k_of_type_AndroidWidgetTextView.setText("");
    this.jdField_o_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void ak()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendMsgBtn", 2, " send start: currenttime:" + System.currentTimeMillis());
    }
    al();
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.e();
    }
  }
  
  public void al()
  {
    
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0) {
      if (!LoveLanguageConfig.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
        break label1862;
      }
    }
    label555:
    label1074:
    label1079:
    label1085:
    label1856:
    label1862:
    for (int i1 = ((LoveLanguageManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(273)).a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);; i1 = 0)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      LogcatUtil.a((String)localObject2);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131362132) == null) {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
      }
      Object localObject1 = null;
      Object localObject3;
      int i2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq, 0L);
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label1856;
        }
        i2 = 0;
        if (i2 >= ((List)localObject3).size()) {
          break label1856;
        }
        localObject1 = (MessageRecord)((List)localObject3).get(i2);
        if ((MsgProxyUtils.a((MessageRecord)localObject1)) || ((localObject1 instanceof MessageForSafeGrayTips))) {}
      }
      for (;;)
      {
        if (((localObject1 instanceof MessageForTroopTopic)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 100))
        {
          QQToast.a(a(), 2131430722, 0).b(a().getTitleBarHeight());
          return;
          i2 += 1;
          break;
        }
        if ((localObject1 instanceof MessageForReplyText)) {
          if ((((MessageForReplyText)localObject1).mGroupPostElemInfo != null) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 100))
          {
            QQToast.a(a(), 2131430722, 0).b(a().getTitleBarHeight());
            return;
          }
        }
        for (;;)
        {
          PicPreDownloadUtils.a((String)localObject2);
          if ((localObject2 != null) && (((String)localObject2).length() > jdField_E_of_type_Int))
          {
            ChatActivityUtils.a(this.jdField_a_of_type_AndroidContentContext, 2131433361, 1);
            return;
            if (((localObject1 instanceof MessageForStructing)) && (StructingMsgItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localObject1)) && (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 100)) {
              QQToast.a(a(), 2131430722, 0).b(a().getTitleBarHeight());
            }
          }
          else
          {
            ChatActivityFacade.SendMsgParams localSendMsgParams = new ChatActivityFacade.SendMsgParams();
            a(localSendMsgParams);
            localSendMsgParams.jdField_g_of_type_Boolean = this.jdField_F_of_type_Boolean;
            this.jdField_F_of_type_Boolean = false;
            a((String)localObject2, localSendMsgParams, 0);
            if (i1 > 0) {
              localSendMsgParams.jdField_i_of_type_Boolean = true;
            }
            boolean bool1;
            Object localObject4;
            Object localObject5;
            Object localObject6;
            boolean bool2;
            if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000))
            {
              if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " send curType == VALUE.UIN_TYPE_TROOP or disc start sendMessage currenttime:" + System.currentTimeMillis());
              }
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName)))
              {
                if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString) == null) {
                  break label1074;
                }
                bool1 = true;
                localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
                localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                localObject5 = this.jdField_a_of_type_AndroidContentContext;
                localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                String str = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "";
                XEditTextEx localXEditTextEx = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) {
                  break label1079;
                }
                bool2 = true;
                localObject3 = AtTroopMemberSpan.a((QQAppInterface)localObject4, (Context)localObject5, (String)localObject6, str, (String)localObject3, bool1, localXEditTextEx, bool2);
                if ((localObject3 != null) && (((SpannableString)localObject3).length() != 0)) {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject3);
                }
                localObject4 = a();
                i1 = ((List)localObject4).size() - 1;
                label738:
                if (i1 < 0) {
                  break label1847;
                }
                localObject3 = (ChatMessage)((List)localObject4).get(i1);
                if (((ChatMessage)localObject3).shmsgseq != this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq) {
                  break label1085;
                }
              }
            }
            for (;;)
            {
              MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "suc_replyMsg", "reply_suc", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (ChatMessage)localObject3);
              if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) && (localObject1 != null) && (!AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (TroopTopicMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (MessageRecord)localObject1, localSendMsgParams)))
              {
                if (!QLog.isColorLevel()) {
                  break label1844;
                }
                QLog.d("zivonchen", 2, "TroopTopic commend end-----------------");
              }
              for (;;)
              {
                a((String)localObject2, false, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                aL();
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
                this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(1002, new Object[] { localObject2 });
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation != 2) {
                  break;
                }
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005C7C", "0X8005C7C", 0, 0, "", "", "", "");
                return;
                bool1 = false;
                break label555;
                bool2 = false;
                break label673;
                i1 -= 1;
                break label738;
                if (localSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo != null) {
                  localSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
                }
                localObject2 = new ArrayList();
                localObject1 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject2);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
                {
                  i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
                  label1147:
                  if ((android.text.TextUtils.isEmpty((CharSequence)localObject1)) || (i1 <= 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1) || (this.jdField_G_of_type_Boolean)) {
                    break label1289;
                  }
                  localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
                  localObject4 = (MixedMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(173);
                  localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  localObject6 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                  i1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_f_of_type_Int != 2) {
                    break label1284;
                  }
                  bool1 = true;
                  label1237:
                  ((MixedMsgManager)localObject4).a((QQAppInterface)localObject5, (String)localObject6, i1, (ArrayList)localObject3, bool1, (String)localObject1, (ArrayList)localObject2, localSendMsgParams.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo);
                  this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().removeExtra("PhotoConst.SELECTED_PATHS");
                }
                label1272:
                do
                {
                  localObject2 = localObject1;
                  break;
                  i1 = 0;
                  break label1147;
                  bool1 = false;
                  break label1237;
                  if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131362149) == null) {
                    break label1571;
                  }
                } while (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131362149) == null);
                localObject2 = (MessageForTroopGift)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(2131362149);
                localSendMsgParams.jdField_c_of_type_Long = ((MessageForTroopGift)localObject2).senderUin;
                localObject1 = SharedPreUtils.k(this.jdField_a_of_type_AndroidContentContext, "wantWord");
                if (!android.text.TextUtils.isEmpty((CharSequence)localObject1)) {}
                for (;;)
                {
                  this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText((CharSequence)localObject1);
                  localObject1 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((MessageForTroopGift)localObject2).senderUin + "");
                  localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                  localObject4 = this.jdField_a_of_type_AndroidContentContext;
                  localObject5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
                  localObject2 = ((MessageForTroopGift)localObject2).senderUin + "";
                  localObject6 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {}
                  for (bool1 = true;; bool1 = false)
                  {
                    localObject1 = AtTroopMemberSpan.a((QQAppInterface)localObject3, (Context)localObject4, (String)localObject5, (String)localObject2, (String)localObject1, false, (EditText)localObject6, bool1);
                    if ((localObject1 != null) && (((SpannableString)localObject1).length() != 0)) {
                      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText().insert(0, (CharSequence)localObject1);
                    }
                    localObject2 = new ArrayList();
                    localObject1 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject2);
                    a((String)localObject1, localSendMsgParams, (ArrayList)localObject2);
                    break;
                  }
                  a((String)localObject1, localSendMsgParams, (ArrayList)localObject2);
                  break label1272;
                  if (QLog.isColorLevel()) {
                    QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP start sendMessage currenttime:" + System.currentTimeMillis());
                  }
                  localObject1 = new ArrayList();
                  localObject2 = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
                  localObject1 = localObject2;
                  if (ArkRecommendController.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
                  {
                    localObject1 = localObject2;
                    if (((String)localObject2).startsWith("@babyQ"))
                    {
                      localObject1 = localObject2;
                      if (!ArkAiAppCenter.jdField_f_of_type_Boolean)
                      {
                        i1 = "@babyQ".length();
                        if (!((String)localObject2).equals("@babyQ" + ArkRecommendController.jdField_b_of_type_JavaLangString)) {
                          break label1778;
                        }
                        localObject1 = "@babyQ";
                      }
                    }
                  }
                  for (;;)
                  {
                    a((String)localObject1, localSendMsgParams, null);
                    localObject2 = localObject1;
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("SendMsgBtn", 2, " send sessionInfo.curType != VALUE.UIN_TYPE_TROOP end sendMessage currenttime:" + System.currentTimeMillis());
                    localObject2 = localObject1;
                    break;
                    label1778:
                    localObject1 = localObject2;
                    if (((String)localObject2).length() > i1)
                    {
                      localObject1 = localObject2;
                      if (((String)localObject2).charAt(i1) != ' ') {
                        localObject1 = "@babyQ " + ((String)localObject2).substring(i1);
                      }
                    }
                  }
                  localObject1 = "，土豪，我也要礼物~";
                }
              }
              localObject3 = null;
            }
          }
        }
        localObject1 = null;
      }
    }
  }
  
  public void am()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.shakemsg", 2, "startShakeAnim() is called,time is:" + System.currentTimeMillis());
    }
    an();
    rqz localrqz = new rqz(this, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (localInputMethodManager.isActive()) {
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(localrqz, 60L);
        return;
      }
      localrqz.run();
      return;
    }
  }
  
  public void an()
  {
    ((ViewGroup)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    if ((this.jdField_q_of_type_AndroidViewView != null) && (this.jdField_q_of_type_AndroidViewView.getParent() != null)) {
      ((ViewGroup)this.jdField_q_of_type_AndroidViewView.getParent()).removeView(this.jdField_q_of_type_AndroidViewView);
    }
    this.jdField_q_of_type_AndroidViewView = null;
  }
  
  public void ao() {}
  
  public void ap()
  {
    if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground != null) {
        if ((!"".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString)) && (!"null".equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString))) {
          break label364;
        }
      }
    }
    label217:
    label364:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : inNightMode, isDefaultBg=" + bool + ",mMask=" + this.jdField_l_of_type_AndroidViewView + ", sessionInfo.chatBg.path=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_JavaLangString);
      }
      if ((this.jdField_l_of_type_AndroidViewView != null) && (QLog.isColorLevel()))
      {
        if (this.jdField_l_of_type_AndroidViewView.getVisibility() == 0) {
          QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : mMask getVisibility = VISIBLE");
        }
      }
      else
      {
        if (bool) {
          break label309;
        }
        if ((this.jdField_l_of_type_AndroidViewView == null) || (this.jdField_l_of_type_AndroidViewView.getVisibility() != 0)) {
          break label217;
        }
      }
      do
      {
        do
        {
          return;
          if (this.jdField_l_of_type_AndroidViewView.getVisibility() == 4)
          {
            QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : mMask getVisibility = INVISIBLE");
            break;
          }
          QLog.d("Q.aio.BaseChatPie", 2, "#handleNightMask# : mMask getVisibility = GONE");
          break;
          if (this.jdField_l_of_type_AndroidViewView == null)
          {
            this.jdField_l_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
            this.jdField_l_of_type_AndroidViewView.setBackgroundColor(1996488704);
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
            localLayoutParams.addRule(6, 2131363489);
            localLayoutParams.addRule(2, this.jdField_b_of_type_AndroidWidgetLinearLayout.getId());
            this.jdField_l_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_l_of_type_AndroidViewView);
            return;
          }
          this.jdField_l_of_type_AndroidViewView.setVisibility(0);
          return;
        } while (this.jdField_l_of_type_AndroidViewView == null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_l_of_type_AndroidViewView);
        this.jdField_l_of_type_AndroidViewView = null;
        return;
      } while ((this.jdField_l_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_l_of_type_AndroidViewView);
      this.jdField_l_of_type_AndroidViewView = null;
      return;
    }
  }
  
  public void aq()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(10);
  }
  
  public void ar()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
    }
  }
  
  public void as()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(21);
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
      {
        ApolloManager localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if ((localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 0) || (localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) == 2)) {
          VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "panel_close_show", localApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), 0, new String[] { "" + ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
        {
          int i1 = this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b();
          if (i1 != -1) {
            VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "game_show", ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(i1) });
          }
        }
      }
    }
  }
  
  public void at()
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
      PokeItemHelper.b();
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
    this.jdField_a_of_type_JavaLangRunnable = new rly(this);
    ThreadManager.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
    ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
  }
  
  public void au()
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(30);
  }
  
  public void av()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_e_of_type_Boolean)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 3000) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1)) {
            break;
          }
          localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, false);
        } while ((localObject == null) || (!((NoC2CExtensionInfo)localObject).isDataChanged));
        ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
        return;
      } while (!x());
      localObject = ((FriendsManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, false);
    } while ((localObject == null) || (!((ExtensionInfo)localObject).isDataChanged));
    ThreadManager.getFileThreadHandler().post(new BaseChatPie.SaveInputTypeTask((Entity)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
  }
  
  public void aw()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) && (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null))
    {
      int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition();
      int i2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1 + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount() + this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
      if (QLog.isColorLevel()) {
        QLog.d("MyOnGestureListener", 2, "onOverScrollTargetValue isScrollToButtom=" + this.jdField_D_of_type_Boolean + "lastPosition=" + i1 + "toLast=" + i2);
      }
      if ((this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (i1 == i2) && (this.jdField_D_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004454", "0X8004454", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void ax()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "onEventComplite");
    }
    this.W = true;
  }
  
  public void ay()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1) {
      if (((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx)) {
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
      }
    }
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    } while ((localView == null) || (localView.getVisibility() != 0));
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "hideAllPanels  curPanel = " + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
    }
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void az()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQMapActivityProxy = new QQMapActivityProxy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  public View b()
  {
    return this.jdField_g_of_type_AndroidViewView;
  }
  
  public ImageView b()
  {
    return this.jdField_b_of_type_AndroidWidgetImageView;
  }
  
  public TextView b()
  {
    return this.jdField_b_of_type_AndroidWidgetTextView;
  }
  
  @Deprecated
  public String b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString;
  }
  
  public void b()
  {
    com.tencent.mobileqq.text.TextUtils.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
  }
  
  public void b(int paramInt)
  {
    a(paramInt, null, -1L);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramInt1, paramInt2);
  }
  
  public void b(int paramInt, View paramView, ListView paramListView) {}
  
  public void b(Intent paramIntent)
  {
    StartupTracker.a(null, "AIO_updateSession_updateTitle");
    String str = paramIntent.getStringExtra("uinname");
    paramIntent = str;
    if (str == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.aio.BaseChatPie", 2, "updateSession_updateTitle nick == null");
      }
      paramIntent = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateSession_updateTitle curFriendNick" + Utils.a(paramIntent));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = paramIntent;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString != null)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
      if (AppSetting.jdField_b_of_type_Boolean)
      {
        paramIntent = this.jdField_d_of_type_AndroidWidgetTextView.getText();
        this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        a().setTitle(this.jdField_d_of_type_AndroidWidgetTextView.getText());
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      StartupTracker.a("AIO_updateSession_updateTitle", null);
      return;
      QLog.e("Q.aio.BaseChatPie", 1, "updateSession_updateTitle sessionInfo.curFriendNick == null");
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {}
    Object localObject1;
    do
    {
      Object localObject2;
      do
      {
        do
        {
          do
          {
            return;
            PokeItemAnimationManager.a().a(paramView);
            localObject1 = AIOUtils.a(paramView);
            if (!StructingMsgItemBuilder.StructingMsgViewHolder.class.isInstance(localObject1)) {
              break;
            }
            localObject1 = (StructingMsgItemBuilder.StructingMsgViewHolder)localObject1;
          } while ((((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_AndroidWidgetRelativeLayout == null) || (!MessageForStructing.class.isInstance(((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage)));
          localObject2 = (MessageForStructing)((StructingMsgItemBuilder.StructingMsgViewHolder)localObject1).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
        } while ((((MessageForStructing)localObject2).structingMsg == null) || (!(((MessageForStructing)localObject2).structingMsg instanceof StructMsgForGeneralShare)) || ((!(this.jdField_a_of_type_AndroidContentContext instanceof ChatActivity)) && (!(this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity))));
        if (((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).mIsPAVideoStructMsg) {
          AIOVideoPlayController.a().a(paramView, (StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg);
        }
        localObject1 = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getChatFragment().a().a();
        localObject2 = ((StructMsgForGeneralShare)((MessageForStructing)localObject2).structingMsg).getLayoutStr();
      } while (localObject1 == null);
      ((StructingMsgItemBuilder.ViewCache)localObject1).a((String)localObject2, (ViewGroup)paramView.findViewById(2131361877));
      return;
      if (ShortVideoItemBuilder.Holder.class.isInstance(localObject1))
      {
        ((ShortVideoItemBuilder.Holder)localObject1).a(paramView);
        return;
      }
    } while (!ShortVideoRealItemBuilder.Holder.class.isInstance(localObject1));
    ((ShortVideoRealItemBuilder.Holder)localObject1).a(paramView);
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    AioAnimationDetector.a().a(paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
  }
  
  public void b(ChatMessage paramChatMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "start del anim,uniseq is:" + paramChatMessage.uniseq + ",id is:" + paramChatMessage.getId() + ",time is:" + System.currentTimeMillis());
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      ah();
    }
    long l1 = System.currentTimeMillis();
    ThreadManager.post(new rqn(this, paramChatMessage), 8, null, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.delmsg", 2, "removeMsgByMessageRecord cost time is:" + (l2 - l1));
    }
  }
  
  public void b(ChatMessage paramChatMessage, int paramInt)
  {
    if (paramChatMessage == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo();
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSeq = paramChatMessage.shmsgseq;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin = Long.parseLong(paramChatMessage.senderuin);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgTime = ((int)paramChatMessage.time);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceSummaryFlag = 1;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = paramInt;
    Object localObject = AnonymousChatHelper.a(paramChatMessage);
    if (!android.text.TextUtils.isEmpty(((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName = ((AnonymousChatHelper.AnonymousExtInfo)localObject).jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText = paramChatMessage.getSummaryMsg();
      paramInt = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
      int i1 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
      int i2 = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight();
      localObject = ReplyedMessageSpan.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, paramInt - i1 - i2, this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint(), this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (localObject == null) {
        break label336;
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, ((ReplyedMessageSpan)localObject).getDrawable(), null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131362132, localObject);
      this.jdField_a_of_type_AndroidTextMethodMovementMethod = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(ReplyClickMovementMethod.a());
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().length());
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rmn(this), 200L);
      MessageForReplyText.reportReplyMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "Msg_menu", "clk_replyMsg", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, paramChatMessage);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin != 50000000L) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin != 1000000L)) {
        break;
      }
      localObject = TroopBusinessUtil.a(paramChatMessage);
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mAnonymousNickName = ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_c_of_type_JavaLangString;
      break;
      label336:
      if (this.jdField_a_of_type_AndroidTextMethodMovementMethod != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(this.jdField_a_of_type_AndroidTextMethodMovementMethod);
      }
    }
  }
  
  public void b(EmoticonInfo paramEmoticonInfo) {}
  
  public void b(@Nullable String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) || (!PokeItemHelper.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (this.jdField_G_of_type_Boolean)) {}
    do
    {
      String str;
      do
      {
        return;
        str = paramString;
        if (paramString == null) {
          str = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        }
      } while ((!str.isEmpty()) || (StickerBubbleAnimationHelper.a() <= 0));
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageDrawable(StickerBubbleAnimationHelper.a(this.jdField_a_of_type_AndroidContentContext));
    } while (this.ac);
    ReportController.b(a(), "dc00898", "", "", "0X8009272", "0X8009272", StickerBubbleAnimationHelper.a(), 0, "", "", "", "");
    this.ac = true;
  }
  
  public void b(String paramString, int paramInt, QQRecorder.RecorderParam paramRecorderParam)
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
      a(paramString, this.jdField_c_of_type_Long, bool1, paramRecorderParam);
      w(paramInt);
      return;
    }
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    int i1 = 1;
    d(true);
    aI();
    i(0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "recorderEnd() is called");
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
    if (paramRecorderParam != null) {
      if (paramRecorderParam.jdField_a_of_type_JavaLangObject != null) {
        break label65;
      }
    }
    while (i1 == 0)
    {
      StreamDataManager.a(paramString, false);
      StreamDataManager.a(paramString);
      return;
      label65:
      i1 = 0;
    }
    PttBuffer.b(paramString);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_k_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFirstVisiblePosition();
    this.jdField_o_of_type_AndroidViewView.setVisibility(0);
    this.jdField_o_of_type_AndroidViewView.bringToFront();
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = paramString2;
    this.jdField_j_of_type_AndroidWidgetTextView.setText(a(paramString2));
    this.jdField_k_of_type_AndroidWidgetTextView.setText(paramString3);
    this.jdField_o_of_type_AndroidViewView.setOnClickListener(new rqw(this, paramString1, paramString2));
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() == 8))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(1, 16.0F);
    }
    while ((paramBoolean) || (this.jdField_e_of_type_AndroidWidgetTextView.getVisibility() != 0)) {
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextSize(2, 19.0F);
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (q())
    {
      if (!paramBoolean1) {
        break label41;
      }
      w();
    }
    for (;;)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramBoolean2, false, false);
      d(true, paramBoolean2);
      this.jdField_k_of_type_Boolean = paramBoolean2;
      return;
      label41:
      x();
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(int paramInt)
  {
    this.jdField_h_of_type_Int = 7;
    AIOUtils.a("Q.aio.BaseChatPie", "finish " + paramInt, hashCode(), this.jdField_h_of_type_Int);
    PlayLastLogic.b();
    DoodleResHelper.a().a();
    if (this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(59)) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(59);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.a(true, paramInt);
    }
    aj();
    this.Q = false;
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {
      a(false, null, false);
    }
    for (int i1 = 1;; i1 = 0)
    {
      if ((i1 != 0) && (paramInt == 0)) {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "basechatpie_finish 1,type:" + paramInt);
        }
      }
      int i2;
      do
      {
        do
        {
          return true;
          if (this.jdField_G_of_type_Boolean)
          {
            aP();
            i1 = 1;
          }
          if ((i1 == 0) || (paramInt != 0)) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.aio.BaseChatPie", 2, "basechatpie_finish 1.1,type:" + paramInt);
        return true;
        i2 = i1;
        if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null)
        {
          i2 = i1;
          if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.b()) {
            i2 = 1;
          }
        }
        if ((i2 == 0) || (paramInt != 0)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.aio.BaseChatPie", 2, "basechatpie_finish 2,type:" + paramInt);
      return true;
      if (paramInt == 1)
      {
        bl();
        label284:
        if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0) {
          if ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 2) || (paramInt != 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a())) {
            break label787;
          }
        }
      }
      label787:
      for (i1 = 1;; i1 = 0)
      {
        if (i1 == 0)
        {
          if (paramInt != 1) {
            break label442;
          }
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(false);
        }
        for (;;)
        {
          i2 = 1;
          i1 = i2;
          if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null)
          {
            i1 = i2;
            if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a())
            {
              this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a();
              i1 = 1;
            }
          }
          if ((i1 == 0) || (paramInt != 0)) {
            break label454;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.aio.BaseChatPie", 2, "basechatpie_finish 3,type:" + paramInt);
          return true;
          if ((paramInt != 0) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0)) {
            break label284;
          }
          bl();
          break label284;
          label442:
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(true);
        }
        label454:
        P();
        aZ();
        Object localObject2;
        Object localObject1;
        if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent() != null)
        {
          localObject2 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
          i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
          ReadinjoySPEventReport localReadinjoySPEventReport = ReadinjoySPEventReport.a();
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a();
            localReadinjoySPEventReport.a(0, (List)localObject1, (String)localObject2, i1);
          }
        }
        else
        {
          if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("key_req_by_contact_sync", false)) {
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.moveTaskToBack(true);
          }
          B();
          this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
          if (paramInt != 0) {
            break label755;
          }
          I();
        }
        for (;;)
        {
          try
          {
            localObject1 = this.jdField_a_of_type_AndroidWidgetTextView.getTag();
            localObject2 = (String[])localObject1;
            if ((localObject1 != null) && ("comic".equals(localObject2[0]))) {
              VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", localObject2[1], new String[] { "3" });
            }
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
            continue;
          }
          if ((this.jdField_w_of_type_Boolean) && (!this.jdField_y_of_type_Boolean) && (AIOUtils.jdField_m_of_type_Boolean))
          {
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
            this.jdField_y_of_type_Boolean = true;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
            this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
          }
          o(false);
          DuiButtonImageView.b();
          if ((this instanceof FriendChatPie)) {
            GoldMsgPayManager.a(this, a());
          }
          return false;
          localObject1 = null;
          break;
          label755:
          if (paramInt == 1) {
            if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity)) {
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
            } else {
              I();
            }
          }
        }
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public int c()
  {
    int i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "initHaveUnRead count " + i1);
    }
    return i1;
  }
  
  public ImageView c()
  {
    return this.jdField_d_of_type_AndroidWidgetImageView;
  }
  
  public TextView c()
  {
    return this.jdField_c_of_type_AndroidWidgetTextView;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
  }
  
  public void c()
  {
    l(6);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(3);
    d(false, false);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    aa();
    ab();
    if (QLog.isColorLevel()) {
      QLog.d("inputx", 2, "doPanelChanged newPanel=" + paramInt2);
    }
    if (((paramInt1 == 21) || (paramInt2 == 21)) && (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(paramInt1, paramInt2, this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel);
    }
    Object localObject;
    if ((SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
    {
      localObject = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramInt1 != 21) {
        break label617;
      }
      if (localObject != null)
      {
        ((SpriteActionScript)localObject).a(1);
        break label616;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO == null) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx == null)) {
          break label721;
        }
      }
    }
    label648:
    label659:
    label677:
    label683:
    label721:
    for (int i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getBottom() - this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getHeight() + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTop();; i1 = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i1);
      label218:
      label239:
      PhotoListPanel localPhotoListPanel;
      if (this.jdField_j_of_type_AndroidViewView != null)
      {
        if (paramInt2 >= 1) {
          this.jdField_j_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        if (this.jdField_k_of_type_AndroidViewView != null)
        {
          if (paramInt2 < 1) {
            break label648;
          }
          this.jdField_k_of_type_AndroidViewView.setVisibility(8);
        }
        if (!this.jdField_e_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("doPanelChanged", 2, "oldPanel=" + paramInt1 + " newPanel=" + paramInt2 + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length());
          }
          if (paramInt2 != 2) {
            break label659;
          }
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (paramInt1 != 2) && (AIOInputTypeHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(false);
          }
        }
        label345:
        if ((paramInt1 == 4) && (paramInt2 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(1019);
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
            this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.setMixedMsgMode(false);
          }
        }
        if ((paramInt2 == 4) && (paramInt1 != 4) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (!this.jdField_G_of_type_Boolean))
          {
            localObject = new ArrayList();
            localObject = AtTroopMemberSpan.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject);
            localPhotoListPanel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel;
            if (android.text.TextUtils.isEmpty((CharSequence)localObject)) {
              break label677;
            }
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localPhotoListPanel.setMixedMsgMode(bool);
        if ((paramInt2 == 14) && (paramInt1 != 14) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
          this.jdField_b_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a();
        }
        if ((paramInt1 == 2) && (paramInt2 != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
        }
        if ((paramInt1 != 2) && (paramInt2 == 2)) {
          this.jdField_i_of_type_Int = 0;
        }
        paramInt1 = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
        paramInt2 = this.jdField_a_of_type_JavaUtilList.size();
        if (paramInt1 == 0) {
          break label683;
        }
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        if ((paramInt1 == 5) || (paramInt1 == 6)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        }
        label616:
        return;
        label617:
        if ((paramInt2 != 21) || (localObject == null)) {
          break;
        }
        ((SpriteActionScript)localObject).a(2);
        break;
        this.jdField_j_of_type_AndroidViewView.setVisibility(0);
        break label218;
        this.jdField_k_of_type_AndroidViewView.setVisibility(0);
        break label239;
        if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() != 0) {
          break label345;
        }
        break label345;
      }
      if ((paramInt2 == 0) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips == null)) {
        break;
      }
      localObject = (QQOperationViopTipTask)this.jdField_a_of_type_JavaUtilList.get(paramInt2 - 1);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips.a((QQOperationViopTipTask)localObject);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
  
  public void c(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "updateSession");
    }
    this.ad = true;
    StartupTracker.a(null, "AIO_updateSession_initIntentData");
    k(paramIntent);
    StartupTracker.a("AIO_updateSession_initIntentData", "AIO_updateSession_updateUI");
    d(paramIntent);
    a(paramIntent);
    StartupTracker.a("AIO_updateSession_updateUI", "AIO_updateSession_forwardType");
    a(paramIntent, true);
    StartupTracker.a("AIO_updateSession_forwardType", "AIO_updateSession_otherThings");
    m(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this);
    StartupTracker.a("AIO_updateSession_otherThings", null);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime updateSession end");
    }
  }
  
  /* Error */
  public void c(ChatMessage paramChatMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 698	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   4: aload_1
    //   5: invokevirtual 708	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)I
    //   8: aload_0
    //   9: getfield 714	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   12: invokevirtual 722	com/tencent/mobileqq/bubble/ChatXListView:getHeaderViewsCount	()I
    //   15: iadd
    //   16: istore_2
    //   17: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: ldc_w 710
    //   26: iconst_2
    //   27: new 434	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 567	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 712
    //   37: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload_2
    //   41: invokevirtual 584	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 593	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 596	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: iload_2
    //   51: ifge +4 -> 55
    //   54: return
    //   55: aload_0
    //   56: getfield 714	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   59: invokevirtual 719	com/tencent/mobileqq/bubble/ChatXListView:getFirstVisiblePosition	()I
    //   62: istore_3
    //   63: iload_2
    //   64: iload_3
    //   65: isub
    //   66: istore 4
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 714	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   73: iload 4
    //   75: invokevirtual 729	com/tencent/mobileqq/bubble/ChatXListView:getChildAt	(I)Landroid/view/View;
    //   78: putfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   81: aload_0
    //   82: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   85: ifnonnull +65 -> 150
    //   88: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +51 -> 142
    //   94: ldc_w 710
    //   97: iconst_2
    //   98: new 434	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 567	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 6647
    //   108: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: iload 4
    //   113: invokevirtual 584	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: ldc_w 6649
    //   119: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: iload_3
    //   123: invokevirtual 584	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 6651
    //   129: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_2
    //   133: invokevirtual 584	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: invokevirtual 593	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 596	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: ldc_w 6652
    //   146: invokevirtual 2886	com/tencent/mobileqq/activity/BaseChatPie:b	(I)V
    //   149: return
    //   150: aload_0
    //   151: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   154: invokevirtual 6655	android/view/View:isDrawingCacheEnabled	()Z
    //   157: istore 5
    //   159: aload_0
    //   160: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   163: invokevirtual 6658	android/view/View:willNotCacheDrawing	()Z
    //   166: istore 6
    //   168: aload_0
    //   169: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   172: iconst_1
    //   173: invokevirtual 6661	android/view/View:setDrawingCacheEnabled	(Z)V
    //   176: aload_0
    //   177: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   180: iconst_0
    //   181: invokevirtual 6664	android/view/View:setWillNotCacheDrawing	(Z)V
    //   184: aload_0
    //   185: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   188: invokevirtual 6668	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   191: astore 7
    //   193: aload_0
    //   194: new 1834	android/widget/FrameLayout
    //   197: dup
    //   198: aload_0
    //   199: getfield 459	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   202: invokespecial 5464	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   205: putfield 6131	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   208: aconst_null
    //   209: astore 9
    //   211: aload 9
    //   213: astore 8
    //   215: aload 7
    //   217: ifnull +10 -> 227
    //   220: aload 7
    //   222: invokestatic 6671	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   225: astore 8
    //   227: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +31 -> 261
    //   233: ldc_w 710
    //   236: iconst_2
    //   237: new 434	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 567	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 6673
    //   247: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 8
    //   252: invokevirtual 1587	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 593	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 596	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 8
    //   263: ifnull +461 -> 724
    //   266: aload_0
    //   267: getfield 455	com/tencent/mobileqq/activity/BaseChatPie:jdField_c_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   270: ldc_w 5490
    //   273: invokevirtual 5491	android/view/ViewGroup:findViewById	(I)Landroid/view/View;
    //   276: checkcast 1842	android/view/ViewGroup
    //   279: astore 7
    //   281: aload 7
    //   283: invokevirtual 5492	android/view/ViewGroup:getChildCount	()I
    //   286: istore_3
    //   287: iconst_0
    //   288: istore_2
    //   289: iload_2
    //   290: iload_3
    //   291: if_icmpge +551 -> 842
    //   294: aload 7
    //   296: iload_2
    //   297: invokevirtual 5493	android/view/ViewGroup:getChildAt	(I)Landroid/view/View;
    //   300: aload_0
    //   301: getfield 714	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqBubbleChatXListView	Lcom/tencent/mobileqq/bubble/ChatXListView;
    //   304: if_acmpne +71 -> 375
    //   307: iload_2
    //   308: iconst_m1
    //   309: if_icmpne +73 -> 382
    //   312: invokestatic 564	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +36 -> 351
    //   318: ldc_w 710
    //   321: iconst_2
    //   322: new 434	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 567	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 5495
    //   332: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: iload_2
    //   336: invokevirtual 584	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   339: ldc_w 5497
    //   342: invokevirtual 573	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 593	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 596	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   351: aload_0
    //   352: ldc_w 6652
    //   355: invokevirtual 2886	com/tencent/mobileqq/activity/BaseChatPie:b	(I)V
    //   358: return
    //   359: astore 7
    //   361: aconst_null
    //   362: astore 7
    //   364: goto -171 -> 193
    //   367: astore 7
    //   369: aconst_null
    //   370: astore 7
    //   372: goto -179 -> 193
    //   375: iload_2
    //   376: iconst_1
    //   377: iadd
    //   378: istore_2
    //   379: goto -90 -> 289
    //   382: new 1551	android/widget/RelativeLayout$LayoutParams
    //   385: dup
    //   386: iconst_m1
    //   387: iconst_m1
    //   388: invokespecial 1554	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   391: astore 9
    //   393: aload 9
    //   395: bipush 6
    //   397: ldc_w 5500
    //   400: invokevirtual 1558	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   403: aload 9
    //   405: bipush 8
    //   407: ldc_w 5500
    //   410: invokevirtual 1558	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   413: aload 9
    //   415: iconst_5
    //   416: ldc_w 5500
    //   419: invokevirtual 1558	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   422: aload 9
    //   424: bipush 7
    //   426: ldc_w 5500
    //   429: invokevirtual 1558	android/widget/RelativeLayout$LayoutParams:addRule	(II)V
    //   432: aload 7
    //   434: aload_0
    //   435: getfield 6131	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   438: iload_2
    //   439: iconst_1
    //   440: iadd
    //   441: aload 9
    //   443: invokevirtual 5501	android/view/ViewGroup:addView	(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V
    //   446: aload_0
    //   447: getfield 6131	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   450: new 6675	rqp
    //   453: dup
    //   454: aload_0
    //   455: invokespecial 6676	rqp:<init>	(Lcom/tencent/mobileqq/activity/BaseChatPie;)V
    //   458: invokevirtual 5505	android/view/ViewGroup:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   461: new 3801	android/widget/ImageView
    //   464: dup
    //   465: aload_0
    //   466: getfield 459	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   469: invokespecial 5465	android/widget/ImageView:<init>	(Landroid/content/Context;)V
    //   472: astore 9
    //   474: aload 9
    //   476: aload 8
    //   478: invokevirtual 5508	android/widget/ImageView:setImageBitmap	(Landroid/graphics/Bitmap;)V
    //   481: new 1834	android/widget/FrameLayout
    //   484: dup
    //   485: aload_0
    //   486: getfield 459	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   489: invokespecial 5464	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   492: astore 10
    //   494: new 5510	android/widget/FrameLayout$LayoutParams
    //   497: dup
    //   498: aload_0
    //   499: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   502: invokevirtual 5467	android/view/View:getWidth	()I
    //   505: aload_0
    //   506: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   509: invokevirtual 5468	android/view/View:getHeight	()I
    //   512: invokespecial 5511	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   515: astore 7
    //   517: aload 7
    //   519: bipush 51
    //   521: putfield 5514	android/widget/FrameLayout$LayoutParams:gravity	I
    //   524: aload_0
    //   525: getfield 6131	com/tencent/mobileqq/activity/BaseChatPie:jdField_b_of_type_AndroidViewViewGroup	Landroid/view/ViewGroup;
    //   528: aload 10
    //   530: aload 7
    //   532: invokevirtual 2582	android/view/ViewGroup:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   535: aload_0
    //   536: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   539: iconst_4
    //   540: invokevirtual 1838	android/view/View:setVisibility	(I)V
    //   543: aload 10
    //   545: aload 9
    //   547: new 5510	android/widget/FrameLayout$LayoutParams
    //   550: dup
    //   551: iconst_m1
    //   552: iconst_m1
    //   553: invokespecial 5511	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   556: invokevirtual 5515	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   559: aload 7
    //   561: aload_0
    //   562: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   565: invokevirtual 5518	android/view/View:getLeft	()I
    //   568: putfield 5521	android/widget/FrameLayout$LayoutParams:leftMargin	I
    //   571: aload 7
    //   573: aload_0
    //   574: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   577: invokevirtual 5046	android/view/View:getTop	()I
    //   580: putfield 5522	android/widget/FrameLayout$LayoutParams:topMargin	I
    //   583: aload 7
    //   585: iconst_0
    //   586: putfield 5523	android/widget/FrameLayout$LayoutParams:rightMargin	I
    //   589: aload 7
    //   591: iconst_0
    //   592: putfield 5524	android/widget/FrameLayout$LayoutParams:bottomMargin	I
    //   595: new 5526	android/view/animation/LinearInterpolator
    //   598: dup
    //   599: invokespecial 5527	android/view/animation/LinearInterpolator:<init>	()V
    //   602: astore 11
    //   604: new 5463	android/view/animation/AnimationSet
    //   607: dup
    //   608: iconst_1
    //   609: invokespecial 5466	android/view/animation/AnimationSet:<init>	(Z)V
    //   612: astore 12
    //   614: new 5529	android/view/animation/AlphaAnimation
    //   617: dup
    //   618: fconst_1
    //   619: fconst_0
    //   620: invokespecial 5532	android/view/animation/AlphaAnimation:<init>	(FF)V
    //   623: astore 7
    //   625: aload 7
    //   627: ldc2_w 4424
    //   630: invokevirtual 5537	android/view/animation/AlphaAnimation:setDuration	(J)V
    //   633: aload 7
    //   635: aload 11
    //   637: invokevirtual 5541	android/view/animation/AlphaAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   640: aload 12
    //   642: aload 7
    //   644: invokevirtual 5545	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   647: aload_1
    //   648: invokevirtual 3180	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   651: ifeq +127 -> 778
    //   654: new 5547	android/view/animation/TranslateAnimation
    //   657: dup
    //   658: fconst_0
    //   659: aload_0
    //   660: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   663: invokevirtual 5550	android/view/View:getRight	()I
    //   666: i2f
    //   667: fconst_0
    //   668: fconst_0
    //   669: invokespecial 5553	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   672: astore 7
    //   674: aload 7
    //   676: ldc2_w 4424
    //   679: invokevirtual 5554	android/view/animation/TranslateAnimation:setDuration	(J)V
    //   682: aload 7
    //   684: aload 11
    //   686: invokevirtual 5555	android/view/animation/TranslateAnimation:setInterpolator	(Landroid/view/animation/Interpolator;)V
    //   689: aload 12
    //   691: aload 7
    //   693: invokevirtual 5545	android/view/animation/AnimationSet:addAnimation	(Landroid/view/animation/Animation;)V
    //   696: aload 9
    //   698: aload 12
    //   700: invokevirtual 5558	android/widget/ImageView:startAnimation	(Landroid/view/animation/Animation;)V
    //   703: aload_0
    //   704: getfield 242	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   707: new 6678	rqr
    //   710: dup
    //   711: aload_0
    //   712: aload 10
    //   714: invokespecial 6681	rqr:<init>	(Lcom/tencent/mobileqq/activity/BaseChatPie;Landroid/widget/FrameLayout;)V
    //   717: ldc2_w 4424
    //   720: invokevirtual 669	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   723: pop
    //   724: aload_0
    //   725: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   728: iload 5
    //   730: invokevirtual 6661	android/view/View:setDrawingCacheEnabled	(Z)V
    //   733: aload_0
    //   734: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   737: iload 6
    //   739: invokevirtual 6664	android/view/View:setWillNotCacheDrawing	(Z)V
    //   742: aload 8
    //   744: ifnull +58 -> 802
    //   747: aload_0
    //   748: getfield 242	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   751: bipush 15
    //   753: invokevirtual 4972	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   756: astore 7
    //   758: aload 7
    //   760: aload_1
    //   761: putfield 694	android/os/Message:obj	Ljava/lang/Object;
    //   764: aload_0
    //   765: getfield 242	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   768: aload 7
    //   770: ldc2_w 4302
    //   773: invokevirtual 4429	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   776: pop
    //   777: return
    //   778: new 5547	android/view/animation/TranslateAnimation
    //   781: dup
    //   782: fconst_0
    //   783: aload_0
    //   784: getfield 6129	com/tencent/mobileqq/activity/BaseChatPie:jdField_f_of_type_AndroidViewView	Landroid/view/View;
    //   787: invokevirtual 5550	android/view/View:getRight	()I
    //   790: ineg
    //   791: i2f
    //   792: fconst_0
    //   793: fconst_0
    //   794: invokespecial 5553	android/view/animation/TranslateAnimation:<init>	(FFFF)V
    //   797: astore 7
    //   799: goto -125 -> 674
    //   802: aload_0
    //   803: getfield 698	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1	Lcom/tencent/mobileqq/activity/aio/ChatAdapter1;
    //   806: aload_1
    //   807: invokevirtual 6682	com/tencent/mobileqq/activity/aio/ChatAdapter1:a	(Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   810: aload_0
    //   811: getfield 242	com/tencent/mobileqq/activity/BaseChatPie:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   814: bipush 16
    //   816: ldc2_w 3250
    //   819: invokevirtual 1759	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   822: pop
    //   823: return
    //   824: astore 7
    //   826: aload 9
    //   828: astore 8
    //   830: goto -603 -> 227
    //   833: astore 7
    //   835: aload 9
    //   837: astore 8
    //   839: goto -612 -> 227
    //   842: iconst_m1
    //   843: istore_2
    //   844: goto -537 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	847	0	this	BaseChatPie
    //   0	847	1	paramChatMessage	ChatMessage
    //   16	828	2	i1	int
    //   62	230	3	i2	int
    //   66	46	4	i3	int
    //   157	572	5	bool1	boolean
    //   166	572	6	bool2	boolean
    //   191	104	7	localObject1	Object
    //   359	1	7	localException1	Exception
    //   362	1	7	localObject2	Object
    //   367	1	7	localOutOfMemoryError1	OutOfMemoryError
    //   370	428	7	localObject3	Object
    //   824	1	7	localException2	Exception
    //   833	1	7	localOutOfMemoryError2	OutOfMemoryError
    //   213	625	8	localObject4	Object
    //   209	627	9	localObject5	Object
    //   492	221	10	localFrameLayout	FrameLayout
    //   602	83	11	localLinearInterpolator	LinearInterpolator
    //   612	87	12	localAnimationSet	AnimationSet
    // Exception table:
    //   from	to	target	type
    //   184	193	359	java/lang/Exception
    //   184	193	367	java/lang/OutOfMemoryError
    //   220	227	824	java/lang/Exception
    //   220	227	833	java/lang/OutOfMemoryError
  }
  
  public void c(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.getVisibility() == 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
    }
    for (;;)
    {
      this.jdField_e_of_type_JavaLangString = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "[Performance] showEmoticonPanel, duration=" + (System.currentTimeMillis() - l1));
      }
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.jdField_e_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
        }
      }
      else if (paramString != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(paramString);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(3);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131432992, 0).b(a());
      return;
    }
    Object localObject = new Object[1];
    if (paramBoolean) {}
    for (int i1 = 2131438920;; i1 = 2131433747)
    {
      boolean bool = a((Object[])localObject, i1);
      localObject = (List)localObject[0];
      if ((localObject == null) || (((List)localObject).size() == 0)) {
        break;
      }
      if (bool)
      {
        DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(i1)).setPositiveButton(17039370, new rna(this, paramBoolean, (List)localObject)).setNegativeButton(17039360, new rmz(this)).show();
        return;
      }
      if (paramBoolean)
      {
        a((List)localObject, 2);
        return;
      }
      if (((List)localObject).size() == 1)
      {
        localObject = (ChatMessage)((List)localObject).get(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.jdField_a_of_type_ComTencentMobileqqActivityAioItemItemBuilderFactory.a((ChatMessage)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1).a(2131363499, this.jdField_a_of_type_AndroidContentContext, (ChatMessage)localObject);
        return;
      }
      b((List)localObject);
      return;
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (BaseChatItemLayout.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if ((this.jdField_q_of_type_Int == 0) && (!this.jdField_x_of_type_Boolean) && (u()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("inputx", 2, "showAudioPanelIfNeed return mEnterExtPanel=" + this.jdField_q_of_type_Int);
        }
      }
      else if (!this.jdField_e_of_type_Boolean)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (!localFriendsManager.f())
        {
          ThreadManager.executeOnSubThread(new rmb(this));
          return;
        }
        long l1 = System.currentTimeMillis();
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
          b(localFriendsManager, paramBoolean1, paramBoolean2);
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.aio.BaseChatPie", 2, "showAudioPanelIfNeed cost :" + (System.currentTimeMillis() - l1) + " isCallFromOnShow = " + paramBoolean1 + " guide = " + paramBoolean2);
          return;
          a(localFriendsManager, paramBoolean1, paramBoolean2);
        }
      }
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public int d()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public TextView d()
  {
    return this.jdField_e_of_type_AndroidWidgetTextView;
  }
  
  public void d()
  {
    this.jdField_E_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer = ((XPanelContainer)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131362822));
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnPanelChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setOnChangeMultiScreenListener(this);
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    this.jdField_d_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363473));
    PokeItemAnimationManager.a().a((FitSystemWindowsRelativeLayout)this.jdField_d_of_type_AndroidViewViewGroup);
    ((FitSystemWindowsRelativeLayout)this.jdField_d_of_type_AndroidViewViewGroup).setQQAppInterface(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363474));
    this.jdField_a_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363490);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363492));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363491));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363226));
    this.jdField_m_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363972));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363362));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363227));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363970));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363971));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363228));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363456));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363980));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363982));
    this.jdField_h_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363979));
    this.jdField_d_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131428869));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363976).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131435258));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363360));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363973));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363939));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363975));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363494));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363974));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363489));
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setActTAG("actFPSAIO");
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setStackFromBottom(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnTouchListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setTranscriptMode(0);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLongClickable(true);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setDelAnimationDuration(300L);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(this);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(this);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_AndroidContentContext, new rrk(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = ((AIOAnimationConatiner)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363008));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.jdField_a_of_type_ComTencentWidgetListView = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.jdField_a_of_type_ComTencentMobileqqActivityAioAnimIAioAnimListener = this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector = new AIOFooterViewDetector(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 = new ChatAdapter1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, this);
    if (this.jdField_m_of_type_AndroidViewView == null)
    {
      this.jdField_m_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      int i1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448);
      this.jdField_m_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, i1));
      this.jdField_m_of_type_AndroidViewView.setId(2131361977);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.addHeaderView(this.jdField_m_of_type_AndroidViewView, null, false);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeaderTop(i1);
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable = new ScrollerRunnable(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller = new MoveToBottomScroller(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = ((PanelIconLinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363475));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setPanelIconListener(this);
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = ((XEditTextEx)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363479));
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback = this.jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(QQTextBuilder.a);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(true).putInt("SOGOU_EXPRESSION", 1);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(new rnm(this));
      String str = Build.MODEL;
      DeviceLib.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton = ((PatchedButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363481));
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentWidgetPatchedButton.setContentDescription("发送");
      }
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setOnLongClickListener(new rny(this));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363476));
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363488));
      this.jdField_k_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363487));
      float f1 = this.jdField_j_of_type_AndroidWidgetTextView.getPaint().measureText("测");
      this.jdField_j_of_type_AndroidWidgetTextView.setMaxWidth((int)(f1 * 9.0F + 0.5F));
      this.jdField_o_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363486);
      this.jdField_e_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363482);
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363483));
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnTouchListener(this);
      this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837620);
      this.K = false;
      aE();
      aD();
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = new ArkRecommendController(this);
      }
      this.jdField_m_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("Q.aio.BaseChatPie", 1, "input set error", localException);
      }
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setVolumeControlStream(paramInt);
  }
  
  public void d(Intent paramIntent) {}
  
  public void d(ChatMessage paramChatMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    if (localObject == null) {}
    for (boolean bool = false; (bool) && (paramChatMessage.msgtype != -2005); bool = ((SharedPreferences)localObject).getBoolean("first_time_revoke_msg", true))
    {
      ((SharedPreferences)localObject).edit().putBoolean("first_time_revoke_msg", false).commit();
      localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131433739);
      if (paramChatMessage.msgtype == -2005) {
        localObject = this.jdField_a_of_type_AndroidContentContext.getString(2131433740);
      }
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage((CharSequence)localObject).setPositiveButton(17039370, new rre(this, paramChatMessage)).show();
      return;
    }
    f(paramChatMessage);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_b_of_type_AndroidAppDialog == null)
    {
      this.jdField_b_of_type_AndroidAppDialog = LBSHandler.a(this.jdField_a_of_type_AndroidContentContext, paramString, new rmc(this), null);
      if (this.jdField_b_of_type_AndroidAppDialog != null) {
        ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131364014)).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131432999));
      }
    }
    if ((this.jdField_b_of_type_AndroidAppDialog != null) && (!this.jdField_b_of_type_AndroidAppDialog.isShowing()) && (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()))
    {
      ((TextView)this.jdField_b_of_type_AndroidAppDialog.findViewById(2131362758)).setText(paramString);
      this.jdField_b_of_type_AndroidAppDialog.show();
    }
  }
  
  @TargetApi(13)
  public void d(boolean paramBoolean)
  {
    int i1 = 0;
    int i2 = 1;
    if (!paramBoolean)
    {
      this.jdField_G_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getRequestedOrientation();
      int i3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.b()) {
        if (i3 == 1)
        {
          localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
          i1 = i2;
          if (VersionUtils.c()) {
            i1 = 7;
          }
          ((FragmentActivity)localObject).setRequestedOrientation(i1);
        }
      }
      label72:
      do
      {
        do
        {
          do
          {
            break label72;
            do
            {
              return;
            } while (i3 != 2);
            localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
            if (VersionUtils.c()) {}
            for (i1 = 6;; i1 = 0)
            {
              ((FragmentActivity)localObject).setRequestedOrientation(i1);
              return;
            }
            if (VersionUtils.f())
            {
              localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindowManager().getDefaultDisplay();
              i2 = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((i2 == 0) || (i2 == 2)) {
                if (localPoint.jdField_x_of_type_Int > localPoint.jdField_y_of_type_Int) {
                  if (i2 != 0) {}
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(i1);
                return;
                i1 = 8;
                continue;
                if (i2 == 0)
                {
                  i1 = 1;
                }
                else
                {
                  i1 = 9;
                  continue;
                  if (localPoint.jdField_x_of_type_Int > localPoint.jdField_y_of_type_Int)
                  {
                    if (i2 != 1) {
                      i1 = 8;
                    }
                  }
                  else if (i2 == 1) {
                    i1 = 9;
                  } else {
                    i1 = 1;
                  }
                }
              }
            }
            i1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((i1 != 0) && (i1 != 1)) {
              break;
            }
            if (i3 == 1)
            {
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(1);
              return;
            }
          } while (i3 != 2);
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(0);
          return;
        } while ((i1 != 2) && (i1 != 3));
        if (i3 == 1)
        {
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(9);
          return;
        }
      } while (i3 != 2);
      this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(8);
      return;
    }
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.setRequestedOrientation(this.jdField_G_of_type_Int);
  }
  
  public boolean d()
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "[initApolloSurfaceView],mCurrentAIOState:" + this.jdField_h_of_type_Int);
    }
    aX();
    this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(this);
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 0)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(25);
      if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()))
      {
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433377));
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      }
    }
    while ((paramInt != 1) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
  }
  
  public void e(Intent paramIntent)
  {
    String str = null;
    Object localObject = paramIntent.getExtras();
    boolean bool;
    if (paramIntent.getBooleanExtra("message_box_click", false))
    {
      this.jdField_i_of_type_Boolean = true;
      aJ();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription("返回消息");
      bool = paramIntent.getBooleanExtra("key_jump_from_qzone_feed", false);
      if (!paramIntent.getBooleanExtra("isFromDiscussionFlyTicket", false)) {
        break label341;
      }
      this.jdField_c_of_type_Boolean = true;
      if (!this.jdField_c_of_type_Boolean) {
        break label466;
      }
      long l1 = System.currentTimeMillis();
      t();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "AIOTime doOnCreate_initUI updateUnreadNumOnTitleBar cost: " + (System.currentTimeMillis() - l1));
      }
    }
    for (;;)
    {
      str = paramIntent.getStringExtra("backName");
      if (!android.text.TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        aJ();
        str = paramIntent.getStringExtra("comicId");
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        paramIntent = str;
        if (str == null) {
          paramIntent = "";
        }
        ((TextView)localObject).setTag(new String[] { "comic", paramIntent });
        this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("返回QQ动漫");
      }
      if (ChatActivityConstants.N)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("聊天设置");
        if (!this.jdField_c_of_type_Boolean)
        {
          str = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
          paramIntent = str;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131432397).equals(str)) {
            paramIntent = "返回" + str + "界面";
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramIntent);
        }
      }
      return;
      if (localObject == null) {
        break;
      }
      this.jdField_i_of_type_Boolean = ((Bundle)localObject).getBoolean("isBack2Root");
      if (!this.jdField_i_of_type_Boolean) {
        break;
      }
      aJ();
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLeftContentDescription("返回消息");
      break;
      label341:
      if (bool)
      {
        str = paramIntent.getStringExtra("key_jump_from_qzone_feed_left_title");
        if (str == null) {}
        for (str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131433681);; str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131436283, new Object[] { str }))
        {
          this.jdField_c_of_type_Boolean = false;
          break;
        }
      }
      str = paramIntent.getStringExtra("leftViewText");
      if ((this.jdField_i_of_type_Boolean) || ((str != null) && (str.contains(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131433280))))) {}
      for (bool = true;; bool = false)
      {
        this.jdField_c_of_type_Boolean = bool;
        break;
      }
      label466:
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      localObject = str;
      if (str == null) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131433681);
      }
      localTextView.setText((CharSequence)localObject);
      aJ();
    }
  }
  
  public void e(ChatMessage paramChatMessage)
  {
    if ((NetConnInfoCenter.getServerTimeMillis() - paramChatMessage.time * 1000L < 120000L) || (paramChatMessage.msgtype == -2005) || (TroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
    {
      this.jdField_b_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131433742));
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(true);
      localQQMessageFacade.b(this.jdField_b_of_type_ComTencentMobileqqDataChatMessage);
      int i1 = 20000;
      if (paramChatMessage.msgtype == -2005) {
        i1 = 30000;
      }
      paramChatMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(267387140, 1, 0);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramChatMessage, i1);
      return;
    }
    DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131433741)).setPositiveButton(17039370, new rlw(this)).show();
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_A_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "leftBackEvent() disableBackForPTV true");
      }
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 10))
    {
      rop localrop = new rop(this, paramBoolean);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131439042), this.jdField_a_of_type_AndroidContentContext.getString(2131439043), this.jdField_a_of_type_AndroidContentContext.getString(2131439044), localrop, localrop).show();
      return;
    }
    p(paramBoolean);
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b();
    }
    Object localObject = LightReplyMenuManager.a();
    if ((localObject != null) && (((LightReplyMenuManager)localObject).b()))
    {
      ((LightReplyMenuManager)localObject).a();
      if (((LightReplyMenuManager)localObject).a != null) {
        ((LightReplyMenuManager)localObject).a.b();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.d();
    }
    if (this.jdField_A_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "onBackEvent() disableBackForPTV true");
      }
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 0) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 0)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80081B8", "0X80081B8", 1, 0, "", "", "", "");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a(true) > 10) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 0))
    {
      localObject = new rnr(this);
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, null, this.jdField_a_of_type_AndroidContentContext.getString(2131439042), this.jdField_a_of_type_AndroidContentContext.getString(2131439043), this.jdField_a_of_type_AndroidContentContext.getString(2131439044), (DialogInterface.OnClickListener)localObject, (DialogInterface.OnClickListener)localObject).show();
      return false;
    }
    return b(0);
  }
  
  public int f()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
  }
  
  public void f()
  {
    aX();
    this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.b(this);
  }
  
  public void f(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_a_of_type_MqqOsMqqHandler.hasMessages(16711686)))
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711688);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_j_of_type_Int = paramInt;
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(16711686);
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 200L);
    }
  }
  
  public void f(Intent paramIntent)
  {
    if (ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidContentContext, paramIntent, this.jdField_a_of_type_MqqOsMqqHandler)) {
      this.jdField_i_of_type_Boolean = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getBooleanExtra("isBack2Root", false);
    }
  }
  
  public void f(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.msgtype != -2005)
    {
      e(paramChatMessage);
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    localActionSheet.a("撤回后双方文件消息将被删除");
    localActionSheet.b("(若对方非最新版本，则消息撤回可能失败。)");
    localActionSheet.a("撤回", 3);
    localActionSheet.d("取消");
    localActionSheet.a(new rlx(this, paramChatMessage, localActionSheet));
    localActionSheet.show();
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverScrollHeaderView() == null)
      {
        if (this.jdField_i_of_type_AndroidViewView == null) {
          this.jdField_i_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968796, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader(this.jdField_i_of_type_AndroidViewView);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverscrollHeader((Drawable)null);
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollHeader((View)null);
  }
  
  public boolean f()
  {
    return ((this instanceof TroopChatPie)) || ((this instanceof DiscussChatPie));
  }
  
  public int g()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController = new AIOTipsController(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new rrj(this, null);
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioAVObserver == null) {
      this.jdField_a_of_type_ComTencentAvGaudioAVObserver = new rrg(this, null);
    }
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_p_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = new TipsManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPasswdRedBagManager = ((PasswdRedBagManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124));
  }
  
  public void g(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
  }
  
  public void g(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "doOnNewIntent");
    }
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    }
    this.jdField_h_of_type_Int = 1;
    this.I = false;
    n(paramIntent);
    h(paramIntent);
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "AIOTime doOnNewIntent end");
    }
  }
  
  public void g(ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidWidgetTextView.getText().toString();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131433682);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(null);
    int i8 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics().widthPixels;
    int i7 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131558448) - 5;
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = (RelativeLayout)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363474);
    Object localObject2;
    if (this.jdField_b_of_type_AndroidViewView == null)
    {
      this.jdField_b_of_type_AndroidViewView = new View(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = new RelativeLayout.LayoutParams(-1, i7);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
      this.jdField_b_of_type_AndroidViewView.setFocusable(true);
      this.jdField_b_of_type_AndroidViewView.setContentDescription("");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      }
      ((RelativeLayout)localObject1).addView(this.jdField_b_of_type_AndroidViewView);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "createMulti");
    }
    int i9;
    int i1;
    int i2;
    label332:
    int i3;
    label348:
    int i4;
    label355:
    int i5;
    label363:
    int i6;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      localObject2 = new RelativeLayout.LayoutParams(-1, i7);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      i9 = i8 / 37;
      ((RelativeLayout.LayoutParams)localObject2).setMargins(i9, 0, i9, 0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((RelativeLayout)localObject1).addView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
      if (AIOUtils.a(1) != 0) {
        break label1316;
      }
      i1 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label1321;
      }
      i2 = 1;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008) {
        break label1326;
      }
      i3 = 1;
      if (i1 == 0) {
        break label1332;
      }
      i4 = 1;
      if (i3 == 0) {
        break label1338;
      }
      i5 = 1;
      if (i2 == 0) {
        break label1344;
      }
      i6 = 1;
      label370:
      i5 = i4 + 1 + i5 + i6;
      if (i5 != 1) {
        break label1350;
      }
      i4 = (i8 - i9 * 2 - i7) / 2;
      label402:
      i6 = i7 * 3 / 20;
      this.jdField_i_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_i_of_type_AndroidWidgetImageView.setId(2131361898);
      localObject1 = new LinearLayout.LayoutParams(i7, i7);
      if (i5 != 1) {
        break label1373;
      }
      ((LinearLayout.LayoutParams)localObject1).setMargins(i4, 0, 0, 0);
      label465:
      this.jdField_i_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.jdField_i_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
      this.jdField_i_of_type_AndroidWidgetImageView.setOnClickListener(this);
      if (AppSetting.jdField_b_of_type_Boolean) {
        this.jdField_i_of_type_AndroidWidgetImageView.setContentDescription("删除");
      }
      localObject1 = new StateListDrawable();
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838541);
      ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838542);
      ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
      this.jdField_i_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_i_of_type_AndroidWidgetImageView);
      if (i1 != 0)
      {
        this.jdField_j_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_j_of_type_AndroidWidgetImageView.setId(2131361899);
        localObject1 = new LinearLayout.LayoutParams(i7, i7);
        ((LinearLayout.LayoutParams)localObject1).setMargins(i4, 0, 0, 0);
        this.jdField_j_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_j_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
        this.jdField_j_of_type_AndroidWidgetImageView.setOnClickListener(this);
        if (AppSetting.jdField_b_of_type_Boolean) {
          this.jdField_j_of_type_AndroidWidgetImageView.setContentDescription("添加到表情");
        }
        localObject1 = new StateListDrawable();
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838556);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838557);
        ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838556);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_j_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_j_of_type_AndroidWidgetImageView);
      }
      if (i3 != 0)
      {
        this.jdField_k_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_k_of_type_AndroidWidgetImageView.setId(2131361897);
        if (AppSetting.jdField_b_of_type_Boolean) {
          this.jdField_k_of_type_AndroidWidgetImageView.setContentDescription("转发");
        }
        localObject1 = new LinearLayout.LayoutParams(i7, i7);
        ((LinearLayout.LayoutParams)localObject1).setMargins(i4, 0, 0, 0);
        this.jdField_k_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_k_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
        this.jdField_k_of_type_AndroidWidgetImageView.setOnClickListener(this);
        localObject1 = new StateListDrawable();
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838564);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838565);
        ((StateListDrawable)localObject1).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838564);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_k_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_k_of_type_AndroidWidgetImageView);
      }
      if (i2 != 0)
      {
        this.jdField_l_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_l_of_type_AndroidWidgetImageView.setId(2131361902);
        if (AppSetting.jdField_b_of_type_Boolean) {
          this.jdField_l_of_type_AndroidWidgetImageView.setContentDescription("更多");
        }
        localObject1 = new LinearLayout.LayoutParams(i7, i7);
        ((LinearLayout.LayoutParams)localObject1).setMargins(i4, 0, 0, 0);
        this.jdField_l_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_l_of_type_AndroidWidgetImageView.setPadding(i6, i6, i6, i6);
        this.jdField_l_of_type_AndroidWidgetImageView.setOnClickListener(this);
        localObject1 = new StateListDrawable();
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838502);
        ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838502);
        ((StateListDrawable)localObject1).addState(new int[0], (Drawable)localObject2);
        this.jdField_l_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_l_of_type_AndroidWidgetImageView);
      }
    }
    if (bool) {
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493227));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131363228).setVisibility(4);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setCustomHeight(0);
      }
      a(true, paramChatMessage, false);
      return;
      label1316:
      i1 = 0;
      break;
      label1321:
      i2 = 0;
      break label332;
      label1326:
      i3 = 0;
      break label348;
      label1332:
      i4 = 0;
      break label355;
      label1338:
      i5 = 0;
      break label363;
      label1344:
      i6 = 0;
      break label370;
      label1350:
      i4 = (i8 - i9 * 2 - i7 * i5) / (i5 - 1);
      break label402;
      label1373:
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      break label465;
      this.jdField_b_of_type_AndroidViewView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492894));
    }
  }
  
  public void g(boolean paramBoolean) {}
  
  public boolean g()
  {
    return j();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips = new QQOperateTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentWidgetXPanelContainer, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    ReaderTipsBar localReaderTipsBar = new ReaderTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar = new VideoStatusTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_MqqOsMqqHandler);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar = new FraudTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_MqqOsMqqHandler);
    SougouInputGrayTips localSougouInputGrayTips = new SougouInputGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    HongbaoKeywordGrayTips localHongbaoKeywordGrayTips = new HongbaoKeywordGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1);
    VipSpecialCareGrayTips localVipSpecialCareGrayTips = new VipSpecialCareGrayTips(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ComicTipsBar localComicTipsBar = new ComicTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsQQOperateTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localReaderTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVideoStatusTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localComicTipsBar);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localSougouInputGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localHongbaoKeywordGrayTips);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(localVipSpecialCareGrayTips);
  }
  
  public void h(int paramInt)
  {
    AudioUtil.b(paramInt, false);
  }
  
  public void h(Intent paramIntent)
  {
    this.jdField_k_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.u();
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) && (QLog.isColorLevel())) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNewIntent sessionInfo.curFriendUin is null and sessionInfo.curType " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + " troopUin " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString + " sessionInfo.entrance " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int);
    }
    i(paramIntent);
    this.jdField_p_of_type_Boolean = true;
    a(paramIntent, 2);
  }
  
  public void h(ChatMessage paramChatMessage)
  {
    b(paramChatMessage, 0);
  }
  
  public void h(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
    }
    if (!VideoEnvironment.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 230).setMessage("系统版本过低，不支持短视频功能").setPositiveButton(2131432999, new rmk(this)).show();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
      QQToast.a(BaseApplicationImpl.getContext(), 2131428986, 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131558448));
    }
    for (;;)
    {
      AIOPanelUtiles.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "0X8005E91", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
      return;
      if (VideoEnvironment.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        i(paramBoolean);
      }
    }
  }
  
  public boolean h()
  {
    return this.aa;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1;
    Object localObject1;
    switch (paramMessage.what)
    {
    default: 
    case 16711689: 
    case 16711681: 
    case 16711683: 
    case 16711685: 
    case 16711687: 
    case 16711686: 
    case 16711688: 
    case 10: 
    case 41: 
    case 12: 
    case 78: 
    case 13: 
    case 14: 
    case 54: 
    case 60: 
    case 15: 
    case 16: 
    case 52: 
    case 17: 
    case 18: 
    case 21: 
    case 44: 
    case 77: 
    case 76: 
    case 66: 
    case 73: 
    case 75: 
    case 72: 
    case 45: 
    case 48: 
    case 47: 
    case 61: 
    case 62: 
    case 65: 
    case 49: 
    case 51: 
    case 22: 
    case 23: 
    case 16711696: 
    case 24: 
    case 16711697: 
      for (;;)
      {
        return true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "read confirm send readconfirm");
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16711689, 300000L);
        ThreadManager.post(new rlv(this), 8, null, false);
        continue;
        paramMessage = (String)paramMessage.obj;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessage))
        {
          b(1);
          continue;
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433713, 1).b(a());
          continue;
          ba();
          continue;
          f(2);
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
          }
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.c();
          aI();
          if (this.jdField_c_of_type_Long == 0L)
          {
            h(2131230743);
            continue;
            a(0, null, -1L);
            continue;
            if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.i();
              continue;
              if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
              {
                this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.j();
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.aio.BaseChatPie", 2, "handleMessage MSG_REFRESH_LIST");
                }
                if ((paramMessage.obj != null) && ((paramMessage.obj instanceof MessageHandler.MsgSendCostParams)))
                {
                  paramMessage = (MessageHandler.MsgSendCostParams)paramMessage.obj;
                  paramMessage.jdField_e_of_type_Long = (System.currentTimeMillis() - paramMessage.jdField_d_of_type_Long);
                  MessageHandler.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
                N();
                if (this.jdField_g_of_type_Int == 0)
                {
                  BubbleDiyFetcher.a().a(a(), 1500);
                  DiyPendantFetcher.a().a(a(), 1500);
                  continue;
                  long l1 = paramMessage.getData().getLong("messageUniseq");
                  i1 = paramMessage.arg1;
                  localObject1 = (ChatMessage)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, l1);
                  if ((localObject1 != null) && (paramMessage.obj != null) && ((paramMessage.obj instanceof MessageHandler.MsgSendCostParams)))
                  {
                    paramMessage = (MessageHandler.MsgSendCostParams)paramMessage.obj;
                    paramMessage.jdField_e_of_type_Long = (System.currentTimeMillis() - paramMessage.jdField_d_of_type_Long);
                    MessageHandler.a(paramMessage, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                    ((ChatMessage)localObject1).setIsSentByXG(paramMessage.jdField_b_of_type_Boolean);
                  }
                  a((ChatMessage)localObject1, i1);
                  continue;
                  v(paramMessage.arg1);
                  continue;
                  c(paramMessage.arg1, paramMessage.arg2);
                  continue;
                  if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (paramMessage.arg1 > 50))
                  {
                    localObject1 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams();
                    if ((localObject1 != null) && (((RelativeLayout.LayoutParams)localObject1).bottomMargin != paramMessage.arg1))
                    {
                      ((RelativeLayout.LayoutParams)localObject1).setMargins(((RelativeLayout.LayoutParams)localObject1).leftMargin, ((RelativeLayout.LayoutParams)localObject1).topMargin, ((RelativeLayout.LayoutParams)localObject1).rightMargin, paramMessage.arg1);
                      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                      continue;
                      if (this.jdField_d_of_type_AndroidViewViewGroup == null)
                      {
                        paramMessage = "1";
                        label1168:
                        if (paramMessage == null) {
                          continue;
                        }
                        if ((this.jdField_d_of_type_AndroidViewViewGroup == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground == null) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!ChatBackground.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)))) {
                          break label1775;
                        }
                        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
                          break label1629;
                        }
                        this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
                        this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
                      }
                      for (;;)
                      {
                        QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error. bErrMsg=" + paramMessage + ", show Again img=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                        break;
                        if (paramMessage.obj == null)
                        {
                          paramMessage = "2";
                          break label1168;
                        }
                        if (!(paramMessage.obj instanceof Drawable))
                        {
                          paramMessage = "3, msg.obj=" + paramMessage.obj;
                          break label1168;
                        }
                        if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
                        {
                          if ((!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean)) {
                            break label1486;
                          }
                          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
                          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
                        }
                        for (;;)
                        {
                          ap();
                          paramMessage = null;
                          break;
                          label1486:
                          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
                          {
                            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
                            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
                          }
                          else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
                          {
                            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
                            this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
                          }
                          else
                          {
                            this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable((Drawable)paramMessage.obj);
                          }
                        }
                        label1629:
                        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Boolean))
                        {
                          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
                          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
                        }
                        else if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1033) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1034))
                        {
                          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130845689));
                          this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(1711276032);
                        }
                        else
                        {
                          this.jdField_d_of_type_AndroidViewViewGroup.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                        }
                      }
                      label1775:
                      QLog.e("Q.msg.delmsg", 1, "MSG_SHOW_AIO_BACKGROUND Error.. bErrMsg=" + paramMessage + ", afRoot=" + this.jdField_d_of_type_AndroidViewViewGroup + ", sessionInfo=" + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.delmsg", 2, "delay MSG_START_VER_ANIM msg is handled,time is:" + System.currentTimeMillis());
                      }
                      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.a((ChatMessage)paramMessage.obj);
                      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(16, 300L);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.delmsg", 2, "ver anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
                      }
                      if (this.jdField_f_of_type_AndroidViewView != null) {
                        this.jdField_f_of_type_AndroidViewView.setVisibility(0);
                      }
                      if ((this.jdField_b_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null)) {
                        ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).removeView(this.jdField_b_of_type_AndroidViewViewGroup);
                      }
                      this.jdField_f_of_type_AndroidViewView = null;
                      this.jdField_b_of_type_AndroidViewViewGroup = null;
                      b(196612);
                      continue;
                      b(196612);
                      continue;
                      if (QLog.isColorLevel()) {
                        QLog.d("Q.msg.delmsg", 2, "ver anim onAnimationEnd() is called,time is:" + System.currentTimeMillis());
                      }
                      if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout != null)
                      {
                        i1 = 0;
                        while (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout.length)
                        {
                          if (this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1] != null) {
                            this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout[i1].setVisibility(8);
                          }
                          i1 += 1;
                        }
                      }
                      if (this.jdField_a_of_type_ArrayOfAndroidViewView != null)
                      {
                        i1 = 0;
                        while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewView.length)
                        {
                          if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] != null) {
                            this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
                          }
                          i1 += 1;
                        }
                      }
                      if (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup != null)
                      {
                        i1 = 0;
                        while (i1 < this.jdField_a_of_type_ArrayOfAndroidViewViewGroup.length)
                        {
                          if ((this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1] != null) && (this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent() != null)) {
                            ((ViewGroup)this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1].getParent()).removeView(this.jdField_a_of_type_ArrayOfAndroidViewViewGroup[i1]);
                          }
                          i1 += 1;
                        }
                      }
                      this.jdField_a_of_type_ArrayOfAndroidViewView = null;
                      this.jdField_a_of_type_ArrayOfAndroidViewViewGroup = null;
                      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = null;
                      this.jdField_a_of_type_ArrayOfAndroidViewAnimationAnimationSet = null;
                      this.jdField_a_of_type_ArrayOfAndroidWidgetFrameLayout = null;
                      b(65540);
                      continue;
                      a(false, false);
                      continue;
                      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
                      {
                        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.h();
                        continue;
                        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                        {
                          this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.f();
                          continue;
                          paramMessage = (String)paramMessage.obj;
                          if (!android.text.TextUtils.isEmpty(paramMessage))
                          {
                            QQToast.a(this.jdField_a_of_type_AndroidContentContext, paramMessage, 0).a();
                            continue;
                            if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                            {
                              this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.o();
                              continue;
                              if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                              {
                                localObject1 = (ApolloInfo)paramMessage.obj;
                                if (paramMessage.arg1 == 1)
                                {
                                  this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.g();
                                }
                                else
                                {
                                  this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a((ApolloInfo)localObject1);
                                  continue;
                                  if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                                  {
                                    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.n();
                                    continue;
                                    i1 = paramMessage.arg1;
                                    int i2 = paramMessage.arg2;
                                    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                                    {
                                      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(i1, i2);
                                      continue;
                                      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) {
                                        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.n();
                                      }
                                      if ((paramMessage.obj != null) && (!android.text.TextUtils.isEmpty(paramMessage.obj.toString())))
                                      {
                                        if (this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
                                        {
                                          localObject1 = new rml(this);
                                          this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, "游戏币不够", paramMessage.obj.toString(), "取消", "查看详情", (DialogInterface.OnClickListener)localObject1, null);
                                          new rmt(this);
                                        }
                                        this.jdField_b_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
                                        continue;
                                        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
                                        {
                                          paramMessage = (HashMap)paramMessage.obj;
                                          if (paramMessage != null)
                                          {
                                            paramMessage.put("offset", "" + a());
                                            this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.a(paramMessage);
                                            continue;
                                            if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
                                            {
                                              this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
                                              continue;
                                              if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a() != null)
                                              {
                                                i1 = Math.max(AIOUtils.a(46.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramMessage.arg1);
                                                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(1, i1);
                                                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(i1, true, "handleMsg_showFooter");
                                              }
                                              else
                                              {
                                                if (1 != ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
                                                {
                                                  i1 = 1;
                                                  label2688:
                                                  if ((i1 == 0) || (SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
                                                    break label2752;
                                                  }
                                                }
                                                label2752:
                                                for (i1 = 1; i1 == 0; i1 = 0)
                                                {
                                                  this.J = true;
                                                  this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(Math.max(AIOUtils.a(46.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramMessage.arg1), false, "handleMsg_addFooter");
                                                  break;
                                                  i1 = 0;
                                                  break label2688;
                                                }
                                                this.J = false;
                                                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(1, 0);
                                                this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
                                                continue;
                                                e();
                                                continue;
                                                as();
                                                continue;
                                                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel != null)
                                                {
                                                  this.jdField_a_of_type_ComTencentMobileqqActivityAioPlusPanel.b();
                                                  continue;
                                                  c((String)paramMessage.obj);
                                                  continue;
                                                  k(0);
                                                  this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
                                                  continue;
                                                  b(1);
                                                  continue;
                                                  if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
                                                  {
                                                    this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
                                                    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433408, 0).b(this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDimensionPixelSize(2131558448));
                                                  }
                                                  localObject1 = new HashMap();
                                                  ((HashMap)localObject1).put("nickCount", paramMessage.arg1 + "");
                                                  StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "multiMsgNickTimeOut", false, 30000L, 0L, (HashMap)localObject1, "");
                                                  continue;
                                                  l1 = System.currentTimeMillis();
                                                  if (l1 - this.jdField_e_of_type_Long < 1000L)
                                                  {
                                                    if (QLog.isColorLevel()) {
                                                      QLog.d("Q.aio.BaseChatPie", 2, "MSG_BUBBLE_CACHE_UPDATE, frequency limit, abort");
                                                    }
                                                  }
                                                  else
                                                  {
                                                    this.jdField_e_of_type_Long = l1;
                                                    if (this.jdField_g_of_type_Int == 0) {
                                                      break;
                                                    }
                                                    this.jdField_t_of_type_Boolean = true;
                                                    if (QLog.isColorLevel()) {
                                                      QLog.d("Q.aio.BaseChatPie", 2, "MSG_BUBBLE_CACHE_UPDATE, scrolling, abort");
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break;
      }
    }
    for (paramMessage = (BubbleManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43);; paramMessage = null)
    {
      label3089:
      Object localObject2;
      boolean bool;
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) && (paramMessage != null))
      {
        i1 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildCount() - 1;
        if (i1 >= 0)
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(i1);
          if ((localObject2 instanceof BaseChatItemLayout))
          {
            localObject1 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject2);
            localObject2 = AIOUtils.a((View)localObject2);
            if ((localObject2 != null) && (((ChatMessage)localObject2).needVipBubble()) && (localObject1 != null) && (((BaseBubbleBuilder.ViewHolder)localObject1).a != null) && (((BaseBubbleBuilder.ViewHolder)localObject1).a.jdField_a_of_type_Int == BubbleUtils.a.jdField_a_of_type_Int) && (paramMessage.a(SVIPHandler.a(((ChatMessage)localObject2).vipBubbleID)))) {
              bool = true;
            }
          }
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "MSG_BUBBLE_CACHE_UPDATE, needRefresh=" + bool);
        }
        if (!bool) {
          break;
        }
        b(196608);
        break;
        if (((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).a((BaseBubbleBuilder.ViewHolder)localObject1, (ChatMessage)localObject2))
        {
          bool = true;
          continue;
          if ((localObject2 != null) && ((AIOUtils.a((View)localObject2) instanceof RichStatItemBuilder.Holder)))
          {
            bool = true;
            continue;
          }
        }
        i1 -= 1;
        break label3089;
        a(paramMessage);
        break;
        if ((this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null)) {
          break;
        }
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
        this.jdField_b_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar = new LightalkBlueTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsLightalkBlueTipsBar, new Object[0])) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightalkBlueTipsBar", 2, "BaseChatPie:handleMessage() : TYPE_ON_SHOW =====>");
        }
        ThreadManager.getSubThreadHandler().post(new rmu(this));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800510F", "0X800510F", 0, 0, "1", "", "", "");
        break;
        bool = paramMessage.getData().getBoolean("showRedDot");
        if (bool) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005B00", "0X8005B00", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.a(bool);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar = new VipFunCallTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, new rmv(this));
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsVipFunCallTipsBar, new Object[0]);
        break;
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        break;
        ChatActivityFacade.a(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, true);
        break;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a();
        break;
        bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_notice_key", false);
        if ((SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", false)) || (!bool)) {
          break;
        }
        SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), null, "pcactive_has_notice", true);
        paramMessage = new Intent("mqq.intent.action.NOTICE_ON_PCACTIVE");
        paramMessage.addFlags(268435456);
        paramMessage.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        BaseApplicationImpl.getApplication().startActivity(paramMessage);
        break;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "MSG_SHOW_FASTIMAGE,  mAllowFastImage = " + this.jdField_h_of_type_Boolean);
        }
        if (!this.jdField_h_of_type_Boolean) {
          return true;
        }
        if ((this.jdField_d_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_d_of_type_AndroidWidgetLinearLayout.getVisibility() == 0)) {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
          a(false);
        }
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D91", "0X8004D91", 0, 0, "", "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.a();
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(this);
        }
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(33), 5000L);
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.d();
        break;
        a(true);
        break;
        p(paramMessage.arg1);
        break;
        if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(false);
        break;
        if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
        {
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(false);
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131433738, 0).b(a());
        if (paramMessage.arg1 != 1) {
          break;
        }
        UncommonMessageProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, UncommonMessageProcessor.jdField_e_of_type_Int, UncommonMessageProcessor.jdField_o_of_type_Int);
        break;
        a((String)paramMessage.obj, true, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        break;
        d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 3);
        break;
        ad();
        break;
        a(true, true);
        break;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        break;
        aF();
        break;
        if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionKeywordAdapter.d();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.c();
        break;
        if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.d();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b();
        }
        EmojiStickerManager.a().b(this);
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(67);
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(67, 5000L);
        break;
        if (!ResponseHandler.a(0)) {
          break;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2, 2131429819, 1).b(a());
        break;
        i1 = paramMessage.arg1;
        if (!ResponseHandler.a(i1)) {
          break;
        }
        if (ResponseHandler.d(i1))
        {
          ResponseHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          break;
        }
        paramMessage = (String)paramMessage.obj;
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramMessage, 1).b(a());
        break;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007FA8", "0X8007FA8", 0, 0, "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "[Doutu] handleMessage : MSG_SHOW_DOUTU_EMOTION_LAYOUT");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager == null) {
          this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager = ((DoutuManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(213));
        }
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_MqqOsMqqHandler, (DoutuItem)paramMessage.obj);
        if (this.jdField_d_of_type_AndroidWidgetLinearLayout != null) {
          this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(false);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.d();
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
          this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b();
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.a(true);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
        break;
        if ((this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager == null) || (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionAdapter == null)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.jdField_a_of_type_ComTencentMobileqqDoutuDoutuEmotionAdapter.notifyDataSetChanged();
        break;
        if (!(paramMessage.obj instanceof ApolloActionData)) {
          break;
        }
        i1 = paramMessage.arg1;
        localObject1 = paramMessage.getData().getString("senderUin");
        paramMessage = (ApolloActionData)paramMessage.obj;
        ((ApolloResponseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231)).a(this, paramMessage.pkIds, i1, (String)localObject1);
        break;
        ((ApolloResponseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231)).a();
        break;
        aW();
        if (paramMessage.arg1 == 1) {
          this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
        break;
        bool = false;
      }
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "showAddFriendAndShield() ==== called.");
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1006) {
      str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    Object localObject;
    label215:
    LinearLayout.LayoutParams localLayoutParams1;
    label335:
    View localView;
    LinearLayout.LayoutParams localLayoutParams2;
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout == null)
    {
      rok localrok = new rok(this);
      this.jdField_c_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setId(2131361976);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setOrientation(0);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131558669));
      localLayoutParams.addRule(3, 2131363226);
      if (!this.jdField_E_of_type_Boolean) {
        break label911;
      }
      localLayoutParams.topMargin -= AIOUtils.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
      this.jdField_h_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
      if (!this.jdField_E_of_type_Boolean) {
        break label920;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837756);
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837558);
        this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getString(2131436897));
        this.jdField_h_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1006) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.f.equals("")))) {
        break label940;
      }
      this.jdField_h_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_h_of_type_AndroidWidgetTextView.setClickable(false);
      this.jdField_h_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimension(2131558422));
      this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.jdField_h_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources()));
      this.jdField_h_of_type_AndroidWidgetTextView.setOnClickListener(localrok);
      localLayoutParams1 = new LinearLayout.LayoutParams(0, -1);
      localLayoutParams1.weight = 1.0F;
      localView = new View(this.jdField_a_of_type_AndroidContentContext);
      localLayoutParams2 = new LinearLayout.LayoutParams(1, -1);
      this.jdField_i_of_type_AndroidWidgetTextView = new DrawableCenterTextView(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_i_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131433386));
      this.jdField_i_of_type_AndroidWidgetTextView.setTextSize(0, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558422));
      if (!this.jdField_E_of_type_Boolean) {
        break label959;
      }
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837550);
      label518:
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject, null, null, null);
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(AIOUtils.a(8.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_i_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_i_of_type_AndroidWidgetTextView.getText());
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(localrok);
      this.jdField_i_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(3));
      localObject = new LinearLayout.LayoutParams(0, -1);
      ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
      if (!this.jdField_E_of_type_Boolean) {
        break label976;
      }
      localView.setBackgroundColor(Color.parseColor("#d3d5dc"));
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837755));
      this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837755));
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131494254));
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494254));
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_h_of_type_AndroidWidgetTextView, localLayoutParams1);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(localView, localLayoutParams2);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.addView(this.jdField_i_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject);
      this.jdField_d_of_type_AndroidViewViewGroup.addView(this.jdField_c_of_type_AndroidWidgetLinearLayout, localLayoutParams);
      if (ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo))
      {
        this.jdField_h_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131436897));
        this.jdField_h_of_type_AndroidWidgetTextView.setTag(Integer.valueOf(4));
      }
      ThreadManager.post(new rou(this, str), 8, null, true);
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        int i2 = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131558669) + (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131558448);
        int i1 = i2;
        if (this.jdField_E_of_type_Boolean) {
          i1 = i2 - AIOUtils.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
        }
        ((RelativeLayout.LayoutParams)localObject).topMargin = i1;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      return;
      label911:
      localLayoutParams.topMargin = 0;
      break;
      label920:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837759);
      break label215;
      label940:
      this.jdField_h_of_type_AndroidWidgetTextView.setEnabled(true);
      this.jdField_h_of_type_AndroidWidgetTextView.setClickable(true);
      break label335;
      label959:
      localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837553);
      break label518;
      label976:
      this.jdField_h_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDrawable(2130837754));
      this.jdField_i_of_type_AndroidWidgetTextView.setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837754));
      localView.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131494143));
      this.jdField_h_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getColorStateList(2131494253));
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494253));
    }
  }
  
  public void i(int paramInt)
  {
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.runOnUiThread(new rot(this, paramInt));
  }
  
  public void i(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getExtras();
    paramIntent.getStringExtra("uin");
    paramIntent.getIntExtra("uintype", -1);
    boolean bool = paramIntent.getBooleanExtra("isNeedUpdate", false);
    this.jdField_H_of_type_Boolean = false;
    if ((!this.jdField_H_of_type_Boolean) || (localBundle.containsKey("forward_type"))) {
      c(paramIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "updateSession_otherThings appShareId=" + localBundle.getLong("res_share_id", 0L));
      }
      return;
      if ((this.jdField_d_of_type_Int != 0) || (bool)) {
        a(true, false);
      } else if (localBundle.getLong("res_share_id", 0L) > 0L) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramIntent);
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    boolean bool6 = r();
    if ((!bool6) && (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext)))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131432961, 0).a();
      return;
    }
    this.jdField_A_of_type_Boolean = true;
    this.aa = true;
    this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rmm(this), 3000L);
    boolean bool1 = false;
    Object localObject1 = (RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
    Object localObject2 = ((RedTouchManager)localObject1).a("103100.103500.103501");
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "<hongdian> aioShortVideoFilterPath=" + "103100.103500.103501" + "   reddotInfo=" + localObject2);
    }
    if (localObject2 != null)
    {
      if (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() != 1) {
        break label704;
      }
      bool2 = true;
      label157:
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.aio.BaseChatPie", 2, "<hongdian> reddotInfo.iNewFlag.get()=" + ((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() + "   showRedDot=" + bool2);
        bool1 = bool2;
      }
    }
    localObject2 = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_sp", 4);
    boolean bool3 = ((SharedPreferences)localObject2).getBoolean("flow_filter_reddot_key", false);
    if (bool3)
    {
      ((RedTouchManager)localObject1).b("103100.103500.103501");
      ((SharedPreferences)localObject2).edit().putBoolean("flow_filter_reddot_key", false).commit();
    }
    for (boolean bool2 = false;; bool2 = bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "<hongdian> showRedDot=" + bool2 + " currentClicked=" + bool3);
      }
      bool1 = BaseApplicationImpl.getApplication().getSharedPreferences("flow_filter_reddot_pkg_sp" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 4).getBoolean("flow_filter_reddot_key", false);
      if (!bool1) {}
      for (bool3 = true;; bool3 = false)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "<hongdian> needShowRedPkg=" + bool3 + "  clicked=" + bool1);
        }
        ShortVideoMtaReport.a("shortvideo_entry", null);
        boolean bool7 = PtvFilterSoLoad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
        localObject2 = PlusPanelUtils.a(AppConstants.aQ);
        PlusPanelUtils.a(AppConstants.aQ);
        boolean bool4;
        label467:
        long l1;
        boolean bool5;
        if ((bool6) && ((bool7) || (PtvFilterSoLoad.a(this.jdField_a_of_type_AndroidContentContext) == 0)))
        {
          bool4 = true;
          StatisticCollector.a(BaseApplication.getContext()).a(null, "actShortVideoSoDownload", bool4, -1L, 0L, null, null, false);
          l1 = 0L;
          bool5 = false;
          if (!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
            break label1349;
          }
          localObject1 = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
          if (!((BabyQHandler)localObject1).a(3)) {
            break label715;
          }
          bool1 = true;
          ((BabyQHandler)localObject1).b();
          label538:
          l1 = ((BabyQHandler)localObject1).a();
        }
        for (;;)
        {
          if (CaptureUtil.a())
          {
            localObject1 = new AIOEffectsCameraCaptureFragment.Session(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString);
            if (bool6)
            {
              CameraCaptureActivity.a(this.jdField_a_of_type_AndroidContentContext, AIOEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a((AIOEffectsCameraCaptureFragment.Session)localObject1, 10000, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getClass().getName(), l1, bool1));
              ShortVideoErrorReport.a(0);
            }
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8006A11", "0X8006A11", 0, 0, "", "", "", "");
            if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
              MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            }
            if (PeakUtils.a == null) {
              break;
            }
            PeakUtils.a.b();
            return;
            label704:
            bool2 = false;
            break label157;
            bool4 = false;
            break label467;
            label715:
            bool1 = bool5;
            if (ShortVideoUtils.f()) {
              break label538;
            }
            bool1 = bool5;
            if (!((BabyQHandler)localObject1).a(0)) {
              break label538;
            }
            ((BabyQHandler)localObject1).b();
            bool1 = bool5;
            break label538;
            ShortVideoErrorReport.a(1);
            localObject1 = CameraCaptureActivity.a(this.jdField_a_of_type_AndroidContentContext, AIOEffectsCameraCaptureFragment.class.getName(), AIOEffectsCameraCaptureFragment.a((AIOEffectsCameraCaptureFragment.Session)localObject1, 10000, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getClass().getName(), l1, bool1));
            CaptureSoDownloadActivity.a(this.jdField_a_of_type_AndroidContentContext, AIOEffectsCameraCaptureFragment.class.getName(), ((Intent)localObject1).getExtras());
            continue;
            if (bool4)
            {
              localObject1 = NewFlowCameraActivity.class;
              if (CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString)) {
                localObject1 = MX3FlowNewCameraActivity.class;
              }
              localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject1);
              PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", (String)localObject2).commit();
              ((Intent)localObject1).putExtra("qcamera_photo_filepath", (String)localObject2);
              ((Intent)localObject1).putExtra("support_photo_merge", true);
              ((Intent)localObject1).putExtra("video_min_frame_count", 3);
              ((Intent)localObject1).putExtra("recapture", paramBoolean);
              ((Intent)localObject1).putExtra("activity_start_time", SystemClock.elapsedRealtime());
              ((Intent)localObject1).putExtra("PhotoConst.MY_UIN", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
              ((Intent)localObject1).putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              ((Intent)localObject1).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
              ((Intent)localObject1).putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
              ((Intent)localObject1).putExtra("flow_show_filter_red", bool2);
              ((Intent)localObject1).putExtra("flow_show_filter_red_pkg", bool3);
              q((Intent)localObject1);
              ((Intent)localObject1).putExtra("edit_video_type", 10000);
              ((Intent)localObject1).putExtra("entrance_type", 100);
              ((Intent)localObject1).putExtra("flow_camera_video_mode", true);
              ((Intent)localObject1).putExtra("flow_camera_use_filter_function", bool7);
              ((Intent)localObject1).putExtra("flow_camera_use_3dfilter_function", NativeSoLoader.a(false));
              ((Intent)localObject1).putExtra("f_a_a_n", this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getClass().getName());
              ((Intent)localObject1).putExtra("key_activity_code", ChatActivityUtils.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity));
              if (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
              {
                localObject2 = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
                if (!((BabyQHandler)localObject2).a(3)) {
                  break label1203;
                }
                ((Intent)localObject1).putExtra("show_guide_view", true);
                ((BabyQHandler)localObject2).b();
              }
              for (;;)
              {
                ((Intent)localObject1).putExtra("babyq_ability", ((BabyQHandler)localObject2).a());
                ShortVideoErrorReport.a(0);
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject1, 11000);
                break;
                label1203:
                if ((!ShortVideoUtils.f()) && (((BabyQHandler)localObject2).a(0))) {
                  ((BabyQHandler)localObject2).b();
                }
              }
            }
            ShortVideoErrorReport.a(1);
            localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, NewPreFlowCamera.class);
            ((Intent)localObject1).putExtra("qcamera_photo_filepath", (String)localObject2);
            ((Intent)localObject1).putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
            ((Intent)localObject1).putExtra("support_photo_merge", true);
            ((Intent)localObject1).putExtra("video_min_frame_count", 3);
            ((Intent)localObject1).putExtra("flow_show_filter_red", bool2);
            ((Intent)localObject1).putExtra("flow_show_filter_red_pkg", bool3);
            ((Intent)localObject1).putExtra("edit_video_type", 10000);
            ((Intent)localObject1).putExtra("entrance_type", 100);
            this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject1, 11000);
          }
          label1349:
          bool1 = false;
        }
      }
    }
  }
  
  public boolean i()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b());
  }
  
  public void j()
  {
    if (this.jdField_c_of_type_AndroidWidgetLinearLayout != null) {
      this.jdField_c_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    int i1;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      i1 = (int)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getDimension(2131558448);
      if (!this.jdField_E_of_type_Boolean) {
        break label89;
      }
      i1 -= AIOUtils.a(3.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
    }
    label89:
    for (;;)
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      localLayoutParams.topMargin = i1;
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  public void j(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(true);
    if ((this.jdField_v_of_type_Boolean) || (this.I)) {
      QLog.d("Q.aio.BaseChatPie", 1, "onShowFirst return|" + paramInt + " hasDestory:" + this.I);
    }
    do
    {
      return;
      StartupTracker.a("AIO_SysMsgCost", "AIO_onShow_first");
      this.jdField_v_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "AIOTime onShowFirst|" + paramInt);
      }
      AIOUtils.a(false);
      r(false);
      b(131072);
      k();
      l();
      p(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent());
      f(true);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) && (Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        ThreadManager.executeOnSubThread(new rpf(this), true);
      }
      rpg localrpg = new rpg(this);
      if (AppSetting.jdField_d_of_type_Boolean) {
        ThreadManager.executeOnSubThread(localrpg, true);
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener != null) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.a(false, 0);
        }
        aX();
        X();
        SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        StartupTracker.a(null, "AIO_apolloSurface");
        if (!a())
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.aio.BaseChatPie", 2, "remove footerview for initApolloSurfaceView failed");
          }
        }
        o();
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.f();
        }
        ArkTipsManager.a().a(this);
        StartupTracker.a("AIO_apolloSurface", null);
        DuiButtonImageView.a();
        StartupTracker.a("AIO_onShow_first", null);
        ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (Build.VERSION.SDK_INT >= 26) {}
        try
        {
          View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.jdField_a_of_type_ComTencentWidgetXEditTextEx, new Object[] { Integer.valueOf(8) });
          CustomizeStrategyFactory.a().a(true);
          if (!PokePanel.jdField_c_of_type_Boolean)
          {
            this.jdField_a_of_type_JavaLangRunnable = new rpi(this);
            ThreadManager.executeOnSubThread(this.jdField_a_of_type_JavaLangRunnable);
          }
          if (!PokeItemHelper.jdField_b_of_type_Boolean)
          {
            ThreadManager.executeOnSubThread(new rpj(this));
            return;
            localrpg.run();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.w("Q.aio.BaseChatPie", 2, "disable auto fill error", localException);
          }
        }
      }
    } while (PEPanelHelper.jdField_a_of_type_Boolean);
    ThreadManager.executeOnSubThread(new rpk(this));
  }
  
  protected void j(Intent paramIntent)
  {
    if (paramIntent == null) {}
    do
    {
      int i1;
      do
      {
        do
        {
          Bundle localBundle;
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "uploadPreviewPhoto");
            }
            ImageUtil.a(-1L, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, true, "image_send_prepare", "ChatActivity.uploadPreviewPhoto:request=" + paramIntent.getIntExtra(AlbumConstants.h, -1));
            localBundle = null;
            if (paramIntent != null) {
              localBundle = paramIntent.getExtras();
            }
          } while (localBundle == null);
          if (localBundle.getBoolean("deleteImage", false))
          {
            a(true, false);
            return;
          }
          i1 = paramIntent.getIntExtra(AlbumConstants.h, -1);
        } while ((i1 != 2) && (i1 != 1));
        paramIntent = paramIntent.getParcelableArrayListExtra("imageInfos");
      } while ((paramIntent == null) || (paramIntent.isEmpty()));
      if (paramIntent.size() == 1)
      {
        if (i1 == 1)
        {
          d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 1);
          return;
        }
        d(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 2);
        return;
      }
    } while (paramIntent.size() <= 1);
    a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_c_of_type_Int, 4, "" + paramIntent.size());
  }
  
  public void j(boolean paramBoolean)
  {
    Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if (paramBoolean) {
      if ((localFragment != null) && (((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact != null)) {
        ((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(false, 0);
      }
    }
    while ((localFragment == null) || (((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact == null)) {
      return;
    }
    ((ChatFragment)localFragment).jdField_a_of_type_ComTencentWidgetImmersiveSystemBarCompact.setgetStatusBarVisible(true, 0);
  }
  
  public boolean j()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public void k()
  {
    if (b())
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView true");
      }
      i();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatActivity", 2, "updateAddFriendAndShieldView false");
    }
    j();
  }
  
  @TargetApi(11)
  public void k(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, " setInputStat start stat = " + paramInt + " mInputStat= " + this.jdField_e_of_type_Int + " currenttime:" + System.currentTimeMillis());
    }
    if (paramInt != this.jdField_e_of_type_Int)
    {
      if (paramInt != 1) {
        break label347;
      }
      if (this.jdField_l_of_type_AndroidWidgetTextView == null)
      {
        Button localButton = new Button(this.jdField_a_of_type_AndroidContentContext);
        localButton.setId(2131361892);
        localButton.setBackgroundResource(2130845662);
        localButton.setTextSize(2, 14.0F);
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131494200));
        localButton.setText(2131433761);
        localButton.setOnTouchListener(this);
        int i1 = ((ViewGroup)this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getParent()).indexOfChild(this.jdField_a_of_type_ComTencentWidgetXEditTextEx);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.weight = 1.0F;
        this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(localButton, i1, localLayoutParams);
        this.jdField_l_of_type_AndroidWidgetTextView = localButton;
      }
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(0);
      if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
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
      this.jdField_e_of_type_Int = paramInt;
      aa();
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, " setInputStat end currenttime:" + System.currentTimeMillis());
      }
      return;
      label347:
      if (paramInt != 2) {
        break;
      }
      Z();
    }
    if (this.jdField_l_of_type_AndroidWidgetTextView != null) {
      this.jdField_l_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_f_of_type_AndroidWidgetTextView != null) {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(0);
    if ((this.jdField_r_of_type_Int <= 0) || (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() > 0)) {
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setEnable(8, true);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(true);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(true);
      if (!VersionUtils.e()) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setChildAlpha(8, 1.0F);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setAlpha(1.0F);
      break;
      this.jdField_a_of_type_ComTencentWidgetPatchedButton.setEnabled(false);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  public boolean k()
  {
    return this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != 0;
  }
  
  public void l()
  {
    if (((Boolean)SkinEngine.getInstances().getThemeConfig("aio_big_input_bar", Boolean.FALSE)).booleanValue())
    {
      localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363477);
      ((View)localObject).setBackgroundResource(2130838349);
      ((View)localObject).setVisibility(0);
      localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setVisible(false, false);
      }
      return;
    }
    Object localObject = this.jdField_b_of_type_AndroidWidgetLinearLayout.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).setVisible(true, false);
    }
    this.jdField_b_of_type_AndroidWidgetLinearLayout.findViewById(2131363477).setVisibility(8);
  }
  
  public void l(int paramInt)
  {
    EmojiHomeUiPlugin.openEmojiHomePage(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramInt);
    if (6 == paramInt) {
      ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiTianjia", 0, 0, "", "", "", "");
    }
    while (9 != paramInt) {
      return;
    }
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbGiftClick", 0, 0, "", "", "", "");
  }
  
  public void l(boolean paramBoolean)
  {
    if (((a() instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int != 2)) {
      return;
    }
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
    localAIOAnimationControlManager.a(this);
    if (paramBoolean) {
      localAIOAnimationControlManager.b();
    }
    localAIOAnimationControlManager.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getSharedPreferences("AIOAnimationControlManager_limit_key", 4));
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "playTroopGiftAnimationPlayList");
    }
    this.jdField_a_of_type_MqqOsMqqHandler.post(new rmp(this, localAIOAnimationControlManager, paramBoolean));
  }
  
  public boolean l()
  {
    return b() == 1008;
  }
  
  protected void m()
  {
    StartupTracker.a(null, "AIO_apolloFooterview");
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getIntExtra("uintype", -1);
    if (((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) || ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) && (1 == ApolloManager.c("discuss")))) && (ApolloManager.jdField_b_of_type_Boolean) && (1 == ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())) && (!((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (!SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (SpriteUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.a(AIOUtils.a(46.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), false, "initUI");
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "add apollo footerview on init UI");
      }
    }
    StartupTracker.a("AIO_apolloFooterview", null);
  }
  
  public void m(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.shakemsg", 2, "beforeVibrate() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new rrd(this));
    }
  }
  
  public void m(boolean paramBoolean)
  {
    r(paramBoolean);
  }
  
  public boolean m()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)) {
      bool = false;
    }
    return bool;
  }
  
  public void n() {}
  
  public void n(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.b(paramInt);
    }
  }
  
  public void n(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setIsInMultiScreen(paramBoolean);
    }
  }
  
  public boolean n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MyOnGestureListener", 2, "shouldRecordPositionY ");
    }
    this.jdField_F_of_type_Int = this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a();
    if (this.jdField_F_of_type_Int == 1)
    {
      if (!((InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method")).isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx))
      {
        this.W = false;
        return true;
      }
    }
    else if ((this.jdField_F_of_type_Int == 0) || ((this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a().getVisibility() != 0)))
    {
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getVisibility() == 0) {
        this.W = false;
      }
      return true;
    }
    return false;
  }
  
  public void o() {}
  
  public void o(int paramInt)
  {
    int i1 = -1;
    if (paramInt == 0) {
      i1 = ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.b(i1);
      }
      this.jdField_D_of_type_Int = i1;
      as();
      return;
      if (paramInt == 1) {
        i1 = 7;
      }
    }
  }
  
  public boolean o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar = new TimTipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTimTipsBar, new Object[0]);
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 != 2131363483) && (i1 != 2131363479) && (this.K))
    {
      ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      this.K = false;
    }
    if ((i1 != 2131363227) && (i1 != 2131363970) && (i1 != 2131363971) && (i1 != 2131363976)) {
      AIOUtils.jdField_m_of_type_Boolean = true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0) && (i1 != 2131362057) && (i1 != 2131365573))
    {
      if (QLog.isColorLevel()) {
        QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
      }
      a(true);
    }
    switch (i1)
    {
    }
    for (;;)
    {
      i1 = 1;
      for (;;)
      {
        label314:
        if ((this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) && (i1 != 0)) {
          this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.g();
        }
        label581:
        label596:
        do
        {
          do
          {
            do
            {
              return;
              if (BaseChatItemLayout.jdField_a_of_type_Boolean)
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
                  localObject1 = (String[])paramView;
                  if ((paramView != null) && ("comic".equals(localObject1[0]))) {
                    VipComicReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "3006", "2", "40025", localObject1[1], new String[] { "1" });
                  }
                  i1 = 1;
                }
                catch (Exception paramView)
                {
                  paramView.printStackTrace();
                  i1 = 1;
                }
                e(false);
              }
              break;
              if ((this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel.b())) {
                break label596;
              }
              if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString().length() <= 20) {
                break label581;
              }
            } while (System.currentTimeMillis() - this.jdField_f_of_type_Long < 2000L);
            this.jdField_f_of_type_Long = System.currentTimeMillis();
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, "动效消息长度不能超过20个字符。", 0).b(a());
            return;
            this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(28, false);
            i1 = 1;
            break label314;
            this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel.d();
            i1 = 1;
            break label314;
            if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 0) {
              this.S = true;
            }
            s();
            if (QLog.isDevelopLevel()) {
              QLog.d("reportEvent", 4, " curType : " + this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int + ", mEntryFriendCard: " + this.S);
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80040EA", "0X80040EA", 0, 0, ChatActivityUtils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), "", "", "");
            i1 = 1;
            break label314;
            ApolloManager.jdField_a_of_type_JavaUtilArrayList.clear();
            this.jdField_m_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount();
            if (this.jdField_m_of_type_Int > 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
              this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.b();
              this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setSelectionFromBottom(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getCount() - 1, 0);
            }
            paramView.setVisibility(8);
            i1 = 1;
            break label314;
            long l1 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn start mInputStat = " + this.jdField_e_of_type_Int + " text.length " + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + " currentPanel:" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() + " currenttime:" + System.currentTimeMillis());
            }
            o(true);
            ak();
            if (!QLog.isColorLevel()) {
              break;
            }
            long l2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, " onClick fun_btn end mInputStat = " + this.jdField_e_of_type_Int + "text.length" + this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() + "cast time :" + (l2 - l1));
            }
            i1 = 1;
            break label314;
            localObject1 = (Intent)paramView.getTag();
            ((Intent)localObject1).putExtra("message_box_click", true);
            MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
            paramView.setVisibility(8);
            if (this.jdField_p_of_type_AndroidViewView != null) {
              this.jdField_p_of_type_AndroidViewView.setVisibility(8);
            }
            i1 = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, (Intent)localObject1);
            if (i1 == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.BaseChatPie", 2, "openAIO by start SplashAct");
              }
              this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity((Intent)localObject1);
            }
            while (i1 != 2)
            {
              if ((((Intent)localObject1).getBooleanExtra("finishAIO", false)) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof ChatActivity))) {
                this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
              }
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Q.aio.BaseChatPie", 2, " onClick R.id.msgbox ");
              i1 = 1;
              break label314;
            }
            QLog.e("Q.aio.BaseChatPie", 1, "openAIO rediectToAIOWithMt 2");
            return;
            paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (!this.jdField_k_of_type_Boolean) {}
            for (boolean bool = true;; bool = false)
            {
              paramView.e(bool);
              this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.c();
              i1 = 1;
              break;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B6", "0X80059B6", 0, 0, "", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", AIOShareActionSheet.jdField_c_of_type_JavaLangString, AIOShareActionSheet.jdField_c_of_type_JavaLangString, 0, 0, "", "", "", "");
          } while ((ChatActivityFacade.b != null) && (ChatActivityFacade.b.isShowing()));
          paramView = MultiMsgManager.a().a();
          if (paramView.size() != 0) {
            break label1412;
          }
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433406, 0).b(a());
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "0", "", "", "");
        } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 1008);
        paramView = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, paramView, "1", "", "");
        return;
        label1412:
        MultiMsgManager.a().b(paramView);
        if (QLog.isDevelopLevel()) {
          QLog.d("MultiMsg", 4, "checklist.size = " + paramView.size());
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80059B7", "0X80059B7", 0, 0, "" + paramView.size(), "", "", "");
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1008)
        {
          localObject1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis()));
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Pb_account_lifeservice", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X80064F9", "0X80064F9", 0, 0, (String)localObject1, "0", "", "");
        }
        ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramView);
        i1 = 1;
        continue;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80067F6", "0X80067F6", 0, 0, "", "", "", "");
        if (!NetworkUtil.d(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131432992, 0).b(a());
          return;
        }
        Object localObject2 = MultiMsgManager.a().a();
        if (((List)localObject2).size() == 0)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433406, 0).b(a());
          return;
        }
        Object localObject1 = null;
        i1 = 0;
        for (;;)
        {
          paramView = (View)localObject1;
          if (i1 < ((List)localObject2).size())
          {
            paramView = (ChatMessage)((List)localObject2).get(i1);
            if ((!(paramView instanceof MessageForMarketFace)) && (!(paramView instanceof MessageForPic))) {}
          }
          else
          {
            if (paramView != null) {
              break;
            }
            QLog.e("Q.aio.BaseChatPie", 1, "add to custom face, no market face message or pic message selected");
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131433406, 0).b(a());
            return;
          }
          i1 += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 1, "add to custom face, selected message=" + paramView);
        }
        if ((paramView instanceof MessageForPic))
        {
          paramView = (MessageForPic)paramView;
          localObject1 = URLDrawableHelper.a(URLDrawableHelper.a(paramView, 1), -1, -1, null, null, false);
          ((URLDrawable)localObject1).setTag(paramView);
          AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (URLDrawable)localObject1, paramView.frienduin, this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448), null, null);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "3", "", "", "");
        }
        for (;;)
        {
          a(false, null, false);
          i1 = 1;
          break;
          if ((paramView instanceof MessageForMarketFace))
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006448", "0X8006448", 0, 0, "4", "", "", "");
            localObject2 = (MessageForMarketFace)paramView;
            paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
            if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
            {
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131436072));
              this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
            }
            localObject1 = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((MessageForMarketFace)localObject2).mMarkFaceMessage);
            EmoticonPackage localEmoticonPackage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(((PicEmoticonInfo)localObject1).a.epId);
            MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage = (ChatMessage)localObject2;
            MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = (PicEmoticonInfo)localObject1;
            if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
            {
              i1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
              int i2 = (int)(System.currentTimeMillis() / 1000L);
              if ((i2 - i1 > 86400) || (i2 < i1))
              {
                localObject2 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
                ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject2).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (PicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
                EmojiListenerManager.a().a((EmotionJsonDownloadListener)localObject2);
                ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(((PicEmoticonInfo)localObject1).a.epId, EmojiManager.jdField_b_of_type_Int);
              }
              else
              {
                MarketFaceItemBuilder.a(6, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localEmoticonPackage, (PicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
              }
            }
            else
            {
              localObject2 = new MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars();
              ((MarketFaceItemBuilder.EmoticonDetailJsonDownloaderVars)localObject2).a(6, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (PicEmoticonInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramView);
              EmojiListenerManager.a().a((EmotionJsonDownloadListener)localObject2);
              ((EmojiManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(42)).a(((PicEmoticonInfo)localObject1).a.epId, EmojiManager.jdField_b_of_type_Int);
            }
          }
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", AIOShareActionSheet.jdField_d_of_type_JavaLangString, AIOShareActionSheet.jdField_d_of_type_JavaLangString, 0, 0, "", "", "", "");
        c(false);
        i1 = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "BaseCHatPie onClick call enterPhotoPreivew. path = " + PlusPanelUtils.jdField_b_of_type_JavaLangString);
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004D92", "0X8004D92", 0, 0, "", "", "", "");
        PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putString("camera_photo_path", PlusPanelUtils.jdField_b_of_type_JavaLangString).commit();
        localObject1 = null;
        paramView = (View)localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null)
        {
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            paramView = (View)localObject1;
            if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
            {
              paramView = new Intent();
              paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
            }
          }
        }
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, paramView, 8);
        if (QLog.isColorLevel()) {
          QLog.d("fastimage", 2, "BaseCHatPie onClick call removeFastImage");
        }
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(33);
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout == null) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.setOnClickListener(null);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout);
        i1 = 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("Q.aio.BaseChatPie", 2, "onClick case R.id.input");
        }
        o(true);
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.c();
        i1 = 0;
        continue;
        this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a(1);
        i1 = 1;
        continue;
        if (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet == null) {
          this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet = new AIOShareActionSheet(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this, this.jdField_a_of_type_MqqOsMqqHandler);
        }
        this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.a();
        i1 = 1;
        continue;
        a(paramView);
        i1 = 1;
        continue;
        aP();
        i1 = 1;
      }
      ai();
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.e(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.b();
      GoldMsgChatHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetMobile2Wifi readconfirm network change");
    }
    if (this.Q)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetNone2Mobile readconfirm network change");
    }
    if (this.Q)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetNone2Wifi readconfirm network change");
    }
    if (this.Q)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "onNetWifi2Mobile readconfirm network change");
    }
    if (this.Q)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(16711689);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(16711689);
    }
  }
  
  public void onNetWifi2None() {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    aH();
    int i1 = paramMotionEvent.getAction();
    if ((this.jdField_d_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_d_of_type_AndroidWidgetLinearLayout.getVisibility() == 0))
    {
      this.jdField_d_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) {
        this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.c();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqDoutuDoutuManager.b();
    }
    LightReplyMenuManager localLightReplyMenuManager = LightReplyMenuManager.a();
    if ((localLightReplyMenuManager != null) && (localLightReplyMenuManager.b())) {
      localLightReplyMenuManager.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewFastImagePreviewLayout.getVisibility() == 0)) {
      a(true);
    }
    switch (paramView.getId())
    {
    default: 
      return false;
    case 2131363489: 
      if (this.K)
      {
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
        this.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130837620);
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
    case 2131363479: 
      if ((this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel.b())) {
        this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatPanel.d();
      }
      o(true);
      return false;
    }
    a(paramView, paramMotionEvent);
    return true;
  }
  
  public void p()
  {
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void p(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {}
    FriendsManager localFriendsManager;
    do
    {
      do
      {
        return;
      } while (this.jdField_d_of_type_Boolean);
      if (paramInt != -1)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setCurrentPannel(paramInt, false);
        return;
      }
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1))
      {
        b(localFriendsManager);
        return;
      }
    } while (!x());
    a(localFriendsManager);
  }
  
  public final boolean p()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a() == 0);
  }
  
  public void q()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.setAllUnSelected();
    if ((4 == this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.a(false);
    }
    if (this.jdField_j_of_type_AndroidViewView != null) {
      this.jdField_j_of_type_AndroidViewView.setVisibility(0);
    }
    if (this.jdField_k_of_type_AndroidViewView != null) {
      this.jdField_k_of_type_AndroidViewView.setVisibility(0);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null) && (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 22)) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.jdField_p_of_type_Boolean = true;
    }
  }
  
  public void q(int paramInt)
  {
    if (jdField_y_of_type_Int == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("vivo", 2, "setVivoSetting isButtom=" + paramInt);
      }
      ThreadManager.getSubThreadHandler().post(new rmd(this, paramInt));
    }
  }
  
  public boolean q()
  {
    boolean bool = false;
    if (((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isResume()) || (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isInMultiWindow()))) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 6) || (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 5)) {
      bool = true;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && (QLog.isColorLevel())) {
      QLog.d("Q.aio.BaseChatPie", 2, "isActivityResume = " + bool);
    }
    return bool;
  }
  
  protected void r()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText("");
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager = DraftTextManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_o_of_type_Boolean = true;
    ThreadManager.post(new GetTextDraftJob(this.jdField_a_of_type_MqqOsMqqHandler, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqManagersDraftTextManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this), 8, null, true);
  }
  
  public void r(int paramInt)
  {
    Object localObject = FlowCameraActivity2.class;
    if (CameraCompatibleList.d(CameraCompatibleList.jdField_c_of_type_JavaLangString)) {
      localObject = MX3FlowCameraActivity.class;
    }
    localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, (Class)localObject);
    ((Intent)localObject).putExtra("flow_camera_height", XPanelContainer.jdField_a_of_type_Int);
    ((Intent)localObject).putExtra("selected_item", 5);
    ((Intent)localObject).putExtra("selected_data", this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout.a());
    ((Intent)localObject).putExtra("PhotoConst.SEND_SESSION_INFO", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    ((Intent)localObject).putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
    ((Intent)localObject).putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
    q((Intent)localObject);
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
      if (MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b()) {
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
  
  public boolean r()
  {
    if (ShortVideoUtils.a()) {}
    do
    {
      return true;
      ShortVideoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    } while (ShortVideoUtils.a());
    return false;
  }
  
  public void s()
  {
    if ((Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (Utils.a(this.jdField_a_of_type_AndroidContentContext))) {
      return;
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, ChatSettingActivity.class);
    localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString);
    localIntent.putExtra("uintype", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 2000);
  }
  
  public void s(int paramInt)
  {
    if (paramInt < 0)
    {
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(true);
      q(1);
      this.jdField_D_of_type_Boolean = true;
    }
  }
  
  public boolean s()
  {
    return (this.jdField_g_of_type_AndroidWidgetTextView != null) && (this.jdField_g_of_type_AndroidWidgetTextView.getVisibility() == 0);
  }
  
  public void setting()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, EmosmActivity.class);
    localIntent.putExtra("extra_launch_source", 1);
    localIntent.putExtra("extra_launch_mode", 2);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivity(localIntent);
    ReportController.b(null, "CliOper", "", "", "MbGuanli", "MbDianjiGuanli", 0, 0, "", "", "", "");
  }
  
  void t()
  {
    int i1;
    Object localObject;
    String str1;
    if ((this.jdField_c_of_type_Boolean) && (!BaseChatItemLayout.jdField_a_of_type_Boolean))
    {
      int i2 = QCallFacade.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      i1 = 0;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localObject != null) {
        i1 = ((QQMessageFacade)localObject).b();
      }
      i1 += i2;
      localObject = "";
      if (i1 <= 0) {
        break label172;
      }
      localObject = "" + i1;
      if (i1 > 99) {
        localObject = "99+";
      }
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433280) + "(" + (String)localObject + ")";
    }
    for (String str2 = "返回" + this.jdField_a_of_type_AndroidContentContext.getString(2131433280) + i1 + "条未读";; str2 = "返回" + this.jdField_a_of_type_AndroidContentContext.getString(2131433280))
    {
      a(str1, str2, (String)localObject);
      return;
      label172:
      str1 = this.jdField_a_of_type_AndroidContentContext.getString(2131433280);
    }
  }
  
  public void t(int paramInt)
  {
    this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(paramInt);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    if (paramInt == 0)
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(8);
      if (localLayoutParams != null)
      {
        localLayoutParams.setMargins(0, 0, 0, 0);
        this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      }
      return;
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setVisibility(0);
    if (localLayoutParams != null)
    {
      int i1 = this.jdField_e_of_type_AndroidWidgetImageView.getWidth();
      paramInt = i1;
      if (i1 == 0) {
        paramInt = AIOUtils.a(21.0F, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
      }
      localLayoutParams.setMargins(paramInt, 0, 0, 0);
      this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    }
    AIOUtils.a(this.jdField_e_of_type_AndroidWidgetImageView, (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F), (int)(this.jdField_a_of_type_Float * 5.0F + 0.5F));
  }
  
  public boolean t()
  {
    return false;
  }
  
  public void u()
  {
    if (!GoldMsgChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130845772, 2130845773);
    }
  }
  
  public void u(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer != null) {
      this.jdField_a_of_type_ComTencentBizTroopgiftAIOGiftPanelContainer.a(paramInt);
    }
  }
  
  public boolean u()
  {
    if (!this.jdField_C_of_type_Boolean) {
      return false;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = ((Intent)localObject1).getStringExtra("panel");
      if ((localObject2 != null) && (((String)localObject2).equals("ptv"))) {
        return false;
      }
      if (((Intent)localObject1).getBooleanExtra("PhotoConst.SEND_FLAG", false)) {
        return false;
      }
    }
    long l2 = 80L;
    long l1 = l2;
    if (localObject1 != null)
    {
      l1 = l2;
      if (((Intent)localObject1).getExtras() != null)
      {
        l1 = l2;
        if (((Intent)localObject1).getExtras().containsKey("forward_type")) {
          l1 = 800L;
        }
      }
    }
    if (this.jdField_w_of_type_Boolean) {
      l1 = 300L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("inputx", 2, "autoShowInput delayTime=" + l1);
      }
      int i2 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("aio_autoinput_time", 900);
      if (QLog.isColorLevel()) {
        QLog.i("inputx", 2, "autoShowInput auto_time=" + i2);
      }
      if (i2 <= 0) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {
        return false;
      }
      if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("inputx", 2, "autoShowInput return currentPanle=" + this.jdField_a_of_type_ComTencentWidgetXPanelContainer.a());
        }
        return true;
      }
      if (this.jdField_B_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("inputx", 2, "autoShowInput return hasAutoInput");
        }
        return true;
      }
      long l3 = NetConnInfoCenter.getServerTime();
      localObject2 = a();
      int i1 = ((List)localObject2).size() - 1;
      if (i1 >= 0)
      {
        localObject1 = (ChatMessage)((List)localObject2).get(i1);
        if ((localObject1 instanceof MessageForGrayTips)) {}
      }
      for (;;)
      {
        if (localObject1 != null) {
          if ((!((ChatMessage)localObject1).isSend()) || (((ChatMessage)localObject1).msgtype == -2002))
          {
            return false;
            i1 -= 1;
            break;
          }
        }
        for (l2 = ((ChatMessage)localObject1).time;; l2 = -1L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("inputx", 2, "lastMsgTimeOrSeq=" + l2 + "currentTime=" + l3 + "diff=" + (l3 - l2));
          }
          if ((l2 != -1L) && (l3 - l2 < i2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("inputx", 2, "SOFT_INPUT_PANEL!!!!!!!!!!!");
            }
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(59), l1);
            this.jdField_B_of_type_Boolean = true;
            return true;
          }
          return false;
        }
        localObject1 = null;
      }
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null) && ((this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity instanceof SplashActivity))) {
      if (!this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {}
    }
    Object localObject;
    label323:
    label364:
    do
    {
      do
      {
        do
        {
          return;
          paramObservable = ((SplashActivity)this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
        } while ((paramObservable != null) && (!paramObservable.isVisible()));
      } while (paramObject == null);
      if (!(paramObject instanceof MessageRecord)) {
        break label1859;
      }
      if (!(paramObject instanceof ChatMessage)) {
        break label1814;
      }
      paramObservable = (MessageRecord)paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "update mr.msgseq" + paramObservable.msgseq + ",time is:" + System.currentTimeMillis() + " status:" + paramObservable.extraflag);
      }
      if ((32768 != paramObservable.extraflag) && ((paramObservable instanceof MessageForApollo))) {
        ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a((MessageForApollo)paramObservable, "aio");
      }
      if (q())
      {
        if (((paramObservable instanceof MessageForUniteGrayTip)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.senderuin)) && (ConfessMsgUtil.a(paramObservable.istroop, paramObservable.getConfessTopicId(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int)))
        {
          localObject = (MessageForUniteGrayTip)paramObservable;
          String str = ((MessageForUniteGrayTip)localObject).tipParam.jdField_c_of_type_JavaLangString;
          ((MessageForUniteGrayTip)localObject).hasRead = 1;
          ((MessageForUniteGrayTip)localObject).updateUniteGrayTipMsgData(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (((MessageForUniteGrayTip)localObject).tipParam.jdField_b_of_type_Int == 2097153)
          {
            if (((MessageForUniteGrayTip)localObject).subType != 6) {
              break;
            }
            if (QLog.isColorLevel()) {
              QLog.d("FriendReactive", 2, "new message graytips big ship");
            }
            this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(70);
          }
        }
        AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramObservable, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner);
        if ((paramObject instanceof MessageForDeliverGiftTips))
        {
          if (((MessageForDeliverGiftTips)paramObject).isInteract()) {
            break label886;
          }
          l(false);
        }
      }
      if (paramObservable.isSendFromLocal()) {
        break label1128;
      }
      if (QLog.isColorLevel()) {
        QLog.d("sendback", 2, "update mr.isBlessMsg" + paramObservable.isBlessMsg);
      }
    } while ((paramObservable.msgtype == -1004) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.frienduin)));
    if (a(paramObservable)) {
      if (q())
      {
        if ((!paramObservable.isread) && ((paramObservable instanceof MessageForShakeWindow)))
        {
          localObject = (MessageForShakeWindow)paramObservable;
          ((MessageForShakeWindow)localObject).parse();
          if ((((MessageForShakeWindow)localObject).mShakeWindowMsg != null) && (((MessageForShakeWindow)localObject).mShakeWindowMsg.onlineFlag == 1))
          {
            if (this.jdField_b_of_type_JavaUtilList == null) {
              this.jdField_b_of_type_JavaUtilList = new ArrayList();
            }
            this.jdField_b_of_type_JavaUtilList.add(localObject);
          }
        }
        if ((!paramObservable.isread) && ((paramObservable instanceof MessageForPoke)) && (!paramObservable.isSend()))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramObservable.uniseq), (MessageForPoke)paramObservable);
          ((MessageForPoke)paramObservable).isPlayed = false;
        }
        if ((!paramObservable.isread) && (!paramObservable.isSend()) && ((paramObservable instanceof MessageForArkFlashChat))) {
          ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a((MessageForArkFlashChat)paramObservable);
        }
        M();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
          HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        }
        this.Q = true;
        this.R = true;
        if ((!paramObservable.isSend()) && (paramObservable.msgtype == -2039) && (!ApolloManager.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(paramObservable.uniseq)))) {
          ApolloManager.jdField_a_of_type_JavaUtilArrayList.add(Long.valueOf(paramObservable.uniseq));
        }
        localObject = (AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217);
        if (!paramObservable.isSend())
        {
          ((AppGuideTipsManager)localObject).a(paramObservable);
          label733:
          if ((paramObservable instanceof MessageForText)) {
            ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(271)).a((ChatMessage)paramObject);
          }
          if ((!(this instanceof PublicAccountChatPie)) || (!((PublicAccountChatPie)this).W) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLastVisiblePosition() != this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.getCount() - 1)) {
            break label933;
          }
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rnx(this), 800L);
        }
      }
      else
      {
        label815:
        this.jdField_q_of_type_Boolean = true;
      }
    }
    for (;;)
    {
      t();
      if ((paramObject == null) || ((!(paramObject instanceof MessageForStructing)) && (!(paramObject instanceof MessageForText)))) {
        break;
      }
      AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1, (ChatMessage)paramObject);
      return;
      AioAnimationDetector.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner, ((MessageForUniteGrayTip)localObject).subType, 4);
      break label323;
      label886:
      if (((a() instanceof SplashActivity)) && (SplashActivity.jdField_a_of_type_Int != 2)) {
        break;
      }
      ((AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222)).a(this);
      break label364;
      ((AppGuideTipsManager)localObject).a(this, paramObservable);
      break label733;
      label933:
      ((ChatMessage)paramObject).mMsgAnimFlag = true;
      b(196608);
      break label815;
      if (((paramObservable.istroop == 1001) || (paramObservable.istroop == 10002)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.senderuin)) && (MsgProxyUtils.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int)))
      {
        if ((String.valueOf(AppConstants.F).equalsIgnoreCase(paramObservable.frienduin)) && (!paramObservable.isread))
        {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
        }
        else
        {
          if (q())
          {
            this.R = true;
            M();
            ((ChatMessage)paramObject).mMsgAnimFlag = true;
            b(196608);
          }
          this.jdField_q_of_type_Boolean = true;
        }
      }
      else if ((q()) && (!paramObservable.isread) && ((paramObservable.msgtype != -2006) || (!(paramObject instanceof MessageForFoldMsg)))) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
      }
    }
    label1128:
    M();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) {
      HotChatUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    }
    this.Q = true;
    this.jdField_q_of_type_Boolean = true;
    if ((paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) && (ConfessMsgUtil.a(paramObservable.istroop, paramObservable.getConfessTopicId(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int)))
    {
      ((ChatMessage)paramObject).mMsgAnimFlag = true;
      if (paramObservable.msgtype == -2058) {
        break label1497;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "update need instantUpdate, msg= " + paramObservable.toString());
      }
      a(true, true);
      label1272:
      ((AppGuideTipsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(217)).a(this, paramObservable);
      if ((paramObservable instanceof MessageForText)) {
        ((AIOMessageSpreadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(271)).a((ChatMessage)paramObject);
      }
    }
    if (((paramObservable instanceof MessageForStructing)) && ((paramObservable.istroop == 1) || (paramObservable.istroop == 3000) || (paramObservable.istroop == 0))) {
      if ("viewMultiMsg".equals(((MessageForStructing)paramObservable).structingMsg.mMsgAction)) {
        MultiMsgManager.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObservable.frienduin, paramObservable.istroop, paramObservable.uniseq, true);
      }
    }
    label1463:
    label1859:
    label2116:
    for (;;)
    {
      label1391:
      if (((paramObservable instanceof ChatMessage)) && (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null))
      {
        paramObject = new SessionInfo();
        if (!paramObservable.frienduin.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
          break label1787;
        }
        paramObject.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
        paramObject.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        paramObject.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
        if (!ArkRecommendController.a(paramObject)) {
          break label1812;
        }
        paramObservable = (ChatMessage)paramObservable;
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new rnz(this, paramObservable, paramObject), 1000L);
        return;
        a(false, false);
        break label1272;
        if (((paramObservable instanceof MessageForText)) && (paramObservable.istroop == 3000) && (paramObservable.extraflag == 0))
        {
          paramObject = (MessageForText)paramObservable;
          if ((paramObject.atInfoList == null) || (paramObject.atInfoList.size() <= 0)) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006211", "0X8006211", 0, 0, "", "", "", "");
          if ((paramObject.atInfoList != null) && (paramObject.atInfoList.size() == 1))
          {
            if (((MessageForText.AtTroopMemberInfo)paramObject.atInfoList.get(0)).isIncludingAll()) {
              continue;
            }
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006212", "0X8006212", 0, 0, "", "", "", "");
            continue;
          }
          if ((paramObject.atInfoList == null) || (paramObject.atInfoList.size() <= 1)) {
            continue;
          }
          paramObject = paramObject.atInfoList.iterator();
          do
          {
            if (!paramObject.hasNext()) {
              break;
            }
          } while (!((MessageForText.AtTroopMemberInfo)paramObject.next()).isIncludingAll());
        }
      }
      label1497:
      for (int i1 = 1;; i1 = 0)
      {
        if (i1 != 0) {
          break label2116;
        }
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006213", "0X8006213", 0, 0, "", "", "", "");
        break label1391;
        if (!(paramObservable instanceof MessageForArkFlashChat)) {
          break label1391;
        }
        ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).a((MessageForArkFlashChat)paramObservable);
        break label1391;
        break;
        label1787:
        paramObject.jdField_a_of_type_Int = paramObservable.istroop;
        paramObject.jdField_a_of_type_JavaLangString = paramObservable.frienduin;
        paramObject.jdField_b_of_type_JavaLangString = paramObservable.frienduin;
        break label1463;
        break;
        paramObservable = (MessageRecord)paramObject;
        if (((paramObject instanceof DataLineMsgRecord)) && (!paramObservable.isread) && (!paramObservable.isSendFromLocal())) {
          a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a());
        }
        t();
        return;
        if ((paramObject instanceof QQMessageFacade.RefreshMessageContext))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext = ((QQMessageFacade.RefreshMessageContext)paramObject);
          paramObservable = (ChatContext)this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaLangObject;
          if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramObservable.a())) || (this.jdField_b_of_type_Long != paramObservable.a()) || (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_d_of_type_Boolean) || (!ConfessMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_f_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_e_of_type_Int))) {
            break;
          }
          paramObservable = this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_JavaUtilList;
          if ((paramObservable != null) && (paramObservable.size() > 0)) {
            this.jdField_c_of_type_Int += 1;
          }
          boolean bool;
          long l1;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppMessageQQMessageFacade$RefreshMessageContext.jdField_a_of_type_Boolean)
          {
            bool = true;
            this.P = bool;
            l1 = this.jdField_b_of_type_Long + 300L - SystemClock.uptimeMillis();
            if (l1 <= 0L) {
              break label2064;
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new roa(this), l1);
            return;
            bool = false;
            break;
            l1 = 0L;
          }
        }
        if (!(paramObject instanceof QQMessageFacade.MessageNotifyParam)) {
          break;
        }
        paramObservable = (QQMessageFacade.MessageNotifyParam)paramObject;
        if ((!paramObservable.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) || (paramObservable.jdField_a_of_type_Int != 0)) {
          break;
        }
        a(false, true);
        return;
      }
    }
  }
  
  public void v()
  {
    String str = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString, ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 3);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_d_of_type_JavaLangString = str;
  }
  
  public boolean v()
  {
    return true;
  }
  
  public void w()
  {
    if (this.jdField_a_of_type_AndroidAppDialog == null)
    {
      this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_AndroidContentContext, 2131624574);
      ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      localImageView.setBackgroundResource(2130837618);
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
      QLog.e("Q.aio.BaseChatPie", 1, "showPttMaskDialog", localException);
    }
  }
  
  public boolean w()
  {
    return this.jdField_v_of_type_Boolean;
  }
  
  public void x()
  {
    if ((this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()) && (this.jdField_a_of_type_AndroidAppDialog.getWindow() != null)) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public void y() {}
  
  @TargetApi(11)
  public void z()
  {
    if (this.I)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.aio.BaseChatPie", 2, "doOnDestroy return");
      }
      return;
    }
    this.I = true;
    if (this.jdField_G_of_type_Boolean)
    {
      this.jdField_G_of_type_Boolean = false;
      x(8);
    }
    ArkTipsManager.a().b(this);
    URLDrawable.resume();
    this.jdField_h_of_type_Int = 8;
    AIOUtils.a("Q.aio.BaseChatPie", "doOnDestroy", hashCode(), this.jdField_h_of_type_Int);
    this.jdField_x_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewChatApolloViewListener.jdField_a_of_type_Boolean = false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      b(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getOverscrollHeader());
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOFooterViewDetector.b();
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setRecyclerListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setChatPie(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOverScrollListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setShowPanelListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollListener(null);
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setOnScrollToButtomListener(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener != null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeOnLayoutChangeListener(this.jdField_a_of_type_ComTencentMobileqqApolloViewInputGlobalLayoutListener);
    }
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.b();
    }
    af();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Long = -1L;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimMoveToBottomScroller.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1 != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioChatAdapter1.c();
    }
    ArkAioContainerWrapper.a(2);
    ArkFlashChatContainerWrapper.a(2);
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.g();
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController.b();
      this.jdField_a_of_type_ComTencentMobileqqArkArkRecommendController = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr = null;
    }
    Object localObject = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    ((EmoticonManager)localObject).b();
    ((EmoticonManager)localObject).c();
    EmojiStickerManager.a().a(this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_v_of_type_Boolean);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.e();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletWidgetHongBaoPanel.onDestory();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel != null)
    {
      this.jdField_D_of_type_Int = -1;
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel.h();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloPanel = null;
    }
    ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.g();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel = null;
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.b();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodlePanel = null;
    }
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
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.b();
      this.jdField_a_of_type_ComTencentWidgetXPanelContainer.setReadyToShow(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloChatPieApolloViewController.e(this);
    }
    a(false, null, false);
    if (this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog != null)
    {
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog.dismiss();
      this.jdField_a_of_type_ComTencentBizWidgetsShareAioResultDialog = null;
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
    if (this.jdField_g_of_type_AndroidViewView != null)
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(4);
      this.jdField_g_of_type_AndroidViewView = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_d_of_type_JavaLangRunnable);
    if (this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      this.jdField_c_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(ChatActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.a();
    }
    ChatActivityUtils.b();
    ChatActivityFacade.a();
    if (this.jdField_g_of_type_AndroidWidgetTextView != null) {
      b(this.jdField_g_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_h_of_type_AndroidWidgetTextView != null) {
      b(this.jdField_h_of_type_AndroidWidgetTextView.getBackground());
    }
    if (this.jdField_i_of_type_AndroidWidgetTextView != null) {
      b(this.jdField_i_of_type_AndroidWidgetTextView.getBackground());
    }
    this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    if (this.jdField_o_of_type_AndroidWidgetTextView != null) {
      this.jdField_o_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().e();
    }
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))
    {
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -3010);
      MsgProxyUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, -4020);
    }
    if (AITranslator.a()) {
      AITranslator.a().a(this.jdField_a_of_type_AndroidContentContext, true);
    }
    MultiMsgManager.a().a();
    this.U = false;
    this.jdField_s_of_type_Int = 60;
    this.jdField_u_of_type_Int = 0;
    this.jdField_w_of_type_Int = 0;
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    AioAnimationDetector.a().a();
    ThridAppShareHelper.a().a();
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
    localObject = (InputMethodManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("input_method");
    if (this.jdField_a_of_type_ComTencentWidgetXPanelContainer != null) {
      ((InputMethodManager)localObject).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentWidgetXPanelContainer.getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity != null)
    {
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getCurrentFocus();
      if (localObject != null)
      {
        QLog.i("Q.aio.BaseChatPie", 1, localObject.toString());
        ((View)localObject).clearFocus();
      }
    }
    V = true;
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx != null)
    {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
      if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false) != null) {
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(false).clear();
      }
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(null, null, null, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131362132, null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(0);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.jdField_a_of_type_ComTencentWidgetXEditTextEx$SizeChangedCallback = null;
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnEditorActionListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnKeyListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnTouchListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnFocusChangeListener(null);
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(null);
    }
    try
    {
      if (AIOUtils.c())
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getViewTreeObserver();
        Field localField = ViewTreeObserver.class.getDeclaredField("mOnTouchModeChangeListeners");
        localField.setAccessible(true);
        localField.set(localObject, new CopyOnWriteArrayList());
        QLog.d("Q.aio.BaseChatPie", 1, "force clear mOnTouchModeChangeListeners success.");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji.a();
        this.jdField_a_of_type_ComTencentMobileqqEmoticonSogouEmoji = null;
      }
      if (this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler != null) {
        Looper.myQueue().removeIdleHandler(this.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      }
      PerformanceReportUtils.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
      PttSSCMPool.a();
      com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder.jdField_a_of_type_Long = 0L;
      if (jdField_y_of_type_Int == 1) {
        q(0);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.e();
      }
      ChatActivityUtils.a();
      ThreadPriorityManager.a(false);
      localObject = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localObject != null) {
        ((FileTransferManager)localObject).b();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a();
      }
      ApolloManager.jdField_a_of_type_JavaUtilHashSet.clear();
      QQLiveImage.releaseAll();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemStructingMsgItemBuilder$ViewCache.a();
      NowVideoController.a().c();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilHashMap.clear();
      localObject = new rnf(this);
      if (AppSetting.jdField_d_of_type_Boolean)
      {
        ThreadManager.executeOnSubThread((Runnable)localObject, true);
        BaseActivity.sActivityRoute.remove(getClass().getSimpleName());
        localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(222);
        if (localObject != null) {
          ((AIOAnimationControlManager)localObject).c();
        }
        AIOSingleReporter.a().a();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPokeAndEmoPanel.d();
        }
        aI();
        DoutuManager.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager.a();
          this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboUIManager = null;
        }
        localObject = LightReplyMenuManager.a();
        if (localObject != null) {
          ((LightReplyMenuManager)localObject).b();
        }
        HotPicPageView.c();
        PresenceInterfaceImpl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ((ApolloResponseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(231)).a();
        QIMUserManager.a().a(false);
        ReceiptMsgManager.a().a();
        if (this.jdField_s_of_type_AndroidViewView != null)
        {
          this.jdField_d_of_type_AndroidViewViewGroup.removeViewInLayout(this.jdField_s_of_type_AndroidViewView);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeViewInLayout(this.jdField_r_of_type_AndroidViewView);
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeViewInLayout(this.jdField_p_of_type_AndroidWidgetTextView);
          this.jdField_s_of_type_AndroidViewView = null;
          this.jdField_r_of_type_AndroidViewView = null;
          this.jdField_p_of_type_AndroidWidgetTextView = null;
          ((RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getLayoutParams()).addRule(2, 2131363476);
        }
        CustomizeStrategyFactory.a().a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.b();
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgAioState.a();
        if (this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet.b();
          this.jdField_a_of_type_ComTencentMobileqqMsgforwardAIOShareActionSheet = null;
        }
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
        aU();
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
        }
        if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
          this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
        }
        UniteGrayTipUtil.b();
        this.ac = false;
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("Q.aio.BaseChatPie", 1, "force clear mOnTouchModeChangeListeners", localException);
        continue;
        localException.run();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie
 * JD-Core Version:    0.7.0.1
 */