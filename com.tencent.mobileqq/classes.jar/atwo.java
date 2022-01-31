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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class atwo
  extends atwn
{
  public atwo(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
  }
  
  public int a(atuy paramatuy)
  {
    return 1;
  }
  
  public View a(ViewGroup paramViewGroup, atuy paramatuy)
  {
    paramatuy = (atwp)paramatuy;
    paramViewGroup = LayoutInflater.from(this.a).inflate(2131560896, paramViewGroup, false);
    paramatuy.g = ((TextView)paramViewGroup.findViewById(2131378370));
    paramatuy.e = ((ImageView)paramViewGroup.findViewById(2131368544));
    paramatuy.f = ((ImageView)paramViewGroup.findViewById(2131368640));
    return paramViewGroup;
  }
  
  public atuy a()
  {
    return new atwp(this);
  }
  
  public String a(atuy paramatuy)
  {
    long l = ((atwy)((atwp)paramatuy).a).jdField_b_of_type_Long;
    if (l % 1000L > 500L) {}
    for (l = (int)l / 1000 + 1;; l = (int)l / 1000) {
      return String.valueOf(l);
    }
  }
  
  public void d(atuy paramatuy)
  {
    atwy localatwy = (atwy)paramatuy.a;
    if ((localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry != null) && (localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.publishState != 0))
    {
      atwj.a(this.a, localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry, 2);
      return;
    }
    super.d(paramatuy);
  }
  
  public void f(atuy paramatuy)
  {
    atwp localatwp = (atwp)paramatuy;
    atwy localatwy = (atwy)localatwp.a;
    paramatuy = bbkd.a(this.a, localatwp.a.a, localatwy.n);
    int j;
    String str;
    File localFile;
    boolean bool;
    if (TextUtils.isEmpty(paramatuy))
    {
      localatwp.g.setVisibility(8);
      j = vzo.a(this.a, 180.0F);
      str = (String)localatwp.e.getTag(2131376880);
      if (localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry == null) {
        break label544;
      }
      localFile = new File(localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath + "");
      bool = localFile.exists();
    }
    for (;;)
    {
      Object localObject;
      int i;
      if (bool)
      {
        localObject = localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.thumbPath;
        paramatuy = (atuy)localObject;
        if (localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth <= 0) {
          break label539;
        }
        paramatuy = (atuy)localObject;
        if (localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight <= 0) {
          break label539;
        }
        i = localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoHeight * j / localatwy.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.videoWidth;
        paramatuy = (atuy)localObject;
      }
      for (;;)
      {
        label195:
        if (i * 3 > j * 4) {
          i = j * 4 / 3;
        }
        for (;;)
        {
          if (!TextUtils.equals(str, paramatuy))
          {
            localatwp.e.setTag(2131376880, paramatuy);
            localObject = (FrameLayout.LayoutParams)localatwp.e.getLayoutParams();
            if (localObject != null) {
              break label444;
            }
            localObject = new FrameLayout.LayoutParams(j, i);
            localatwp.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
          for (;;)
          {
            try
            {
              localObject = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.a.getResources().getDrawable(2130844648);
              ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.a.getResources().getDrawable(2130844648);
              if (!bool) {
                continue;
              }
              paramatuy = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject);
              paramatuy.setTag(bavi.b(j, i, bawz.a(this.a, 3.0F)));
              paramatuy.setDecodeHandler(bavi.e);
              localatwp.e.setImageDrawable(paramatuy);
              return;
            }
            catch (Exception paramatuy)
            {
              label444:
              localatwp.e.setImageDrawable(this.a.getResources().getDrawable(2130844648));
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("ShortVideoMomentItemBuilder", 1, paramatuy.toString());
              return;
            }
            localatwp.g.setVisibility(0);
            if ((paramatuy instanceof SpannableString)) {
              localatwp.g.setMovementMethod(LinkMovementMethod.getInstance());
            }
            localatwp.g.setText(paramatuy);
            break;
            localObject = localatwy.jdField_a_of_type_JavaLangString;
            paramatuy = (atuy)localObject;
            if (localatwy.jdField_a_of_type_Int <= 0) {
              break label539;
            }
            paramatuy = (atuy)localObject;
            if (localatwy.jdField_b_of_type_Int <= 0) {
              break label539;
            }
            i = localatwy.jdField_b_of_type_Int * j / localatwy.jdField_a_of_type_Int;
            paramatuy = (atuy)localObject;
            break label195;
            if ((((FrameLayout.LayoutParams)localObject).width != j) || (((FrameLayout.LayoutParams)localObject).height != i))
            {
              ((FrameLayout.LayoutParams)localObject).width = j;
              ((FrameLayout.LayoutParams)localObject).height = i;
              localatwp.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
              continue;
              paramatuy = URLDrawable.getDrawable(paramatuy, (URLDrawable.URLDrawableOptions)localObject);
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
 * Qualified Name:     atwo
 * JD-Core Version:    0.7.0.1
 */