import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axfl
  extends axfk
{
  public axfl(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(axdv paramaxdv)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, axdv paramaxdv)
  {
    paramaxdv = (axfm)paramaxdv;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131561220, paramViewGroup, false);
    paramaxdv.g = ((TextView)paramViewGroup.findViewById(2131379865));
    paramaxdv.e = ((ImageView)paramViewGroup.findViewById(2131369207));
    paramaxdv.f = ((ImageView)paramViewGroup.findViewById(2131369324));
    return paramViewGroup;
  }
  
  public axdv a()
  {
    return new axfm(this);
  }
  
  public String a(axdv paramaxdv)
  {
    long l = ((axfv)((axfm)paramaxdv).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(axdv paramaxdv)
  {
    axfv localaxfv = (axfv)paramaxdv.a;
    if ((localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      axfg.a(this.a, localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramaxdv);
  }
  
  public void f(axdv paramaxdv)
  {
    axfm localaxfm = (axfm)paramaxdv;
    axfv localaxfv = (axfv)localaxfm.a;
    paramaxdv = bfzn.a(this.a, localaxfm.a.a, localaxfv.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramaxdv))
    {
      localaxfm.g.setVisibility(8);
      j = UIUtils.dip2px(this.a, 180.0F);
      str = (String)localaxfm.e.getTag(2131378207);
      if (localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramaxdv = (axdv)localObject;
        if (localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramaxdv = (axdv)localObject;
        if (localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localaxfv.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramaxdv = (axdv)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramaxdv))
          {
            localaxfm.e.setTag(2131378207, paramaxdv);
            localObject = (FrameLayout.LayoutParams)localaxfm.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localaxfm.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130845375);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130845375);
              if (!bool) {
                continue;
              }
              paramaxdv = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramaxdv.setTag(bfol.b(j, i, DisplayUtil.dip2px(this.a, 3.0F)));
              paramaxdv.setDecodeHandler(bfol.e);
              localaxfm.e.setImageDrawable(paramaxdv);
              return;
            }
            catch (Exception paramaxdv)
            {
              label444:
              localaxfm.e.setImageDrawable(this.a.getResources().getDrawable(2130845375));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramaxdv.toString());
              return;
            }
            localaxfm.g.setVisibility(0);
            if ((paramaxdv instanceof SpannableString)) {
              localaxfm.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localaxfm.g.setText(paramaxdv);
            break;
            localObject = localaxfv.jdField_a_of_type_JavaLangString;
            paramaxdv = (axdv)localObject;
            if (localaxfv.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramaxdv = (axdv)localObject;
            if (localaxfv.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localaxfv.jdField_b_of_type_Int * j / localaxfv.jdField_a_of_type_Int;
            paramaxdv = (axdv)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localaxfm.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramaxdv = URLDrawable.getDrawable(paramaxdv, (URLDrawable.URLDrawableOptions)localObject);
            }
          }
        }
        label539:
        i = j;
      }
      label544:
      bool = false;
      localFile = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfl
 * JD-Core Version:    0.7.0.1
 */