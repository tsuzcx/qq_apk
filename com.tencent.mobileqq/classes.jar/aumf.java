import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.flashchat.FlashChatItem;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatPanel;
import com.tencent.mobileqq.flashchat.FlashChatTextEffectView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class aumf
  extends RecyclerView.Adapter<aumi>
{
  public static SparseArray<WeakReference<ArkFlashChatContainerWrapper>> a;
  public static int b;
  public static SparseArray<MessageForArkFlashChat> b;
  public int a;
  private agpi jdField_a_of_type_Agpi = new aumg(this);
  public aumj a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  public List<aumb> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String b;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_Int = 1;
  }
  
  public aumf(aumj paramaumj, BaseChatPie paramBaseChatPie, int paramInt, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaLangString = "FlashChatAdapter";
    this.jdField_a_of_type_Aumj = paramaumj;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public aumi a(ViewGroup paramViewGroup, int paramInt)
  {
    return new aumi(LayoutInflater.from(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getActivity().getBaseContext()).inflate(2131561065, paramViewGroup, false), this.jdField_a_of_type_Aumj, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    jdField_b_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(aumi paramaumi, int paramInt)
  {
    Object localObject1 = (aumb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = (ViewGroup.MarginLayoutParams)paramaumi.itemView.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject2).height = FlashChatPanel.f;
    ((ViewGroup.MarginLayoutParams)localObject2).width = FlashChatPanel.e;
    if (paramInt % 3 == 0)
    {
      ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = 0;
      ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.g;
    }
    for (;;)
    {
      if (paramInt / 3 == 0)
      {
        ((ViewGroup.MarginLayoutParams)localObject2).topMargin = 0;
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.g;
        label82:
        paramaumi.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramaumi.itemView.setBackgroundDrawable(new ColorDrawable(0));
        paramaumi.itemView.setContentDescription(anvx.a(2131704091) + ((aumb)localObject1).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.name);
        paramaumi.jdField_a_of_type_Int = ((aumb)localObject1).jdField_a_of_type_Int;
        paramaumi.jdField_b_of_type_Int = ((aumb)localObject1).jdField_b_of_type_Int;
        paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = ((aumb)localObject1).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
        paramaumi.jdField_a_of_type_Aumb = ((aumb)localObject1);
        paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setClipRadius(4.0F);
        paramaumi.itemView.setLayerType(0, null);
      }
      try
      {
        paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(0);
        paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setBkgColorNormal(Color.parseColor(paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.color));
        label231:
        String str;
        if (jdField_a_of_type_AndroidUtilSparseArray.get(paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id) == null)
        {
          localObject1 = null;
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new ArkFlashChatContainerWrapper();
            jdField_a_of_type_AndroidUtilSparseArray.put(paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, new WeakReference(localObject2));
          }
          localObject1 = (MessageForArkFlashChat)jdField_b_of_type_AndroidUtilSparseArray.get(paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id);
          if (localObject1 != null) {
            break label878;
          }
          localObject1 = new MessageForArkFlashChat();
          ((MessageForArkFlashChat)localObject1).uniseq = jdField_b_of_type_Int;
          jdField_b_of_type_Int += 1;
          ((MessageForArkFlashChat)localObject1).ark_app_message = new ArkFlashChatMessage();
          ((MessageForArkFlashChat)localObject1).ark_app_message.preview = true;
          jdField_b_of_type_AndroidUtilSparseArray.put(paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, localObject1);
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            break label840;
          }
          this.jdField_a_of_type_JavaLangString = FlashChatManager.b(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).input.getText().toString());
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceAll("\\s", "");
          label400:
          if (!avkh.c.get()) {
            this.jdField_a_of_type_JavaLangString = "";
          }
          ArkFlashChatMessage localArkFlashChatMessage = ((MessageForArkFlashChat)localObject1).ark_app_message;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label850;
          }
          str = anvx.a(2131704088);
          label440:
          localArkFlashChatMessage.promptText = str;
          ((MessageForArkFlashChat)localObject1).ark_app_message.appName = paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.appName;
          ((MessageForArkFlashChat)localObject1).arkContainer = ((ArkFlashChatContainerWrapper)localObject2);
          ((ArkFlashChatContainerWrapper)localObject2).a();
          ((ArkFlashChatContainerWrapper)localObject2).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app, BaseApplicationImpl.sApplication, paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.appName, paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.mainView, paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.ver, paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, ((MessageForArkFlashChat)localObject1).ark_app_message.getMeta(((MessageForArkFlashChat)localObject1).uniseq, false), paramaumi.itemView.getContext().getResources().getDisplayMetrics().scaledDensity, ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getSessionInfo(), FlashChatPanel.e - bptp.a(7.0F), FlashChatPanel.f - bptp.a(7.0F), FlashChatPanel.e, FlashChatPanel.f, (MessageForArkFlashChat)localObject1);
          paramaumi.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = ((MessageForArkFlashChat)localObject1);
          paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnVisibleChangeListener(this.jdField_a_of_type_Agpi);
          paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new aumh(this, paramaumi, paramInt));
          paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a((agnx)localObject2, paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
          if ((paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getVisibility() == 0) && (avkh.c.get()))
          {
            paramaumi.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(8);
            FlashChatTextEffectView.a(paramaumi);
            localObject1 = Message.obtain();
            ((Message)localObject1).obj = paramaumi;
            ((Message)localObject1).what = paramInt;
            if (paramInt >= FlashChatTextEffectView.a().length) {
              break label859;
            }
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, FlashChatTextEffectView.a()[paramInt]);
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onRecyclerBindViewHolder(paramaumi, paramInt, getItemId(paramInt));
          return;
          if (paramInt % 3 == 2)
          {
            ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.g;
            ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = 0;
            break;
          }
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = FlashChatPanel.g;
          ((ViewGroup.MarginLayoutParams)localObject2).rightMargin = FlashChatPanel.g;
          break;
          if (paramInt / 3 == getItemCount() / 3)
          {
            ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.g;
            ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = 0;
            break label82;
          }
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = FlashChatPanel.g;
          ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = FlashChatPanel.g;
          break label82;
          localObject1 = (ArkFlashChatContainerWrapper)((WeakReference)jdField_a_of_type_AndroidUtilSparseArray.get(paramaumi.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id)).get();
          break label231;
          label840:
          this.jdField_a_of_type_JavaLangString = "";
          break label400;
          label850:
          str = this.jdField_a_of_type_JavaLangString;
          break label440;
          label859:
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, 7000L);
        }
      }
      catch (Throwable localThrowable)
      {
        label878:
        for (;;) {}
      }
    }
  }
  
  public void a(List<? extends aumb> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void b()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      Object localObject = (WeakReference)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(0);
        }
      }
      i += 1;
    }
  }
  
  public void c()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      Object localObject = (WeakReference)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(1);
        }
      }
      i += 1;
    }
  }
  
  public void d()
  {
    int i = 0;
    while (i < jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      Object localObject = (WeakReference)jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
      if (localObject != null)
      {
        localObject = (ArkFlashChatContainerWrapper)((WeakReference)localObject).get();
        if (localObject != null) {
          ((ArkFlashChatContainerWrapper)localObject).doOnEvent(2);
        }
      }
      i += 1;
    }
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumf
 * JD-Core Version:    0.7.0.1
 */