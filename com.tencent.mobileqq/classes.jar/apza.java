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
import com.tencent.mobileqq.activity.BaseChatPie;
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
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class apza
  extends RecyclerView.Adapter<apzd>
{
  public static SparseArray<WeakReference<ArkFlashChatContainerWrapper>> a;
  public static int b;
  public static SparseArray<MessageForArkFlashChat> b;
  public int a;
  private admu jdField_a_of_type_Admu = new apzb(this);
  public apze a;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  public List<apyw> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private String b;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_AndroidUtilSparseArray = new SparseArray();
    jdField_b_of_type_Int = 1;
  }
  
  public apza(apze paramapze, BaseChatPie paramBaseChatPie, int paramInt, MqqHandler paramMqqHandler)
  {
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_b_of_type_JavaLangString = "FlashChatAdapter";
    this.jdField_a_of_type_Apze = paramapze;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_MqqOsMqqHandler = paramMqqHandler;
  }
  
  public apzd a(ViewGroup paramViewGroup, int paramInt)
  {
    return new apzd(LayoutInflater.from(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a().getBaseContext()).inflate(2131560694, paramViewGroup, false), this.jdField_a_of_type_Apze, this.jdField_a_of_type_Int);
  }
  
  public void a()
  {
    jdField_a_of_type_AndroidUtilSparseArray.clear();
    jdField_b_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(apzd paramapzd, int paramInt)
  {
    Object localObject1 = (apyw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject2 = (ViewGroup.MarginLayoutParams)paramapzd.itemView.getLayoutParams();
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
        paramapzd.itemView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramapzd.itemView.setBackgroundDrawable(new ColorDrawable(0));
        paramapzd.itemView.setContentDescription(ajya.a(2131704623) + ((apyw)localObject1).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.name);
        paramapzd.jdField_a_of_type_Int = ((apyw)localObject1).jdField_a_of_type_Int;
        paramapzd.jdField_b_of_type_Int = ((apyw)localObject1).jdField_b_of_type_Int;
        paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem = ((apyw)localObject1).jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem;
        paramapzd.jdField_a_of_type_Apyw = ((apyw)localObject1);
        paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setClipRadius(4.0F);
        paramapzd.itemView.setLayerType(0, null);
      }
      try
      {
        paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(0);
        paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setBkgColorNormal(Color.parseColor(paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.color));
        label231:
        ArkFlashChatMessage localArkFlashChatMessage;
        if (jdField_a_of_type_AndroidUtilSparseArray.get(paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id) == null)
        {
          localObject1 = null;
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject2 = new ArkFlashChatContainerWrapper();
            jdField_a_of_type_AndroidUtilSparseArray.put(paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, new WeakReference(localObject2));
          }
          localObject1 = (MessageForArkFlashChat)jdField_b_of_type_AndroidUtilSparseArray.get(paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id);
          if (localObject1 != null) {
            break label863;
          }
          localObject1 = new MessageForArkFlashChat();
          ((MessageForArkFlashChat)localObject1).uniseq = jdField_b_of_type_Int;
          jdField_b_of_type_Int += 1;
          ((MessageForArkFlashChat)localObject1).ark_app_message = new ArkFlashChatMessage();
          ((MessageForArkFlashChat)localObject1).ark_app_message.preview = true;
          jdField_b_of_type_AndroidUtilSparseArray.put(paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, localObject1);
          if (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) {
            break label827;
          }
          this.jdField_a_of_type_JavaLangString = FlashChatManager.b(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
          this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString.replaceAll("\\s", "");
          label400:
          if (!aqxj.c.get()) {
            this.jdField_a_of_type_JavaLangString = "";
          }
          localArkFlashChatMessage = ((MessageForArkFlashChat)localObject1).ark_app_message;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
            break label837;
          }
        }
        label827:
        label837:
        for (String str = ajya.a(2131704620);; str = this.jdField_a_of_type_JavaLangString)
        {
          localArkFlashChatMessage.promptText = str;
          ((MessageForArkFlashChat)localObject1).ark_app_message.appName = paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.appName;
          ((MessageForArkFlashChat)localObject1).arkContainer = ((ArkFlashChatContainerWrapper)localObject2);
          ((ArkFlashChatContainerWrapper)localObject2).a();
          ((ArkFlashChatContainerWrapper)localObject2).a(((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.sApplication, paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.appName, paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.mainView, paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.ver, paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id, ((MessageForArkFlashChat)localObject1).ark_app_message.getMeta(((MessageForArkFlashChat)localObject1).uniseq, false), paramapzd.itemView.getContext().getResources().getDisplayMetrics().scaledDensity, ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(), FlashChatPanel.e - blcq.a(7.0F), FlashChatPanel.f - blcq.a(7.0F), FlashChatPanel.e, FlashChatPanel.f, (MessageForArkFlashChat)localObject1);
          paramapzd.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = ((MessageForArkFlashChat)localObject1);
          paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnVisibleChangeListener(this.jdField_a_of_type_Admu);
          paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setCallback(new apzc(this, paramapzd, paramInt));
          paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.a((adlj)localObject2, paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout);
          if ((paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getVisibility() == 0) && (aqxj.c.get()))
          {
            paramapzd.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLoadLayout.setVisibility(8);
            FlashChatTextEffectView.a(paramapzd);
            localObject1 = Message.obtain();
            ((Message)localObject1).obj = paramapzd;
            ((Message)localObject1).what = paramInt;
            if (paramInt >= FlashChatTextEffectView.a().length) {
              break label846;
            }
            this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, FlashChatTextEffectView.a()[paramInt]);
          }
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
          localObject1 = (ArkFlashChatContainerWrapper)((WeakReference)jdField_a_of_type_AndroidUtilSparseArray.get(paramapzd.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatItem.id)).get();
          break label231;
          this.jdField_a_of_type_JavaLangString = "";
          break label400;
        }
        label846:
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject1, 7000L);
        return;
      }
      catch (Throwable localThrowable)
      {
        label863:
        for (;;) {}
      }
    }
  }
  
  public void a(List<? extends apyw> paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apza
 * JD-Core Version:    0.7.0.1
 */