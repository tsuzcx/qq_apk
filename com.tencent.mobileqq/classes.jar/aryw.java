import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aryw
  extends arwe
{
  protected List<asaf> a;
  protected boolean a;
  protected List<asaf> b;
  protected boolean b;
  protected List<asaf> c = new ArrayList();
  
  public aryw(EmoticonPanelController paramEmoticonPanelController)
  {
    super(paramEmoticonPanelController);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  public int a()
  {
    arqk localarqk = (arqk)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(334);
    if (!localarqk.c()) {}
    for (int j = 4;; j = 5)
    {
      List localList = ((awmr)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(false, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.h);
      int i;
      if (localList != null)
      {
        i = j;
        if (localList.size() != 0) {}
      }
      else
      {
        i = j - 1;
      }
      Object localObject = a();
      j = i;
      String str;
      if (localObject != null)
      {
        j = i;
        if (((aqoo)localObject).jdField_b_of_type_JavaUtilList.size() > 0)
        {
          i = ((aqoo)localObject).jdField_b_of_type_JavaUtilList.size();
          localObject = ((aqoo)localObject).jdField_b_of_type_JavaUtilList.iterator();
          j = i;
          if (((Iterator)localObject).hasNext())
          {
            str = (String)((Iterator)localObject).next();
            if (("camera".equalsIgnoreCase(str)) && (!localarqk.c())) {
              i -= 1;
            }
          }
        }
      }
      for (;;)
      {
        break;
        if (("recommend".equalsIgnoreCase(str)) && ((localList == null) || (localList.size() == 0)))
        {
          i -= 1;
          continue;
          return c() + j;
        }
      }
    }
  }
  
  public int a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (c() == 0) || (paramInt >= c())) {}
    int i;
    int j;
    do
    {
      return paramInt;
      i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      j = i + c();
      i = b();
      paramInt = i;
    } while (j > i);
    return j;
  }
  
  protected aqoo a()
  {
    return aqon.a();
  }
  
  public List<asaf> a(List<asaf> paramList)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return paramList;
    }
    List localList = Collections.synchronizedList(new ArrayList());
    if ((paramList != null) && (!paramList.isEmpty())) {
      localList.addAll(paramList);
    }
    paramList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      asaf localasaf = (asaf)localIterator.next();
      if ((localasaf.a == 13) || (localasaf.a == 14)) {
        paramList.add(localasaf);
      }
    }
    if (!paramList.isEmpty()) {
      localList.removeAll(paramList);
    }
    if (!this.jdField_b_of_type_JavaUtilList.isEmpty()) {
      localList.addAll(0, this.jdField_b_of_type_JavaUtilList);
    }
    if (!this.c.isEmpty()) {
      localList.addAll(this.c);
    }
    this.jdField_a_of_type_JavaUtilList = localList;
    b();
    return localList;
  }
  
  protected void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager != null)) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setNoScrollItem(c(), b());
    }
  }
  
  public void a(int paramInt)
  {
    b(paramInt);
  }
  
  protected void a(aqoo paramaqoo)
  {
    this.c.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    if ((paramaqoo != null) && (!paramaqoo.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      int i = 0;
      int j = 0;
      if (i < paramaqoo.jdField_a_of_type_JavaUtilList.size())
      {
        String str = (String)paramaqoo.jdField_a_of_type_JavaUtilList.get(i);
        int k;
        if ("face".equalsIgnoreCase(str)) {
          k = 1;
        }
        for (;;)
        {
          i += 1;
          j = k;
          break;
          if ("add".equalsIgnoreCase(str))
          {
            if (j != 0)
            {
              k = j;
              if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k)
              {
                k = j;
                if (a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c))
                {
                  this.c.add(new asaf(13, 0, null));
                  k = j;
                }
              }
            }
            else
            {
              k = j;
              if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.k)
              {
                k = j;
                if (a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.c))
                {
                  this.jdField_b_of_type_JavaUtilList.add(new asaf(13, 0, null));
                  k = j;
                }
              }
            }
          }
          else
          {
            k = j;
            if ("setting".equalsIgnoreCase(str))
            {
              k = j;
              if (!this.jdField_b_of_type_Boolean) {
                if (j != 0)
                {
                  this.c.add(new asaf(14, 0, null));
                  k = j;
                }
                else
                {
                  this.jdField_b_of_type_JavaUtilList.add(new asaf(14, 0, null));
                  k = j;
                }
              }
            }
          }
        }
      }
    }
    else
    {
      this.jdField_b_of_type_JavaUtilList.add(new asaf(13, 0, null));
      this.jdField_b_of_type_JavaUtilList.add(new asaf(14, 0, null));
    }
  }
  
  protected boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a != null);
  }
  
  protected boolean a(int paramInt)
  {
    return arze.c(paramInt);
  }
  
  public int[] a()
  {
    return new int[] { 1, 3, 8 };
  }
  
  protected int b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return c();
    }
    return this.jdField_a_of_type_JavaUtilList.size() - d() - 1;
  }
  
  public void b()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    label122:
    for (;;)
    {
      return;
      int i;
      if ((EmoticonPanelController.b >= 0) && (EmoticonPanelController.b < c()))
      {
        EmoticonPanelController.b += c();
        i = 0;
      }
      for (;;)
      {
        if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
          break label122;
        }
        if (((asaf)this.jdField_a_of_type_JavaUtilList.get(i)).a == 8)
        {
          EmoticonPanelController.d = i;
          return;
          if ((d() <= 0) || (b() < 0) || (EmoticonPanelController.b <= b())) {
            break;
          }
          EmoticonPanelController.b = b();
          break;
        }
        i += 1;
      }
    }
  }
  
  protected void b(int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setRightScrollDisEnable(false);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setLeftScrollDisEnable(false);
      return;
    }
    if ((paramInt != 0) && (paramInt <= c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setRightScrollDisEnable(true);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setLeftScrollDisEnable(false);
    }
    for (;;)
    {
      a();
      return;
      if (paramInt >= b())
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setRightScrollDisEnable(false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setLeftScrollDisEnable(true);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setRightScrollDisEnable(false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPager.setLeftScrollDisEnable(false);
      }
    }
  }
  
  public boolean b(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return false;
    }
    asaf localasaf = (asaf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    return ((aryu)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(6)).a(localasaf.a);
  }
  
  public int c()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_JavaUtilList == null)) {
      return 0;
    }
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public int d()
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.c == null)) {
      return 0;
    }
    return this.c.size();
  }
  
  public void d()
  {
    boolean bool2 = false;
    aqoo localaqoo = a();
    if (localaqoo != null) {
      if ((!localaqoo.a()) || (!a()) || (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.l)) {
        break label50;
      }
    }
    label50:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_a_of_type_Boolean = bool1;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.jdField_a_of_type_Arxz.j) && (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.g != 3))
    {
      bool1 = bool2;
      if (!this.jdField_b_of_type_Boolean) {}
    }
    else
    {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
    aryu localaryu = (aryu)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelController.a(6);
    localaryu.b(8);
    localaryu.c(8);
    localaryu.a(true, true);
    a(localaqoo);
    b();
  }
  
  public void i()
  {
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_b_of_type_JavaUtilList.clear();
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aryw
 * JD-Core Version:    0.7.0.1
 */