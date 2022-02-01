package com.tencent.ilive.opensdk.bridgeinterface;

import com.tencent.ilive.opensdk.coreinterface.IMusicDecoderFactory;

public class SimpleMusicDecoder$CreateMusicDecoder
  implements IMusicDecoderFactory
{
  public Object create()
  {
    return new SimpleMusicDecoder();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.bridgeinterface.SimpleMusicDecoder.CreateMusicDecoder
 * JD-Core Version:    0.7.0.1
 */