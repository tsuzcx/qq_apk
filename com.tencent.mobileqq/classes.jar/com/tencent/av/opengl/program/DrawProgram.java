package com.tencent.av.opengl.program;

import lqx;
import lqy;
import lqz;

public class DrawProgram
  extends TextureProgram
{
  public DrawProgram()
  {
    super("uniform mat4 uMatrix;attribute vec2 aPosition;void main() {vec4 pos = vec4 (aPosition, 0.0, 1.0);gl_Position  = uMatrix * pos;}", "precision mediump float;uniform vec4 uColor;void main() {gl_FragColor = uColor;}", new lqy[] { new lqx("aPosition"), new lqz("uMatrix"), new lqz("uColor") }, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.opengl.program.DrawProgram
 * JD-Core Version:    0.7.0.1
 */