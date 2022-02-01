package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.coreui.input.InputBarUI;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.coreui.msglist.ListUI;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameDetailInfo;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameMsgGreeting.QueryAIOGreetInfoRsp;
import com.tencent.mobileqq.gamecenter.util.RoleIdUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class GameMsgSayHiHelper
  extends SimpleUIAIOHelper
  implements OnFinishListener
{
  public static String a = "ext_key_game_msg_say_hi_type";
  View.OnClickListener b = new GameMsgSayHiHelper.3(this);
  private FrameLayout h;
  private GameMsgSayHiHelper.SayHiState i = GameMsgSayHiHelper.SayHiState.UNKNOWN;
  private boolean j = false;
  private boolean k = false;
  private ArrayList<GameMsgSayHiHelper.EmojiListItem> l = new ArrayList();
  private int m = 0;
  private final int n = 205;
  private final int o = 92;
  private View.OnClickListener p = new GameMsgSayHiHelper.2(this);
  
  public GameMsgSayHiHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    if ((this.c instanceof GameMsgChatPie))
    {
      if ((paramBaseChatPie.bv() != null) && (paramBaseChatPie.bv().d() != null)) {
        paramBaseChatPie.bv().d().a(this);
      }
      r();
      if (this.l.size() <= 0) {
        s();
      }
      return;
    }
    throw new IllegalArgumentException("GameMsgSayHiHelper: A GameMsgChatPie is required");
  }
  
  private long a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (!paramBundle.containsKey("allowTimeStamp")) {
        return 0L;
      }
      long l1 = paramBundle.getLong("allowTimeStamp", 0L);
      long l2 = NetConnInfoCenter.getServerTime();
      if (l1 <= l2) {
        return 0L;
      }
      l1 -= l2;
      l2 = l1 / 60L;
      int i1;
      if (l1 % 60L > 0L) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      return l2 + i1;
    }
    return 0L;
  }
  
  private String a(List<String> paramList, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i3 = Math.abs(new Random().nextInt()) % paramList.size();
      int i2 = -1;
      if (!TextUtils.isEmpty(paramString)) {
        i2 = paramList.indexOf(paramString);
      }
      int i1 = i3;
      if (i2 >= 0)
      {
        i1 = i3;
        if (i3 == i2) {
          i1 = i3 + 1;
        }
      }
      i2 = i1;
      if (i1 >= paramList.size()) {
        i2 = 0;
      }
      return (String)paramList.get(i2);
    }
    return "";
  }
  
  private void a(GameMsgSayHiHelper.SayHiState paramSayHiState, Bundle paramBundle)
  {
    if ((this.h != null) && (this.i != paramSayHiState))
    {
      if (paramSayHiState == GameMsgSayHiHelper.SayHiState.UNKNOWN) {
        return;
      }
      this.i = paramSayHiState;
      Object localObject = this.h.findViewById(2131436898);
      View localView1 = this.h.findViewById(2131436982);
      View localView2 = this.h.findViewById(2131447251);
      int i1 = GameMsgSayHiHelper.4.a[paramSayHiState.ordinal()];
      if (i1 != 1)
      {
        if ((i1 != 2) && (i1 != 3))
        {
          if (i1 != 4)
          {
            if (i1 != 5) {
              return;
            }
            ((View)localObject).setVisibility(8);
            localView1.setVisibility(0);
            localView2.setVisibility(8);
            a(92);
            ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(u(), "1", "145", "920", "92005", "209031", "", "", "8", "0");
            return;
          }
          ((View)localObject).setVisibility(8);
          localView1.setVisibility(8);
          localView2.setVisibility(0);
          a(92);
          return;
        }
        ((View)localObject).setVisibility(0);
        localView1.setVisibility(8);
        localView2.setVisibility(8);
        long l1 = a(paramBundle);
        paramBundle = (TextView)this.h.findViewById(2131447211);
        localObject = (TextView)this.h.findViewById(2131447213);
        if ((paramSayHiState == GameMsgSayHiHelper.SayHiState.SAY_HI_DENIED) && (l1 > 0L))
        {
          paramBundle.setText(BaseApplicationImpl.getContext().getString(2131889856, new Object[] { Long.valueOf(l1) }));
          ((TextView)localObject).setEnabled(false);
        }
        else
        {
          paramBundle.setText(BaseApplicationImpl.getContext().getString(2131889858));
          ((TextView)localObject).setEnabled(true);
        }
        a(205);
        ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(u(), "1", "145", "920", "92005", "209029", "", "", "8", "0");
        return;
      }
      f(true);
      this.h.setVisibility(8);
    }
  }
  
  private void b(View paramView)
  {
    paramView = (LinearLayout)paramView.findViewById(2131436912);
    int i1 = 0;
    while (i1 < this.l.size())
    {
      Object localObject1 = (GameMsgSayHiHelper.EmojiListItem)this.l.get(i1);
      View localView = View.inflate(BaseApplicationImpl.getContext(), 2131624101, null);
      Object localObject2 = (ImageView)localView.findViewById(2131435440);
      TextView localTextView = (TextView)localView.findViewById(2131447135);
      localView.setTag(Integer.valueOf(((GameMsgSayHiHelper.EmojiListItem)localObject1).a));
      localView.setOnClickListener(this.b);
      if (((GameMsgSayHiHelper.EmojiListItem)localObject1).d != null) {
        localTextView.setText(((GameMsgSayHiHelper.EmojiListItem)localObject1).d);
      }
      if (!TextUtils.isEmpty(((GameMsgSayHiHelper.EmojiListItem)localObject1).b)) {
        ((ImageView)localObject2).setImageDrawable(URLDrawable.getDrawable(((GameMsgSayHiHelper.EmojiListItem)localObject1).b));
      } else if (((GameMsgSayHiHelper.EmojiListItem)localObject1).c != 0) {
        ((ImageView)localObject2).setImageResource(((GameMsgSayHiHelper.EmojiListItem)localObject1).c);
      }
      localObject1 = BaseApplicationImpl.getContext().getResources();
      localObject2 = new LinearLayout.LayoutParams(AIOUtils.b(106.5F, (Resources)localObject1), AIOUtils.b(86.0F, (Resources)localObject1));
      ((LinearLayout.LayoutParams)localObject2).leftMargin = AIOUtils.b(6.0F, (Resources)localObject1);
      ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.b(6.0F, (Resources)localObject1);
      paramView.addView(localView, (ViewGroup.LayoutParams)localObject2);
      i1 += 1;
    }
    if (paramView.getChildCount() > 0) {
      a(paramView.getChildAt(0));
    }
  }
  
  private void f(boolean paramBoolean)
  {
    Object localObject1 = t();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = ((GameMsgChatPie)localObject1).bA();
    int i2 = 0;
    int i1;
    if ((localObject2 != null) && (((GameMsgChatPie)localObject1).bA().d() != null) && (((GameMsgChatPie)localObject1).bA().d().e() != null))
    {
      localObject2 = ((GameMsgChatPie)localObject1).bA().d().e();
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      ((InputBarUI)localObject2).a(i1);
    }
    if (((GameMsgChatPie)localObject1).W != null)
    {
      localObject1 = ((GameMsgChatPie)localObject1).W;
      if (paramBoolean) {
        i1 = i2;
      } else {
        i1 = 8;
      }
      ((PanelIconLinearLayout)localObject1).setVisibility(i1);
    }
    if ((paramBoolean) && (this.c.bb != null))
    {
      localObject1 = this.c.bb.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = -2;
      this.c.bb.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    if (paramBoolean)
    {
      c(this.m);
      return;
    }
    localObject1 = e();
    if (localObject1 != null) {
      this.m = ((ListUI)localObject1).n();
    }
  }
  
  private void r()
  {
    if (this.c != null)
    {
      if (this.c.d == null) {
        return;
      }
      Object localObject1 = ((IGameMsgManagerService)this.c.d.getRuntimeService(IGameMsgManagerService.class, "")).getSayHiDefaultConfig();
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((JSONObject)localObject1).optJSONArray("showList");
      if (localObject1 == null) {
        return;
      }
      int i1 = 0;
      while ((i1 < ((JSONArray)localObject1).length()) && (i1 < 3))
      {
        Object localObject2 = ((JSONArray)localObject1).optJSONObject(i1);
        if (localObject2 != null)
        {
          localObject2 = new GameMsgSayHiHelper.EmojiListItem((JSONObject)localObject2);
          this.l.add(localObject2);
        }
        i1 += 1;
      }
    }
  }
  
  private void s()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    GameMsgSayHiHelper.EmojiListItem localEmojiListItem1 = new GameMsgSayHiHelper.EmojiListItem();
    localEmojiListItem1.a = 2;
    localEmojiListItem1.c = 2130838031;
    localEmojiListItem1.d = localBaseApplication.getString(2131889876);
    localEmojiListItem1.e.add(localBaseApplication.getString(2131889870));
    localEmojiListItem1.e.add(localBaseApplication.getString(2131889871));
    localEmojiListItem1.e.add(localBaseApplication.getString(2131889872));
    localEmojiListItem1.e.add(localBaseApplication.getString(2131889873));
    localEmojiListItem1.e.add(localBaseApplication.getString(2131889874));
    localEmojiListItem1.e.add(localBaseApplication.getString(2131889875));
    GameMsgSayHiHelper.EmojiListItem localEmojiListItem2 = new GameMsgSayHiHelper.EmojiListItem();
    localEmojiListItem2.a = 3;
    localEmojiListItem2.c = 2130838028;
    localEmojiListItem2.d = localBaseApplication.getString(2131889863);
    localEmojiListItem2.e.add(localBaseApplication.getString(2131889859));
    localEmojiListItem2.e.add(localBaseApplication.getString(2131889860));
    localEmojiListItem2.e.add(localBaseApplication.getString(2131889861));
    localEmojiListItem2.e.add(localBaseApplication.getString(2131889862));
    GameMsgSayHiHelper.EmojiListItem localEmojiListItem3 = new GameMsgSayHiHelper.EmojiListItem();
    localEmojiListItem3.a = 1;
    localEmojiListItem3.c = 2130838030;
    localEmojiListItem3.d = localBaseApplication.getString(2131889869);
    localEmojiListItem3.e.add(localBaseApplication.getString(2131889864));
    localEmojiListItem3.e.add(localBaseApplication.getString(2131889865));
    localEmojiListItem3.e.add(localBaseApplication.getString(2131889866));
    localEmojiListItem3.e.add(localBaseApplication.getString(2131889867));
    localEmojiListItem3.e.add(localBaseApplication.getString(2131889868));
    this.l.add(localEmojiListItem1);
    this.l.add(localEmojiListItem3);
    this.l.add(localEmojiListItem2);
  }
  
  private GameMsgChatPie t()
  {
    if ((this.c instanceof GameMsgChatPie)) {
      return (GameMsgChatPie)this.c;
    }
    return null;
  }
  
  private String u()
  {
    Object localObject = t();
    if (localObject == null) {
      return "";
    }
    localObject = ((GameMsgChatPie)localObject).bB();
    if (localObject == null) {
      return "";
    }
    return ((GameDetailInfo)localObject).c;
  }
  
  private void v()
  {
    if (this.h != null) {
      return;
    }
    GameMsgChatPie localGameMsgChatPie = t();
    if (localGameMsgChatPie == null) {
      return;
    }
    this.h = ((FrameLayout)View.inflate(BaseApplicationImpl.getContext(), 2131624100, null));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12, -1);
    localGameMsgChatPie.bl().addView(this.h, localLayoutParams);
    b(this.h);
    this.h.findViewById(2131436869).setOnClickListener(this.p);
    this.h.findViewById(2131436909).setOnClickListener(this.p);
    this.h.findViewById(2131435409).setOnClickListener(this.p);
    this.h.findViewById(2131447213).setOnClickListener(this.p);
  }
  
  protected void a(int paramInt)
  {
    paramInt = AIOUtils.b(paramInt, BaseApplicationImpl.getContext().getResources());
    c(paramInt);
    b(paramInt);
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    GameMsgChatPie localGameMsgChatPie = t();
    if (localGameMsgChatPie != null)
    {
      if (localGameMsgChatPie.d == null) {
        return;
      }
      SessionInfo localSessionInfo = localGameMsgChatPie.aE();
      if (localSessionInfo == null) {
        return;
      }
      int i1 = Math.abs(new Random().nextInt());
      ChatMessage localChatMessage = (ChatMessage)MessageRecordFactory.a(-1000);
      MessageRecordFactory.a(localGameMsgChatPie.d, localChatMessage, localSessionInfo.b, localSessionInfo.c, localSessionInfo.a);
      RoleIdUtil.c(localChatMessage);
      localChatMessage.saveExtInfoToExtStr(a, String.valueOf(paramInt));
      localChatMessage.msg = paramString;
      localChatMessage.msgUid = MessageUtils.a(i1);
      localChatMessage.mAnimFlag = true;
      localChatMessage.mNewAnimFlag = true;
      localGameMsgChatPie.d.getMessageFacade().a(localChatMessage, null);
    }
  }
  
  protected void a(View paramView)
  {
    Object localObject1 = this.h;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (TextView)((FrameLayout)localObject1).findViewById(2131447156);
    LinearLayout localLinearLayout = (LinearLayout)this.h.findViewById(2131436912);
    int i1 = 0;
    while ((i1 < localLinearLayout.getChildCount()) && (i1 < this.l.size()))
    {
      Object localObject2 = localLinearLayout.getChildAt(i1);
      Object localObject3 = (CheckBox)((View)localObject2).findViewById(2131430669);
      boolean bool;
      if (paramView == localObject2) {
        bool = true;
      } else {
        bool = false;
      }
      ((CheckBox)localObject3).setChecked(bool);
      if (paramView == localObject2)
      {
        localObject2 = (GameMsgSayHiHelper.EmojiListItem)this.l.get(i1);
        localObject3 = ((TextView)localObject1).getText().toString();
        ((TextView)localObject1).setText(a(((GameMsgSayHiHelper.EmojiListItem)localObject2).e, (String)localObject3));
      }
      i1 += 1;
    }
  }
  
  protected void a(GameMsgGreeting.QueryAIOGreetInfoRsp paramQueryAIOGreetInfoRsp)
  {
    if (!paramQueryAIOGreetInfoRsp.greetType.has())
    {
      QLog.e("GameMsgSayHiHelper", 1, "onSayHiResponse no greetType");
      return;
    }
    int i1 = paramQueryAIOGreetInfoRsp.greetType.get();
    if ((i1 > GameMsgSayHiHelper.SayHiState.UNKNOWN.ordinal()) && (i1 <= GameMsgSayHiHelper.SayHiState.NORMAL_CHAT.ordinal()))
    {
      if (i1 == GameMsgSayHiHelper.SayHiState.NORMAL_CHAT.ordinal())
      {
        if (this.h == null) {
          return;
        }
        a(GameMsgSayHiHelper.SayHiState.values()[i1], null);
        if ((this.c != null) && (this.c.bv() != null) && (this.c.bv().d() != null)) {
          ((IceBreakHelper)this.c.bv().d().a(10)).a(false, true);
        }
      }
      else
      {
        if (this.h == null)
        {
          f(false);
          v();
        }
        Bundle localBundle = new Bundle();
        if (paramQueryAIOGreetInfoRsp.nextGreetTime.has()) {
          localBundle.putLong("allowTimeStamp", paramQueryAIOGreetInfoRsp.nextGreetTime.get());
        }
        a(GameMsgSayHiHelper.SayHiState.values()[i1], localBundle);
      }
      return;
    }
    QLog.e("GameMsgSayHiHelper", 1, "onSayHiResponse greetType is unknow.");
  }
  
  public void a(String paramString1, String paramString2)
  {
    GameMsgChatPie localGameMsgChatPie = t();
    if (localGameMsgChatPie != null)
    {
      if (localGameMsgChatPie.d == null) {
        return;
      }
      this.j = true;
      ((IGameMsgManagerService)localGameMsgChatPie.d.getRuntimeService(IGameMsgManagerService.class, "")).reqGameMsgSayHiInfo(paramString1, paramString2, new GameMsgSayHiHelper.1(this, paramString2, paramString1));
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  protected void b(int paramInt)
  {
    if ((this.c != null) && (this.c.bb != null))
    {
      ViewGroup.LayoutParams localLayoutParams = this.c.bb.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.c.bb.setLayoutParams(localLayoutParams);
    }
  }
  
  protected void bK_()
  {
    a(2, BaseApplicationImpl.getContext().getString(2131889855));
    a(GameMsgSayHiHelper.SayHiState.NORMAL_CHAT, null);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(u(), "1", "145", "920", "92005", "209032", "", "1", "20", "0");
  }
  
  protected void bL_()
  {
    a(3, BaseApplicationImpl.getContext().getString(2131889857));
    a(GameMsgSayHiHelper.SayHiState.NORMAL_CHAT, null);
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(u(), "1", "145", "920", "92005", "209032", "", "2", "20", "0");
  }
  
  public int bM_()
  {
    return 0;
  }
  
  protected void c(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    ListUI localListUI = e();
    if (localListUI != null) {
      localListUI.a(localListUI.q(), localListUI.o(), localListUI.p(), paramInt);
    }
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  protected ListUI e()
  {
    if ((this.c != null) && (this.c.bv() != null) && (this.c.bv().e() != null)) {
      return this.c.bv().e().b();
    }
    return null;
  }
  
  public void e(int paramInt)
  {
    if ((this.c != null) && (this.c.d != null)) {
      ((IGameMsgManagerService)this.c.d.getRuntimeService(IGameMsgManagerService.class, "")).removeGameMsgSayHiCallback();
    }
    this.k = true;
    this.j = false;
    this.i = GameMsgSayHiHelper.SayHiState.UNKNOWN;
  }
  
  protected View h()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.h.findViewById(2131436912);
    int i1 = 0;
    while ((i1 < localLinearLayout.getChildCount()) && (i1 < this.l.size()))
    {
      if (((CheckBox)localLinearLayout.getChildAt(i1).findViewById(2131430669)).isChecked()) {
        return localLinearLayout.getChildAt(i1);
      }
      i1 += 1;
    }
    return null;
  }
  
  protected void i()
  {
    Object localObject = (LinearLayout)this.h.findViewById(2131436912);
    int i1 = 0;
    while ((i1 < ((LinearLayout)localObject).getChildCount()) && (i1 < this.l.size()))
    {
      if (((CheckBox)((LinearLayout)localObject).getChildAt(i1).findViewById(2131430669)).isChecked())
      {
        localObject = ((GameMsgSayHiHelper.EmojiListItem)this.l.get(i1)).e;
        break label82;
      }
      i1 += 1;
    }
    localObject = null;
    label82:
    TextView localTextView = (TextView)this.h.findViewById(2131447156);
    localTextView.setText(a((List)localObject, localTextView.getText().toString()));
  }
  
  protected void j()
  {
    a(1, ((TextView)this.h.findViewById(2131447156)).getText().toString());
    a(GameMsgSayHiHelper.SayHiState.SAY_HI_WAIT_REPLYING, null);
    Object localObject = h();
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((View)localObject).getTag().toString();
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(u(), "1", "145", "920", "92005", "209030", "", (String)localObject, "20", "0");
  }
  
  public boolean k()
  {
    return (!this.j) && ((this.i == GameMsgSayHiHelper.SayHiState.UNKNOWN) || (this.i == GameMsgSayHiHelper.SayHiState.NORMAL_CHAT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgSayHiHelper
 * JD-Core Version:    0.7.0.1
 */