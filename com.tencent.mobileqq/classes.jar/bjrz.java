import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.view.PressDarkImageButton;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import org.json.JSONObject;

public class bjrz
  extends bjwu
  implements Handler.Callback, View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PressDarkImageButton jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton;
  private tcv jdField_a_of_type_Tcv;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public bjrz(@NonNull bjww parambjww, int paramInt, boolean paramBoolean)
  {
    super(parambjww);
    this.jdField_a_of_type_Int = paramInt;
    this.f = paramBoolean;
    this.jdField_a_of_type_Tcv = ((tcv)tdc.a(10));
  }
  
  private int a(int paramInt)
  {
    int i;
    switch (paramInt)
    {
    default: 
      i = ((Integer)this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_config_c2c", Integer.valueOf(0))).intValue();
    }
    for (;;)
    {
      veg.d("Q.qqstory.sync.EditAioSyncToStoryPart", "get " + paramInt + " type config=" + i);
      return i;
      i = ((Integer)this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_config_group", Integer.valueOf(0))).intValue();
      continue;
      i = ((Integer)this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_config_discuss", Integer.valueOf(0))).intValue();
    }
  }
  
  private static int a(JSONObject paramJSONObject, int paramInt)
  {
    int i;
    if (paramJSONObject == null) {
      i = 0;
    }
    int j;
    do
    {
      return i;
      i = paramInt & 0x3;
      int k = paramJSONObject.optInt("initOpen");
      j = paramJSONObject.optInt("reset");
      int n = paramJSONObject.optInt("sync_pic");
      int m = paramJSONObject.optInt("sync_video");
      paramInt = i;
      if (n == 1) {
        paramInt = i + 32;
      }
      i = paramInt;
      if (m == 1) {
        i = paramInt + 16;
      }
      paramInt = i;
      if (k == 1) {
        paramInt = i + 8;
      }
      i = paramInt;
    } while (j != 1);
    return paramInt + 4;
  }
  
  private void a(int paramInt)
  {
    boolean bool2 = true;
    int i = a(paramInt);
    if ((i & 0x20) > 0)
    {
      bool1 = true;
      this.c = bool1;
      if ((i & 0x10) <= 0) {
        break label97;
      }
      bool1 = true;
      label32:
      this.d = bool1;
      if ((i & 0x8) <= 0) {
        break label102;
      }
      bool1 = true;
      label46:
      this.jdField_a_of_type_Boolean = bool1;
      if ((i & 0x4) <= 0) {
        break label107;
      }
      bool1 = true;
      label59:
      this.b = bool1;
      if ((i & 0x1) <= 0) {
        break label112;
      }
    }
    label97:
    label102:
    label107:
    label112:
    for (paramInt = 1;; paramInt = 0)
    {
      if ((!this.b) && (paramInt != 0)) {
        break label117;
      }
      this.e = this.jdField_a_of_type_Boolean;
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label32;
      bool1 = false;
      break label46;
      bool1 = false;
      break label59;
    }
    label117:
    if ((i & 0x2) > 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.e = bool1;
      return;
    }
  }
  
  public static void a(@NonNull String paramString)
  {
    veg.d("Q.qqstory.sync.EditAioSyncToStoryPart", "parseConfig=" + paramString);
    tcv localtcv = (tcv)tdc.a(10);
    int j = ((Integer)localtcv.b("integer_aio_sync_to_story_config_c2c", Integer.valueOf(0))).intValue();
    int k = ((Integer)localtcv.b("integer_aio_sync_to_story_config_group", Integer.valueOf(0))).intValue();
    int i = ((Integer)localtcv.b("integer_aio_sync_to_story_config_discuss", Integer.valueOf(0))).intValue();
    paramString = new JSONObject(paramString);
    j = a(paramString.optJSONObject("other"), j);
    k = a(paramString.optJSONObject("group"), k);
    i = a(paramString.optJSONObject("discuss"), i);
    veg.a("Q.qqstory.sync.EditAioSyncToStoryPart", "handledAIOSyncToStory parse data: c2c=%d,group=%d,discuss=%d", Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i));
    localtcv.b("integer_aio_sync_to_story_config_c2c", Integer.valueOf(j));
    localtcv.b("integer_aio_sync_to_story_config_group", Integer.valueOf(k));
    localtcv.b("integer_aio_sync_to_story_config_discuss", Integer.valueOf(i));
  }
  
  public static void b()
  {
    veg.d("Q.qqstory.sync.EditAioSyncToStoryPart", "---clearConfig----");
    tcv localtcv = (tcv)tdc.a(10);
    localtcv.b("integer_aio_sync_to_story_config_c2c", Integer.valueOf(0));
    localtcv.b("integer_aio_sync_to_story_config_group", Integer.valueOf(0));
    localtcv.b("integer_aio_sync_to_story_config_discuss", Integer.valueOf(0));
  }
  
  private boolean b()
  {
    if ((this.f) && (this.d)) {}
    while ((!this.f) && (this.c)) {
      return true;
    }
    return false;
  }
  
  private void d()
  {
    if (((Integer)this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_switcher_guide", Integer.valueOf(0))).intValue() == 0)
    {
      this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_switcher_guide", Integer.valueOf(1));
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 5000L);
      String str1;
      if (this.jdField_a_of_type_Int == 1)
      {
        str1 = "3";
        if (!this.f) {
          break label141;
        }
      }
      label141:
      for (String str2 = "1";; str2 = "2")
      {
        vel.a("aio_shoot", "exp_tip", 0, 0, new String[] { str1, "", str2 });
        return;
        if (this.jdField_a_of_type_Int == 3000)
        {
          str1 = "2";
          break;
        }
        str1 = "1";
        break;
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a()
  {
    super.a();
    a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton = ((PressDarkImageButton)a(2131377584));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131376770));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131376771));
    if (!b())
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(8);
      this.e = false;
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setOnClickListener(this);
    String str1;
    if (this.e)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(true);
      if (this.jdField_a_of_type_Int != 1) {
        break label182;
      }
      str1 = "3";
      label130:
      if (!this.f) {
        break label204;
      }
    }
    label182:
    label204:
    for (String str2 = "1";; str2 = "2")
    {
      vel.a("aio_shoot", "exp_sync", 0, 0, new String[] { str1, "", str2 });
      d();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton.setChecked(false);
      break;
      if (this.jdField_a_of_type_Int == 3000)
      {
        str1 = "2";
        break label130;
      }
      str1 = "1";
      break label130;
    }
  }
  
  public void a(int paramInt, @NonNull bkkm parambkkm)
  {
    super.a(paramInt, parambkkm);
    parambkkm.d = this.e;
    String str1;
    if (this.jdField_a_of_type_Int == 1)
    {
      parambkkm = "3";
      if (!this.e) {
        break label95;
      }
      str1 = "2";
      label35:
      if (!this.f) {
        break label101;
      }
    }
    label95:
    label101:
    for (String str2 = "1";; str2 = "2")
    {
      vel.a("aio_shoot", "clk_send", 0, 0, new String[] { parambkkm, str1, str2 });
      return;
      if (this.jdField_a_of_type_Int == 3000)
      {
        parambkkm = "2";
        break;
      }
      parambkkm = "1";
      break;
      str1 = "1";
      break label35;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 0;
    if (this.c) {
      j = 32;
    }
    int i = j;
    if (this.d) {
      i = j + 16;
    }
    j = i;
    if (this.jdField_a_of_type_Boolean) {
      j = i + 8;
    }
    i = j;
    if (this.b) {
      i = j + 4;
    }
    j = i;
    if (paramBoolean) {
      j = i + 2;
    }
    i = j + 1;
    veg.a("Q.qqstory.sync.EditAioSyncToStoryPart", "save config = %s", Integer.valueOf(i));
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_config_c2c", Integer.valueOf(i));
      return;
    case 1: 
      this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_config_group", Integer.valueOf(i));
      return;
    }
    this.jdField_a_of_type_Tcv.b("integer_aio_sync_to_story_config_discuss", Integer.valueOf(i));
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    if (paramView == this.jdField_a_of_type_ComTencentBizQqstoryViewPressDarkImageButton)
    {
      bjke.a(paramView, 200L, new bjsa(this));
      a(this.e);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      i = j;
      if (this.jdField_a_of_type_Bjww.a.jdField_a_of_type_Int != 2)
      {
        i = j;
        if (this.jdField_a_of_type_Bjww.a.jdField_a_of_type_Int != 5) {
          if (this.jdField_a_of_type_Bjww.a.jdField_a_of_type_Int != 6) {
            break label159;
          }
        }
      }
    }
    label159:
    for (int i = j;; i = 0)
    {
      vel.a("video_edit_aio", "hyws_clk", 0, i, new String[0]);
      do
      {
        return;
      } while (paramView != this.jdField_a_of_type_AndroidWidgetTextView);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjrz
 * JD-Core Version:    0.7.0.1
 */