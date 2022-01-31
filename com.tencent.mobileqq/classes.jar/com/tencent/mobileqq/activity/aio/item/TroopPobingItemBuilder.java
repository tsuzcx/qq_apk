package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import vhk;

public class TroopPobingItemBuilder
  extends BaseBubbleBuilder
{
  private static String jdField_a_of_type_JavaLangString = "";
  public static ArrayList a;
  private static int b;
  public static ArrayList b;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new vhk(this);
  private TroopPobingItemBuilder.ConfigableWordingSetter jdField_a_of_type_ComTencentMobileqqActivityAioItemTroopPobingItemBuilder$ConfigableWordingSetter = new TroopPobingItemBuilder.ConfigableWordingSetter(this);
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_Int = 0;
  }
  
  public TroopPobingItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    a(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_b_of_type_JavaUtilArrayList.clear();
    a(paramQQAppInterface, jdField_a_of_type_JavaUtilArrayList, jdField_b_of_type_JavaUtilArrayList);
    if (jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      jdField_a_of_type_JavaUtilArrayList.addAll(Arrays.asList(new String[] { "欢迎欢迎！", "哎呦你终于来了！", "举朵小花欢迎你！", "欢迎入群！" }));
    }
    if (jdField_b_of_type_JavaUtilArrayList.isEmpty()) {
      jdField_b_of_type_JavaUtilArrayList.addAll(Arrays.asList(new String[] { "求曝照", "喜欢看什么电影？", "用三个词形容下自己吧", "你这么好看我能撩你吗？", "能约你吃饭吗？", "我可以跟你聊聊天吗？", "群里你最想认识谁？", "你单身吗？", "平时喜欢玩什么？" }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, ArrayList paramArrayList, String paramString2)
  {
    if (jdField_b_of_type_Int == 0) {}
    while ((paramArrayList.size() != 1) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    for (;;)
    {
      try
      {
        paramArrayList = (MessageForText.AtTroopMemberInfo)paramArrayList.get(0);
        long l1 = paramArrayList.uin;
        long l2 = Long.parseLong(jdField_a_of_type_JavaLangString);
        if (l1 != l2) {
          return;
        }
        paramArrayList = paramString1.substring(paramArrayList.textLen).trim();
        if (jdField_b_of_type_Int == 1)
        {
          Object localObject = "";
          if (jdField_a_of_type_JavaUtilArrayList.contains(paramArrayList)) {
            localObject = paramArrayList;
          }
          new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_welcome_suc").a(new String[] { paramString2, localObject, jdField_a_of_type_JavaLangString }).a();
        }
        if (jdField_b_of_type_Int == 2)
        {
          if (jdField_b_of_type_JavaUtilArrayList.contains(paramArrayList)) {
            new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("send_play_suc").a(new String[] { paramString2, paramArrayList, jdField_a_of_type_JavaLangString }).a();
          }
        }
        else {
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopPobingItemBuilder", 2, "reportWelcome subString error ,content length = " + paramString1.length());
        }
        return;
      }
      finally
      {
        jdField_b_of_type_Int = 0;
      }
      paramArrayList = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, JSONArray paramJSONArray1, JSONArray paramJSONArray2)
  {
    if ((paramJSONArray1 == null) || (paramJSONArray2 == null)) {
      return;
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp()).edit();
    localEditor.putString("troop_pobing_config_left_wording_" + paramString, paramJSONArray1.toString());
    localEditor.putString("troop_pobing_config_right_wording_" + paramString, paramJSONArray2.toString());
    localEditor.commit();
    a(paramQQAppInterface);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, List paramList1, List paramList2)
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
    paramQQAppInterface = paramQQAppInterface.c();
    String str = ((SharedPreferences)localObject).getString("troop_pobing_config_left_wording_" + paramQQAppInterface, "");
    paramQQAppInterface = ((SharedPreferences)localObject).getString("troop_pobing_config_right_wording_" + paramQQAppInterface, "");
    int i;
    if (!TextUtils.isEmpty(str)) {
      try
      {
        localObject = new JSONArray(str);
        i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          str = ((JSONArray)localObject).optString(i);
          if (!TextUtils.isEmpty(str)) {
            paramList1.add(str);
          }
          i += 1;
        }
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          return;
        }
      }
      catch (JSONException paramList1)
      {
        paramList1.printStackTrace();
      }
    } else {
      try
      {
        paramQQAppInterface = new JSONArray(paramQQAppInterface);
        i = 0;
        while (i < paramQQAppInterface.length())
        {
          paramList1 = paramQQAppInterface.optString(i);
          if (!TextUtils.isEmpty(paramList1)) {
            paramList2.add(paramList1);
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 3;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    TroopPobingItemBuilder.TroopPobingViewHolder localTroopPobingViewHolder = (TroopPobingItemBuilder.TroopPobingViewHolder)paramViewHolder;
    boolean bool = paramChatMessage.senderuin.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    Context localContext = paramBaseChatItemLayout.getContext();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130968769, paramBaseChatItemLayout, false);
      localTroopPobingViewHolder.a = ((TextView)paramViewHolder.findViewById(2131363618));
      localTroopPobingViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131363664));
      localTroopPobingViewHolder.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewHolder.findViewById(2131363665));
      localTroopPobingViewHolder.jdField_b_of_type_AndroidViewView = paramViewHolder.findViewById(2131363661);
      localTroopPobingViewHolder.jdField_c_of_type_AndroidViewView = paramViewHolder.findViewById(2131363663);
      paramView = paramViewHolder.findViewById(2131363660);
      paramBaseChatItemLayout = paramView.getLayoutParams();
      paramBaseChatItemLayout.width = (BaseChatItemLayout.d - AIOUtils.a(24.0F, localContext.getResources()));
      paramView.setLayoutParams(paramBaseChatItemLayout);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    }
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131558633);
    int k = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelOffset(2131558634);
    int j;
    if (paramChatMessage.isSend()) {
      j = k;
    }
    for (;;)
    {
      k = AIOUtils.a(20.0F, localContext.getResources());
      int m = AIOUtils.a(20.0F, localContext.getResources());
      localTroopPobingViewHolder.a.setPadding(j, k, i, m);
      paramChatMessage = (MessageForTroopPobing)paramChatMessage;
      localTroopPobingViewHolder.a.setText(paramChatMessage.mBrief);
      if (!bool)
      {
        localTroopPobingViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(0);
        localTroopPobingViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localTroopPobingViewHolder.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localTroopPobingViewHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        return paramViewHolder;
      }
      localTroopPobingViewHolder.jdField_b_of_type_AndroidViewView.setVisibility(8);
      localTroopPobingViewHolder.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return paramViewHolder;
      j = i;
      i = k;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new TroopPobingItemBuilder.TroopPobingViewHolder();
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    return paramChatMessage.getSummaryMsg();
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131375336: 
      ChatActivityFacade.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.b(paramChatMessage);
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if (paramChatMessage.isSend())
    {
      paramViewHolder.a.setBackgroundResource(2130845661);
      return;
    }
    paramViewHolder.a.setBackgroundResource(2130845497);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    a(AIOUtils.a(paramView), localQQCustomMenu);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopPobingItemBuilder
 * JD-Core Version:    0.7.0.1
 */