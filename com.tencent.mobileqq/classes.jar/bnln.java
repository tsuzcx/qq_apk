import android.app.Activity;
import android.app.Dialog;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.data.AEGifCategoryWrapper;
import dov.com.qq.im.ae.gif.AEGIFStickerListPart.9;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.LinkedList;
import java.util.List;

public class bnln
  extends bnqb
  implements ajkh
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private Pair<String[], int[]> jdField_a_of_type_AndroidUtilPair;
  private bmxa jdField_a_of_type_Bmxa;
  private bnmb jdField_a_of_type_Bnmb;
  private bnne jdField_a_of_type_Bnne;
  private bnpz jdField_a_of_type_Bnpz;
  private bnqa jdField_a_of_type_Bnqa;
  private SimpleSlidingIndicator jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator;
  private String jdField_a_of_type_JavaLangString;
  private List<AEGifCategoryWrapper> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private List<bnkg> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public bnln(Activity paramActivity, View paramView, bnqc parambnqc)
  {
    super(paramActivity, paramView, parambnqc);
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_Bmxa = ((bmxa)parambnqc.a(65537, new Object[0]));
  }
  
  @Nullable
  private Pair<Integer, Integer> a(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (paramList.size() == 0) {
      return null;
    }
    Object localObject = (AEGifCategoryWrapper)paramList.get(0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject).materialWrapperList)) {
      return null;
    }
    if ((((AEGifCategoryWrapper)localObject).materialWrapperList.get(0) != null) && (((bnkg)((AEGifCategoryWrapper)localObject).materialWrapperList.get(0)).b != 1))
    {
      bnkg localbnkg = new bnkg();
      localbnkg.b = 1;
      localbnkg.jdField_a_of_type_JavaLangString = "none";
      ((AEGifCategoryWrapper)localObject).materialWrapperList.add(0, localbnkg);
    }
    localObject = b(paramList);
    if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null)) {}
    for (((AEGifCategoryWrapper)paramList.get(((Integer)((Pair)localObject).first).intValue())).selected = true;; ((AEGifCategoryWrapper)paramList.get(0)).selected = true) {
      return localObject;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class));
    this.jdField_a_of_type_Bnpz.a.observe(this.jdField_a_of_type_Bmxa, new bnlq(this));
    this.jdField_a_of_type_Bnpz.c.observe(this.jdField_a_of_type_Bmxa, new bnlr(this));
    this.jdField_a_of_type_Bnqa = ((bnqa)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnqa.class));
    this.jdField_a_of_type_Bnqa.a().observe(this.jdField_a_of_type_Bmxa, new bnls(this));
    this.jdField_a_of_type_Bnmb = ((bnmb)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnmb.class));
    this.jdField_a_of_type_Bnmb.a().observe(this.jdField_a_of_type_Bmxa, new bnlt(this));
    bnjq.a().observe(this.jdField_a_of_type_Bmxa, new bnlu(this));
    bnjq.c().observe(this.jdField_a_of_type_Bmxa, new bnlv(this));
    if (!this.jdField_a_of_type_Boolean) {
      bnjw.a().a();
    }
  }
  
  private void a(@NonNull Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("KEY_CURRENT_SELECT_ID");
    paramIntent = paramIntent.getStringExtra("KEY_CURRENT_TAB");
    bnrh.a("AEGIFStickerListPart", "[initTakeSame], bottomTab=" + paramIntent + ", materialId=" + str);
    this.jdField_a_of_type_Boolean = a(paramIntent, str);
    if (this.jdField_a_of_type_Boolean)
    {
      this.c = str;
      c();
    }
  }
  
  private void a(@Nullable bnkg parambnkg)
  {
    this.jdField_a_of_type_Bnmb.c(parambnkg);
    if (parambnkg == null)
    {
      this.jdField_a_of_type_Bnmb.b(null);
      this.c = null;
      return;
    }
    this.c = parambnkg.jdField_a_of_type_JavaLangString;
    switch (parambnkg.jdField_a_of_type_Int)
    {
    case 1: 
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_Bnmb.a(parambnkg);
      return;
    }
    this.jdField_a_of_type_Bnmb.b(parambnkg);
  }
  
  private void a(@Nullable String paramString)
  {
    if (this.jdField_a_of_type_Bnmb != null) {
      this.jdField_a_of_type_Bnmb.d().postValue(paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (bnlh.a().a(paramString) != Typeface.DEFAULT)) {
      return;
    }
    ThreadManager.excute(new AEGIFStickerListPart.9(this, paramString), 64, null, false);
  }
  
  private boolean a()
  {
    if (this.jdField_a_of_type_Bnqa == null) {
      return false;
    }
    Boolean localBoolean = (Boolean)this.jdField_a_of_type_Bnqa.e().getValue();
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  private boolean a(@Nullable String paramString1, @Nullable String paramString2)
  {
    return (!TextUtils.isEmpty(paramString1)) && (AECaptureMode.GIF.name.equals(paramString1)) && (!TextUtils.isEmpty(paramString2));
  }
  
  @Nullable
  private Pair<Integer, Integer> b(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (TextUtils.isEmpty(this.c))
    {
      bnrh.b("AEGIFStickerListPart", "[findLastSelectedPosition] mPendingApplyGIFId is empty");
      return null;
    }
    int i;
    Object localObject1;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      i = 0;
      if (i < paramList.size())
      {
        localObject1 = (AEGifCategoryWrapper)paramList.get(i);
        if ((localObject1 == null) || (TextUtils.isEmpty(((AEGifCategoryWrapper)localObject1).categoryId))) {}
        while (!((AEGifCategoryWrapper)localObject1).categoryId.equals(this.jdField_a_of_type_JavaLangString))
        {
          i += 1;
          break;
        }
      }
    }
    for (;;)
    {
      int j;
      Object localObject2;
      if ((localObject1 != null) && (!CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)))
      {
        j = 0;
        if (j < ((AEGifCategoryWrapper)localObject1).materialWrapperList.size())
        {
          localObject2 = (bnkg)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(j);
          if ((localObject2 == null) || (TextUtils.isEmpty(((bnkg)localObject2).jdField_a_of_type_JavaLangString))) {}
          while (!((bnkg)localObject2).jdField_a_of_type_JavaLangString.equals(this.c))
          {
            j += 1;
            break;
          }
        }
      }
      for (localObject1 = localObject2;; localObject1 = null)
      {
        int k;
        int m;
        int i2;
        Object localObject3;
        int i1;
        if (localObject1 == null)
        {
          int n = 0;
          AEGifCategoryWrapper localAEGifCategoryWrapper;
          for (;;)
          {
            k = j;
            localObject2 = localObject1;
            m = i;
            if (n >= paramList.size()) {
              break label385;
            }
            localAEGifCategoryWrapper = (AEGifCategoryWrapper)paramList.get(n);
            i2 = j;
            localObject3 = localObject1;
            i1 = i;
            if (localAEGifCategoryWrapper == null) {
              break label455;
            }
            if (!CollectionUtils.isEmpty(localAEGifCategoryWrapper.materialWrapperList)) {
              break;
            }
            k = j;
            j = i;
            i = k;
            n += 1;
            k = j;
            j = i;
            i = k;
          }
          i1 = 0;
          k = j;
          localObject2 = localObject1;
          m = i;
          if (i1 < localAEGifCategoryWrapper.materialWrapperList.size())
          {
            localObject2 = (bnkg)localAEGifCategoryWrapper.materialWrapperList.get(i1);
            if ((localObject2 == null) || (TextUtils.isEmpty(((bnkg)localObject2).jdField_a_of_type_JavaLangString))) {}
            while (!((bnkg)localObject2).jdField_a_of_type_JavaLangString.equals(this.c))
            {
              i1 += 1;
              break;
            }
            k = i1;
            m = n;
          }
          i2 = k;
          localObject3 = localObject2;
          i1 = m;
          if (localObject2 == null) {}
        }
        for (;;)
        {
          label385:
          if (localObject2 != null)
          {
            bnrh.b("AEGIFStickerListPart", "[findLastSelectedPosition] found tabPosition=" + m + ", itemPosition=" + k);
            return new Pair(Integer.valueOf(m), Integer.valueOf(k));
          }
          bnrh.b("AEGIFStickerListPart", "[findLastSelectedPosition] not found");
          return null;
          label455:
          i = i2;
          localObject1 = localObject3;
          j = i1;
          break;
          k = j;
          localObject2 = localObject1;
          m = i;
        }
        j = -1;
      }
      i = -1;
      localObject1 = null;
    }
  }
  
  private void b()
  {
    aalp.a(new View[] { this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView }).b(new float[] { 0.0F, 1.0F }).a(300L).a(new bnlw(this)).b();
  }
  
  private Pair<String[], int[]> c(@NonNull List<AEGifCategoryWrapper> paramList)
  {
    if (CollectionUtils.isEmpty(paramList)) {
      return new Pair(new String[0], new int[0]);
    }
    String[] arrayOfString = new String[paramList.size()];
    int[] arrayOfInt = new int[paramList.size()];
    int i = 0;
    if (i < paramList.size())
    {
      localObject = (AEGifCategoryWrapper)paramList.get(i);
      if ((localObject == null) || (TextUtils.isEmpty(((AEGifCategoryWrapper)localObject).categoryName))) {
        break label114;
      }
    }
    label114:
    for (Object localObject = ((AEGifCategoryWrapper)localObject).categoryName;; localObject = "")
    {
      arrayOfString[i] = localObject;
      arrayOfInt[i] = i;
      i += 1;
      break;
      return new Pair(arrayOfString, arrayOfInt);
    }
  }
  
  private void c()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this.mActivity, 2131755829);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(true);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559607);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372740)).setText(2131694653);
        this.jdField_a_of_type_AndroidAppDialog.setOnCancelListener(new bnlp(this));
      }
      if (!this.jdField_a_of_type_AndroidAppDialog.isShowing())
      {
        bnrh.a("AEGIFStickerListPart", "[showTakeSameLoading], show dialog");
        this.jdField_a_of_type_AndroidAppDialog.show();
      }
    }
  }
  
  private void d()
  {
    if ((this.mActivity != null) && (!this.mActivity.isFinishing()) && (this.jdField_a_of_type_AndroidAppDialog != null) && (this.jdField_a_of_type_AndroidAppDialog.isShowing()))
    {
      bnrh.a("AEGIFStickerListPart", "[hideTakeSameLoading], dismiss dialog");
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = (AEGifCategoryWrapper)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) || (!this.jdField_b_of_type_JavaLangString.equals(((AEGifCategoryWrapper)localObject1).categoryId)))
    {
      this.jdField_b_of_type_JavaLangString = ((AEGifCategoryWrapper)localObject1).categoryId;
      bnqq.a().l(this.jdField_b_of_type_JavaLangString);
      bnqm.a().aj();
    }
    if (!paramBoolean) {
      return 0;
    }
    this.jdField_a_of_type_JavaLangString = ((AEGifCategoryWrapper)localObject1).categoryId;
    a(((AEGifCategoryWrapper)localObject1).fontId);
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.addAll(((AEGifCategoryWrapper)localObject1).materialWrapperList);
    this.jdField_a_of_type_Bnne.a();
    this.jdField_a_of_type_Bnne.notifyDataSetChanged();
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.scrollToPositionWithOffset(0, 0);
    if (CollectionUtils.isEmpty(((AEGifCategoryWrapper)localObject1).materialWrapperList)) {}
    for (localObject1 = null;; localObject1 = (bnkg)((AEGifCategoryWrapper)localObject1).materialWrapperList.get(0))
    {
      Object localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((bnkg)localObject1).b == 1) {
          localObject2 = null;
        }
      }
      a(localObject2);
      return 0;
    }
  }
  
  protected void initView()
  {
    if (this.mRootView == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_AndroidUtilPair = new Pair(new String[0], new int[0]);
    this.jdField_b_of_type_JavaUtilList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator = ((SimpleSlidingIndicator)this.mRootView.findViewById(2131362277));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setOnTabListener(this);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)this.mRootView.findViewById(2131362278));
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(this.jdField_a_of_type_AndroidContentContext, 0, false);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setItemAnimator(null);
    this.jdField_a_of_type_Bnne = new bnne(this.mRootView.getContext(), this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_Bnne.a(new bnlo(this));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Bnne);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsBaseTabsSimpleSlidingIndicator.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
    a(this.mActivity.getIntent());
    a();
  }
  
  public void onActivityResume()
  {
    super.onActivityResume();
    if ((this.jdField_a_of_type_Bnpz != null) && (this.jdField_a_of_type_Bnpz.a())) {
      bnqm.a().ag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnln
 * JD-Core Version:    0.7.0.1
 */