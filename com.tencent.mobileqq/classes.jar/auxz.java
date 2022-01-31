import QC.UniBusiGetOneItemWithCheckReq;
import QC.UniBusiGetOneItemWithCheckRsp;
import QC.UniBusiSimpleFontItem;
import QC.UniBusiSimpleItemDetail;
import QC.UniBusiSimpleSigItem;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class auxz
  extends RecyclerView.Adapter<auyh>
{
  private int jdField_a_of_type_Int;
  private UniBusiSimpleItemDetail jdField_a_of_type_QCUniBusiSimpleItemDetail;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private auxy jdField_a_of_type_Auxy;
  public auyg a;
  private URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new auyf(this);
  private ArrayList<UniBusiSimpleItemDetail> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  private final int c = 0;
  private final int d = 1;
  
  public auxz(Context paramContext, ArrayList<UniBusiSimpleItemDetail> paramArrayList)
  {
    this.jdField_a_of_type_Auyg = new auyb(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130846234);
  }
  
  private Drawable a(String paramString1, String paramString2)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    Object localObject = localDrawable;
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      paramString1 = new URL("sig_cover", paramString2, paramString1);
      localObject = localDrawable;
      if (paramString1 != null)
      {
        paramString2 = URLDrawable.URLDrawableOptions.obtain();
        localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        paramString2.mFailedDrawable = ((Drawable)localObject);
        paramString2.mLoadingDrawable = ((Drawable)localObject);
        paramString2.mPlayGifImage = true;
        localObject = URLDrawable.getDrawable(paramString1, paramString2);
        ((URLDrawable)localObject).addHeader("my_uin", BaseApplicationImpl.getApplication().getRuntime().getAccount());
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        ((URLDrawable)localObject).setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
      }
      return localObject;
    }
    catch (MalformedURLException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickyNoteVasAdapter", 2, paramString1.getMessage());
        }
        paramString1 = null;
      }
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str3 = ajyc.a(2131704672);
    String str2 = ajyc.a(2131720226);
    String str1 = str2;
    if (!TextUtils.isEmpty(paramString2))
    {
      str1 = str2;
      if (paramString2.contains("svip")) {
        str1 = ajyc.a(2131720224);
      }
    }
    bbcv.a(paramContext, 230, str3, paramString3, ajyc.a(2131704673), str1, new auyc(this, paramContext, paramString1, paramString2, paramString4), new auyd(this)).show();
  }
  
  public static boolean a(int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    switch (paramInt)
    {
    default: 
      return false;
    case 0: 
    case 1: 
      return true;
    case 4: 
      return VipUtils.c(localQQAppInterface);
    case 5: 
      return VipUtils.b(localQQAppInterface);
    }
    return false;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130846551;
    case 0: 
    case 1: 
      return 2130846550;
    case 4: 
      return 2130846555;
    case 5: 
      return 2130846554;
    case 21: 
      return 2130846553;
    }
    return 2130846552;
  }
  
  public Drawable a(Context paramContext, Drawable paramDrawable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return paramDrawable;
    }
    return new LayerDrawable(new Drawable[] { paramDrawable, paramContext.getResources().getDrawable(2130849197) });
  }
  
  public Drawable a(Context paramContext, String paramString, boolean paramBoolean)
  {
    int i = 14606046;
    if (!TextUtils.isEmpty(paramString))
    {
      String str = paramString;
      if (!paramString.contains("#")) {
        str = "#" + paramString;
      }
      i = Color.parseColor(str);
    }
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i + 1291845632, i + -2147483648 });
    if (!paramBoolean) {
      return paramString;
    }
    return new LayerDrawable(new Drawable[] { paramString, paramContext.getResources().getDrawable(2130849197) });
  }
  
  public auyh a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = new auyh(this, View.inflate(paramViewGroup.getContext(), 2131561026, null));
    if (paramInt == 1)
    {
      paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return paramViewGroup;
    }
    paramViewGroup.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    return paramViewGroup;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_QCUniBusiSimpleItemDetail != null) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Int, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, this.jdField_a_of_type_QCUniBusiSimpleItemDetail.feeType, this.jdField_a_of_type_Auyg);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, auyg paramauyg)
  {
    if ((a(paramInt3)) && (paramauyg != null))
    {
      paramauyg.a(true, null);
      return;
    }
    new bbwn("QC.UniBusinessUserInfoServer.UniBusinessUserInfoObj", "QcUniBusinessUserInfo.UniBusiGetOneItemWithCheck", "stReq", "stRsp").a("UniBusiGetOneItemWithCheck", new UniBusiGetOneItemWithCheckReq(bbwn.a(), paramInt1, paramInt2), new UniBusiGetOneItemWithCheckRsp(), new auye(this, paramauyg), false);
  }
  
  public void a(TextView paramTextView, int paramInt)
  {
    paramTextView.setCompoundDrawablePadding(bbkx.b(4.0F));
    paramTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, a(paramInt), 0);
  }
  
  public void a(auxy paramauxy)
  {
    this.jdField_a_of_type_Auxy = paramauxy;
  }
  
  public void a(auyh paramauyh, int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)) {
      return;
    }
    UniBusiSimpleItemDetail localUniBusiSimpleItemDetail = (UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramauyh.jdField_a_of_type_AndroidWidgetTextView.setText(localUniBusiSimpleItemDetail.name);
    boolean bool;
    if (this.b == localUniBusiSimpleItemDetail.itemId)
    {
      bool = true;
      QLog.d("StickyNoteVasAdapter", 1, " mAppId:" + this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Int != 9) {
        break label236;
      }
      paramauyh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(a(paramauyh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.getContext(), localUniBusiSimpleItemDetail.itemBgColor, bool));
      paramInt = (axli.e(paramauyh.itemView.getContext()) - axli.a(96.0F)) / 3;
      ViewGroup.LayoutParams localLayoutParams = paramauyh.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.width = paramInt;
      localLayoutParams.height = ((int)(paramInt * 0.57F));
      paramauyh.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      paramauyh.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(a(String.valueOf(localUniBusiSimpleItemDetail.itemId), localUniBusiSimpleItemDetail.image));
    }
    for (;;)
    {
      a(paramauyh.jdField_a_of_type_AndroidWidgetTextView, localUniBusiSimpleItemDetail.feeType);
      paramauyh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setOnClickListener(new auya(this, localUniBusiSimpleItemDetail));
      return;
      bool = false;
      break;
      label236:
      paramauyh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.setBackgroundDrawable(a(paramauyh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetRoundRelativeLayout.getContext(), a(String.valueOf(localUniBusiSimpleItemDetail.itemId), localUniBusiSimpleItemDetail.image), bool));
    }
  }
  
  public void a(ArrayList<UniBusiSimpleItemDetail> paramArrayList, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_JavaUtilArrayList != null)) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    }
  }
  
  public void b()
  {
    notifyDataSetChanged();
    if (this.jdField_a_of_type_Auxy != null)
    {
      if (this.jdField_a_of_type_Int != 5) {
        break label60;
      }
      i = 0;
      if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem != null) {
        i = this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stFontItem.fontType;
      }
      this.jdField_a_of_type_Auxy.b(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
    }
    label60:
    while (this.jdField_a_of_type_Int != 9) {
      return;
    }
    int j = 16777215;
    int i = j;
    if (this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem != null)
    {
      i = j;
      if (!TextUtils.isEmpty(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor)) {
        i = Color.parseColor(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.stSigItem.fontColor);
      }
    }
    this.jdField_a_of_type_Auxy.a(this.jdField_a_of_type_QCUniBusiSimpleItemDetail.itemId, i);
  }
  
  public void b(int paramInt)
  {
    this.b = -1;
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i)).itemId == paramInt)
        {
          this.b = paramInt;
          this.jdField_a_of_type_QCUniBusiSimpleItemDetail = ((UniBusiSimpleItemDetail)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          notifyDataSetChanged();
          return;
        }
        i += 1;
      }
    }
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if (paramInt == getItemCount() - 1) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxz
 * JD-Core Version:    0.7.0.1
 */